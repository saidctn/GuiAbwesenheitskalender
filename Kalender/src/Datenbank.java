import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

public class Datenbank{
    // Verbindungsattribute
    private final String url = "jdbc:postgresql://localhost/GuiJava";
    private final String user = "postgres";
    private String password;

    /**
     * Konstruktor
     * @param
     */
    public Datenbank() {
        createTableMitglied();
        createTableKompetenz();
        createTableMK();
    }

    /**
     * Fügt in die Datenbank hinzu
     * @param m
     */
    public void addToDatabase(Mitglied m){
        int mitgliedID = addMitglied(m.getVorname(),m.getNachname(),m.getLieblingsfarbe());
        m.setID(mitgliedID);

        int kompetenzID;
        ArrayList<Kompetenz> liste =m.getKompetenzliste();
        Iterator<Kompetenz> it = liste.iterator();
        while (it.hasNext()){
            Kompetenz k = it.next();
            kompetenzID = addKompetenz(k.getKompetenzname());
            k.setID(kompetenzID);
            addMK(mitgliedID,kompetenzID);
        }
    }

    /*public void addToDatabase(String vorname, String nachname, String lieblingsfarbe, String Kompetenz) {
        int mitgliedID = addMitglied(vorname, nachname, lieblingsfarbe);
        int kompetenzID = addKompetenz(Kompetenz);
        addMK(mitgliedID, kompetenzID);
    }*/

    /**
     * löscht von der Datenbank
     * @param m
     */
    public void delFromDatabase(Mitglied m) {
        int kompetenzID = 0;
        deleteMitglied(m);
        ArrayList<Kompetenz> liste = m.getKompetenzliste();
        Iterator it = liste.iterator();
        while(it.hasNext()){
            Kompetenz k = (Kompetenz) it.next();
            kompetenzID = k.getID();
            deleteKompetenz(kompetenzID);
        }
        deleteMK(m.getID(), kompetenzID);
        System.out.println("Komplett geloscht");
    }

    /**
     * Fügt einen Mitglied ein intern benutzung
     * @param vorname
     * @param nachname
     * @param lieblingsfarbe
     * @return
     */
    private int addMitglied(String vorname, String nachname, String lieblingsfarbe) {
        String insertDataSQL = "INSERT INTO Mitglieder (vorname, nachname, lieblingsfarbe) VALUES (?, ?, ?) RETURNING id_mitglied";
        int mitgliedID = 0;

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {

            preparedStatement.setString(1, vorname);
            preparedStatement.setString(2, nachname);
            preparedStatement.setString(3, lieblingsfarbe);
            //preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                mitgliedID = resultSet.getInt(1);
                System.out.println("Mitglied hinzugefügt mit ID: " + mitgliedID);
            } else {
                System.out.println("Fehler beim Abrufen der generierten ID.");
            }

            System.out.println("Mitglied hinzugefuegt.");

        } catch (SQLException e) {
            System.out.println("Konnte nicht hinzugefuegt werden -> Mitglied: " + e.getMessage());
        }
        return mitgliedID;
    }

    /**
     * Fügt eine Kompetenz hinzu intern benutzung
     * @param Kompetenzname
     * @return
     */
    private int addKompetenz(String Kompetenzname) {

        int id_abfrage = -1;
        String abfrage = "SELECT id_kompetenz FROM kompetenz WHERE name = ? ";
        try (Connection con = connect();
             PreparedStatement preparedStatement = con.prepareStatement(abfrage)) {
            preparedStatement.setString(1, Kompetenzname);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                id_abfrage = result.getInt("id_kompetenz");
            }
            if (id_abfrage != -1) {
                System.out.println("Kompetenz wurde schonmal hinzugefuegt   Kompetenz ID : " + id_abfrage);
                return id_abfrage;
            }
        } catch (SQLException e) {
            System.out.println("Abrufen Kompetenz nicht moeglich");
        }


        int kompetenzID = 0;
        String insert = "INSERT INTO Kompetenz (name) VALUES (?) RETURNING id_kompetenz";
        String insert2 = "INSERT INTO mk (id_mitglied, id_kompetenz) VALUES (?,?)";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, Kompetenzname);
            //preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                kompetenzID = resultSet.getInt(1);
                System.out.println("\n\n\nKompetenz ID ist = " + kompetenzID);
            } else {
                System.out.println("Fehler beim Abrufen von der Kompetenz ID");
            }

            System.out.println("Kompetenz Hinzugefuegt");
        } catch (SQLException e) {
            System.out.println("Konnte nicht hinzugefuegt werden -> Kompetenz: " + e.getMessage());
        }
        return kompetenzID;
    }

    /**
     * Fügt in die Schnittstellentabelle hinzu
     * @param mitgliedID
     * @param komptenzID
     */
    private void addMK(int mitgliedID, int komptenzID) {
        String select = "SELECT COUNT(*) FROM mk WHERE id_mitglied = ? AND id_kompetenz = ?";
        String insert = "INSERT INTO MK (id_mitglied, id_kompetenz) VALUES (?,?)";
        try (Connection connection = connect();
             PreparedStatement prep = connect().prepareStatement(select);
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {

            prep.setInt(1,mitgliedID);
            prep.setInt(2,komptenzID);
            ResultSet resultSet = prep.executeQuery();
            resultSet.next();
            int anzahl = resultSet.getInt(1);

            if (anzahl == 0) {
                preparedStatement.setInt(1, mitgliedID);
                preparedStatement.setInt(2, komptenzID);
                preparedStatement.executeUpdate();
            } else {
                System.out.println("\nTupel existiert bereits!!!!!");
            }
        } catch (SQLException e) {
            System.out.println("Konnte nicht hinzugefuegt werden -> MK: " + e.getMessage());
        }
    }

    /**
     * löscht ein Mitglied
     * @param m
     */
    private void deleteMitglied(Mitglied m) {
        String idmitgliedAbfrage =" SELECT id_mitglied FROM mitglieder where vorname = ? and nachname = ? and lieblingsfarbe = ?";
        String delete = "DELETE FROM Mitglieder WHERE id_mitglied = ?";

        try (Connection connection = connect();
             PreparedStatement prepareID = connect().prepareStatement(idmitgliedAbfrage);
             PreparedStatement preparedStatement = connection.prepareStatement(delete)) {

            prepareID.setString(1,m.getVorname());
            prepareID.setString(2, m.getNachname());
            prepareID.setString(3,m.getLieblingsfarbe());
            ResultSet result = prepareID.executeQuery();
            int mitgliedID = result.getInt(1);

            preparedStatement.setInt(1, mitgliedID);
            preparedStatement.executeUpdate();

            System.out.println("Mitglied gelöscht.");

        } catch (SQLException e) {
            System.out.println("Konnte nicht geloescht werden -> Mitglied: " + e.getMessage());
        }
    }

    /**
     * löscht eine Kompetenz
     * @param kompetenzID
     */
    private void deleteKompetenz(int kompetenzID) {
        String abfrageMehrfach = "SELECT count(id_kompetenz) FROM mk WHERE id_kompetenz = ? ";
        try (Connection con = connect();
             PreparedStatement prep = con.prepareStatement(abfrageMehrfach)) {
            prep.setInt(1, kompetenzID);
            ResultSet resultMehrfach = prep.executeQuery();
            if (resultMehrfach.next()) {
                if (resultMehrfach.getInt("id_kompetenz") == 1) {
                    String delete = "DELETE FROM Mitglieder WHERE id_kompetenz = ?";
                    try (Connection connection = connect();
                         PreparedStatement preparedStatement = connection.prepareStatement(delete)) {

                        preparedStatement.setInt(1, kompetenzID);
                        preparedStatement.executeUpdate();

                        System.out.println("Kompetenz gelöscht.");
                    }
                } else {
                    System.out.println("Kompetenz gibt es mehrfach");
                }
            }
        } catch (SQLException e) {
            System.out.println("Konnte nicht geloescht werden -> Kompetenz: " + e.getMessage());

        }
    }

    /**
     * löscht Schnittstellen eintrag
     * @param mitgliedID
     * @param kompetenzID
     */
    private void deleteMK(int mitgliedID, int kompetenzID) {
        String abfrageMK = "";
        String deleteMkAbfrage = "DELETE FROM mk where id_mitglied = ?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteMkAbfrage)) {
            preparedStatement.setInt(1, mitgliedID);
            //preparedStatement.setInt(2, kompetenzID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("konnte nicht geloscht werden -> MK: " + e.getMessage());
        }
    }

    /**
     * Tabelle Mitglieder erzeugen
     */
    private void createTableMitglied() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            // SQL-Anweisung zur Tabellenerstellung
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Mitglieder ("
                    + "id_mitglied serial PRIMARY KEY,"
                    + "vorname VARCHAR(255),"
                    + "nachname VARCHAR(255),"
                    + "lieblingsfarbe VARCHAR(255))";

            // Tabellenerstellung ausführen
            statement.execute(createTableSQL);

            System.out.println("Table created successfully.");

        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    /**
     * Tabelle kompetenz erzeugen
     */
    private void createTableKompetenz() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            // SQL-Anweisung zur Tabellenerstellung
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Kompetenz ("
                    + "id_kompetenz serial PRIMARY KEY,"
                    + "name VARCHAR(255))";

            // Tabellenerstellung ausführen
            statement.execute(createTableSQL);

            System.out.println("Table created successfully.");

        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    /**
     * Tabelle mk erzeugen
     */
    private void createTableMK() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            // SQL-Anweisung zur Tabellenerstellung
            String createTableSQL = "CREATE TABLE IF NOT EXISTS MK ("
                    + "id_mitglied INT,"
                    + "id_kompetenz INT)";

            // Tabellenerstellung ausführen
            statement.execute(createTableSQL);

            System.out.println("Table created successfully.");

        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    /**
     * Verbindung zum Datenbank aufbauen
     * @return
     */
    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Display Mitglied
     *
     * @param rs
     * @throws SQLException
     */
    private void displayMitglied(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("id_mitglied") + "\t"
                    + rs.getString("vorname") + "\t"
                    + rs.getString("nachname") + "\t"
                    + rs.getString("lieblingsfarbe"));

        }
    }

    /**
     * Gibt alle Mitglieder aus
     */
    public void getMitglieder() {
        String SQL = "SELECT id_mitglied,vorname, nachname FROM Mitglieder";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            // display actor information
            displayMitglied(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Find mitglied by his/her ID
     *
     * @param mitgliedID
     */
    public void findMitgliedByID(int mitgliedID) {
        String SQL = "SELECT id_mitglied,vorname,nachname "
                + "FROM Mitglieder "
                + "WHERE id_mitglied = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, mitgliedID);
            ResultSet rs = pstmt.executeQuery();
            displayMitglied(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error while closing connection: " + e.getMessage());
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


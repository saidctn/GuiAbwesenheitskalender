import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Datenbank {
    // Verbindungsattribute
    private final String url = "jdbc:postgresql://localhost/GuiJava";
    private final String user = "postgres";
    private String password;
    public Datenbank(String password){
        this.password = password;
    }
    public void createTable(){

    }
    public Connection connect() {
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
     * Display actor
     *
     * @param rs
     * @throws SQLException
     */
    private void displayActor(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getString("actor_id") + "\t"
                    + rs.getString("first_name") + "\t"
                    + rs.getString("last_name"));

        }
    }
    /**
     * Get all rows in the actor table
     */
    public void getActors() {

        String SQL = "SELECT actor_id,first_name, last_name FROM actor";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            // display actor information
            displayActor(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Find actor by his/her ID
     *
     * @param actorID
     */
    public void findActorByID(int actorID) {
        String SQL = "SELECT actor_id,first_name,last_name "
                + "FROM actor "
                + "WHERE actor_id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, actorID);
            ResultSet rs = pstmt.executeQuery();
            displayActor(rs);
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
    public static void main(String[] args) {
        Datenbank app = new Datenbank("thkoln");
        app.connect();
        
        app.getActors();

        }
}


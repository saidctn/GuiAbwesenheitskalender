import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainFrame extends JFrame {

    BorderLayout borderContainer = new BorderLayout();
    JLabel mitgliederView = new JLabel("MitgliederListe");
    JPanel labelMitglieder = new JPanel();
    JTable tableMitglieder;
    DefaultTableModel mitgliederTable = new DefaultTableModel();
    JButton hinzufuegenButton = new JButton("Mitglied Hinzufuegen");
    JButton loeschen =new JButton("Eintrag entfernen");
    JScrollPane scrollPane;




    MainFrame(){
        setSize(1000,800);
        setLayout(borderContainer);

        // Tabellen-Spalte
        mitgliederTable.addColumn("Nachname");
        mitgliederTable.addColumn("Vorname");
        // Tabellen-Reihe


        tableMitglieder = new JTable(mitgliederTable);
        scrollPane = new JScrollPane(tableMitglieder);


        // Panel
        labelMitglieder.setBackground(new Color(255,0,0));
        labelMitglieder.add(mitgliederView);

        // Container Settings
        borderContainer.addLayoutComponent(labelMitglieder,BorderLayout.WEST);

        add(labelMitglieder);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.YearMonth;

public class MitgliederVerwaltungMitKalender extends JFrame {
    private DefaultListModel<String> mitgliederListModel;
    private JList<String> mitgliederList;


    public MitgliederVerwaltungMitKalender() {
        // Setzen Sie die Größe des Frames
        setSize(1200, 600);

        // Layout-Manager auf BorderLayout setzen
        setLayout(new BorderLayout());

        // Mitgliederliste erstellen und dem westlichen Bereich hinzufügen
        mitgliederListModel = new DefaultListModel<>();
        mitgliederList = new JList<>(mitgliederListModel);
        JScrollPane mitgliederScrollPane = new JScrollPane(mitgliederList);
        add(mitgliederScrollPane, BorderLayout.WEST);



        // Buttons erstellen und dem südlichen Bereich hinzufügen
        JButton erstellenButton = new JButton("Mitglied erstellen");
        JButton loeschenButton = new JButton("Mitglied löschen");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(erstellenButton);
        buttonPanel.add(loeschenButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // ActionListener für den Erstellen-Button hinzufügen
        erstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Eingabeaufforderung für Vor- und Nachnamen anzeigen
                String vorname = JOptionPane.showInputDialog("Vorname:");
                String nachname = JOptionPane.showInputDialog("Nachname:");

                // Überprüfen, ob Vor- und Nachname eingegeben wurden
                if (vorname != null && !vorname.isEmpty() && nachname != null && !nachname.isEmpty()) {
                    String mitglied = vorname + " , " + nachname;
                    mitgliederListModel.addElement(mitglied);
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte Vor- und Nachnamen eingeben.");
                }
            }
        });

        // ActionListener für den Löschen-Button hinzufügen
        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = mitgliederList.getSelectedIndex();
                if (selectedIndex != -1) {
                    mitgliederListModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Bitte ein Mitglied auswählen.");
                }
            }
        });

        // Das Programm bei Schließen des Fensters beenden
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MitgliederVerwaltungMitKalender().setVisible(true);
            }
        });
    }
}

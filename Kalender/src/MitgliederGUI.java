import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MitgliederGUI extends JFrame {
    /* Die DefaultListModel-Klasse ist eine vorgefertigte Implementierung von ListModel
    , die die grundlegenden Funktionen zum Hinzufügen, Entfernen und Verwalten von Elementen bereitstellt.
     Ist für die Daten-Verwaltung
     */
    private DefaultListModel<String> mitgliederListModel;

    /* Jlist verwendet um Liste in der Gui darzustellen
    *  Wird Verwendet um einen Listener zu Implementieren der auf Aktionen und Klicks reagieren kann
    * */
    private JList<String> mitgliederList;
    private JButton hinzufuegenButton, entfernenButton;
    private JTextArea krankenKalender;

    private Map<String, ArrayList<String>> krankenEintraege;

    public MitgliederGUI() {
        krankenEintraege = new HashMap<>();

        setTitle("Mitglieder Verwaltung");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mitgliederListModel = new DefaultListModel<>();
        mitgliederList = new JList<>(mitgliederListModel);
        JScrollPane mitgliederScrollPane = new JScrollPane(mitgliederList);



        hinzufuegenButton = new JButton("Mitglied hinzufügen");
        entfernenButton = new JButton("Mitglied entfernen");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(hinzufuegenButton);
        buttonPanel.add(entfernenButton);
        // Um Panel zu sehen innerhalb des Borderlayouts
        buttonPanel.setBackground(new Color(200,0,0));

        krankenKalender = new JTextArea(10, 30);
        krankenKalender.setEditable(false);
        JScrollPane krankenKalenderScrollPane = new JScrollPane(krankenKalender);


        // Hinzufuegen von Borderlayout in Panel
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(mitgliederScrollPane, BorderLayout.WEST);
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        contentPane.add(krankenKalenderScrollPane, BorderLayout.CENTER);

        add(contentPane);

        hinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vorname = JOptionPane.showInputDialog("Vorname eingeben:");
                String nachname = JOptionPane.showInputDialog("Nachname eingeben:");
                String mitglied = vorname + " " + nachname;
                mitgliederListModel.addElement(mitglied);
            }
        });

        entfernenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mitgliederList.getSelectedIndex() != -1) {
                    mitgliederListModel.remove(mitgliederList.getSelectedIndex());
                }
            }
        });

        // Hier können weitere Funktionen für den Krankenkalender implementiert werden

        setVisible(true);
    }
/*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MitgliederGUI();
            }
        });

 */
    }

// vllt weg machen !}
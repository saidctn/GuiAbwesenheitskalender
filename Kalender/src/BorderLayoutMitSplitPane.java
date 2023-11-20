import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BorderLayoutMitSplitPane extends JFrame {

    private ArrayList<Mitglied> mitgliedsliste =new ArrayList<>();
    MitgliedHinzufuegen mitgliederAddFram
    public BorderLayoutMitSplitPane() {
        setTitle("Abwesendheits-Kalendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);

        JButton buttonAdd = new JButton("Hinzufügen");
        JButton buttonDel = new JButton("Delete");


        // Erstelle die Listen spätere implementierung mit buttons
        DefaultListModel<String> kompetenzenListe = new DefaultListModel<>();
        kompetenzenListe.add(0,"Windows-Server");
        kompetenzenListe.add(1,"Datenbank");
        kompetenzenListe.add(2,"VMWare");
        kompetenzenListe.add(3,"Linux-Server");

        //JList<Mitglied> mitgliederListe = new JList<>((ListModel<Mitglied>) mitgliedsliste);
        JList<String> kompetenzListe = new JList<>(kompetenzenListe);

        // Erstelle ein SplitPane
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,null,new JScrollPane(kompetenzListe));

        splitPane.setDividerLocation(200); // Setze die Position des Dividers
        splitPane.setPreferredSize(new Dimension(200,400));

        // Füge Überschriften hinzu
        JLabel mitgliederLabel = new JLabel("Mitglieder");
        JLabel kompetenzLabel = new JLabel("Kompetenzen", SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(800,50));
        buttonPanel.setLayout(null);

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(buttonAdd)){
                    mitgliederAddFrame = new MitgliedHinzufuegen();
                }
            }
        });
        buttonDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MitgliedEntfernen();
            }
        });



        buttonAdd.setSize(new Dimension(150,25));
        buttonAdd.setBounds(800,10,100,25);
        buttonDel.setSize(new Dimension(150,25));
        buttonDel.setBounds(900,10,75,25);
        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonDel);


        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(splitPane, BorderLayout.WEST);
        mainPanel.add(buttonPanel,BorderLayout.NORTH);


        getContentPane().add(mainPanel);
        setVisible(true);
    }
}


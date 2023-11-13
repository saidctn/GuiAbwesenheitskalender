import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MitgliedHinzufuegen {

    private Mitglied mitarbeiter;

    private JFrame frame;
    private JLabel nachName;
    private JLabel vorName;
    private JTextField eingabeVorName;
    private JTextField eingabeNachname;

   public  MitgliedHinzufuegen() {
       frame = new JFrame("Mitglied hinzufuegen");
        nachName=new JLabel("Nachname: ");
        vorName=new JLabel("Vorname   : ");
        eingabeVorName=new JTextField();
        eingabeNachname=new JTextField();


   }



    public void gui() {
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        nameHinzufuegen();
        eingabeName();
        lieblingsfarbe();

        frame.setVisible(true);
    }

    private void nameHinzufuegen() {
        nachName.setBounds(10, 10, 300, 50);
        nachName.setFont(new Font("Arial",Font.BOLD,30));
        frame.add(nachName);

        vorName.setBounds(10,40,300,50);
        vorName.setFont(new Font("Arial",Font.BOLD,30));
        vorName.setLocation(10,80);
        frame.add(vorName);
    }


    private void eingabeName(){
        eingabeNachname.setBounds(200,10,250,50);
        eingabeNachname.setFont(new Font("Arial",Font.BOLD,25));

        eingabeVorName.setBounds(200,75,250,50);
        eingabeVorName.setFont(new Font("Arial",Font.BOLD,25));

        frame.add(eingabeNachname);
       frame.add(eingabeVorName);
    }

    private void lieblingsfarbe(){
    String farbe []={"schwarz","weiss","rot","gruen","blau","gelb","orang","rosa","dunkrlgrau","magenta","Cyan","helgrau"};




    }


}



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MitgliedHinzufuegen extends JFrame implements ActionListener {

    private Mitglied mitarbeiter;
    private JComboBox<String> lieblingsfarbe;
    private JComboBox<String>kompetenzen;
    private JTextField eingabeVorName=new JTextField();
    private JTextField eingabeNachname=new JTextField();
    private JTextField farbeTextField=new JTextField();
    private JTextField kompetenzenTextField=new JTextField();
    private JButton hinzufuegenButton=new JButton("Mitglied hinzufuegen");
    private JButton kompetenzFeldEntfernen=new JButton("kompetenz del");
    private Datenbank mitgliedHinzufuegenInDatenbank=new Datenbank("1234");


   public  MitgliedHinzufuegen() {
       new JFrame("Mitglied hinzufuegen");

       setSize(820, 500);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(null);

       JLabel nachName=new JLabel("Nachname: ");
       JLabel vorName=new JLabel("Vorname   :");
       nameLabel(nachName,vorName);

       eingabeName();

       JLabel farbeLabel=new JLabel("Lieblingsfarbe: ");
       lieblingsfarbe(farbeLabel);

       JLabel kompetenzenLabel=new JLabel("Kompetenzen:");
       kompetenzen(kompetenzenLabel);

       hinzufuegenButton();

       setVisible(true);
   }

   public Mitglied getMitarbeiter(){
       return mitarbeiter;
   }




    //plazierung/form des labes des namens
    private void nameLabel(JLabel nachName,JLabel vorName) {
        nachName.setBounds(10, 10, 300, 50);
        nachName.setFont(new Font("Arial",Font.BOLD,30));
        add(nachName);

        vorName.setBounds(10,40,300,50);
        vorName.setFont(new Font("Arial",Font.BOLD,30));
        vorName.setLocation(10,80);
        add(vorName);
    }

    //plazierung/form des textfelder von vor-/Nachname
    private void eingabeName(){
        eingabeNachname.setBounds(200,10,250,50);
        eingabeNachname.setFont(new Font("Arial",Font.BOLD,25));


        eingabeVorName.setBounds(200,75,250,50);
        eingabeVorName.setFont(new Font("Arial",Font.BOLD,25));


        add(eingabeNachname);
       add(eingabeVorName);
    }

    //plazierung/form der farbe
    private void lieblingsfarbe(JLabel farbeLabel){
    String farbe []={"","schwarz","weiss","rot","gruen","blau","gelb","orang","pink","dunkelgrau","magenta","Cyan","helgrau"};
    lieblingsfarbe=new JComboBox<>(farbe);
    lieblingsfarbe.setBounds(25,300,200,50);
    lieblingsfarbe.setFont(new Font("Arial",Font.BOLD,15));
    lieblingsfarbe.setBackground(Color.white);
    lieblingsfarbe.addActionListener(this);

    farbeLabel.setBounds(10,180,230,50);
    farbeLabel.setFont(new Font("Arial",Font.BOLD,30));

    farbeTextField.setBounds(25,245,200,50);
    farbeTextField.setEditable(false);
    farbeTextField.setBackground(Color.white);


    add(farbeTextField);
    add(farbeLabel);
    add(lieblingsfarbe);
    }

    //plazierung/form der Kompetenzen
    private void kompetenzen(JLabel kompetenzenLabel){
       String []komptenzenliste={"","Windows Server","Linux Server","Datenbanken","VMWare"};
    kompetenzenLabel.setFont(new Font("Arial",Font.BOLD,30));
    kompetenzenLabel.setBounds(360,180,230,50);

    kompetenzen=new JComboBox<>(komptenzenliste);
    kompetenzen.setBounds(365,300,200,50);
    kompetenzen.setFont(new Font("Arial",Font.BOLD,15));
    kompetenzen.setBackground(Color.white);
    kompetenzen.addActionListener(this);

    kompetenzenTextField.setEditable(false);
    kompetenzenTextField.setBackground(Color.white);
    kompetenzenTextField.setBounds(365,250,250,50);
    kompetenzenTextField.setFont(new Font("Arial",Font.BOLD,15));

    kompetenzFeldEntfernen.setBounds(625,250,175,100);
    kompetenzFeldEntfernen.setFont(new Font("Arial",Font.BOLD,20));
    kompetenzFeldEntfernen.addActionListener(this);

    add(kompetenzFeldEntfernen);
    add(kompetenzenTextField);
    add(kompetenzen);
    add(kompetenzenLabel);

    }

    //plazierung/form des Buttons
    private void hinzufuegenButton(){
       hinzufuegenButton.setBounds(100,400,500,50);
       hinzufuegenButton.setFont(new Font("Arial",Font.BOLD,20));
        hinzufuegenButton.addActionListener(this);

       add(hinzufuegenButton);
    }


//zusammenspiel der einzellen Komponenten
    @Override
    public void actionPerformed(ActionEvent e) {
        String faehigkeit=new String();
        String vorName=new String();
        String nachName=new String();
        String farbe=new String();


        //faerbung des TextFeldes durch auswahl der lieblingsfarbe
        if (e.getSource().equals(lieblingsfarbe)) {
            farbe = (String) lieblingsfarbe.getSelectedItem();
            System.out.println("ausgabe farbe von jCombox: "+farbe);
            switch (farbe){

                case "schwarz":
                    farbeTextField.setBackground(Color.BLACK);break;
                case "weiss":
                    farbeTextField.setBackground(Color.white);break;
                case "rot":
                    farbeTextField.setBackground(Color.red);break;
                case "gruen":
                    farbeTextField.setBackground(Color.green);break;
                case "blau":
                    farbeTextField.setBackground(Color.blue);break;
                case "gelb":
                    farbeTextField.setBackground(Color.yellow);break;
                case "orang":
                    farbeTextField.setBackground(Color.orange);break;
                case "pink":
                    farbeTextField.setBackground(Color.PINK);break;
                case "dunkelgrau":
                    farbeTextField.setBackground(Color.darkGray);break;
                case "magenta":
                    farbeTextField.setBackground(Color.magenta);break;
                case "cyan":
                    farbeTextField.setBackground(Color.cyan);break;
                case "hellgrau":
                    farbeTextField.setBackground(Color.lightGray);break;
            }
        }

        //eingabe der Kompetenzen in das TextFeld
        if(e.getSource().equals(kompetenzen)){

            faehigkeit=(String)kompetenzen.getSelectedItem();

            //besonderheit bei der eingabe des Textfeldes das am anfang kein komma steht
            if(kompetenzenTextField.getText().isEmpty()){
                kompetenzenTextField.setText(faehigkeit);}
            else{
                kompetenzenTextField.setText(kompetenzenTextField.getText()+", "+faehigkeit);
            }
        }

        //betaetigung des buttuns entfernt alle Kompetenzen
        if(e.getSource().equals(kompetenzFeldEntfernen)){
            kompetenzenTextField.setText("");
        }

        //es wird erst ein Objekt mitarbeiter erstellt wenn alle fleder ausgefuellt sind
        if(e.getSource().equals(hinzufuegenButton)) {
            vorName=eingabeVorName.getText();
            nachName=eingabeNachname.getText();
            faehigkeit=kompetenzenTextField.getText();
            farbe=(String)lieblingsfarbe.getSelectedItem();


            if (vorName.isEmpty() || nachName.isEmpty() || farbe.isEmpty() || faehigkeit.isEmpty()) {


                JFrame fehler = new JFrame("alles ausfuellen");
                fehler.setSize(500, 200);
                fehler.setLayout(null);
                fehler.setLocationRelativeTo(null);

                JLabel keinMitgliedErzeugt = new JLabel("bitte fuellen sie alle Felder aus");
                keinMitgliedErzeugt.setBounds(20, 50, 500, 50);
                keinMitgliedErzeugt.setFont(new Font("Arial", Font.BOLD, 30));
                keinMitgliedErzeugt.setForeground(Color.red);
                fehler.add(keinMitgliedErzeugt);
                fehler.setVisible(true);

            } else {
                mitarbeiter = new Mitglied(vorName, nachName, farbe);
                dispose();
            }
        }
    }
        }



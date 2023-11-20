import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MitgliedHinzufuegen implements ActionListener {

    private ArrayList<Mitglied> mitgliedsliste =new ArrayList<>();
    public Mitglied mitarbeiter;
    private Kompetenz windows;
    private Kompetenz linux;
    private  Kompetenz datenbank;
    private Kompetenz vMWare;
    private JFrame frame;
    private JLabel nachName;
    private JLabel vorName;
    private JTextField eingabeVorName;
    private JTextField eingabeNachname;
    private JComboBox<String> lieblingsfarbe;
    private JLabel farbeLabel;
    private  JComboBox<String>komepetenz;
    private  JLabel kompetenzenLabel;
    private JComboBox<String>kompetenzen;
    private JTextField farbeTextField;
    private JTextField kompetenzenTextField;
    private JButton hinzufuegenButton;
    private JButton kompetenzFeldEntfernen;
    private Datenbank mitgliedHinzufuegenInDatenbank=new Datenbank("1234");

   public  MitgliedHinzufuegen() {
       frame = new JFrame("Mitglied hinzufuegen");
        nachName=new JLabel("Nachname: ");
        vorName=new JLabel("Vorname   : ");
        eingabeVorName=new JTextField();
        eingabeNachname=new JTextField();
        farbeLabel=new JLabel("Lieblingsfarbe: ");
        kompetenzenLabel=new JLabel("Kompetenzen: ");
        farbeTextField=new JTextField();
        kompetenzenTextField=new JTextField();
        hinzufuegenButton=new JButton("Mitglied hinzufuegen");
        kompetenzFeldEntfernen=new JButton("kompetenz del");
   }

    public ArrayList<Mitglied> getMitgliedsliste() {
        return mitgliedsliste;
    }

    public void gui() {
        frame.setSize(820, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        nameLabel();
        eingabeName();
        lieblingsfarbe();
        kompetenzen();
        hinzufuegenButton();

        frame.setVisible(true);

    }

    private void nameLabel() {
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


    frame.add(farbeTextField);
    frame.add(farbeLabel);
    frame.add(lieblingsfarbe);
    }


    private void kompetenzen(){
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

    frame.add(kompetenzFeldEntfernen);
    frame.add(kompetenzenTextField);
    frame.add(kompetenzen);
    frame.add(kompetenzenLabel);

    }


    private void hinzufuegenButton(){
       hinzufuegenButton.setBounds(100,400,500,50);
       hinzufuegenButton.setFont(new Font("Arial",Font.BOLD,20));
        hinzufuegenButton.addActionListener(this);


       frame.add(hinzufuegenButton);
    }
    private void addMitgliedInListe(Mitglied m){
       mitgliedsliste.add(m);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String faehigkeit=new String();
        String vorName=new String();
        String nachName=new String();
        String farbe=new String();

        String windowsString=new String();
        String linuxString=new String();
        String datenbankString=new String();
        String vMWarwString=new String();

        if (e.getSource().equals(lieblingsfarbe)) {
            farbe = (String) lieblingsfarbe.getSelectedItem();

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


        if(e.getSource().equals(kompetenzen)){

            faehigkeit=(String)kompetenzen.getSelectedItem();
          switch (faehigkeit){
              case "Windows Server":
                  windowsString=faehigkeit;
                  windows=new Kompetenz(windowsString);break;
              case "Linux Server":
                  linuxString=faehigkeit;
                  linux=new Kompetenz(linuxString);break;
              case "Datenbank":
                  datenbankString=faehigkeit;
                  datenbank=new Kompetenz(datenbankString);break;
              case "VMWare":
                  vMWarwString=faehigkeit;
                  vMWare=new Kompetenz(vMWarwString);break;
          }




            if(kompetenzenTextField.getText().isEmpty()){
            kompetenzenTextField.setText(faehigkeit);}
            else{
                kompetenzenTextField.setText(kompetenzenTextField.getText()+", "+faehigkeit);
            }
        }



        if(e.getSource().equals(kompetenzFeldEntfernen)){
            kompetenzenTextField.setText("");
            vMWarwString=null;
            linuxString=null;
            windowsString=null;
            datenbankString=null;

        }

        if(e.getSource().equals(hinzufuegenButton)) {
            vorName=eingabeVorName.getText();
            nachName=eingabeNachname.getText();


            if (!(vorName.isEmpty() & nachName.isEmpty() & farbe.isEmpty() & faehigkeit.isEmpty())) {
                mitarbeiter = new Mitglied(vorName, nachName, farbe);
                mitgliedsliste.add(mitarbeiter);

                // In datenbank Mitglied hinzufugen
                mitgliedHinzufuegenInDatenbank.addToDatabase(mitarbeiter);

                if(!windowsString.equals(null)){
                    mitarbeiter.addKompetenz(windows);
                }
                if(!vMWarwString.equals(null)){
                    mitarbeiter.addKompetenz(vMWare);
                }
                if(!linuxString.equals(null)){
                    mitarbeiter.addKompetenz(linux);
                }
                if(!datenbankString.equals(null)){
                    mitarbeiter.addKompetenz(datenbank);
                }



                frame.dispose();

            } else {

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
            }
        }
    }
        }



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MitgliedHinzufuegen implements ActionListener {

    private Mitglied mitarbeiter;

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

   }



    public void gui() {
        frame.setSize(750, 500);
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
        eingabeNachname.addActionListener(this);

        eingabeVorName.setBounds(200,75,250,50);
        eingabeVorName.setFont(new Font("Arial",Font.BOLD,25));
        eingabeVorName.addActionListener(this);

        frame.add(eingabeNachname);
       frame.add(eingabeVorName);
    }

    private void lieblingsfarbe(){
    String farbe []={"","schwarz","weiss","rot","gruen","blau","gelb","orang","pink","dunkelgrau","magenta","Cyan","helgrau"};
    lieblingsfarbe=new JComboBox<>(farbe);
    lieblingsfarbe.setBounds(25,300,200,50);
    lieblingsfarbe.setFont(new Font("Arial",Font.BOLD,25));
    lieblingsfarbe.setBackground(Color.white);
    lieblingsfarbe.addActionListener(this);

    farbeLabel.setBounds(10,180,230,50);
    farbeLabel.setFont(new Font("Arial",Font.BOLD,30));

    farbeTextField.setBounds(25,245,200,50);
    farbeTextField.setEditable(false);
    farbeTextField.setBackground(Color.white);
    farbeTextField.setFont(new Font("Arial",Font.BOLD,25));

    frame.add(farbeTextField);
    frame.add(farbeLabel);
    frame.add(lieblingsfarbe);
    }


    private void kompetenzen(){
       String []komptenzenliste={" ","Windows Server","Linux Server","Datenbanken","VMWare"};
    kompetenzenLabel.setFont(new Font("Arial",Font.BOLD,30));
    kompetenzenLabel.setBounds(360,180,230,50);
    kompetenzen=new JComboBox<>(komptenzenliste);

    kompetenzen.setBounds(365,300,200,50);
    kompetenzen.setFont(new Font("Arial",Font.BOLD,25));
    kompetenzen.setBackground(Color.white);
    kompetenzen.addActionListener(this);

    kompetenzenTextField.setEditable(false);
    kompetenzenTextField.setBackground(Color.white);
    kompetenzenTextField.setBounds(365,250,250,50);





    frame.add(kompetenzenTextField);
    frame.add(kompetenzen);
    frame.add(kompetenzenLabel);

    }
<<<<<<< HEAD
}
=======

    private void hinzufuegenButton(){
       hinzufuegenButton.setBounds(100,400,500,50);
       hinzufuegenButton.setFont(new Font("Arial",Font.BOLD,20));


       frame.add(hinzufuegenButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String faehigkeit;
        String vorName;
        String nachName;


        if (e.getSource().equals(lieblingsfarbe)) {
            String farbe = (String) lieblingsfarbe.getSelectedItem();

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
            if(kompetenzenTextField.getText().isEmpty()){
            kompetenzenTextField.setText(faehigkeit);}
            else{
                kompetenzenTextField.setText(kompetenzenTextField.getText()+", "+faehigkeit);
            }
        }

        if(e.getSource().equals(eingabeNachname)){
            nachName=eingabeNachname.getText();
        }
        if(e.getSource().equals(eingabeVorName)){
            vorName=eingabeVorName.getText();
        }

    }
        }




>>>>>>> ae771705f3a77dd28d4f7c31c4d28c1a8ed4c351



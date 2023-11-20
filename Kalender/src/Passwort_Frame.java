import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Passwort_Frame extends JFrame implements ActionListener {
    JLabel north = new JLabel("Gebe dein Password ein");
    JTextField pwtf = new JTextField();
    JButton enter = new JButton("enter");

    Passwort_Frame(){
        setTitle("Login Database");
        setLayout(new GridLayout(3,1));
        setSize(300,200);
        setLocationRelativeTo(null);

        north.setFont(new Font("Arial",Font.BOLD,20));
        north.setPreferredSize(new Dimension(300,50));

        pwtf.setFont(new Font("Arial",Font.BOLD,20));
        pwtf.setPreferredSize(new Dimension(300,50));


        enter.setPreferredSize(new Dimension(300,50));
        enter.addActionListener(this);

        add(north);
        add(pwtf);
        add(enter);
        setVisible(true);
    }

    //public static void main(String[] args) {
      //  new Passwort_Frame();
    //
    // }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(enter)) {
            String enteredPassword = pwtf.getText();
            // Übergebe das eingegebene Passwort an die Datenbankklasse
            //Datenbank datenbank = new Datenbank();
            //datenbank.setPassword(enteredPassword);
            //MitgliedHinzufuegen.mitgliedHinzufuegenInDatenbank.setPassword();

        }
    }
}

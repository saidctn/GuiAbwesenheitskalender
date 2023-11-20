import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Passwort_Frame extends JFrame implements ActionListener {
    JLabel north = new JLabel("Gebe dein Password ein");
    JPasswordField pwtf = new JPasswordField();
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

    public static void main(String[] args) {
        new Passwort_Frame();

     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(enter)) {

            boolean successfulLogin = true;

            do {
                String enteredPassword = new String(pwtf.getPassword());

                // Übergebe das eingegebene Passwort an die Datenbankklasse
                Datenbank datenbank = new Datenbank(enteredPassword);

                // Überprüfe die Verbindung und setze successfulLogin entsprechend
                successfulLogin = datenbank.testConnection();

                if (!successfulLogin) {
                    // Wenn die Verbindung nicht erfolgreich war, erneute Eingabe auffordern
                    JOptionPane.showMessageDialog(this, "Falsches Passwort. Bitte versuche es erneut.", "Fehler", JOptionPane.ERROR_MESSAGE);
                    pwtf.setText("");  // Passwortfeld leeren
                }
            } while (!successfulLogin);
            new BorderLayoutMitSplitPane();

            // Schließe das Frame, wenn die Verbindung erfolgreich war
            dispose();
        }
    }
}

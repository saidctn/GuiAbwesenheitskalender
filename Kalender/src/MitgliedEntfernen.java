import javax.swing.*;
import java.awt.*;

public class MitgliedEntfernen {

    private static JFrame jframe;
    private JList<String> jList;


    public MitgliedEntfernen() {
        JFrame jframe = new JFrame("Liste");
        jframe.setSize(500, 500);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        JButton jButton=new JButton("entfernen");
        jButton.setSize(100,50);
        jButton.setBackground(Color.red);
        jButton.setLocation(380,0);
        jframe.setLayout(new GridLayout(8,10));
        jframe.add(jButton);

    }

    public static void main(String[] args) {
        new MitgliedEntfernen();
    }
}


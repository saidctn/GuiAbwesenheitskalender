

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MitgliedEntfernen {

    private static JFrame jframe;
    private DefaultListModel<String> jList;
    private JList<String> membersList;

    public MitgliedEntfernen() {
        jframe = new JFrame("Mitglieder verwalten");
        jframe.setSize(500, 500);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setLayout(new BorderLayout());
        addButton();

        jframe.setVisible(true);
    }

    private void addButton() {
        JButton jButton = new JButton("Entfernen");
        jButton.setSize(50, 50);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRemoveDialog();
            }
        });

        jframe.add(jButton, BorderLayout.SOUTH);
    }

    private void showRemoveDialog() {
        if (jList == null) {
            jList = new DefaultListModel<>();
            jList.addElement("Mitglied1");
            jList.addElement("Mitglied2");
            jList.addElement("Mitglied3");
            membersList = new JList<>(jList);
        }

        String selectedMember = (String) JOptionPane.showInputDialog(jframe, "Wählen Sie ein Mitglied zum Entfernen:", "Mitglied entfernen", JOptionPane.PLAIN_MESSAGE, null, jList.toArray(), null);

        if (selectedMember != null) {
            jList.removeElement(selectedMember);
            showRemoveDialog(); // Falls weitere Mitglieder entfernt werden sollen
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MitgliedEntfernen();
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI implements ActionListener {

    public static void main(String[] args) {
        new GUI();
    }

    private static JLabel userlabel;
    private static JTextField usertext;
    private static JButton button;
    private static JLabel succes;
    private static JList lijst;
    private static JScrollPane scrollPane;

    public GUI() {
        //voor maken van window
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Opdracht 4");

        //label
        userlabel = new JLabel("Person:");
        userlabel.setBounds(10, 50, 80, 25);
        panel.add(userlabel);

        //input field
        usertext = new JTextField();
        usertext.setBounds(140, 50, 165, 25);
        panel.add(usertext);

        succes = new JLabel();
        succes.setBounds(110, 150, 300, 25);
        panel.add(succes);

        //button die method aan roept
        button = new JButton("Persoon Toevoegen");
        button.setBounds(140, 120, 160, 25);
        button.addActionListener(this::actionPerformed);
        panel.add(button);

        //Lijst met waar person info inkomt
        lijst = new JList();
        panel.add(lijst);

        //scrollbar toevoegen aan lijst
        scrollPane = new JScrollPane(lijst);
        scrollPane.setBounds(100, 160, 300, 70);
        panel.add(scrollPane);

        //setting voor Jpanel en Jframe
        panel.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }


    DefaultListModel mod = new DefaultListModel();

    @Override
    public void actionPerformed(ActionEvent e) {
        String person = usertext.getText();
        mod.addElement(usertext.getText());
        lijst.setModel(mod);


    }


}

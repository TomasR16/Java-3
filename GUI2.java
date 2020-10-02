import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI2 implements ActionListener {

    private int count = 0;
    private static JFrame frame;
    private static JLabel label;
    private static JPanel panel;
    private static JButton button;
    private static JButton button2;
    static JButton knop;

    public static void main(String[] args) {
        new GUI2();

    }

    public GUI2() {

        frame = new JFrame("GUI practice");

        label = new JLabel("Number of clicks: 0");
        panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(1, 1,10,10));
        panel.add(label);

        button = new JButton("Click me");
        button.addActionListener(this::actionPerformed);
        button.setBounds(50, 50, 25, 25);
        panel.add(button);

        button2 = new JButton("Update");
        button2.setBounds(50,50,50,50);
        button2.addActionListener(this::update);
        panel.add(button2);


        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setSize(250, 250);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    public void oefen(ActionEvent z){
        knop = new JButton("Tekst Hier:");
        knop.setBounds(25,25,25,25);
        knop.addActionListener(this::update);
        panel.add(knop);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks: " + count);
    }

    public void update(ActionEvent i) {
        System.out.println("Hello Tomas");
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Visibility;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class eind1 {
    //maken van objecten
    static JFrame frame;
    static JPanel panel;
    static JLabel label;
    static JButton knop;
    static ImageIcon img;
    static MemoButton[] buttons = new MemoButton[16];


    //maken van methodes
    public static void main(String[] args) {
        new eind1();
        buttonimg();
    }


    public static void buttonimg() {

        String[] bestand = {"src\\img\\spiderman.jpg", "src\\img\\spiderman.jpg",
                "src\\img\\batman.jpg", "src\\img\\batman.jpg",
                "src\\img\\captain-america.jpg", "src\\img\\captain-america.jpg",
                "src\\img\\fantastic-four.jpg", "src\\img\\fantastic-four.jpg",
                "src\\img\\flash.jpg", "src\\img\\flash.jpg",
                "src\\img\\ironman.jpg", "src\\img\\ironman.jpg",
                "src\\img\\the-avengers.jpg", "src\\img\\the-avengers.jpg",
                "src\\img\\aquaman.jpg", "src\\img\\aquaman.jpg"};

        int t = 0;

        panel.setLayout(new GridLayout(0, 4, 25, 25));

        while (bestand.length > 0) {
            //random image in de jbutton
            int index = (int) (Math.random() * (bestand.length - 1));
            MemoButton knop = new MemoButton();
            knop.setImagename(bestand[index]);

            knop.addActionListener((new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MemoButton hier = (MemoButton) e.getSource();

                    //als die open is zet weer dicht en andersom
                    if (hier.getStatus().equals("DICHT")) {
                        hier.setStatus("OPEN");
                    } else if (hier.getStatus().equals("OPEN")) {
                        hier.setStatus("DICHT");
                    }
                    System.out.println("Geklikt");

                    for (int i = 0; i < buttons.length; i++) {

                        // niet met jezelf vergelijken
                        if (!hier.equals(buttons[i])) {
                            //System.out.println(i+": "+"vergelijkend niet met jezelf");
                            System.out.println("Geklikt: " + hier.getStatus());
                            System.out.println(i + " Lijst:  " + buttons[i].getStatus());

                            //als bijde kaarten openstaan
                            if (hier.getStatus().equals("OPEN") && buttons[i].getStatus().equals("OPEN")) {
                                System.out.println("Twee open kaarten");

                                //als de kaarten zelfde naam hebben zet GEVONDEN
                                if (hier.getImageName().equals(buttons[i].getImageName())) {
                                    hier.setStatus("GEVONDEN");
                                    buttons[i].setStatus("GEVONDEN");
                                    System.out.println("MATCH");
                                } else {
                                    //niet gelijk dus sluiten
                                    int finalI = i;
                                    Thread t = new Thread(new Runnable() {
                                        //maar eerst aanroepen van deze methode voor sluiten
                                        @Override
                                        public void run() {
                                            try {
                                                Thread.sleep(500);
                                            } catch (InterruptedException interruptedException) {
                                                interruptedException.printStackTrace();
                                            }
                                            hier.setStatus("DICHT");
                                            buttons[finalI].setStatus("DICHT");
                                        }
                                    });
                                    //starten van methode
                                    t.start();

                                }
                            }
                        }
                    }

                }
            }));
            //printen van buttons met image
            buttons[bestand.length - 1] = knop;
            panel.add(knop);
            String[] bestand2 = new String[bestand.length - 1];
            for (int x = 0; x <= bestand2.length; x++) {
                if (x != index) {
                    bestand2[t] = bestand[x];
                    t++;
                }
            }
            // reset t naar 0
            t = 0;
            // kopier bestand 2 naar bestand
            bestand = bestand2;
        }

    }

    //setten van window en frame
    public eind1() {
        frame = new JFrame("Eindopdracht");
        panel = new JPanel();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(1200, 1000);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(4, 4));
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }


}

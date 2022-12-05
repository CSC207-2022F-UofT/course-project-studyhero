package UI.screens.panels.settings;

import javax.swing.*;
import java.awt.*;

public class Border{
        JFrame f;
        JPanel p;
        public Border() {
            f = new JFrame();
            p = new JPanel();
            f.add(p, BorderLayout.NORTH);

            // creating buttons
            JButton b1 = new JButton("NORTH"); // the button will be labeled as NORTH
            JButton b2 = new JButton("SOUTH"); // the button will be labeled as SOUTH
            JButton b3 = new JButton("EAST"); // the button will be labeled as EAST
            JButton b4 = new JButton("WEST"); // the button will be labeled as WEST
            JButton b5 = new JButton("CENTER"); // the button will be labeled as CENTER

            p.add(b1, BorderLayout.NORTH); // b1 will be placed in the North Direction
            p.add(b2, BorderLayout.SOUTH);  // b2 will be placed in the South Direction
            p.add(b3, BorderLayout.EAST);  // b2 will be placed in the East Direction
            p.add(b4, BorderLayout.WEST);  // b2 will be placed in the West Direction
            p.add(b5, BorderLayout.CENTER);  // b2 will be placed in the Center

            JPanel p2 =  new JPanel();
            JButton b6 = new JButton("Other");
            p2.add(b6);
            p2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            f.add(p2, BorderLayout.SOUTH);

            //f.add(p);
            p.add(Box.createRigidArea(new Dimension(0,5)));
            p.setLayout(new BoxLayout(p, 3));
            p.setBorder(BorderFactory.createEmptyBorder(50,100,1,100));
            f.setSize(300, 300);
            f.setVisible(true);
        }

        public static void main(String[] args) {
            new Border();
        }

}

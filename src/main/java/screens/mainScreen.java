package screens;

import javax.swing.*;
import java.awt.*;
import screens.panels.*;

import static screens.mainCard.switchScreens;

public class mainScreen {

    public static void main(String[] args){
        new mainScreen();
    }

    public mainScreen(){

        JFrame frame = new JFrame("StudyHero");
        JPanel mainPanel = new JPanel(); // container
        JPanel panel1 = breakPanel.breakPanel();
        JPanel panel2 = startPanel.startPanel();
        JButton button1 = new JButton("Switch to Start");
        JButton button2 = new JButton("Switch to Break");

        CardLayout card = mainCard.getCard();

        mainPanel.setLayout(card);
        panel1.add(button1);
        button1.addActionListener(e -> switchScreens(mainPanel, "Start"));
        panel2.add(button2);
        button2.addActionListener(e -> switchScreens(mainPanel, "Break"));
        panel1.setBackground(Color.BLUE);
        panel2.setBackground(Color.GRAY);

        mainPanel.add(panel1, "Break");
        mainPanel.add(panel2, "Start");

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("demo");
        frame.pack();
        frame.setVisible(true);

    }



}

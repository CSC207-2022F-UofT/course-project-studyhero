package screens;

import screens.panels.breakPanel;
import screens.panels.shopPanel;
import screens.panels.startPanel;

import javax.swing.*;
import java.awt.*;

import static screens.mainCard.*;

public class mainPanel {


    public static void switchPanel(String index){
        //card.show(mainPanel,index);
    }

    public static JPanel getMainPanel(){
        JPanel mainPanel = new JPanel();
        CardLayout card = getCard();
        mainPanel.setLayout(card);
        JPanel breakP = breakPanel.breakPanel();
        JPanel startP = startPanel.startPanel();
        JPanel shopP = shopPanel.shopPanel();
        JPanel menuP = new JPanel();


        JButton button1 = new JButton("Switch to Start");
        menuP.add(button1);
        button1.addActionListener(e -> card.show(mainPanel,"Start"));

        JButton button2 = new JButton("Switch to Break");
        menuP.add(button2);
        button2.addActionListener(e -> card.show(mainPanel,"Break"));

        JButton button3 = new JButton("Switch to Shop");
        menuP.add(button3);
        button3.addActionListener(e -> card.show(mainPanel,"Shop"));

        JButton buttonMain1 = new JButton("Back to Menu");
        buttonMain1.addActionListener(e -> card.show(mainPanel,"Menu"));
        startP.add(buttonMain1);

        JButton buttonMain2 = new JButton("Back to Menu");
        buttonMain2.addActionListener(e -> card.show(mainPanel,"Menu"));
        breakP.add(buttonMain2);

        JButton buttonMain3 = new JButton("Back to Menu");
        buttonMain3.addActionListener(e -> card.show(mainPanel,"Menu"));
        shopP.add(buttonMain3);

        mainPanel.add(menuP, "Menu");
        mainPanel.add(breakP, "Break");
        mainPanel.add(startP, "Start");
        mainPanel.add(shopP, "Shop");


        card.show(mainPanel, "Menu");
        return mainPanel;
    }

    public mainPanel(){
        JFrame frame = new JFrame();
        //CardLayout card = new CardLayout();
        JPanel mainPanel = getMainPanel();
        //mainPanel.setLayout(card);


        frame.add(mainPanel);
        //card.show(mainPanel, "Start");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("demo");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new mainPanel();
    }

}
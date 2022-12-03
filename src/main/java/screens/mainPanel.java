package screens;

import screens.panels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static screens.mainCard.*;

public class mainPanel implements ActionListener {

    public JPanel getMainPanel(){
        JPanel mainPanel = new JPanel();
        CardLayout card = getCard();
        mainPanel.setLayout(card);

        //get all panels
        JPanel breakP = breakPanel.breakPanel();
        JPanel startP = startPanel.startPanel();
        JPanel shopP = shopPanel.shopPanel();
        JPanel menuP = new JPanel();
        JPanel buyMenuP = buyMenuPanel.buyMenuPanel();
        JPanel sellMenuP = sellMenuPanel.sellMenuPanel();
        JPanel bossP = bossPanel.bossPanel();
        JPanel statsP = statsPanel.statsPanel();

        // all navigating buttons
        JButton menuToStart = new JButton("Start");
        menuP.add(menuToStart);
        menuToStart.addActionListener(e -> card.show(mainPanel,"Start"));

        JButton menuToBreak = new JButton("Break");
        menuP.add(menuToBreak);
        menuToBreak.addActionListener(e -> card.show(mainPanel,"Break"));

        JButton menuToShop = new JButton("Shop");
        menuP.add(menuToShop);
        menuToShop.addActionListener(e -> card.show(mainPanel,"Shop"));

        JButton menuToBoss = new JButton("Boss Fight");
        menuP.add(menuToBoss);
        menuToBoss.addActionListener(e -> card.show(mainPanel, "Boss"));

        JButton menuToStats = new JButton("Stats");
        menuP.add(menuToStats);
        menuToStats.addActionListener(e -> card.show(mainPanel, "Stats"));

        JButton shopMenuToBuyMenu = new JButton("Buy items");
        shopMenuToBuyMenu.addActionListener(e -> card.show(mainPanel, "Buy Menu"));
        shopP.add(shopMenuToBuyMenu);

        JButton buyMenuToShopMenu = new JButton("Back to Shop");
        buyMenuToShopMenu.addActionListener(e -> card.show(mainPanel, "Shop"));
        buyMenuP.add(buyMenuToShopMenu);


        JButton shopMenuToSellMenu = new JButton("Sell items");
        shopMenuToSellMenu.addActionListener(e -> card.show(mainPanel, "Sell Menu"));
        shopP.add(shopMenuToSellMenu);

        JButton sellMenuToShopMenu = new JButton("Back to Shop");
        sellMenuToShopMenu.addActionListener(e -> card.show(mainPanel, "Shop"));
        sellMenuP.add(sellMenuToShopMenu);

        JButton buttonMain1 = new JButton("Back to Menu");
        buttonMain1.addActionListener(e -> card.show(mainPanel, "Menu"));
        startP.add(buttonMain1);

        JButton buttonMain2 = new JButton("Back to Menu");
        buttonMain2.addActionListener(e -> card.show(mainPanel, "Menu"));
        breakP.add(buttonMain2);

        JButton buttonMain3 = new JButton("Back to Menu");
        buttonMain3.addActionListener(e -> card.show(mainPanel, "Menu"));
        shopP.add(buttonMain3);

        JButton runAway = new JButton("Run Away");
        runAway.addActionListener(e -> card.show(mainPanel, "Menu"));
        bossP.add(runAway);


        // add all panels
        mainPanel.add(menuP, "Menu");
        mainPanel.add(breakP, "Break");
        mainPanel.add(startP, "Start");
        mainPanel.add(shopP, "Shop");
        mainPanel.add(statsP, "Stats");
        mainPanel.add(buyMenuP, "Buy Menu");
        mainPanel.add(sellMenuP, "Sell Menu");
        mainPanel.add(bossP, "Boss");


        card.show(mainPanel, "Menu");

        return mainPanel;
    }

    public mainPanel(){
        JFrame frame = new JFrame();
        JPanel mainPanel = getMainPanel();

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("demo");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 500);
    }

    public static void main(String[] args){
        new mainPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
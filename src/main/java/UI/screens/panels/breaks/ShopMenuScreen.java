package UI.screens.panels.breaks;

import javax.swing.*;
import java.awt.*;
public class ShopMenuScreen extends JPanel {
    CardLayout card;
    JPanel parentPanel;

    //Frame frame;

    public ShopMenuScreen(CardLayout card, JPanel parentPanel) {
        this.card = card;
        this.parentPanel = parentPanel;
        JLabel title = new JLabel("Shop Menu");

        //frame = new Frame("Sell Menu Warning");
        CardLayout newCard = new CardLayout();
        JPanel newPanel = new JPanel();
        newPanel.setLayout(newCard);
        JPanel menuPanel = new JPanel();

        // ===== Initialise A Buy Menu =====
        JButton buyMenu = new JButton("Buy Items");
        buyMenu.addActionListener(e ->
            {BuyMenuScreen buyMenuScreen = new BuyMenuScreen(newCard, newPanel);
            newPanel.add(buyMenuScreen, "Buy Menu");
            newCard.show(newPanel, "Buy Menu");});

        // ===== Initialise A Sell Menu =====
        JButton sellMenu = new JButton("Sell Items");
        sellMenu.addActionListener(e ->
            {SellMenuScreen sellMenuScreen = new SellMenuScreen(newCard, newPanel);
            newPanel.add(sellMenuScreen, "Sell Menu");
            newCard.show(newPanel, "Sell Menu");}  );

//         SellMenuScreen sellMenuScreen = new SellMenuScreen(card, mainPanel);
//         mainPanel.add(sellMenuScreen, "Sell Menu");

//         JButton buyMenu = new JButton("Buy Items");
//         buyMenu.addActionListener(e -> card.show(parentPanel, "Buy Menu"));
//
//        JButton sellMenu = new JButton("Sell Items");
//        sellMenu.addActionListener(e -> JOptionPane.showMessageDialog(
//                frame, "The shop is currently not willing to buy your items!",
//                "Sell Menu Warning", JOptionPane.ERROR_MESSAGE));

        JButton backToBreak = new JButton("Back");
        backToBreak.addActionListener(e -> card.show(parentPanel, "Break"));

        menuPanel.add(title);
        menuPanel.add(buyMenu);
        menuPanel.add(sellMenu);
        menuPanel.add(backToBreak);
        newPanel.add(menuPanel, "Shop Menu");

        newCard.show(newPanel, "Shop Menu");
        this.add(newPanel);

    }
}

package UI.screens.panels.breaks;

import javax.swing.*;
import java.awt.*;

public class ShopMenuScreen extends JPanel {
    CardLayout card;
    JPanel parentPanel;

    Frame frame;

    public ShopMenuScreen(CardLayout card, JPanel parentPanel) {
        this.card = card;
        this.parentPanel = parentPanel;
        JLabel title = new JLabel("Shop Menu");
        this.add(title);

        frame = new Frame("Sell Menu Warning");

        //        SellMenuScreen sellMenuScreen = new SellMenuScreen(card, mainPanel);
        //        mainPanel.add(sellMenuScreen, "Sell Menu");



        JButton buyMenu = new JButton("Buy Items");
        buyMenu.addActionListener(e -> card.show(parentPanel, "Buy Menu"));

        JButton sellMenu = new JButton("Sell Items");
        sellMenu.addActionListener(e -> JOptionPane.showMessageDialog(
                frame, "The shop is currently not willing to buy your items!",
                "Sell Menu Warning", JOptionPane.ERROR_MESSAGE));

        JButton backToBreak = new JButton("Back");
        backToBreak.addActionListener(e -> card.show(parentPanel, "Break"));

        this.add(buyMenu);
        this.add(sellMenu);
        this.add(backToBreak);

    }
}

package UI.screens.panels.breaks;

import javax.swing.*;
import java.awt.*;

public class ShopMenuScreen extends JPanel {
    CardLayout card;
    JPanel parentPanel;

    public ShopMenuScreen(CardLayout card, JPanel parentPanel) {
        this.card = card;
        this.parentPanel = parentPanel;
        JLabel title = new JLabel("Shop Menu");
        this.add(title);

        JButton buyMenu = new JButton("Buy Items");
        buyMenu.addActionListener(e -> card.show(parentPanel, "Buy Menu"));

        JButton sellMenu = new JButton("Sell Items");
        sellMenu.addActionListener(e -> card.show(parentPanel, "Sell Menu"));

        JButton backToBreak = new JButton("Back");
        backToBreak.addActionListener(e -> card.show(parentPanel, "Break"));

        this.add(buyMenu);
        this.add(sellMenu);
        this.add(backToBreak);

    }
}

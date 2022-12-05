package UI.screens.panels.breaks;

import javax.swing.*;
import java.awt.*;

public class BreakScreen extends JPanel {
    CardLayout card;
    JPanel parentPanel;

    public BreakScreen(CardLayout card, JPanel parentPanel) {
        this.card = card;
        this.parentPanel = parentPanel;

        JLabel title = new JLabel("Time to take a break...");
        JButton buyMenu = new JButton("Shop");
        buyMenu.addActionListener(e -> card.show(parentPanel, "Shop Menu"));

        JButton sellMenu = new JButton("Sell your items");
        sellMenu.addActionListener(e -> card.show(parentPanel, "Sell Menu"));

        JButton fightBoss = new JButton("Fight Boss");
        fightBoss.addActionListener(e -> card.show(parentPanel,"Fight Boss"));

        JButton settings = new JButton("Settings");
        settings.addActionListener(e -> card.show(parentPanel, "Break Settings"));

        this.add(title);
        this.add(buyMenu);
        this.add(sellMenu);
        this.add(fightBoss);
        this.add(settings);
    }
}

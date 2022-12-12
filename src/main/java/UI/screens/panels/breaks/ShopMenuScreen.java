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

        JButton backToBreak = new JButton("Back");
        backToBreak.addActionListener(e -> card.show(parentPanel, "Break"));

        menuPanel.add(title);
        menuPanel.add(buyMenu);
        menuPanel.add(backToBreak);
        newPanel.add(menuPanel, "Shop Menu");

        newCard.show(newPanel, "Shop Menu");
        this.add(newPanel);

    }
}

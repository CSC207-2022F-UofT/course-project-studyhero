package UI.screens.panels.breaks;

import javax.swing.*;
import java.awt.*;

public class SellMenuScreen extends JPanel {
    CardLayout card;
    JPanel parentPanel;

    public SellMenuScreen(CardLayout card, JPanel parentPanel) {
        this.card = card;
        this.parentPanel = parentPanel;

        JLabel title = new JLabel("Sell Menu");
        this.add(title);

        JButton backToBreak = new JButton("Back");
        backToBreak.addActionListener(e -> card.show(parentPanel, "Break"));
        this.add(backToBreak);
    }
}

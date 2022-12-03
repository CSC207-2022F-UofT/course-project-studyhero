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

        JButton backToBreak = new JButton("Back");
        backToBreak.addActionListener(e -> card.show(parentPanel, "Break"));
        this.add(backToBreak);
    }
}

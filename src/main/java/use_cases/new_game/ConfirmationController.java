package use_cases.new_game;

import InventoryMenu.InventoryItem.InventoryList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmationController implements ActionListener {
    CardLayout card;
    JPanel parentPanel;
    JFrame parentFrame;

    public ConfirmationController(CardLayout card, JPanel parentPanel, JFrame parentFrame){
        this.card= card;
        this.parentPanel = parentPanel;
        this.parentFrame = parentFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new NewGame("stats.csv");
        new InventoryList("Inventory");
        parentFrame.dispose();
        card.show(parentPanel, "Story");
    }
}

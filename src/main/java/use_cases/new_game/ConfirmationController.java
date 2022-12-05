package use_cases.new_game;

import inventory_menu.inventory_item.InventoryList;

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
        new InventoryList("PlayerInventory.csv");
        parentFrame.dispose();
        card.show(parentPanel, "Story");
    }
}

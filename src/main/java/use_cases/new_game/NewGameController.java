package use_cases.new_game;

import InventoryMenu.InventoryItem.InventoryList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameController implements ActionListener {
    CardLayout card;
    JPanel parentPanel;

    public NewGameController(CardLayout card, JPanel parent){
        this.card = card;
        this.parentPanel = parent;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new NewGame("stats.csv");
        new InventoryList("Inventory");
        card.show(parentPanel, "Next");
    }
}

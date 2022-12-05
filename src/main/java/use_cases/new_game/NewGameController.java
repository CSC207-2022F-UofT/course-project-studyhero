package use_cases.new_game;

import InventoryMenu.InventoryItem.InventoryList;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidInventory;
import use_cases.file_checker.ValidStats;

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
        ErrorPresenter presenter = new ErrorPresenter();
        ValidStats statsFile = new ValidStats("stats.csv", presenter);
        ValidInventory inventoryFile = new ValidInventory("Inventory", presenter);
        if (statsFile.isPlayable() && inventoryFile.fileExists()){
            new NewGameConfirmation(card, parentPanel);
        }
        else{
            new NewGame("stats.csv");
            new InventoryList("Inventory");
            card.show(parentPanel, "Story");
        }
    }
}

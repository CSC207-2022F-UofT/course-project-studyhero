package use_cases.new_game;

import inventory_menu.inventory_item.InitializePlayerInventory;
import inventory_menu.inventory_item.InventoryList;
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
        ValidInventory inventoryFile = new ValidInventory("PlayerInventory.csv", presenter);
        if (statsFile.isPlayable() && inventoryFile.isPlayable()){
            new NewGameConfirmation(card, parentPanel);
        }
        else{
            new NewGame("stats.csv");
            new InventoryList("PlayerInventory.csv");
            card.show(parentPanel, "Story");
        }
    }
}

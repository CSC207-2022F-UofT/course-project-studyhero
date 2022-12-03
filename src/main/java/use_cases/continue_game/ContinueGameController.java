package use_cases.continue_game;

import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidInventory;
import use_cases.file_checker.ValidStats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContinueGameController implements ActionListener {
    CardLayout card;
    JPanel parent;
    ErrorPresenter presenter;

    public ContinueGameController(CardLayout card, JPanel parent,
                                  ErrorPresenter presenter){
        this.card = card;
        this.parent = parent;
        this.presenter = presenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ValidStats statsChecker = new ValidStats("stats.csv", presenter);
        ValidInventory inventoryChecker = new ValidInventory("Inventory", presenter);

        if (statsChecker.isValid() && inventoryChecker.isValid()){
            System.out.println("Game exists. Continuing to next game...");
            System.out.println("Current stats: " + statsChecker.load());
            card.show(parent, "Next");
        }
    }
}

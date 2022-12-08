package use_cases.continue_game;

import use_cases.errors.ErrorOutputBoundary;
import use_cases.file_checker.ValidInventory;
import use_cases.file_checker.ValidPlayerInventory;
import use_cases.file_checker.ValidStats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContinueGameController implements ActionListener {
    CardLayout card;
    JPanel parent;
    ErrorOutputBoundary presenter;

    public ContinueGameController(CardLayout card, JPanel parent, ErrorOutputBoundary presenter){
        this.card = card;
        this.parent = parent;
        this.presenter = presenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ValidStats statsChecker = new ValidStats("stats.csv", presenter);
        ValidPlayerInventory inventoryChecker = new ValidPlayerInventory("PlayerInventory.csv", presenter);

        System.out.println(statsChecker.isValid());

        if (statsChecker.isValid() && inventoryChecker.isValid()){
            System.out.println("Game exists. Continuing to next game...");
            System.out.println("Current stats: " + statsChecker.load());
            card.show(parent, "Timer");
        }
    }
}

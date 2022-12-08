package use_cases.new_game;

import use_cases.errors.ErrorOutputBoundary;
import use_cases.file_checker.ValidFileDsGateway;
import use_cases.file_checker.ValidPlayerInventory;
import use_cases.file_checker.ValidStats;
import use_cases.new_game.confirmation_window.ConfirmationWindowInteractor;
import use_cases.new_game.confirmation_window.ConfirmationWindowOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameCheckController implements ActionListener {
    CardLayout card;
    JPanel parentPanel;

    NewGameInputBoundary useCase;
    ValidFileDsGateway statsFile;
    ValidFileDsGateway inventoryFile;
    ErrorOutputBoundary presenter;


    public GameCheckController(CardLayout card, JPanel parentPanel, String stats,
                               String inventory, NewGameInputBoundary newGameInteractor,
                               ErrorOutputBoundary presenter){
        this.statsFile = new ValidStats("stats.csv",presenter);
        this.inventoryFile = new ValidPlayerInventory("PlayerInventory.csv", presenter);
        this.useCase = newGameInteractor;
        this.card = card;
        this.parentPanel = parentPanel;
        this.presenter = presenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (statsFile.isPlayable() && inventoryFile.isPlayable()){
            ConfirmationWindowInteractor confirmationWindowInteractor =
                    new ConfirmationWindowInteractor(
                            "Are you sure? This will overwrite your existing save files.",
                            card, parentPanel,presenter);
            ConfirmationWindowOutputBoundary window = confirmationWindowInteractor.createWindow();
            window.viewWindow();

        }
        else{
            useCase.newGame();
            card.show(parentPanel, "Story");
        }
    }
}

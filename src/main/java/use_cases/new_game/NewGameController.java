package use_cases.new_game;

import use_cases.game_check.GameCheckInputBoundary;
import use_cases.new_game.confirmation_window.ConfirmationWindowInputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameController implements ActionListener {
    CardLayout card;
    JPanel parentPanel;
    GameCheckInputBoundary gameCheckUseCase;
    NewGameInputBoundary newGameUseCase;
    ConfirmationWindowInputBoundary confirmationUseCase;

    /**
     * Creates a GameCheckController object that handles all use cases
     * involving the starting of a new game, including prompting the user
     * to reconfirm their decision if all necessary game files exist and
     * are valid.
     *
     * @param card                  layout manager to allow user to see the
     *                              next screen
     * @param parentPanel           panel in GameMain that uses the card and
     *                              contains the next screen
     * @param gameCheckUseCase      Checks for valid game files
     * @param newGameUseCase        Generates all necessary game files
     * @param confirmationUseCase   Presents to the user a confirmation window
     */
    public NewGameController(CardLayout card, JPanel parentPanel,
                             GameCheckInputBoundary gameCheckUseCase,
                             NewGameInputBoundary newGameUseCase,
                             ConfirmationWindowInputBoundary confirmationUseCase){
        this.gameCheckUseCase = gameCheckUseCase;
        this.newGameUseCase = newGameUseCase;
        this.card = card;
        this.parentPanel = parentPanel;
        this.confirmationUseCase = confirmationUseCase;
    }

    /**
     * In the event of a button click, if all necessary game files are valid and
     * creating a new game will overwrite them, a confirmation window will be
     * opened for the user to reconfirm that decision before proceeding.
     * If any necessary game file doesn't exist or is invalid, then all new files
     * will be generated, stored and the user will see the next screen (story).
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameCheckUseCase.check()){
            confirmationUseCase.createWindow();
        }
        else{
            newGameUseCase.newGame();
            card.show(parentPanel, "Story");
        }
    }
}
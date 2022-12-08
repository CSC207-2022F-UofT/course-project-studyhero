package use_cases.game_check;

import use_cases.errors.ErrorOutputBoundary;
import use_cases.new_game.NewGameInputBoundary;
import use_cases.new_game.confirmation_window.ConfirmationWindowInteractor;
import use_cases.new_game.confirmation_window.ConfirmationWindowOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameCheckController implements ActionListener {
    CardLayout card;
    JPanel parentPanel;
    GameCheckInputBoundary gameCheckUseCase;

    NewGameInputBoundary newGameUseCase;
    ErrorOutputBoundary presenter;
    private static final String confirmationMsg = "Are you sure? This will overwrite your existing save files.";



    public GameCheckController(CardLayout card, JPanel parentPanel,
                               GameCheckInputBoundary gameCheckUseCase,
                               NewGameInputBoundary newGameUseCase,
                               ErrorOutputBoundary presenter){
        this.gameCheckUseCase = gameCheckUseCase;
        this.newGameUseCase = newGameUseCase;
        this.card = card;
        this.parentPanel = parentPanel;
        this.presenter = presenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameCheckUseCase.check()){
            ConfirmationWindowInteractor confirmationWindowInteractor =
                    new ConfirmationWindowInteractor( confirmationMsg,card, parentPanel,presenter);
            ConfirmationWindowOutputBoundary window = confirmationWindowInteractor.createWindow();
            window.viewWindow();

        }
        else{
            newGameUseCase.newGame();
            card.show(parentPanel, "Story");
        }
    }
}

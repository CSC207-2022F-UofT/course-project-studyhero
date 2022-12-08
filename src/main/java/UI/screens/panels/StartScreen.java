package UI.screens.panels;

import use_cases.continue_game.ContinueGameController;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.new_game.GameCheckController;
import use_cases.new_game.NewGame;
import controllers.new_game.NewGameControllerOld;
import use_cases.new_game.confirmation_window.ConfirmationWindowInteractor;

import javax.swing.*;
import java.awt.*;

public class StartScreen extends JPanel{

    CardLayout card;
    JPanel parentPanel;
    ErrorOutputBoundary presenter;

    public StartScreen(CardLayout card, JPanel parent){

        this.card = card;
        this.parentPanel = parent;
        this.presenter = new ErrorPresenter();

        JLabel title = new JLabel("Start Game");

        //   ----- Buttons -----

        JButton newGameButton = new JButton("New Game");
        NewGame newGameUseCase = new NewGame(presenter);
        GameCheckController gameCheckController = new GameCheckController(card, parent, "stats.csv",
                "PlayerInventory.csv", newGameUseCase, presenter);
        newGameButton.addActionListener(gameCheckController);

        //ConfirmationWindowInteractor confirmationWindowInteractor = new ConfirmationWindowInteractor(card, parentPanel, false);
        //NewGameControllerOld newGameControllerOld =
        //        new NewGameControllerOld(card, parentPanel, newGameUseCase, confirmationWindowInteractor);
        //newGameButton.addActionListener(newGameControllerOld);

        JButton continueGameButton = new JButton("Continue Game");
        ContinueGameController continueGameController = new ContinueGameController(card, parent, presenter);
        continueGameButton.addActionListener(continueGameController);


        JButton goToSettingsButton = new JButton("Settings");
        goToSettingsButton.addActionListener(e -> card.show(parent, "Start Settings"));

        JButton quitGameButton = new JButton("Quit Game");
        quitGameButton.addActionListener(e -> System.exit(0));

        this.add(title);
        this.add(newGameButton);
        this.add(continueGameButton);
        this.add(goToSettingsButton);
        this.add(quitGameButton);

        this.setSize(800,500);
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
    }
}

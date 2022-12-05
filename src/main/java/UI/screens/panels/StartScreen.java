package UI.screens.panels;

import use_cases.continue_game.ContinueGameController;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.new_game.NewGame;
import controllers.new_game.NewGameController;

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
        NewGame newGameUseCase = new NewGame("stats.csv", presenter);
        NewGameController newGameController = new NewGameController(card, parentPanel, newGameUseCase);
        newGameButton.addActionListener(newGameController);

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

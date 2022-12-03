package UI.screens.panels;

import use_cases.continue_game.ContinueGameController;
import use_cases.errors.ErrorPresenter;
import use_cases.new_game.NewGameController;

import javax.swing.*;
import java.awt.*;

public class NewGameScreen extends JPanel{

    CardLayout card;
    JPanel parentPanel;
    ErrorPresenter cGRM;
    public NewGameScreen(CardLayout card, JPanel parent, ErrorPresenter cGRM){
        this.card = card;
        this.parentPanel = parent;
        this.cGRM = cGRM;

        JLabel title = new JLabel("Start Game");
        JButton newGameButton = new JButton("New Game");
        NewGameController newGameListener = new NewGameController(card, parent);
        newGameButton.addActionListener(newGameListener);

        JButton continueGameButton = new JButton("Continue Existing Game");
        ContinueGameController continueGameButtonListener =
                new ContinueGameController(card, parent, cGRM);
        continueGameButton.addActionListener(continueGameButtonListener);

        this.add(title);
        this.add(newGameButton);
        this.add(continueGameButton);

    }
}

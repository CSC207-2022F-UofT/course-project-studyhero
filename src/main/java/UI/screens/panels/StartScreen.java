package UI.screens.panels;

import use_cases.continue_game.ContinueGameController;
import use_cases.errors.ErrorPresenter;
import use_cases.new_game.NewGameController;

import javax.swing.*;
import java.awt.*;

public class StartScreen extends JPanel{

    CardLayout card;
    JPanel parentPanel;
    ErrorPresenter cGRM;

    public StartScreen(CardLayout card, JPanel parent, ErrorPresenter cGRM){

        this.card = card;
        this.parentPanel = parent;
        this.cGRM = cGRM;

        JLabel title = new JLabel("Start Game");

        //   ----- Buttons -----
        JButton newGameButton = new JButton("New Game");
        NewGameController newGameListener = new NewGameController(card, parent);
        newGameButton.addActionListener(newGameListener);

        JButton continueGameButton = new JButton("Continue Game");
        ContinueGameController continueGameButtonListener =
                new ContinueGameController(card, parent, cGRM);
        continueGameButton.addActionListener(continueGameButtonListener);

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

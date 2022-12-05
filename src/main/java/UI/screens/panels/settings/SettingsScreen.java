package UI.screens.panels.settings;

import entities.MusicPlayer;
import use_cases.errors.ErrorOutputBoundary;
import controllers.new_game.NewGameController;
import use_cases.new_game.NewGame;

import javax.swing.*;
import java.awt.*;

public class SettingsScreen extends JPanel {
    CardLayout card;
    JPanel parentPanel;
    ErrorOutputBoundary presenter;
    public SettingsScreen(CardLayout card, JPanel parentPanel,
                          ErrorOutputBoundary presenter, String prevPanel,
                          MusicPlayer player) {
        this.card = card;
        this.parentPanel = parentPanel;
        this.presenter = presenter;

        JLabel title = new JLabel("Settings");
        this.add(title);

        // ===== Main Controls =====
        JPanel mainControls = new JPanel();
        JButton newGameButton = new JButton("New Game");
        NewGame newGameInteractor = new NewGame("stats.csv", presenter);
        NewGameController newGameController = new NewGameController(card, parentPanel,newGameInteractor);
        newGameButton.addActionListener(newGameController);

        JButton goBackButton = new JButton("Back");
        goBackButton.addActionListener(e -> card.show(parentPanel, prevPanel));

        JButton quitButton = new JButton("Quit Game");
        quitButton.addActionListener(e -> System.exit(0));

        // ===== Music Controls =====
        MusicControlScreen musicControlScreen =
                new MusicControlScreen(card, parentPanel, player, mainControls);
        musicControlScreen.setVisible(false);

        JButton musicButton = new JButton("Music Controls");
        musicButton.addActionListener(e-> {
            musicControlScreen.setVisible(true);
            mainControls.setVisible(false);
        });
        mainControls.add(newGameButton);
        mainControls.add(musicButton);
        mainControls.add(goBackButton);
        mainControls.add(quitButton);

        this.add(mainControls);
        this.add(musicControlScreen);
    }

}

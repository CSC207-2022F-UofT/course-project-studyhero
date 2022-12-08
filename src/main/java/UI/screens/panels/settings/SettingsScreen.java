package UI.screens.panels.settings;

import entities.MusicPlayer;
import use_cases.errors.ErrorOutputBoundary;
import controllers.new_game.NewGameControllerOld;
import use_cases.new_game.NewGame;
import use_cases.new_game.confirmation_window.ConfirmationWindowInteractor;

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
        //ConfirmationWindowInteractor confirmation = new ConfirmationWindowInteractor(card, parentPanel, false);
        NewGame newGameInteractor = new NewGame( presenter);
        //NewGameControllerOld newGameControllerOld = new NewGameControllerOld(card, parentPanel, newGameInteractor, confirmation);
        //newGameButton.addActionListener(newGameControllerOld);

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

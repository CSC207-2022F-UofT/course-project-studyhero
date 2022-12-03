package UI.screens.panels.settings;

import entities.MusicPlayer;
import use_cases.music.PauseController;
import use_cases.music.PlayController;
import use_cases.music.RestartController;

import javax.swing.*;
import java.awt.*;

public class MusicControlScreen extends JPanel {
    CardLayout card;
    JPanel parent;
    MusicPlayer player;

    public MusicControlScreen(CardLayout card, JPanel parent,
                              MusicPlayer player, JPanel mainControls){
        this.card = card;
        this.parent = parent;
        this.player = player;


        JLabel title = new JLabel("Music");
        JButton playButton = new JButton("Play");
        PlayController playController = new PlayController(player);
        playButton.addActionListener(playController);

        JButton pauseButton = new JButton("Pause");
        PauseController pauseController = new PauseController(player);
        pauseButton.addActionListener(pauseController);

        JButton restartButton = new JButton("Restart");
        RestartController restartController = new RestartController(player);
        restartButton.addActionListener(restartController);

        JButton backToSettingsButton = new JButton("Back to Settings");
        backToSettingsButton.addActionListener(e-> {
            this.setVisible(false);
            mainControls.setVisible(true);});

        this.add(title);
        this.add(playButton);
        this.add(pauseButton);
        this.add(restartButton);
        this.add(backToSettingsButton);
    }

}

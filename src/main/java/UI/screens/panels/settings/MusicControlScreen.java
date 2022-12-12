package UI.screens.panels.settings;

import entities.MusicPlayer;
import controllers.music.PauseController;
import controllers.music.PlayController;
import controllers.music.RestartController;
import use_cases.music_controls.*;

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
        PlayMusicInputBoundary playMusic = new PlayMusic(player);
        PlayController playController = new PlayController(playMusic);
        playButton.addActionListener(playController);

        JButton pauseButton = new JButton("Pause");
        PauseMusicInputBoundary pauseMusic = new PauseMusic(player);
        PauseController pauseController = new PauseController(pauseMusic);
        pauseButton.addActionListener(pauseController);

        JButton restartButton = new JButton("Restart");
        RestartMusicInputBoundary restartMusic = new RestartMusic(player);
        RestartController restartController = new RestartController(restartMusic);
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

package controllers.music;

import entities.MusicPlayer;
import use_cases.music_controls.RestartMusicInputBoundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartController implements ActionListener {
    RestartMusicInputBoundary useCase;
    public RestartController(RestartMusicInputBoundary useCase){

        this.useCase = useCase;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        useCase.restartMusic();
    }
}

package controllers.music;

import entities.MusicPlayer;
import use_cases.music_controls.PauseMusicInputBoundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseController implements ActionListener {
    PauseMusicInputBoundary useCase;
    public PauseController(PauseMusicInputBoundary useCase){

        this.useCase = useCase;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        useCase.pauseMusic();
    }
}

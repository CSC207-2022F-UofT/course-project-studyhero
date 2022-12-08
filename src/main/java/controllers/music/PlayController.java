package controllers.music;

import use_cases.music_controls.PlayMusicInputBoundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayController implements ActionListener {

    PlayMusicInputBoundary useCase;
    public PlayController(PlayMusicInputBoundary useCase){
        this.useCase = useCase;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        useCase.playMusic();
    }
}

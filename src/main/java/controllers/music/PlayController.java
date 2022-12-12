package controllers.music;

import use_cases.music_controls.PlayMusicInputBoundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayController implements ActionListener {

    private final PlayMusicInputBoundary useCase;
    /**
     * Creates a new Play Controller that handles the playing of music
     * when a button is pressed.
     *
     * @param useCase the input boundary that can play music from the MusicPlayer
     */
    public PlayController(PlayMusicInputBoundary useCase){
        this.useCase = useCase;
    }

    /**
     * When button is pressed, leading to event e occurring, the input boundary will
     * play the music. If music is already being played, nothing will happen.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        useCase.playMusic();
    }
}

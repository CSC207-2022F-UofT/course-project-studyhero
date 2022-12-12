package settings.music.controllers;

import settings.music.usecases.RestartMusicInputBoundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartController implements ActionListener {
    private final RestartMusicInputBoundary useCase;

    /**
     * Creates a new RestartController that handles the restarting of music
     * when a button is pressed.
     *
     * @param useCase the input boundary that can restart the MusicPlayer
     */
    public RestartController(RestartMusicInputBoundary useCase){
        this.useCase = useCase;
    }

    /**
     * When button is pressed, leading to event e occurring, the input boundary will
     * restart the music.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        useCase.restartMusic();
    }
}

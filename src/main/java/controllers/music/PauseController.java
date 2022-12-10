package controllers.music;

import use_cases.music_controls.PauseMusicInputBoundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseController implements ActionListener {
    private final PauseMusicInputBoundary useCase;

    /**
     * Creates a new PauseController that handles the pausing of music
     * when a button is pressed.
     *
     * @param useCase the input boundary that can pause the MusicPlayer
     */
    public PauseController(PauseMusicInputBoundary useCase){

        this.useCase = useCase;
    }

    /**
     * When button is pressed, leading to event e occurring, the
     * input boundary will pause the music. If the music is already
     * paused, nothing will happen.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        useCase.pauseMusic();
    }
}

package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.CustomTimerController;
import UI.screens.timer_screen.PresetTimerController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for the ActionListener of PresetMediumButton.
 */
public class PresetMediumButtonListener implements ActionListener {
    private PresetTimerController ptController;
    private CustomTimerController ctController;
    private JLabel timerText;
    private JProgressBar progressBar;

    /**
     * Constructor for PresetMediumButtonListener.
     * @param ptController
     * @param ctController
     * @param timerText
     * @param progressBar
     */
    public PresetMediumButtonListener(PresetTimerController ptController, CustomTimerController ctController,
                                      JLabel timerText, JProgressBar progressBar) {
        this.ptController = ptController;
        this.ctController = ctController;
        this.timerText = timerText;
        this.progressBar = progressBar;
    }

    /**
     * Makes the timer use the Medium preset time.
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        ctController.setCustomTime("-1");
        ptController.selectMediumTime();
        String time = ptController.getMediumTime();
        timerText.setText(time);
        int totalSeconds = convertTimeToSeconds(time);
        progressBar.setMaximum(totalSeconds);
    }

    /**
     * Helper method that converts String time into the number of seconds that it equals.
     * @param time the time with format (00:00:00)
     * @return the number of seconds time equals
     */
    public int convertTimeToSeconds(String time) {
        String[] times = time.split(":", 3);
        int timeSeconds = Integer.parseInt(times[0])*3600 + Integer.parseInt(times[1])*60 + Integer.parseInt(times[2]);
        return timeSeconds;
    }
}

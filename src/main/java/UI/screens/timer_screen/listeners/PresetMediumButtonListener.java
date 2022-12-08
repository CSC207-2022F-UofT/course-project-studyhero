package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.ConvertTimeToSecondsHelper;
import UI.screens.timer_screen.CustomTimerController;
import UI.screens.timer_screen.PresetTimerController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for the ActionListener of PresetMediumButton.
 */
public class PresetMediumButtonListener implements ActionListener {
    PresetTimerController ptController;
    CustomTimerController ctController;
    JLabel timerText;
    JProgressBar progressBar;

    /**
     * Constructor for PresetMediumButtonListener.
     * @param ptController the PresetTimerController
     * @param ctController the CustomTimerController
     * @param timerText the label displaying the time
     * @param progressBar the progress bar on the timer screen
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
        ConvertTimeToSecondsHelper helper = new ConvertTimeToSecondsHelper();
        ctController.setCustomTime("-1");
        ptController.selectMediumTime();
        String time = ptController.getMediumTime();
        timerText.setText(time);
        int totalSeconds = helper.convertTimeToSeconds(time);
        progressBar.setMaximum(totalSeconds);
    }
}

package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.CustomTimerController;
import UI.screens.timer_screen.PresetTimerController;
import UI.screens.timer_screen.ConvertTimeToSecondsHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for the ActionListener of PresetShortButton.
 */
public class PresetShortButtonListener implements ActionListener {
    PresetTimerController ptController;
    CustomTimerController ctController;
    JLabel timerText;
    JProgressBar progressBar;

    /**
     * Constructor for PresetShortButtonListener.
     * @param ptController the PresetTimerController
     * @param ctController the CustomTimerController
     * @param timerText the label displaying the time
     * @param progressBar the progress bar on the timer screen
     */
    public PresetShortButtonListener(PresetTimerController ptController, CustomTimerController ctController,
                                     JLabel timerText, JProgressBar progressBar) {
        this.ptController = ptController;
        this.ctController = ctController;
        this.timerText = timerText;
        this.progressBar = progressBar;
    }

    /**
     * Makes the timer use the Short preset time.
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        ConvertTimeToSecondsHelper helper = new ConvertTimeToSecondsHelper();
        ctController.setCustomTime("-1");
        ptController.selectShortTime();
        String time = ptController.getShortTime();
        timerText.setText(time);
        int totalSeconds = helper.convertTimeToSeconds(time);
        progressBar.setMaximum(totalSeconds);
    }
}

package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.CustomTimerController;
import UI.screens.timer_screen.PresetTimerController;
import UI.screens.timer_screen.TimerPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for the ActionListener of PresetLongButton.
 */
public class PresetLongButtonListener implements ActionListener {
    private PresetTimerController ptController;
    private CustomTimerController ctController;
    private JLabel timerText;
    private JProgressBar progressBar;

    /**
     * Constructor for PresetLongButtonListener.
     * @param ptController
     * @param ctController
     * @param timerText
     * @param progressBar
     */
    public PresetLongButtonListener(PresetTimerController ptController, CustomTimerController ctController,
                                    JLabel timerText, JProgressBar progressBar) {
        this.ptController = ptController;
        this.ctController = ctController;
        this.timerText = timerText;
        this.progressBar = progressBar;
    }

    /**
     * Makes the timer use the Long preset time.
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        ctController.setCustomTime("-1");
        ptController.selectLongTime();
        String time = ptController.getLongTime();
        timerText.setText(time);
        int totalSeconds = TimerPanel.convertTimeToSeconds(time);
        progressBar.setMaximum(totalSeconds);
    }
}

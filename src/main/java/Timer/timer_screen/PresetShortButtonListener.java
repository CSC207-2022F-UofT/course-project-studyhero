package Timer.timer_screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresetShortButtonListener implements ActionListener {
    private PresetTimerController ptController;
    private CustomTimerController ctController;
    private JLabel timerText;
    private JProgressBar progressBar;

    public PresetShortButtonListener(PresetTimerController ptController, CustomTimerController ctController, JLabel timerText, JProgressBar progressBar) {
        this.ptController = ptController;
        this.ctController = ctController;
        this.timerText = timerText;
        this.progressBar = progressBar;
    }

    public void actionPerformed(ActionEvent e) {
        ctController.setCustomTime("-1");
        ptController.selectShortTime();
        String time = ptController.getShortTime();
        timerText.setText(time);
        int totalSeconds = TimerPanel.convertTimeToInt(time);
        progressBar.setMaximum(totalSeconds);
    }
}

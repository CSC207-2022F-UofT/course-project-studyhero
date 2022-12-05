package Timer.timer_screen;

import Timer.timer_use_cases.TimerRequestModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndTimerButtonListener implements ActionListener {
    private TimerRequestModel tRequestModel;
    private PresetTimerController ptController;
    private CustomTimerController ctController;
    private Timer timer;
    private JLabel timerText;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tRequestModel.getCustomTime().equals("-1")) {
            ptController.endTimer();
        }
        else {
            ctController.endTimer();
        }
        timer.stop();
        timerText.setText("00:00:00");
    }
}

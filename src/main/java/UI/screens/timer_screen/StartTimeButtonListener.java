package UI.screens.timer_screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Timer.timer_use_cases.TimerRequestModel;

public class StartTimeButtonListener implements ActionListener {

    private TimerRequestModel tRequestModel;
    private PresetTimerController ptController;
    private CustomTimerController ctController;
    private Timer timer;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tRequestModel.getCustomTime().equals("-1")) {
            ptController.startTimer();
        } else {
            ctController.startTimer();
        }
        timer.start();
    }
}

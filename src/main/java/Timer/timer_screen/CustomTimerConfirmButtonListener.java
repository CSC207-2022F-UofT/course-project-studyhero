package Timer.timer_screen;

import Timer.timer_use_cases.TimerRequestModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomTimerConfirmButtonListener implements ActionListener {
    private TimerRequestModel tRequestModel;
    private PresetTimerController ptController;
    private CustomTimerController ctController;
    private CustomTimerTextField customTimerTextField;
    private JLabel timerText;
    private int totalTime;


    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

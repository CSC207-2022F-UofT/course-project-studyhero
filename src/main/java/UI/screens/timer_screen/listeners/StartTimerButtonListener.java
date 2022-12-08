package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.CustomTimerController;
import UI.screens.timer_screen.PresetTimerController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartTimerButtonListener implements ActionListener {
    private PresetTimerController ptController;
    private CustomTimerController ctController;
    private Timer timer;
    private JButton customTimerConfirmButton;
    private JButton presetLongButton;
    private JButton presetMediumButton;
    private JButton presetShortButton;
    private JButton startTimerButton;
    private JFormattedTextField customTimerTextField;

    public StartTimerButtonListener(PresetTimerController ptController, CustomTimerController ctController, Timer timer, JButton customTimerConfirmButton, JButton presetLongButton, JButton presetMediumButton, JButton presetShortButton, JButton startTimerButton, JFormattedTextField customTimerTextField) {
        this.ptController = ptController;
        this.ctController = ctController;
        this.timer = timer;
        this.customTimerConfirmButton = customTimerConfirmButton;
        this.presetLongButton = presetLongButton;
        this.presetMediumButton = presetMediumButton;
        this.presetShortButton = presetShortButton;
        this.startTimerButton = startTimerButton;
        this.customTimerTextField = customTimerTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ctController.getCustomTime().equals("-1")) {
            ptController.startTimer();
        } else {
            ctController.startTimer();
        }
        timer.start();
        customTimerConfirmButton.setEnabled(false);
        presetLongButton.setEnabled(false);
        presetMediumButton.setEnabled(false);
        presetShortButton.setEnabled(false);
        startTimerButton.setEnabled(false);
        customTimerTextField.setEnabled(false);
    }
}

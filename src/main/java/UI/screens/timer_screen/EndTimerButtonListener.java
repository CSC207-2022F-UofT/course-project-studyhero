package UI.screens.timer_screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndTimerButtonListener implements ActionListener {
    private PresetTimerController ptController;
    private CustomTimerController ctController;
    private Timer timer;
    private JLabel timerText;
    private JButton goToBreakMenuButton;
    private JButton customTimerConfirmButton;
    private JButton presetLongButton;
    private JButton presetMediumButton;
    private JButton presetShortButton;
    private JButton startTimerButton;
    private JFormattedTextField customTimerTextField;

    public EndTimerButtonListener(PresetTimerController ptController, CustomTimerController ctController, Timer timer, JLabel timerText, JButton goToBreakMenuButton, JButton customTimerConfirmButton, JButton presetLongButton, JButton presetMediumButton, JButton presetShortButton, JButton startTimerButton, JFormattedTextField customTimerTextField) {
        this.ptController = ptController;
        this.ctController = ctController;
        this.timer = timer;
        this.timerText = timerText;
        this.goToBreakMenuButton = goToBreakMenuButton;
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
            ptController.endTimer();
        }
        else {
            ctController.endTimer();
        }
        timer.stop();
        timerText.setText("00:00:00");
        goToBreakMenuButton.setVisible(true);
        customTimerConfirmButton.setEnabled(true);
        presetLongButton.setEnabled(true);
        presetMediumButton.setEnabled(true);
        presetShortButton.setEnabled(true);
        startTimerButton.setEnabled(true);
        customTimerTextField.setEnabled(true);
    }
}

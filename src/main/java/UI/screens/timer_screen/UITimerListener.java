package UI.screens.timer_screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static UI.screens.timer_screen.TimerPanel.convertTimeToInt;

public class UITimerListener implements ActionListener {
    private JLabel timerText;
    private TimerPresenter tPresenter;
    private JProgressBar progressBar;
    private JButton goToBreakMenuButton;
    private JButton customTimerConfirmButton;
    private JButton presetLongButton;
    private JButton presetMediumButton;
    private JButton presetShortButton;
    private JButton startTimerButton;
    private JFormattedTextField customTimerTextField;

    public UITimerListener(JLabel timerText, TimerPresenter tPresenter, JProgressBar progressBar, JButton goToBreakMenuButton, JButton customTimerConfirmButton, JButton presetLongButton, JButton presetMediumButton, JButton presetShortButton, JButton startTimerButton, JFormattedTextField customTimerTextField) {
        this.timerText = timerText;
        this.tPresenter = tPresenter;
        this.progressBar = progressBar;
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
        timerText.setText(tPresenter.getOutputTime());
        progressBar.setValue(progressBar.getMaximum() - convertTimeToInt(tPresenter.getOutputTime()));
        if ((tPresenter.getOutputTime()).equals("00:00:00")) {
            goToBreakMenuButton.setVisible(true);
            customTimerConfirmButton.setEnabled(true);
            presetLongButton.setEnabled(true);
            presetMediumButton.setEnabled(true);
            presetShortButton.setEnabled(true);
            startTimerButton.setEnabled(true);
            customTimerTextField.setEnabled(true);
        }
        else {
            goToBreakMenuButton.setVisible(false);
        }
    }
}

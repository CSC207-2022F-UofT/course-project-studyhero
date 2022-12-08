package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.TimerPresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static UI.screens.timer_screen.TimerPanel.convertTimeToSeconds;

/**
 * Class for the ActionListener of the timer in TimerPanel.
 */
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
    private JButton endTimerButton;

    /**
     * Constructor for UITimerListener.
     * @param timerText
     * @param tPresenter
     * @param progressBar
     * @param goToBreakMenuButton
     * @param customTimerConfirmButton
     * @param presetLongButton
     * @param presetMediumButton
     * @param presetShortButton
     * @param startTimerButton
     * @param customTimerTextField
     * @param endTimerButton
     */
    public UITimerListener(JLabel timerText, TimerPresenter tPresenter, JProgressBar progressBar,
                           JButton goToBreakMenuButton, JButton customTimerConfirmButton, JButton presetLongButton,
                           JButton presetMediumButton, JButton presetShortButton, JButton startTimerButton,
                           JFormattedTextField customTimerTextField, JButton endTimerButton) {
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
        this.endTimerButton = endTimerButton;
    }

    /**
     * Updates the time displayed and progressBar, and changes the interactability of some elements if
     * the timer is finished.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        timerText.setText(tPresenter.getOutputTime());
        progressBar.setValue(progressBar.getMaximum() - convertTimeToSeconds(tPresenter.getOutputTime()));
        if ((tPresenter.getOutputTime()).equals("00:00:00")) {
            goToBreakMenuButton.setVisible(true);
            customTimerConfirmButton.setEnabled(true);
            presetLongButton.setEnabled(true);
            presetMediumButton.setEnabled(true);
            presetShortButton.setEnabled(true);
            startTimerButton.setEnabled(true);
            customTimerTextField.setEnabled(true);
            endTimerButton.setEnabled(false);
        }
        else {
            goToBreakMenuButton.setVisible(false);
        }
    }
}

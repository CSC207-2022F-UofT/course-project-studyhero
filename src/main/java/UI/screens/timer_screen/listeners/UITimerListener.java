package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.CustomTimerController;
import UI.screens.timer_screen.PresetTimerController;
import UI.screens.timer_screen.TimerPanel;
import UI.screens.timer_screen.TimerPresenter;
import UI.screens.timer_screen.ConvertTimeToSecondsHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for the ActionListener of the timer in TimerPanel.
 */
public class UITimerListener implements ActionListener {
    PresetTimerController presetTimerController;
    CustomTimerController customTimerController;
    JLabel timerText;
    TimerPresenter tPresenter;
    JProgressBar progressBar;
    JButton goToBreakMenuButton;
    JButton customTimerConfirmButton;
    JButton presetLongButton;
    JButton presetMediumButton;
    JButton presetShortButton;
    JButton startTimerButton;
    JFormattedTextField customTimerTextField;
    JButton endTimerButton;
    TimerPanel timerPanel;

    /**
     * Constructor for UITimerListener.
     *
     * @param timerText the label displaying the time
     * @param tPresenter the presenter for timer
     * @param progressBar the progress bar on the timer screen
     * @param goToBreakMenuButton the break menu button on the timer screen
     * @param customTimerConfirmButton the confirm button on the timer screen
     * @param presetLongButton the long preset button on the timer screen
     * @param presetMediumButton the medium preset button on the timer screen
     * @param presetShortButton the short button on the timer screen
     * @param startTimerButton the start timer button on the timer screen
     * @param customTimerTextField the text field on the timer screen
     * @param endTimerButton the end timer button on the timer screen
     * @param timerPanel the panel for timer
     */
    public UITimerListener(PresetTimerController presetTimerController, CustomTimerController customTimerController,
                           JLabel timerText, TimerPresenter tPresenter, JProgressBar progressBar,
                           JButton goToBreakMenuButton, JButton customTimerConfirmButton, JButton presetLongButton,
                           JButton presetMediumButton, JButton presetShortButton, JButton startTimerButton,
                           JFormattedTextField customTimerTextField, JButton endTimerButton, TimerPanel timerPanel) {
        this.presetTimerController = presetTimerController;
        this.customTimerController = customTimerController;
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
        this.timerPanel = timerPanel;
    }

    /**
     * Updates the time displayed and progressBar, and changes the interactability of some elements if
     * the timer is finished.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ConvertTimeToSecondsHelper helper = new ConvertTimeToSecondsHelper();
        timerText.setText(tPresenter.getOutputTime());
        progressBar.setValue(progressBar.getMaximum() - helper.convertTimeToSeconds(tPresenter.getOutputTime()));
        if ((tPresenter.getOutputTime()).equals("00:00:00")) {
            if (customTimerController.getCustomTime().equals("-1")) {
                presetTimerController.endTimer();
            }
            else {
                customTimerController.endTimer();
            }
            timerPanel.timer.stop();
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

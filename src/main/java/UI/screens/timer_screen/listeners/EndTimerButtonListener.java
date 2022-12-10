package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.CustomTimerController;
import UI.screens.timer_screen.PresetTimerController;
import UI.screens.timer_screen.SetInteractabilityHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for the ActionListener of EndTimerButton.
 */
public class EndTimerButtonListener implements ActionListener {
    /**
     * Controller for the preset portion of timer.
     */
    PresetTimerController ptController;
    /**
     * Controller for the custom portion of timer.
     */
    CustomTimerController ctController;
    /**
     * Elements that will be affected.
     */
    Timer timer;
    JLabel timerText;
    JButton goToBreakMenuButton;
    JButton customTimerConfirmButton;
    JButton presetLongButton;
    JButton presetMediumButton;
    JButton presetShortButton;
    JButton startTimerButton;
    JFormattedTextField customTimerTextField;
    JButton endTimerButton;

    /**
     * Constructor for EndTimerButtonListener.
     * @param ptController the PresetTimerController
     * @param ctController the CustomTimerController
     * @param timer the timer being stopped
     * @param timerText the label displaying the time
     * @param goToBreakMenuButton the break menu button on the timer screen
     * @param customTimerConfirmButton the confirm button on the timer screen
     * @param presetLongButton the long preset button on the timer screen
     * @param presetMediumButton the medium preset button on the timer screen
     * @param presetShortButton the short button on the timer screen
     * @param startTimerButton the start timer button on the timer screen
     * @param customTimerTextField the text field on the timer screen
     * @param endTimerButton the end timer button on the timer screen
     */
    public EndTimerButtonListener(PresetTimerController ptController, CustomTimerController ctController, Timer timer,
                                  JLabel timerText, JButton goToBreakMenuButton, JButton customTimerConfirmButton,
                                  JButton presetLongButton, JButton presetMediumButton, JButton presetShortButton,
                                  JButton startTimerButton, JFormattedTextField customTimerTextField,
                                  JButton endTimerButton) {
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
        this.endTimerButton = endTimerButton;
    }

    /**
     * Ends the timer, sets the time to 00:00:00, and changes the interactability of some elements.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ctController.endTimer();
        timer.stop();
        timerText.setText("00:00:00");
        goToBreakMenuButton.setVisible(true);
        SetInteractabilityHelper setInteractabilityHelper = new SetInteractabilityHelper(customTimerConfirmButton,
                presetLongButton, presetMediumButton, presetShortButton, startTimerButton, customTimerTextField,
                endTimerButton);
        setInteractabilityHelper.setInteractability(true);
    }
}

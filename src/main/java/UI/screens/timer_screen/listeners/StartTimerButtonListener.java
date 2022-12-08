package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.CustomTimerController;
import UI.screens.timer_screen.PresetTimerController;
import UI.screens.timer_screen.SetInteractabilityHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for the ActionListener of StartTimerButton.
 */
public class StartTimerButtonListener implements ActionListener {
    PresetTimerController ptController;
    CustomTimerController ctController;
    Timer timer;
    JButton customTimerConfirmButton;
    JButton presetLongButton;
    JButton presetMediumButton;
    JButton presetShortButton;
    JButton startTimerButton;
    JFormattedTextField customTimerTextField;
    JButton endTimerButton;

    /**
     * Constructor for StartTimerButtonListener.
     * @param ptController the PresetTimerController
     * @param ctController the CustomTimerController
     * @param timer the timer being stopped
     * @param customTimerConfirmButton the confirm button on the timer screen
     * @param presetLongButton the long preset button on the timer screen
     * @param presetMediumButton the medium preset button on the timer screen
     * @param presetShortButton the short button on the timer screen
     * @param startTimerButton the start timer button on the timer screen
     * @param customTimerTextField the text field on the timer screen
     * @param endTimerButton the end timer button on the timer screen
     */
    public StartTimerButtonListener(PresetTimerController ptController, CustomTimerController ctController, Timer timer,
                                    JButton customTimerConfirmButton, JButton presetLongButton,
                                    JButton presetMediumButton, JButton presetShortButton, JButton startTimerButton,
                                    JFormattedTextField customTimerTextField, JButton endTimerButton) {
        this.ptController = ptController;
        this.ctController = ctController;
        this.timer = timer;
        this.customTimerConfirmButton = customTimerConfirmButton;
        this.presetLongButton = presetLongButton;
        this.presetMediumButton = presetMediumButton;
        this.presetShortButton = presetShortButton;
        this.startTimerButton = startTimerButton;
        this.customTimerTextField = customTimerTextField;
        this.endTimerButton = endTimerButton;
    }

    /**
     * Starts the timer and changes the interactability of some elements.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (ctController.getCustomTime().equals("-1")) {
            ptController.startTimer();
        } else {
            ctController.startTimer();
        }
        timer.start();

        SetInteractabilityHelper setInteractabilityHelper = new SetInteractabilityHelper(customTimerConfirmButton,
                presetLongButton, presetMediumButton, presetShortButton, startTimerButton, customTimerTextField,
                endTimerButton);
        setInteractabilityHelper.setInteractability(false);
    }
}

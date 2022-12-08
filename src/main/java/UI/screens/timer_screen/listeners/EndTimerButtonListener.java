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
    private PresetTimerController ptController;
    /**
     * Controller for the custom portion of timer.
     */
    private CustomTimerController ctController;
    /**
     * Elements that will be affected.
     */
    private final Timer timer;
    private final JLabel timerText;
    private final JButton goToBreakMenuButton;
    private JButton customTimerConfirmButton;
    private JButton presetLongButton;
    private JButton presetMediumButton;
    private JButton presetShortButton;
    private JButton startTimerButton;
    private JFormattedTextField customTimerTextField;
    private JButton endTimerButton;

    /**
     * Constructor for EndTimerButtonListener.
     * @param ptController
     * @param ctController
     * @param timer
     * @param timerText
     * @param goToBreakMenuButton
     * @param customTimerConfirmButton
     * @param presetLongButton
     * @param presetMediumButton
     * @param presetShortButton
     * @param startTimerButton
     * @param customTimerTextField
     * @param endTimerButton
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
        if (ctController.getCustomTime().equals("-1")) {
            ptController.endTimer();
        }
        else {
            ctController.endTimer();
        }
        timer.stop();
        timerText.setText("00:00:00");
        goToBreakMenuButton.setVisible(true);
        SetInteractabilityHelper setInteractabilityHelper = new SetInteractabilityHelper(customTimerConfirmButton,
                presetLongButton, presetMediumButton, presetShortButton, startTimerButton, customTimerTextField,
                endTimerButton);
        setInteractabilityHelper.setInteractability(true);
    }
}

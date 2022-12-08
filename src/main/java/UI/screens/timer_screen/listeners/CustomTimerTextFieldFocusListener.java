package UI.screens.timer_screen.listeners;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Class for the FocusListener of CustomTimerTextField.
 */
public class CustomTimerTextFieldFocusListener implements FocusListener {
    private JFormattedTextField customTimerTextField;

    /**
     * Constructor for CustomTimerTextFieldFocusListener.
     * @param customTimerTextField
     */
    public CustomTimerTextFieldFocusListener(JFormattedTextField customTimerTextField) {
        this.customTimerTextField = customTimerTextField;
    }

    /**
     * Allows customTimerTextField to be edited when focus is on it.
     * @param e the event to be processed
     */
    @Override
    public void focusGained(FocusEvent e) {
        customTimerTextField.setEnabled(true);
    }

    /**
     * Allows customTimerTextField to be edited when focus is not on it.
     * @param e the event to be processed
     */
    @Override
    public void focusLost(FocusEvent e) {
        customTimerTextField.setEnabled(true);
    }
}

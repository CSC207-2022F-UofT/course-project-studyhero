package UI.screens.timer_screen.listeners;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 * Class for the CaretListener of CustomTimerTextField.
 */
public class CustomTimerTextFieldCaretListener implements CaretListener {
    private JFormattedTextField customTimerTextField;

    /**
     * Constructor for CustomTimerTextFieldCaretListener.
     * @param customTimerTextField
     */
    public CustomTimerTextFieldCaretListener(JFormattedTextField customTimerTextField) {
        this.customTimerTextField = customTimerTextField;
    }

    /**
     * Adds ":" when the length of input in customTimerTextField equals 2 or 5 and also limits the maximum length to 8.
     * @param e the caret event
     */
    @Override
    public void caretUpdate(CaretEvent e) {
        int textLength = customTimerTextField.getText().length();
        if (textLength == 2 || textLength == 5) {
            SwingUtilities.invokeLater (new Runnable() {
                public void run() {
                    customTimerTextField.setText(customTimerTextField.getText() + ":");
                }
            });
        }
        if (textLength >= 9) {
            SwingUtilities.invokeLater (new Runnable() {
                public void run() {
                    customTimerTextField.setText(customTimerTextField.getText().substring(0, 8));
                }
            });
        }
    }
}

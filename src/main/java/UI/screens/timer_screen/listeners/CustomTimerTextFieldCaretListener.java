package UI.screens.timer_screen.listeners;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class CustomTimerTextFieldCaretListener implements CaretListener {
    private JFormattedTextField customTimerTextField;

    public CustomTimerTextFieldCaretListener(JFormattedTextField customTimerTextField) {
        this.customTimerTextField = customTimerTextField;
    }

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

package UI.screens.timer_screen;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CustomTimerTextFieldFocusListener implements FocusListener {
    public CustomTimerTextFieldFocusListener(JFormattedTextField customTimerTextField) {
        this.customTimerTextField = customTimerTextField;
    }

    private JFormattedTextField customTimerTextField;

    @Override
    public void focusGained(FocusEvent e) {
        customTimerTextField.setEnabled(true);
    }

    @Override
    public void focusLost(FocusEvent e) {
        customTimerTextField.setEnabled(true);
    }
}

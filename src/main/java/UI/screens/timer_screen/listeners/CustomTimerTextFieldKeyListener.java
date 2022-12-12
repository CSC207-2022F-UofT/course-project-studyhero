package UI.screens.timer_screen.listeners;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class for the KeyListener of CustomTimerTextField.
 */
public class CustomTimerTextFieldKeyListener implements KeyListener {
    JFormattedTextField customTimerTextField;

    /**
     * Constructor for CustomTimerTextFieldKeyListener.
     * @param customTimerTextField the text field being listened to
     */
    public CustomTimerTextFieldKeyListener(JFormattedTextField customTimerTextField) {
        this.customTimerTextField = customTimerTextField;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Ensures that only numbers are entered into customTimerTextField.
     * @param ke the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        customTimerTextField.setEditable(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' ||
                ke.getKeyCode() == KeyEvent.VK_BACK_SPACE);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

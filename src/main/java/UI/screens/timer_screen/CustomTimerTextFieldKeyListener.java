package Timer.timer_screen;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CustomTimerTextFieldKeyListener implements KeyListener {
    private JFormattedTextField customTimerTextField;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            customTimerTextField.setEditable(true);
        } else {
            customTimerTextField.setEditable(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

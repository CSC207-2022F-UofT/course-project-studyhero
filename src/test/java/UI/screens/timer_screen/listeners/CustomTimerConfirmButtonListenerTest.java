package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.TimerPanel;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class CustomTimerConfirmButtonListenerTest {

    @Test
    void validTimeTest() {
        CardLayout card = new CardLayout();
        JPanel panel = new JPanel();
        panel.setLayout(card);
        TimerPanel tp = new TimerPanel(card, panel);
        ActionEvent e = new ActionEvent(new Object(), 1, "confirm");
        tp.customTimerTextField.setText("00:25:00");
        CustomTimerConfirmButtonListener customTimerConfirmButtonListener = new CustomTimerConfirmButtonListener(
                tp.customTimerController, tp.customTimerTextField, tp.timerText, tp.progressBar, tp.errorLabel);
        customTimerConfirmButtonListener.actionPerformed(e);
        assertEquals("00:25:00", tp.timerText.getText());
    }

    @Test
    void invalidTimeTest() {
        CardLayout card = new CardLayout();
        JPanel panel = new JPanel();
        panel.setLayout(card);
        TimerPanel tp = new TimerPanel(card, panel);
        ActionEvent e = new ActionEvent(new Object(), 1, "confirm");
        tp.customTimerTextField.setText("-00:25:00");
        CustomTimerConfirmButtonListener customTimerConfirmButtonListener = new CustomTimerConfirmButtonListener(
                tp.customTimerController, tp.customTimerTextField, tp.timerText, tp.progressBar, tp.errorLabel);
        customTimerConfirmButtonListener.actionPerformed(e);
        assertTrue(tp.errorLabel.isVisible());
    }
}
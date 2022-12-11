package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.TimerPanel;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class StartTimerButtonListenerTest {

    @Test
    void actionPerformed() {
        CardLayout card = new CardLayout();
        JPanel panel = new JPanel();
        panel.setLayout(card);
        TimerPanel tp = new TimerPanel(card, panel);
        ActionEvent e = new ActionEvent(new Object(), 1, "start");
        StartTimerButtonListener startTimerButtonListener = new StartTimerButtonListener(tp.presetTimerController,
                tp.customTimerController, tp.timer, tp.customTimerConfirmButton, tp.presetLongButton,
                tp.presetMediumButton, tp.presetShortButton, tp.startTimerButton, tp.customTimerTextField,
                tp.endTimerButton);
        assertDoesNotThrow(() -> startTimerButtonListener.actionPerformed(e));
        assertTrue(tp.timer.isRunning());
        assertFalse(tp.customTimerConfirmButton.isEnabled());
        assertFalse(tp.presetLongButton.isEnabled());
        assertFalse(tp.presetMediumButton.isEnabled());
        assertFalse(tp.presetShortButton.isEnabled());
        assertFalse(tp.startTimerButton.isEnabled());
        assertFalse(tp.customTimerTextField.isEnabled());
        assertTrue(tp.endTimerButton.isEnabled());
    }
}
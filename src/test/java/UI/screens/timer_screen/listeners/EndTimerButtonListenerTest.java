package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.TimerPanel;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class EndTimerButtonListenerTest {

    @Test
    void endTimerTest() {
        CardLayout card = new CardLayout();
        JPanel panel = new JPanel();
        panel.setLayout(card);
        TimerPanel tp = new TimerPanel(card, panel);
        ActionEvent e = new ActionEvent(new Object(), 1, "end");
        EndTimerButtonListener endTimerButtonListener = new EndTimerButtonListener(tp.presetTimerController,
                tp.customTimerController, tp.timer, tp.timerText, tp.breakMenuButton, tp.customTimerConfirmButton, tp.presetLongButton,
                tp.presetMediumButton, tp.presetShortButton, tp.startTimerButton, tp.customTimerTextField,
                tp.endTimerButton);
        tp.presetTimerController.selectShortTime();
        tp.presetTimerController.startTimer();
        endTimerButtonListener.actionPerformed(e);
        assertFalse(tp.timer.isRunning());
        assertTrue(tp.customTimerConfirmButton.isEnabled());
        assertTrue(tp.presetLongButton.isEnabled());
        assertTrue(tp.presetMediumButton.isEnabled());
        assertTrue(tp.presetShortButton.isEnabled());
        assertTrue(tp.startTimerButton.isEnabled());
        assertTrue(tp.customTimerTextField.isEnabled());
        assertFalse(tp.endTimerButton.isEnabled());
    }
}
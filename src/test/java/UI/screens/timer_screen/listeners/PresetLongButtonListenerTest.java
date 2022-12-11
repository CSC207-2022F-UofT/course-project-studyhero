package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.TimerPanel;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class PresetLongButtonListenerTest {

    @Test
    void presetLongButtonTest() {
        CardLayout card = new CardLayout();
        JPanel panel = new JPanel();
        panel.setLayout(card);
        TimerPanel tp = new TimerPanel(card, panel);
        ActionEvent e = new ActionEvent(new Object(), 1, "long");
        PresetLongButtonListener presetLongButtonListener = new PresetLongButtonListener(tp.presetTimerController,
                tp.customTimerController, tp.timerText, tp.progressBar);
        presetLongButtonListener.actionPerformed(e);
        assertEquals("01:00:00", tp.timerText.getText());
    }
}
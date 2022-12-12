package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.TimerPanel;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class PresetMediumButtonListenerTest {

    @Test
    void presetMediumButtonTest() {
        CardLayout card = new CardLayout();
        JPanel panel = new JPanel();
        panel.setLayout(card);
        TimerPanel tp = new TimerPanel(card, panel);
        ActionEvent e = new ActionEvent(new Object(), 1, "medium");
        PresetMediumButtonListener presetMediumButtonListener = new PresetMediumButtonListener(tp.presetTimerController,
                tp.customTimerController, tp.timerText, tp.progressBar);
        presetMediumButtonListener.actionPerformed(e);
        assertEquals("00:30:00", tp.timerText.getText());
    }
}
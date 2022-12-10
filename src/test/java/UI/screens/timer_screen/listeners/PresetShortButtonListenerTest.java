package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.TimerPanel;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PresetShortButtonListenerTest {

    @Test
    void actionPerformed() {
        CardLayout card = new CardLayout();
        JPanel panel = new JPanel();
        panel.setLayout(card);
        TimerPanel timerPanel = new TimerPanel(card, panel);
        assertDoesNotThrow(() -> timerPanel.presetShortButton.doClick());
        assertEquals("00:15:00", timerPanel.timerText.getText());
    }
}
package UI.screens.timer_screen.listeners;

import UI.screens.timer_screen.TimerPanel;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CustomTimerConfirmButtonListenerTest {

    @Test
    void actionPerformed() {
        CardLayout card = new CardLayout();
        JPanel panel = new JPanel();
        panel.setLayout(card);
        TimerPanel timerPanel = new TimerPanel(card, panel);
        timerPanel.customTimerTextField.setText("00:25:00");
        assertDoesNotThrow(() -> timerPanel.customTimerConfirmButton.doClick());
        assertEquals("00:25:00", timerPanel.timerText.getText());
    }
}
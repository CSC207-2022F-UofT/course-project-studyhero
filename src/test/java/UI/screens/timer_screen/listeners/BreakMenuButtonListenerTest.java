package UI.screens.timer_screen.listeners;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class BreakMenuButtonListenerTest {

    @Test
    void actionPerformedTest() {
        CardLayout card = new CardLayout();
        JPanel panel = new JPanel();
        panel.setLayout(card);
        ActionEvent e = new ActionEvent(new Object(), 1, "break");
        BreakMenuButtonListener breakMenuButtonListener = new BreakMenuButtonListener(card, panel);
        assertDoesNotThrow(() -> breakMenuButtonListener.actionPerformed(e));
    }
}
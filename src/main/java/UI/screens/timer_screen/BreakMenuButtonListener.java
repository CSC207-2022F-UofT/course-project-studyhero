package UI.screens.timer_screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BreakMenuButtonListener implements ActionListener {
    CardLayout card;
    JPanel parentPanel;

    public BreakMenuButtonListener(CardLayout card, JPanel parentPanel) {
        this.card = card;
        this.parentPanel = parentPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.card.show(parentPanel, "Break");
    }
}

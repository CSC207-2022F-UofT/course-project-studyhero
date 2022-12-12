package UI.screens.timer_screen.listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for the ActionListener of BreakMenuButton.
 */
public class BreakMenuButtonListener implements ActionListener {
    /**
     * Layout that allows the user to switch between panels.
     */
    CardLayout card;
    /**
     * The panel that contains all panels.
     */
    JPanel parentPanel;

    /**
     * Constructor for BreakMenuButtonListener.
     * @param card layout that allows the user to switch between panels
     * @param parentPanel the panel that contains all panels
     */
    public BreakMenuButtonListener(CardLayout card, JPanel parentPanel) {
        this.card = card;
        this.parentPanel = parentPanel;
    }

    /**
     * Switches to the Break Menu panel when the button is clicked.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        card.show(parentPanel, "Break");
    }
}

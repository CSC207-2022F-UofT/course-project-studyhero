package controllers.breaks;

import UI.screens.panels.breaks.SellMenuScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellMenuScreenController implements ActionListener {
    private final CardLayout card;
    private final JPanel panel;

    /**
     * Creates a SellMenuScreenController object that handles the
     * creation of a new SellMenuScreen.
     *
     * @param card  layout of where the new screen will be stored
     * @param panel panel where the new screen will be stored
     */
    public SellMenuScreenController(CardLayout card, JPanel panel){
        this.card = card;
        this.panel = panel;
    }

    /**
     * Upon the click of a button with event e, creates a new
     * SellMenuScreen and adds/overwrites(if any) it into the
     * panel. Then uses the card to show the screen to the user.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        SellMenuScreen sellMenuScreen = new SellMenuScreen(card, panel);
        panel.add(sellMenuScreen, "Sell Menu");
        card.show(panel, "Sell Menu");
    }
}

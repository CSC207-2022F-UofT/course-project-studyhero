package controllers.breaks;

import UI.screens.panels.breaks.BuyMenuScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BuyMenuScreenController implements ActionListener {
    private final CardLayout card;
    private final JPanel panel;

    /**
     * Creates a BuyMenuScreenController object that handles the
     * creation of a new BuyMenuScreen.
     *
     * @param card  layout of where the new screen will be stored
     * @param panel panel where the new screen will be stored
     */
    public BuyMenuScreenController(CardLayout card, JPanel panel){
        this.card = card;
        this.panel = panel;
    }

    /**
     * Upon the click of a button with event e, creates a new
     * BuyMenuScreen and adds/overwrites(if any) it into the
     * panel. Then uses the card to show the screen to the user.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        BuyMenuScreen buyMenuScreen = new BuyMenuScreen(card, panel);
        panel.add(buyMenuScreen, "Buy Menu");
        card.show(panel, "Buy Menu");
    }
}

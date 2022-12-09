package controllers.breaks;

import UI.screens.panels.FightBossScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FightBossScreenController implements ActionListener {
    private final CardLayout card;
    private final JPanel panel;

    /**
     * Creates a FightBossScreenController object that handles the
     * creation of a new FightBossScreen.
     *
     * @param card  layout of where the new screen will be stored
     *              (card of the break screen)
     * @param panel panel where the new screen will be stored
     *              (break screen)
     */
    public FightBossScreenController(CardLayout card, JPanel panel){
        this.card = card;
        this.panel = panel;
    }

    /**
     * Upon the click of a button with event e, creates a new
     * FightBossScreen and adds/overwrites(if any) it into the
     * panel. Then uses the card to show the screen to the user.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        FightBossScreen fightBossScreen = new FightBossScreen(card, panel);
        panel.add(fightBossScreen, "Fight Boss");
        card.show(panel, "Fight Boss");
    }
}

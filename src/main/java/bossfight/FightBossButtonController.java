package bossfight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An overwrite of the ActionListener from JButtons. It is the controller that controls what happens after the Fight
 * Boss button is pressed
 */
public class FightBossButtonController implements ActionListener {
    FightBossInteractor fightBossInteractor;

    CardLayout card;
    JPanel mainPanel;

    /**
     * Constructor for setting up the "Fight Boss" button available to the user on the Break Menu Panel. Sets up the
     * screen panel and the screen card for FightBoss
     * @param card: Layout manager for the main game's JPanel
     * @param mainPanel: Stores the JPanel for FightBossScreen.java (this was created in the main panel)
     */
    public FightBossButtonController(CardLayout card, JPanel mainPanel) {
        this.card = card;
        this.mainPanel = mainPanel;
    }

    /**
     * Creates a new FightBossInteractor in order to use the initialize function within it to set up the fightStats.csv
     * file, basically resetting it to baseline values for both the boss and player
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e){
        fightBossInteractor = new FightBossInteractor(card, mainPanel);
        fightBossInteractor.initializeFightingStats();
        card.show(mainPanel,"Fight Boss");
    }
}

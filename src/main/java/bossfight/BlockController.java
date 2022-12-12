package bossfight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An overwrite of the ActionListener from JButtons. It is the controller that controls what happens after the Block
 * button is pressed
 */
public class BlockController implements ActionListener {


    FightBossInteractor fightBossInteractor;

    CardLayout card;
    JPanel mainPanel;
    JLabel HPBar;
    JLabel BossHP;

    FightBossStatsDisplayInteractor fightBossStatsDisplayInteractor;

    /**
     * Constructor for setting up the block button available for the user to interact with on the FightBossScreen
     * Calls FightBossInteractor to calculate if the player won with that move, then repaints the screen accordingly
     * The parameters are taken only to repaint the panel with new health points
     * @param card: Layout manager for the main game's JPanel
     * @param mainPanel: Stores the JPanel for FightBossScreen.java
     * @param HPBar: The JLabel responsible for displaying the players health
     * @param BossHP: The JLabel responsible for displaying the boss' health
     */
    public BlockController(CardLayout card, JPanel mainPanel, JLabel HPBar, JLabel BossHP) {
        this.card = card;
        this.mainPanel = mainPanel;
        this.HPBar = HPBar;
        this.BossHP = BossHP;
        this.fightBossStatsDisplayInteractor = new FightBossStatsDisplayInteractor();
    }

    /**
     * Runs when the button is clicked. Creates a new FightBossInteractor and enters the value of the button clicked to
     * find out what the new health points to be displayed are, then adjusts them accordingly and repaints the JPanel.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        fightBossInteractor = new FightBossInteractor(card, mainPanel);
        fightBossInteractor.fighter(2);
        fightBossStatsDisplayInteractor = new FightBossStatsDisplayInteractor();
        System.out.println(fightBossStatsDisplayInteractor.getPlayerHealth());
        this.HPBar.setText("HP: " + fightBossStatsDisplayInteractor.getPlayerHealth());
        this.BossHP.setText("Boss HP: " + fightBossStatsDisplayInteractor.getBossHealth());
        mainPanel.repaint();
    }
}

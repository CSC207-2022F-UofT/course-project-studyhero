package UI.screens.panels;

import use_cases.boss_fight.*;

import javax.swing.*;
import java.awt.*;

/**
 * This is the JPanel class for the BossFight which is initialized from the BreakScreen when the user decides to play the boss
 * fight mini-game. It displays the temporary health of both the player and the boss, and has 3 buttons consisting of
 * moves that the player can make, and a button to return the player to the BreakScreen should they wish to leave the
 * fight.
 */
public class FightBossScreen extends JPanel {
    CardLayout card;
    JPanel parentPanel;
    FightBossStatsDisplayInteractor fightBossStatsDisplayInteractorInitializer;
    FightBossStatsDisplayInteractor fightBossStatsDisplayInteractor;

    /**
     * This is the constructor for the FightBossScreen which uses different JLabels and JButtons to display the
     * @param card: Layout manager for the main game's JPanel
     * @param parentPanel:  Stores the JPanel for FightBossScreen.java
     */
    public FightBossScreen(CardLayout card, JPanel parentPanel) {
        this.card = card;
        this.parentPanel = parentPanel;
        //Setting up DisplayInteractor to change the HP values
        this.fightBossStatsDisplayInteractor = new FightBossStatsDisplayInteractor();
        //Setting up the Initial DisplayInteractor to show HP values at the top
        this.fightBossStatsDisplayInteractorInitializer = new FightBossStatsDisplayInteractor("stats.csv");

        JPanel mainPanel = new JPanel();

        //JLabel's being added to the Panel to showcase text
        JLabel title = new JLabel("Fight!");
        JPanel HPPanel = new JPanel();
        JLabel HPBar = new JLabel("HP: " + this.fightBossStatsDisplayInteractorInitializer.getPlayerHealth());
        HPPanel.add(HPBar);
        JPanel bossHPPanel = new JPanel();
        JLabel bossHP = new JLabel("Boss HP: " + this.fightBossStatsDisplayInteractorInitializer.getBossHealth());
        bossHPPanel.add(bossHP);

        //Moving the location of the JLabel's
        JPanel topPanel = new JPanel();
        topPanel.add(HPPanel);
        topPanel.add(bossHPPanel);

        //This has been commented out because we decided that trying to create a use consumable button and interaction
        //would be too difficult to implement by the due date
        /* bottom panel including buttons to use consumable, stab, block, slash */
        JPanel bottomPanel = new JPanel();
        /* JButton useConsumableButton = new JButton("Use Consumable"); */


        // Setting up buttons and listeners (aka the button controllers) to be displayed on the screen
        //Passing in the card, the panel, and the JLabels that will have to be updated everytime a button is clicked
        JButton stabButton = new JButton("Stab");
        StabController stabController = new StabController(this.card, this.parentPanel, HPBar, bossHP);
        stabButton.addActionListener(stabController);
        JButton slashButton = new JButton("Slash");
        SlashController slashController = new SlashController(this.card, this.parentPanel, HPBar, bossHP);
        slashButton.addActionListener(slashController);
        JButton blockButton = new JButton("Block");
        BlockController blockController = new BlockController(this.card, this.parentPanel, HPBar, bossHP);
        blockButton.addActionListener(blockController);
        // bottomPanel.add(useConsumableButton);

        //Adding said buttons to the bottom panel
        bottomPanel.add(stabButton);
        bottomPanel.add(slashButton);
        bottomPanel.add(blockButton);

        //Setting up the layout of the mainPanel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        //Back button to
        JButton backToTimer = new JButton("Back");
        backToTimer.addActionListener(e -> card.show(parentPanel,"Timer"));

        this.add(title);
        this.add(mainPanel);
        this.add(backToTimer);
    }


}

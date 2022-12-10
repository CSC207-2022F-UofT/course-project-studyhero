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
     * @param card
     * @param parentPanel
     */
    public FightBossScreen(CardLayout card, JPanel parentPanel) {
        this.card = card;
        this.parentPanel = parentPanel;
        this.fightBossStatsDisplayInteractor = new FightBossStatsDisplayInteractor();
        this.fightBossStatsDisplayInteractorInitializer = new FightBossStatsDisplayInteractor("stats.csv");

        JPanel mainPanel = new JPanel();

        JLabel title = new JLabel("Fight!");
        JPanel HPPanel = new JPanel();
        JLabel HPBar = new JLabel("HP: " + this.fightBossStatsDisplayInteractorInitializer.getPLayerHealth());
        HPPanel.add(HPBar);
        JPanel bossHPPanel = new JPanel();
        JLabel bossHP = new JLabel("Boss HP: " + this.fightBossStatsDisplayInteractorInitializer.getBossHealth());
        bossHPPanel.add(bossHP);

        JPanel topPanel = new JPanel();
        topPanel.add(HPPanel);
        topPanel.add(bossHPPanel);

        //bottom panel including buttons to use consumable, stab, block, slash
        JPanel bottomPanel = new JPanel();
        // JButton useConsumableButton = new JButton("Use Consumable");


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
        bottomPanel.add(stabButton);
        bottomPanel.add(slashButton);
        bottomPanel.add(blockButton);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        JButton backToTimer = new JButton("Back");
        backToTimer.addActionListener(e -> card.show(parentPanel,"Timer"));

        this.add(title);
        this.add(mainPanel);
        this.add(backToTimer);
    }


}

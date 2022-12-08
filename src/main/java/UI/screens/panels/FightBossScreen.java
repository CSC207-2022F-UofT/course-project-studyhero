package UI.screens.panels;

import use_cases.boss_fight.*;

import javax.swing.*;
import java.awt.*;


public class FightBossScreen extends JPanel {
    CardLayout card;
    JPanel parentPanel;
    FightBossStatsDisplayInteractor fightBossStatsDisplayInteractorInitializer;
    FightBossStatsDisplayInteractor fightBossStatsDisplayInteractor;

    public FightBossScreen(CardLayout card, JPanel parentPanel) {
        this.card = card;
        this.parentPanel = parentPanel;
        //this.fightBossStatsDisplayInteractor = new FightBossStatsDisplayInteractor();
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
        StabController stabController = new StabController();
        stabButton.addActionListener(stabController);
        stabController.changeText().getBossHealth();


        JButton slashButton = new JButton("Slash");
        SlashController slashController = new SlashController();
        slashButton.addActionListener(slashController);
        JButton blockButton = new JButton("Block");
        BlockController blockController = new BlockController();
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

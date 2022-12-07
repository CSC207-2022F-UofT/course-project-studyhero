package UI.screens.panels;

import javax.swing.*;
import java.awt.*;


public class FightBossScreen extends JPanel {
    CardLayout card;
    JPanel parentPanel;

    public FightBossScreen(CardLayout card, JPanel parentPanel) {
        this.card = card;
        this.parentPanel = parentPanel;

        JPanel mainPanel = new JPanel();

        JLabel title = new JLabel("Fight!");
        JPanel HPPanel = new JPanel();
        JLabel HPBar = new JLabel("HP: 0");
        HPPanel.add(HPBar);

        JPanel timerPanel = new JPanel();
        JLabel timer = new JLabel("Timer");
        timerPanel.add(timer);

        JPanel bossHPPanel = new JPanel();
        JLabel bossHP = new JLabel("Boss HP: ");
        bossHPPanel.add(bossHP);

        JPanel topPanel = new JPanel();
        topPanel.add(HPPanel);
        topPanel.add(timerPanel);
        topPanel.add(bossHPPanel);

        //bottom panel including buttons to use consumable, stab, block, slash
        JPanel bottomPanel = new JPanel();
        JButton useConsumableButton = new JButton("Use Consumable");
        JButton slashButton = new JButton("Slash");
        JButton stabButton = new JButton("Stab");
        JButton blockButton = new JButton("Block");
        bottomPanel.add(useConsumableButton);
        bottomPanel.add(slashButton);
        bottomPanel.add(stabButton);
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

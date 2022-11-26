package screens.panels;

import javax.swing.*;
import java.awt.*;

import static UI.buttons.boss_fight.blockButton.getBlockButton;
import static UI.buttons.boss_fight.slashButton.getSlashButton;
import static UI.buttons.boss_fight.stabButton.getStabButton;
import static UI.buttons.boss_fight.useConsumableButton.getUseConsumableButton;

public class bossPanel {
    public static JPanel bossPanel(){
        JLabel text = new JLabel("Boss Fight Screen");
        JPanel bossPanel = new JPanel();

        // top panel including user hp, timer, boss hp
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
        bottomPanel.add(getUseConsumableButton());
        bottomPanel.add(getSlashButton());
        bottomPanel.add(getStabButton());
        bottomPanel.add(getBlockButton());

        bossPanel.add(topPanel, BorderLayout.NORTH);
        bossPanel.add(bottomPanel, BorderLayout.SOUTH);

        return bossPanel;

    }
}

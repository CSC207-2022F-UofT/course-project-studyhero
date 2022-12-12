package use_cases.boss_fight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlashController implements ActionListener {

    FightBossInteractor fightBossInteractor;

    CardLayout card;
    JPanel mainPanel;

    JLabel HPBar;
    JLabel BossHP;

    FightBossStatsDisplayInteractor fightBossStatsDisplayInteractor;

    public SlashController(CardLayout card, JPanel mainPanel, JLabel HPBar, JLabel BossHP) {
        this.card = card;
        this.mainPanel = mainPanel;
        this.HPBar = HPBar;
        this.BossHP = BossHP;
        this.fightBossStatsDisplayInteractor = new FightBossStatsDisplayInteractor();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        fightBossInteractor = new FightBossInteractor(card, mainPanel);
        fightBossInteractor.fighter(1);
        fightBossStatsDisplayInteractor = new FightBossStatsDisplayInteractor();
        System.out.println(fightBossStatsDisplayInteractor.getPLayerHealth());
        this.HPBar.setText("HP: " + fightBossStatsDisplayInteractor.getPLayerHealth());
        this.BossHP.setText("Boss HP: " + fightBossStatsDisplayInteractor.getBossHealth());
        mainPanel.repaint();
    }
}

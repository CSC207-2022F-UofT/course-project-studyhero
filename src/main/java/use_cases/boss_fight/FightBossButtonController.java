package use_cases.boss_fight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FightBossButtonController implements ActionListener {
    FightBossInteractor fightBossInteractor;

    CardLayout card;
    JPanel mainPanel;

    public FightBossButtonController(CardLayout card, JPanel mainPanel) {
        this.card = card;
        this.mainPanel = mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        fightBossInteractor = new FightBossInteractor(card, mainPanel);
        fightBossInteractor.initializeFightingStats();
        card.show(mainPanel,"Fight Boss");
    }
}

package UI.buttons.boss_fight;

import bossfight.FightBossInteractor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class stabButtonListener implements ActionListener {
    FightBossInteractor fightBoss;
    @Override
    public void actionPerformed(ActionEvent e) {
        fightBoss.fighter(0);
    }
}

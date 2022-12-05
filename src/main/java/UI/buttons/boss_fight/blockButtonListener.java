package UI.buttons.boss_fight;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import bossfight.FightBossInteractor;

public class blockButtonListener implements ActionListener {
    FightBossInteractor fightBoss;
    @Override
    public void actionPerformed(ActionEvent e) {
        fightBoss.fighter(2);
    }
}

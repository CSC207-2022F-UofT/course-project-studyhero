package use_cases.boss_fight;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlashController implements ActionListener {
    FightBossInteractor fightBossInteractor;

    @Override
    public void actionPerformed(ActionEvent e) {
        fightBossInteractor.fighter(1);
    }
}

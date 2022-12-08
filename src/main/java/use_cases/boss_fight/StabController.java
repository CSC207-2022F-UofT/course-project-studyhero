package use_cases.boss_fight;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StabController implements ActionListener {
    FightBossInteractor fightBossInteractor;

    FightBossStatsDisplayInteractor fightBossStatsDisplayInteractor;

    @Override
    public void actionPerformed(ActionEvent e) {
        fightBossInteractor.fighter(0);
    }

    public FightBossStatsDisplayInteractor changeText(){
        fightBossStatsDisplayInteractor = new FightBossStatsDisplayInteractor();
        return fightBossStatsDisplayInteractor;
    }

}

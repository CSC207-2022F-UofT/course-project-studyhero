package bossfight;

import java.util.ArrayList;

public class FightBossInteractor {
    FightWinner fightWinner;
    int playerTempDamage;
    int bossTempDamage;
    StatsUpdateInteractor statsUpdateInteractor;

    public FightBossInteractor() {
        this.fightWinner = new FightWinner();
        this.statsUpdateInteractor = new StatsUpdateInteractor();
        this.playerTempDamage = statsUpdateInteractor.getPlayerDamage();
        this.bossTempDamage = statsUpdateInteractor.getBossDamage();
    }

    public void fighter(int value){
        int bossInput = bossMoveMaker();
        ArrayList<Integer> winner = fightWinner.winner(value, bossInput);
        statsUpdateInteractor.changePlayerHp(-(winner.get(0) * bossTempDamage +));
        statsUpdateInteractor.changeBossHp(-(winner.get(1) * playerTempDamage));
        WinCondition(statsUpdateInteractor.getPlayerHp, statsUpdateInteractor.getBossHp);
    }

    public int bossMoveMaker() {
        return GenerateRandom.generator();
    }
}


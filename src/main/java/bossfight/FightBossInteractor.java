package bossfight;

import entities.CurrentFightingStats;

import java.util.ArrayList;

public class FightBossInteractor {
    FightWinner fightWinner;
    int playerTempDamage;
    int bossTempDamage;

    CurrentFightingStats currentFightingStats;

    public FightBossInteractor() {
        this.fightWinner = new FightWinner();
        currentFightingStats = new CurrentFightingStats();
    }

    public void fighter(int value){
        int bossInput = bossMoveMaker();
        ArrayList<Integer> winner = fightWinner.winner(value, bossInput);
        currentFightingStats.changePlayerHP(-(winner.get(0) * bossTempDamage));
        currentFightingStats.changeBossHP(-(winner.get(1) * playerTempDamage));
        // WinCondition(currentFightingStats.getPlayerHP, currentFightingStats.getBossHP);
    }

    public int bossMoveMaker() {
        return GenerateRandom.generator();
    }

}


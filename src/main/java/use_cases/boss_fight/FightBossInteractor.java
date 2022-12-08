package use_cases.boss_fight;

import entities.CurrentFightingStats;

import java.util.ArrayList;

public class FightBossInteractor {
    FightWinner fightWinner;

    CurrentFightingStats currentFightingStats;

    public FightBossInteractor() {
        this.fightWinner = new FightWinner();
        this.currentFightingStats = new CurrentFightingStats();
    }

    public void saveFightingStats(){
        currentFightingStats.saveFightStats();
    }

    public void fighter(int value){
        int bossInput = bossMoveMaker();
        ArrayList<Integer> winner = fightWinner.winner(value, bossInput);
        currentFightingStats.changePlayerHP(-(winner.get(0) * currentFightingStats.getBossDamage()));
        currentFightingStats.changeBossHP(-(winner.get(1) * currentFightingStats.getPlayerDamage()));
        saveFightingStats();
        int endGame = currentFightingStats.winCondition();
    }

    public int bossMoveMaker() {
        return GenerateRandom.generator();
    }

}


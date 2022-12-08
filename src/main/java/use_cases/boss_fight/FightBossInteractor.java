package use_cases.boss_fight;

import entities.CurrentFightingStats;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FightBossInteractor {
    FightWinner fightWinner;

    CurrentFightingStats currentFightingStats;
    CardLayout card;
    JPanel mainPanel;



    public FightBossInteractor(CardLayout card, JPanel mainPanel) {
        this.fightWinner = new FightWinner();
        this.currentFightingStats = new CurrentFightingStats();
        this.card = card;
        this.mainPanel = mainPanel;
    }

    public void initializeFightingStats(){
        currentFightingStats.initializeFight("stats.csv");
    }

    public void saveFightingStats(){
        System.out.println(currentFightingStats.getFightStats());
        currentFightingStats.saveFightStats();
    }

    public void fighter(int value){
        int bossInput = bossMoveMaker();
        ArrayList<Integer> winner = fightWinner.winner(value, bossInput);
        currentFightingStats.changePlayerHP(-(winner.get(0) * currentFightingStats.getBossDamage()));
        currentFightingStats.changeBossHP(-(winner.get(1) * currentFightingStats.getPlayerDamage()));
        saveFightingStats();
        int endGame = currentFightingStats.winCondition();
        new FightDone(endGame, this.card, this.mainPanel);

    }

    public int bossMoveMaker() {
        return GenerateRandom.generator();
    }

}


package use_cases.boss_fight;

import entities.CurrentFightingStats;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * An interactor that finds the winner of the combat, changes health points, and returns the player to the break menu
 * should a win condition be met
 */
public class FightBossInteractor {
    FightWinner fightWinner;

    CurrentFightingStats currentFightingStats;
    CardLayout card;
    JPanel mainPanel;


    /**
     * Constructor for setting up all the values needed in FightBossInteractor in order for it to calculate the winner
     * of every move using helper classes.
     * @param card: Layout manager for the main game's JPanel
     * @param mainPanel: Stores the JPanel for FightBossScreen.java
     */
    public FightBossInteractor(CardLayout card, JPanel mainPanel) {
        this.fightWinner = new FightWinner();
        this.currentFightingStats = new CurrentFightingStats();
        this.card = card;
        this.mainPanel = mainPanel;
    }

    /**
     * Calls the initialize function within CurrentFightingStats to set up the most recently updated stats.
     */
    public void initializeFightingStats(){
        currentFightingStats.initializeFight("stats.csv");
    }

    /**
     * Calls the save function within CurrentFightingStats to save the most recently updated stats.
     */
    public void saveFightingStats(){
        currentFightingStats.saveFightStats();
    }

    /**
     * Calculates the winner of combat using the value of which button the player selected, and a randomly generated
     * value from the boss. Then, it calculates the damage using the values from CurrentFightingStats and whether the
     * corresponding health should be changed or not, then changes the player and boss health in CurrenFightingStats
     * and saves them to the file. It then checks if there is any winner, then sends the input to FightDone.
     * @param value: the value received from one of 3 controllers stating which move the player took
     */
    public void fighter(int value){
        int bossInput = bossMoveMaker();
        ArrayList<Integer> winner = fightWinner.winner(value, bossInput);
        currentFightingStats.changePlayerHP(-(winner.get(0) * currentFightingStats.getBossDamage()));
        currentFightingStats.changeBossHP(-(winner.get(1) * currentFightingStats.getPlayerDamage()));
        saveFightingStats();
        int endGame = currentFightingStats.winCondition();
        new FightDone(endGame, this.card, this.mainPanel);

    }

    /**
     * Generates a random move the boss will take
     * @return the randomized value stating which move the boss took
     */
    public int bossMoveMaker() {
        return GenerateRandom.generator();
    }

}


package use_cases.boss_fight;

import entities.StatsUser;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidStats;
import use_cases.save_game.StatSave;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * A helper interactor that runs when a win condition is met, and updates game files and panels accordingly
 */
public class FightDone {
    private final CardLayout card;
    private final JPanel mainPanel;
    private final String newFile;

    private StatsUser player;

    /**
     * Constructor for setting up what happens when either the player or the boss health reaches zero
     * @param winner: value of whether the player or the boss won
     * @param card: Layout manager for the main game's JPanel
     * @param mainPanel: Stores the JPanel for FightBossScreen.java
     */
    public FightDone(int winner, CardLayout card, JPanel mainPanel){
        new HashMap<>();
        this.newFile = "stats.csv";
        this.card = card;
        this.mainPanel = mainPanel;
        if (winner == 2){
            playerWin();
        } else if (winner == 1){
            bossWin();
        }

    }

    /**
     * When the condition that the player has won is met, the panel is changed back to the Break Menu panel, and the
     * player level is updated
     */
    public void playerWin(){
        card.show(mainPanel, "Break");
        ErrorPresenter presenter = new ErrorPresenter();
        ValidStats playerStats = new ValidStats(newFile, presenter);
        if (playerStats.isPlayable()) {
            Map<String, Integer> statsMap = playerStats.load();
            this.player = new StatsUser(statsMap);
            player.getUserStats();
        }

        player.updateLevel();

        StatSave statSave = new StatSave(player.getUserStats(), presenter);
        statSave.save("stats.csv");

    }

    /**
     * When the condition that the boss has won is met, the panel is changed back to the Break Menu panel
     */
    public void bossWin(){
        card.show(mainPanel, "Break");
    }
}

package use_cases.boss_fight;

import entities.CurrentFightingStats;

/**
 * A display interactor that sets up the CurrentFightingStats entity and gets the player health and boss health so
 * they can update the panel with new values
 */
public class FightBossStatsDisplayInteractor {
    CurrentFightingStats currentFightingStats;

    /**
     * Constructor that sets up a CurrentFightingStats entity
     */
    public FightBossStatsDisplayInteractor() {
        this.currentFightingStats = new CurrentFightingStats();
    }

    /**
     * Constructor with parameter that sets up a CurrentFightingStats entity with a parameter
     * @param csv: String with the path of the csv file
     */
    public FightBossStatsDisplayInteractor(String csv) {
        this.currentFightingStats = new CurrentFightingStats(csv);
    }

    /**
     * Returns the values of the player health as a string to be displayed
     * @return The health of the player as a string
     */
    public String getPlayerHealth(){
        return String.valueOf(currentFightingStats.getPlayerHP());
    }

    /**
     * Returns the values of the boss health as a string to be displayed
     * @return The health of the boss as a string
     */
    public String getBossHealth(){
        return String.valueOf(currentFightingStats.getBossHP());
    }


}

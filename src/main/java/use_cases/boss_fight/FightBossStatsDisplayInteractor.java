package use_cases.boss_fight;

import entities.CurrentFightingStats;

public class FightBossStatsDisplayInteractor {
    CurrentFightingStats currentFightingStats;

    public FightBossStatsDisplayInteractor() {
        this.currentFightingStats = new CurrentFightingStats();
    }

    public FightBossStatsDisplayInteractor(String csv) {
        this.currentFightingStats = new CurrentFightingStats(csv);
    }

    public String getPLayerHealth(){
        return String.valueOf(currentFightingStats.getPlayerHP());
    }

    public String getBossHealth(){
        return String.valueOf(currentFightingStats.getBossHP());
    }


}

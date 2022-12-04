package stats_update_use_case;

import entities.Stats;
import entities.StatsUser;
import stats_storage.StatsDsGateway;

import java.util.Map;

public class StatsUpdateInteractor implements StatsUpdateInterface {
    Stats stats;
    StatsDsGateway statsDsGateway;

    public StatsUpdateInteractor(StatsDsGateway statsDsGateway) {
        Map<String, Integer> statsMap = statsDsGateway.loadStats();
        this.stats = new StatsUser(statsMap);
    }
    @Override
    public void updateLevel() {
        this.stats.updateLevel();
        saveStatsToStorageAndReturn();
    }
    @Override
    public void updateGold(int changeBy) {
        this.stats.updateGold(changeBy);
        saveStatsToStorageAndReturn();
    }
    @Override
    public void updateHp(int changeBy) {
        this.stats.updateCurrHp(changeBy);
        saveStatsToStorageAndReturn();
    }
    @Override
    public void updateTempDamage(int changeBy) {
        this.stats.updateTempDamage(changeBy);
        saveStatsToStorageAndReturn();
    }

    @Override
    public void updateBaselineDamage(int changeBy) {
        this.stats.updateBaselineDamage(changeBy);
        saveStatsToStorageAndReturn();
    }
    @Override
    public void updateDefence(int changeBy) {
        this.stats.updateDefence(changeBy);
        saveStatsToStorageAndReturn();
    }
    private void saveStatsToStorageAndReturn() {
        this.statsDsGateway.saveStats(this.stats.getUserStats());
    }

}

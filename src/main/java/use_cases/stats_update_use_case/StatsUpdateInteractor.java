package use_cases.stats_update_use_case;

import entities.Stats;
import entities.StatsUser;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidStats;
import use_cases.save_game.StatSave;

import java.util.Map;

public class StatsUpdateInteractor implements StatsUpdateInterface {
    Stats stats;
    ValidStats validStats;
    ErrorPresenter statsErrorPresenter;

    public StatsUpdateInteractor(ErrorPresenter statsErrorPresenter, String filename) {
        this.statsErrorPresenter = statsErrorPresenter;
        this.validStats = new ValidStats(filename, this.statsErrorPresenter);
        Map<String, Integer> statsMap = this.validStats.load();
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
        StatSave statSave = new StatSave(this.stats.getUserStats(), this.statsErrorPresenter);
        statSave.save();
    }

}

//package use_cases.stats_update_use_case;
//
//import stats.entities.Stats;
//import stats.entities.StatsUser;
//import use_cases.errors.ErrorOutputBoundary;
//import use_cases.file_checker.ValidStats;
//import use_cases.save_game.StatSave;
//
//import java.util.Map;
//
//public class StatsUpdateInteractor implements StatsUpdateInterface {
//    Stats stats;
//    ValidStats validStats;
//    ErrorOutputBoundary statsErrorOutputBoundary;
//
//    /**
//     * Constructor for StatsUpdateInteractor.
//     *
//     * @param statsErrorOutputBoundary output boundary for error cases when trying to load or save stats
//     * @param filename name of the file where the stats are stored in persistence.
//     */
//    public StatsUpdateInteractor(ErrorOutputBoundary statsErrorOutputBoundary, String filename) {
//        this.statsErrorOutputBoundary = statsErrorOutputBoundary;
//        this.validStats = new ValidStats(filename, this.statsErrorOutputBoundary);
//        Map<String, Integer> statsMap = this.validStats.load();
//        this.stats = new StatsUser(statsMap);
//    }
//    @Override
//    public void updateLevel() {
//        this.stats.updateLevel();
//        saveStatsToStorage();
//    }
//    @Override
//    public void updateGold(int changeBy) {
//        this.stats.updateGold(changeBy);
//        saveStatsToStorage();
//    }
//    @Override
//    public void updateCurrentHp(int changeBy) {
//        this.stats.updateCurrHp(changeBy);
//        saveStatsToStorage();
//    }
//    @Override
//    public void updateTempDamage(int changeBy) {
//        this.stats.updateTempDamage(changeBy);
//        saveStatsToStorage();
//    }
//
//    @Override
//    public void updateBaselineDamage(int changeBy) {
//        this.stats.updateBaselineDamage(changeBy);
//        saveStatsToStorage();
//    }
//    @Override
//    public void updateDefence(int changeBy) {
//        this.stats.updateDefence(changeBy);
//        saveStatsToStorage();
//    }
//
//    /**
//     * Helper method for saving the stat map to storage
//     */
//    private void saveStatsToStorage() {
//        StatSave statSave = new StatSave(this.stats.getUserStats(), this.statsErrorOutputBoundary);
//        statSave.save();
//    }
//
//}

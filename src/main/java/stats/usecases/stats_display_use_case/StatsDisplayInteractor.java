package stats.usecases.stats_display_use_case;

import use_cases.file_checker.ValidStats;

import java.util.Map;

/**
 * Interactor for stats display use case.
 */
public class StatsDisplayInteractor implements StatsDisplayInputBoundary {

    final Map<String, Integer> stats;

    public StatsDisplayInteractor(ValidStats validStats) {
        this.stats = validStats.load();
    }

    public Map<String, Integer> display() {
        return this.stats;
    }
}

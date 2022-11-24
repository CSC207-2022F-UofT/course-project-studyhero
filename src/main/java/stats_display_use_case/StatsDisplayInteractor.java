package stats_display_use_case;

import entities.Stats;
import screens.StatsDisplayViewModel;

import java.util.Map;

public class StatsDisplayInteractor implements StatsDisplayInputBoundary {

    final Stats stats;

    final StatsDisplayOutputBoundary statsDisplayPresenter;

    public StatsDisplayInteractor(Stats stats, StatsDisplayOutputBoundary statsDisplayPresenter) {
        this.stats = stats;
        this.statsDisplayPresenter = statsDisplayPresenter;
    }

    public StatsDisplayViewModel display() {
        Map<String, Integer> statsMap = stats.getUserStats();
        return statsDisplayPresenter.displayStats(statsMap);
    }
}

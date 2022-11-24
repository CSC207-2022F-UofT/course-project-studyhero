package stats_display_use_case;

import entities.Stats;
import screens.StatsDisplayViewModel;

import java.util.Map;

public class StatsDisplayInteractor implements StatsDisplayInputBoundary {

    final Stats stats;

    final StatsDisplayOutputBoundary statsDisplayOutputBoundary;

    public StatsDisplayInteractor(Stats stats, StatsDisplayOutputBoundary statsDisplayOutputBoundary) {
        this.stats = stats;
        this.statsDisplayOutputBoundary = statsDisplayOutputBoundary;
    }

    public void display() {
        Map<String, Integer> statsMap = stats.getUserStats();
        statsDisplayOutputBoundary.displayStats(statsMap);
    }
}

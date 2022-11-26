package stats_display_use_case;

import entities.Stats;
import stats_storage.StatsDsGateway;

import java.util.Map;

public class StatsDisplayInteractor implements StatsDisplayInputBoundary {

    final Map<String, Integer> stats;

    final StatsDisplayOutputBoundary statsDisplayPresenter;

    public StatsDisplayInteractor(StatsDsGateway statsDsGateway, StatsDisplayOutputBoundary statsDisplayPresenter) {
        this.stats = StatsDsGateway.load();
        this.statsDisplayPresenter = statsDisplayPresenter;
    }

    public Map<String, Integer> display() {
        return this.stats;
    }
}

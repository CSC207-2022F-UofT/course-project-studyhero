package stats_display_use_case;

import stats_storage.StatsDsGateway;

import java.util.Map;

public class StatsDisplayInteractor implements StatsDisplayInputBoundary {

    final Map<String, Integer> stats;

    public StatsDisplayInteractor(StatsDsGateway statsDsGateway) {
        this.stats = statsDsGateway.loadStats();
    }

    public Map<String, Integer> display() {
        return this.stats;
    }
}

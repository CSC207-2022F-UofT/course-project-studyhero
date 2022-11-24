package stats;

import java.util.Map;

public class StatsDisplayInteractor implements StatsDisplayInputBoundary {

    final StatsDisplayDsGateway statsDsGateway;

    final StatsDisplayOutputBoundary statsDisplayPresenter;

    public StatsDisplayInteractor(StatsDisplayDsGateway statsDsGateway, StatsDisplayOutputBoundary statsDisplayPresenter) {
        this.statsDsGateway = statsDsGateway;
        this.statsDisplayPresenter = statsDisplayPresenter;
    }

    public StatsDisplayViewModel display() {
        return statsDisplayPresenter.displayStats(statsDsGateway);
    }
}

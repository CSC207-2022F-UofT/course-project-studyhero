package screens;

import stats_display_use_case.StatsDisplayInputBoundary;
import stats_display_use_case.StatsDisplayOutputBoundary;

import java.util.Map;

/** Controller class for displaying stats (Interface adaptors layer)
 *
 */
public class StatsDisplayController {
    final StatsDisplayInputBoundary statsDisplayInteractor;
    final StatsDisplayOutputBoundary statsDisplayPresenter;
    final StatsDisplayViewModel statsDisplayViewModel;
    public StatsDisplayController(StatsDisplayInputBoundary statsDisplayInteractor,
                                  StatsDisplayOutputBoundary statsDisplayPresenter) {
        this.statsDisplayInteractor = statsDisplayInteractor;
        this.statsDisplayPresenter = statsDisplayPresenter;
        Map<String, Integer> statsMap = this.statsDisplayInteractor.display();
        this.statsDisplayViewModel = this.statsDisplayPresenter.displayStats(statsMap);
    }
    public StatsDisplayViewModel displayStats() {
        return this.statsDisplayViewModel;
    }
}

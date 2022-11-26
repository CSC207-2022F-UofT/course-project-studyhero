package screens;

import stats_display_use_case.StatsDisplayInputBoundary;
import stats_display_use_case.StatsDisplayOutputBoundary;

/** Controller class for displaying stats (Interface adaptors layer)
 *
 */
public class StatsDisplayController {
    StatsDisplayInputBoundary statsDisplayInteractor;
    StatsDisplayOutputBoundary statsDisplayPresenter;
    StatsDisplayViewModel statsDisplayViewModel;
    public StatsDisplayController(StatsDisplayInputBoundary statsDisplayInteractor,
                                  StatsDisplayOutputBoundary statsDisplayPresenter,
                                  StatsDisplayViewModel statsDisplayViewModel) {
        this.statsDisplayInteractor = statsDisplayInteractor;
        this.statsDisplayPresenter = statsDisplayPresenter;
        this.statsDisplayViewModel = this.statsDisplayPresenter.displayStats(this.statsDisplayInteractor.display());
    }
    public StatsDisplayViewModel displayStats() {
        return this.statsDisplayViewModel;
    }
}

package screens;

import use_cases.stats_display_use_case.StatsDisplayInputBoundary;
import use_cases.stats_display_use_case.StatsDisplayOutputBoundary;

import java.util.Map;

/** Controller class for displaying stats. Whenever the button is pressed, the controller will call the presenter to
 * receive a view model and then pass that view model to the view.
 */
public class StatsDisplayController {
    final StatsDisplayInputBoundary statsDisplayInteractor;
    final StatsDisplayOutputBoundary statsDisplayPresenter;
    final StatsDisplayViewModel statsDisplayViewModel;

    /**
     * Constructor for StatsDisplayController.
     *
     * @param statsDisplayInteractor an object implementing the statsDisplayInputBoundary that will act as the
     *                               interactor for the stats display use case
     * @param statsDisplayPresenter an object implementing the statsDisplayOutputBoundary that will act as the
     *                              presenter
     */
    public StatsDisplayController(StatsDisplayInputBoundary statsDisplayInteractor,
                                  StatsDisplayOutputBoundary statsDisplayPresenter) {
        this.statsDisplayInteractor = statsDisplayInteractor;
        this.statsDisplayPresenter = statsDisplayPresenter;
        Map<String, Integer> statsMap = this.statsDisplayInteractor.display();
        this.statsDisplayViewModel = this.statsDisplayPresenter.displayStats(statsMap);
    }

    /**
     * Display method that is called to obtain the view model which can then be used by the view to display the user's
     * stats to the screen.
     *
     * @return stats display view model
     */
    public StatsDisplayViewModel displayStats() {
        return this.statsDisplayViewModel;
    }
}

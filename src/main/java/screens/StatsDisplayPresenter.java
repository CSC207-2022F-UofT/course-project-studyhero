package screens;

import use_cases.stats_display_use_case.StatsDisplayOutputBoundary;

import java.util.Map;

/**
 * Presenter class for displaying stats. This is called by the controller to return a view model which the controller
 * then passes on to the view.
 */
public class StatsDisplayPresenter implements StatsDisplayOutputBoundary {
    /**
     * Display method that processes the stats map and returns a view model to the controller.
     * @param statsMap the stats map containing type of stats as string key and its value as an integer value
     * @return stats display view model
     */
    @Override
    public StatsDisplayViewModel displayStats(Map<String, Integer> statsMap) {
        return new StatsDisplayViewModel(statsMap);
    }
}

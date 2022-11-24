package screens;

import stats_display_use_case.StatsDisplayOutputBoundary;

import java.util.Map;

/**
 * Presenter class for displaying stats (Interface adaptors layer)
 */
public class StatsDisplayPresenter implements StatsDisplayOutputBoundary {

    @Override
    public StatsDisplayViewModel displayStats(Map<String, Integer> statsMap) {
        return new StatsDisplayViewModel(statsMap);
    }
}

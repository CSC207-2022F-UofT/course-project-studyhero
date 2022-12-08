package use_cases.stats_display_use_case;

import screens.StatsDisplayViewModel;

import java.util.Map;

/**
 * The output boundary (interface) for the stats display use case.
 */
// Entity Layer
public interface StatsDisplayOutputBoundary {
    /**
     * Passes a stats display view model to the presenter.
     *
     * @param statsMap the stats map containing type of stats as string key and its value as an integer value
     * @return the stats display view model
     */
    StatsDisplayViewModel displayStats(Map<String, Integer> statsMap);
}

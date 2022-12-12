package stats.usecases.stats_display_use_case;

import java.util.Map;

/**
 * Input boundary for the stats display use case.
 */
public interface StatsDisplayInputBoundary {
    /**
     * Returns a map containing the type of stat as the key string and its value as the value integer.
     * @return map from string describing the type of stat to the integer value of that stat.
     */
    Map<String, Integer> display();
}

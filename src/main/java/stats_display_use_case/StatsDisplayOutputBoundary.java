package stats_display_use_case;

import screens.StatsDisplayViewModel;

import java.util.Map;

// Entity Layer
public interface StatsDisplayOutputBoundary {
    StatsDisplayViewModel displayStats(Map<String, Integer> statsMap);
}

package stats.stats_storage;

import java.util.Map;

public interface StatsDsGateway {
    Map<String, Integer> loadStats();
    void saveStats(Map<String, Integer> statsMap);
}

package stats_storage;

import java.util.Map;

public interface StatsDsGateway {
    public Map<String, Integer> loadStats();
    public void saveStats(String filepath);
}

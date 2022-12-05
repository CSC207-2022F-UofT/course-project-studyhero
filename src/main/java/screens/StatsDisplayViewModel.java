package screens;

import java.util.HashMap;
import java.util.Map;

public class StatsDisplayViewModel {

    final Map <String, String> statsAsStrings;
    public StatsDisplayViewModel(Map<String, Integer> statsMap) {
        statsAsStrings = new HashMap<>();
        for (Map.Entry<String, Integer> entry : statsMap.entrySet()) {
            statsAsStrings.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
    }
    public Map<String, String> getStats() {
        return this.statsAsStrings;
    }
}

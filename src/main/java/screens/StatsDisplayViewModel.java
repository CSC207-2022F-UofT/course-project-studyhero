package screens;

import java.util.HashMap;
import java.util.Map;

/**
 * View model for the stats display use case that is passed on to the view. It contains a final Map that has strings
 * representing the type of stat as the keys and strings representing the value of that stat as its values. This map can
 * be accessed by the getStats() method.
 */
public class StatsDisplayViewModel {

    final Map <String, String> statsAsStrings;

    /**
     * Constructor for the stats display view model.
     *
     * @param statsMap map from the string describing the type of stat to the integer value of the stat. E.g.
     *                  statsMap.get("gold") is 12 if the user has 12 gold.
     */
    public StatsDisplayViewModel(Map<String, Integer> statsMap) {
        statsAsStrings = new HashMap<>();
        for (Map.Entry<String, Integer> entry : statsMap.entrySet()) {
            statsAsStrings.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
    }

    /**
     * Returns a map that has string representing the type of stat as the keys and strings representing the value of
     * that stat as its values. Useful for displaying the user's stats.
     *
     * @return the stats map containing strings representing the type of stat as the keys and strings representing the
     * value of that stat as the values
     */
    public Map<String, String> getStats() {
        return this.statsAsStrings;
    }
}

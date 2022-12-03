package use_cases.update_stats.load_game;

import java.util.Map;

public interface LoadGameInputBoundary {
    Map<String, Integer> load(LoadGameRequestModel requestModel);
}

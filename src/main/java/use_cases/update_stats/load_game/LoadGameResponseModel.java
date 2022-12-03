package use_cases.update_stats.load_game;

import java.util.Map;

public class LoadGameResponseModel {
    Map<String, Integer> stats;

    public LoadGameResponseModel(Map<String, Integer> stats){
        this.stats = stats;
    }

    public Map<String, Integer> getStats(){
        return stats;
    }

    public void setStats(Map<String, Integer> stats){
        this.stats = stats;
    }
}

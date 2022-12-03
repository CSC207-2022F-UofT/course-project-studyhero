package use_cases.update_stats.load_game;

import java.util.Map;

public class LoadGameController {
    final LoadGameInputBoundary loadGameInput;

    public LoadGameController(LoadGameInputBoundary inputBoundary){
        this.loadGameInput = inputBoundary;
    }
    Map<String, Integer> load(){
        LoadGameRequestModel model = new LoadGameRequestModel();
        return loadGameInput.load(model);
    }
}

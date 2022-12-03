package use_cases.update_stats.load_game;

public interface LoadGameDsGateway {
    boolean existsGame(String filename);
    void save(LoadGameDsRequestModel requestModel);
}

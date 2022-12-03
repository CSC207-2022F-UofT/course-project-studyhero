package use_cases.update_stats.load_game;

public interface LoadGamePresenter {
    LoadGameResponseModel prepareSuccessView(LoadGameResponseModel user);

    LoadGameResponseModel prepareFailView(String error);
}

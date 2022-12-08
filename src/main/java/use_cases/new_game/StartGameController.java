package use_cases.new_game;

public class StartGameController {
    private NewGameInputBoundary newGame;

    public StartGameController(NewGameInputBoundary newGame){

        this.newGame = newGame;
    }
    public void startNewGame(){
        if (!newGame.isPlayable()){
        newGame.newGame();}
    }
}

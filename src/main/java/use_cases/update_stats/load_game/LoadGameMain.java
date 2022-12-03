package use_cases.update_stats.load_game;

import javax.swing.*;

public class LoadGameMain {
    public static void main(String[] args){
        JFrame main = new JFrame("Load Game Test");

        LoadGameDsGateway gateway;
        gateway = new LoadGameInputFile();

        //LoadGamePresenter presenter  = new LoadGamePresenter();
        //LoadGameInteractor loader = new LoadGameInteractor(gateway, presenter);
        //LoadGameController controller = new LoadGameController(loader);
        //LoadGameScreen loadGameScreen = new LoadGameScreen(controller);
        //main.add(loadGameScreen);
        main.pack();
        main.setVisible(true);

    }
}

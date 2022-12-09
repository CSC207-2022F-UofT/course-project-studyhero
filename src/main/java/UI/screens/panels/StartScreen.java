package UI.screens.panels;

import use_cases.continue_game.ContinueGameController;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidFileDsGateway;
import use_cases.file_checker.ValidPlayerInventory;
import use_cases.file_checker.ValidShopInventory;
import use_cases.file_checker.ValidStats;
import use_cases.new_game.*;
import use_cases.game_check.GameCheckController;
import use_cases.game_check.GameCheckInputBoundary;
import use_cases.game_check.GameCheckInteractor;

import javax.swing.*;
import java.awt.*;
public class StartScreen extends JPanel{

    CardLayout card;
    JPanel parentPanel;
    ErrorOutputBoundary presenter;
    private final static String statsFilepath = "stats.csv";
    private final static String playerInventoryFilepath = "PlayerInventory.csv";
    private final static String shopInventoryFilepath = "ShopInventory.csv";
    private final static String fightStatsFilepath = "fightStats.csv";

    public StartScreen(CardLayout card, JPanel parent){

        this.card = card;
        this.parentPanel = parent;
        this.presenter = new ErrorPresenter();

        JLabel title = new JLabel("Start Game");

        //   ----- Buttons -----

        // 1. New Game -> checks to see if there are existing valid game files and
        // either gives you a confirmation window or starts a new game
        JButton newGameButton = new JButton("New Game");
        ErrorOutputBoundary fileCheckerPresenter = new ErrorPresenter();
        ValidFileDsGateway statsChecker = new ValidStats(statsFilepath, fileCheckerPresenter);
        ValidFileDsGateway playerInventoryChecker = new ValidPlayerInventory(playerInventoryFilepath, fileCheckerPresenter);
        ValidFileDsGateway shopInventoryChecker = new ValidShopInventory(shopInventoryFilepath, fileCheckerPresenter);

        ValidFileDsGateway fightStatsChecker = new ValidStats(fightStatsFilepath, presenter);
        NewGameInputBoundary newGameUseCase =
                new NewGame(statsChecker, playerInventoryChecker, shopInventoryChecker, fightStatsChecker, presenter);
        GameCheckInputBoundary gameCheckUseCase =
                new GameCheckInteractor(statsChecker, playerInventoryChecker, fightStatsChecker);
        GameCheckController gameCheckController = new GameCheckController(card, parent, gameCheckUseCase,
                newGameUseCase, presenter);
        newGameButton.addActionListener(gameCheckController);


        // 2. Continue Game -> checks to see if there are existing valid game files
        // and will move to timer screen if so
        JButton continueGameButton = new JButton("Continue Game");
        ContinueGameController continueGameController = new ContinueGameController(card, parent, gameCheckUseCase, presenter);
        continueGameButton.addActionListener(continueGameController);

        JButton goToSettingsButton = new JButton("Settings");
        goToSettingsButton.addActionListener(e -> card.show(parent, "Start Settings"));

        JButton quitGameButton = new JButton("Quit Game");
        quitGameButton.addActionListener(e -> System.exit(0));

        this.add(title);
        this.add(newGameButton);
        this.add(continueGameButton);
        this.add(goToSettingsButton);
        this.add(quitGameButton);

        this.setSize(800,500);
        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
    }
}

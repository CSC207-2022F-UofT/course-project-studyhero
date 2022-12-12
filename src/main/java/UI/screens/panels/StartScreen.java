package UI.screens.panels;

import filesaver.usecases.continue_game.ContinueGameController;
import errors.usecases.ErrorOutputBoundary;
import errors.usecases.ErrorPresenter;
import filesaver.usecases.file_checker.ValidFileDsGateway;
import filesaver.usecases.file_checker.ValidPlayerInventory;
import filesaver.usecases.file_checker.ValidShopInventory;
import filesaver.usecases.file_checker.ValidStats;
import filesaver.usecases.new_game.NewGame;
import filesaver.usecases.new_game.NewGameInputBoundary;
import filesaver.usecases.new_game.NewGameController;
import filesaver.usecases.game_check.GameCheckInputBoundary;
import filesaver.usecases.game_check.GameCheckInteractor;

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
        ValidFileDsGateway playerInventoryChecker =
                new ValidPlayerInventory(playerInventoryFilepath, fileCheckerPresenter);
        ValidFileDsGateway shopInventoryChecker =
                new ValidShopInventory(shopInventoryFilepath, fileCheckerPresenter);

        ValidFileDsGateway fightStatsChecker = new ValidStats(fightStatsFilepath, presenter);
        NewGameInputBoundary newGameUseCase =
                new NewGame(statsChecker, playerInventoryChecker, fightStatsChecker, presenter);
        GameCheckInputBoundary gameCheckUseCase =
                new GameCheckInteractor(statsChecker, playerInventoryChecker, fightStatsChecker);


        // the validFileDsGateways - confirmationWindow - gameCheckUseCase - newGameController
        // follows the MVC architectural pattern
        String confirmationMsg = "Are you sure? This will overwrite your " +
                "existing save files.";
        ConfirmationWindowView confirmationWindow =
                new ConfirmationWindowView(confirmationMsg, card,
                        parent, presenter);
        NewGameController newGameController =
                new NewGameController(card, parent, gameCheckUseCase,
                newGameUseCase, confirmationWindow);
        newGameButton.addActionListener(newGameController);


        // 2. Continue Game -> checks to see if there are existing valid game files
        // and will move to timer screen if so
        JButton continueGameButton = new JButton("Continue Game");
        ContinueGameController continueGameController =
                new ContinueGameController(card, parent, gameCheckUseCase);
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

package UI.screens.panels.settings;

import entities.MusicPlayer;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidFileDsGateway;
import use_cases.file_checker.ValidPlayerInventory;
import use_cases.file_checker.ValidShopInventory;
import use_cases.file_checker.ValidStats;
import use_cases.new_game.*;
import use_cases.new_game.NewGameController;
import use_cases.game_check.GameCheckInputBoundary;
import use_cases.game_check.GameCheckInteractor;
import UI.screens.panels.ConfirmationWindowView;

import javax.swing.*;
import java.awt.*;

public class SettingsScreen extends JPanel {
    private final static String statsFilepath = "stats.csv";
    private final static String playerInventoryFilepath = "PlayerInventory.csv";
    private final static String shopInventoryFilepath = "ShopInventory.csv";
    private final static String fightStatsFilepath = "fightStats.csv";
    public SettingsScreen(CardLayout card, JPanel parentPanel,
                          ErrorOutputBoundary presenter, String prevPanel,
                          MusicPlayer player) {

        JLabel title = new JLabel("Settings");
        this.add(title);

        // ===== Main Controls =====
        JPanel mainControls = new JPanel();


        JButton newGameButton = new JButton("New Game");
        ErrorOutputBoundary fileCheckerPresenter = new ErrorPresenter();
        ValidFileDsGateway statsChecker =
                new ValidStats(statsFilepath, fileCheckerPresenter);
        ValidFileDsGateway playerInventoryChecker =
                new ValidPlayerInventory(playerInventoryFilepath, fileCheckerPresenter);
        ValidFileDsGateway shopInventoryChecker =
                new ValidShopInventory(shopInventoryFilepath, fileCheckerPresenter);

        ValidFileDsGateway fightStatsChecker =
                new ValidStats(fightStatsFilepath, presenter);
        NewGameInputBoundary newGameUseCase =
                new NewGame(statsChecker, playerInventoryChecker,
                shopInventoryChecker, fightStatsChecker, presenter);
        GameCheckInputBoundary gameCheckUseCase =
                new GameCheckInteractor(statsChecker, playerInventoryChecker,
                        fightStatsChecker);

        String confirmationMsg = "Are you sure? This will overwrite your " +
                "existing save files.";
        ConfirmationWindowView confirmationWindow =
                new ConfirmationWindowView(confirmationMsg, card, parentPanel, presenter);
        NewGameController newGameController =
                new NewGameController(card, parentPanel, gameCheckUseCase,
                newGameUseCase, confirmationWindow);
        newGameButton.addActionListener(newGameController);

        JButton goBackButton = new JButton("Back");
        goBackButton.addActionListener(e -> card.show(parentPanel, prevPanel));

        JButton quitButton = new JButton("Quit Game");
        quitButton.addActionListener(e -> System.exit(0));

        // ===== Music Controls =====
        MusicControlScreen musicControlScreen =
                new MusicControlScreen(card, parentPanel, player, mainControls);
        musicControlScreen.setVisible(false);

        JButton musicButton = new JButton("Music Controls");
        musicButton.addActionListener(e-> {
            musicControlScreen.setVisible(true);
            mainControls.setVisible(false);
        });
        mainControls.add(newGameButton);
        mainControls.add(musicButton);
        mainControls.add(goBackButton);
        mainControls.add(quitButton);

        this.add(mainControls);
        this.add(musicControlScreen);
    }

}

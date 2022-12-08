package UI.screens;
import UI.screens.inventoryscreens.InventoryPanel;
import UI.screens.timer_screen.TimerPanel;
import UI.screens.panels.*;
import UI.screens.panels.breaks.BreakScreen;
import UI.screens.panels.breaks.BuyMenuScreen;
//import UI.screens.panels.breaks.SellMenuScreen;
import UI.screens.panels.breaks.ShopMenuScreen;
import UI.screens.panels.settings.SettingsScreen;
import entities.MusicPlayer;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidFileDsGateway;
import use_cases.file_checker.ValidPlayerInventory;
import use_cases.file_checker.ValidShopInventory;
import use_cases.file_checker.ValidStats;
import use_cases.new_game.NewGame;
import use_cases.new_game.NewGameInputBoundary;
import use_cases.new_game.StartGameController;

import javax.swing.*;
import java.awt.*;

public class GameMain {
    public static void main(String[] args){
        JFrame mainFrame = new JFrame("Test Game");
        JPanel mainPanel = new JPanel();
        CardLayout card = new CardLayout();
        ErrorOutputBoundary cGRM = new ErrorPresenter();
        mainPanel.setLayout(card);

        // ----- Music ------
        ErrorOutputBoundary musicErrorPresenter = new ErrorPresenter();
        MusicPlayer player = new MusicPlayer("btd2.wav", musicErrorPresenter);

        StartScreen startScreen = new StartScreen(card, mainPanel);
        ErrorOutputBoundary startScreenPresenter = new ErrorPresenter();
        ValidFileDsGateway validStats = new ValidStats("stats.csv", startScreenPresenter);
        ValidFileDsGateway validInventory =
                new ValidPlayerInventory("PlayerInventory.csv", startScreenPresenter);
        ValidFileDsGateway validFighterStats =
                new ValidStats("fighterStats.csv", startScreenPresenter);
        ValidFileDsGateway validShopInventory =
                new ValidShopInventory("ShopInventory.csv", startScreenPresenter);

        NewGameInputBoundary newGame = new NewGame(validStats, validInventory,
                validShopInventory,validFighterStats, startScreenPresenter);
        StartGameController startGameController = new StartGameController(newGame);
        startGameController.startNewGame();

        StoryScreen storyScreen = new StoryScreen(card, mainPanel);
        TimerPanel timerScreen = new TimerPanel(card, mainPanel);
        InventoryPanel inventoryScreen = new InventoryPanel(card, mainPanel);
        BreakScreen breakScreen = new BreakScreen(card, mainPanel);

//        SellMenuScreen sellMenuScreen = new SellMenuScreen(card, mainPanel);
        BuyMenuScreen buyMenuScreen = new BuyMenuScreen(card, mainPanel);
        ShopMenuScreen shopMenuScreen = new ShopMenuScreen(card, mainPanel);

        FightBossScreen fightBossScreen = new FightBossScreen(card, mainPanel);


        ChangeStatsScreen changeStatsScreen = new ChangeStatsScreen(card, mainPanel, cGRM);

        // ===== all settings =====
        SettingsScreen startSettingsScreen =
                new SettingsScreen(card, mainPanel, cGRM, "Start", player);
        SettingsScreen breakSettingsScreen =
                new SettingsScreen(card, mainPanel, cGRM, "Break", player);


        mainPanel.add(storyScreen, "Story");
        mainPanel.add(timerScreen, "Timer");
        mainPanel.add(breakScreen, "Break");
        mainPanel.add(changeStatsScreen, "Change Stats");
        mainPanel.add(startSettingsScreen, "Start Settings");
        mainPanel.add(breakSettingsScreen, "Break Settings");
//        mainPanel.add(sellMenuScreen, "Sell Menu");
        mainPanel.add(buyMenuScreen, "Buy Menu");
        mainPanel.add(shopMenuScreen, "Shop Menu");
        mainPanel.add(fightBossScreen, "Fight Boss");
        mainPanel.add(inventoryScreen, "Inventory Menu");
        mainPanel.add(startScreen, "Start");

        mainFrame.add(mainPanel);
        card.show(mainPanel, "Start");
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setSize(800, 500);

    }
}

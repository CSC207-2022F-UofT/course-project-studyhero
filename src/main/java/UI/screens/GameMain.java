package UI.screens;
import UI.screens.panels.StatsDisplayScreen;
import UI.screens.timer_screen.TimerPanel;
import UI.screens.panels.*;
import UI.screens.panels.breaks.BreakScreen;
import UI.screens.panels.breaks.BuyMenuScreen;
import UI.screens.panels.breaks.ShopMenuScreen;
import UI.screens.panels.settings.SettingsScreen;
import entities.FightingStatsInitializer;
import entities.MusicPlayer;
import entities.StatsUser;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidFileDsGateway;
import use_cases.file_checker.ValidStats;
import use_cases.save_game.StatSave;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class GameMain {
    public static void main(String[] args){
        JFrame mainFrame = new JFrame("StudyHero");
        JPanel mainPanel = new JPanel();
        CardLayout card = new CardLayout();
        ErrorOutputBoundary cGRM = new ErrorPresenter();
        mainPanel.setLayout(card);

        // ----- Music ------
        ErrorOutputBoundary musicErrorPresenter = new ErrorPresenter();
        MusicPlayer player = new MusicPlayer("btd2.wav", musicErrorPresenter);

        StartScreen startScreen = new StartScreen(card, mainPanel);
        StoryScreen storyScreen = new StoryScreen(card, mainPanel);
        TimerPanel timerScreen = new TimerPanel(card, mainPanel);
        BreakScreen breakScreen = new BreakScreen(card, mainPanel);
        ShopMenuScreen shopMenuScreen = new ShopMenuScreen(card, mainPanel);

        // ===== Initialize fight boss screen =====
        // ===== Create new stats file if !exists =====
        ErrorOutputBoundary presenter = new ErrorPresenter();
        ValidFileDsGateway validStats = new ValidStats("stats.csv", presenter);
        if (!validStats.isPlayable()){
            StatsUser newUser = new StatsUser();
            StatSave newSave = new StatSave(newUser.getUserStats(), presenter);
            newSave.save("stats.csv");

        }
        // ===== Create/ overwrite fightStats files =====
        FightingStatsInitializer fightingStatsInitializer =
                new FightingStatsInitializer();
        Map<String, Integer> fightStats = fightingStatsInitializer.initialize();
        StatSave saver = new StatSave(fightStats, presenter);
        saver.save("fightStats.csv");

        FightBossScreen fightBossScreen = new FightBossScreen(card, mainPanel);

        StatsDisplayScreen statsScreen = new StatsDisplayScreen(card, mainPanel);

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
        mainPanel.add(shopMenuScreen, "Shop Menu");
        mainPanel.add(startScreen, "Start");

        mainPanel.add(fightBossScreen, "Fight Boss");

        mainPanel.add(statsScreen, "Stats");

        mainFrame.add(mainPanel);
        card.show(mainPanel, "Start");
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setSize(800, 500);



    }
}

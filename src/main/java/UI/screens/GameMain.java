package UI.screens;
import UI.screens.timer_screen.TimerPanel;
import UI.screens.panels.*;
import UI.screens.panels.breaks.BreakScreen;
import UI.screens.panels.breaks.ShopMenuScreen;
import UI.screens.panels.settings.SettingsScreen;
import entities.MusicPlayer;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;

import javax.swing.*;
import java.awt.*;

public class GameMain {
    public static void main(String[] args){
        JFrame mainFrame = new JFrame("StudyHero");
        JPanel mainPanel = new JPanel();
        CardLayout card = new CardLayout();
        ErrorOutputBoundary cGRM = new ErrorPresenter();
        mainPanel.setLayout(card);

        // ----- Music ------
        ErrorOutputBoundary musicErrorPresenter = new ErrorPresenter();
        MusicPlayer player = new MusicPlayer("bgm.wav", musicErrorPresenter);

        StartScreen startScreen = new StartScreen(card, mainPanel);
        StoryScreen storyScreen = new StoryScreen(card, mainPanel);
        TimerPanel timerScreen = new TimerPanel(card, mainPanel);
        BreakScreen breakScreen = new BreakScreen(card, mainPanel);
        ShopMenuScreen shopMenuScreen = new ShopMenuScreen(card, mainPanel);
        FightBossScreen fightBossScreen = new FightBossScreen(card, mainPanel);

        // ===== all settings =====
        SettingsScreen startSettingsScreen =
                new SettingsScreen(card, mainPanel, cGRM, "Start", player);
        SettingsScreen breakSettingsScreen =
                new SettingsScreen(card, mainPanel, cGRM, "Break", player);


        mainPanel.add(storyScreen, "Story");
        mainPanel.add(timerScreen, "Timer");
        mainPanel.add(breakScreen, "Break");
        mainPanel.add(startSettingsScreen, "Start Settings");
        mainPanel.add(breakSettingsScreen, "Break Settings");
        mainPanel.add(shopMenuScreen, "Shop Menu");
        mainPanel.add(fightBossScreen, "Fight Boss");
        mainPanel.add(startScreen, "Start");

        mainFrame.add(mainPanel);
        card.show(mainPanel, "Start");
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setSize(800, 500);

    }
}

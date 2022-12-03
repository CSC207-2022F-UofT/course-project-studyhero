package UI.screens;
import UI.screens.panels.ChangeStatsScreen;
import UI.screens.panels.NewGameScreen;
import UI.screens.panels.NextScreen;
import use_cases.errors.ErrorPresenter;

import javax.swing.*;
import java.awt.*;

public class NewGameMain {
    public static void main(String[] args){
        JFrame mainFrame = new JFrame("Load Game Test");
        JPanel mainPanel = new JPanel();
        CardLayout card = new CardLayout();
        ErrorPresenter cGRM = new ErrorPresenter();
        mainPanel.setLayout(card);

        NewGameScreen newGameScreen = new NewGameScreen(card, mainPanel,cGRM);
        NextScreen nextScreen = new NextScreen(card, mainPanel,cGRM);
        ChangeStatsScreen changeStatsScreen = new ChangeStatsScreen(card,mainPanel, cGRM);
        mainPanel.add(newGameScreen, "New");
        mainPanel.add(nextScreen, "Next");
        mainPanel.add(changeStatsScreen, "Change Stats");

        mainFrame.add(mainPanel);
        card.show(mainPanel, "New");
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

    }
}

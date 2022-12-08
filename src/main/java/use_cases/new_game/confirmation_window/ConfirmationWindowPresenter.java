package use_cases.new_game.confirmation_window;

import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidFileDsGateway;
import use_cases.file_checker.ValidPlayerInventory;
import use_cases.file_checker.ValidStats;
import use_cases.new_game.NewGame;
import use_cases.new_game.NewGameConfirmationController;
import use_cases.new_game.NewGameInputBoundary;

import javax.swing.*;
import java.awt.*;

public class ConfirmationWindowPresenter extends JFrame implements
        ConfirmationWindowOutputBoundary {

    private final static String statsFilepath = "stats.csv";
    private final static String inventoryFilepath = "PlayerInventory.csv";
    private final static String fightStatsFilepath = "fightStats.csv";

    public ConfirmationWindowPresenter(String confirmation, CardLayout card, JPanel parentPanel,
                                       ErrorOutputBoundary presenter){
        JLabel title = new JLabel(confirmation);
        JPanel panel = new JPanel();
        JButton confirm = new JButton("Yes");

        ErrorOutputBoundary fileCheckerPresenter = new ErrorPresenter();
        ValidFileDsGateway statsChecker = new ValidStats(statsFilepath, fileCheckerPresenter);
        ValidFileDsGateway inventoryChecker = new ValidPlayerInventory(inventoryFilepath, fileCheckerPresenter);
        ValidFileDsGateway fightStatsChecker = new ValidStats(fightStatsFilepath, presenter);
        NewGameInputBoundary newGameUseCase = new NewGame(statsChecker, inventoryChecker,
                fightStatsChecker, presenter);
        NewGameConfirmationController newGameConfirmationController =
                new NewGameConfirmationController(card, parentPanel, this,
                        newGameUseCase, presenter);
        confirm.addActionListener(newGameConfirmationController);

        JButton reject = new JButton("No");
        reject.addActionListener(e -> this.dispose());

        panel.add(title);
        panel.add(confirm);
        panel.add(reject);
        this.add(panel);
        this.pack();
    }

    @Override
    public void viewWindow(){
        this.setVisible(true);
    }

}

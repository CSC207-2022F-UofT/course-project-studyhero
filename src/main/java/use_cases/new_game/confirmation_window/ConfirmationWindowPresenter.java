package use_cases.new_game.confirmation_window;

import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.file_checker.ValidFileDsGateway;
import use_cases.file_checker.ValidPlayerInventory;
import use_cases.file_checker.ValidShopInventory;
import use_cases.file_checker.ValidStats;
import use_cases.new_game.NewGame;
import use_cases.new_game.NewGameInputBoundary;

import javax.swing.*;
import java.awt.*;

public class ConfirmationWindowPresenter extends JFrame implements
        ConfirmationWindowOutputBoundary {

    private final static String statsFilepath = "stats.csv";
    private final static String playerInventoryFilepath = "PlayerInventory.csv";
    private final static String fightStatsFilepath = "fightStats.csv";
    private final static String shopInventoryFilepath = "ShopInventory.csv";

    /**
     * Creates a ConfirmationWindowPresenter object that can displays the
     * confirmation message and has two buttons to either allow the user
     * to close the window, or create a new game.
     *
     * @param confirmation  Confirmation message
     * @param card          Layout Manager to show the user the next screen (Story)
     * @param parentPanel   Panel where the next screen is stored
     * @param presenter     Output boundary if any error occurs
     */
    public ConfirmationWindowPresenter(String confirmation, CardLayout card,
                                       JPanel parentPanel,
                                       ErrorOutputBoundary presenter){
        JLabel title = new JLabel(confirmation);
        JPanel panel = new JPanel();

        // ===== Confirm Button =====
        // --- Creates file checkers and new game use case to start a new game
        JButton confirm = new JButton("Yes");
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
                        shopInventoryChecker, fightStatsChecker,presenter);
        NewGameConfirmationController newGameConfirmationController =
                new NewGameConfirmationController(card, parentPanel,
                        this, newGameUseCase);
        confirm.addActionListener(newGameConfirmationController);

        // ===== Reject button =====
        // --- Closes the window
        JButton reject = new JButton("No");
        reject.addActionListener(e -> this.dispose());

        panel.add(title);
        panel.add(confirm);
        panel.add(reject);
        this.add(panel);
        this.pack();
        viewWindow();
    }

    @Override
    public void viewWindow(){
        this.setVisible(true);
    }

}

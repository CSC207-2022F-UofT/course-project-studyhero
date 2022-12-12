package UI.screens.panels;

import errors.usecases.ErrorOutputBoundary;
import errors.usecases.ErrorPresenter;
import filesaver.usecases.file_checker.ValidFileDsGateway;
import filesaver.usecases.file_checker.ValidPlayerInventory;
import filesaver.usecases.file_checker.ValidShopInventory;
import filesaver.usecases.file_checker.ValidStats;
import filesaver.usecases.new_game.NewGame;
import filesaver.usecases.new_game.NewGameInputBoundary;
import filesaver.usecases.new_game.confirmation_window.NewGameConfirmationController;

import javax.swing.*;
import java.awt.*;

public class ConfirmationWindowView extends JFrame{

    private final static String statsFilepath = "stats.csv";
    private final static String playerInventoryFilepath = "PlayerInventory.csv";
    private final static String fightStatsFilepath = "fightStats.csv";
    private final static String shopInventoryFilepath = "ShopInventory.csv";
    private boolean visible;

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
    public ConfirmationWindowView(String confirmation, CardLayout card,
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
                        fightStatsChecker, presenter);
        NewGameConfirmationController newGameConfirmationController =
                new NewGameConfirmationController(card, parentPanel,
                        this, newGameUseCase);
        confirm.addActionListener(newGameConfirmationController);

        // ===== Reject button =====
        // --- Closes the window
        JButton reject = new JButton("No");
        reject.addActionListener(e -> {this.setVisible(false); this.visible = false;});

        panel.add(title);
        panel.add(confirm);
        panel.add(reject);
        this.add(panel);
        this.setSize(400, 200);
        this.pack();
        this.visible = false;
    }

    public boolean isVisible(){return this.visible;}

    public void viewWindow(){
        try{this.setVisible(true);}
        catch (HeadlessException ignored){
        }
        this.visible = true;
    }

}

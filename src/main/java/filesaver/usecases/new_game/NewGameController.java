package filesaver.usecases.new_game;

import filesaver.usecases.game_check.GameCheckInputBoundary;
import UI.screens.panels.ConfirmationWindowView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameController implements ActionListener {
    private final CardLayout card;
    private final JPanel parentPanel;
    private final GameCheckInputBoundary gameCheckUseCase;
    private final NewGameInputBoundary newGameUseCase;
    private final ConfirmationWindowView confirmationView;

    private String statsPath = "stats.csv";
    private String plyrInvPath = "PlayerInventory.csv";
    private String shpInvPath =  "ShopInventory.csv";
    private String fightStatsPath = "fightStats.csv";

    /**
     * Creates a GameCheckController object that handles all use cases
     * involving the starting of a new game, including prompting the user
     * to reconfirm their decision if all necessary game files exist and
     * are valid.
     *
     * @param card                  layout manager to allow user to see the
     *                              next screen
     * @param parentPanel           panel in GameMain that uses the card and
     *                              contains the next screen
     * @param gameCheckUseCase      Checks for valid game files
     * @param newGameUseCase        Generates all necessary game files
     * @param confirmationView   Presents to the user a confirmation window
     */
    public NewGameController(CardLayout card, JPanel parentPanel,
                             GameCheckInputBoundary gameCheckUseCase,
                             NewGameInputBoundary newGameUseCase,
                             ConfirmationWindowView confirmationView){
        this.gameCheckUseCase = gameCheckUseCase;
        this.newGameUseCase = newGameUseCase;
        this.card = card;
        this.parentPanel = parentPanel;
        this.confirmationView = confirmationView;
    }

    public String getStatsPath() {return statsPath;}
    public void setStatsPath(String newStatsPath){statsPath = newStatsPath;}
    public String getPlyrInvPath() {return plyrInvPath;}
    public void setPlyrInvPath(String newPlyrInvPath){
        this.plyrInvPath = newPlyrInvPath;}
    public String getShpInvPath() {return shpInvPath;}
    public void setShpInvPath(String newShpInvPath){
        this.shpInvPath = newShpInvPath;}
    public String getFightStatsPath(){return fightStatsPath;}
    public void setFightStatsPath(String fightStatsPath) {
        this.fightStatsPath = fightStatsPath;
    }

    /**
     * In the event of a button click, if all necessary game files are valid and
     * creating a new game will overwrite them, a confirmation window will be
     * opened for the user to reconfirm that decision before proceeding.
     * If any necessary game file doesn't exist or is invalid, then all new files
     * will be generated, stored and the user will see the next screen (story).
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameCheckUseCase.check()){
            confirmationView.viewWindow();
        }
        else{
            newGameUseCase.newGame(statsPath, plyrInvPath,
                    shpInvPath, fightStatsPath);
            try{card.show(parentPanel, "Story");}
            catch(HeadlessException ignored){}
        }
    }
}

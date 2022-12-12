package filesaver.usecases.new_game.confirmation_window;

import filesaver.usecases.new_game.NewGameInputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameConfirmationController implements ActionListener {
    private final CardLayout card;
    private final JPanel parentPanel;
    private final JFrame parentFrame;
    private final NewGameInputBoundary useCase;
    private String statsPath = "stats.csv";
    private String plyrInvPath = "PlayerInventory.csv";
    private String shpInvPath =  "ShopInventory.csv";
    private String fightStatsPath = "fightStats.csv";

    /**
     * Creates a NewGameConfirmationController object that handles the creation
     * of a new game after reconfirmation from the user.
     *
     * @param card              Layout manager to allow user to see the next screen
     * @param parentPanel       Panel that contains the next screen
     * @param parentFrame       Confirmation window
     * @param newGameUseCase    Input boundary that creates new game files
     */
    public NewGameConfirmationController(CardLayout card, JPanel parentPanel,
                                         JFrame parentFrame,
                                         NewGameInputBoundary newGameUseCase){
        this.card= card;
        this.parentPanel = parentPanel;
        this.parentFrame = parentFrame;
        this.useCase = newGameUseCase;
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
     * In the event of a button press, new game files are created, the confirmation
     * window closes and the user will see the story screen.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        useCase.newGame(statsPath, plyrInvPath,
                shpInvPath, fightStatsPath);
        parentFrame.dispose();
        card.show(parentPanel, "Story");
    }
}

package use_cases.new_game.confirmation_window;

import use_cases.new_game.NewGameInputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameConfirmationController implements ActionListener {
    private final CardLayout card;
    private final JPanel parentPanel;
    private final JFrame parentFrame;
    private final NewGameInputBoundary useCase;


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

    /**
     * In the event of a button press, new game files are created, the confirmation
     * window closes and the user will see the story screen.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        useCase.newGame();
        parentFrame.dispose();
        card.show(parentPanel, "Story");
    }
}

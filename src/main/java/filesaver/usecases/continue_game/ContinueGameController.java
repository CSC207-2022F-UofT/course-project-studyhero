package filesaver.usecases.continue_game;

import filesaver.usecases.game_check.GameCheckInputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContinueGameController implements ActionListener {
    private final CardLayout card;
    private final JPanel parent;
    private final GameCheckInputBoundary gameCheckUseCase;

    /**
     * Creates a ContinueGameController object that handles the use case
     * relating to continuing the game from the start screen.
     *
     * @param card      layout of the panel with the next screen (timer)
     *                  to direct the user to if the game is continuable
     * @param parent    parent panel where all main screens are stored in
     *                  the main game
     * @param useCase   input boundary that checks if the game is can be
     *                  continued
     */
    public ContinueGameController(CardLayout card, JPanel parent,
                                  GameCheckInputBoundary useCase){
        this.card = card;
        this.parent = parent;
        this.gameCheckUseCase = useCase;
    }

    /**
     * When a button is pressed (i.e. event e occurs), the input boundary
     * will check for whether existing data files are valid for continuing.
     * If so, the card will show the next screen (timer).
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameCheckUseCase.valid()){
            System.out.println("Game exists. Continuing to next game...");
            card.show(parent, "timer");
        }
    }
}

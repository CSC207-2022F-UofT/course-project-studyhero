package use_cases.new_game.confirmation_window;

import use_cases.errors.ErrorOutputBoundary;

import javax.swing.*;
import java.awt.*;

/**
 * A use case responsible for creating a confirmation window when starting a new game
 */
public class ConfirmationWindowInteractor implements ConfirmationWindowInputBoundary{
    private final String confirmation;
    private final CardLayout card;
    private final JPanel parentPanel;
    private final ErrorOutputBoundary presenter;

    /**
     * Creates a ConfirmationWindowInteractor object that can return an Output
     * Boundary to present to the user a confirmation message
     *
     * @param confirmation  Confirmation message
     * @param card          Card to allow the user to switch screens
     *                      after confirmation
     * @param parentPanel   Panel where desired screen is stored
     * @param presenter     Output boundary if error occurs
     */
    public ConfirmationWindowInteractor(String confirmation, CardLayout card,
                                        JPanel parentPanel,
                                        ErrorOutputBoundary presenter){
        this.confirmation = confirmation;
        this.card = card;
        this.parentPanel = parentPanel;
        this.presenter = presenter;
    }

    /**
     * @return presenter showing the confirmation message and functionalities
     * to confirm
     * or close the screen
     */
    public ConfirmationWindowOutputBoundary createWindow(){
        return new ConfirmationWindowPresenter(confirmation, card,
                parentPanel, presenter);
    }

}

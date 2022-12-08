package use_cases.new_game.confirmation_window;

import use_cases.errors.ErrorOutputBoundary;

import javax.swing.*;
import java.awt.*;

public class ConfirmationWindowInteractor implements ConfirmationWindowInputBoundary{
    private final String confirmation;
    private final CardLayout card;
    private final JPanel parentPanel;
    private final ErrorOutputBoundary presenter;

    public ConfirmationWindowInteractor(String confirmation, CardLayout card,
                                        JPanel parentPanel, ErrorOutputBoundary presenter){
        this.confirmation = confirmation;
        this.card = card;
        this.parentPanel = parentPanel;
        this.presenter = presenter;
    }

    public ConfirmationWindowOutputBoundary createWindow(){
        return new ConfirmationWindowPresenter(confirmation, card, parentPanel, presenter);
    }

}

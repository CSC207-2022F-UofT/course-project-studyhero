package controllers.new_game;

import use_cases.new_game.NewGame;
import use_cases.new_game.confirmation_window.ConfirmationWindowInteractor;
import use_cases.new_game.NewGameInputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameControllerOld implements ActionListener {
    private final CardLayout card;
    private final JPanel parentPanel;
    private final ConfirmationWindowInteractor confirmation;
    private final NewGameInputBoundary useCase;

    public NewGameControllerOld(CardLayout card, JPanel parent,
                                NewGame useCase, ConfirmationWindowInteractor confirmation){
        this.card = card;
        this.parentPanel = parent;
        this.useCase = useCase;
        this.confirmation = confirmation;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (useCase.isPlayable()){
            }
        else{
            useCase.newGame();
            card.show(parentPanel, "Story");
        }
    }

}

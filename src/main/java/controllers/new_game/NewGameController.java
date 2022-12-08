package controllers.new_game;

import use_cases.errors.ErrorOutputBoundary;
import use_cases.new_game.NewGame;
import use_cases.new_game.NewGameConfirmation;
import use_cases.new_game.NewGameInputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameController implements ActionListener {
    private final CardLayout card;
    private final JPanel parentPanel;
    private final NewGameConfirmation confirmation;
    private final NewGameInputBoundary useCase;

    public NewGameController(CardLayout card, JPanel parent,
                             NewGame useCase, NewGameConfirmation confirmation){
        this.card = card;
        this.parentPanel = parent;
        this.useCase = useCase;
        this.confirmation = confirmation;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (useCase.isPlayable()){
            confirmation.setVisible(true);}
        else{
            useCase.newGame();
            card.show(parentPanel, "Story");
        }
    }

}

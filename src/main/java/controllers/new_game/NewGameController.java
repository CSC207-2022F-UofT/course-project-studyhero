package controllers.new_game;

import use_cases.new_game.NewGame;
import use_cases.new_game.NewGameConfirmation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameController implements ActionListener {
    CardLayout card;
    JPanel parentPanel;
    NewGame useCase;

    public NewGameController(CardLayout card, JPanel parent, NewGame useCase){
        this.card = card;
        this.parentPanel = parent;
        this.useCase = useCase;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (useCase.isPlayable()){ new NewGameConfirmation(card, parentPanel);}
        else{
            useCase.newGame();
            card.show(parentPanel, "Story");
        }
    }

}

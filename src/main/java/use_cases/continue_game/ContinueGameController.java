package use_cases.continue_game;

import use_cases.errors.ErrorOutputBoundary;
import use_cases.game_check.GameCheckInputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContinueGameController implements ActionListener {
    private final CardLayout card;
    private final JPanel parent;
    private final GameCheckInputBoundary gameCheckUseCase;
    private final ErrorOutputBoundary presenter;

    public ContinueGameController(CardLayout card, JPanel parent,
                                  GameCheckInputBoundary useCase,
                                  ErrorOutputBoundary presenter){
        this.card = card;
        this.parent = parent;
        this.gameCheckUseCase = useCase;
        this.presenter = presenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("clicked");

        if (gameCheckUseCase.valid()){
            System.out.println("Game exists. Continuing to next game...");
            card.show(parent, "Timer");
        }
    }
}

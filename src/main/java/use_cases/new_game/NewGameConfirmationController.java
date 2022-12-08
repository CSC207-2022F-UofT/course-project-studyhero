package use_cases.new_game;

import use_cases.errors.ErrorOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameConfirmationController implements ActionListener {
    CardLayout card;
    JPanel parentPanel;
    JFrame parentFrame;
    private NewGameInputBoundary useCase;
    final ErrorOutputBoundary presenter;

    public NewGameConfirmationController(CardLayout card, JPanel parentPanel,
                                         JFrame parentFrame, NewGameInputBoundary newGameUseCase,
                                         ErrorOutputBoundary presenter){
        this.card= card;
        this.parentPanel = parentPanel;
        this.parentFrame = parentFrame;
        this.useCase = newGameUseCase;
        this.presenter = presenter;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        useCase.newGame();
        parentFrame.dispose();
        card.show(parentPanel, "Story");
    }
}

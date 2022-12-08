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


//    private final JFrame confirmationWindow;
//
//    public ConfirmationWindow(CardLayout card, JPanel parentPanel, boolean visible){
//        ErrorOutputBoundary presenter = new ErrorPresenter();
//        this.confirmationWindow = new JFrame();
//        JPanel confirmationPanel = new JPanel();
//        JLabel title = new JLabel("Are you sure? This will overwrite your existing save files.");
//
//        JButton confirm = new JButton("Yes");
//        NewGameConfirmationController newGameConfirmationController =
//                new NewGameConfirmationController(card, parentPanel, confirmationWindow, presenter);
//        confirm.addActionListener(newGameConfirmationController);
//
//        JButton reject = new JButton("No");
//        reject.addActionListener(e -> confirmationWindow.dispose());
//
//        confirmationPanel.add(title);
//        confirmationPanel.add(confirm);
//        confirmationPanel.add(reject);
//        confirmationWindow.add(confirmationPanel);
//        confirmationWindow.pack();
//        confirmationWindow.getDefaultCloseOperation();
//        confirmationWindow.setVisible(visible);
//    }
//
//    public void setVisible(boolean visible){
//        confirmationWindow.setVisible(visible);
//    }
}

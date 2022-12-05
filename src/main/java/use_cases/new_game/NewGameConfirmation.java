package use_cases.new_game;

import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;

import javax.swing.*;
import java.awt.*;

public class NewGameConfirmation {

    public NewGameConfirmation(CardLayout card, JPanel parentPanel){
        ErrorOutputBoundary presenter = new ErrorPresenter();
        JFrame confirmationWindow = new JFrame();
        JPanel confirmationPanel = new JPanel();
        JLabel title = new JLabel("Are you sure? This will overwrite your existing save files.");

        JButton confirm = new JButton("Yes");
        ConfirmationController confirmationController =
                new ConfirmationController(card, parentPanel, confirmationWindow, presenter);
        confirm.addActionListener(confirmationController);

        JButton reject = new JButton("No");
        reject.addActionListener(e -> confirmationWindow.dispose());

        confirmationPanel.add(title);
        confirmationPanel.add(confirm);
        confirmationPanel.add(reject);
        confirmationWindow.add(confirmationPanel);
        confirmationWindow.pack();
        confirmationWindow.getDefaultCloseOperation();
        confirmationWindow.setVisible(true);
    }
}

package use_cases.new_game.confirmation_window;

import use_cases.errors.ErrorOutputBoundary;
import use_cases.new_game.NewGameConfirmationController;

import javax.swing.*;
import java.awt.*;

public class ConfirmationWindowPresenter extends JFrame implements
        ConfirmationWindowOutputBoundary {

    public ConfirmationWindowPresenter(String confirmation, CardLayout card, JPanel parentPanel,
                                       ErrorOutputBoundary presenter){
        JLabel title = new JLabel(confirmation);
        JPanel panel = new JPanel();
        JButton confirm = new JButton("Yes");
        NewGameConfirmationController newGameConfirmationController =
                new NewGameConfirmationController(card, parentPanel, this, presenter);
        confirm.addActionListener(newGameConfirmationController);

        JButton reject = new JButton("No");
        reject.addActionListener(e -> this.dispose());

        panel.add(title);
        panel.add(confirm);
        panel.add(reject);
        this.add(panel);
        this.pack();
    }

    @Override
    public void viewWindow(){
        this.getDefaultCloseOperation();
        this.setVisible(true);
    }

}

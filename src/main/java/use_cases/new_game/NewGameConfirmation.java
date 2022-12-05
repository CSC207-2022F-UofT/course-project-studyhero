package use_cases.new_game;

import javax.swing.*;
import java.awt.*;

public class NewGameConfirmation {

    CardLayout card;
    JPanel parentPanel;

    public NewGameConfirmation(CardLayout card, JPanel parentPanel){
        JFrame confirmationWindow = new JFrame();
        JPanel confirmationPanel = new JPanel();
        JLabel title = new JLabel();
        title.setText("<html>"+ "Are you sure? This will overwrite your existing save files." +"</html>");

        JButton confirm = new JButton("Yes");
        ConfirmationController confirmationController =
                new ConfirmationController(card, parentPanel, confirmationWindow);
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

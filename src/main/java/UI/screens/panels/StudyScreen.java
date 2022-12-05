package UI.screens.panels;

import javax.swing.*;
import java.awt.*;

/* will be replaced by the timer screen later (named study screen for now)
 */
public class StudyScreen extends JPanel {
    CardLayout card;
    JPanel parentPanel;

    public StudyScreen(CardLayout card, JPanel parentPanel){
        this.card = card;
        this.parentPanel = parentPanel;

        JLabel title = new JLabel("Timer");
        this.add(title);

        JButton breakButton = new JButton("Break");
        breakButton.addActionListener(e -> card.show(parentPanel, "Break"));
        this.add(breakButton);
    }
}

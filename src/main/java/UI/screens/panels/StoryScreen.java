package UI.screens.panels;

import javax.swing.*;
import java.awt.*;

public class StoryScreen extends JPanel {

    CardLayout card;
    JPanel parentPanel;

    public StoryScreen(CardLayout card, JPanel parentPanel){
        this.card = card;
        this.parentPanel = parentPanel;

        JLabel title = new JLabel("Welcome to StudyHero (Story)");
        JTextArea textArea = new JTextArea("The story goes here");
        JLabel story = new JLabel("Story sdhfkslfjslfsjlfjslfjsljflsfjsfd." +
                "Skdjhfksjhfkshfkjshfkshfkshfksfdhksjf");

        this.add(title);
        this.add(textArea);
        this.add(story);

        JButton startNewGame = new JButton("Start your quest");
        startNewGame.addActionListener(e -> card.show(parentPanel, "Timer"));
        this.add(startNewGame);
    }

}

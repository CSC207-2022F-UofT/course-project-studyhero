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
        JLabel story = new JLabel("You are a hero set on killing The Bad Monster(tm)");
        JLabel story3 = new JLabel("After countless defeats, you've decided to put away your sword in its sheath, " +
                "and embark on a journey of study. ");
        JLabel story1 = new JLabel("Now, now. Go forth, and try your best to focus. " +
                "\n Your dignity is on the line.");
        JLabel story2 = new JLabel("Now, now. Go forth, and try your best to focus. " +
                "\n Your dignity is on the line.");

        this.add(title);
        this.add(story);
        this.add(story3);
        this.add(story1);
        this.add(story2);

        JButton startNewGame = new JButton("Start your quest");
        startNewGame.addActionListener(e -> card.show(parentPanel, "Break"));
        this.add(startNewGame);
    }

}

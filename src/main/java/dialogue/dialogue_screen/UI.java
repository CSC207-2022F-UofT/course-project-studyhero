package dialogue.dialogue_screen;

import javax.swing.*;
import java.awt.*;

/*
Creates UI Window to for the start screen/dialogue to appear.
 */

public class UI {
    JFrame window;
    JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, randomPanel;
    JLabel titleLabel;
    Font titleFont = new Font("Courier", Font.PLAIN, 90);
    Font normalFont = new Font("Courier", Font.PLAIN, 15);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea storyTextArea;

    public void createUI(DialogueGameScreen.ChoiceHandler cHandler) {

        // WINDOW
        window = new JFrame();
        window.setSize(800, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        // TITLE CONTAINER
        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 600, 100);
        titlePanel.setBackground(Color.blue);

        // TITLE LABEL
        titleLabel = new JLabel("STUDY HERO");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);

        // ADD TITLE LABEL TO CONTAINER
        titlePanel.add(titleLabel);

        // START BUTTON PANEL
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        // ACTUAL BUTTON
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startButtonPanel.add(startButton);

        // ADD EVERYTHING TO WINDOW
        window.add(titlePanel);
        window.add(startButtonPanel);

        // GAMEPLAY SCREEN

        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);

        storyTextArea = new JTextArea("This is where the dialogue lives");
        storyTextArea.setBounds(100, 100, 600, 250);
        storyTextArea.setBackground(Color.black);
        storyTextArea.setForeground(Color.white);
        storyTextArea.setFont(normalFont);
        storyTextArea.setLineWrap(true);
        storyTextArea.setEditable(false);

        mainTextPanel.add(storyTextArea);

        // PANEL FOR CHOICE BUTTONS
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 100);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        window.add(choiceButtonPanel);

        // CHOICE BUTTONS: C1
        choice1 = new JButton();
        choice1.setFont(normalFont);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice1.addActionListener(cHandler);

        // CHOICE BUTTONS: C2
        choice2 = new JButton();
        choice2.setFont(normalFont);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice2.addActionListener(cHandler);

        // CHOICE BUTTONS: C3
        choice3 = new JButton();
        choice3.setFont(normalFont);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice3.addActionListener(cHandler);

        // CHOICE BUTTONS: C4
        choice4 = new JButton();
        choice4.setFont(normalFont);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);
        choice4.addActionListener(cHandler);

        // RANDOM PANEL
        randomPanel = new JPanel();
        randomPanel.setBounds(100, 15, 600, 50);
        randomPanel.setBackground(Color.black);
        randomPanel.setLayout(new GridLayout(1, 4));
        window.add(randomPanel); // If I remove this, the buttons stop working.


        window.setVisible(true);

    }
}


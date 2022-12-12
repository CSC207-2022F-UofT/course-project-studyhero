package dialogue.ui_dialogue;
import javax.swing.*;
import java.awt.*;

public class UI {

    JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonsPanel, randomPanel;
    JLabel titleLabel;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea storyTextArea;
    Font titleFont = new Font("Courier", Font.PLAIN, 90);
    Font normalFont = new Font("Courier", Font.PLAIN, 15);

    public void createUI(DialogueGameScreen.ChoiceHandler cHandler) {
        JFrame window = new JFrame();
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
        choiceButtonsPanel = new JPanel();
        choiceButtonsPanel.setBounds(250, 350, 300, 100);
        choiceButtonsPanel.setBackground(Color.black);
        choiceButtonsPanel.setLayout(new GridLayout(4, 1));
        window.add(choiceButtonsPanel);

        // CHOICE BUTTONS: C1
        choice1 = new JButton();
        choice1.setFont(normalFont);
        // choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonsPanel.add(choice1);

        // CHOICE BUTTONS: C2
        choice2 = new JButton();
        choice2.setFont(normalFont);
        // choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonsPanel.add(choice2);

        // CHOICE BUTTONS: C3
        choice3 = new JButton();
        choice3.setFont(normalFont);
        // choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtonsPanel.add(choice3);

        // CHOICE BUTTONS: C4
        choice4 = new JButton();
        choice4.setFont(normalFont);
        // choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choiceButtonsPanel.add(choice4);

        // RANDOM PANEL
        randomPanel = new JPanel();
        randomPanel.setBounds(100, 15, 600, 50);
        randomPanel.setBackground(Color.black);
        randomPanel.setLayout(new GridLayout(1, 4));
        window.add(randomPanel); // If I remove this, the buttons stop working.


        window.setVisible(true);

    }
}


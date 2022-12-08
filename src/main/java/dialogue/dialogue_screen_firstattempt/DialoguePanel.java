package dialogue.dialogue_screen_firstattempt;

import dialogue.DialoguePresenter;

import javax.swing.*;
import java.awt.*;
/*
Creates the panel for the dialogue.
 */

public class DialoguePanel extends JPanel {

    // Graphics2D g2;

    Font dialogueFont = new Font("Papyrus", Font.PLAIN, 30);
    DialoguePresenter dPresenter = new DialoguePresenter();

    public DialoguePanel() {}

    public JPanel createDialoguePanel() {

        // ---------- DIALOGUE TEXT PANEL ---------- (textPanel)
        JPanel textPanel = new JPanel();
        textPanel.setBounds(200, 100, 400, 150);
        textPanel.setBackground(Color.blue);

        //              ACTUAL TEXT
        JTextArea mainTextArea = new JTextArea(dPresenter.showDialogue());
        mainTextArea.setBounds(200, 100, 400, 150);
        mainTextArea.setBackground(Color.red);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(dialogueFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        textPanel.add(mainTextArea);
        // ------------ (end of textPanel)--------------


        //TODO: Figure out how to add a graphics2d to a JPanel

        return textPanel;}


    }


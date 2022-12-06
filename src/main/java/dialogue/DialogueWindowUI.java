package dialogue;

import javax.swing.*;
import java.awt.*;

/*
Creates the window for the dialogue.
 */

public class DialogueWindowUI {

    Font dialogueFont = new Font("Papyrus", Font.PLAIN, 12);

    public void createWindow() {
        // ---------------- WINDOW
        JFrame window = new JFrame();
        window.setSize(800, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        // ---------- DIALOGUE TEXT PANEL ---------- (textPanel)
        JPanel textPanel = new JPanel();
        textPanel.setBounds(200, 100, 400, 150);
        textPanel.setBackground(Color.blue);

        //              ACTUAL TEXT
        JTextArea mainTextArea = new JTextArea("calls the presenter");
        mainTextArea.setBounds(200, 100, 400, 150);
        mainTextArea.setBackground(Color.red);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(dialogueFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        textPanel.add(mainTextArea);
        // ------------ (end of textPanel)--------------
        //TODO: Figure out how to make DialoguePanel work instead of this

        JPanel dialoguePanel1 = new DialoguePanel().createDialoguePanel();

        window.add(dialoguePanel1);
        // window.add(textPanel);

        window.setVisible(true);
    }

}

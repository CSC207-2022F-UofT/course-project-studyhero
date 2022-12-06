package dialogue;

import javax.swing.*;
import java.awt.*;
/*
Creates the panel for the dialogue.
 */

/*
TODO:
- Add ActionListener/KeyHandler
- Figure out how it goes to the "next screen"
- Should interact with: RequestModel, ResponseModel, DialogueController, DialoguePresenter
What the classes should do:
- RequestModel: Should there be a req. model?
- ResponseModel: ???
- DialogueController: Use an interactor to get dialogue.
- DialoguePresenter: Use an interactor to show dialogue.
 */

public class DialoguePanel extends JPanel {

    // Graphics2D g2;

    Font dialogueFont = new Font("Papyrus", Font.PLAIN, 12);

    public DialoguePanel() {}

    public JPanel createDialoguePanel() {

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


        //TODO: Figure out how to add a graphics2d to a JPanel

        return textPanel;}


    }


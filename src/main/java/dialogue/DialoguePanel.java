package dialogue;

import javax.swing.*;
import java.awt.*;

public class DialoguePanel extends JPanel {

    JPanel dialoguePanel;
    JTextArea dialogueText;
    Font dialoguefont = new Font("Papyrus", Font.PLAIN, 30);

    public DialoguePanel() {

        // DIALOGUE CONTAINER (PANEL)
        dialoguePanel = new JPanel();
        // dialoguePanel.setBounds(); TODO: Set bounds according to Cana's GUI
        dialoguePanel.setBackground(Color.black);

        // DIALOGUE TEXT

//        dialogueText = new JTextArea("");
//        dialogueText.setBounds(100, 100, 600, 250);
//        dialogueText.setBackground(Color.red);
//        dialogueText.setForeground(Color.white);
//        dialogueText.setFont(dialoguefont);
//        dialogueText.setLineWrap(true);
        // TODO: Figure out whether to create different Panels for different Dialogue Cases


    }


}

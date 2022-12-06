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

    JPanel dialoguePanel;
    JTextArea dialogueText;
    Font dialoguefont = new Font("Papyrus", Font.PLAIN, 30);

    public DialoguePanel() {

        // DIALOGUE CONTAINER (PANEL)
        dialoguePanel = new JPanel();
        dialoguePanel.setBounds(100, 100, 500, 150);
        dialoguePanel.setBackground(Color.black);

        // DIALOGUE TEXT

//        dialogueText = new JTextArea("AAAA");
//        dialogueText.setBounds(100, 100, 500, 150);
//        dialogueText.setBackground(Color.red);
//        dialogueText.setForeground(Color.white);
//        dialogueText.setFont(dialoguefont);
//        dialogueText.setLineWrap(true);
        // TODO: Figure out whether to create different Panels for different Dialogue Cases


    }


}

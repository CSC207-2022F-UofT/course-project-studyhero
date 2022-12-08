package dialogue.intro;
/*
The controller to be used after the user presses the "New Game" Button
 */

import dialogue.DialogueInputBoundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogueGameIntroController implements ActionListener{
    // TODO: After the user presses the button "New Game",
    //  The button calls the controller, which utilizes the InputBoundary.
    //  1) Figure out how to make it so this knows when a button is pressed.
    //  I think the controller has to call the Input Boundary?

    final DialogueInputBoundary requestDialogue;

    public DialogueGameIntroController(DialogueInputBoundary dialogueInput) {this.requestDialogue = dialogueInput;}

    @Override
    public void actionPerformed(ActionEvent e) {requestDialogue.getDialogue();}


}

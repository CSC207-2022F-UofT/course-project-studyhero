package dialogue.interface_adapters;
import dialogue.application_business_rules.DialogueInputBoundary;
import dialogue.application_business_rules.DialogueInteractor;

/*
Controller that dictates how the second button acts upon pressed.
*/
public class DialogueChoice2Controller {

    DialogueInputBoundary dialogueInputBoundary = new DialogueInteractor();

    public DialogueChoice2Controller(String nextPosition1) {
        dialogueInputBoundary.getDialogue();

    }
}

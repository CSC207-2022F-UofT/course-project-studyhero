package dialogue.interface_adapters;
import dialogue.application_business_rules.DialogueInputBoundary;
import dialogue.application_business_rules.DialogueInteractor;

/*
Controller that dictates how the bottom (last) button acts upon pressed.
*/

public class DialogueChoice4Controller {

    DialogueInputBoundary dialogueInputBoundary = new DialogueInteractor();

    public DialogueChoice4Controller(String nextPosition1) {
        dialogueInputBoundary.getDialogue();

    }
}

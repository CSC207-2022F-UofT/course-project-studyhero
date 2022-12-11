package dialogue.dialogue_clean.interface_adapters;
import dialogue.dialogue_clean.application_business_rules.DialogueInputBoundary;
import dialogue.dialogue_clean.application_business_rules.DialogueInteractor;

/*
Controller that dictates how the third/second-to-last button acts upon pressed.
*/

public class DialogueChoice3Controller {

    DialogueInputBoundary dialogueInputBoundary = new DialogueInteractor();

    public DialogueChoice3Controller(String nextPosition1) {
        dialogueInputBoundary.getDialogue();

    }
}

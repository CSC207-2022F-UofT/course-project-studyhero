package dialogue.dialogue_clean.interface_adapters;
import dialogue.dialogue_clean.application_business_rules.DialogueInputBoundary;
import dialogue.dialogue_clean.application_business_rules.DialogueInteractor;

/*
Controller that dictates how the bottom (last) button acts upon pressed.
*/

public class DialogueChoice4Controller {

    DialogueInputBoundary dialogueInputBoundary = new DialogueInteractor();

    public DialogueChoice4Controller(String nextPosition1) {
        dialogueInputBoundary.getDialogue();

    }
}

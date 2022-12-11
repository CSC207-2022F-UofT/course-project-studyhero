/*
Controller that dictates how the first (topmost) button acts upon pressed.
 */
package dialogue.dialogue_clean.interface_adapters;
import dialogue.dialogue_clean.application_business_rules.DialogueInputBoundary;
import dialogue.dialogue_clean.application_business_rules.DialogueInteractor;

/*
Controller that dictates how the first (topmost) button acts upon pressed.
 */

public class DialogueChoice1Controller{

    DialogueInputBoundary dialogueInputBoundary = new DialogueInteractor();

    public DialogueChoice1Controller(String nextPosition1) {
        dialogueInputBoundary.getDialogue();

    }
}


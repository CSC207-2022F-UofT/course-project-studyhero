/*
Controller that dictates how the first (topmost) button acts upon pressed.
 */
package dialogue.interface_adapters;
import dialogue.application_business_rules.DialogueInputBoundary;
import dialogue.application_business_rules.DialogueInteractor;

/*
Controller that dictates how the first (topmost) button acts upon pressed.
 */

public class DialogueChoice1Controller{

    DialogueInputBoundary dialogueInputBoundary = new DialogueInteractor();

    public DialogueChoice1Controller(String nextPosition1) {
        dialogueInputBoundary.getDialogue();

    }
}


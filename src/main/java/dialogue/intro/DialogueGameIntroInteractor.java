package dialogue.intro;

import dialogue.DialogueInputBoundary;
import dialogue.DialogueOutputBoundary;

/*
Use case interactor for the Dialogue at the Intro.
TODO:
- Call the Output Boundary
- Implement the Input Boundary
 */

public class DialogueGameIntroInteractor implements DialogueInputBoundary {

    String intro = DialogueGameIntroEntity.getDialogue();
    @Override
    public void getDialogue() { }


}

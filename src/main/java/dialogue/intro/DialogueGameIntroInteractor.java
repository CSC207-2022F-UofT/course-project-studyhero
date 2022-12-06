package dialogue.intro;

import dialogue.DialogueOutputBoundary;

public class DialogueGameIntroInteractor implements DialogueOutputBoundary {

    @Override
    public void getDialogue() {
        DialogueGameIntroEntity.getDialogue();
    }
}

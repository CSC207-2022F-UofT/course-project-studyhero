package dialogue.intro;

import dialogue.DialogueInputBoundary;
import dialogue.DialogueOutputBoundary;

/*
Use case interactor for the Dialogue at the Intro.
TODO:
 I think this has to call the OutputBoundary so it goes into the presenter.
- Call the Presenter
 */

public class DialogueGameIntroInteractor implements DialogueInputBoundary {

    final DialogueOutputBoundary dialoguePresenter;

    public DialogueGameIntroInteractor(DialogueOutputBoundary dialogueIntroPresenter) {
        this.dialoguePresenter = dialogueIntroPresenter;
    }

    @Override
    public void getDialogue() {
        DialogueOutputBoundary dialogueOutputBoundary = new DialogueOutputBoundary() {
            @Override
            public String showDialogue() {
                return DialogueGameIntroEntity.getDialogue1();

            }
        };
    }
}

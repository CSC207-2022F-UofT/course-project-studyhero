/*
Interactor: delegates which dialogue to show in the screen.

Issues:
Not implemented because I'm not sure how to access/keep track of the player's position.
 */
package dialogue.dialogue_clean.application_business_rules;
import dialogue.dialogue_clean.interface_adapters.DialoguePresenter;

public class DialogueInteractor implements DialogueInputBoundary{

    DialogueOutputBoundary dialogueOutput = new DialoguePresenter();

    public void introPosition() {
        // This is what the implementation of "StoryIntro" should be, in my opinion.
    }

    public void bossFightWin() {}

    public void bossFightDefeat() {}

    @Override
    public void getDialogue() {}
}

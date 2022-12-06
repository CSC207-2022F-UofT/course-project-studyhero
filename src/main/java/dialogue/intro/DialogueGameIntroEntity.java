package dialogue.intro;

import dialogue.DialogueEntity;

public class DialogueGameIntroEntity extends DialogueEntity {

    static String dialogue = "You are a valiant hero that needs to study.";

    public static String getDialogue() {return dialogue;}

    public void changeDialogue(String newDialogue) {
        dialogue = newDialogue;
    }
}

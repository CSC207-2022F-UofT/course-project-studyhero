package dialogue;
/*
Parent class for child Dialogue entities.
 */

public class DialogueEntity {

    String dialogue;

    public String getDialogue() {return dialogue;}

    public void changeDialogue(String newDialogue) { this.dialogue = newDialogue; }
}

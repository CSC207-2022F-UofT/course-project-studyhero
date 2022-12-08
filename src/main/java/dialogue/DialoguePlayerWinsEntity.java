package dialogue;
/*
Stores the dialogue entity to showcase after the player wins against the boss.
 */

public class DialoguePlayerWinsEntity extends DialogueEntity{

    static String dialogue = "Congratulations! The boss has been defeated. What do you wish to do next?";

    public String getDialogue() {return dialogue;}

    public void changeDialogue(String newDialogue) { dialogue = newDialogue;}
}

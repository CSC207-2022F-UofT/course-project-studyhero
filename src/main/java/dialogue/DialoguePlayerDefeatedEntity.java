package dialogue;

/*
Storse the dialogue that appears after the Player has lost the battle in the Boss fight.
 */

public class DialoguePlayerDefeatedEntity extends DialogueEntity{

    static String dialogue = "Try again later!";

    public String getDialogue() {return dialogue;}

    public void changeDialogue(String newDialogue) { dialogue = newDialogue;}


}

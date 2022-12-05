package dialogue;

/*
Dialogue that appears after the Player has lost the battle in the Boss fight.
 */

public class DialoguePlayerDefeatedEntity extends DialogueEntity{

    public void setDialogue() {
        dialogue = "Try again later!";}

    public String getDialogue() {return dialogue;}
}

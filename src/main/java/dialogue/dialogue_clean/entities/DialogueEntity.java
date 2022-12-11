package dialogue.dialogue_clean.entities;
import java.util.HashMap;

/*
Entities for the default dialogue, keeps track of which dialogue screen the player is in,
and has DialogueText.csv as a HashMap.

About Warnings:
- "Raw use of parametrized HashMap" not sure how to fix this one.
Adding <String, String> to the declaration still gives a warning.
 */

public class DialogueEntity extends DialogueEntityAbstract {

    String playerPosition;
    DialogueCSVReader csvReader = new DialogueCSVReader("DialogueText.csv");
    HashMap dialogueMap;

    public DialogueEntity() {dialogueMap = getDialogueMap();}

    public String getPlayerPosition() { return this.playerPosition; }

    public void setPlayerPosition(String currentPosition) {playerPosition = currentPosition;}

    public void setDialogueMap() {dialogueMap = csvReader.getDialogues();}

    public HashMap getDialogueMap() {return dialogueMap;}


}


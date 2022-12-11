package dialogue.dialogue_clean.entities;
import java.util.HashMap;
/*
An abstract class that provides a framework if it
is wished to add more the dialogue options later on.
 */

public class DialogueEntityAbstract {

    String playerPosition;

    DialogueCSVReader dialogueCSVReader;

    HashMap <String, String> dialogueMap;

    public String getPlayerPosition() { return null;}

    public void setPlayerPosition() {}

    public void setDialogueMap() {}

    public HashMap getDialogueMap() { return null; }
}

package dialogue.intro;
import dialogue.DialogueEntity;

/*
Contains the Dialogue to appear in the game introduction.

Note: Gives warning because this has not been implemented yet.
 */

public class DialogueGameIntroEntity extends DialogueEntity {

    static String dialogue1 = "You are a hero set on killing The Bad Monster(tm) \n " +
            "After countless defeats, you've decided to put away your sword in its sheath, " +
            "and embark on a journey of study. " +
            "\n\nWhat better way for success, \n other than to meticulously study your enemy's weaknesses?";

    static String dialogue2 = "Now, now. Go forth, and try your best to focus. \n Your dignity is on the line.";

    public static String getDialogue1() {return dialogue1;}

    public static String getDialogue2() {return dialogue2;}
}

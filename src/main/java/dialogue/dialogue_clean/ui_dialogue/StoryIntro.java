package dialogue.dialogue_clean.ui_dialogue;
/*
The first introductory dialogue that the player sees after pressing "start".
Part of the UI.

Issues:
- I'm unsure of how to make the dialogue be accessed from an external file, instead of hard-coding it.
 */
public class StoryIntro {

    public static void storyIntro(UI ui) {

        ui.storyTextArea.setText("You are a hero set on killing The Bad Monster(tm) \n " +
                "After countless defeats, you've decided to put away your sword in its sheath, " +
                "and embark on a journey of study. " +
                "\n\nWhat better way for success, \n other than to meticulously study your enemy's weaknesses?");

        ui.choice1.setText("Yes");
        ui.choice2.setText("Ok but, consider: Violence.");
        ui.choice3.setText("Actually-");
        ui.choice4.setText("...");

    }
}

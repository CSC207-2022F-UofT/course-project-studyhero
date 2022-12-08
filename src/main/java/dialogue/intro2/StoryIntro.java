package dialogue.intro2;

/*
Contains the Introduction Story to the Game.
 */

public class StoryIntro {
    DialogueGame gameScreen;
    UI ui;
    VisibilityManager vm;

    public StoryIntro(DialogueGame g, UI userInterface, VisibilityManager vManager) {
        gameScreen = g;
        ui = userInterface;
        vm = vManager;
    }

    public void selectPosition(String nextPosition) {

        if ("secondScreen".equals(nextPosition)) { secondScreen();}

    }

    public void introStory() {
        ui.storyTextArea.setText("You are a hero set on killing The Bad Monster(tm) \n " +
                "After countless defeats, you've decided to put away your sword in its sheath, " +
                "and embark on a journey of study. " +
                "\n\nWhat better way for success, \n other than to meticulously study your enemy's weaknesses?");

        ui.choice1.setText("Yes");
        ui.choice2.setText("Ok but, consider: violence.");
        ui.choice3.setText("Actually-");
        ui.choice4.setText("...");

        gameScreen.nextPosition = "secondScreen";
    }

    public void secondScreen() {
        ui.storyTextArea.setText("Now, now. Go forth, and try your best to focus. \n Your dignity is on the line.");
        ui.choice1.setText("Start studying!");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
    }


}

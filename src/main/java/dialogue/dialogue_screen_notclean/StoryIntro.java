package dialogue.dialogue_screen_notclean;

/*
Contains the Introduction Story and options to the Game.

I think this would be the equivalent to the interactor?
It uses the UI and vm though (frameworks layer), so that's a no-no.
 */

public class StoryIntro {
    DialogueGameScreen gameScreen;
    UI ui;
    VisibilityManager vm;

    public StoryIntro(DialogueGameScreen g, UI userInterface, VisibilityManager vManager) {
        gameScreen = g;
        ui = userInterface;
        vm = vManager;
    }

    public void selectPosition(String nextPosition) {
        if ("secondScreen".equals(nextPosition)) { secondScreen();}
        else if (nextPosition.equals("introStory")) { introStory();}

    }

    public void introStory() {
        ui.storyTextArea.setText("You are a hero set on killing The Bad Monster(tm) \n " +
                "After countless defeats, you've decided to put away your sword in its sheath, " +
                "and embark on a journey of study. " +
                "\n\nWhat better way for success, \n other than to meticulously study your enemy's weaknesses?");

        ui.choice1.setText("Yes");
        ui.choice2.setText("Ok but, consider: Violence.");
        ui.choice3.setText("Actually-");
        ui.choice4.setText("...");

        gameScreen.nextPosition = "secondScreen";
        gameScreen.nextPosition2 = "secondScreen";
    }

    public void secondScreen() {
        ui.storyTextArea.setText("Now, now. Go forth, and try your best to focus. \n Your dignity is on the line.");
        ui.choice1.setText("Start studying!");
        ui.choice2.setText("Go back");
        ui.choice3.setText("");
        ui.choice4.setText("");

        gameScreen.nextPosition = "";
        gameScreen.nextPosition2 = "introStory";
        // Missing: make it so that pressing c1 leads to the timer screen.
    }


}

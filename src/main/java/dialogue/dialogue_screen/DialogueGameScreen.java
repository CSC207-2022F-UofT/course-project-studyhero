package dialogue.dialogue_screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
Game screen for the Introduction Story/Dialogue of the Game
 */

public class DialogueGameScreen {

    ChoiceHandler cHandler = new ChoiceHandler();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    StoryIntro story = new StoryIntro(this, ui, vm);
    String nextPosition;



    public static void main(String[] args) {new DialogueGameScreen();}

    public DialogueGameScreen(){
        ui.createUI(cHandler);
        vm.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch(yourChoice){
                case "start": vm.initialScreen(); story.introStory(); break;
                case "c1": story.selectPosition(nextPosition);
                case "c2": story.selectPosition(nextPosition);
                case "c3": story.selectPosition(nextPosition);
                case "c4": story.selectPosition(nextPosition);
            }
        }
    }
}

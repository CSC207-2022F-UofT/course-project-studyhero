package dialogue.dialogue_screen_notclean;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
Game screen for the Introduction Story/Dialogue of the Game

Outermost layer of CA.
 */

public class DialogueGameScreen {

    ChoiceHandler cHandler = new ChoiceHandler();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    StoryIntro story = new StoryIntro(this, ui, vm);
    String nextPosition, nextPosition2;



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
                case "c1": story.selectPosition(nextPosition); break;
                case "c2": story.selectPosition(nextPosition2); break;
                case "c3": story.selectPosition(nextPosition); break;
                case "c4": story.selectPosition(nextPosition); break;
            }
        }
    }
}

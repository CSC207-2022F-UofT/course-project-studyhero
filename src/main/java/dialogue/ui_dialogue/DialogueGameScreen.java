package dialogue.ui_dialogue;
import dialogue.interface_adapters.DialogueChoice1Controller;
import dialogue.interface_adapters.DialogueChoice2Controller;
import dialogue.interface_adapters.DialogueChoice3Controller;
import dialogue.interface_adapters.DialogueChoice4Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Screen for the Dialogue component of the Game. Unfortunately this is not implemented.
Only the "start" button works.

Issues encountered:
- In a way, the dialogue text is an entity, but I'm not sure how to make it
so that it transfers from the entities layer to the ui's ".setText" method, without
going across layers.
- I am also not sure how to make it so that the screen registers the player's "position"
based on the button they press, as the position is also an entity.
Sorry if this explanation doesn't make sense!
 */

public class DialogueGameScreen {

    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    ChoiceHandler cHandler = new ChoiceHandler();

    public static void main(String[] args) { new DialogueGameScreen();}

    public DialogueGameScreen() {
        ui.createUI(cHandler);
        vm.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String yourChoice = e.getActionCommand();

            switch(yourChoice){
                case "start": vm.initialScreen(); StoryIntro.storyIntro(ui); break;
                case "c1": new DialogueChoice1Controller(nextPosition1); break;
                case "c2": new DialogueChoice2Controller(nextPosition2); break;
                case "c3": new DialogueChoice3Controller(nextPosition3); break;
                case "c4": new DialogueChoice4Controller(nextPosition4); break;
            }
        }
    }
}

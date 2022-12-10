package dialogue.dialogue_screen_notclean;

/*
Disables the start screen after the player presses "start".
 */

public class VisibilityManager {

    UI ui;

    public VisibilityManager(UI userInterface) { ui = userInterface;}

    public void showTitleScreen(){
        // Show title screen
        ui.titlePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        // Hide the game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.randomPanel.setVisible(false);}

    public void initialScreen() {
        // Show title screen
        ui.titlePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        // Hide the game screen
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.randomPanel.setVisible(true);
    }
}


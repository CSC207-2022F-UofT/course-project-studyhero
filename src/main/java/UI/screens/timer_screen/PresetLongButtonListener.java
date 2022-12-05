package UI.screens.timer_screen;

import saveGame.saveGameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresetLongButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        saveGameController.saveGame();
    }
}

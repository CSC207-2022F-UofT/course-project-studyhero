package UI.buttons.save_game;

import saveGame.saveGameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class saveGameButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        saveGameController.saveGame();
    }
}

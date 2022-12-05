package UI.buttons.load_game;

import loadGame.loadGameContoller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loadGameButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        loadGameContoller.loadGame();
    }
}

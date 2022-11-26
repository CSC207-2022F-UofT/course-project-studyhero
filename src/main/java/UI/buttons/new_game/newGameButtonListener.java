package UI.buttons.new_game;

import newGame.newGameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newGameButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        newGameController.newGame();
//        switchScreens( "Break");
    }
}

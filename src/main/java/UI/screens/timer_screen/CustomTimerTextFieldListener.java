package UI.screens.timer_screen;

import loadGame.loadGameContoller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomTimerTextFieldListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        loadGameContoller.loadGame();
    }
}

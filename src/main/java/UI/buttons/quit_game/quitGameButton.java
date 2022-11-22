package UI.buttons.quit_game;

import UI.buttons.button;

import javax.swing.*;

public class quitGameButton extends button {
    public static JButton quitGameButton = createButton("Quit Game", new quitGameButtonListener());

    public static JButton getQuitGameButton() {
        return quitGameButton;
    }
}

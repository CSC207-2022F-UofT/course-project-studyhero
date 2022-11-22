package UI.buttons.new_game;

import UI.buttons.button;

import javax.swing.*;

public class newGameButton extends button {
    public static JButton getNewGameButton() {
        JButton newGameButton = createButton("New Game",
                new newGameButtonListener());
        return newGameButton;
    }
}

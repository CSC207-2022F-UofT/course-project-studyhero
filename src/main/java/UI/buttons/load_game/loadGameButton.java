package UI.buttons.load_game;

import UI.buttons.button;

import javax.swing.*;

public class loadGameButton extends button {
    public static JButton loadGameButton = createButton("Load Game",
            new loadGameButtonListener());

    public static JButton getLoadGameButton() {
        return loadGameButton;
    }
}
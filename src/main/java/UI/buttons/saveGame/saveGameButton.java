package UI.buttons.saveGame;

import UI.buttons.button;

import javax.swing.*;

public class saveGameButton extends button {
    public static JButton saveGameButton = createButton("Save Game",
            new saveGameButtonListener());

    public static JButton getSaveGameButton() {
        return saveGameButton;
    }
}

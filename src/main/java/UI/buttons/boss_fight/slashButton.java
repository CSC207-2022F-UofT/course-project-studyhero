package UI.buttons.boss_fight;

import UI.buttons.button;

import javax.swing.*;

public class slashButton extends button {
    public static JButton slashButton = createButton("Slash",
            new slashButtonListener());

    public static JButton getSlashButton() {
        return slashButton;
    }
}

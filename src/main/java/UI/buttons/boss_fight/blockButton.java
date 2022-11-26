package UI.buttons.boss_fight;

import UI.buttons.button;

import javax.swing.*;

public class blockButton extends button {
    public static JButton blockButton = createButton("Block",
            new blockButtonListener());

    public static JButton getBlockButton() {
        return blockButton;
    }
}

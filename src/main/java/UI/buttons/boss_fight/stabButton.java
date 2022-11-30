package UI.buttons.boss_fight;

import UI.buttons.button;
import UI.buttons.load_game.loadGameButtonListener;

import javax.swing.*;

public class stabButton extends button {
    public static JButton stabButton = createButton("Stab",
            new stabButtonListener());

    public static JButton getStabButton() {
        return stabButton;
    }
}

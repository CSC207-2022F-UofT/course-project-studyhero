package UI.buttons.boss_fight;

import UI.buttons.button;

import javax.swing.*;

public class runAwayButton extends button {

    // !!! This button is not being used!!!!
    public static JButton runAwayButton = createButton("Run Away",
            new runAwayButtonListener());

    public static JButton getRunAwayButton() {
        return runAwayButton;
    }
}

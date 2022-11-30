package UI.buttons.boss_fight;

import UI.buttons.button;

import javax.swing.*;

public class useConsumableButton extends button {
    public static JButton useConsumableButton = createButton("Use Consumable",
            new useConsumableButtonListener());

    public static JButton getUseConsumableButton() {
        return useConsumableButton;
    }
}

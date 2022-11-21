package UI.buttons.shop;

import UI.buttons.button;

import javax.swing.*;

public class BuyItemButtonUI extends button {
    public static JButton getBuyItemButton() {
        return createButton("Buy Item", new buyItemButtonListener());
    }

}

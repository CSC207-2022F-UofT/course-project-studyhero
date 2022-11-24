package UI.buttons.shop;

import UI.buttons.button;

import javax.swing.*;

public class BuyMenuButtonUI extends button{
    public static JButton getBuyMenuButton() {
        return createButton("Buy Menu", new buyMenuButtonListener());
    }
}

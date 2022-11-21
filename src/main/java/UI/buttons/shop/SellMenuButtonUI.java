package UI.buttons.shop;
import UI.buttons.button;

import javax.swing.*;

public class SellMenuButtonUI extends button{
    public static JButton getSellMenuButton() {
        return createButton("Sell Menu", new sellMenuButtonListener());
    }
}

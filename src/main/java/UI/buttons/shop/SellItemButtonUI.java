package UI.buttons.shop;
import UI.buttons.button;

import javax.swing.*;

public class SellItemButtonUI extends button{
    public static JButton getSellItemButton() {
        return createButton("Sell Item", new sellItemButtonListener());
    }
}

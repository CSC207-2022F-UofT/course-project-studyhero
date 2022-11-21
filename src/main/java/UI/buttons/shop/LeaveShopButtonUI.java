package UI.buttons.shop;
import UI.buttons.button;

import javax.swing.*;

public class LeaveShopButtonUI extends button{
    public static JButton getLeaveShopButton() {
        return createButton("Leave Shop", new leaveShopButtonListener());
    }
}

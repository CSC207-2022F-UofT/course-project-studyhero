package screens.panels;

import javax.swing.*;

import static UI.buttons.shop.BuyItemButtonUI.getBuyItemButton;
import static UI.buttons.shop.BuyMenuButtonUI.getBuyMenuButton;
import static UI.buttons.shop.LeaveShopButtonUI.getLeaveShopButton;
import static UI.buttons.shop.SellItemButtonUI.getSellItemButton;
import static UI.buttons.shop.SellMenuButtonUI.getSellMenuButton;

public class shopPanel {
    public static JPanel shopPanel(){
        JPanel shopPanel = new JPanel();
        JLabel title = new JLabel("Shop Screen");

        JButton buyItemButton = getBuyItemButton();
        JButton buyMenuButton = getBuyMenuButton();
        JButton leaveShopButton = getLeaveShopButton();
        JButton sellItemButton = getSellItemButton();
        JButton sellMenuButton = getSellMenuButton();

        shopPanel.add(title);
        shopPanel.add(buyItemButton);
        shopPanel.add(buyMenuButton);
        shopPanel.add(leaveShopButton);
        shopPanel.add(sellItemButton);
        shopPanel.add(sellMenuButton);

        return shopPanel;
    }
}

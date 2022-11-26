package screens.panels;

import javax.swing.*;

import static UI.buttons.shop.BuyItemButtonUI.getBuyItemButton;
import static UI.buttons.shop.SellItemButtonUI.getSellItemButton;

public class sellMenuPanel {
    public static JPanel sellMenuPanel() {
        //initialise new panel
        JPanel buyPanel = new JPanel();
        JLabel title = new JLabel("Sell Menu");

        //initialise content
        JTextArea text = new JTextArea();
        JButton sellItemButton = getSellItemButton();

        buyPanel.add(title);
        buyPanel.add(text);
        buyPanel.add(sellItemButton);

        return buyPanel;}
}

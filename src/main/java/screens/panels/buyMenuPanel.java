package screens.panels;

import javax.swing.*;

import static UI.buttons.shop.BuyItemButtonUI.getBuyItemButton;


public class buyMenuPanel {
    public static JPanel buyMenuPanel() {
        //initialise new panel
        JPanel buyPanel = new JPanel();
        JLabel title = new JLabel("Buy Menu");

        //initialise content
        JTextArea text = new JTextArea();
        JButton buyItemButton = getBuyItemButton();

        buyPanel.add(title);
        buyPanel.add(text);
        buyPanel.add(buyItemButton);

        return buyPanel;}
}

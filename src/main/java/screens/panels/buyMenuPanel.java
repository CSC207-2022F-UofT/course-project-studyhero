package screens.panels;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.Dimension;

import static UI.buttons.shop.BuyItemButtonUI.getBuyItemButton;

// get gold
// get inventory list

public class buyMenuPanel extends JFrame implements ListSelectionListener {
    static JList list;
    static JLabel selectedItem;
    static JLabel cost;

    public static JPanel buyMenuPanel() {
        // Initialize new panels
        JPanel mainPanel = new JPanel(); // mainPanel
        JPanel buyPanel = new JPanel(); // Panel for buying items (shop & user panels)
        JPanel userPanel = new JPanel(); // User Inventory
        JPanel shopPanel = new JPanel(); // Shop Inventory
        JPanel botPanel = new JPanel(); // Bottom Panel
        JPanel topPanel = new JPanel(); // Top Panel
        JLabel title = new JLabel("Buy Menu");

        // TEMPORARY: ADD LIST
        buyMenuPanel s = new buyMenuPanel();

        String week[] = { "One", "Two", "Three", "Four" };
        list = new JList(week);

        list.clearSelection();
        list.addListSelectionListener(s);
        list.setMaximumSize(new Dimension(400, 300));

        selectedItem = new JLabel("Selected: ");
        cost = new JLabel("Cost: ");


        // user and shop Layout
        BoxLayout userBox = new BoxLayout(userPanel, BoxLayout.Y_AXIS);
        userPanel.setLayout(userBox);

        BoxLayout shopBox = new BoxLayout(shopPanel, BoxLayout.Y_AXIS);
        shopPanel.setLayout(shopBox);

        // buy Layout
        BoxLayout buyBox = new BoxLayout(buyPanel, BoxLayout.X_AXIS);
        buyPanel.setLayout(buyBox);

        //top Layout
        BoxLayout topBox = new BoxLayout(topPanel, BoxLayout.Y_AXIS);
        topPanel.setLayout(topBox);

        // main Layout
        BoxLayout mainBox = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(mainBox);

        /*
         * INITIALIZE CONTENT
         */
        JButton buyItemButton = getBuyItemButton();

        JLabel itemsOwned = new JLabel("Quantity Owned: " + "0");
        JLabel shopInv = new JLabel("Shop Inventory");

        /*
         * ADDING PANELS
         */

        // topPanel
        mainPanel.add(title);

        // userPanel
        userPanel.add(itemsOwned);
        userPanel.add(buyItemButton);

        // shopPanel
        shopPanel.add(shopInv, BorderLayout.EAST);
        shopPanel.add(list);
        shopPanel.add(selectedItem);
        shopPanel.add(cost);

        // buyPanel (add user and shop)
        buyPanel.add(shopPanel, BorderLayout.WEST);
        buyPanel.add(userPanel, BorderLayout.EAST);
        buyPanel.setPreferredSize(new Dimension(300,300));

        // add all to mainPanel
        mainPanel.add(topPanel);
        mainPanel.add(buyPanel);
        mainPanel.add(botPanel);

        return mainPanel;
    }

    public void valueChanged(ListSelectionEvent e) {
        selectedItem.setText("Selected: " + list.getSelectedValue().toString());
        cost.setText("Cost: " + list.getSelectedIndex());
    }
}


package screens.panels;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.Dimension;

import static UI.buttons.shop.SellItemButtonUI.getSellItemButton;

public class sellMenuPanel extends JFrame implements ListSelectionListener {

    static JList list;
    static JLabel selectedItem;
    static JLabel cost;
    public static JPanel sellMenuPanel() {
        //initialise new panels
        JPanel mainPanel = new JPanel();
        JPanel sellPanel = new JPanel();
        JPanel userPanel = new JPanel();
        JPanel shopPanel = new JPanel();
        JPanel botPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JLabel title = new JLabel("Sell Menu");

        // Temporary: Add list
        sellMenuPanel s = new sellMenuPanel();
        String week[] = { "One", "Two", "Three", "Four" };
        list = new JList(week);

        list.clearSelection();
        list.addListSelectionListener(s);
        list.setMaximumSize(new Dimension(400, 300));

        selectedItem = new JLabel("Selected: ");
        cost = new JLabel("Sell Cost: ");

        //initialise content
        JButton sellItemButton = getSellItemButton();
        JLabel userInv = new JLabel("User Inventory");

        // Layouts
        BoxLayout userBox = new BoxLayout(userPanel, BoxLayout.Y_AXIS);
        userPanel.setLayout(userBox);

        BoxLayout shopBox = new BoxLayout(shopPanel, BoxLayout.Y_AXIS);
        shopPanel.setLayout(shopBox);

        BoxLayout sellBox = new BoxLayout(sellPanel, BoxLayout.X_AXIS);
        sellPanel.setLayout(sellBox);

        BoxLayout topBox = new BoxLayout(topPanel, BoxLayout.Y_AXIS);
        topPanel.setLayout(topBox);

        BoxLayout mainBox = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(mainBox);

        // Adding Panels
        mainPanel.add(title);

        userPanel.add(userInv);
        userPanel.add(list);

        shopPanel.add(selectedItem);
        shopPanel.add(cost);
        shopPanel.add(sellItemButton);

        sellPanel.add(userPanel, BorderLayout.WEST);
        sellPanel.add(shopPanel, BorderLayout.EAST);

        // Add to Main
        mainPanel.add(sellPanel);

        return mainPanel;
    }
    public void valueChanged(ListSelectionEvent e) {
        selectedItem.setText("Selected: " + list.getSelectedValue().toString());
        cost.setText("Sell Cost: " + list.getSelectedIndex());
    }
}

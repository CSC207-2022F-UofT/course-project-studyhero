package screens.panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

import static UI.buttons.shop.BuyItemButtonUI.getBuyItemButton;

// get gold
// get inventory list

public class buyMenuPanel extends JFrame implements ListSelectionListener {
    static JList b;
    static JLabel l1;

    public static JPanel buyMenuPanel() {
        //initialise new panels
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
        JList b = new JList(week);
        JLabel test = new JLabel("This is a Test");
        b.setSelectedIndex(0);
        test.setText(b.getSelectedValue().toString());
        b.addListSelectionListener(s);

        // user and shop Layout
        BoxLayout userBox = new BoxLayout(userPanel, BoxLayout.Y_AXIS);
        userPanel.setLayout(userBox);
        userPanel.setBorder(new EmptyBorder(new Insets(150,75,150,75))); // border

        BoxLayout shopBox = new BoxLayout(shopPanel, BoxLayout.Y_AXIS);
        shopPanel.setLayout(shopBox);
        shopPanel.setBorder(new EmptyBorder(new Insets(150,75,150,75))); // border

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

        JLabel playerItems = new JLabel("Player's Inventory");
        JLabel shopInv = new JLabel("Shop Inventory");

        /*
         * ADDING PANELS
         */

        // botPanel
        mainPanel.add(title);

        // topPanel
        shopPanel.add(test);

        // userPanel
        userPanel.add(buyItemButton, BorderLayout.CENTER);
        userPanel.add(playerItems, BorderLayout.CENTER);

        // shopPanel
        shopPanel.add(shopInv);
        shopPanel.add(b);


        // buyPanel (add user and shop)
        buyPanel.add(shopPanel);
        buyPanel.add(userPanel);

        // add all to mainPanel
        mainPanel.add(topPanel);
        mainPanel.add(buyPanel, BorderLayout.CENTER);
        mainPanel.add(botPanel, BorderLayout.CENTER);



        return mainPanel;
    }
    public void valueChanged(ListSelectionEvent e) {
        l1.setText(b.getSelectedValue().toString());
    }
}


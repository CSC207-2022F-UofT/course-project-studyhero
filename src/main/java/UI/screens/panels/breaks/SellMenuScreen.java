package UI.screens.panels.breaks;

import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryResponseModel;
import inventorymenu.inventoryitem.InventoryItemDsRequestModel;
import inventorymenu.inventoryitem.ShopInventoryFile;
import inventorymenu.inventoryitem.PlayerInventoryFile;
import entities.Stats;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.file_checker.ValidStats;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
public class SellMenuScreen extends JPanel implements ListSelectionListener {
    CardLayout card;
    JPanel parentPanel;

    static JList list;
    static JLabel selectedItem;
    static JLabel cost;

    static Stats stats;
    ErrorOutputBoundary presenter;
    static ArrayList<InventoryItemDsRequestModel> shopInventory;
    static ArrayList<InventoryItemDsRequestModel> playerInventory;


    public SellMenuScreen(CardLayout card, JPanel parentPanel) {
        // ----- Initialize Panels -----
        JPanel sellPanel = new JPanel();
        JPanel userPanel = new JPanel();
        JPanel shopPanel = new JPanel();
        JPanel topPanel = new JPanel();

        // ----- Initialize Files for List Generation -----
        // NOTE: MOVE THIS TO SHOP MENU
        // Shop Inventory
        ShopInventoryFile shopInventoryFile = new ShopInventoryFile("ShopInventory.csv");
        shopInventoryFile.initialize();
        shopInventoryFile.readInventoryList();
        PlayerDisplayInventoryDsRequestModel shopIterator = shopInventoryFile.getInventoryListIterator();
        shopInventory = new ArrayList<>();
        while (shopIterator.hasNext()) {
            shopInventory.add(shopIterator.getNext());
        }

        // Player Inventory
        PlayerInventoryFile playerInventoryFile =  new PlayerInventoryFile("PlayerInventory.csv");
        playerInventoryFile.readInventoryList();
//        PlayerDisplayInventoryResponseModel displayInventoryResponseModel = displayInventoryController.display();
        PlayerDisplayInventoryDsRequestModel playerIterator = playerInventoryFile.getInventoryListIterator();
        playerInventory = new ArrayList<>();
        while (playerIterator.hasNext()) {
            playerInventory.add(playerIterator.getNext());
        }


        // Displays user items
        ArrayList<String> displayUserItems = new ArrayList<>();
        for (int item = 0; item < playerInventory.size(); item++) {
            displayUserItems.add(playerInventory.get(item).getName());
        }

        // Temporary: Add list
        list = new JList(displayUserItems.toArray());

        list.clearSelection();
        list.addListSelectionListener(this);
        list.setMaximumSize(new Dimension(200, 200));

        selectedItem = new JLabel("Selected: ");
        cost = new JLabel("Sell Cost: ");


        // ----- Initialize Components -----
        this.card = card;
        this.parentPanel = parentPanel;

        JLabel title = new JLabel("Sell Menu");

        JLabel userInv = new JLabel("User Inventory");

        JButton backToBreak = new JButton("Back");
        backToBreak.addActionListener(e -> card.show(parentPanel, "Shop Menu"));


        // Layouts
        BoxLayout mainBox = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(mainBox);

        BoxLayout userBox = new BoxLayout(userPanel, BoxLayout.Y_AXIS);
        userPanel.setLayout(userBox);

        BoxLayout shopBox = new BoxLayout(shopPanel, BoxLayout.Y_AXIS);
        shopPanel.setLayout(shopBox);

        BoxLayout sellBox = new BoxLayout(sellPanel, BoxLayout.X_AXIS);
        sellPanel.setLayout(sellBox);

        BoxLayout topBox = new BoxLayout(topPanel, BoxLayout.Y_AXIS);
        topPanel.setLayout(topBox);

        // ----- Add Components to Panels -----
        topPanel.add(title);

        userPanel.add(userInv);
        userPanel.add(list);

        shopPanel.add(selectedItem);
        shopPanel.add(cost);

        sellPanel.add(userPanel, BorderLayout.WEST);
        sellPanel.add(shopPanel, BorderLayout.EAST);

        this.add(topPanel);
        this.add(sellPanel);
        this.add(backToBreak);
    }

    public void valueChanged(ListSelectionEvent e) {
        selectedItem.setText("Selected: " + list.getSelectedValue().toString());
        cost.setText("Sell Cost: " + list.getSelectedIndex());
    }
}

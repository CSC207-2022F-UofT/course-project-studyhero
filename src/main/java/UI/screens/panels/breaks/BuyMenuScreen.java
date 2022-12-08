package UI.screens.panels.breaks;

import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
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


public class BuyMenuScreen extends JPanel implements ListSelectionListener, ActionListener {
    CardLayout card;
    JPanel parentPanel;

    static JList list;
    static int index;
    static JLabel selectedItem;
    static JLabel cost;

    static Stats stats;
    ErrorOutputBoundary presenter;
    static ArrayList<InventoryItemDsRequestModel> shopInventory;
    static ArrayList<InventoryItemDsRequestModel> playerInventory;


    public BuyMenuScreen(CardLayout card, JPanel parentPanel) {

        // ----- Initialize Panels -----
        JPanel buyPanel = new JPanel();
        JPanel userPanel = new JPanel();
        JPanel shopPanel = new JPanel();
        JPanel topPanel = new JPanel();

        // ----- Initialize Gold Values -----
        ValidStats stats = new ValidStats("stats.csv", presenter);
        Map<String, Integer> statsMap = stats.load();
        System.out.println(statsMap.get("gold"));

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
        PlayerDisplayInventoryDsRequestModel playerIterator = playerInventoryFile.getInventoryListIterator();
        playerInventory = new ArrayList<>();
        while (playerIterator.hasNext()) {
            playerInventory.add(playerIterator.getNext());
        }


        // Displays shop items
        ArrayList<String> displayShopItems = new ArrayList<>();
        for (int item = 0; item < shopInventory.size(); item ++) {
            displayShopItems.add(shopInventory.get(item).getName());
        }


        // ----- List Selection -----
        list = new JList(displayShopItems.toArray());

        list.clearSelection();
        list.addListSelectionListener(this);
        list.setMaximumSize(new Dimension(200, 200));


        // ----- Buy Button -----
        JButton buyButton = new JButton("Buy Selected Item");
        buyButton.addActionListener(this);


        // ---- Initialize Components -----
        this.card = card;
        this.parentPanel = parentPanel;

        JLabel shopInv = new JLabel("Shop Inventory");

        JLabel title = new JLabel("Buy Menu");
        this.add(title);

        JButton backToBreak = new JButton("Back to Shop");
        backToBreak.addActionListener(e -> card.show(parentPanel, "Shop Menu"));

        selectedItem = new JLabel("Selected: ");
        cost = new JLabel("Cost: ");


        // ----- Initialize Layouts -----
        BoxLayout mainBox = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(mainBox);

        BoxLayout userBox = new BoxLayout(userPanel, BoxLayout.Y_AXIS);
        userPanel.setLayout(userBox);

        BoxLayout shopBox = new BoxLayout(shopPanel, BoxLayout.Y_AXIS);
        shopPanel.setLayout(shopBox);

        BoxLayout buyBox = new BoxLayout(buyPanel, BoxLayout.X_AXIS);
        buyPanel.setLayout(buyBox);

        BoxLayout topBox = new BoxLayout(topPanel, BoxLayout.Y_AXIS);
        topPanel.setLayout(topBox);


        // ----- Add Panels -----
        topPanel.add(title);

        shopPanel.add(shopInv);
        shopPanel.add(list);

        userPanel.add(selectedItem);
        userPanel.add(cost);
        userPanel.add(buyButton);

        buyPanel.add(shopPanel, BorderLayout.WEST);
        buyPanel.add(userPanel, BorderLayout.EAST);

        this.add(topPanel);
        this.add(buyPanel);
        this.add(backToBreak);

        this.add(backToBreak);
    }


    // ----- Changes the displayed text for the selected item -----
    public void valueChanged(ListSelectionEvent e) {
        selectedItem.setText("Selected: " + list.getSelectedValue().toString());
        index = list.getSelectedIndex();
        cost.setText("Cost: " + shopInventory.get(index).getGoldValue() + " Gold");
    }

    // ----- Button -----
    public void actionPerformed(ActionEvent e) {
        System.out.println("hi");
        System.out.println("Item " + shopInventory.get(index).getName() + " successfully added.");
        playerInventory.add(shopInventory.get(index));
    }
}

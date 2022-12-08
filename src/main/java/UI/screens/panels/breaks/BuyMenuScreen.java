package UI.screens.panels.breaks;

import entities.Stats;
import entities.StatsUser;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import inventorymenu.inventoryitem.InventoryItemDsRequestModel;
import inventorymenu.inventoryitem.ShopInventoryFile;
import inventorymenu.inventoryitem.PlayerInventoryFile;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.file_checker.ValidStats;
import inventorymenu.inventoryitem.InventoryItem;
import stats_update_use_case.StatsUpdateInteractor;
import use_cases.save_game.StatSave;

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

    Frame frame;

    static JList list;
    static int index;
    static JLabel selectedItem;
    static JLabel cost;

    static JLabel userGold;

    static ValidStats stats;
    static StatSave statSave;
    static StatsUser statsUser;
    static Map<String, Integer> statsMap;
    ErrorOutputBoundary presenter;
    static ArrayList<InventoryItemDsRequestModel> shopInventory;

    static PlayerInventoryFile playerInventoryFile;
    static ArrayList<InventoryItemDsRequestModel> playerInventory;


    public BuyMenuScreen(CardLayout card, JPanel parentPanel) {

        // ----- Initialize Panels -----
        JPanel buyPanel = new JPanel();
        JPanel userPanel = new JPanel();
        JPanel shopPanel = new JPanel();
        JPanel topPanel = new JPanel();


        // ----- Initialize Gold Values -----
        stats = new ValidStats("stats.csv", presenter);
        statsMap = stats.load();
        statSave = new StatSave(statsMap, presenter);
        statsUser = new StatsUser(statsMap);


        // ----- Initialize Files for List Generation -----
        // NOTE: MOVE THIS TO SHOP MENU THESE ARE INTERACTORS
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
        playerInventoryFile =  new PlayerInventoryFile("PlayerInventory.csv");
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
        userGold = new JLabel("Your Gold: " + statsMap.get("gold"));


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
        userPanel.add(userGold);

        buyPanel.add(shopPanel, BorderLayout.WEST);
        buyPanel.add(userPanel, BorderLayout.EAST);

        this.add(topPanel);
        this.add(buyPanel);
        this.add(backToBreak);

        this.add(backToBreak);

        frame = new JFrame("Pop-Up Frame");

    }


    // ----- Changes the displayed text for the selected item -----
    public void valueChanged(ListSelectionEvent e) {
        selectedItem.setText("Selected: " + list.getSelectedValue().toString());
        index = list.getSelectedIndex();
        cost.setText("Cost: " + shopInventory.get(index).getGoldValue() + " Gold");
    }

    // ----- Button -----
    public void actionPerformed(ActionEvent e) {
        if (playerInventoryFile.inventoryFull()) {
            JOptionPane.showMessageDialog(frame,
                    "You do not have enough space in your inventory!",
                    "Purchase Error", JOptionPane.WARNING_MESSAGE);
        } else if (statsMap.get("gold") < shopInventory.get(index).getGoldValue() ) {
            JOptionPane.showMessageDialog(frame,
                    "You do not have enough gold!",
                    "Purchase Error", JOptionPane.WARNING_MESSAGE);
        } else {
            System.out.println("Item " + shopInventory.get(index).getName() + " successfully added.");
        }

        playerInventoryFile.save(new InventoryItem(
                shopInventory.get(index).getType(),
                shopInventory.get(index).getName(),
                shopInventory.get(index).getEffect(),
                shopInventory.get(index).getGoldValue(),
                shopInventory.get(index).checkIsEquipped()
        ));
        System.out.println(-shopInventory.get(index).getGoldValue());
        statsUser.changeGold(-shopInventory.get(index).getGoldValue());
        StatSave newStats = new StatSave(statsUser.getUserStats(),presenter);
        newStats.save();
        userGold.setText("Your Gold: " + statsMap.get("gold"));
    }
}

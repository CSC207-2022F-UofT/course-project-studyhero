package UI.screens.panels.breaks;

import entities.StatsUser;
import inventorymenu.inventoryitem.InventoryItemDsRequestModel;
import use_cases.buy_menu.BuyMenuButtonController;
import use_cases.buy_menu.BuyMenuGoldUpdater;
import use_cases.buy_menu.BuyMenuPlayerInvUpdater;
import use_cases.buy_menu.BuyMenuShopInvInitializer;
import inventorymenu.inventoryitem.InventoryItem;
import use_cases.save_game.StatSave;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * The screen for displaying the Buy Menu from the Shop Menu.
 * The user is able to buy items from a list of ShopInventoryFile items
 * in exchange for the user's gold from Stats, which are sent to their
 * PlayerInventoryFile.
 */
public class BuyMenuScreen extends JPanel implements ListSelectionListener {
    /**
     * Elements of the BuyMenuScreen.
     */
    CardLayout card;
    JPanel parentPanel;
    Frame frame;

    int index;
    JLabel userGold;

    JList<String> list;
    JLabel selectedItem;
    JLabel cost;

    ArrayList<InventoryItemDsRequestModel> shopInventory;
    ArrayList<InventoryItemDsRequestModel> playerInventory;

    BuyMenuPlayerInvUpdater buyMenuPlayerInvUpdater;
    BuyMenuGoldUpdater buyMenuGoldUpdater;
    BuyMenuShopInvInitializer buyMenuShopInvInitializer;


    /**
     * Card where all the visual panels, labels, lists, etc.
     * are stored to be viewed by the user.
     */
    public BuyMenuScreen(CardLayout card, JPanel parentPanel) {

        // ----- Initialize Panels -----
        JPanel buyPanel = new JPanel();
        JPanel userPanel = new JPanel();
        JPanel shopPanel = new JPanel();
        JPanel topPanel = new JPanel();

        buyMenuShopInvInitializer = new BuyMenuShopInvInitializer();
        buyMenuPlayerInvUpdater = new BuyMenuPlayerInvUpdater();
        buyMenuGoldUpdater = new BuyMenuGoldUpdater();

        shopInventory = buyMenuShopInvInitializer.getShopInventory();
        playerInventory = buyMenuPlayerInvUpdater.getPlayerInventory();

        // ----- List Selection -----
        list = new JList(buyMenuShopInvInitializer.DisplayShopItems().toArray());

        list.clearSelection();
        list.addListSelectionListener(this);
        list.setMaximumSize(new Dimension(200, 200));


        // ----- Buy Button -----
        JButton buyButton = new JButton("Buy Selected Item");
        BuyMenuButtonController buyMenuButtonController = new BuyMenuButtonController(card,
                parentPanel, index, userGold);
        buyButton.addActionListener(buyMenuButtonController);
//        buyButton.addActionListener(indexGetter);


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
        userGold = new JLabel("Your Gold: " + buyMenuGoldUpdater.getUserGold());


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
        selectedItem.setText("Selected: " + list.getSelectedValue());
        index = list.getSelectedIndex();
        cost.setText("Cost: " + shopInventory.get(index).getGoldValue() + " Gold");
        repaint();
    }

    // ----- Button -----
//    public void actionPerformed(ActionEvent e) {
//        if (playerInventoryFile.inventoryFull()) {
//            JOptionPane.showMessageDialog(frame,
//                    "You do not have enough space in your inventory!",
//                    "Purchase Error", JOptionPane.WARNING_MESSAGE);
//        } else if (statsMap.get("gold") < shopInventory.get(index).getGoldValue() ) {
//            JOptionPane.showMessageDialog(frame,
//                    "You do not have enough gold!",
//                    "Purchase Error", JOptionPane.WARNING_MESSAGE);
//        } else {
//            // call interactor
//            playerInventoryFile.save(new InventoryItem(
//                    shopInventory.get(index).getType(),
//                    shopInventory.get(index).getName(),
//                    shopInventory.get(index).getEffect(),
//                    shopInventory.get(index).getGoldValue(),
//                    shopInventory.get(index).checkIsEquipped()
//            ));
//
//            statsUser.updateGold(-shopInventory.get(index).getGoldValue());
//            StatSave newStats = new StatSave(statsUser.getUserStats(), presenter);
//            newStats.save("stats.csv");
//
//            statsMap = stats.load();
//            statSave = new StatSave(statsMap, presenter);
//            statsUser = new StatsUser(statsMap);
//            // controller
//            userGold.setText("Your Gold: " + statsMap.get("gold"));
//        }
//    }
}

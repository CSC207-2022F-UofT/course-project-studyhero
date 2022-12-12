package UI.screens.panels.breaks;

import inventory.inventory_item.entities.InventoryItem;
import use_cases.buy_menu.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The screen for displaying the Buy Menu from the Shop Menu.
 * The user is able to buy items from a list of ShopInventoryFile items
 * in exchange for the user's gold from Stats, which are sent to their
 * PlayerInventoryFile.
 */
public class BuyMenuScreen extends JPanel {
    // Elements of the buy menu screen.
    CardLayout card;
    JPanel parentPanel;
    Frame frame;

    JLabel userGold;

    JList<String> list;
    JLabel selectedItem;
    JLabel cost;

    ArrayList<InventoryItem> shopInventory;
    ArrayList<InventoryItem> playerInventory;

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


        // ---- Initialize Components -----
        this.card = card;
        this.parentPanel = parentPanel;

        JLabel shopInv = new JLabel("Shop Inventory");

        JLabel title = new JLabel("Buy Menu");
        this.add(title);

        JButton backToBreak = new JButton("Back to Shop");
        backToBreak.addActionListener(e -> card.show(parentPanel, "Shop Menu"));

        buyMenuShopInvInitializer = new BuyMenuShopInvInitializer();
        buyMenuPlayerInvUpdater = new BuyMenuPlayerInvUpdater();
        buyMenuGoldUpdater = new BuyMenuGoldUpdater();

        shopInventory = buyMenuShopInvInitializer.getShopInventory();
        playerInventory = buyMenuPlayerInvUpdater.getPlayerInventory();

        selectedItem = new JLabel("Selected: ");
        cost = new JLabel("Cost: ");
        userGold = new JLabel("Your Gold: " + buyMenuGoldUpdater.getUserGold());


        // ----- List Selection -----
        list = new JList(buyMenuShopInvInitializer.DisplayShopItems().toArray());

        list.clearSelection();
        BuyMenuListController buyMenuListController = new BuyMenuListController(card,
                parentPanel, list, shopInventory, selectedItem, cost);
        list.addListSelectionListener(buyMenuListController);
        list.setMaximumSize(new Dimension(200, 200));


        // ----- Buy Button -----
        JButton buyButton = new JButton("Buy Selected Item");
        BuyMenuButtonController buyMenuButtonController = new BuyMenuButtonController(card,
                parentPanel, userGold,
                cost, selectedItem, list, buyMenuListController);
        buyButton.addActionListener(buyMenuButtonController);


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
}

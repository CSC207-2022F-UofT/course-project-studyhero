package use_cases.buy_menu;

import inventory.inventory_item.entities.InventoryItem;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;

public class BuyMenuListController extends ListSelectionEvent implements BuyMenuListInterface, ListSelectionListener {
    JPanel parentPanel;
    CardLayout card;
    JLabel selectedItem;
    int index;
    JLabel cost;

    JList<String> list;
    ArrayList<InventoryItem> shopInventory;

    /**
     * The BuyMenuListController that acts as the Action Listener from the BuyMenuScreen when the user
     * selects an item from the JList 'list'.
     *
     * @param card                  The CardLayout from BuyMenuScreen for which the card is displayed on.
     *
     * @param parentPanel           The Panel from BuyMenuScreen for which the panel is displayed on.
     *
     * @param list                  The JList that takes in the displayed shop items from BuyMenuScreen.
     *
     * @param shopInventory         The ArrayList of inventory items from the ShopInventoryFile.
     *
     * @param selectedItem          The JLabel of the selected item's name from the JList.
     *
     * @param cost                  The JLabel of the cost of the selected item from the JList.
     */
    public BuyMenuListController(CardLayout card,
                                 JPanel parentPanel,
                                 JList<String> list,
                                 ArrayList<InventoryItem> shopInventory,
                                 JLabel selectedItem, JLabel cost) {
        super(list, 0, list.getMaxSelectionIndex(), true);
        this.card = card;
        this.parentPanel = parentPanel;
        this.list = list;
        this.shopInventory = shopInventory;
        this.selectedItem = selectedItem;
        this.cost = cost;
    }

    /**
     * The action listener for the list selection event in the JList 'list' that changes the displayed selected
     * item and cost.
     *
     * @param e the event that characterizes the change.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        selectedItem.setText("Selected: " + list.getSelectedValue());
        this.index = list.getSelectedIndex();
        cost.setText("Cost: " + shopInventory.get(index).getGoldValue() + " Gold");
        parentPanel.repaint();
    }

    /**
     * The index of the selected item after the value changes from the ListSelectionEvent.
     *
     * @return the integer the selected item's index.
     */
    public int getIndex() {
        return index;
    }
}

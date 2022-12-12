package use_cases.buy_menu;

import inventorymenu.inventoryitem.InventoryItemDsRequestModel;

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
    ArrayList<InventoryItemDsRequestModel> shopInventory;

    public BuyMenuListController(CardLayout card,
                                 JPanel parentPanel,
                                 JList<String> list,
                                 ArrayList<InventoryItemDsRequestModel> shopInventory,
                                 JLabel selectedItem, JLabel cost) {
        super(list,
                0, list.getMaxSelectionIndex(), true);
        this.card = card;
        this.parentPanel = parentPanel;
        this.list = list;
        this.shopInventory = shopInventory;
        this.selectedItem = selectedItem;
        this.cost = cost;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        selectedItem.setText("Selected: " + list.getSelectedValue());
        this.index = list.getSelectedIndex();
        cost.setText("Cost: " + shopInventory.get(index).getGoldValue() + " Gold");
        parentPanel.repaint();
    }

    public int getIndex() {
        return index;
    }
}

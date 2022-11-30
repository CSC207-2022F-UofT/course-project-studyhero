package InventoryMenu.inventory_menu_use_case.display_player_inventory;

import InventoryMenu.InventoryItem.InventoryItem;
import InventoryMenu.InventoryItem.InventoryList;

import java.util.ArrayList;

/**
 * This class is an Iterator that will be used to iterate InventoryList
 */
public class PlayerDisplayInventoryDsRequestModel implements InventoryListIterator {
    private int currentPosition = 0;

    public PlayerDisplayInventoryDsRequestModel(InventoryList file, ArrayList<InventoryItem> inventoryList) {
        this.file = file;
        this.inventoryList = inventoryList;
    }

    InventoryList file;
    private ArrayList<InventoryItem> inventoryList;

    /**
     * This will update currentPosition by one if hasNext() is true
     * @return InventoryItem in the InventoryList[currentPosition]
     */
    @Override
    public InventoryItem getNext() {
        if(!hasNext()){
            return null;
        }

        InventoryItem item = new InventoryItem(inventoryList.get(currentPosition).getType(),
                inventoryList.get(currentPosition).getName(),
                inventoryList.get(currentPosition).getEffect());

        currentPosition += 1;
        return item;
    }

    /**
     * Checks if the currentPosition reaches an end of InventoryList
     * @return true if currentPosition does not reach to the end of InventoryList
     */
    @Override
    public boolean hasNext() {
        return currentPosition < inventoryList.size();
    }

    /**
     * This will reset the currentPosition
     */
    @Override
    public void reset() {
        currentPosition = 0;
    }

}

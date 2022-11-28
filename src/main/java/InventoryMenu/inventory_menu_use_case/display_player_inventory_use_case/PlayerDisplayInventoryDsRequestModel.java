package InventoryMenu.inventory_menu_use_case.display_player_inventory_use_case;

import InventoryMenu.InventoryItem.InventoryItemDsRequestModel;
import InventoryMenu.InventoryItem.InventoryList;

import java.util.ArrayList;

/**
 * This class is an Iterator that will be used to iterate over the InventoryList
 */
public class PlayerDisplayInventoryDsRequestModel implements InventoryListIterator {
    private int currentPosition = 0;

    /**
     *
     * @param file contains all the inventory information
     * @param inventoryList is a list containing inventoryList
     */
    public PlayerDisplayInventoryDsRequestModel(InventoryList file, ArrayList<InventoryItemDsRequestModel> inventoryList) {
        this.file = file;
        this.inventoryList = inventoryList;
    }

    InventoryList file;
    private ArrayList<InventoryItemDsRequestModel> inventoryList;

    /**
     * This will update currentPosition by one if hasNext() is true
     * @return InventoryItem in the InventoryList[currentPosition]
     */
    @Override
    public InventoryItemDsRequestModel getNext() {
        if(!hasNext()){
            return null;
        }

        InventoryItemDsRequestModel item = new InventoryItemDsRequestModel(inventoryList.get(currentPosition).getId(),
                inventoryList.get(currentPosition).getType(),
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

}

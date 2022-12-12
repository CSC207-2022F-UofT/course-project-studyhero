package use_cases.inventory_menu_use_case.display_player_inventory_use_case;

import inventory.inventory_item.entities.InventoryItem;

import java.util.ArrayList;

/**
 * This class is an Iterator that will be used to iterate over the InventoryList
 */
public class PlayerDisplayInventoryDsRequestModel implements InventoryListIterator {
    private int currentPosition = 0;

    /**
     * @param inventoryList is a list containing inventoryList
     */
    public PlayerDisplayInventoryDsRequestModel(ArrayList<InventoryItem> inventoryList) {

        this.inventoryList = inventoryList;
    }


    private ArrayList<InventoryItem> inventoryList;

    /**
     * This will update currentPosition by one if hasNext() is true
     * @return inventory_item in the InventoryList[currentPosition]
     */
    @Override
    public InventoryItem getNext() {
        if(!hasNext()){
            return null;
        }

        InventoryItem item = new InventoryItem(inventoryList.get(currentPosition).getId(),
                inventoryList.get(currentPosition).getType(),
                inventoryList.get(currentPosition).getName(),
                inventoryList.get(currentPosition).getEffect(),
                inventoryList.get(currentPosition).getGoldValue(), inventoryList.get(currentPosition).checkIsEquipped());

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

package inventorymenu.inventory_menu_use_case.display_player_inventory_use_case;

import inventorymenu.inventoryitem.InventoryItemDsRequestModel;

import java.util.ArrayList;

/**
 * This class is an Iterator that will be used to iterate over the InventoryList
 */
public class PlayerDisplayInventoryDsRequestModel implements InventoryListIterator {
    private int currentPosition = 0;

    /**
     * @param inventoryList is a list containing inventoryList
     */
    public PlayerDisplayInventoryDsRequestModel(ArrayList<InventoryItemDsRequestModel> inventoryList) {

        this.inventoryList = inventoryList;
    }


    private ArrayList<InventoryItemDsRequestModel> inventoryList;

    /**
     * This will update currentPosition by one if hasNext() is true
     * @return inventory_item in the InventoryList[currentPosition]
     */
    @Override
    public InventoryItemDsRequestModel getNext() {
        if(!hasNext()){
            return null;
        }

        InventoryItemDsRequestModel item = new InventoryItemDsRequestModel(inventoryList.get(currentPosition).getId(),
                inventoryList.get(currentPosition).getType(),
                inventoryList.get(currentPosition).getName(),
                inventoryList.get(currentPosition).getEffect(),
                inventoryList.get(currentPosition).getGoldValue());

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

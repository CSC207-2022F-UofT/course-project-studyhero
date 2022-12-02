package inventorymenu.inventory_menu_use_case.display_player_inventory_use_case;

import inventorymenu.inventoryitem.InventoryItemDsRequestModel;

/**
 * This interface contains method that need to implemented for an iterator class
 */

public interface InventoryListIterator {
    /**
     * Get next item in InventoryList
     * @return an InventoryItem on current position of the inventory list
     */
    InventoryItemDsRequestModel getNext();


    /**
     * Check if the iterator has reached the end of the InventoryList
     * @return true if the iterator has not reached the end of the InventoryList and false if it reached the end
     */
    boolean hasNext();

}

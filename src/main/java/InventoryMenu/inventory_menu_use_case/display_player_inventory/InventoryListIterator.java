package InventoryMenu.inventory_menu_use_case.display_player_inventory;

import InventoryMenu.InventoryItem.InventoryItem;

/**
 * This interface contains method that need to implemented for an iterator class
 */

public interface InventoryListIterator {
    /**
     * Get next item in InventoryList
     * @return an InventoryItem
     */
    InventoryItem getNext();

    /**
     * Check if the iterator has reached the end of the InventoryList
     * @return true if the iterator has not reached the end of the InventoryList and false if it reached the end
     */
    boolean hasNext();

    /**
     * Reset the position of the iterator
     */
    void reset();
}

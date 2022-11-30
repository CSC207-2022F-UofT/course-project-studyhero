package InventoryMenu.inventory_menu_use_case.add_item;

import InventoryMenu.InventoryItem.InventoryItem;

/**
This interface obtain all the methods that will be implemented to add item to the inventory
 */
public interface AddItemDsGateway {
     /**
      * Check if the inventory is full
      * @return true if the inventory is full and false if the inventory is not full
      */
     boolean inventoryFull();

     /**
      * Add the inventoryItem to the inventoryList
      * @param requestModel an inventoryItem
      */
     void save(InventoryItem requestModel);
}

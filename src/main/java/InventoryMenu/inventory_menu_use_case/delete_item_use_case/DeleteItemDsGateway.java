package InventoryMenu.inventory_menu_use_case.delete_item_use_case;

import InventoryMenu.InventoryItem.InventoryItem;


/**
This interface obtain all the methods that will be implemented to add item to the inventory
 */
public interface DeleteItemDsGateway {
     /**
      * Check if the item is in the inventory
      * @return true if the item is in the inventory
      */
     boolean itemExist(int id);

     /**
      * Delete the item from inventory
      * @param id of the item wants to be removed from inventory
      */
     void deleteItem(int id);

     /**
      * Reassign the ids for items in inventory
      */
     void reassign();
}

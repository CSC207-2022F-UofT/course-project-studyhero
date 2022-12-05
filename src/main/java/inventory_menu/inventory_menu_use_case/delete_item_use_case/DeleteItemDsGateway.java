package inventory_menu.inventory_menu_use_case.delete_item_use_case;


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

     /**
      * Get the name of the inventory item correspond to the id in the inventory
      * @param id of the item wants to be removed from inventory
      * @return the name of the item that wants to be removed from inventory
      */
     DeleteItemDsRequestModel getName(int id);
}

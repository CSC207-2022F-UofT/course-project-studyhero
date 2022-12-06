package inventory_menu.inventoryitem;

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

     /**
      * Create a new AddItemDsRequestModel with every attributes on inventory_item and an inventory id.
      * @return the new AddItemDsRequestModel created
      */
     InventoryItemDsRequestModel attachId(InventoryItem newItem);

     /**
      * Checks how many items are in the inventory
      * @return number of item in the inventory
      */
     int CheckLatestInventoryItemId();

}

package inventory.inventory_item.entities;

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
      * Checks how many items are in the inventory
      * @return number of item in the inventory
      */
     int CheckLatestInventoryItemId();

}

package inventorymenu.inventoryitem;
import inventorymenu.inventory_menu_use_case.delete_item_use_case.DeleteItemDsGateway;
import inventorymenu.inventory_menu_use_case.delete_item_use_case.DeleteItemDsRequestModel;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsGateway;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;


/** The public class for adding inventory. AddItemToInventory stores all the
 * inventory information which includes item_type, item_name and item_effect.
 */
public interface InventoryList extends AddItemDsGateway, DeleteItemDsGateway{

    /**
     * Read the inventory File and record the information to inventory list
     */
    void readInventoryList();

    /**
     * Add new InventoryItem to the inventory
     * @param item is the item which need to be added to the inventory
     */
    @Override
    void save(InventoryItem item);

    /**
     * @param item The inventory item you want to add to the inventory
     * @return a AddItemDsRequestModel with id as the next available player's inventory slot
     */
    @Override
    InventoryItemDsRequestModel attachId(InventoryItem item);


    /**
     * Check how many InventoryItem are in the inventory
     * @return the number of items in the inventory
     */
    @Override
    int CheckLatestInventoryItemId();

    /**
     * Rewrite the inventory file with the added inventoryItem
     */
    void save();

    /**
     * Return whether inventory is full
     * @return whether inventory's capacity is greater than 20
     */
    @Override
    boolean inventoryFull();

    /**
     * Check if the item is in the inventory
     * @return true if the item is in the inventory
     */
    @Override
    boolean itemExist(int id);

    /**
     * Delete the item from inventory
     * @param id of the item wants to be removed from inventory
     */
    @Override
    void deleteItem(int id);

    /**
     * get the item's name associated with inventory id
     * @param id of the item wants to be removed from inventory
     * @return the name of the item that wants to be removed from inventory
     */
    @Override
    DeleteItemDsRequestModel getName(int id);

}

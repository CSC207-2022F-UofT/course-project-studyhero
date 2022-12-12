package use_cases.inventory_menu_use_case.display_player_inventory_use_case;

/**
 * This interface includes method to create an Iterator object of type PlayerDisplayInventoryDsRequestModel
 */
public interface PlayerDisplayInventoryDsGateway{
    /**
     * create the inventoryList iterator
     * @return An iterator  on InventoryList
     */
    PlayerDisplayInventoryDsRequestModel getInventoryListIterator();

    /**
     * update the inventory list to the corresponding inventory list file
     */
    void updateInventoryList();
}

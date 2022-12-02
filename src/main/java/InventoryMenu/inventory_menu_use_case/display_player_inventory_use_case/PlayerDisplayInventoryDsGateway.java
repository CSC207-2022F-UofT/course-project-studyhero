package inventorymenu.inventory_menu_use_case.display_player_inventory_use_case;

/**
 * This interface includes method to create an Iterator object of type PlayerDisplayInventoryDsRequestModel
 */
public interface PlayerDisplayInventoryDsGateway {
    /**
     * create the inventoryList iterator
     * @return An iterator on InventoryList
     */
    PlayerDisplayInventoryDsRequestModel createIterator();
}

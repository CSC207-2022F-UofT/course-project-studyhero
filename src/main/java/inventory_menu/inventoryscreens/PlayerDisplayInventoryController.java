package inventory_menu.inventoryscreens;

import inventory_menu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryInputBoundary;
import inventory_menu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryResponseModel;

/**
 * This class is incomplete
 */
public class PlayerDisplayInventoryController {

    private final PlayerDisplayInventoryInputBoundary inputBoundary;

    public PlayerDisplayInventoryController(PlayerDisplayInventoryInputBoundary inventoryGateway) {
        this.inputBoundary = inventoryGateway;
    }


    /**
     * Display Player's Inventory
     */
    public PlayerDisplayInventoryResponseModel display() {
        return inputBoundary.display();
    }
}

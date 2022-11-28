package InventoryMenu.InventoryMenuUI;

import InventoryMenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryInputBoundary;
import InventoryMenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryResponseModel;

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

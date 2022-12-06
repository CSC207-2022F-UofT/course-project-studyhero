package inventory_menu.inventoryscreens;

import inventory_menu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryInputBoundary;
import inventory_menu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryResponseModel;

public class PlayerDisplayInventoryController {

    private final PlayerDisplayInventoryInputBoundary inputBoundary;

    public PlayerDisplayInventoryController(PlayerDisplayInventoryInputBoundary inventoryGateway) {
        this.inputBoundary = inventoryGateway;
    }


    /**
     * Display Player's Inventory
     * @return the response of display
     */
    public PlayerDisplayInventoryResponseModel display() {
        return inputBoundary.display();
    }
}

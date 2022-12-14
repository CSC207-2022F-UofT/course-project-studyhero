package inventory.inventoryscreens;

import inventory.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryInputBoundary;
import inventory.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryResponseModel;

public class PlayerDisplayInventoryController {

    private final PlayerDisplayInventoryInputBoundary inputBoundary;

    /**
     * @param inventoryGateway is an interface containing method of dealing user input data
     */
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

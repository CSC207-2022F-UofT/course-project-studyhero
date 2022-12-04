package inventorymenu.inventoryitem;

public class InitializePlayerInventory {

    public static void InitializePlayerInventory(String csvPath) {
        /**
         * Initialize the item in player's inventory
         */

        InitializePlayerInventoryGateway initializePlayerInventoryGateway = new InventoryList(csvPath);
        initializePlayerInventoryGateway.initialize();
    }
}

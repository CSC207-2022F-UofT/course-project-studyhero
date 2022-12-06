package inventory_menu.inventoryitem;

public class InitializePlayerInventory {
    /**
     * Initialize the item in player's inventory
     */
    public static void InitializePlayerInventory(String csvPath) {

        InitializePlayerInventoryGateway initializePlayerInventoryGateway = new PlayerInventoryFile(csvPath);
        initializePlayerInventoryGateway.initialize();
    }
}

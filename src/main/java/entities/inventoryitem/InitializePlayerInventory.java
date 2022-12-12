package entities.inventoryitem;

public class InitializePlayerInventory {
    /**
     * Initialize the item in player's inventory
     */
    public void InitializePlayerInventory(String csvPath) {

        InitializePlayerInventoryGateway initializePlayerInventoryGateway = new PlayerInventoryFile(csvPath);
        initializePlayerInventoryGateway.initialize();
    }
}

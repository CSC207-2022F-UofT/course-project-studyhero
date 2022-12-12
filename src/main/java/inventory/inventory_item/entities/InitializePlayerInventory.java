package inventory.inventory_item.entities;

public class InitializePlayerInventory {
    /**
     * Initialize the item in player's inventory
     */
    public void InitializePlayerInventory(String csvPath) {

        InitializePlayerInventoryGateway initializePlayerInventoryGateway = new PlayerInventoryFile(csvPath);
        initializePlayerInventoryGateway.initialize();
    }
}

package inventory.inventory_item.entities;

public class InitializeShopInventory {
    /**
     * Initialize the item in player's inventory
     */
    public void InitializeShopInventory(String csvPath) {

        InitializeShopInventoryGateway initializeShopInventoryGateway = new ShopInventoryFile(csvPath);
        initializeShopInventoryGateway.initialize();
    }
}

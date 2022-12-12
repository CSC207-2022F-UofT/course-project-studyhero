package inventory.entities;

public interface InitializeShopInventoryGateway {
    /**
     * clear the inventory file
     */
    void clearInventory();

    /**
     * initialize the inventory file
     */
    void initialize();
}

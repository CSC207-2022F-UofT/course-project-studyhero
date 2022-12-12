package inventory.inventory_item.entities;

public interface InitializePlayerInventoryGateway {
    /**
     * clear the inventory file
     */
    void clearInventory();

    /**
     * initialize the inventory file
     */
    void initialize();
}

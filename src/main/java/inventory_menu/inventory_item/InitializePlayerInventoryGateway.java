package inventory_menu.inventory_item;

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

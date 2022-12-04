package inventorymenu.inventoryitem.inventory_menu_use_case.display_player_inventory_use_case;

/**
 * This class is incomplete
 */
public class PlayerDisplayInventoryInteractor implements PlayerDisplayInventoryInputBoundary{
    final PlayerDisplayInventoryDsGateway inventoryDsGateway;
    final PlayerDisplayInventoryOutputBoundary outputBoundary;

    /**
     *
     * @param inventoryDsGateway An interface that communicates with data in inventory file.
     * @param outputBoundary An interface that communicates with output data
     */
    public PlayerDisplayInventoryInteractor(PlayerDisplayInventoryDsGateway inventoryDsGateway,
                                            PlayerDisplayInventoryOutputBoundary outputBoundary) {
        this.inventoryDsGateway = inventoryDsGateway;
        this.outputBoundary = outputBoundary;
    }

    /**
     * Get inventory information and pass it to the presenter
     */
    @Override
    public PlayerDisplayInventoryResponseModel display() {
        PlayerDisplayInventoryDsRequestModel iterator = inventoryDsGateway.getInventoryListIterator();
            return outputBoundary.prepareInventoryView(iterator);
    }
}

package inventory_menu.display_player_inventory;

public class PlayerDisplayInventoryInteractor {
    final PlayerDisplayInventoryDsGateway inventoryDsGateway;

    public PlayerDisplayInventoryInteractor(PlayerDisplayInventoryDsGateway inventoryDsGateway) {
        this.inventoryDsGateway = inventoryDsGateway;
    }
}

package inventory_menu.inventoryscreens;

import inventory_menu.inventory_item.InventoryItemDsRequestModel;
import inventory_menu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import inventory_menu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryOutputBoundary;
import inventory_menu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryResponseModel;


public class PlayerDisplayInventoryPresenter implements PlayerDisplayInventoryOutputBoundary {

    private final PlayerDisplayInventoryResponseModel inventoryList = new PlayerDisplayInventoryResponseModel();

    @Override
    public PlayerDisplayInventoryResponseModel prepareInventoryView(PlayerDisplayInventoryDsRequestModel dsRequestModel) {
        inventoryList.clearItem();
        while(dsRequestModel.hasNext()){
            InventoryItemDsRequestModel item = dsRequestModel.getNext();
            inventoryList.addItem(item);
        }

        return inventoryList;
    }
}


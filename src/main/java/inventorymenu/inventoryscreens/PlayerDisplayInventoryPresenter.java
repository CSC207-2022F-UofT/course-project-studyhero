package inventorymenu.inventoryscreens;

import inventorymenu.inventory_item.InventoryItemDsRequestModel;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryOutputBoundary;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryResponseModel;


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


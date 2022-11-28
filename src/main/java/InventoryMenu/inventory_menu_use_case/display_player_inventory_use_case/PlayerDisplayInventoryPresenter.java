package InventoryMenu.inventory_menu_use_case.display_player_inventory_use_case;

import InventoryMenu.InventoryItem.InventoryItemDsRequestModel;


public class PlayerDisplayInventoryPresenter implements PlayerDisplayInventoryOutputBoundary{

    private final PlayerDisplayInventoryResponseModel inventoryList = new PlayerDisplayInventoryResponseModel();

    @Override
    public PlayerDisplayInventoryResponseModel prepareInventoryView(PlayerDisplayInventoryDsRequestModel dsRequestModel) {
        while(dsRequestModel.hasNext()){
            InventoryItemDsRequestModel item = dsRequestModel.getNext();
            inventoryList.addItem(item);
        }

        return inventoryList;
    }
}


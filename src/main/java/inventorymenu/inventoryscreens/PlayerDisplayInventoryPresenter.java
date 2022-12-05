package inventorymenu.inventoryscreens;

import inventorymenu.inventoryitem.InventoryItemDsRequestModel;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryOutputBoundary;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryResponseModel;


public class PlayerDisplayInventoryPresenter implements PlayerDisplayInventoryOutputBoundary {

    private final PlayerDisplayInventoryResponseModel inventoryList = new PlayerDisplayInventoryResponseModel();

    /**
     * @param dsRequestModel is the iterator that will be used to access inventory list
     * @return inventory information using arraylist
     */
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


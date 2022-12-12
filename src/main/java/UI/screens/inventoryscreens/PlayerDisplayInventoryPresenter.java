package UI.screens.inventoryscreens;

import entities.inventoryitem.InventoryItem;
import use_cases.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import use_cases.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryOutputBoundary;
import use_cases.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryResponseModel;


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
            InventoryItem item = dsRequestModel.getNext();
            inventoryList.addItem(item);
        }

        return inventoryList;
    }
}


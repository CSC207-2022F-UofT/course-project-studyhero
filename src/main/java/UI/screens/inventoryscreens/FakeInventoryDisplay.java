package UI.screens.inventoryscreens;

import entities.inventoryitem.InventoryItemDsRequestModel;
import use_cases.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsGateway;
import use_cases.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;

import java.util.ArrayList;

public class FakeInventoryDisplay implements PlayerDisplayInventoryDsGateway {

    public FakeInventoryDisplay(ArrayList<InventoryItemDsRequestModel> oldInventoryList,
                                ArrayList<InventoryItemDsRequestModel> newInventoryList){
        this.oldInventoryList = oldInventoryList;
        this.newInventoryList = newInventoryList;
    }

    private ArrayList<InventoryItemDsRequestModel> oldInventoryList;
    private ArrayList<InventoryItemDsRequestModel> newInventoryList;

    /**
     * create the inventoryList iterator
     * @return An iterator on InventoryList
     */
    @Override
    public PlayerDisplayInventoryDsRequestModel getInventoryListIterator() {
        updateInventoryList();
        return new PlayerDisplayInventoryDsRequestModel(oldInventoryList);
    }

    /**
     * update the inventory list to the corresponding inventory list file
     */
    @Override
    public void updateInventoryList() {
        oldInventoryList.clear();
        for(InventoryItemDsRequestModel item : newInventoryList){
            oldInventoryList.add(item);
        }
    }
}

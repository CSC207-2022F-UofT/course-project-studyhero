package inventory_menu.inventoryscreens;

import inventory_menu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsGateway;
import inventory_menu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import inventory_menu.inventoryitem.InventoryItemDsRequestModel;

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

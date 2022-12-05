package inventorymenu.inventoryscreens;

import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsGateway;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import inventorymenu.inventoryitem.InventoryItemDsRequestModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

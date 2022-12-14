package inventory.inventoryscreens;

import inventory.entities.InventoryItem;
import inventory.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsGateway;
import inventory.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;

import java.util.ArrayList;

public class FakeInventoryDisplay implements PlayerDisplayInventoryDsGateway {

    public FakeInventoryDisplay(ArrayList<InventoryItem> oldInventoryList,
                                ArrayList<InventoryItem> newInventoryList){
        this.oldInventoryList = oldInventoryList;
        this.newInventoryList = newInventoryList;
    }

    private final ArrayList<InventoryItem> oldInventoryList;
    private final ArrayList<InventoryItem> newInventoryList;

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
        oldInventoryList.addAll(newInventoryList);
    }
}

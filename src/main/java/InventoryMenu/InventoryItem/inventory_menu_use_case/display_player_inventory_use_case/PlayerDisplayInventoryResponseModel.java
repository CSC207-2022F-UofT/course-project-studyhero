package inventorymenu.inventoryitem.inventory_menu_use_case.display_player_inventory_use_case;

import inventorymenu.inventoryitem.InventoryItemDsRequestModel;

import java.util.ArrayList;

public class PlayerDisplayInventoryResponseModel {


    private final ArrayList<InventoryItemDsRequestModel> inventoryList = new ArrayList<>();

    public ArrayList<InventoryItemDsRequestModel> getInventoryList() {
        return inventoryList;
    }

    public void addItem(InventoryItemDsRequestModel item){
        inventoryList.add(item);
    }

}

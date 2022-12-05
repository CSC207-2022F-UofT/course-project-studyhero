package inventorymenu.inventoryscreens;

import inventorymenu.inventory_menu_use_case.delete_item_use_case.DeleteItemDsGateway;
import inventorymenu.inventory_menu_use_case.delete_item_use_case.DeleteItemDsRequestModel;
import inventorymenu.inventoryitem.InventoryItemDsRequestModel;

import java.util.ArrayList;

public class FakeInventoryDeletion implements DeleteItemDsGateway {
    public FakeInventoryDeletion(ArrayList<InventoryItemDsRequestModel> inventoryList) {
        this.inventoryList = inventoryList;
    }

    private ArrayList<InventoryItemDsRequestModel> inventoryList;

    @Override
    public boolean itemExist(int id) {
        return id <= inventoryList.size() && id > 0;
    }

    @Override
    public void deleteItem(int id) {
        inventoryList.remove(id - 1);
        int newId = 1;
        for(InventoryItemDsRequestModel item : inventoryList){
            item.setId(newId);
            newId++;
        }
    }


    @Override
    public DeleteItemDsRequestModel getName(int id) {

        return new DeleteItemDsRequestModel(inventoryList.get(id - 1).getName());
    }
}

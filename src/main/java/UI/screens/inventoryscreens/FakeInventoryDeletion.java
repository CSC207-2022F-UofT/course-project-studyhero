package UI.screens.inventoryscreens;



import entities.inventoryitem.InventoryItem;
import use_cases.inventory_menu_use_case.delete_item_use_case.DeleteItemDsGateway;
import use_cases.inventory_menu_use_case.delete_item_use_case.DeleteItemDsRequestModel;

import java.util.ArrayList;

public class FakeInventoryDeletion implements DeleteItemDsGateway {

    public FakeInventoryDeletion(ArrayList<InventoryItem> inventoryList) {
        this.inventoryList = inventoryList;
    }


    private ArrayList<InventoryItem> inventoryList;


    /**
     * Check if the item is in the inventory
     * @return true if the item is in the inventory
     */
    @Override
    public boolean itemExist(int id) {
        return id <= inventoryList.size() && id > 0;
    }

    /**
     * Delete the item from inventory
     * @param id of the item wants to be removed from inventory
     */
    @Override
    public void deleteItem(int id) {
        inventoryList.remove(id - 1);
        int newId = 1;
        for(InventoryItem item : inventoryList){
            item.setId(newId);
            newId++;
        }
    }

    /**
     * Get the name of the inventory item correspond to the id in the inventory
     * @param id of the item wants to be removed from inventory
     * @return the name of the item that wants to be removed from inventory
     */
    @Override
    public DeleteItemDsRequestModel getDeletionName(int id) {

        return new DeleteItemDsRequestModel(inventoryList.get(id - 1).getName());
    }
}

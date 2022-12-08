package use_cases.inventory_menu_use_case.display_player_inventory_use_case;

import entities.inventoryitem.InventoryItemDsRequestModel;

import java.util.ArrayList;

public class PlayerDisplayInventoryResponseModel {


    private final ArrayList<InventoryItemDsRequestModel> inventoryList = new ArrayList<>();
    private final ArrayList<String> response = new ArrayList<>();

    /**
     * Add item to the inventory list
     * @param item is the item that needs to be added to inventory list
     */
    public void addItem(InventoryItemDsRequestModel item){
        inventoryList.add(item);
    }

    /**
     * Reset the Item in inventoryList
     */
    public void clearItem(){
        inventoryList.clear();
    }

    /**
     * Reset the response
     */
    public void clearResponse(){
        response.clear();
    }


    /**
     * Transform the inventory data into response model
     * @return the response model
     */
    public ArrayList<String> showItem(){
        clearResponse();
        for(InventoryItemDsRequestModel item : inventoryList){
            response.add("Id: " + item.getId() +
                    " Type: " + item.getType() +
                    " Name: " + item.getName() +
                    " Effect: " + item.getEffect() +
                    " Gold: " + item.getGoldValue() +
                    " Item equipped : " + item.checkIsEquipped());

        }
        return response;
    }

}

package UI.screens.inventoryscreens;

import use_cases.inventory_menu_use_case.equip_item_use_case.EquipItemInputBoundary;
import use_cases.inventory_menu_use_case.equip_item_use_case.EquipItemRequestModel;
import use_cases.inventory_menu_use_case.equip_item_use_case.EquipItemResponseModel;

public class EquipItemController {
    final EquipItemInputBoundary userInput;

    /**
     * @param userInput is an input boundary(an interface) containing method that interacts with the userInput
     */
    public EquipItemController(EquipItemInputBoundary userInput) {
        this.userInput = userInput;
    }

    /**
     * delete the item in inventory based on request model
     * @param requestModel is the input data the user enters
     * @return a response from the deletion
     */
    public EquipItemResponseModel delete(EquipItemRequestModel requestModel){
        return userInput.equip(requestModel);
    }
}

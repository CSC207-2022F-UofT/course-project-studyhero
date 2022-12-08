package inventorymenu.inventoryscreens;

import inventorymenu.inventory_menu_use_case.equip_item_use_case.EquipItemInputBoundary;
import inventorymenu.inventory_menu_use_case.equip_item_use_case.EquipItemRequestModel;
import inventorymenu.inventory_menu_use_case.equip_item_use_case.EquipItemResponseModel;

public class EquipItemController {
    final EquipItemInputBoundary userInput;

    public EquipItemController(EquipItemInputBoundary userInput) {
        this.userInput = userInput;
    }

    public EquipItemResponseModel delete(EquipItemRequestModel requestModel){
        return userInput.equip(requestModel);
    }
}

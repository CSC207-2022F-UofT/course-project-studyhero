package UI.screens.inventoryscreens;

import use_cases.inventory_menu_use_case.delete_item_use_case.DeleteItemInputBoundary;
import use_cases.inventory_menu_use_case.delete_item_use_case.DeleteItemRequestModel;
import use_cases.inventory_menu_use_case.delete_item_use_case.DeleteItemResponseModel;

public class DeleteItemController {
    final DeleteItemInputBoundary userInput;

    public DeleteItemController(DeleteItemInputBoundary userInput) {
        this.userInput = userInput;
    }

    public DeleteItemResponseModel delete(DeleteItemRequestModel requestModel){
        return userInput.delete(requestModel);
    }
}

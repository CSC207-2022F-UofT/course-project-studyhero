package inventory.inventoryscreens;

import inventory.inventory_menu_use_case.delete_item_use_case.DeleteItemInputBoundary;
import inventory.inventory_menu_use_case.delete_item_use_case.DeleteItemRequestModel;
import inventory.inventory_menu_use_case.delete_item_use_case.DeleteItemResponseModel;

public class DeleteItemController {
    final DeleteItemInputBoundary userInput;

    public DeleteItemController(DeleteItemInputBoundary userInput) {
        this.userInput = userInput;
    }

    public DeleteItemResponseModel delete(DeleteItemRequestModel requestModel){
        return userInput.delete(requestModel);
    }

}

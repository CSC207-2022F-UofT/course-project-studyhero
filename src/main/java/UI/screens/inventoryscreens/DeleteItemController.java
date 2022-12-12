package UI.screens.inventoryscreens;

import use_cases.inventory_menu_use_case.delete_item_use_case.DeleteItemInputBoundary;
import use_cases.inventory_menu_use_case.delete_item_use_case.DeleteItemRequestModel;
import use_cases.inventory_menu_use_case.delete_item_use_case.DeleteItemResponseModel;

public class DeleteItemController {
    final DeleteItemInputBoundary userInput;

    /**
     * @param userInput is an input boundary(an interface) containing method that interacts with the userInput
     */
    public DeleteItemController(DeleteItemInputBoundary userInput) {
        this.userInput = userInput;
    }

    /**
     * delete the item in inventory based on request model
     * @param requestModel is the input data the user enters
     * @return a response from the deletion
     */
    public DeleteItemResponseModel delete(DeleteItemRequestModel requestModel){
        return userInput.delete(requestModel);
    }
}

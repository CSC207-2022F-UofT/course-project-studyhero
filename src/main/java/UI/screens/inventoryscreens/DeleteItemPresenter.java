package UI.screens.inventoryscreens;


import use_cases.inventory_menu_use_case.delete_item_use_case.DeleteItemOutputBoundary;
import use_cases.inventory_menu_use_case.delete_item_use_case.DeleteItemResponseModel;

public class DeleteItemPresenter implements DeleteItemOutputBoundary {

    /**
     * prepare success deletion view for the user
     * @param responseModel is the id of the item that was deleted from the inventory
     * @return the information after the successful deletion
     */
    @Override
    public DeleteItemResponseModel prepareSuccessView(DeleteItemResponseModel responseModel) {
        return responseModel;
    }

    /**
     * prepare fail deletion view for the user
     * @param error is an error that occurs during the deletion
     * @return the error after the failed deletion
     */
    @Override
    public DeleteItemResponseModel prepareFailView(String error) {
        throw new DeleteItemFailed(error);
    }
}

package inventorymenu.inventory_menu_use_case.delete_item_use_case;

public interface DeleteItemOutputBoundary {
    /**
     * create a successful message of deletion
     * @param inputId is the id of the item that was deleted from the inventory
     * @return the response after the deletion
     */
    DeleteItemResponseModel prepareSuccessView(DeleteItemResponseModel inputId);

    /**
     * create a fail message of deletion
     * @param error is an error that occurs during the deletion
     * @return the response after this deletion
     */
    DeleteItemResponseModel prepareFailView(String error);
}

package inventory_menu.inventory_menu_use_case.delete_item_use_case;

public interface DeleteItemOutputBoundary {
    DeleteItemResponseModel prepareSuccessView(DeleteItemResponseModel inputId);
    DeleteItemResponseModel prepareFailView(String error);
}

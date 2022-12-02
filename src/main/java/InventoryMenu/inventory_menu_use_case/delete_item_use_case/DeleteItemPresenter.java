package inventorymenu.inventory_menu_use_case.delete_item_use_case;

import inventorymenu.inventoryscreens.DeleteItemFailed;

public class DeleteItemPresenter implements DeleteItemOutputBoundary{

    @Override
    public DeleteItemResponseModel prepareSuccessView(DeleteItemResponseModel responseModel) {
        return responseModel;
    }

    @Override
    public DeleteItemResponseModel prepareFailView(String error) {
        throw new DeleteItemFailed(error);
    }
}

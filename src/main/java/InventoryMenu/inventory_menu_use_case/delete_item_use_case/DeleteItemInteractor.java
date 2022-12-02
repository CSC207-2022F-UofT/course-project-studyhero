package inventorymenu.inventory_menu_use_case.delete_item_use_case;

public class DeleteItemInteractor implements DeleteItemInputBoundary{
    final DeleteItemDsGateway dsGateway;
    final DeleteItemOutputBoundary outputBoundary;

    public DeleteItemInteractor(DeleteItemDsGateway dsGateway, DeleteItemOutputBoundary outputBoundary) {
        this.dsGateway = dsGateway;
        this.outputBoundary = outputBoundary;
    }


    @Override
    public DeleteItemResponseModel delete(DeleteItemRequestModel requestModel) {
        if(!dsGateway.itemExist(requestModel.getId())){
            return outputBoundary.prepareFailView("Item does not exist on the slot");
        }
        dsGateway.deleteItem(requestModel.getId());
        DeleteItemDsRequestModel name = dsGateway.getName(requestModel.getId());
        DeleteItemResponseModel deleteItemResponseModel = new DeleteItemResponseModel(name.getName(),
                requestModel.getId());

        return outputBoundary.prepareSuccessView(deleteItemResponseModel);
    }
}

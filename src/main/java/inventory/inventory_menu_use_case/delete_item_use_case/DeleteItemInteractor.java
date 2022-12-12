package inventory.inventory_menu_use_case.delete_item_use_case;

public class DeleteItemInteractor implements DeleteItemInputBoundary{
    final DeleteItemDsGateway dsGateway;
    final DeleteItemOutputBoundary outputBoundary;

    /**
     *
     * @param dsGateway an interface that communicates with the inventory data
     * @param outputBoundary an interface that communicates with output data
     */
    public DeleteItemInteractor(DeleteItemDsGateway dsGateway, DeleteItemOutputBoundary outputBoundary) {
        this.dsGateway = dsGateway;
        this.outputBoundary = outputBoundary;
    }


    /**
     * delete the item corresponding to the id in the inventory
     * @param requestModel the id of the inventory item in inventory
     * @return a response model that contains the id and the name of the item that has been deleted from the inventory
     */
    @Override
    public DeleteItemResponseModel delete(DeleteItemRequestModel requestModel) {
        if(!dsGateway.itemExist(requestModel.getId())){
            return outputBoundary.prepareFailView("Item does not exist on the slot");
        }

        DeleteItemDsRequestModel name = dsGateway.getDeletionName(requestModel.getId());
        DeleteItemResponseModel deleteItemResponseModel = new DeleteItemResponseModel(name.getName(),
                requestModel.getId());
        dsGateway.deleteItem(requestModel.getId());
        return outputBoundary.prepareSuccessView(deleteItemResponseModel);
    }
}

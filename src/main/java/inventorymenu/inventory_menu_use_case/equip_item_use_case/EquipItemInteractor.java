package inventorymenu.inventory_menu_use_case.equip_item_use_case;

import inventorymenu.inventory_menu_use_case.delete_item_use_case.*;

public class EquipItemInteractor implements EquipItemInputBoundary{
    final EquipItemDsGateway dsGateway;
    final EquipItemOutputBoundary outputBoundary;

    /**
     *
     * @param dsGateway an interface that communicates with the inventory data
     * @param outputBoundary an interface that communicates with output data
     */
    public EquipItemInteractor(EquipItemDsGateway dsGateway, EquipItemOutputBoundary outputBoundary) {
        this.dsGateway = dsGateway;
        this.outputBoundary = outputBoundary;
    }


    /**
     * delete the item corresponding to the id in the inventory
     * @param requestModel the id of the inventory item in inventory
     * @return a response model that contains the id and the name of the item
     * that has been equipped by the player from the inventory
     */
    @Override
    public EquipItemResponseModel equip(EquipItemRequestModel requestModel) {
        if(!dsGateway.itemExist(requestModel.getId())){
            return outputBoundary.prepareFailView("Item does not exist on the slot");
        }

        if(!dsGateway.itemEquipable(requestModel.getId())){
            return outputBoundary.prepareFailView("The item that you select is not equipable");
        }

        EquipItemDsRequestModel name = dsGateway.getName(requestModel.getId());
        EquipItemResponseModel equipItemResponseModel = new EquipItemResponseModel(name.getName(),
                requestModel.getId());
        dsGateway.equipItem(requestModel.getId());
        return outputBoundary.prepareSuccessView(equipItemResponseModel);
    }
}

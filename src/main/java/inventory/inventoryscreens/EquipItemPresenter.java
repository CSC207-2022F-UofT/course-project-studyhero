package inventory.inventoryscreens;

import inventory.inventory_menu_use_case.equip_item_use_case.EquipItemOutputBoundary;
import inventory.inventory_menu_use_case.equip_item_use_case.EquipItemResponseModel;

public class EquipItemPresenter implements EquipItemOutputBoundary {

    /**
     * prepare success deletion view for the user
     * @param responseModel is the id of the item that was deleted from the inventory
     * @return the information after the successful deletion
     */
    @Override
    public EquipItemResponseModel prepareSuccessView(EquipItemResponseModel responseModel) {
        return responseModel;
    }

    /**
     * prepare fail deletion view for the user
     * @param error is an error that occurs during the deletion
     * @return the error after the failed deletion
     */
    @Override
    public EquipItemResponseModel prepareFailView(String error) {
        throw new EquipItemFailed(error);
    }
}


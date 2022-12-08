package inventorymenu.inventoryscreens;

import inventorymenu.inventory_menu_use_case.equip_item_use_case.EquipItemOutputBoundary;
import inventorymenu.inventory_menu_use_case.equip_item_use_case.EquipItemResponseModel;

public class EquipItemPresenter implements EquipItemOutputBoundary {

    @Override
    public EquipItemResponseModel prepareSuccessView(EquipItemResponseModel responseModel) {
        return responseModel;
    }

    @Override
    public EquipItemResponseModel prepareFailView(String error) {
        throw new EquipItemFailed(error);
    }
}


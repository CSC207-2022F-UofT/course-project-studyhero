package inventorymenu.inventory_menu_use_case.equip_item_use_case;

import inventorymenu.inventory_menu_use_case.delete_item_use_case.DeleteItemResponseModel;

public interface EquipItemOutputBoundary {
    /**
     * create a successful message of equip
     * @param inputId is the id of the item the player wants to equip from the inventory
     * @return the response after the equip process
     */
    EquipItemResponseModel prepareSuccessView(EquipItemResponseModel inputId);

    /**
     * create a fail message of equip
     * @param error is an error that occurs during the equip process
     * @return the response after the equip process
     */
    EquipItemResponseModel prepareFailView(String error);
}

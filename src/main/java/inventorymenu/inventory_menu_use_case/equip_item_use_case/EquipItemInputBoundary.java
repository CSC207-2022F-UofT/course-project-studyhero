package inventorymenu.inventory_menu_use_case.equip_item_use_case;

public interface EquipItemInputBoundary {
    /**
     * delete the item corresponding to the id in the inventory
     * @param requestModel the id of the inventory item in inventory
     * @return a response model that contains the id and the name of the item
     * that has been equipped from the inventory
     */
    EquipItemResponseModel equip(EquipItemRequestModel requestModel);
}

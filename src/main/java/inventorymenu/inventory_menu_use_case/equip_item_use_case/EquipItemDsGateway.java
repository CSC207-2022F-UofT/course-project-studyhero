package inventorymenu.inventory_menu_use_case.equip_item_use_case;

public interface EquipItemDsGateway {
    /**
     * Check if the item is in the inventory
     * @return true if the item is in the inventory
     */
    boolean itemExist(int id);

    /**
     * Check if the item is equipable
     * @return true if the item is equipable
     */
    boolean itemEquipable(int id);

    /**
     * Equip the item from inventory
     * @param id of the item wants to be equipped from inventory
     */
    void equipItem(int id);

    /**
     * Get the name of the inventory item correspond to the id in the inventory
     * @param id of the item wants to be equipped from inventory
     * @return the name of the item that wants to be equipped from inventory
     */
    EquipItemDsRequestModel getEquipName(int id);
}

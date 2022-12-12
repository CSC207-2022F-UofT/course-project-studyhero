package inventory.inventory_menu_use_case.equip_item_use_case;

public class EquipItemRequestModel {
    private final int id;

    /**
     * @param id is used identify id'th item in the inventory
     */
    public EquipItemRequestModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}

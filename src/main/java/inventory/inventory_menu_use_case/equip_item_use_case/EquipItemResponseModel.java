package inventory.inventory_menu_use_case.equip_item_use_case;

public class EquipItemResponseModel {
    String name;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param name is the name of the inventory item that the player wants to equip
     * @param id the position that inventory item occupied
     */
    public EquipItemResponseModel(String name, int id) {
        this.name = name;
        this.id = id;
    }


    public int getId() {
        return id;
    }
}

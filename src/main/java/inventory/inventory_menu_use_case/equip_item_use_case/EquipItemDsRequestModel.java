package inventory.inventory_menu_use_case.equip_item_use_case;

public class EquipItemDsRequestModel {
    /**
     * @param name of the inventory item that has been equipped
     * @param type
     */
    public EquipItemDsRequestModel(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    private final String name;

    public String getType() {
        return type;
    }

    private final String type;

}

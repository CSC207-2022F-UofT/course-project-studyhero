package use_cases.inventory_menu_use_case.equip_item_use_case;

public class EquipItemDsRequestModel {
    /**
     * @param name of the inventory item that has been equipped
     */
    public EquipItemDsRequestModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    private final String name;

}

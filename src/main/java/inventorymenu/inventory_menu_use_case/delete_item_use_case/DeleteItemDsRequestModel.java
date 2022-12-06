package inventorymenu.inventory_menu_use_case.delete_item_use_case;

public class DeleteItemDsRequestModel {
    /**
     *
     * @param name of the inventory item that has been deleted
     */
    public DeleteItemDsRequestModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    private final String name;


}

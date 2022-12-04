package inventorymenu.inventory_menu_use_case.delete_item_use_case;

public class DeleteItemRequestModel {
    private final int id;

    /**
     * @param id is used identify id'th item in the inventory
     */
    public DeleteItemRequestModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}

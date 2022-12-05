package inventory_menu.inventory_menu_use_case.delete_item_use_case;

public class DeleteItemResponseModel {
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
     * @param name is the name of the inventory item that got deleted
     * @param id the position that inventory item occupied
     */
    public DeleteItemResponseModel(String name, int id) {
        this.name = name;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

package InventoryMenu.InventoryItem;

public class InventoryItemDsRequestModel {

    private final String name;
    private final String type;
    private final int effect;
    private int id;


    /**
     *
     * @param name name of the inventory item
     * @param type type of the inventory item
     * @param effect effect of the inventory item that will be added on player in some way
     * @param id id of the inventory item in player's inventory.
     */
    public InventoryItemDsRequestModel(int id, String type, String name, int effect) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.effect = effect;
    }

    /**
     * Get inventory item's type
     * @return type of the AddItemDsRequestModel
     */
    public String getType() {
        return type;
    }

    /**
     * Get inventory item's effect
     * @return effect of the AddItemDsRequestModel
     */
    public int getEffect() {
        return effect;
    }

    /**
     * Get inventory item's name
     * @return name of the AddItemDsRequestModel
     */
    public String getName() {
        return name;
    }

    /**
     * Get inventory item's id in user's inventory
     * @return id of the AddItemDsRequestModel in user's inventory
     */
    public int getId() {
        return id;
    }

    /**
     * Set inventory item's id in user's inventory
     * @param id of the AddItemDsRequestModel in user's inventory
     */
    public void setId(int id) {
        this.id = id;
    }
}

package inventorymenu.inventoryitem;

public class InventoryItemDsRequestModel {

    private final String name;
    private final String type;
    private final int effect;
    private int id;
    private final int goldValue;
    private boolean isEquipped;

    /**
     * @param id        of the inventory item in player's inventory.
     * @param type      of the inventory item
     * @param name      of the inventory item
     * @param effect    of the inventory item that will be added on a unit in some way
     * @param goldValue of the inventory item that will be added
     * @param isEquipped ,whether the inventory is being equipped or not
     */
    public InventoryItemDsRequestModel(int id, String type, String name, int effect, int goldValue, boolean isEquipped) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.effect = effect;
        this.goldValue = goldValue;
        this.isEquipped = isEquipped;
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

    /**
     * Get the gold value of the inventory item
     * @return gold value of the inventory item
     */
    public int getGoldValue() {
        return goldValue;
    }

    /**
     * check if the item is equipped by the player
     * @return true if player is equipping the item
     */
    public boolean checkIsEquipped() {
        return isEquipped;
    }

    /**
     * Set equip status for the inventory item
     * @param equipped indicates whether the player is equipping the inventory item or not
     */
    public void setEquipped(boolean equipped) {
        isEquipped = equipped;
    }

}

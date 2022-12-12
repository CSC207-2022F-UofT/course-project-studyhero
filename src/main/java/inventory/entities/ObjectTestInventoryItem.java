package inventory.entities;

public class ObjectTestInventoryItem {

    private final Object name;
    private final Object type;
    private final Object effect;
    private Object id;
    private final Object goldValue;
    private Object isEquipped;

    /**
     * @param id        of the inventory item in player's inventory.
     * @param type      of the inventory item
     * @param name      of the inventory item
     * @param effect    of the inventory item that will be added on a unit in some way
     * @param goldValue of the inventory item that will be added
     * @param isEquipped ,whether the inventory is being equipped or not
     */
    public ObjectTestInventoryItem(Object id, Object type, Object name, Object effect, Object goldValue, Object isEquipped) {
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
    public Object getType() {
        return type;
    }

    /**
     * Get inventory item's effect
     * @return effect of the AddItemDsRequestModel
     */
    public Object getEffect() {
        return effect;
    }

    /**
     * Get inventory item's name
     * @return name of the AddItemDsRequestModel
     */
    public Object getName() {
        return name;
    }

    /**
     * Get inventory item's id in user's inventory
     * @return id of the AddItemDsRequestModel in user's inventory
     */
    public Object getId() {
        return id;
    }

    /**
     * Set inventory item's id in user's inventory
     * @param id of the AddItemDsRequestModel in user's inventory
     */
    public void setId(Object id) {
        this.id = id;
    }

    /**
     * Get the gold value of the inventory item
     * @return gold value of the inventory item
     */
    public Object getGoldValue() {
        return goldValue;
    }

    /**
     * check if the item is equipped by the player
     * @return true if player is equipping the item
     */
    public Object checkIsEquipped() {
        return isEquipped;
    }

    /**
     * Set equip status for the inventory item
     * @param equipped indicates whether the player is equipping the inventory item or not
     */
    public void setEquipped(Object equipped) {
        isEquipped = equipped;
    }

}

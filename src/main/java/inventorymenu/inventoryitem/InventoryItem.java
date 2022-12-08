package inventorymenu.inventoryitem;

public class InventoryItem {
    private final String name;
    private final String type;
    private final int effect;
    private final int goldValue;
    private final boolean isEquipped;

    /**
     * Constructor for InventoryItem
     *
     * @param type      of the inventoryItem
     * @param name      of the inventoryItem
     * @param effect    of the inventoryItem that will be added on player in some way
     * @param goldValue of the inventoryItem
     * @param isEquipped ,whether the inventory is being equipped or not
     */
    public InventoryItem(String type, String name, int effect, int goldValue, boolean isEquipped) {
        this.name = name;
        this.type = type;
        this.effect = effect;
        this.goldValue = goldValue;
        this.isEquipped = isEquipped;
    }

    /**
     * Get InventoryItem type
     * @return type of the inventoryItem
     */
    public String getType() {
        return type;
    }

    /**
     * Get InventoryItem's name
     * @return name of the inventoryItem
     */
    public String getName() {
        return name;
    }

    /**
     * Get InventoryItem effect
     * @return effect of the inventoryItem
     */
    public int getEffect() {
        return effect;
    }

    /**
     * Get inventoryItem's gold value
     * @return the gold value of the inventoryItem
     */
    public int getGoldValue(){
        return goldValue;
    }


    /**
     * Check if the inventory item is equipped
     * @return true if the player is equipping the inventory item
     */
    public boolean checkIsEquipped() {
        return isEquipped;
    }
}

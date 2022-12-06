package inventory_menu.inventoryitem;

public class InventoryItem {
    private final String name;
    private final String type;
    private final int effect;
    private final int goldValue;

    /**
     * Constructor for InventoryItem
     *
     * @param type      of the inventoryItem
     * @param name      of the inventoryItem
     * @param effect    of the inventoryItem that will be added on player in some way
     * @param goldValue of the inventoryItem
     */
    public InventoryItem(String type, String name, int effect, int goldValue) {
        this.name = name;
        this.type = type;
        this.effect = effect;
        this.goldValue = goldValue;
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
}

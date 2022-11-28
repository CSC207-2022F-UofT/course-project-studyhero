package InventoryMenu.InventoryItem;

public class InventoryItem {
    private final String name;
    private final String type;
    private final int effect;

    /**
     * Constructor for InventoryItem
     * @param name name of the inventoryItem
     * @param type type of the inventoryItem
     * @param effect effect of the inventoryItem that will be added on player in some way
     */
    public InventoryItem(String type, String name, int effect) {
        this.name = name;
        this.type = type;
        this.effect = effect;
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
}

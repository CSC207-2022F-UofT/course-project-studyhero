package InventoryMenu.InventoryItem;

public class InventoryItem {
    private final String name;

    /**
     * Get InventoryItem type
     * @return type of the inventoryItem
     */
    public String getType() {
        return type;
    }

    private final String type;

    /**
     * Get InventoryItem effect
     * @return effect of the inventoryItem
     */
    public int getEffect() {
        return effect;
    }

    private final int effect;

    /**
     * Constructor for InventoryItem
     * @param name name of the inventoryItem
     * @param type type of the inventoryItem
     * @param effect effect of the inventoryItem that will be added on player in some way
     */
    public InventoryItem(String name, String type, int effect) {
        this.name = name;
        this.type = type;
        this.effect = effect;
    }

    /**
     * Get InventoryItem's name
     * @return name of the inventoryItem
     */
    public String getName() {
        return name;
    }
}

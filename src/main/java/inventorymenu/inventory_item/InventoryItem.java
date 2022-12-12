package inventorymenu.inventory_item;

public class InventoryItem {
    private final String name;
    private final String type;
    private final int effect;

    /**
     * Constructor for inventory_item
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
     * Get inventory_item type
     * @return type of the inventoryItem
     */
    public String getType() {
        return type;
    }

    /**
     * Get inventory_item's name
     * @return name of the inventoryItem
     */
    public String getName() {
        return name;
    }

    /**
     * Get inventory_item effect
     * @return effect of the inventoryItem
     */
    public int getEffect() {
        return effect;
    }
}

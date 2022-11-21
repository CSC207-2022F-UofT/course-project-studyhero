package inventory_menu.inventory_item;

public class InventoryItem {
    private final String name;

    public String getType() {
        return type;
    }

    private final String type;

    public int getEffect() {
        return effect;
    }

    private final int effect;

    public InventoryItem(String name, String type, int effect) {
        this.name = name;
        this.type = type;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }
}

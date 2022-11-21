package inventory_menu.inventory_item;

public class Potion extends InventoryItem implements Consumable{
    public Potion(String name, String type, int effect) {
        super(name, type, effect);
    }

    @Override
    public void consume() {

    }
}

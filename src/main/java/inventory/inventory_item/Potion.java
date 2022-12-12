package inventory.inventory_item;

public class Potion extends InventoryItem implements Consumable{
    /**
     *
     * @param name name of the Potion
     * @param type type of the Potion
     * @param effect effect of the Potion when consumed
     */
    public Potion(String type, String name, int effect) {
        super(type, name, effect);
    }

    /**
     * Consume the potion and add the effect to player's stat (Incomplete)
     */
    @Override
    public void consume() {

    }
}

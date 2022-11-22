package InventoryMenu.InventoryItem;

public class Potion extends InventoryItem implements Consumable{
    /**
     *
     * @param name name of the Potion
     * @param type type of the Potion
     * @param effect effect of the Potion when consumed
     */
    public Potion(String name, String type, int effect) {
        super(name, type, effect);
    }

    /**
     * Consume the potion and add the effect to player's stat (Incomplete)
     */
    @Override
    public void consume() {

    }
}

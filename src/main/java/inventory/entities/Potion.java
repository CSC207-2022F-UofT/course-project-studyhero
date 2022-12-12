package inventory.entities;

public class Potion extends InventoryItem implements Consumable{
    /**
     *
     * @param name of the Potion
     * @param type of the Potion
     * @param effect of the Potion when consumed
     * @param goldValue of the Potion
     */
    public Potion(String type, String name, int effect, int goldValue) {
        super(0, type, name, effect, goldValue, false);
    }

    /**
     * Consume the potion and add the effect to player's stat (Incomplete)
     */
    @Override
    public void consume() {

    }
}

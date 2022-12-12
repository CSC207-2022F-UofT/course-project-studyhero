package inventory.entities;

public class Shield extends InventoryItem implements Equipable {
    private final static String type = "Shield";


    /**
     * An InventoryItem that can be equipped and add effect to unit's defence.
     * @param name of the shield
     * @param shieldDefence that will be added to unit's defence
     * @param goldValue of the shield
     */
    public Shield(String name, int shieldDefence, int goldValue) {
        super(0, type, name, shieldDefence, goldValue, false);
    }

    /**
     * Increase unit's stat by weapon's effect.(Incomplete)
     */
    @Override
    public void equip() {

    }
}

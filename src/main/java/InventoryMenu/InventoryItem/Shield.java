package InventoryMenu.InventoryItem;

public class Shield extends InventoryItem implements Equipable {


    /**
     * An InventoryItem that can be equipped and add effect to player's defence.
     * @param name name of the shield
     * @param shieldDefence effect that will be added to player's defence
     */
    public Shield(String name, int shieldDefence) {
        super(name, "Shield", shieldDefence);
    }

    /**
     * Increase player's stat by weapon's effect.(Incomplete)
     */
    @Override
    public void equip() {

    }
}

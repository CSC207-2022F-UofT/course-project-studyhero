package inventorymenu.inventoryitem;

public class Weapon extends InventoryItem implements Equipable {
    private final static String type = "Weapon";

    /**
     * An InventoryItem that can be equipped and add effect to player's attack.
     * @param name name of the shield
     * @param weaponAttack effect that will be added to player's attack
     */
    public Weapon(String name, int weaponAttack) {
        super(type, name, weaponAttack);
    }

    /**
     * Increase player's stat by weapon's effect. (Incomplete)
     */
    @Override
    public void equip() {

    }
}

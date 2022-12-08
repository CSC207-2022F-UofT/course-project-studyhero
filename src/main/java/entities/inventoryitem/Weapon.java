package entities.inventoryitem;

public class Weapon extends InventoryItem implements Equipable {
    private final static String type = "Weapon";

    /**
     * An InventoryItem that can be equipped and add effect to unit's attack.
     * @param name of the weapon
     * @param weaponAttack that will be added to unit's attack
     * @param goldValue of the weapon
     */
    public Weapon(String name, int weaponAttack, int goldValue) {
        super(0, type, name, weaponAttack, goldValue, false);
    }

    /**
     * Increase unit's stat by weapon's effect. (Incomplete)
     */
    @Override
    public void equip() {

    }
}

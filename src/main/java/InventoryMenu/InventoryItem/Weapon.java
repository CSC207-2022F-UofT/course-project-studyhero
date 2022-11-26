package InventoryMenu.InventoryItem;

public class Weapon extends InventoryItem implements Equipable {

    /**
     * An InventoryItem that can be equipped and add effect to player's attack.
     * @param name name of the shield
     * @param weaponAttack effect that will be added to player's attack
     */
    public Weapon(String name, int weaponAttack) {
        super(name, "Weapon", weaponAttack);
    }

    /**
     * Increase player's stat by weapon's effect. (Incomplete)
     */
    @Override
    public void equip() {

    }
}

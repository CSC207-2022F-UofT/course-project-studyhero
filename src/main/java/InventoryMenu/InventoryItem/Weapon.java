package InventoryMenu.InventoryItem;

public class Weapon extends InventoryItem implements Equipable {

    public Weapon(String name, int weaponAttack) {
        super(name, "Weapon", weaponAttack);
    }

    @Override
    public void equip() {

    }
}

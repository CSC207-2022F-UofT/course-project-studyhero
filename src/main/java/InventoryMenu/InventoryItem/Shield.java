package InventoryMenu.InventoryItem;

public class Shield extends InventoryItem implements Equipable {

    public Shield(String name, int shieldDefence) {
        super(name, "Shield", shieldDefence);
    }

    @Override
    public void equip() {

    }
}

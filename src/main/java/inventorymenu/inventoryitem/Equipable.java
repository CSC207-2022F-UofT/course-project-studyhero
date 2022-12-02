package inventorymenu.inventoryitem;

public interface Equipable {
    /**
     * Increase player's stat by current equipment's effect. If the equipment is a weapon, add the effect to player's
     * attack, if the equipment is a shield, add the effect to player's defence.
     */
    void equip();
}

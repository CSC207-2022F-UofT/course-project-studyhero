package inventory.inventory_item.entities;

public interface Regenerative {
    /**
     * add health to a unit
     */
    void restoreHealth(int healthBonus);
}

package inventory.inventory_item.entities;

public interface Poisonous {
    /**
     * deduct health to a unit
     */
    void deductHealth(int poisonBonus);
}

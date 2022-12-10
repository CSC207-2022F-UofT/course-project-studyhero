package entities.inventoryitem;

public interface Poisonous {
    /**
     * deduct health to a unit
     */
    void deductHealth(int poisonBonus);
}

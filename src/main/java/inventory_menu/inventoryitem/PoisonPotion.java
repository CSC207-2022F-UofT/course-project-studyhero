package inventory_menu.inventoryitem;

public class PoisonPotion extends Potion implements Poisonous {
    /**
     * @param goldValue of the HealthPotion
     * @param name of the HealthPotion
     * @param effect of the HealthPotion
     */
    public PoisonPotion(String name, int effect, int goldValue) {
        super("PoisonPotion", name, effect, goldValue);
    }
    /**
     * Deduct health to a unit's health (Incomplete)
     * @param poisonBonus
     */
    @Override
    public void deductHealth(int poisonBonus) {

    }
}

package inventory.entities;

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
     * poisonBonus can deal damage to a unit's health
     * @param poisonBonus, deduct that proportion of health to a unit
     */
    @Override
    public void deductHealth(int poisonBonus) {

    }
}

package entities.inventoryitem;


public class AttackPotion extends Potion implements Aggressive {


    /**
     * @param goldValue of the AttackPotion
     * @param name of the AttackPotion
     * @param effect of the AttackPotion
     */
    public AttackPotion(String name, int effect, int goldValue) {
        super("AttackPotion", name, effect, goldValue);

    }

    /**
     * Add attackBonus to player's attack (Incomplete)
     * @param attackBonus that will be added to player's stat
     */
    @Override
    public void enhanceAttack(int attackBonus) {

    }
}

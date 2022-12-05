package inventorymenu.inventoryitem;


public class AttackPotion extends Potion implements Aggressive {


    /**
     *
     * @param name This is the name of the AttackPotion
     * @param effect This is the effect of the AttackPotion
     */
    public AttackPotion(String name, int effect) {
        super("AttackPotion", name, effect);

    }

    /**
     * Add attackBonus to player's attack (Incomplete)
     * @param attackBonus is the bonus attack that will be added to player's stat
     */
    @Override
    public void enhanceAttack(int attackBonus) {

    }
}

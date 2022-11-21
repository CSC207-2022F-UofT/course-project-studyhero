package inventory_menu.inventory_item;

public class AttackPotion extends Potion implements Aggresive{


    public AttackPotion(String name, String type, int effect) {
        super(name, type, effect);
    }

    @Override
    public void enhanceAttack(int attackBonus) {

    }
}

package inventory_menu.inventory_item;

public class DefencePotion extends Potion implements Defensive{
    public DefencePotion(String name, String type, int effect) {
        super(name, type, effect);
    }

    @Override
    public void enhanceDefence() {

    }
}

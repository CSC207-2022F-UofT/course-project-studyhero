package UI.screens.inventoryscreens;

public class EquipItemFailed extends RuntimeException{
    public EquipItemFailed(String error) {
        super(error);
    }
}
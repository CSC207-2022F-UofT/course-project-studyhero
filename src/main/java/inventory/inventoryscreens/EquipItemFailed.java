package inventory.inventoryscreens;

public class EquipItemFailed extends RuntimeException{
    /**
     * generate an error
     * @param error is the type of error the user will get
     */
    public EquipItemFailed(String error) {
        super(error);
    }
}

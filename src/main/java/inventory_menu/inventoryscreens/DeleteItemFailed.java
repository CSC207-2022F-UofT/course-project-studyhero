package inventory_menu.inventoryscreens;

public class DeleteItemFailed extends RuntimeException {
    public DeleteItemFailed(String error) {
        super(error);
    }
}

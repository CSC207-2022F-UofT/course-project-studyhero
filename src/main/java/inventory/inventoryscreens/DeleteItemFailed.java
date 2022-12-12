package inventory.inventoryscreens;

public class DeleteItemFailed extends RuntimeException {
    public DeleteItemFailed(String error) {
        super(error);
    }
}

package UI.screens.inventoryscreens;

public class DeleteItemFailed extends RuntimeException {
    /**
     * generate an error
     * @param error is the type of error the user will get
     */
    public DeleteItemFailed(String error) {
        super(error);
    }
}

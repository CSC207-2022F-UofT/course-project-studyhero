package use_cases.new_game.confirmation_window;

/**
 * Input boundary that allows controller to create a window
 * displaying a confirmation message before proceeding with action
 */
public interface ConfirmationWindowInputBoundary {
    /**
     * @return JFrame window containing the confirmation message
     */
    ConfirmationWindowOutputBoundary createWindow();
}

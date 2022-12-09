package use_cases.errors;

public class ErrorPresenter implements ErrorOutputBoundary{

    /**
     * Initializes and returns an ErrorWindow object displaying the
     * error message.
     *
     * @param error     error message
     */
    @Override
    public void error(String error){
        new ErrorWindow(error);
    }
}
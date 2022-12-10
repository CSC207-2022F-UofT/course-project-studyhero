package use_cases.errors;

public class ErrorPresenter implements ErrorOutputBoundary{

    String error;

    /**
     * @return error message of presenter
     */
    public String getError(){
        return this.error;
    }

    /**
     * Initializes and returns an ErrorWindow object displaying the
     * error message.
     *
     * @param error     error message
     */
    @Override
    public boolean error(String error){
        new ErrorWindow(error);
        this.error = error;
        return true;
    }
}
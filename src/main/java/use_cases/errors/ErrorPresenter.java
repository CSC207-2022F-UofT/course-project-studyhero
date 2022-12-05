package use_cases.errors;

public class ErrorPresenter implements ErrorOutputBoundary{
    @Override
    public void error(String error){
        new ErrorWindow(error);
    }
}
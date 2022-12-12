package errors.usecases;

public interface ErrorOutputBoundary {

    /**
     * Output boundary for use cases that do not output
     * data for the user but may need to show the user
     * an error message if an error occurs.
     *
     * @param error     error message
     */
    boolean error(String error);
    String getError();
    void setError(String s);

}
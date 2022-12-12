package use_cases.game_check;

/**
 * Input boundary that allows controller to check for
 * whether given files are valid for reading and playing.
 */
public interface GameCheckInputBoundary {

    /**
     * @return true if all files are valid, false if otherwise
     */
    boolean check();

    /**
     * @return true if all files are valid, false if otherwise
     * and also create a JFrame to display the error
     */
    boolean valid();


}

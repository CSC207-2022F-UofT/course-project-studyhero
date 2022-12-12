package use_cases.file_checker;

/**
 * Data structure gateway interface that allows for files to
 * be checked for validity and existence
 */
public interface ValidFileDsGateway {

    /**
     * @return true if the file exists
     */
    boolean fileExists();

    /**
     * @return true if the file exists and is valid for
     * reading and data manipulation
     */
    boolean isPlayable();

    /**
     * @return true if the file is playable, else false
     * and presents a screen displaying the file error
     */
    boolean isValid();
}
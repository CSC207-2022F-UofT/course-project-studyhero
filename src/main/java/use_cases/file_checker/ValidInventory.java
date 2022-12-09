package use_cases.file_checker;

import java.io.*;

/**
 * Data structure gateway interface that checks for valid
 * inventory files
 */
public interface ValidInventory extends ValidFileDsGateway{

    String[] read(BufferedReader br);

    String checkError();

    @Override
    boolean fileExists();

    @Override
    boolean isPlayable();
    @Override
    boolean isValid();
}
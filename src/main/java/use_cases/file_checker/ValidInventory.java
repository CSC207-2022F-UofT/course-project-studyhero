package use_cases.file_checker;

import use_cases.errors.ErrorOutputBoundary;

import java.io.*;
import java.util.Arrays;


public interface ValidInventory extends ValidFileDsGateway{

    public String[] read(BufferedReader br);

    public String checkError();

    @Override
    public boolean fileExists();

    @Override
    public boolean isPlayable();
    @Override
    public boolean isValid();
}
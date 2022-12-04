package use_cases.file_checker;

import use_cases.errors.ErrorPresenter;

import java.io.File;

public class ValidInventory implements ValidFileDsGateway{

    String filename;
    File file;
    ErrorPresenter presenter;
    public ValidInventory(String filename, ErrorPresenter presenter){
        this.filename = filename;
        this.file = new File(filename);
        this.presenter = presenter;
    }

    @Override
    public boolean fileExists() {
        return (file.exists() && !file.isDirectory());    }

    @Override
    public boolean isValid() {
        if (!fileExists()){
            presenter.error("There is no existing " + filename + " file.");
            return false;
        }
        else{return true;}
    }
}

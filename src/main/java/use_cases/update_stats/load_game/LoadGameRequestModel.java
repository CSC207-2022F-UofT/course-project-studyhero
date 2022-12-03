package use_cases.update_stats.load_game;

import java.io.File;

public class LoadGameRequestModel {
    private File file ;
    private String filename;

    public LoadGameRequestModel(){
        this.filename = "stats.csv";
        this.file = new File(filename);
    }

    public File getFile(){
        return file;}

    public void setFile(File file){this.file = file;}
}

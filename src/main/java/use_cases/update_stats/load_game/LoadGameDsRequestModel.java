package use_cases.update_stats.load_game;

import java.io.File;

public class LoadGameDsRequestModel {

    private File file;

    public LoadGameDsRequestModel(){
        this.file = new File("stats.csv");
    }
    public File getFile(){return file;}
}

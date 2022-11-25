package loadGame;

import java.io.File;

public class checkGameExistsInteractor {
    public static boolean checkFile(File filename){
        return filename.exists() && !filename.isDirectory();
    }
}

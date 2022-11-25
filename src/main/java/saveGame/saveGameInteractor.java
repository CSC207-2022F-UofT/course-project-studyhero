package saveGame;
import entities.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

public class saveGameInteractor {
    public static void saveGame() {
        try{
            File statsFile = new File("stats.csv");
            Map<String, Integer> stats = user.getUser().getUserStats();
            PrintWriter out = new PrintWriter(statsFile);

            ArrayList<String> key = new ArrayList<>(stats.keySet());

            // made arbitrary so that attribute names can be changed
            String att0 = key.get(0);
            String att1 = key.get(1);
            String att2 = key.get(2);
            String att3 = key.get(3);
            String att4 = key.get(4);

            out.printf("%s, %s, %s, %s, %s \n", att0, att1, att2, att3, att4);
            out.printf("%d, %d, %d, %d, %d \n",
                    stats.get(att0), stats.get(att1), stats.get(att2),
                    stats.get(att3), stats.get(att4));

            out.close();

            System.out.println(stats);
            System.out.println("Saved.");


        } catch (IOException e){
            // TODO: there should be a popup to notify the user that the file
            //  does not exist.
            System.out.println("File doesn't exist.");
            e.printStackTrace();
        }
    }

}

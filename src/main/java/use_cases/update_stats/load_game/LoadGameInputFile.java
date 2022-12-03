package use_cases.update_stats.load_game;

import entities.user;
import use_cases.update_stats.checkGameExistsInteractor;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoadGameInputFile implements LoadGameDsGateway{
    private File csvFile;
    private final Map<String, Integer> statsMap = new LinkedHashMap<>();

    public LoadGameInputFile(){
        csvFile = new File("stats.csv");

        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            String attributes = br.readLine();
            String[] allAttributes = attributes.split(", ");

            String att0 = allAttributes[0], att1 = allAttributes[1], att2 = allAttributes[2],
                    att3 = allAttributes[3], att4 = allAttributes[4].trim();
            System.out.println(att0 + att1 + att2 + att3 + att4);

            String readline = br.readLine().trim();
            System.out.println(readline);
            String[] values = readline.split(", ");

            Integer attVal0 = Integer.valueOf(values[0]),
                    attVal1 = Integer.valueOf(values[1]),
                    attVal2 = Integer.valueOf(values[2]),
                    attVal3 = Integer.valueOf(values[3]),
                    attVal4 = Integer.valueOf(values[4]);

            statsMap.put(att0, attVal0);
            statsMap.put(att1, attVal1);
            statsMap.put(att2, attVal2);
            statsMap.put(att3, attVal3);
            statsMap.put(att4, attVal4);
        } catch (FileNotFoundException e) {
            //TODO: there should be more here.
            // when the file isn't found the user should be
            // notified via a popup window or something similar
            System.out.println("File not found.");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("IOException.");
            throw new RuntimeException(e);
        }


    }
    @Override
    public boolean existsGame(String filename) {
        return false;
    }

    @Override
    public void save(LoadGameDsRequestModel requestModel) {

    }
}

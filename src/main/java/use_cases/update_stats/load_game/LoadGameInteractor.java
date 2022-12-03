package use_cases.update_stats.load_game;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LoadGameInteractor implements LoadGameInputBoundary{
    final LoadGameDsGateway loadGameDsGateway;
    final LoadGamePresenter loadGamePresenter;

    public LoadGameInteractor(LoadGameDsGateway loadGameDsGateway,
                              LoadGamePresenter loadGamePresenter){
        this.loadGameDsGateway = loadGameDsGateway;
        this.loadGamePresenter = loadGamePresenter;
    }

    @Override
    public Map<String, Integer> load(LoadGameRequestModel requestModel) {
        File statsCsvFile = requestModel.getFile();

        if (loadGameDsGateway.existsGame("stat.csv") == false) {
            loadGamePresenter.prepareFailView("Cannot load game. There is no save file.");
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader(statsCsvFile));
                String attributes = br.readLine().trim();
                String[] allAttributes = attributes.split(", ");

                String att0 = allAttributes[0], att1 = allAttributes[1], att2 = allAttributes[2],
                        att3 = allAttributes[3], att4 = allAttributes[4];

                String readline = br.readLine().trim();
                System.out.println(readline);
                String[] values = readline.split(", ");

                Integer attVal0 = Integer.valueOf(values[0]),
                        attVal1 = Integer.valueOf(values[1]),
                        attVal2 = Integer.valueOf(values[2]),
                        attVal3 = Integer.valueOf(values[3]),
                        attVal4 = Integer.valueOf(values[4]);

                Map<String, Integer> statsMap = new HashMap<>();
                statsMap.put(att0, attVal0);
                statsMap.put(att1, attVal1);
                statsMap.put(att2, attVal2);
                statsMap.put(att3, attVal3);
                statsMap.put(att4, attVal4);

                return statsMap;

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
        return null;
    }

}

package stats_storage;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StatsFileDataAccess implements StatsDsGateway {
    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final StatsDsRequestModel statsDsRequestModel = new StatsDsRequestModel();

    public StatsFileDataAccess(String csvPath) throws IOException {
        csvFile = new File(csvPath);

        headers.put("level", 0);
        headers.put("hp", 1);
        headers.put("gold", 2);
        headers.put("damage", 3);
        headers.put("defence", 4);

        if (csvFile.length() == 0) {
            save();
        } else {

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine();

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String username = String.valueOf(col[headers.get("username")]);
                String password = String.valueOf(col[headers.get("password")]);
                String creationTimeText = String.valueOf(col[headers.get("creation_time")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                UserRegisterDsRequestModel user = new UserRegisterDsRequestModel(username, password, ldt);
                accounts.put(username, user);
            }

            reader.close();
        }
    }

    @Override
    public Map<String, Integer> loadStats() {
        return null;
    }

    @Override
    public void saveStats(String filePath) {
        File file = new File(filePath);

    }
}

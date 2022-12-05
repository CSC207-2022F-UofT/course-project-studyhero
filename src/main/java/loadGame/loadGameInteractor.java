package loadGame;

import entities.StatsUser;
import entities.user;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class loadGameInteractor {
    public static void loadGame(){
        File file = new File("stats.csv");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String attributes = br.readLine();
            String[] allAttributes = attributes.split(", ");

            String att0 = allAttributes[0], att1 = allAttributes[1], att2 = allAttributes[2],
                    att3 = allAttributes[3], att4 = allAttributes[4].trim();
            System.out.println(att0 + att1 + att2 + att3 + att4);


            String readline;
            while ((readline = br.readLine()) != null){
                readline = readline.replaceAll("\\s+ ", "");
                System.out.println(readline);
                String[] values = readline.split(", ");

                Integer attVal0 = Integer.valueOf(values[0]); //gold
                Integer attVal1 = Integer.valueOf(values[1]); //damage
                Integer attVal2 = Integer.valueOf(values[2]); //level
                Integer attVal3 = Integer.valueOf(values[3]); //defence
                Integer attVal4 = Integer.valueOf(values[4].replaceAll("\\s+", "")); //hp

                Map<String, Integer> statsMap = new HashMap<>();
                statsMap.put(att0, attVal0);
                statsMap.put(att1, attVal1);
                statsMap.put(att2, attVal2);
                statsMap.put(att3, attVal3);
                statsMap.put(att4, attVal4);

                StatsUser importPlayer = new StatsUser(statsMap);
                user.setUser(importPlayer);

                System.out.println("File Loaded!");
                System.out.println(user.getUser().getUserStats());
            }

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
}

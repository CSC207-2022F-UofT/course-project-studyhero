package use_cases.file_checker;

import entities.StatsUser;
import use_cases.errors.ErrorPresenter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ValidStats implements ValidFileDsGateway{
    String filename;
    File file;
    ErrorPresenter presenter;
    public ValidStats(String filename,ErrorPresenter presenter){
        this.filename = filename;
        this.file = new File(filename);
        this.presenter = presenter;
    }

    public String[] read(BufferedReader br, String str){
        String line;
        String[] array = new String[0];
        try {
            if ((line = br.readLine()) == null){
                presenter.error("No " + str +  " in " + " file.");
                return array;
            } else{ return line.split(", ");}
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Integer> load(){
        HashMap<String, Integer> statsMap = new HashMap<>();
        if (isValid()){
            File statsFile = new File(filename);
            try {
                BufferedReader br = new BufferedReader(new FileReader(statsFile));

                String[] allAttributes = br.readLine().trim().split(", ");
                String[] allStats = br.readLine().trim().split(", ");
                for (int i = 0; i < allAttributes.length; i++){
                    statsMap.put(allAttributes[i], Integer.valueOf(allStats[i]));
                }
            } catch (FileNotFoundException e)  {
                presenter.error("File not found.");
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return statsMap;
    }

    public String checkError(){
        /* returns a string representing the error
         * null - no error
         * exist - file does not exist
         * invalid - the attributes and stats are not in the correct format
         * other - any other error
         */
        File statsFile = new File(filename);
        // checking the file exists
        if (!fileExists()){
            return "exist";
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(statsFile));
            Path path = Paths.get(filename);
            long numLines = Files.lines(path).count();

            if (numLines != 2){return "invalid";}

            String[] attributes;
            if ((attributes = read(br, "attributes")).length == 0){return "invalid";}
            String[] stats;
            if ((stats = read(br, "stats")).length == 0){return "invalid";}
            br.close();

            //checking that all stats are type integer
            for (String stat : stats) {
                try { Integer.parseInt(stat.trim());
                } catch(NumberFormatException e) { return "invalid";}
            }
            //checking that there is a stat value for every stat
            if (attributes.length != stats.length ||
                    attributes.length != new StatsUser().getUserStats().size() ||
                    stats.length != new StatsUser().getUserStats().size()) {
                return "invalid";
            } else {return null;}
        } catch (IOException e)  {
            return "other";
        }
    }

    @Override
    public boolean fileExists(){
        File file = new File(filename);
        return (file.exists() && !file.isDirectory());
    }

    public boolean isPlayable(){
        return (checkError() == null);
    }


    @Override
    // returns a boolean for if the stats file exists and is valid
    public boolean isValid() {
        String result = checkError();
        switch(result){
            case "exist":
                presenter.error("There is no existing " + filename + " file.");
                break;
            case "invalid":
                presenter.error("Invalid " + filename + " file.");
                break;
            case "other":
                presenter.error("Error: please start a new game.");
            case "null":
                return true;

        }
        return false;

//        // checking the file exists
//        if (!fileExists()){
//            presenter.error("There is no existing " + filename + " file.");
//            return false;
//        }
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(statsFile));
//
//            String[] attributes;
//            if ((attributes = read(br, "attributes")).length == 0){return false;}
//
//            String[] stats;
//            if ((stats = read(br, "stats")).length == 0){return false;}
//
//            //checking that all stats are type integer
//            for (String stat : stats) {
//                try {
//                    Integer.parseInt(stat.trim());
//                } catch(NumberFormatException e) {
//                    presenter.error("Invalid stats in " + filename + " file.");
//                    return false;
//                }
//            }
//            //checking that there is a stat value for every stat
//
//            if (attributes.length != stats.length ||
//                    attributes.length != new StatsUser().getUserStats().size() ||
//                    stats.length != new StatsUser().getUserStats().size()) {
//                presenter.error("Invalid " + filename + " file.");
//                return false;
//            } else {return true;}
//
//        } catch (FileNotFoundException e)  {
//            presenter.error("File not found.");
//            throw new RuntimeException(e);
//        }
    }
}

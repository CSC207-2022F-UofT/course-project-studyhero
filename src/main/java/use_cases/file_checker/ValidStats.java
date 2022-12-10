package use_cases.file_checker;

import use_cases.errors.ErrorOutputBoundary;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ValidStats implements ValidFileDsGateway{
    private final String filename;
    private final File file;
    private final ErrorOutputBoundary presenter;

    /**
     * Creates a ValidStats object that can check for whether the file
     * with filename is a valid stats file that can be read, and if so,
     * can load the file.
     *
     * @param filename      filename of file to check
     * @param presenter     output boundary for displaying errors
     */
    public ValidStats(String filename,ErrorOutputBoundary presenter){
        this.filename = filename;
        this.file = new File(filename);
        this.presenter = presenter;
    }

    /**
     * Helper function that reads the next line of a buffered
     * reader and returns a string array representation of it.
     *
     * @param br    buffered reader
     * @param str   next line's attribute name
     * @return String array form of the next line of the buffered
     * reader. If there is no line, display the error.
     */
    private String[] read(BufferedReader br, String str){
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

    /**
     * @return A Map with String keys and integer values representing
     * the stats stored in the file with filename.
     */
    public Map<String, Integer> load(){
        Map<String, Integer> statsMap = new HashMap<>();
        if (isPlayable()){
            File statsFile = new File(filename);
            try {
                BufferedReader br = new BufferedReader(new FileReader(statsFile));

                String[] allAttributes = br.readLine().trim().split(", ");
                String[] allStats = br.readLine().trim().split(", ");
                br.close();
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

    /**
     * Helper function that checks all stats attributes
     * are of correct type and format. Returns the first of
     * error in the following list.
     *
     * @return
     * - null           if there is no error
     * - "exist"        if the file does not exist
     * - "numLines"     if there is more than one row of stats
     * - "attributes"   if the header is empty
     * - "stats"        if the stats are empty
     * - "invalid"      if the number of attributes and stats are
     *                  different
     * - "type"         if the stats are not of integer type
     * - "other"        if there is an IOException
     */
    public String checkError(){
        // checking the file exists
        if (!fileExists()){
            return "exist";
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Path path = Paths.get(filename);

            // only one row of values
            Stream<String> lines = Files.lines(path);
            long numLines = lines.count();
            if (numLines != 2){return "numLines";}

            // read first line as attributes and check it is non-empty
            String[] attributes;
            if ((attributes = read(br, "attributes")).length == 1){return "attributes";}

            // read second line as stats and check it is non-empty
            String[] stats;
            if ((stats = read(br, "stats")).length == 1){return "stats";}
            br.close();

            // check a stat exists for every corresponding attribute and vice versa
            if ((attributes.length != stats.length)){
                return "invalid";}

            //checking that all stats are type integer
            for (String stat : stats) {
                try { Integer.parseInt(stat.trim());
                } catch(NumberFormatException e) { return "type";}
            }

            return null;
        } catch (IOException e)  {
            return "other";
        }
    }

    /**
     * @return true if the file with filename path exists and isn't a
     * directory, else false
     */
    @Override
    public boolean fileExists(){
        File file = new File(filename);
        return (file.exists() && !file.isDirectory());
    }

    /**
     * @return true if checkError returns a null value, ie the stat file
     * in memory is valid and readable
     */
    @Override
    public boolean isPlayable(){
        return (checkError() == null);
    }

    /**
     * @return true if it is playable, else false along with a
     * window (JFrame) displaying the error.
     */
    @Override
    public boolean isValid() {
        String result = checkError();
        if (result == null){return true;}
        switch(result){
            case "exist":
                presenter.error("There is no existing " + filename + " file.");
                return false;
            case "invalid":
            case "numLines":
            case "attributes":
            case "stats":
            case "type":
                presenter.error("Invalid " + filename + " file.");
                return false;
            case "other":
                presenter.error("Error: please start a new game.");
                return false;
        }
        return false;
    }
}

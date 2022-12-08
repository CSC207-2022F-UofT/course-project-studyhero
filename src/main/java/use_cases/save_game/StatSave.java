package use_cases.save_stats;

import use_cases.errors.ErrorOutputBoundary;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class StatSave {
    private final Map<String, Integer> stats;
    private final ErrorOutputBoundary presenter;

    /**
     * Returns a StatsSave object with stats represented as a
     * Hashmap
     *
     * @param stats
     * @param presenter
     */
    public StatSave(Map<String, Integer> stats, ErrorOutputBoundary presenter){

        this.stats = stats;
        this.presenter = presenter;
    }

    /**
     * Returns nothing but saves a csv file representing the
     * current user's stats data
     */
    public void save(String filepath){
        try{
            File statsFile = new File("stats.csv");
            PrintWriter out = new PrintWriter(statsFile);

            StringBuilder keyString = new StringBuilder();
            StringBuilder attString = new StringBuilder();
            for (String att: stats.keySet()){
                keyString.append(", ").append(att);
                attString.append(", ").append(stats.get(att));
            }
            out.println(keyString.substring(2));
            out.println(attString.substring(2));

            out.close();

            System.out.println("Saved. Stats: " + stats);

        } catch (IOException e){
            presenter.error(e.toString());
        }
    }
}

package use_cases.save_game;

import use_cases.errors.ErrorPresenter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class StatSave implements SaveGameOutputBoundary{
    Map<String, Integer> stats;
    ErrorPresenter presenter;
    public StatSave(Map<String, Integer> stats, ErrorPresenter presenter){

        this.stats = stats;
        this.presenter = presenter;
    }

    @Override
    public void save(){
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

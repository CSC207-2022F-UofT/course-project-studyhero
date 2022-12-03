package use_cases.save_game;

import use_cases.errors.ErrorPresenter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

            ArrayList<String> key = new ArrayList<>(stats.keySet());

            String att0 = key.get(0), att1 = key.get(1),
                    att2 = key.get(2), att3 = key.get(3),
                    att4 = key.get(4);

            out.printf("%s, %s, %s, %s, %s \n", att0, att1, att2, att3, att4);
            out.printf("%d, %d, %d, %d, %d \n",
                    stats.get(att0), stats.get(att1), stats.get(att2),
                    stats.get(att3), stats.get(att4));

            out.close();

            System.out.println(stats);
            System.out.println("Saved.");

        } catch (IOException e){
            presenter.error(e.toString());
        }
    }
}

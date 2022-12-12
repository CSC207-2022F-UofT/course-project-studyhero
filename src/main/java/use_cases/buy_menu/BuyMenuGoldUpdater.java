package use_cases.buy_menu;

import entities.StatsUser;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.file_checker.ValidStats;
import use_cases.save_game.StatSave;
import java.util.Map;

public class BuyMenuGoldUpdater {
    ValidStats stats;
    Map<String, Integer> statsMap;
    StatSave statSave;
    StatsUser statsUser;
    ErrorOutputBoundary presenter;


    /**
     * The BuyMenuGoldUpdater interactor used in BuyMenuScreen use case in order to get and set the user's gold amount
     * from 'stats.csv'.
     */
    public BuyMenuGoldUpdater() {
        stats = new ValidStats("stats.csv", presenter);
        statsMap = stats.load();
        statSave = new StatSave(statsMap, presenter);
        statsUser = new StatsUser(statsMap);
    }

    /**
     * Updates the gold when an item is purchased by reducing it from the current statsUser file and saving it
     * as a new statsMap and statsUser.
     *
     * @param price         An integer that represents the price for an item.
     */
    public void updateGoldFromPurchase(int price) {
        statsUser.updateGold(-price);
        System.out.println(statsUser.updateGold(-price));
        StatSave newStats = new StatSave(statsUser.getUserStats(), presenter);
        newStats.save("stats.csv");

        statsMap = stats.load();
        statSave = new StatSave(statsMap, presenter);
        statsUser = new StatsUser(statsMap);
    }


    /**
     * Returns the user's gold value from the saved statsMap.
     *
     * @return the integer of the user's gold stat.
     */
    public int getUserGold() {
        return statsMap.get("gold");
    }

}

package newGame;

import InventoryMenu.InventoryItem.InventoryList;
import entities.StatsUser;

public class newGameInteractor {
    public static void createNewGame(){

        StatsUser stats = new StatsUser();
        System.out.println(stats.getUserStats());

        InventoryList inventList = new InventoryList("Inventory");
        System.out.println(inventList);


        System.out.println("New User created.");
    }
}

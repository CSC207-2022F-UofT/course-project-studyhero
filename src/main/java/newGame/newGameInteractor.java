package newGame;

import entities.StatsUser;
import inventorymenu.inventoryitem.InventoryListFile;

public class newGameInteractor {
    public static void createNewGame(){

        StatsUser stats = new StatsUser();
        System.out.println(stats.getUserStats());

        InventoryListFile inventList = new InventoryListFile("Inventory");
        System.out.println(inventList);


        System.out.println("New User created.");
    }
}

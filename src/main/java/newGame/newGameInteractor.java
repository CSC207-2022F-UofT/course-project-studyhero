package newGame;

import entities.StatsUser;
import inventorymenu.inventoryitem.InventoryList;

public class newGameInteractor {
    public static void createNewGame(){

        StatsUser stats = new StatsUser();
        System.out.println(stats.getUserStats());

        InventoryList inventList = new InventoryList("Inventory");
        System.out.println(inventList);


        System.out.println("New User created.");
    }
}

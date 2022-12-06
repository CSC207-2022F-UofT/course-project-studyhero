package newGame;

import entities.StatsUser;
import inventory_menu.inventoryitem.InventoryList;
import inventory_menu.inventoryitem.PlayerInventoryFile;

public class newGameInteractor {
    public static void createNewGame(){

        StatsUser stats = new StatsUser();
        System.out.println(stats.getUserStats());

        InventoryList inventList = new PlayerInventoryFile("Inventory");
        System.out.println(inventList);


        System.out.println("New User created.");
    }
}

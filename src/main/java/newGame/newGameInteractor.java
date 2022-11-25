package newGame;

import InventoryMenu.InventoryItem.InventoryList;
import entities.StatsUser;
import entities.user;

public class newGameInteractor {
    public static void createNewGame(){

        StatsUser newUser = new StatsUser();

        user.setUser(newUser);
        System.out.println(user.getUser().getUserStats());

        InventoryList inventList = new InventoryList("Inventory");
        System.out.println(inventList);


        System.out.println("New User created.");
    }
}

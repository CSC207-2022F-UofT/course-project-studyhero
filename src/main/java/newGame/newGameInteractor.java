package newGame;

import inventory_menu.inventory_item.InventoryList;
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

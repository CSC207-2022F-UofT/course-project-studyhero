package tutorial;

import InventoryMenu.InventoryItem.InventoryItemDsRequestModel;
import InventoryMenu.InventoryItem.InventoryList;
import InventoryMenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import InventoryMenu.InventoryItem.Weapon;

import java.io.IOException;

public class HelloWorld {

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 100; i++) {
            System.out.println(convert(i));
        }

        Weapon sword = new Weapon("Sword", 13);
        Weapon sword1 = new Weapon("Sword", 13);
        InventoryList file = new InventoryList("./PlayerInventory.csv");
        PlayerDisplayInventoryDsRequestModel iterator = file.createIterator();
        file.save(sword);
        file.save(sword1);

        while(iterator.hasNext()){
            InventoryItemDsRequestModel item = iterator.getNext();
            System.out.println("Id: " + item.getId() + ", Type: " + item.getType() +
                    ", Name: " + item.getName() +
                    ", Effect: " + item.getEffect());
        }
    }

    public static String convert(int decide) {
        if (decide % 15 == 0) {
            return "tutorial.HelloWorld";
        }
        if (decide % 3 == 0) {
            return "Hello";
        }
        if (decide % 5 == 0) {
            return "World";
        }
        return String.valueOf(decide);
    }
}

package tutorial;

import inventorymenu.inventoryitem.InventoryItemDsRequestModel;
import inventorymenu.inventoryitem.InventoryList;
import inventorymenu.inventoryitem.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import inventorymenu.inventoryitem.Weapon;

import java.io.IOException;

public class HelloWorld {

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 100; i++) {
            System.out.println(convert(i));
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

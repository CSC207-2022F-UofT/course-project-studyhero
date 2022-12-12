package shopmenu;


import entities.inventoryitem.InventoryItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import use_cases.buy_menu.BuyMenuShopInvInitializer;
import use_cases.errors.ErrorOutputBoundary;
import use_cases.errors.ErrorPresenter;
import use_cases.save_game.StatSave;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class BuyMenuTest {

    static Map<String, Integer> noGoldStatsMap, withGoldStatsMap;
    static ArrayList<InventoryItem> emptyInventoryList, fullInventoryList, shopInventory;
    static BuyMenuShopInvInitializer buyMenuShopInvInitializer = new BuyMenuShopInvInitializer();
    ErrorOutputBoundary presenter = new ErrorPresenter();

    String filepath = "BuyMenuStatsTest.csv";
    private static Map<String, Integer> generateMap(String[] header,
                                                    String[] stats){
        Map<String, Integer> statsMap = new HashMap<>();
        int i = 0;
        while (i < header.length){
            statsMap.put(header[i], Integer.valueOf(stats[i]));
            i++;
        }
        return statsMap;
    }

    @BeforeEach
    public static void setup() {
        // Set up Shop Inventory
        shopInventory = buyMenuShopInvInitializer.getShopInventory();

        // Empty player inventory
        fullInventoryList = new ArrayList<>();

        // Full player inventory
        fullInventoryList = new ArrayList<>();
        InventoryItem item = new InventoryItem(1, "Weapon", "Sword",
                18, 10, false);
        fullInventoryList.add(item);
        fullInventoryList.add(item);
        fullInventoryList.add(item);
        fullInventoryList.add(item);
        fullInventoryList.add(item); // 5
        fullInventoryList.add(item);
        fullInventoryList.add(item);
        fullInventoryList.add(item);
        fullInventoryList.add(item);
        fullInventoryList.add(item); // 10
        fullInventoryList.add(item);
        fullInventoryList.add(item);
        fullInventoryList.add(item);
        fullInventoryList.add(item);
        fullInventoryList.add(item); // 15
        fullInventoryList.add(item);
        fullInventoryList.add(item);
        fullInventoryList.add(item);
        fullInventoryList.add(item);
        fullInventoryList.add(item); // 20


        // Stats with gold
        String[] withGoldStatsHeader = {"gold", "damage", "level", "defence", "hp"};
        String[] withGoldStatsStats = {"50", "5", "1", "0", "100"};
        withGoldStatsMap = generateMap(withGoldStatsHeader, withGoldStatsStats);

        // Stats with no gold
        String[] noGoldStatsHeader = {"gold", "damage", "level", "defence", "hp"};
        String[] noGoldStatsStats = {"0", "5", "1", "0", "100"};
        noGoldStatsMap = generateMap(noGoldStatsHeader, noGoldStatsStats);
    }

    @AfterEach
    public void testSaved() {
    }

    @Test
    void checkShopInventory() {

    }

    @Test
    void checkItemInListDisplay() {

    }

    @Test
    void buyItemErrorFullInventory() {
        StatSave withGold = new StatSave(withGoldStatsMap, presenter);
        withGold.save(filepath);

        File stats = new File(filepath);
        stats.deleteOnExit();
    }

    @Test
    void buyItemErrorNoGold() {
        StatSave noGold = new StatSave(noGoldStatsMap, presenter);
        noGold.save(filepath);



        File stats = new File(filepath);
        stats.deleteOnExit();
    }

    @Test
    void buyItemButtonSuccess() {

    }



    // Test 0: Check shop inventory
    // Test 1: Check 1 item in a list (readInventoryList)
    // Test 2: BuyItemButton - Check for full inventory
    // Test 3: BuyItemButton - Check for bad number of gold.
    // Test 4: BuyItemButton - Check if item is bought.
        // Check gold, and item in user's inventory.
}

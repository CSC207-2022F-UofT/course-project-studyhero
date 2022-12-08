package inventorymenu.inventoryitem;

import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


class PlayerInventoryFileTest {
    String filePath = "PlayerInventoryTest.csv";
    InventoryList inventoryListFile = new PlayerInventoryFile(filePath);
    ArrayList<InventoryItemDsRequestModel> referenceList = new ArrayList<>();
    InventoryItemDsRequestModel item1 = new InventoryItemDsRequestModel(1,
            "Weapon",
            "Sword",
            13, 10, true);
    InventoryItemDsRequestModel item2 = new InventoryItemDsRequestModel(2,
            "AttackPotion",
            "StrengthPotion",
            5, 23, false);
    InventoryItemDsRequestModel item3 = new InventoryItemDsRequestModel(3,
            "Weapon",
            "HammerHammer",
            18, 43, false);
    InventoryItemDsRequestModel item4 = new InventoryItemDsRequestModel(4,
            "Shield",
            "BronzeShield",
            15, 20, false);


    @BeforeEach
    void setUp(){
        inventoryListFile.initialize();
        referenceList.add(item1);
        referenceList.add(item2);
        referenceList.add(item3);
        referenceList.add(item4);
    }

    @Test
    void readInventoryList() {
        inventoryListFile.readInventoryList();
        PlayerDisplayInventoryDsRequestModel iterator = inventoryListFile.getInventoryListIterator();
        ArrayList<InventoryItemDsRequestModel> inventoryList = new ArrayList<>();
        while(iterator.hasNext()){
            inventoryList.add(iterator.getNext());
        }
        for(int i = 0; i < 4; i++){
            assertEquals(referenceList.get(i).getId(), inventoryList.get(i).getId());
            assertEquals(referenceList.get(i).getName(), inventoryList.get(i).getName());
            assertEquals(referenceList.get(i).getType(), inventoryList.get(i).getType());
            assertEquals(referenceList.get(i).getEffect(), inventoryList.get(i).getEffect());
            assertEquals(referenceList.get(i).getGoldValue(), inventoryList.get(i).getGoldValue());
            assertEquals(referenceList.get(i).checkIsEquipped(), inventoryList.get(i).checkIsEquipped());
        }
    }

    @Test
    void saveItem() {
        InventoryItem newItem = new InventoryItem("Shield", "UltraShield", 99, 999, true);
        inventoryListFile.save(newItem);
        inventoryListFile.readInventoryList();
        PlayerDisplayInventoryDsRequestModel iterator = inventoryListFile.getInventoryListIterator();
        ArrayList<InventoryItemDsRequestModel> inventoryList = new ArrayList<>();
        while(iterator.hasNext()){
            inventoryList.add(iterator.getNext());
        }
        assertEquals(5, inventoryList.get(4).getId());
        assertEquals("UltraShield", inventoryList.get(4).getName());
        assertEquals("Shield", inventoryList.get(4).getType());
        assertEquals(99, inventoryList.get(4).getEffect());
        assertEquals(999, inventoryList.get(4).getGoldValue());
        assertEquals(true, inventoryList.get(4).checkIsEquipped());
    }

    @Test
    void attachId() {
        InventoryItem newItem = new InventoryItem("Shield", "UltraShield", 99, 999, true);
        inventoryListFile.save(newItem);
        inventoryListFile.readInventoryList();
        PlayerDisplayInventoryDsRequestModel iterator = inventoryListFile.getInventoryListIterator();
        ArrayList<InventoryItemDsRequestModel> inventoryList = new ArrayList<>();
        while(iterator.hasNext()){
            inventoryList.add(iterator.getNext());
        }
        assertEquals(5, inventoryList.get(4).getId());
    }

    @Test
    void checkLatestInventoryItemId() {
        assertEquals(4, inventoryListFile.CheckLatestInventoryItemId());
    }

    @Test
    void inventoryFull() {
        InventoryItem newItem = new InventoryItem("Shield", "UltraShield", 99, 999, true);

        for(int i = 0; i < 15; i++){
            inventoryListFile.save(newItem);
        }
        assertFalse(inventoryListFile.inventoryFull());
        inventoryListFile.save(newItem);
        assertTrue(inventoryListFile.inventoryFull());
        inventoryListFile.save(newItem);
        assertTrue(inventoryListFile.inventoryFull());
    }

    @Test
    void getInventoryListIterator() {
        assertTrue(inventoryListFile.getInventoryListIterator() instanceof PlayerDisplayInventoryDsRequestModel);
    }

    @Test
    void updateInventoryList() {
        inventoryListFile.deleteItem(1);
        inventoryListFile.readInventoryList();
        PlayerDisplayInventoryDsRequestModel iterator = inventoryListFile.getInventoryListIterator();
        ArrayList<InventoryItemDsRequestModel> inventoryList = new ArrayList<>();
        while(iterator.hasNext()){
            inventoryList.add(iterator.getNext());
        }
        for(int i = 1; i < 4; i++){
            assertEquals(referenceList.get(i).getId() - 1, inventoryList.get(i - 1).getId());
            assertEquals(referenceList.get(i).getName(), inventoryList.get(i - 1).getName());
            assertEquals(referenceList.get(i).getType(), inventoryList.get(i - 1).getType());
            assertEquals(referenceList.get(i).getEffect(), inventoryList.get(i - 1).getEffect());
            assertEquals(referenceList.get(i).getGoldValue(), inventoryList.get(i - 1).getGoldValue());
            assertEquals(referenceList.get(i).checkIsEquipped(), inventoryList.get(i - 1).checkIsEquipped());
        }
    }

    @Test
    void itemExist() {
        assertFalse(inventoryListFile.itemExist(5));
        assertTrue(inventoryListFile.itemExist(4));
        assertFalse(inventoryListFile.itemExist(0));
        assertTrue(inventoryListFile.itemExist(1));
        assertFalse(inventoryListFile.itemExist(21));
    }

    @Test
    void deleteItem() {
        inventoryListFile.deleteItem(1);

        PlayerDisplayInventoryDsRequestModel iterator = inventoryListFile.getInventoryListIterator();
        ArrayList<InventoryItemDsRequestModel> inventoryList = new ArrayList<>();
        while(iterator.hasNext()){
            inventoryList.add(iterator.getNext());
        }
        for(int i = 1; i < 4; i++){
            assertEquals(referenceList.get(i).getId() - 1, inventoryList.get(i - 1).getId());
            assertEquals(referenceList.get(i).getName(), inventoryList.get(i - 1).getName());
            assertEquals(referenceList.get(i).getType(), inventoryList.get(i - 1).getType());
            assertEquals(referenceList.get(i).getEffect(), inventoryList.get(i - 1).getEffect());
            assertEquals(referenceList.get(i).getGoldValue(), inventoryList.get(i - 1).getGoldValue());
            assertEquals(referenceList.get(i).checkIsEquipped(), inventoryList.get(i - 1).checkIsEquipped());
        }
    }

    @Test
    void getName() {
        for(int i = 1; i < 5; i++){
            assertEquals(referenceList.get(i-1).getName(), inventoryListFile.getName(i).getName());
        }

    }

    @Test
    void clearInventory() {
        inventoryListFile.clearInventory();
        PlayerDisplayInventoryDsRequestModel iterator = inventoryListFile.getInventoryListIterator();
        ArrayList<InventoryItemDsRequestModel> inventoryList = new ArrayList<>();
        while(iterator.hasNext()){
            inventoryList.add(iterator.getNext());
        }
        assertTrue(inventoryList.size() == 0);
    }

    @Test
    void initialize() {
        inventoryListFile.readInventoryList();
        PlayerDisplayInventoryDsRequestModel iterator = inventoryListFile.getInventoryListIterator();
        ArrayList<InventoryItemDsRequestModel> inventoryList = new ArrayList<>();
        while(iterator.hasNext()){
            inventoryList.add(iterator.getNext());
        }
        for(int i = 0; i < 4; i++){
            assertEquals(referenceList.get(i).getId(), inventoryList.get(i).getId());
            assertEquals(referenceList.get(i).getName(), inventoryList.get(i).getName());
            assertEquals(referenceList.get(i).getType(), inventoryList.get(i).getType());
            assertEquals(referenceList.get(i).getEffect(), inventoryList.get(i).getEffect());
            assertEquals(referenceList.get(i).getGoldValue(), inventoryList.get(i).getGoldValue());
            assertEquals(referenceList.get(i).checkIsEquipped(), inventoryList.get(i).checkIsEquipped());
        }
    }
}
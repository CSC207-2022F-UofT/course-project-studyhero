package inventorymenu.inventoryitem;

import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


class InventoryListTest {
    String filePath = "PlayerInventoryTest.csv";
    InventoryList inventoryListFile = new InventoryList(filePath);
    ArrayList<InventoryItemDsRequestModel> referenceList = new ArrayList<>();
    InventoryItemDsRequestModel item1 = new InventoryItemDsRequestModel(1,
            "Weapon",
            "Sword",
            13);
    InventoryItemDsRequestModel item2 = new InventoryItemDsRequestModel(2,
            "AttackPotion",
            "StrengthPotion",
            5);
    InventoryItemDsRequestModel item3 = new InventoryItemDsRequestModel(3,
            "Weapon",
            "HammerHammer",
            18);
    InventoryItemDsRequestModel item4 = new InventoryItemDsRequestModel(4,
            "Shield",
            "BronzeShield",
            15);


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
        ArrayList<InventoryItemDsRequestModel> inventoryList = inventoryListFile.getInventoryList();
        for(int i = 0; i < 4; i++){
            assertEquals(referenceList.get(i).getId(), inventoryList.get(i).getId());
            assertEquals(referenceList.get(i).getName(), inventoryList.get(i).getName());
            assertEquals(referenceList.get(i).getType(), inventoryList.get(i).getType());
            assertEquals(referenceList.get(i).getEffect(), inventoryList.get(i).getEffect());
        }
    }

    @Test
    void saveItem() {
        InventoryItem newItem = new InventoryItem("Shield", "UltraShield", 99);
        inventoryListFile.save(newItem);
        inventoryListFile.readInventoryList();
        ArrayList<InventoryItemDsRequestModel> inventoryList = inventoryListFile.getInventoryList();
        assertEquals(5, inventoryList.get(4).getId());
        assertEquals("UltraShield", inventoryList.get(4).getName());
        assertEquals("Shield", inventoryList.get(4).getType());
        assertEquals(99, inventoryList.get(4).getEffect());
    }

    @Test
    void attachId() {
        InventoryItem newItem = new InventoryItem("Shield", "UltraShield", 99);
        inventoryListFile.save(newItem);
        inventoryListFile.readInventoryList();
        ArrayList<InventoryItemDsRequestModel> inventoryList = inventoryListFile.getInventoryList();
        assertEquals(5, inventoryList.get(4).getId());
    }

    @Test
    void checkLatestInventoryItemId() {
        assertEquals(4, inventoryListFile.CheckLatestInventoryItemId());
    }

    @Test
    void inventoryFull() {
        InventoryItem newItem = new InventoryItem("Shield", "UltraShield", 99);

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
        inventoryListFile.updateInventoryList();
        ArrayList<InventoryItemDsRequestModel> inventoryList = inventoryListFile.getInventoryList();
        for(int i = 1; i < 4; i++){
            assertEquals(referenceList.get(i).getId() - 1, inventoryList.get(i - 1).getId());
            assertEquals(referenceList.get(i).getName(), inventoryList.get(i - 1).getName());
            assertEquals(referenceList.get(i).getType(), inventoryList.get(i - 1).getType());
            assertEquals(referenceList.get(i).getEffect(), inventoryList.get(i - 1).getEffect());
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
        ArrayList<InventoryItemDsRequestModel> inventoryList = inventoryListFile.getInventoryList();
        for(int i = 1; i < 4; i++){
            assertEquals(referenceList.get(i).getId() - 1, inventoryList.get(i - 1).getId());
            assertEquals(referenceList.get(i).getName(), inventoryList.get(i - 1).getName());
            assertEquals(referenceList.get(i).getType(), inventoryList.get(i - 1).getType());
            assertEquals(referenceList.get(i).getEffect(), inventoryList.get(i - 1).getEffect());
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
        assertTrue(inventoryListFile.getInventoryList().size() == 0);
    }

    @Test
    void initialize() {
        inventoryListFile.readInventoryList();
        ArrayList<InventoryItemDsRequestModel> inventoryList = inventoryListFile.getInventoryList();
        for(int i = 0; i < 4; i++){
            assertEquals(referenceList.get(i).getId(), inventoryList.get(i).getId());
            assertEquals(referenceList.get(i).getName(), inventoryList.get(i).getName());
            assertEquals(referenceList.get(i).getType(), inventoryList.get(i).getType());
            assertEquals(referenceList.get(i).getEffect(), inventoryList.get(i).getEffect());
        }
    }
}
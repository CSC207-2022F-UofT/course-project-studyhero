package inventory_menu.inventory_menu_use_case.display_player_inventory_use_case;

import inventory_menu.inventory_item.InventoryItemDsRequestModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDisplayInventoryDsRequestModelTest {


    ArrayList<InventoryItemDsRequestModel> inventoryList = new ArrayList<>();

    @BeforeEach
    public void setInventoryList(){
        InventoryItemDsRequestModel item1 = new InventoryItemDsRequestModel(1,
                "Weapon",
                "Sword",
                13, 10);
        InventoryItemDsRequestModel item2 = new InventoryItemDsRequestModel(2,
                "AttackPotion",
                "StrengthPotion",
                5, 23);
        InventoryItemDsRequestModel item3 = new InventoryItemDsRequestModel(3,
                "Weapon",
                "HammerHammer",
                18, 43);
        InventoryItemDsRequestModel item4 = new InventoryItemDsRequestModel(4,
                "Shield",
                "BronzeShield",
                15, 20);

        inventoryList.add(item1);
        inventoryList.add(item2);
        inventoryList.add(item3);
        inventoryList.add(item4);
    }


    /**
     * Check for the case while the current position = 0
     */
    @Test
    void getNextCurrentPositionZero () {
        InventoryItemDsRequestModel item = new InventoryItemDsRequestModel(1,"Weapon","Sword",13, 10);

        PlayerDisplayInventoryDsRequestModel referenceModel = new PlayerDisplayInventoryDsRequestModel(inventoryList);
        InventoryItemDsRequestModel referenceItem = referenceModel.getNext();

        assertEquals(item.getId(), referenceItem.getId());
        assertEquals(item.getName(), referenceItem.getName());
        assertEquals(item.getEffect(), referenceItem.getEffect());
        assertEquals(item.getType(), referenceItem.getType());
    }

    /**
     * Check for the case while the current position = 1
     */
    @Test
    void getNextCurrentPositionOne () {
        InventoryItemDsRequestModel item = new InventoryItemDsRequestModel(2,
                "AttackPotion",
                "StrengthPotion",
                5, 23);
        PlayerDisplayInventoryDsRequestModel referenceModel = new PlayerDisplayInventoryDsRequestModel(inventoryList);
        referenceModel.getNext();
        InventoryItemDsRequestModel referenceItem = referenceModel.getNext();

        assertEquals(item.getId(), referenceItem.getId());
        assertEquals(item.getName(), referenceItem.getName());
        assertEquals(item.getEffect(), referenceItem.getEffect());
        assertEquals(item.getType(), referenceItem.getType());
    }

    /**
     * Check for the case while the current position = 1
     */
    @Test
    void getNextCurrentPositionLast () {
        InventoryItemDsRequestModel item = new InventoryItemDsRequestModel(4,
                "Shield",
                "BronzeShield",
                15, 20);
        PlayerDisplayInventoryDsRequestModel referenceModel = new PlayerDisplayInventoryDsRequestModel(inventoryList);
        referenceModel.getNext();
        referenceModel.getNext();
        referenceModel.getNext();
        InventoryItemDsRequestModel referenceItem = referenceModel.getNext();

        assertEquals(item.getId(), referenceItem.getId());
        assertEquals(item.getName(), referenceItem.getName());
        assertEquals(item.getEffect(), referenceItem.getEffect());
        assertEquals(item.getType(), referenceItem.getType());
        assertEquals(item.getGoldValue(), referenceItem.getGoldValue());
    }

    @Test
    void hasNextPositionFirst() {
        PlayerDisplayInventoryDsRequestModel referenceModel = new PlayerDisplayInventoryDsRequestModel(inventoryList);
        assertTrue(referenceModel.hasNext());
    }

    @Test
    void hasNextPositionMiddle() {
        PlayerDisplayInventoryDsRequestModel referenceModel = new PlayerDisplayInventoryDsRequestModel(inventoryList);
        referenceModel.getNext();
        assertTrue(referenceModel.hasNext());
    }

    @Test
    void hasNextPositionLast() {
        PlayerDisplayInventoryDsRequestModel referenceModel = new PlayerDisplayInventoryDsRequestModel(inventoryList);
        referenceModel.getNext();
        referenceModel.getNext();
        referenceModel.getNext();
        referenceModel.getNext();
        assertTrue(!referenceModel.hasNext());
    }

}


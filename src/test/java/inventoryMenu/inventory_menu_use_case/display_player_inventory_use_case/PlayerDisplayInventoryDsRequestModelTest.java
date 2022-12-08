package inventoryMenu.inventory_menu_use_case.display_player_inventory_use_case;

import entities.inventoryitem.InventoryItemDsRequestModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDisplayInventoryDsRequestModelTest {


    ArrayList<InventoryItemDsRequestModel> inventoryList = new ArrayList<>();

    @BeforeEach
    public void setInventoryList(){
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
        InventoryItemDsRequestModel item = new InventoryItemDsRequestModel(1,"Weapon","Sword",13, 10, true);

        PlayerDisplayInventoryDsRequestModel referenceModel = new PlayerDisplayInventoryDsRequestModel(inventoryList);
        InventoryItemDsRequestModel referenceItem = referenceModel.getNext();

        assertEquals(item.getId(), referenceItem.getId());
        assertEquals(item.getName(), referenceItem.getName());
        assertEquals(item.getEffect(), referenceItem.getEffect());
        assertEquals(item.getType(), referenceItem.getType());
        assertEquals(item.getGoldValue(), referenceItem.getGoldValue());
        assertEquals(item.checkIsEquipped(), referenceItem.checkIsEquipped());
    }

    /**
     * Check for the case while the current position = 1
     */
    @Test
    void getNextCurrentPositionOne () {
        InventoryItemDsRequestModel item = new InventoryItemDsRequestModel(2,
                "AttackPotion",
                "StrengthPotion",
                5, 23, false);
        PlayerDisplayInventoryDsRequestModel referenceModel = new PlayerDisplayInventoryDsRequestModel(inventoryList);
        referenceModel.getNext();
        InventoryItemDsRequestModel referenceItem = referenceModel.getNext();

        assertEquals(item.getId(), referenceItem.getId());
        assertEquals(item.getName(), referenceItem.getName());
        assertEquals(item.getEffect(), referenceItem.getEffect());
        assertEquals(item.getType(), referenceItem.getType());
        assertEquals(item.getGoldValue(), referenceItem.getGoldValue());
        assertEquals(item.checkIsEquipped(), referenceItem.checkIsEquipped());

    }

    /**
     * Check for the case while the current position = 1
     */
    @Test
    void getNextCurrentPositionLast () {
        InventoryItemDsRequestModel item = new InventoryItemDsRequestModel(4,
                "Shield",
                "BronzeShield",
                15, 20, false);
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
        assertEquals(item.checkIsEquipped(), referenceItem.checkIsEquipped());
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
        assertFalse(referenceModel.hasNext());
    }

}


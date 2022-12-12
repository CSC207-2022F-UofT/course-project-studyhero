package inventorymenu.display_player_inventory_use_case;

import inventorymenu.inventory_item.InventoryItemDsRequestModel;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsRequestModel;
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
        InventoryItemDsRequestModel item = new InventoryItemDsRequestModel(1,"Weapon","Sword",13);

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
                5);
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
                15);
        PlayerDisplayInventoryDsRequestModel referenceModel = new PlayerDisplayInventoryDsRequestModel(inventoryList);
        referenceModel.getNext();
        referenceModel.getNext();
        referenceModel.getNext();
        InventoryItemDsRequestModel referenceItem = referenceModel.getNext();

        assertEquals(item.getId(), referenceItem.getId());
        assertEquals(item.getName(), referenceItem.getName());
        assertEquals(item.getEffect(), referenceItem.getEffect());
        assertEquals(item.getType(), referenceItem.getType());
    }

    @Test
    void hasNext() {
    }
}


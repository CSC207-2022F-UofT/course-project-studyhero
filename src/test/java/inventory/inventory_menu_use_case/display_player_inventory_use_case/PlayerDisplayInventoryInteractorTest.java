package inventory.inventory_menu_use_case.display_player_inventory_use_case;

import inventory.entities.InventoryItem;
import inventory.inventoryscreens.FakeInventoryDisplay;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDisplayInventoryInteractorTest {


    ArrayList<InventoryItem> oldInventoryList = new ArrayList<>();
    ArrayList<InventoryItem> newInventoryList = new ArrayList<>();
    InventoryItem item1 = new InventoryItem(1,
            "Weapon",
            "Sword",
            13, 10, true);
    InventoryItem item2 = new InventoryItem(2,
            "AttackPotion",
            "StrengthPotion",
            5, 23, false);
    InventoryItem item3 = new InventoryItem(3,
            "Weapon",
            "Hammer",
            18, 43, false);
    InventoryItem item4 = new InventoryItem(4,
            "Shield",
            "BronzeShield",
            15, 20, false);

    @Test
    void displayInventoryListWithItem() {


        oldInventoryList.add(item1);
        oldInventoryList.add(item2);
        oldInventoryList.add(item3);
        oldInventoryList.add(item4);
        newInventoryList.add(item1);
        newInventoryList.add(item3);

        PlayerDisplayInventoryDsGateway playerRepo = new FakeInventoryDisplay(oldInventoryList,newInventoryList);

        PlayerDisplayInventoryOutputBoundary presenter = dsRequestModel -> {
            assertTrue(dsRequestModel.hasNext());

            InventoryItem referenceModel1 = dsRequestModel.getNext();
            assertEquals(item1.getType(),referenceModel1.getType());
            assertEquals(item1.getName(),referenceModel1.getName());
            assertEquals(item1.getId(),referenceModel1.getId());
            assertEquals(item1.getEffect(),referenceModel1.getEffect());
            assertEquals(item1.getGoldValue(),referenceModel1.getGoldValue());
            assertEquals(item1.checkIsEquipped(), referenceModel1.checkIsEquipped());

            assertTrue(dsRequestModel.hasNext());

            InventoryItem referenceModel2 = dsRequestModel.getNext();
            assertEquals(item3.getType(),referenceModel2.getType());
            assertEquals(item3.getName(),referenceModel2.getName());
            assertEquals(item3.getId(),referenceModel2.getId());
            assertEquals(item3.getEffect(),referenceModel2.getEffect());
            assertEquals(item3.getGoldValue(),referenceModel2.getGoldValue());
            assertEquals(item3.checkIsEquipped(), referenceModel2.checkIsEquipped());

            assertFalse(dsRequestModel.hasNext());

            return null;
        };

        PlayerDisplayInventoryInputBoundary interactor = new PlayerDisplayInventoryInteractor(playerRepo, presenter);

        interactor.display();

    }

    @Test
    void displayInventoryListWithNoItemBefore() {

        newInventoryList.add(item1);
        newInventoryList.add(item3);

        PlayerDisplayInventoryDsGateway playerRepo = new FakeInventoryDisplay(oldInventoryList,newInventoryList);

        PlayerDisplayInventoryOutputBoundary presenter = dsRequestModel -> {
            assertTrue(dsRequestModel.hasNext());

            InventoryItem referenceModel1 = dsRequestModel.getNext();
            assertEquals(item1.getType(),referenceModel1.getType());
            assertEquals(item1.getName(),referenceModel1.getName());
            assertEquals(item1.getId(),referenceModel1.getId());
            assertEquals(item1.getEffect(),referenceModel1.getEffect());
            assertEquals(item1.getGoldValue(),referenceModel1.getGoldValue());
            assertEquals(item1.checkIsEquipped(), referenceModel1.checkIsEquipped());

            assertTrue(dsRequestModel.hasNext());

            InventoryItem referenceModel2 = dsRequestModel.getNext();
            assertEquals(item3.getType(),referenceModel2.getType());
            assertEquals(item3.getName(),referenceModel2.getName());
            assertEquals(item3.getId(),referenceModel2.getId());
            assertEquals(item3.getEffect(),referenceModel2.getEffect());
            assertEquals(item3.getGoldValue(),referenceModel2.getGoldValue());
            assertEquals(item3.checkIsEquipped(), referenceModel2.checkIsEquipped());


            assertFalse(dsRequestModel.hasNext());

            return null;
        };

        PlayerDisplayInventoryInputBoundary interactor = new PlayerDisplayInventoryInteractor(playerRepo, presenter);

        interactor.display();

    }

    @Test
    void displayInventoryListWithNoItemAfter() {

        oldInventoryList.add(item1);
        oldInventoryList.add(item2);
        oldInventoryList.add(item3);
        oldInventoryList.add(item4);

        PlayerDisplayInventoryDsGateway playerRepo = new FakeInventoryDisplay(oldInventoryList,newInventoryList);

        PlayerDisplayInventoryOutputBoundary presenter = dsRequestModel -> {
            assertFalse(dsRequestModel.hasNext());

            return null;
        };

        PlayerDisplayInventoryInputBoundary interactor = new PlayerDisplayInventoryInteractor(playerRepo, presenter);

        interactor.display();

    }

    @Test
    void displayInventoryListWithNoItemBeforeAndAfter() {

        PlayerDisplayInventoryDsGateway playerRepo = new FakeInventoryDisplay(oldInventoryList,newInventoryList);

        PlayerDisplayInventoryOutputBoundary presenter = dsRequestModel -> {
            assertFalse(dsRequestModel.hasNext());
            return null;
        };

        PlayerDisplayInventoryInputBoundary interactor = new PlayerDisplayInventoryInteractor(playerRepo, presenter);

        interactor.display();

    }
}
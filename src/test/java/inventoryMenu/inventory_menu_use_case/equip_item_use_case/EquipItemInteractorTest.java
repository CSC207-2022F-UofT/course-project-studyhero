package inventorymenu.inventory_menu_use_case.equip_item_use_case;

import UI.screens.inventoryscreens.FakeInventoryEquip;
import entities.inventoryitem.AttackPotion;
import entities.inventoryitem.InventoryItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.inventory_menu_use_case.equip_item_use_case.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EquipItemInteractorTest {
    ArrayList<InventoryItem> inventoryList = new ArrayList<>();

    @BeforeEach
    void setup(){

        InventoryItem item1 = new InventoryItem(1, "Shield", "BronzeShield",
                4, 10, false);
        InventoryItem item2 = new InventoryItem(2, "Weapon", "Sword",
                18, 10, true);
        InventoryItem item3 = new InventoryItem(3, "Weapon", "Hammer",
                15, 43, false);
        InventoryItem item4 = new AttackPotion("Strength Potion",
                3, 3);
        inventoryList.add(item1);
        inventoryList.add(item2);
        inventoryList.add(item3);
        inventoryList.add(item4);
    }

    @Test
    void equipItemSmallerThanInventorySize() {
        int id = 0;
        EquipItemDsGateway inventoryRepo = new FakeInventoryEquip(inventoryList);
        EquipItemOutputBoundary presenter = new EquipItemOutputBoundary(){
            @Override
            public EquipItemResponseModel prepareSuccessView(EquipItemResponseModel inputId) {
                fail("Use case success is unexpected");
                return null;
            }

            @Override
            public EquipItemResponseModel prepareFailView(String error) {
                return null;
            }
        };

        EquipItemInputBoundary interactor = new EquipItemInteractor(inventoryRepo, presenter);
        assertFalse(inventoryRepo.itemExist(id));
        EquipItemRequestModel inputData = new EquipItemRequestModel(id);
        interactor.equip(inputData);
    }

    @Test
    void equipFirstItem() {
        int id = 1;
        EquipItemDsGateway inventoryRepo = new FakeInventoryEquip(inventoryList);
        EquipItemOutputBoundary presenter = new EquipItemOutputBoundary(){
            @Override
            public EquipItemResponseModel prepareSuccessView(EquipItemResponseModel inputId) {
                return null;
            }

            @Override
            public EquipItemResponseModel prepareFailView(String error) {
                fail("Use case success is unexpected");
                return null;
            }
        };

        EquipItemInputBoundary interactor = new EquipItemInteractor(inventoryRepo, presenter);
        assertTrue(inventoryRepo.itemExist(id));
        EquipItemRequestModel inputData = new EquipItemRequestModel(id);
        interactor.equip(inputData);
        assertTrue(inventoryList.get(0).checkIsEquipped());
    }

    @Test
    void equipItemWithSameType() {
        int id = 3;
        EquipItemDsGateway inventoryRepo = new FakeInventoryEquip(inventoryList);
        EquipItemOutputBoundary presenter = new EquipItemOutputBoundary(){
            @Override
            public EquipItemResponseModel prepareSuccessView(EquipItemResponseModel inputId) {
                return null;
            }

            @Override
            public EquipItemResponseModel prepareFailView(String error) {
                fail("Use case success is unexpected");
                return null;
            }
        };

        EquipItemInputBoundary interactor = new EquipItemInteractor(inventoryRepo, presenter);
        assertTrue(inventoryRepo.itemExist(id));
        EquipItemRequestModel inputData = new EquipItemRequestModel(id);
        interactor.equip(inputData);
        assertTrue(inventoryList.get(id - 1).checkIsEquipped());
        assertFalse(inventoryList.get(1).checkIsEquipped());
    }

    @Test
    void equipItemWithoutEquipableKeyword() {
        int id = 4;
        EquipItemDsGateway inventoryRepo = new FakeInventoryEquip(inventoryList);
        EquipItemOutputBoundary presenter = new EquipItemOutputBoundary(){
            @Override
            public EquipItemResponseModel prepareSuccessView(EquipItemResponseModel inputId) {
                fail("Use case success is unexpected");
                return null;
            }

            @Override
            public EquipItemResponseModel prepareFailView(String error) {
                return null;
            }
        };

        EquipItemInputBoundary interactor = new EquipItemInteractor(inventoryRepo, presenter);
        assertTrue(inventoryRepo.itemExist(id));
        EquipItemRequestModel inputData = new EquipItemRequestModel(id);
        interactor.equip(inputData);
        assertFalse(inventoryList.get(id - 1).checkIsEquipped());
    }

    @Test
    void equipItemGreaterThanInventorySize() {
        int id = 5;
        EquipItemDsGateway inventoryRepo = new FakeInventoryEquip(inventoryList);
        EquipItemOutputBoundary presenter = new EquipItemOutputBoundary(){
            @Override
            public EquipItemResponseModel prepareSuccessView(EquipItemResponseModel inputId) {
                fail("Use case success is unexpected");
                return null;
            }

            @Override
            public EquipItemResponseModel prepareFailView(String error) {
                return null;
            }
        };

        EquipItemInputBoundary interactor = new EquipItemInteractor(inventoryRepo, presenter);
        assertFalse(inventoryRepo.itemExist(id));
        EquipItemRequestModel inputData = new EquipItemRequestModel(id);
        interactor.equip(inputData);
    }
}
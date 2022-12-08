package inventoryMenu.inventory_menu_use_case.delete_item_use_case;

import entities.inventoryitem.InventoryItemDsRequestModel;
import UI.screens.inventoryscreens.FakeInventoryDeletion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.inventory_menu_use_case.delete_item_use_case.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeleteItemInteractorTest {
    ArrayList<InventoryItemDsRequestModel> inventoryList = new ArrayList<>();

    @BeforeEach
    void setup(){

        InventoryItemDsRequestModel item1 = new InventoryItemDsRequestModel(1, "Shield", "BronzeShield", 4, 10, true);
        InventoryItemDsRequestModel item2 = new InventoryItemDsRequestModel(2, "Weapon", "Sword", 18, 10, false);
        InventoryItemDsRequestModel item3 = new InventoryItemDsRequestModel(3, "Weapon", "Hammer", 15, 43, false);
        inventoryList.add(item1);
        inventoryList.add(item2);
        inventoryList.add(item3);
    }

    @Test
    void deleteTheFirstItem(){
        int id = 1;
        DeleteItemDsGateway inventoryRepo = new FakeInventoryDeletion(inventoryList);
        DeleteItemOutputBoundary presenter = new DeleteItemOutputBoundary() {
            @Override
            public DeleteItemResponseModel prepareSuccessView(DeleteItemResponseModel responseModel) {
                assertEquals("BronzeShield", responseModel.getName());
                assertEquals(id, responseModel.getId());

                return null;
            }

            @Override
            public DeleteItemResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected");
                return null;
            }
        };
        DeleteItemInputBoundary interactor = new DeleteItemInteractor(inventoryRepo, presenter);
        assertTrue(inventoryRepo.itemExist(id));
        assertEquals("BronzeShield", inventoryRepo.getDeletionName(id).getName());
        DeleteItemRequestModel inputData = new DeleteItemRequestModel(id);
        interactor.delete(inputData);
    }

    @Test
    void deleteTheMiddleItem(){
        int id = 2;
        DeleteItemDsGateway inventoryRepo = new FakeInventoryDeletion(inventoryList);
        DeleteItemOutputBoundary presenter = new DeleteItemOutputBoundary() {
            @Override
            public DeleteItemResponseModel prepareSuccessView(DeleteItemResponseModel responseModel) {
                assertEquals("Sword", responseModel.getName());
                assertEquals(id, responseModel.getId());

                return null;
            }

            @Override
            public DeleteItemResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected");
                return null;
            }
        };
        DeleteItemInputBoundary interactor = new DeleteItemInteractor(inventoryRepo, presenter);
        assertTrue(inventoryRepo.itemExist(id));
        assertEquals("Sword", inventoryRepo.getDeletionName(id).getName());
        DeleteItemRequestModel inputData = new DeleteItemRequestModel(id);
        interactor.delete(inputData);
    }

    @Test
    void deleteTheLastItem(){
        int id = 3;
        DeleteItemDsGateway inventoryRepo = new FakeInventoryDeletion(inventoryList);
        DeleteItemOutputBoundary presenter = new DeleteItemOutputBoundary() {
            @Override
            public DeleteItemResponseModel prepareSuccessView(DeleteItemResponseModel responseModel) {
                assertEquals("Hammer", responseModel.getName());
                assertEquals(id, responseModel.getId());

                return null;
            }

            @Override
            public DeleteItemResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected");
                return null;
            }
        };
        DeleteItemInputBoundary interactor = new DeleteItemInteractor(inventoryRepo, presenter);
        assertTrue(inventoryRepo.itemExist(id));
        assertEquals("Hammer", inventoryRepo.getDeletionName(id).getName());
        DeleteItemRequestModel inputData = new DeleteItemRequestModel(id);
        interactor.delete(inputData);
    }

    @Test
    void deleteItemSmallerThanOne(){
        int id = 0;
        DeleteItemDsGateway inventoryRepo = new FakeInventoryDeletion(inventoryList);
        DeleteItemOutputBoundary presenter = new DeleteItemOutputBoundary() {
            @Override
            public DeleteItemResponseModel prepareSuccessView(DeleteItemResponseModel responseModel) {
                fail("Use case success is unexpected");

                return null;
            }

            @Override
            public DeleteItemResponseModel prepareFailView(String error) {
                return null;
            }
        };
        DeleteItemInputBoundary interactor = new DeleteItemInteractor(inventoryRepo, presenter);
        assertFalse(inventoryRepo.itemExist(id));
        DeleteItemRequestModel inputData = new DeleteItemRequestModel(id);
        interactor.delete(inputData);
    }

    @Test
    void deleteItemGreaterThanInventorySize(){
        int inventorySize = 20;
        int id = inventorySize + 1;
        DeleteItemDsGateway inventoryRepo = new FakeInventoryDeletion(inventoryList);
        DeleteItemOutputBoundary presenter = new DeleteItemOutputBoundary() {
            @Override
            public DeleteItemResponseModel prepareSuccessView(DeleteItemResponseModel responseModel) {
                fail("Use case success is unexpected");

                return null;
            }

            @Override
            public DeleteItemResponseModel prepareFailView(String error) {
                return null;
            }
        };
        DeleteItemInputBoundary interactor = new DeleteItemInteractor(inventoryRepo, presenter);
        assertFalse(inventoryRepo.itemExist(id));
        DeleteItemRequestModel inputData = new DeleteItemRequestModel(id);
        interactor.delete(inputData);
    }

    @Test
    void deleteItemInEmptyInventory() {
        ArrayList<InventoryItemDsRequestModel> emptyInventoryList = new ArrayList<>();
        DeleteItemDsGateway inventoryRepo = new FakeInventoryDeletion(emptyInventoryList);
        int id = 1;
        DeleteItemOutputBoundary presenter = new DeleteItemOutputBoundary() {
            @Override
            public DeleteItemResponseModel prepareSuccessView(DeleteItemResponseModel responseModel) {
                fail("Use case success is unexpected");

                return null;
            }

            @Override
            public DeleteItemResponseModel prepareFailView(String error) {
                return null;
            }

        };
        DeleteItemInputBoundary interactor = new DeleteItemInteractor(inventoryRepo, presenter);
        assertFalse(inventoryRepo.itemExist(id));
        DeleteItemRequestModel inputData = new DeleteItemRequestModel(id);
        interactor.delete(inputData);
    }
}
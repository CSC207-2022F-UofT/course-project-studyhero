package tutorial;

import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryDsGateway;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryInputBoundary;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryInteractor;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryOutputBoundary;
import inventorymenu.inventoryitem.*;
import inventorymenu.inventory_menu_use_case.delete_item_use_case.DeleteItemDsGateway;
import inventorymenu.inventory_menu_use_case.delete_item_use_case.DeleteItemInputBoundary;
import inventorymenu.inventory_menu_use_case.delete_item_use_case.DeleteItemInteractor;
import inventorymenu.inventory_menu_use_case.delete_item_use_case.DeleteItemOutputBoundary;
import inventorymenu.inventoryscreens.*;
import screens.panels.inventoryPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class HelloWorld {
    static final String playerInventory = "PlayerInventory.csv";

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 100; i++) {
            System.out.println(convert(i));
        }
        InitializePlayerInventory.InitializePlayerInventory(playerInventory);

        JFrame application = new JFrame("Inventory Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        PlayerDisplayInventoryDsGateway playerDisplayInventoryDsGateway;
        playerDisplayInventoryDsGateway = new InventoryListFile(playerInventory);


        PlayerDisplayInventoryOutputBoundary playerDisplayInventoryPresenter = new PlayerDisplayInventoryPresenter();
        PlayerDisplayInventoryInputBoundary playerDisplayInventoryInteractor = new PlayerDisplayInventoryInteractor(playerDisplayInventoryDsGateway, playerDisplayInventoryPresenter);
        PlayerDisplayInventoryController displayInventoryController = new PlayerDisplayInventoryController(playerDisplayInventoryInteractor);

        DeleteItemOutputBoundary deleteItemPresenter = new DeleteItemPresenter();
        DeleteItemDsGateway deleteItemDsGateway;
        deleteItemDsGateway = new InventoryListFile(playerInventory);
        DeleteItemInputBoundary deleteItemInputBoundary = new DeleteItemInteractor(deleteItemDsGateway,deleteItemPresenter);
        DeleteItemController deleteItemController = new DeleteItemController(deleteItemInputBoundary);



        inventoryPanel inventoryScreen = new inventoryPanel(displayInventoryController, deleteItemController);
        screens.add(inventoryScreen, "welcome");
        cardLayout.show(screens, "inventory");
        application.pack();
        application.setVisible(true);

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

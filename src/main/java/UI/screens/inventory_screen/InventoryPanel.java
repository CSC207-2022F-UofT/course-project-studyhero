package UI.screens.inventory_screen;

import inventorymenu.inventory_menu_use_case.delete_item_use_case.*;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.*;
import inventorymenu.inventory_menu_use_case.equip_item_use_case.*;
import inventorymenu.inventoryitem.PlayerInventoryFile;
import inventorymenu.inventoryscreens.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class InventoryPanel extends JPanel implements ActionListener {
    private final JTextArea inventoryInfo;
    private final JButton deleteItem;
    private final JButton equipEquipment;
    private final JTextField deleteItemTextField;
    private final JTextField equipItemTextField;
    private final static String newline = "\n";
    static final String playerInventory = "PlayerInventory.csv";

    PlayerDisplayInventoryDsGateway playerDisplayInventoryDsGateway = new PlayerInventoryFile(playerInventory);
    PlayerDisplayInventoryOutputBoundary playerDisplayInventoryPresenter = new PlayerDisplayInventoryPresenter();
    PlayerDisplayInventoryInputBoundary playerDisplayInventoryInteractor =
            new PlayerDisplayInventoryInteractor(playerDisplayInventoryDsGateway, playerDisplayInventoryPresenter);
    PlayerDisplayInventoryController displayInventoryController =
            new PlayerDisplayInventoryController(playerDisplayInventoryInteractor);
    DeleteItemOutputBoundary deleteItemPresenter = new DeleteItemPresenter();
    DeleteItemDsGateway deleteItemDsGateway = new PlayerInventoryFile(playerInventory);
    DeleteItemInputBoundary deleteItemInputBoundary =
            new DeleteItemInteractor(deleteItemDsGateway,deleteItemPresenter);
    DeleteItemController deleteItemController = new DeleteItemController(deleteItemInputBoundary);

    EquipItemOutputBoundary equipItemPresenter = new EquipItemPresenter();
    EquipItemDsGateway equipItemDsGateway = new PlayerInventoryFile(playerInventory);
    EquipItemInputBoundary equipItemInputBoundary = new EquipItemInteractor(equipItemDsGateway, equipItemPresenter);
    EquipItemController equipItemController = new EquipItemController(equipItemInputBoundary);


    public InventoryPanel(CardLayout card, JPanel parentPanel) {
        JLabel title = new JLabel("Your Inventory");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        PlayerDisplayInventoryResponseModel displayInventoryResponseModel = displayInventoryController.display();
        ArrayList<String> response = displayInventoryResponseModel.showItem();
        JButton goToBreakMenuButton = new JButton("Go back to break menu");
        goToBreakMenuButton.addActionListener(e -> card.show(parentPanel, "Break"));

        inventoryInfo = new JTextArea(20, 1);
        inventoryInfo.setEditable(false);
        for(String line : response){
            inventoryInfo.append(line + newline);
        }

        deleteItem = new JButton("delete item");
        equipEquipment = new JButton("equip equipment");
        deleteItemTextField = new JTextField();
        equipItemTextField = new JTextField();

        deleteItem.addActionListener(this);
        equipEquipment.addActionListener(this);
        deleteItemTextField.addActionListener(this);
        equipItemTextField.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(inventoryInfo);
        this.add(deleteItem);
        this.add(deleteItemTextField);
        this.add(equipEquipment);
        this.add(equipItemTextField);
        this.add(goToBreakMenuButton);

    }


    @Override
    public void actionPerformed(ActionEvent evt) {
        if(Objects.equals(evt.getSource(), deleteItem)){
            try{
                DeleteItemRequestModel deleteItemRequestModel = new DeleteItemRequestModel(Integer.parseInt(
                        deleteItemTextField.getText()));

                DeleteItemResponseModel deleteItemResponseModel =
                        deleteItemController.delete(deleteItemRequestModel);


                JOptionPane.showMessageDialog(this, deleteItemResponseModel.getName() +
                        " is deleted at slot " + deleteItemResponseModel.getId());

                PlayerDisplayInventoryResponseModel displayInventoryResponseModel =
                        displayInventoryController.display();
                ArrayList<String> response = displayInventoryResponseModel.showItem();
                inventoryInfo.setText("");
                for(String line : response) inventoryInfo.append(line + newline);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

        if(evt.getSource() == equipEquipment){
            try{
                EquipItemRequestModel equipItemRequestModel;

                equipItemRequestModel = new EquipItemRequestModel(Integer.parseInt(
                        equipItemTextField.getText()));
                EquipItemResponseModel equipItemResponseModel;

                equipItemResponseModel = equipItemController.delete(equipItemRequestModel);


                JOptionPane.showMessageDialog(this,
                        equipItemResponseModel.getName() +
                                " is equipped at slot " + equipItemResponseModel.getId());

                PlayerDisplayInventoryResponseModel displayInventoryResponseModel = displayInventoryController.display();
                ArrayList<String> response;
                response = displayInventoryResponseModel.showItem();
                inventoryInfo.setText("");
                for(String line : response) inventoryInfo.append(line + newline);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }

}

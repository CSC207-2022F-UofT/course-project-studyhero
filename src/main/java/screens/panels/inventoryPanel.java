package screens.panels;

import inventorymenu.inventory_menu_use_case.delete_item_use_case.DeleteItemRequestModel;
import inventorymenu.inventory_menu_use_case.delete_item_use_case.DeleteItemResponseModel;
import inventorymenu.inventory_menu_use_case.display_player_inventory_use_case.PlayerDisplayInventoryResponseModel;
import inventorymenu.inventoryscreens.DeleteItemController;
import inventorymenu.inventoryscreens.PlayerDisplayInventoryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class inventoryPanel extends JPanel implements ActionListener {
    private JTextArea inventoryInfo;
    private JButton deleteItem;
    private JButton equipEquipment;
    private JTextField deleteItemTextField;
    private JTextField equipItemTextField;

    private final static String newline = "\n";
    PlayerDisplayInventoryController inventoryDisplayController;
    DeleteItemController deleteItemController;




    public inventoryPanel(PlayerDisplayInventoryController inventoryDisplayController, DeleteItemController deleteItemController) {
        this.inventoryDisplayController = inventoryDisplayController;
        this.deleteItemController = deleteItemController;

        JLabel title = new JLabel("Your Inventory");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        PlayerDisplayInventoryResponseModel displayInventoryResponseModel = inventoryDisplayController.display();
        ArrayList<String> response = displayInventoryResponseModel.showItem();

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

    }



    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == deleteItem){
            try{
                DeleteItemRequestModel deleteItemRequestModel = new DeleteItemRequestModel(Integer.parseInt(deleteItemTextField.getText()));

                DeleteItemResponseModel deleteItemResponseModel = deleteItemController.delete(deleteItemRequestModel);


                JOptionPane.showMessageDialog(this, deleteItemResponseModel.getName() +
                        " is deleted at slot " + deleteItemResponseModel.getId());

                PlayerDisplayInventoryResponseModel displayInventoryResponseModel = inventoryDisplayController.display();
                ArrayList<String> response = displayInventoryResponseModel.showItem();
                inventoryInfo.setText("");
                for(String line : response){
                    inventoryInfo.append(line + newline);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

        if(evt.getSource() == equipEquipment){

        }
    }

}

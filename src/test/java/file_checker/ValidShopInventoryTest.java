package file_checker;

import inventory.entities.ObjectTestInventoryItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import errors.usecases.ErrorOutputBoundary;
import errors.usecases.ErrorPresenter;
import filesaver.usecases.file_checker.ValidFileDsGateway;
import filesaver.usecases.file_checker.ValidShopInventory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ValidShopInventoryTest {

    File testValidShopInventoryFile;
    ValidFileDsGateway validFileDsGateway;
    ErrorOutputBoundary error = new ErrorPresenter();
    ErrorOutputBoundary fakeError = new ErrorPresenter();
    String filename;

    //A valid label
    String label = "Shop Inventory";

    //A valid header
    Map<String, Integer> validHeader = new LinkedHashMap<>();

    //An invalid header
    Map<String, Integer> inValidHeader = new LinkedHashMap<>();

    //A valid inventory list
    ArrayList<ObjectTestInventoryItem> validInventoryList = new ArrayList<>();
    ObjectTestInventoryItem item1 = new ObjectTestInventoryItem(1,
            "Weapon",
            "Sword",
            13, 10, false);
    ObjectTestInventoryItem item2 = new ObjectTestInventoryItem(2,
            "AttackPotion",
            "StrengthPotion",
            5, 23, false);
    ObjectTestInventoryItem item3 = new ObjectTestInventoryItem(3,
            "Weapon",
            "Hammer",
            18, 43, false);
    ObjectTestInventoryItem item4 = new ObjectTestInventoryItem(4,
            "Shield",
            "BronzeShield",
            15, 20, false);

    //An invalid inventoryList with incorrect inventory id
    ArrayList<ObjectTestInventoryItem> inValidInventoryListID = new ArrayList<>();
    ObjectTestInventoryItem invalidItemId1 = new ObjectTestInventoryItem("invalid",
            "Weapon",
            "Sword",
            13, 10, false);

    //An invalid inventoryList with incorrect inventory type
    ArrayList<ObjectTestInventoryItem> inValidInventoryListType = new ArrayList<>();
    ObjectTestInventoryItem invalidItemType1 = new ObjectTestInventoryItem(1,
            "Gun",
            "Sword",
            13, 10, false);

    //An invalid inventoryList with incorrect inventory item effect
    ArrayList<ObjectTestInventoryItem> inValidInventoryListEffect = new ArrayList<>();
    ObjectTestInventoryItem invalidItemEffect1 = new ObjectTestInventoryItem(1,
            "Weapon",
            "a",
            "invalid", 10, false);

    //An invalid inventoryList with incorrect inventory goldValue
    ArrayList<ObjectTestInventoryItem> inValidInventoryListGoldValue = new ArrayList<>();
    ObjectTestInventoryItem invalidItemGoldValue1 = new ObjectTestInventoryItem(1,
            "Weapon",
            "a",
            13, "invalid", false);

    @BeforeEach
    void setUp(){
        System.setProperty("java.awt.headless","false");
        testValidShopInventoryFile = new File("testValidShopInventoryFile.csv");
        filename = testValidShopInventoryFile.getName();
        validFileDsGateway = new ValidShopInventory(testValidShopInventoryFile.getName(), error);
        validHeader.put("item_id", 0);
        validHeader.put("item_type", 1);
        validHeader.put("item_name", 2);
        validHeader.put("item_effect", 3);
        validHeader.put("item_gold_value", 4);


        inValidHeader.put("item_id", 0);
        inValidHeader.put("item_type", 1);
        inValidHeader.put("item_name", 2);
        inValidHeader.put("item_effect", 3);
        inValidHeader.put("item_gold_value", 4);
        inValidHeader.put("item_is_equipped", 5);

        validInventoryList.add(item1);
        validInventoryList.add(item2);
        validInventoryList.add(item3);
        validInventoryList.add(item4);

        inValidInventoryListID.add(invalidItemId1);
        inValidInventoryListID.add(item2);
        inValidInventoryListID.add(item3);
        inValidInventoryListID.add(item4);

        inValidInventoryListType.add(invalidItemType1);
        inValidInventoryListType.add(item2);
        inValidInventoryListType.add(item3);
        inValidInventoryListType.add(item4);

        inValidInventoryListEffect.add(invalidItemEffect1);
        inValidInventoryListEffect.add(item2);
        inValidInventoryListEffect.add(item3);
        inValidInventoryListEffect.add(item4);

        inValidInventoryListGoldValue.add(invalidItemGoldValue1);
        inValidInventoryListGoldValue.add(item2);
        inValidInventoryListGoldValue.add(item3);
        inValidInventoryListGoldValue.add(item4);

    }
    public void writeFile(String label, Map<String, Integer> header,
                          ArrayList<ObjectTestInventoryItem> inventoryList){
        BufferedWriter fileWithInvalidHeaderWriter;
        try {
            fileWithInvalidHeaderWriter = new BufferedWriter(
                    new FileWriter(testValidShopInventoryFile));
            fileWithInvalidHeaderWriter.write(label);
            fileWithInvalidHeaderWriter.newLine();
            fileWithInvalidHeaderWriter.write(String.join(",", header.keySet()));
            fileWithInvalidHeaderWriter.newLine();

            for (ObjectTestInventoryItem item : inventoryList) {
                String line = String.format("%s,%s,%s,%s,%s",
                        item.getId(),
                        item.getType(),
                        item.getName(),
                        item.getEffect(),
                        item.getGoldValue());
                fileWithInvalidHeaderWriter.write(line);
                fileWithInvalidHeaderWriter.newLine();
            }

            fileWithInvalidHeaderWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void fileExists() throws IOException {
        FileWriter writer = new FileWriter(testValidShopInventoryFile);
        writer.write("1");
        writer.close();
        ValidFileDsGateway fakeFileDsGateway = new ValidShopInventory(
                "fakeFile", error);
        assertTrue(validFileDsGateway.fileExists());
        assertFalse(fakeFileDsGateway.fileExists());
    }

    @Test
    void isPlayable() throws IOException {
        FileWriter writer = new FileWriter(testValidShopInventoryFile);
        writer.write("1");
        assertFalse(validFileDsGateway.isPlayable());
        writer.close();

        //Check file with valid information
        writeFile(label,validHeader,validInventoryList);
        assertTrue(validFileDsGateway.isPlayable());

        //Check file with invalid label but other parts are working
        writeFile("Shop", validHeader, validInventoryList);
        assertFalse(validFileDsGateway.isPlayable());

        //Check file with invalid header but other parts are working
        writeFile(label, inValidHeader, validInventoryList);
        assertFalse(validFileDsGateway.isPlayable());

        //Check file with invalid item id but other part valid
        writeFile(label, validHeader, inValidInventoryListID);
        assertFalse(validFileDsGateway.isPlayable());

        //Check file with invalid item type but other part valid
        writeFile("Shop", validHeader, inValidInventoryListType);
        assertFalse(validFileDsGateway.isPlayable());

        //Check file with invalid item effect but other part valid
        writeFile("Shop", validHeader, inValidInventoryListEffect);
        assertFalse(validFileDsGateway.isPlayable());

        //Check file with invalid item gold value but other part valid
        writeFile("Shop", validHeader, inValidInventoryListGoldValue);
        assertFalse(validFileDsGateway.isPlayable());
    }

    @Test
    void isValid() throws IOException {
        ValidFileDsGateway fakeFileDsGateway = new ValidShopInventory("fakeFile", fakeError);

        //Check file does not exist
        fakeFileDsGateway.isValid();
        assertEquals("There is no existing " + "fakeFile" + " file.", fakeError.getError());

        //Check file with valid information
        writeFile(label,validHeader,validInventoryList);
        validFileDsGateway.isValid();
        assertNull(error.getError());

        //Check file with invalid label but other parts are working
        writeFile("Shop", validHeader, validInventoryList);
        validFileDsGateway.isValid();
        assertEquals("Invalid " + filename + " file.", error.getError());

        //Check file with invalid header but other parts are working
        writeFile(label, inValidHeader, validInventoryList);
        validFileDsGateway.isValid();
        assertEquals("Invalid " + filename + " file.", error.getError());

        //Check empty file
        FileWriter writer = new FileWriter(testValidShopInventoryFile);
        writer.close();
        validFileDsGateway.isValid();
        assertEquals("There are no items in " + filename, error.getError());

        //Check file with invalid item id but other part valid
        writeFile(label, validHeader, inValidInventoryListID);
        assertFalse(validFileDsGateway.isPlayable());
        validFileDsGateway.isValid();
        assertEquals("Item IDs are invalid.", error.getError());

        //Check file with invalid item type but other part valid
        writeFile(label, validHeader, inValidInventoryListType);
        validFileDsGateway.isValid();
        assertEquals("Items are of invalid types.", error.getError());

        //Check file with invalid item effect but other part valid
        writeFile(label, validHeader, inValidInventoryListEffect);
        validFileDsGateway.isValid();
        assertEquals("Items have invalid effects.", error.getError());

        //Check file with invalid item gold value but other part valid
        writeFile(label, validHeader, inValidInventoryListGoldValue);
        validFileDsGateway.isValid();
        assertEquals("Items have invalid gold value.", error.getError());

    }
}
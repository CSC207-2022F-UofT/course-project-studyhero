package use_cases.file_checker;

import use_cases.errors.ErrorOutputBoundary;

import java.io.*;
import java.util.Arrays;


public class ValidShopInventory implements ValidInventory{

    String filename;
    File file;
    ErrorOutputBoundary presenter;
    public ValidShopInventory(String filename, ErrorOutputBoundary presenter){
        this.filename = filename;
        this.file = new File(filename);
        this.presenter = presenter;
    }

    public String[] read(BufferedReader br){
        String line;
        try {
            line = br.readLine();
            return line.split(",");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String checkError(){
        if (!fileExists()){return "exist";}
        try{
            BufferedReader br = new BufferedReader(
                    new FileReader(file));

            // check it is not empty
            if (file.length() == 0){return "empty";}

            // check the label is correct and matches
            String label = String.valueOf(read(br));
            if(label.equals("Shop Inventory")){
                return "label";
            }

            // check the header is correct and matches
            String[] header = read(br);
            if (!Arrays.equals(header, new String[]{"item_id", "item_type", "item_name", "item_effect", "item_gold_value"})){
                System.out.println(header[0]);
                return "header";
            }

            String line;
            while (((line = br.readLine()) != null) && !line.isEmpty()){
                String[] item = line.trim().split(",");
                // check id is integer
                String index = item[0], type = item[1],
                        name = item[2], effect = item[3],
                        goldValue = item[4];

                try {Integer.valueOf(index);
                }catch(NumberFormatException e){return "index";}

                // check type is valid
                String[] valid_types = {"Weapon","Shield","AttackPotion","HealthPotion","PoisonPotion"};
                // not so good as this is primitive
                if (!(Arrays.asList(valid_types).contains(type))){
                    return "type";
                }
                // check if weapon name is correct?

                // check effect is integer
                try {Integer.valueOf(effect);}
                catch(NumberFormatException e){return "effect";}

                // check goldValue is integer
                try {Integer.valueOf(goldValue);}
                catch(NumberFormatException e){return "goldValue";}
            }
            br.close();
            return null;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch(NumberFormatException e){return "other";}
    }

    @Override
    public boolean fileExists() {
        return (file.exists() && !file.isDirectory());    }

    @Override
    public boolean isPlayable(){
        return (checkError() == null);
    }
    @Override
    public boolean isValid() {
        String result = checkError();
        if (result == null){return true;}
        switch(result){
            case "exist":
                presenter.error("There is no existing " + filename + " file.");
            case "label":
                presenter.error("Invalid " + filename + " file.");
            case "header":
                presenter.error("Invalid " + filename + " file.");
            case "empty":
                presenter.error("There are no items in " + filename);
            case "index":
                presenter.error("Item IDs are invalid.");
            case "type":
                presenter.error("Items are of invalid types.");
            case "effect":
                presenter.error("Items have invalid effects.");
            case "goldValue":
                presenter.error("Items have invalid gold value.");
            case "other":
                presenter.error("Error: please start a new game.");
        }
        return false;
    }
}
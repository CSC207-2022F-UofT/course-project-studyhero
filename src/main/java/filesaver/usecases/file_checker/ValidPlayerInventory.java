package filesaver.usecases.file_checker;

import errors.usecases.ErrorOutputBoundary;

import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Objects;


public class ValidPlayerInventory implements ValidFileDsGateway{

    private final String filename;
    private final File file;
    private final ErrorOutputBoundary presenter;
    private final String[] valid_types = {"Weapon","Shield","AttackPotion","HealthPotion","PoisonPotion"};
    private final String[] valid_header =
            {"item_id", "item_type", "item_name", "item_effect", "item_gold_value", "item_is_equipped"};


    /**
     * Creates a ValidPlayerInventory use case object that is capable of
     * checking the validity of files for reading
     *
     * @param filename      filepath of file to check
     * @param presenter     output boundary to display any error
     */
    public ValidPlayerInventory(String filename, ErrorOutputBoundary presenter){
        this.filename = filename;
        this.file = new File(filename);
        this.presenter = presenter;
    }

    /**
     * Helper function that reads the next line of the buffered
     * reader and turns it into a string array
     *
     * @param br            BufferedReader
     * @return String array representation of the next line
     */
    private String[] read(BufferedReader br){
        String line;
        try {
            line = br.readLine();
            return line.split(",");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Helper function that checks all PlayerInventory attributes
     * are of correct type and format
     *
     * @return
     * - null           if there is no error
     * - "exist"        if the file does not exist
     * - "empty"        if the file exists but is empty
     * - "label"        if the label is not correct
     * - "header"       if the attributes do not match the valid_headers array
     * - "type"         if any item's type cannot be found in the valid_types array
     * - "effect"       if any item's effect is not an integer
     * - "goldValue"    if any item's gold value is not an integer
     * - "isEquipped"   if any item's equipped attribute is not a boolean
     * - "other"        if there is any IOException or RuntimeException
     */
    private String checkError(){
        if (!fileExists()){return "exist";}
        try{
            BufferedReader br = new BufferedReader(
                    new FileReader(file));

            // check it is not empty
            if (file.length() == 0){return "empty";}

            // check the label is correct and matches
            String label = Arrays.toString(read(br));
            if(!Objects.equals(label, "[Player Inventory]")){
                return "label";
            }

            // check the header is correct and matches
            String[] header = read(br);
            if (!Arrays.equals(header, valid_header)){
                System.out.println(header[0]);
                return "header";
            }

            String line;
            while (((line = br.readLine()) != null) && !line.isEmpty()){
                String[] item = line.trim().split(",");
                // check id is integer
                String index = item[0], type = item[1],
                        effect = item[3],
                        goldValue = item[4], isEquipped = item[5];

                try {Integer.valueOf(index);
                }catch(NumberFormatException e){return "index";}

                // check type is valid
                if (!(Arrays.asList(valid_types).contains(type))){
                    return "type";
                }

                // check effect is integer
                try {Integer.valueOf(effect);}
                catch(NumberFormatException e){return "effect";}

                // check goldValue is integer
                try {Integer.valueOf(goldValue);}
                catch(NumberFormatException e){return "goldValue";}

                // check isEquipped is boolean
                if(!(isEquipped.equals("true")||isEquipped.equals("false"))){return "isEquipped";}
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

    /**
     * @return true if it is playable, else false along with a
     * window (JFrame) displaying the error.
     */
    @Override
    public boolean isValid() {
        String result = checkError();
        if (result == null){return true;}

        switch(result){
            case "exist":
                presenter.setError("There is no existing " + filename + " file.");
                return false;
            case "label":
            case "header":
                presenter.setError("Invalid " + filename + " file.");
                return false;
            case "empty":
                presenter.setError("There are no items in " + filename);
                return false;
            case "index":
                presenter.setError("Item IDs are invalid.");
                return false;
            case "type":
                presenter.setError("Items are of invalid types.");
                return false;
            case "effect":
                presenter.setError("Items have invalid effects.");
                return false;
            case "goldValue":
                presenter.setError("Items have invalid gold value.");
                return false;
            case "isEquipped":
                presenter.setError("Items have invalid equip information.");
                return false;
            case "other":
                presenter.setError("Error: please start a new game.");
                return false;
        }
        try{presenter.error(presenter.getError()); }
        catch (HeadlessException e){return false;}
        return false;
    }
}
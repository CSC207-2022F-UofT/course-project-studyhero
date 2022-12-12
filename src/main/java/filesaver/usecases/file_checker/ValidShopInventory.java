package filesaver.usecases.file_checker;

import errors.usecases.ErrorOutputBoundary;

import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Objects;


public class ValidShopInventory implements ValidFileDsGateway{

    private final String filename;
    private final File file;
    private final ErrorOutputBoundary presenter;
    private final String[] valid_types = {"Weapon","Shield","AttackPotion","HealthPotion","PoisonPotion"};
    private final String[] valid_header =
            {"item_id", "item_type", "item_name", "item_effect", "item_gold_value"};

    /**
     * Creates a ValidShopInventory object that can check for whether the file
     * with filename is a valid shop inventory file and can be read for use cases.
     *
     * @param filename      filename of file to check
     * @param presenter     output boundary for displaying errors
     */
    public ValidShopInventory(String filename, ErrorOutputBoundary presenter){
        this.filename = filename;
        this.file = new File(filename);
        this.presenter = presenter;
    }

    /**
     * Reads the next line of the buffered reader and turns
     * it into a string array
     *
     * @param br            BufferedReader
     * @return String array representation of the next line
     */
    public String[] read(BufferedReader br){
        String line;
        try {
            line = br.readLine();
            return line.split(",");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks all ShopInventory attributes are of correct type and format
     *
     * @return
     * - null           if there is no error
     * - "exist"        if the file does not exist
     * - "empty"        if the file exists but is empty
     * - "label"        if the label is not correct
     * - "header"       if the attributes do not match the valid_headers array
     * - "index"        if the id of the item is not an integer
     * - "type"         if any item's type cannot be found in the valid_types array
     * - "effect"       if any item's effect is not an integer
     * - "goldValue"    if any item's gold value is not an integer
     * - "other"        if there is any IOException
     */
    public String checkError(){
        if (!fileExists()){return "exist";}
        try{
            BufferedReader br = new BufferedReader(
                    new FileReader(file));

            // check it is not empty
            if (file.length() == 0){return "empty";}

            // check the label is correct and matches
           String label = Arrays.toString(read(br));
            if(!Objects.equals(label, "[Shop Inventory]")){
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

                String index = item[0], type = item[1],
                        effect = item[3],
                        goldValue = item[4];

                // check id is integer
                try {Integer.valueOf(index);
                }catch(NumberFormatException e){return "index";}

                // check type is valid
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


    /**
     * @return true if the file with filename path exists and isn't a
     * directory, else false
     */
    @Override
    public boolean fileExists() {
        return (file.exists() && !file.isDirectory());    }


    /**
     * @return true if checkError returns a null value, ie the stat file
     * in memory is valid and readable
     */
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
            case "other":
                presenter.setError("Error: please start a new game.");
                return false;
        }
        try{presenter.error(presenter.getError()); }
        catch (HeadlessException e){return false;}
        return false;
    }
}
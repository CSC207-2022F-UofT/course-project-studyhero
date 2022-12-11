package dialogue.dialogue_clean.entities;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/*
This is a class that reads DialogueText.csv and converts it into a hashmap for use.

About Warnings:
- "Raw use of parametrized HashMap" not sure how to fix this one.
Adding <String, String> to the declaration still gives a warning.
 */

public class DialogueCSVReader {
    String path = "DialogueText.csv";
    String line;
    BufferedReader br;
    public HashMap<String, String> dialogueMap = new HashMap<>();

    public DialogueCSVReader() {

        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] value = line.split(",");
                dialogueMap.put(value[0], value[1]);
            } //end of while loop
        } //end of try
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap getDialogues() {
        return dialogueMap;}
}

package entities;
import dialogue.dialogue_clean.entities.DialogueEntity;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;

/*
Test for the Entities of Dialogue. It is not finished.
Since the feature is not working, I am not sure what to test for.
 */

public class DialogueEntityTest {

    DialogueEntity dialogueEntity = new DialogueEntity();
    HashMap dialogueMap;


    @BeforeEach
    void dialogueSetUp() {this.dialogueMap = dialogueEntity.getDialogueMap();}

}

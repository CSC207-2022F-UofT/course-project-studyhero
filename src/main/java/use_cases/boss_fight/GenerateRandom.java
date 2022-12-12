package use_cases.boss_fight;

import java.util.Random;

/**
 * A helper interactor randomizer that
 */
public class GenerateRandom {

    /**
     * Generates a random value from zero to two which is sent back
     * @return a random number between 0 and the bound - 1
     */
    public static int generator(){
        Random rand = new Random();
        int upperbound = 3;
        return rand.nextInt(upperbound);
    }

}

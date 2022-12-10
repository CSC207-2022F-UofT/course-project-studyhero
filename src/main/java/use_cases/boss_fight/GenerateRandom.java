package use_cases.boss_fight;

import java.util.Random;

public class GenerateRandom {
    public static int generator(){
        Random rand = new Random();
        int upperbound = 3;
        int intRandom = rand.nextInt(upperbound);
        return intRandom;
    }

}

package use_cases.boss_fight;

import java.util.*;

public class FightWinner {
    Map<String, ArrayList<Integer>> ht1 = new Hashtable<>();
    ArrayList<Integer> al1 = new ArrayList<>();
    ArrayList<Integer> al2 = new ArrayList<>();
    ArrayList<Integer> al3 = new ArrayList<>();

    public FightWinner(){
        al1.add(1);
        al1.add(1);
        al2.add(0);
        al2.add(1);
        al3.add(1);
        al3.add(0);
        ht1.put("00", al1);
        ht1.put("01", al2);
        ht1.put("02", al3);
        ht1.put("10", al3);
        ht1.put("11", al1);
        ht1.put("12", al2);
        ht1.put("20", al2);
        ht1.put("21", al3);
        ht1.put("22", al1);
    }

    public ArrayList<Integer> winner(int playerValue, int bossValue) {
        new FightWinner();
        String playerString = String.valueOf(playerValue);
        String bossString = String.valueOf(bossValue);
        ArrayList<Integer> winner = ht1.get(playerString + bossString);
        System.out.println(winner);
        return winner;
    }
}

package com.badlogic.citadel;
import java.util.Random;

public abstract class Dice {
    private static Random rand = new Random();

    public static int soloDice(){

        return rand.nextInt(6)+1;
    }

    public static int doubleDice(){
        return rand.nextInt(6)+1 + rand.nextInt(6)+1;
    }

    public static int tripleDice(){
        return rand.nextInt(6)+1 + rand.nextInt(6)+1 + rand.nextInt(6)+1;
    }

    /**
     * Return 0 or 1
     * @return 0 for face and 1 for tails
     */
    public static int pileFaceDice(){
        return rand.nextInt(0,1);
    }
}

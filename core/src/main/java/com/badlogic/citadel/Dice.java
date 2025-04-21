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
}

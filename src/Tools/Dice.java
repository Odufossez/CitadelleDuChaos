package Tools;
import java.util.Random;

public abstract class Dice {
    public static int soloDice(){
        Random rand = new Random();
        return rand.nextInt(6)+1;
    }

    public static int doubleDice(){
        Random rand = new Random();
        return rand.nextInt(6)+1 + rand.nextInt(6)+1;
    }
}

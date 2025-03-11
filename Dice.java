import java.util.Random;

public class Dice {
    public int soloDice(){
        Random rand = new Random();
        return rand.nextInt(6)+1;
    }

    public int doubleDice(){
        Random rand = new Random();
        return rand.nextInt(6)+1 + rand.nextInt(6)+1;
    }
}

package citadelleduchaos;
import java.io.IOException;

/**
 * ERROR STATUS :
 * 1 : WRONG INPUT CHOICE
 * 2 : WRONG PATH FOR TEXT
 */

//non défintif
public class Main {
    public static void main(String[] args) throws IOException {
        Player ply = new Player();
        Monster mst = new Monster();

        ply.setHability(10);
        mst.setHability(6);
        Combat cmb = new Combat(ply, mst);

        System.out.println(cmb.toString());
    }
}

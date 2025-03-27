package citadelleduchaos;
import java.io.IOException;

/**
 * ERROR STATUS :
 * 1 : WRONG INPUT CHOICE
 * 2 : WRONG PATH FOR TEXT
 */

//non défintif
public class Main {
    static Player player;
    static Sauvegarde save = new Sauvegarde();

    public static void main(String[] args) throws IOException {
        player = testLoad();
        System.out.println(player.toString());
    }

    public static Player setUpPlayer() {
        return player = new Player(10,20,4,0,8);
    }

    public void testSave() throws IOException {
        save.newSave(setUpPlayer());
    }

    public static Player testLoad() throws IOException {
        return save.loadSave(0);
    }
}

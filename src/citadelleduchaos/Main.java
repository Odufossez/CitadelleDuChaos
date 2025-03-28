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
        new Affichage();
        CharacterCreator.creationPerso(0);
    }

    public static Player setUpPlayer() {
        return player = new Player(10,20,4,0,8);
    }


    public static Player testLoad() throws IOException {
        return save.loadSave(0);
    }
}

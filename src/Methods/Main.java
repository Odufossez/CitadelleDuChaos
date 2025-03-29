package Methods;
import Visual.Affichage;
import Visual.MainMenu;

import java.io.IOException;

/**
 * ERROR STATUS :
 * 1 : WRONG INPUT CHOICE
 * 2 : WRONG PATH FOR TEXT
 */

//non défintif
public class Main {
    static Player player;

    public static void main(String[] args) throws IOException {
        new Affichage();
        MainMenu.afficherTextes();
    }

    public static Player setUpPlayer() {
        return player = new Player(10,20,4,0,8);
    }


    public static Player testLoad() throws IOException {
        return Sauvegarde.loadSave(0);
    }
}

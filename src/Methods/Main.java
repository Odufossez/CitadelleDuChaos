package Methods;
import Tools.Spells;
import Tools.StdDraw;
import Tools.Stuff;
import Visual.Affichage;
import Visual.MainMenu;

import java.io.IOException;

/**
 * ERROR STATUS :
 * 1 : WRONG INPUT CHOICE
 * 2 : WRONG PATH FOR TEXT
 * 3 : PROBLEME DANS LE CHARGEMENT DE L'EVENT
 */

//non défintif
public class Main {
    static Player player;

    public static void main(String[] args) throws IOException {
        new Affichage();
        new Stuff();
        new Spells();
        MainMenu.afficherTextes();

    }

    public static Player setUpPlayer() {
        return player = new Player(10,20,4,0,8);
    }
}

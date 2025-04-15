package Methods;
import Spells.SpellList;
import Tools.OutilsSorts;
import Items.Stuff;
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
        new OutilsSorts();
        new Stuff();
        new SpellList();
        new Affichage();
        MainMenu.afficherTextes();


    }

    public static Player setUpPlayer() {
        return player = new Player(10,20,12,0,8);
    }
}

package Visual;

import Methods.AffMethods;
import Tools.StdDraw;

import java.io.IOException;

import static Methods.Sauvegarde.*;
import static  Tools.Fonts.*;

public class MainMenu {

    public static void afficherTextes() throws IOException {
        int x = -1800;

        /*Titre principal*/
        StdDraw.setFont(titreMainMenu);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.textLeft(x , 900 , "Citadelle du Chaos - The game");
        StdDraw.setFont(bold18);
        StdDraw.textLeft(x,850 , "By LittleBird");

        /*Sous menu*/
        StdDraw.setFont(plain32);

        if (doesSaveExist(1)&&doesSaveExist(2)&&doesSaveExist(3)) { //plus de place
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        }
        StdDraw.textLeft(x , 80 , "1 - Nouvelle partie");
        StdDraw.setPenColor(StdDraw.BLACK);

        if (!savesExist()) {
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        }
        StdDraw.textLeft(x,0,"2 - Charger une sauvegarde");
        StdDraw.setPenColor(StdDraw.BLACK);

        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.textLeft(x,-80 , "3 - Crédits (wip)");
        StdDraw.textLeft(x,-160,"4 - Succès (wip)");

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.textLeft(x,-240,"5 - Sortir");

        StdDraw.show();
        AffMethods.choiceOnMainMenu();
    } //fin void




}

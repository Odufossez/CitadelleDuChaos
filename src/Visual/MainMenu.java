package Visual;

import Tools.StdDraw;
import java.io.File;
import static  Tools.Fonts.*;
import static Tools.PathsTo.*;

public class MainMenu {

    public void afficherTextes(){
        int x = -1800;

        /*Titre principal*/
        StdDraw.setFont(titreMainMenu);
        StdDraw.textLeft(x , 900 , "Citadelle du Chaos - The game");
        StdDraw.setFont(bold18);
        StdDraw.textLeft(x,850 , "By LittleBird");

        /*Sous menu*/
        StdDraw.setFont(plain32);

        StdDraw.textLeft(x , 80 , "1 - Nouvelle partie");
        
        if (!savesExist()) {
            StdDraw.setPenColor(StdDraw.DARK_GRAY);
        }
        StdDraw.textLeft(x,0,"2 - Charger une sauvegarde");
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.textLeft(x,-80 , "3 - Crédits (wip)");
        StdDraw.textLeft(x,-160,"4 - Sortir");

        StdDraw.show();
    }

    public static boolean savesExist(){
        for (int i = 1; i < 4 ; i++) {
            File file = new File(savePath + i + ".txt");
            if (file.exists()) {
                return true;
            }
        }
        return false;
    }
}

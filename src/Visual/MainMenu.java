package Visual;

import Methods.Events;
import Tools.StdDraw;
import java.io.File;
import java.io.IOException;

import static  Tools.Fonts.*;
import static Tools.PathsTo.*;

public class MainMenu {

    public void afficherTextes() throws IOException {
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
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        }
        StdDraw.textLeft(x,0,"2 - Charger une sauvegarde");
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.textLeft(x,-80 , "3 - Crédits (wip)");
        StdDraw.textLeft(x,-160,"4 - Succès (wip)");
        StdDraw.textLeft(x,-240,"5 - Sortir");

        StdDraw.show();
        char inChar;

        do {
            while (!StdDraw.hasNextKeyTyped()){continue;}
            inChar = StdDraw.nextKeyTyped();
            switch (inChar){
                case '1' , '&' : {
                    if (savesExist()){
                        StdDraw.clear();
                        Affichage.choiceSaveLoad();
                    } else {
                        StdDraw.clear();
                        CharacterCreator.creationPerso(1);
                    }
                    break;
                }
                case '2' , 'é' : {
                    if (savesExist()){
                        StdDraw.clear();
                        Affichage.choiceSaveLoad();
                    }
                    break;
                }
                case '3' , '"' : {

                    break;
                }
                case '4' , '\'' : {

                    break;
                }
                case '5' , '(' : {

                    break;
                }
                default: break;
            }
        }while(inChar!='1' && inChar!='&' &&
                (inChar!='2'&&savesExist()) && (inChar!='é'&&savesExist()) &&
                inChar!='"' && inChar!='3' &&
                inChar!='\'' && inChar!='4' &&
                inChar!='5' && inChar!='(');
    }

    /**
     * Permet de savoir s'il existe déjà une sauvegarde
     * @return true s'il y a au moins une sauvegarde sinon false
     */
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

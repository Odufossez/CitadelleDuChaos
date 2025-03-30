package Methods;

import Tools.StdDraw;
import Visual.Affichage;
import Visual.MainMenu;

import java.io.File;
import java.io.IOException;

import static Methods.Sauvegarde.savesExist;
import static Tools.PathsTo.savePath;
import static Tools.ReadingInChar.readChar;
import static Visual.Affichage.choiceSaveLoad;

public class AffMethods {
    private static char inChar;

    /**
     * renvoie le numéro de la save
     * @return
     * @throws IOException
     */
    public static int getIndiceSave() throws IOException{
        char inChar;

        do{
            inChar = readChar();
            switch (inChar){
                case '&' , '1' : {
                    StdDraw.clear();
                    return 1;
                }
                case 'é' , '2' : {
                    StdDraw.clear();
                    return 2;
                }
                case '"' , '3' : {
                    StdDraw.clear();
                    return 3;
                }
                case 'w' : {
                    StdDraw.clear();
                    MainMenu.afficherTextes();
                }
                default: break;
            }
        }while(true);
    }

    /**
     * Fenêtre de gestion d'une sauvegarde, traite les touches pour savoir
     * quoi faire avec la sauvegarde (v charger , x supprimer)
     * @param nbSave numéro de la sauvegarde à traiter
     * @throws IOException
     */
    public static void fenetreGestionSave(int nbSave) throws IOException {
        do {
            inChar = readChar();
            switch (inChar){
                case 'x' : {
                    File file = new File(savePath + nbSave + ".txt");
                    StdDraw.clear();
                    Affichage.fenetreConfirmDelete();
                    if (fenetreConfirm()){
                        StdDraw.clear();
                        file.delete();
                        if(savesExist()){
                            choiceSaveLoad(); //retour sur la fenetre générale
                        } else {
                            StdDraw.clear();
                            MainMenu.afficherTextes();
                        }
                    } else {
                        StdDraw.clear();
                       Affichage.fenetreGestionSave(nbSave);
                    }
                    break;
                }
                case 'v' : {
                    StdDraw.clear();
                    Sauvegarde.loadSave(nbSave);
                }
                case 'w' : {
                    StdDraw.clear();
                    choiceSaveLoad();
                }
                default: break;
            }
        }while(true);
    }

    /**
     * Methode pour retourner un choix simple de confirmation oui ou non
     * @return true si c'est oui sinon false
     */
    public static boolean fenetreConfirm(){
        do {
            inChar = readChar();
            switch (inChar){
                case 'y' : return true;
                case 'n' : return false;
                default: break;
            }
        }while(true);
    }
}

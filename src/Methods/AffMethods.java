package Methods;

import EventsCdC.Events;
import EventsCdC.RedirectionEvent;
import Tools.StdDraw;
import Visual.Affichage;
import Visual.MainMenu;

import java.io.File;
import java.io.IOException;

import static Methods.Sauvegarde.firstEmptySlot;
import static Methods.Sauvegarde.savesExist;
import static Tools.PathsTo.savePath;
import static Tools.ReadingInChar.readChar;
import static Visual.Affichage.choiceSaveLoad;

public class AffMethods {
    private static char inChar;
    private static Player player;

    /**
     * renvoie le numéro de la save
     * @return entier indice de la sauvegarde (1 à 3)
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
                    Affichage.entryConfirmDelete();
                    if (fenetreConfirm()){
                        StdDraw.clear();
                        if (!file.delete()){
                            throw new IOException(file.getAbsolutePath());
                        }
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
                    Events.setUpPlayer(Sauvegarde.loadSave(nbSave));
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

    /**
     * Méthode pour le choix sur menu principal
     */
    public static void choiceOnMainMenu() throws IOException {
       do {
            while (!StdDraw.hasNextKeyTyped()){continue;}
            inChar = StdDraw.nextKeyTyped();
            switch (inChar){
                case '1' , '&' : { //nouvelle partie
                    int slot = firstEmptySlot();
                    if (slot != -1){
                        StdDraw.clear();
                        Events.intro(slot);
                    }
                    break;
                }
                case '2' , 'é' : { //load save
                    if (savesExist()){
                        StdDraw.clear();
                        Affichage.choiceSaveLoad();
                    }
                    break;
                }
                /*case '3' , '"' : {
                    System.out.println("Crédits in WIP");
                    break;
                }
                case '4' , '\'' : {
                    System.out.println("Succès in WIP");
                    break;
                }*/
                case '5' , '(' : {
                    System.exit(0);
                    break;
                }
                default: break;
            }
        }while(true);
    }

    /**
     * Traitement des objets intéressants dans l'inventaire
     * @param obj1 objet 1 sélectionnable
     * @param eventObj1 event associé à obj1
     * @param obj2 objet 2 sélectionnable
     * @param eventObj2 event associé à obj2
     * @param obj3 objet 3 sélectionnable
     * @param eventObj3 event associé à obj3
     */
    public static void tttInventory(int obj1, int eventObj1 , int obj2 , int eventObj2, int obj3 , int eventObj3) throws IOException {
        do {
            inChar = readChar();
            if (inChar == obj1){
                RedirectionEvent.returnToEvent(eventObj1);
            }
            else if (inChar == obj2){
                RedirectionEvent.returnToEvent(eventObj2);
            }
            else if (inChar == obj3){
                RedirectionEvent.returnToEvent(eventObj3);
            } else {

            }
        }while(true);
    }
}

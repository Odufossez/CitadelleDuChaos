package Visual;

import Methods.AffMethods;
import Methods.Player;
import Methods.Sauvegarde;
import Tools.StdDraw;
import Tools.Stuff;

import java.io.*;
import java.util.ArrayList;

import static Methods.AffMethods.getIndiceSave;
import static Tools.Fonts.*;

public class Affichage {

    private static File file;

    private static int suiteY;
    private static int choiceY;

    private static Player player;

    private static boolean needInventory=false;


    /**
     * Initialisation des paramètres d'affichage de la fenêtre StdDraw
     */
    public Affichage() {
        StdDraw.enableDoubleBuffering();
        /*  Paramétrage de la police et de la fenêtre */
        StdDraw.setXscale(-1920,1920);
        StdDraw.setYscale(-1080,1080);
        StdDraw.setCanvasSize(1920,1080);

        suiteY = 950;

        StdDraw.setTitle("Citadelle du Chaos");
        StdDraw.setFont(bold15);
    }

    /**
     * Affichage du texte narratif d'event en cours
     * @param path : string menant au fichier .txt contenant le texte
     * @throws IOException : gestion d'une erreur sur le path
     */
    public static void narration(String path) throws IOException {

        /* Affichage du texte fourni par @path */
        StdDraw.setFont(plain18);

        try(FileReader fileReader = new FileReader(path);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;

            while ((line = buff.readLine()) != null) {
                StdDraw.text(-150,suiteY,line);
                suiteY=suiteY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }
    }

    /* --------------------------------- FLECHES DE NAV --------------------------------------------------------- */

    /**
     * Fonction pour afficher la flèche permettant de passer à la suite
     */
    public static void arrowNext(){
        StdDraw.line(1400 ,suiteY-200,1400,suiteY-60); //coté vertical du triangle
        StdDraw.line(1400 , suiteY-60 , 1600 , suiteY-140); // coté diagonal haut
        StdDraw.line(1400 , suiteY-200 , 1600 ,  suiteY-140); //coté diagonal bas
        StdDraw.text(1450 , suiteY-140 , "x");
    }

    /**
     * Fonction pour afficher la flèche permettant de revenir en arrière notamment dans la création du grimoire
     */
    public static void arrowPrev(){
        StdDraw.line(-1400 ,suiteY-200,-1400,suiteY-60); //coté vertical du triangle
        StdDraw.line(-1400 , suiteY-60 , -1600 , suiteY-140); // coté diagonal haut
        StdDraw.line(-1400 , suiteY-200 , -1600 ,  suiteY-140); //coté diagonal bas
        StdDraw.text(-1450 , suiteY-140 , "w");
    }

    /*---------------------------- AFFICHAGE DES ENCARDS DE CHOIX --------------------------------------- */

    //TODO pour la v1.01 aligner sur le centre du rectangle.
    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 2 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     */
    public static void choice(String choice1 , String choice2){
        StdDraw.rectangle(-1000,-1000,1000,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice1);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(-1020,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(1000,-1000,1000,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice2);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(1040,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

    }

    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 3 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     * @param choice3 : path vers le txt du choix 3
     */
    public static void choice(String choice1 , String choice2, String choice3){
        StdDraw.rectangle(-1920,-1000,1280,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice1);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(-1320,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(-640,-1000,1280,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice2);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(-40,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(640,-1000,1280,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice3);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(1000,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }
    }

    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 4 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     * @param choice3 : path vers le txt du choix 3
     * @param choice4 : path vers le txt du choix 4
     */
    public static void choice(String choice1 , String choice2, String choice3 , String choice4){
        StdDraw.rectangle(-1920,-1000,960,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice1);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(-1500,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(-960,-1000,960,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice2);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(-500,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(0,-1000,960,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice3);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(500,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(960,-1000,960,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice4);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(1300,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

    }

    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 4 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     * @param choice3 : path vers le txt du choix 3
     * @param choice4 : path vers le txt du choix 4
     * @param choice5 : path vers le txt du choix 5
     */
    public static void choice(String choice1 , String choice2, String choice3 , String choice4 , String choice5){
        int halfWidht = 768;
        StdDraw.rectangle(-1920,-1000,halfWidht,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice1);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(-1500,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(-1152,-1000,halfWidht,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice2);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(-900,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(-384,-1000,halfWidht,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice3);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(0,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(384,-1000,halfWidht,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice4);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(900,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

        StdDraw.rectangle(1152,-1000,halfWidht,500);
        choiceY=-800;
        try(FileReader fileReader = new FileReader(choice5);
            BufferedReader buff = new BufferedReader(fileReader)){
            String line;
            while ((line = buff.readLine()) != null) {
                StdDraw.text(1500,choiceY,line);
                choiceY=choiceY-40;
            }
        } catch (IOException e) {
            System.exit(2);
        }

    }


    /* ------------------------- SAUVEGARDES ----------------------------------------------------- */

    /**
     * Affichage du menu de choix d'une sauvegarde déjà existante
     * @throws FileNotFoundException
     */
    public static void choiceSaveLoad() throws IOException {
        Affichage.arrowPrev();
        StdDraw.setPenRadius(0.005);
        StdDraw.setFont(bold32);
        int y = 100;
        int decalageX = 290;
        int decalageY = 40;

        //Slot 1
        StdDraw.rectangle(-1300,y,350,660);
        StdDraw.text(-1300 , y+430 , "1" );


        //Slot 2
        StdDraw.rectangle(0,100,350,660);
        StdDraw.text(0 , y+430 , "2" );

        //Slot 3
        StdDraw.rectangle(1300,100,350,660);
        StdDraw.text(1300 , y+430 , "3" );

        //--------------------- AFFICHAGE TEXTE -----------------//
        StdDraw.setPenRadius();
        StdDraw.setFont(plain18);
        
        //Premiere save
        StdDraw.textLeft(-1300-decalageX, y-decalageY , "Event en cours :" +
                traitementReturnCurrentEvent(Sauvegarde.getCurrentEvent(1)));
        StdDraw.textLeft(-1300-decalageX , y-decalageY*2 , "Nom du personnage : " + " wip" );

        //snd save
        StdDraw.textLeft(0-decalageX , y-decalageY , "Event en cours :" +
                traitementReturnCurrentEvent(Sauvegarde.getCurrentEvent(2)) );
        StdDraw.textLeft(0-decalageX , y-decalageY*2 , "Nom du personnage : "+" wip" );


        //third save
        StdDraw.textLeft(1300-decalageX, y-decalageY , "Event en cours :" +
                traitementReturnCurrentEvent(Sauvegarde.getCurrentEvent(3)) );
        StdDraw.textLeft(1300-decalageX , y-decalageY*2 , "Nom du personnage : "  + "wip");


        StdDraw.show();
        fenetreGestionSave(getIndiceSave());
    }

    /**
     * Traite ce qui doit être affiché dans le rectangle de choix de sauvegarde en fonction de ce qui a été renvoyé
     * par Sauvegarde.getCurrentEvent()
     * @param returnCurrentEvent  int de retour de Sauvegarde.getCurrentEvent() [-1 , 1 , 2 , 3]
     * @return un String qui sera affiché dans le rectangle de choix de sauvegarde
     */
    public static String traitementReturnCurrentEvent(int returnCurrentEvent) {
        if(returnCurrentEvent==-1){
            return "no save to load";
        } else {
            return Integer.toString(returnCurrentEvent);
        }
    }

    /**
     * Affichage de l'écran de décision de ce qu'on fait avec la sauvegarde
     * @param nbSave num de la sauvegarde
     * @throws IOException
     */
    public static void fenetreGestionSave(int nbSave) throws IOException {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledRectangle(0,0,400,200);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setFont(bold25);
        StdDraw.text(0,170,"Que voulez vous faire ?");
        StdDraw.setFont(plain15);
        StdDraw.textLeft(-300,130,"Sauvegarde n° "+nbSave);
        StdDraw.setFont(plain18);
        StdDraw.textLeft(-290 , 0 , "Supprimer : x");
        StdDraw.textLeft(-290 , -40 , "Charger à l'évènement " + Sauvegarde.getCurrentEvent(nbSave) + ": v");
        StdDraw.textLeft(-290 , -80 , "Retour : w");

        StdDraw.show();
        AffMethods.fenetreGestionSave(nbSave);
    }

    /**
     * Affichage de l'écran de confirmation qu'on veut bien supprimer la sauvegarde
     */
    public static void entryConfirmDelete() {
        char inChar;
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.filledRectangle(0,0,500,300);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.setFont(bold25);
        StdDraw.text(0 , 200 , "Etes vous sur de supprimer ?");
        StdDraw.text(0,160,"Cette action est définitive.");
        StdDraw.setFont(plain20);
        StdDraw.textLeft(-490 , -40 , "Supprimer : y");
        StdDraw.textLeft(-60 , -40 , "Revenir en arrière et annuler : n");
        StdDraw.show();
    }

    /*--------------------------------------------INVENTORY-------------------------------------*/

    /**
     * Affichage des objets contenus en inventaire
     * @param event  pour le retour au bon event à la fermeture de l'inventaire
     * @param ply  le joueur concerné par l'ouvertur de son inventaire
     */
    public static void displayInventory(int event, Player ply){
        if (event == 3){
            needInventory = true;
        }

        int y = 900;
        player = ply;
        ArrayList<Integer> inventory = ply.getInventory();

        StdDraw.setFont(bold25);
        StdDraw.text(0,1000, "Inventaire :");

        StdDraw.setFont(plain15);
        for (int i = 0; i < inventory.size()-1 ; i++) {
            StdDraw.point(100,y);
            StdDraw.textLeft(120 , y, Stuff.getStuffName(inventory.get(i)));
            y-=40;
        }

        StdDraw.setFont(bold15);
        StdDraw.text(-1000,-1000,"Or : ");
        StdDraw.textLeft(-980 , -1000, Integer.toString(ply.getGold()));
    }



}

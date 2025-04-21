package com.badlogic.citadel.Visual;

import Methods.AffMethods;
import Methods.Player;
import Methods.Sauvegarde;
import Tools.StdDraw;

import java.io.*;

import static Methods.AffMethods.getIndiceSave;
import static Tools.Fonts.*;

public class Affichage {

    private static File file;

    private static int suiteY;

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

    public static double getSuiteY(){
        return suiteY;
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





}

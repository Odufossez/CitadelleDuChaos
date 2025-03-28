package Visual;

import Methods.Player;
import Methods.Sauvegarde;
import Tools.StdDraw;
import java.io.*;
import static Tools.Fonts.*;

public class Affichage {

    private static Sauvegarde save = new Sauvegarde();
    private static File file;

    private static int suiteY;
    private static int choiceY;

    private static Player player;


    /**
     * Initialisation des paramètres d'affichage de la fenêtre StdDraw
     */
    public Affichage() {
        StdDraw.enableDoubleBuffering();
        /*  Paramétrage de la police et de la fenêtre */
        StdDraw.setXscale(-1920,1920);
        StdDraw.setYscale(-1080,1080);
        StdDraw.setCanvasSize(1920,1080);

        suiteY = 1060;

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
        StdDraw.line(1000 ,suiteY-200,1000,suiteY-60); //coté vertical du triangle
        StdDraw.line(1000 , suiteY-60 , 1200 , suiteY-140); // coté diagonal haut
        StdDraw.line(1000 , suiteY-200 , 1200 ,  suiteY-140); //coté diagonal bas
        StdDraw.text(1050 , suiteY-140 , "x");
    }

    /**
     * Fonction pour afficher la flèche permettant de revenir en arrière notamment dans la création du grimoire
     */
    public static void arrowPrev(){
        StdDraw.line(-1000 ,suiteY-200,-1000,suiteY-60); //coté vertical du triangle
        StdDraw.line(-1000 , suiteY-60 , -1200 , suiteY-140); // coté diagonal haut
        StdDraw.line(-1000 , suiteY-200 , -1200 ,  suiteY-140); //coté diagonal bas
        StdDraw.text(-1050 , suiteY-140 , "w");
    }

    /*---------------------------- AFFICHAGE DES ENCARDS DE CHOIX --------------------------------------- */

    //TODO pour la v1.01 aligner sur le centre du rectangle.
    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 2 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     */
    public static void choiceDouble(String choice1 , String choice2){
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
    public static void choiceTriple(String choice1 , String choice2, String choice3){
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
    public static void choiceQuad(String choice1 , String choice2, String choice3 , String choice4){
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
    public static void choiceFive(String choice1 , String choice2, String choice3 , String choice4 , String choice5){
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
     * todo handle un choix sur une save vide (créer une nouvelle save)
     * todo afficher 
     * @throws FileNotFoundException
     */
    public static void choiceSaveLoad() throws IOException {
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
                traitementReturnCurrentEvent(save.getCurrentEvent(1)));
        StdDraw.textLeft(-1300-decalageX , y-decalageY*2 , "Nom du personnage : " + " wip" );

        //snd save
        StdDraw.textLeft(0-decalageX , y-decalageY , "Event en cours :" +
                traitementReturnCurrentEvent(save.getCurrentEvent(2)) );
        StdDraw.textLeft(0-decalageX , y-decalageY*2 , "Nom du personnage : "+" wip" );


        //third save
        StdDraw.textLeft(1300-decalageX, y-decalageY , "Event en cours :" +
                traitementReturnCurrentEvent(save.getCurrentEvent(3)) );
        StdDraw.textLeft(1300-decalageX , y-decalageY*2 , "Nom du personnage : "  + "wip");

        int nbSave = getIndiceSave();

        file = new File("ressources/saves/save_" + nbSave + ".txt");

        if (file.exists()) {
            save.loadSave(nbSave);
        } else {
            CharacterCreator.creationPerso(nbSave);
        }

    }

    /**
     * renvoie le numéro de la save
     * @return
     * @throws IOException
     */
    public static int getIndiceSave() throws IOException{
        char inChar;

        do{
            while (!StdDraw.hasNextKeyTyped()){continue;}
            inChar = StdDraw.nextKeyTyped();
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
                default: break;
            }
        }while(inChar!='&' && inChar!='1' && inChar!='é' && inChar!='2' && inChar!='"' && inChar!='3');
        return 0;
    }

    /**
     * Traite ce qui doit être affiché dans le rectangle de choix de sauvegarde en fonction de ce qui a été renvoyé
     * par Sauvegarde.getCurrentEvent()
     * @param returnCurrentEvent : int de retour de Sauvegarde.getCurrentEvent() [-1 , 1 , 2 , 3]
     * @return un String qui sera affiché dans le rectangle de choix de sauvegarde
     */
    public static String traitementReturnCurrentEvent(int returnCurrentEvent) {
        if(returnCurrentEvent==-1){
            return "no save to load";
        } else {
            return Integer.toString(returnCurrentEvent);
        }
    }
}

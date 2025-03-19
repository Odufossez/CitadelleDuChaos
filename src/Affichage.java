import java.awt.Font;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Affichage {
    private static int suiteY;
    private static int choiceY;

    /**
     * Initialisation des paramètres d'affichage de la fenêtre StdDraw
     */
    public static void paramAffichage() {
        StdDraw.clear();
        /*  Paramétrage de la police et de la fenêtre */
        Font font = new Font("Arial", Font.BOLD , 15);
        StdDraw.setXscale(-1920,1920);
        StdDraw.setYscale(-1080,1080);
        StdDraw.setCanvasSize(1920,1080); //full screen
        suiteY = 1060;

        StdDraw.setTitle("Citadelle du Chaos");
        StdDraw.setFont(font);
    }

    /**
     * Affichage du texte narratif d'event en cours
     * @param path : string menant au fichier .txt contenant le texte
     * @throws IOException : gestion d'une erreur sur le path
     */
    public static void affichageNarration(String path) throws IOException {

        paramAffichage();

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

    public static void afficheMenuPrincipal(){}

    public static int detectClickMainMenu(){return 0;}

    public static void afficheCreationPerso() throws IOException {
        paramAffichage();
        Font font = new Font("Arial", Font.BOLD , 25);
        StdDraw.setFont(font);
        StdDraw.text(100,1000 , "Création du personnage");

        font = new Font("Arial" , Font.PLAIN , 15);
        StdDraw.setFont(font);

        int x=-1000 , y=500;
        int playerHab = Dice.soloDice()+6;
        int playerEnd = Dice.doubleDice() +12;
        int playerLuck = Dice.soloDice() + 6;
        int playerMagic = Dice.doubleDice() + 6;

        StdDraw.text(x,y , "Force du personnage (habilité au combat) : ");
        StdDraw.text(x+450, y , Integer.toString(playerHab));
        y-=40;
        StdDraw.text(x,y , "Endurance du personnage (nombre de points de vie) : ");
        StdDraw.text(x+450,y, Integer.toString(playerEnd));
        y-=40; //ligne du dessous
        StdDraw.text(x,y , "Chance: ");
        StdDraw.text(x+450,y, Integer.toString(playerLuck));
        y-=40;
        StdDraw.text(x,y,"Formules magiques possibles : ");
        StdDraw.text(x+450,y,Integer.toString(playerMagic));
        y-=100;

        font = new Font("Arial" , Font.BOLD , 20);
        StdDraw.setFont(font);
        StdDraw.text(x,y,"Voulez vous relancer les dés ? (Les valeurs changeront)");
        y-=140;

        font = new Font("Arial" , Font.PLAIN , 20);
        StdDraw.text(x,y,"a. Oui, relancer");
        StdDraw.text(x+500,y,"e. Non, continuer");

        while(!StdDraw.hasNextKeyTyped()){continue;}
        switch (StdDraw.nextKeyTyped()){
            case 'a': afficheCreationPerso(); break; //oui
            case 'e': //non
                Player player = new Player();
                player.setVitality(playerEnd);
                player.setHability(playerHab);
                player.setMagic(playerMagic);
                Events.intro(); break; //TODO remplacer intro par écran de choix des sorts
            default: System.exit(1);
        }
    }

    /**
     * Affichage de la fenêtre pour ajouter les sorts au grimoire
     */
    //TODO reprendre des cycloïdes pour l'affichage différé des sorts et des indices
    public static void afficheMakeGrimoire(){

    }


    /**
     * Fonction pour afficher la flèche permettant de passer à la suite
     */
    public static void afficheSuite(){
        StdDraw.line(1000 ,suiteY-200,1000,suiteY-60); //coté vertical du triangle
        StdDraw.line(1000 , suiteY-60 , 1200 , suiteY-140); // coté diagonal haut
        StdDraw.line(1000 , suiteY-200 , 1200 ,  suiteY-140); //coté diagonal bas
    }

    /**
     * Fonction pour afficher la flèche permettant de revenir en arrière notamment dans la création du grimoire
     */
    public static void affichePrec(){
        StdDraw.line(-1000 ,suiteY-200,-1000,suiteY-60); //coté vertical du triangle
        StdDraw.line(-1000 , suiteY-60 , -1200 , suiteY-140); // coté diagonal haut
        StdDraw.line(-1000 , suiteY-200 , -1200 ,  suiteY-140); //coté diagonal bas
    }

    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 2 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     */
    public static void afficheDouble(String choice1 , String choice2){
        StdDraw.rectangle(-1000,-1000,1000,500);
        StdDraw.rectangle(1000,-1000,1000,500);

    }

    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 3 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     * @param choice3 : path vers le txt du choix 3
     */
    public static void afficheTriple(String choice1 , String choice2, String choice3){
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
    public static void afficheQuad(String choice1 , String choice2, String choice3 , String choice4){
        StdDraw.rectangle(-1920,-1000,960,500);
        StdDraw.rectangle(-960,-1000,960,500);
        StdDraw.rectangle(0,-1000,960,500);
        StdDraw.rectangle(960,-1000,960,500);
    }

    /**
     * Affichage des cases de choix correspondant à l'événement en cours comportant 4 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     * @param choice3 : path vers le txt du choix 3
     * @param choice4 : path vers le txt du choix 4
     * @param choice5 : path vers le txt du choix 5
     */
    public static void afficheCinq(String choice1 , String choice2, String choice3 , String choice4 , String choice5){
        int halfWidht = 768;
        StdDraw.rectangle(-1920,-1000,halfWidht,500);
        StdDraw.rectangle(-1152,-1000,halfWidht,500);
        StdDraw.rectangle(-384,-1000,halfWidht,500);
        StdDraw.rectangle(384,-1000,halfWidht,500);
        StdDraw.rectangle(1152,-1000,halfWidht,500);
    }
}

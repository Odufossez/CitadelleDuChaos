import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;



public class Affichage {
    static int suiteY;
    static int choiceY;

    /**
     * Affichage du texte narratif de l'event en cours
     * @param path : string menant au fichier .txt contenant le texte
     * @throws IOException : gestion d'une erreur sur le path
     */
    public static void affichage(String path) throws IOException {
        StdDraw.clear();
        /*  Paramétrage de la police et de la fenêtre */
        Font font = new Font("Arial", Font.BOLD , 15);
        StdDraw.setXscale(-1920,1920);
        StdDraw.setYscale(-1080,1080);
        StdDraw.setCanvasSize(1920,1080); //full screen
        suiteY = 1060;

        StdDraw.setTitle("Citadelle du Chaos");
        StdDraw.setFont(font);

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

    /**
     * Détecte le clicque au bon endroit pour afficher une suite sans choix possible
     * @return un boolean confirmant que le clic a été effectué au bon endroit
     */
    public static boolean detectClickSuite(){
        if (StdDraw.isMousePressed() &&
                (StdDraw.mouseX()>=1000 && StdDraw.mouseX()<=1200) &&
                (StdDraw.mouseY()>=suiteY-200 && StdDraw.mouseY()<=suiteY-60)){
            return true;
        } else return false;
    }

    /**
     * Fonction pour afficher la flèche permettant de passer à la suite
     */
    public static void afficheSuite(){
        /* Triangle suite du texte*/
        StdDraw.line(1000 ,suiteY-200,1000,suiteY-60); //coté vertical du triangle
        StdDraw.line(1000 , suiteY-60 , 1200 , suiteY-140); // coté diagonal haut
        StdDraw.line(1000 , suiteY-200 , 1200 ,  suiteY-140); //coté diagonal bas
    }

    /**
     * Affichage des cases de choix correspondant à l'évenement en cours comportant 2 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     * @return indice de choix
     */
    public static int afficheDouble(String choice1 , String choice2){
        StdDraw.rectangle(-1000,-1000,1000,500);
        StdDraw.rectangle(1000,-1000,1000,500);

        return  0;
    }

    /**
     * Affichage des cases de choix correspondant à l'évenement en cours comportant 3 choix
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

    public static int detectClickTriple(){
        if (StdDraw.isMousePressed()){
            if ((StdDraw.mouseX()>=-1920 && StdDraw.mouseX()<=-640) &&
                    (StdDraw.mouseY()>=-1000 && StdDraw.mouseY()<=-500)){
                return 1;
            } else if ((StdDraw.mouseX()>=-640 && StdDraw.mouseX()<=-0) &&
                    (StdDraw.mouseY()>=-1000 && StdDraw.mouseY()<=-500)){
                return 2;
            } else if ((StdDraw.mouseX()>=0 && StdDraw.mouseX()<=640) &&
                    (StdDraw.mouseY()>=-1000 && StdDraw.mouseY()<=-500)) {
                return 3;
            }
        }
        return 0;
    }

    /**
     * Affichage des cases de choix correspondant à l'évenement en cours comportant 4 choix
     * @param choice1 : path vers le txt du choix 1
     * @param choice2 : path vers le txt du choix 2
     * @param choice3 : path vers le txt du choix 3
     * @param choice4 : path vers le txt du choix 4
     * @return indice du choix fait
     */
    public static int afficheQuad(String choice1 , String choice2, String choice3 , String choice4){
        StdDraw.rectangle(-1920,-1000,960,500);
        StdDraw.rectangle(-960,-1000,960,500);
        StdDraw.rectangle(0,-1000,960,500);
        StdDraw.rectangle(960,-1000,960,500);

        return 0;
    }

    public static int afficheCinq(String choice1 , String choice2, String choice3 , String choice4 , String choice5){
        int halfWidht = 768;
        StdDraw.rectangle(-1920,-1000,halfWidht,500);
        StdDraw.rectangle(-1152,-1000,halfWidht,500);
        StdDraw.rectangle(-384,-1000,halfWidht,500);
        StdDraw.rectangle(384,-1000,halfWidht,500);
        StdDraw.rectangle(1152,-1000,halfWidht,500);

        return 0;
    }
}

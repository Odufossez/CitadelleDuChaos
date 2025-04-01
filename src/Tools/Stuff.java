package Tools;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import static Tools.PathsTo.pathToTableurs;

public class Stuff {
    private static String stuff[][] = new String[15][2];
    private static boolean eventStuff[][] = new boolean[15][400];
    private static ArrayList<Integer> interactivStuff = new ArrayList<Integer>();

    public Stuff() throws FileNotFoundException {
        stuff[0][0] = "Dague enchantée";                stuff[0][1] = "Inflige 2 dégâts automatique, est détruit après utilisation";
        stuff[1][0] = "Onguent noir";                   stuff[1][1] = "Deux utilisations de magie gratuites";
        stuff[2][0] = "Brosse à cheveux";               stuff[2][1] = "Une brosse à cheveux rafinée";
        stuff[3][0] = "Essence de berce";               stuff[3][1] = "Repousse les créatures de pierre";
        stuff[4][0] = "Epée +1";                        stuff[4][1] = "+1 en force d'attaque";
        stuff[5][0] = "Epée +2";                        stuff[5][1] = "+2 en force d'attaque";
        stuff[6][0] = "Epée basique";                   stuff[6][1] = "+0 en force d'attaque";
        stuff[7][0] = "Bocal Homme-Araignée";           stuff[7][1] = "Un bocal avec une araignée au visage humain";
        stuff[8][0] = "Liquide vert";                   stuff[8][1] = "";
        stuff[9][0] = "Myriade";                        stuff[9][1] = "";
        stuff[10][0] = "Poignée de baies";              stuff[10][1] = "";
        stuff[11][0] = "Miroir d'argent";               stuff[11][1] = "";
        stuff[12][0] = "Clé de cuivre";                 stuff[12][1] = "";
        stuff[13][0] = "Toison d'or";                   stuff[13][1] = "";
        stuff[14][0] = "Amulette ensorcelée";           stuff[14][1] = "";

        File tabStuff = new File(pathToTableurs + "stuff.csv");
        Scanner scanLine = new Scanner(tabStuff);
        Scanner scanChar = new Scanner(scanLine.nextLine());

        while (scanLine.hasNextLine()){
            for (int i = 0; i < 15 ; i++) { //lines
                for (int j = 0 ; j <400 ; j++){
                    if(scanChar.nextInt() == 1){
                        eventStuff[i][j] = true;
                    } else {
                        eventStuff[i][j] = false;
                    }
                }
            }
        }
    }

    public static String getStuffName(int indObj){
        return stuff[indObj][0];
    }

    public static String getStuffDescription(int indObj){
        return stuff[indObj][1];
    }

    /**
     * Retourne la liste des objets utilisables à l'évent spécifié
     * @param indiceEvent un entier représentant le numéro de l'évent
     * @return une array list des entiers indice objet concerné par l'event
     */
    public static ArrayList<Integer> getItemInEvent(int indiceEvent){
        interactivStuff = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (eventStuff[i][indiceEvent]) {
                interactivStuff.add(i);
            }
        }
        return interactivStuff;
    }

}

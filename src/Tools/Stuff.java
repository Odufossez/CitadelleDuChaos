package Tools;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import static Tools.PathsTo.pathToTableurs;

public class Stuff {
    private static String stuff[][] = new String[14][2];
    private static boolean eventStuff[][] = new boolean[400][14];

    public Stuff() throws FileNotFoundException {
        stuff[0][0] = "Dague enchantée";                stuff[0][1] = "Inflige 2 dégâts automatique, est détruit après utilisation";
        stuff[1][0] = "Onguent noir";                   stuff[1][1] = "Deux utilisations de magie gratuites";
        stuff[2][0] = "Brosse à cheveux";               stuff[2][1] = "Une brosse à cheveux rafinée";
        stuff[3][0] = "Essence de berce";               stuff[3][1] = "Repousse les créatures de pierre";
        stuff[4][0] = "Epée +1";                        stuff[4][1] = "+1 en force d'attaque";
        stuff[5][0] = "Epée +2";                        stuff[5][1] = "+2 en force d'attaque";
        stuff[6][0] = "Epée basique";                   stuff[6][1] = "+0 en force d'attaque";
        stuff[7][0] = "Bocal Homme-Araignée";           stuff[7][1] = "Un bocal avec une araignée au visage humain";
        stuff[8][0] = "Myriade";                        stuff[9][1] = "";
        stuff[9][0] = "Poignée de baies";              stuff[10][1] = "";
        stuff[10][0] = "Miroir d'argent";               stuff[11][1] = "";
        stuff[11][0] = "Clé de cuivre";                 stuff[12][1] = "";
        stuff[12][0] = "Toison d'or";                   stuff[13][1] = "";
        stuff[13][0] = "Amulette ensorcelée";           stuff[14][1] = "";

        File tabStuff = new File(pathToTableurs + "items.csv");
        Scanner scanLine = new Scanner(tabStuff);
        Scanner scanChar ;

        while (scanLine.hasNextLine()){
            for (int i = 0; i < 15 ; i++) { //lines
                scanChar = new Scanner(scanLine.nextLine());
                for (int j = 0 ; j <399 ; j++){
                    if (scanChar.hasNextInt()){
                        if(scanChar.nextInt() == 1){
                            eventStuff[j][i] = true;
                        } else {
                            eventStuff[j][i] = false;
                        }
                    } else {
                        scanChar.next();
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

    public static boolean getStuffInEvent(int event, int indiceStuff){
        return eventStuff[indiceStuff][event-1];
    }

    /**
     * Renvoie une liste des events intéractif associé à l'objet
     * @param indiceStuff : indiece de l'obj
     * @return
     */
    public static ArrayList<Integer> fromEvents(int indiceStuff){
        ArrayList<Integer> fromEvents = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            if (eventStuff[indiceStuff][i]) {
                fromEvents.add(i++);
            }
        }
        return fromEvents;
    }

    /**
     * Méthode pour savoir si l'event a au moins un objet utilisable
     * @param event : le numéro de lévent
     * @return true si y a un objet false sinon
     */
    public static boolean eventHasStuff(int event){
        for (int i = 0; i < 15; i++) {
            if (eventStuff[event-1][i]){
                return true;
            }
        }
        return false;
    }

}

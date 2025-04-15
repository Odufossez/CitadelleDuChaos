package Items;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Stuff {
    private static String stuff[][] = new String[14][2];
    private static boolean eventStuff[][] = new boolean[400][14];


    public Stuff() throws FileNotFoundException {

    }

    public static String getStuffName(int indObj){
        return stuff[indObj][0];
    }

    public static String getStuffDescription(int indObj){
        return stuff[indObj][1];
    }

    public static boolean getStuffInEvent(int event, Item item){
        int[] tabEvent = Item.getTabEvent();
        for (int e : tabEvent){
            if (e==event){
                return true;
            }
        }
        return false;
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

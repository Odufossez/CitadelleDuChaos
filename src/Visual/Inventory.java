package Visual;

import Methods.InventoryMethods;
import Methods.Player;
import Tools.ReadingInChar;
import Tools.Spells;
import Tools.StdDraw;
import Tools.Stuff;

import java.util.ArrayList;

public class Inventory {
    private static ArrayList<Integer> inventory = new ArrayList<>();
    private static int[] spellBook;

    public Inventory() {

    }

    public static int displayInventory(Player ply){
        Affichage.arrowPrev();
        int y = 1000;
        int x = -950;
        int flag = 0;

        inventory = ply.getInventory();
        for (int i = 0; i < inventory.size() ; i++) {
            if ( ply.getCurrentEvent()!=0 && Stuff.getStuffInEvent(ply.getCurrentEvent(), inventory.get(i))) {
                StdDraw.setPenColor(StdDraw.RED);
            }
            StdDraw.textLeft(-1050,y, Character.toString(ReadingInChar.tabAlphabet[i]));
            StdDraw.textLeft(x,y,Stuff.getStuffName(inventory.get(i)));
            StdDraw.setPenColor(StdDraw.BLACK);
            y-=40;
            flag = i;
        }

        y=1000;
        x = 950;
        spellBook = ply.getSpells();
        for (int i = 0; i < spellBook.length; i++) {
            if (ply.getCurrentEvent()!=0 && Spells.getSpellInEvent(ply.getCurrentEvent(),spellBook[i])) {
                StdDraw.setPenColor(StdDraw.BLUE);
            }
            StdDraw.textLeft(800,y, Character.toString(ReadingInChar.tabAlphabet[i+inventory.size()]));
            StdDraw.textLeft(x,y,Spells.getSpellName(spellBook[i]));
            StdDraw.setPenColor(StdDraw.BLACK);
            y-=40;
        }

        StdDraw.show();
        return flag;
    }
}

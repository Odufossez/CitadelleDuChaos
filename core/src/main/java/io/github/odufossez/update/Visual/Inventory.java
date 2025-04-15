package Visual;

import Methods.Player;
import Methods.SpellBook;
import Spells.SpellList;
import Tools.ReadingInChar;
import Tools.OutilsSorts;
import Tools.StdDraw;
import Items.Stuff;

import java.util.ArrayList;

public class Inventory {
    private static Methods.Inventory inventory;
    private static SpellBook grimoire;

    public Inventory() {

    }

    public static int displayInventory(Player ply){
        Affichage.arrowPrev();
        int y = 1000;
        int x = -950;
        int flag = 0;

        inventory = ply.getInventory();
        for (int i = 0; i < inventory.getSize() ; i++) {
            if ( ply.getCurrentEvent()!=0 && Stuff.getStuffInEvent(ply.getCurrentEvent(), inventory.getItem(i))) {
                StdDraw.setPenColor(StdDraw.RED);
            }
            StdDraw.textLeft(-1050,y, Character.toString(ReadingInChar.tabAlphabet[i]));
            StdDraw.textLeft(x,y,inventory.getItem(i).toString());
            StdDraw.setPenColor(StdDraw.BLACK);
            y-=40;
            flag = i;
        }

        y=1000;
        x = 950;
        grimoire = ply.getGrimoire();
        for (int i = 0; i < grimoire.length; i++) {
            if (ply.getCurrentEvent()!=0 && SpellList.sortInEvent(i, ply.getCurrentEvent())) {
                StdDraw.setPenColor(StdDraw.BLUE);
            }
            StdDraw.textLeft(800,y, Character.toString(ReadingInChar.tabAlphabet[i+inventory.getSize()]));
            StdDraw.textLeft(x,y, grimoire.getSpell(i).toString());
            StdDraw.setPenColor(StdDraw.BLACK);
            y-=40;
        }

        StdDraw.show();
        return flag;
    }
}

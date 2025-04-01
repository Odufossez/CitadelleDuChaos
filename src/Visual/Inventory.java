package Visual;

import Methods.Player;
import Tools.StdDraw;

import java.util.ArrayList;

public class Inventory {
    Player ply;
    ArrayList<Integer> inventory = new ArrayList<>();

    Inventory(Player ply) {
        this.ply = ply;
    }

    public void displayInventory(){
        inventory = ply.getInventory();
        for (int i = 0; i < inventory.size() ; i++) {
            if () {}
        }
    }
}

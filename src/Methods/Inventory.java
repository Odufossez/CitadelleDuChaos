package Methods;

import Items.Item;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> inventory;

    Inventory(){
        inventory = new ArrayList<>();
    }

    public void putIn(Item i) {
        inventory.add(i);
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }

    public void removeFrom(Item i) {
        inventory.remove(i);
    }

    public int getSize() {
        return inventory.size();
    }

    public Item getItem(int indice){
        return inventory.get(indice);
    }
}

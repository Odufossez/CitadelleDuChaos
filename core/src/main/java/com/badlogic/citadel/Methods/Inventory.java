package com.badlogic.citadel.Methods;

import com.badlogic.citadel.Item;
import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> inventory;

    Inventory(){
        inventory = new ArrayList<>();
    }

    /**
     * Check if the item is already in the inventory, if yes does not add the item to the inventory to avoid
     * duplications.
     * IT IS NOT REQUIRED TO ADD MANUALLY THE ITEM AFTER HAND, THE METHOD DOES IT IF THE ITEM IS NOT IN THE INVENTORY
     * @param i the item that you want to add to the inventory
     * @return 1 if the item is already in the inventory, else return 0
     */
    public int putIn(Item i) {
        for(Item item : inventory){
            if(item.getName().equals(i.getName())){
                return 1;
            }
        }
        inventory.add(i);
        return 0;
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

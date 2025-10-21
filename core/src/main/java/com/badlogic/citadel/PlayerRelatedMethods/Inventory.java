package com.badlogic.citadel.PlayerRelatedMethods;

import com.badlogic.citadel.Item;
import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item.Items> inventory;

    Inventory(){
        inventory = new ArrayList<>();
    }

    /**
     * Check if the item is already in the inventory, if yes does not add the item to the inventory to avoid
     * duplications.
     * IT IS NOT REQUIRED TO ADD MANUALLY THE ITEM AFTER HAND, THE METHOD DOES IT IF THE ITEM IS NOT IN THE INVENTORY
     *
     * @param i the item that you want to add to the inventory
     */
    public void putIn(Item.Items i) {
        for(Item.Items item : inventory){
            if(item.equals(i)){
                return;
            }
        }
        inventory.add(i);
    }

    public ArrayList<Item.Items> getInventory(){
        return inventory;
    }

    public void removeFrom(Item.Items i) {
        inventory.remove(i);
    }

    public int getSize() {
        return inventory.size();
    }

}

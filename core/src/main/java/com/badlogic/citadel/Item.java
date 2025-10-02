package com.badlogic.citadel;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.util.ArrayList;
public class Item implements Comparable{
    protected String name;
    protected String description;
    protected int numero; //must be unique for each item
    protected boolean isDansInventaire;
    protected ArrayList<Integer> usages;
    protected TextButton buttonUse;

    public enum Items{
        ALCHEMIST_HEALING_BALM,
        BERRIES,
        CHARMED_AMULET,
        ENCHANTED_BRUSH,
        ENCHANTED_THROWING_DAGGER,
        EXOTIC_FRUITS,
        FRUIT_OF_SILENCE,
        HALLUCINATING_POTION,
        HOGWEED,
        HOGWEED_ESSENCE,
        JEWEL_OF_LIGHT,
        NEEDLE_KNIFE,
        POCKET_MYRIADE,
        RING_OF_SWORDSMANSHIP,
        SLUMBERBERRY,
        SWORD
    }

    Item(String name, String description, int numero) {
        this.name = name;
        this.description = description;
        this.numero = numero;
        this.isDansInventaire = false;
        this.usages = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getNumero() {
        return numero;
    }

    public void setEtat(boolean etat) {
        isDansInventaire = etat;
    }

    public boolean isDansInventaire() {
        return isDansInventaire;
    }

    public void setUsages(ArrayList<Integer> uses) {
        usages = uses;
    }

    /**
     * Return true if the item can be useful in this event
     * usages is a table of int which represent the events where the
     * item can be use
     * @param event current event
     * @return true if the item is useful in the current event
     */
    public boolean inEvent(int event){
        for (int usage: usages) {
            if (event == usage) {
                return true;
            }
        }
        return false;
    }

    public void setButtonUse(TextButton btt){
        buttonUse = btt;
    }

    public TextButton getButton(){
        return buttonUse;
    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Item){
            Item item = (Item) o;
            return this.numero - item.numero;
        }
        return 0;
    }
}

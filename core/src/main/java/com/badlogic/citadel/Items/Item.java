package com.badlogic.citadel.Items;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Item {
    protected String name;
    protected String description;
    protected int numero;
    protected boolean isDansInventaire;
    protected int[] usages;
    protected TextButton buttonUse;

    Item(String name, String description, int numero) {
        this.name = name;
        this.description = description;
        this.numero = numero;
        this.isDansInventaire = false;
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
}

package com.badlogic.citadel.Visual;

import Methods.Player;
import Tools.StdDraw;

import static EventsCdC.Events.getUsableObject;
import static Tools.StdDraw.*;

public class HUD {
    private static Player ply;

    public HUD(Player ply){
        this.ply = ply;
        health();
        luck();
        inventory();
        show();
    }

    /**
     * Affiche en permanence sur l'écran la vie
     */
    private static void health(){
        //TODO for futur versions set a bar of life rather than just numbers
        setPenColor(StdDraw.RED);
        String vie = ply.getCurrentVitality()+"/"+ply.getVitality();
        StdDraw.textLeft(-900,-780,vie);
    }

    /**
     * Affiche en permanence sur l'écran la chance
     */
    private static void luck(){
        setPenColor(StdDraw.GREEN);
        String luck = ply.getCurrentLuck() + "/"+ ply.getLuck();
        StdDraw.textLeft(-700,-780,luck);
    }

    /**
     * Affiche en permanence sur l'écran le bouton pour l'inventaire
     */
    private static void inventory(){
        if (getUsableObject()){
            setPenColor(PURPLE);
        } else {
            setPenColor(BLACK);
        }
        textLeft(-600 , -780 , "i : ouvrir l'inventaire");
    }
}

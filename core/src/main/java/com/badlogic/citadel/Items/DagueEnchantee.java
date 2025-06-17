package com.badlogic.citadel.Items;

import com.badlogic.citadel.Screens.Skins;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class DagueEnchantee extends Item{

    DagueEnchantee(String name, String description,int numero) {
        super("dagueMagique", description,5);
        setButtonUse(new TextButton("Dague enchantée" , Skins.PLAIN_JAMES_SKIN));
    }

    //todo ajouter les utilisations de la dague ici
}

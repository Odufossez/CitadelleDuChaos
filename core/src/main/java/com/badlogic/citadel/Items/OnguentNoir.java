package com.badlogic.citadel.Items;

import com.badlogic.citadel.Screens.Skins;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class OnguentNoir extends Item {

    private final int[] utilisations = {1,2,3,4}; //todo exemple à changer

    OnguentNoir(String name, String description, int numero) {
        super(name, description, numero);
        setButtonUse(new TextButton("Onguent noir" , Skins.PLAIN_JAMES_SKIN));
    }

    public int[] getUtilisations() {
        return utilisations;
    }
}

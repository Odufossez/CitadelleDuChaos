package com.badlogic.citadel.Items;

import com.badlogic.citadel.Screens.Skins;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class PoigneeBaies extends Item{
    PoigneeBaies(String name, String description, int numero) {
        super(name, description, numero);
        setButtonUse(new TextButton("Baies" , Skins.PLAIN_JAMES_SKIN));
    }
}

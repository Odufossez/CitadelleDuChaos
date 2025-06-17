package com.badlogic.citadel.Items;

import com.badlogic.citadel.Screens.Skins;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Myriade extends Item{

    Myriade(String name, String description, int numero) {
        super(name, description, numero);
        setButtonUse(new TextButton("Myriade" , Skins.PLAIN_JAMES_SKIN));
    }
}

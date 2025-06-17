package com.badlogic.citadel.Items;

import com.badlogic.citadel.Screens.Skins;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class MiroirArgent extends Item{
    MiroirArgent(String name, String description, int numero) {
        super("miroir", description, 8);
        setButtonUse( new TextButton("Miroir en argent" , Skins.PLAIN_JAMES_SKIN));
    }
}

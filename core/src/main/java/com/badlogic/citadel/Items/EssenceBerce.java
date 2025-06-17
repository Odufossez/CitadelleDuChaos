package com.badlogic.citadel.Items;

import com.badlogic.citadel.Screens.Skins;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class EssenceBerce extends Item {
    private int[] usages = {};

    EssenceBerce(String name, String description, int numero) {
        super("essenceBerce", description, 7);
        setButtonUse(new TextButton("Essence de berce" , Skins.PLAIN_JAMES_SKIN));

    }
}

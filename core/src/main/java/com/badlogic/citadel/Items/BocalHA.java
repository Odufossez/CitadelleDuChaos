package com.badlogic.citadel.Items;

import com.badlogic.citadel.Screens.Skins;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class BocalHA extends Item{

    public BocalHA() {
        super("bocalHA", "", 2);
        setButtonUse(new TextButton("Bocal de l'homme-araignée" , Skins.PLAIN_JAMES_SKIN));
    }
}


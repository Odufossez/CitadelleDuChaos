package com.badlogic.citadel.Items;

import com.badlogic.citadel.Screens.Skins;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class BrosseACheveux extends Item {
    BrosseACheveux(String name, String description, int numero) {
        super("BrosseCheveux", description, 3);
        setButtonUse(new TextButton("Brosse à cheveux" , Skins.PLAIN_JAMES_SKIN));
        super.usages = new int[]{};
    }
}

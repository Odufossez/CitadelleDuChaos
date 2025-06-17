package com.badlogic.citadel.Items;

import com.badlogic.citadel.Screens.Skins;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class CleCuivre extends Item{
    CleCuivre(String name, String description, int numero) {
        super("cleCuivre", description, 4);
        setButtonUse(new TextButton("Cle de cuivre" , Skins.PLAIN_JAMES_SKIN));
    }
}

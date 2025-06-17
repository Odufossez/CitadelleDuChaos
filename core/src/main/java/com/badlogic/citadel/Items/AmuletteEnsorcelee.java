package com.badlogic.citadel.Items;

import com.badlogic.citadel.Screens.Skins;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class AmuletteEnsorcelee extends Item{

    private int[] tabEvent = {322};

    public AmuletteEnsorcelee() {
        super("amuletteEnsorcelee", "description", 1);
        setButtonUse(new TextButton("Amulette Ensorcelée" , Skins.PLAIN_JAMES_SKIN));
    }
}

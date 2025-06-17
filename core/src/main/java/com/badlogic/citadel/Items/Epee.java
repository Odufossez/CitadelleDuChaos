package com.badlogic.citadel.Items;

import com.badlogic.citadel.Screens.Skins;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Epee extends Item{

    private static int niveau;

    Epee(String name, String description, int numero) {
        super("sword", description, 6);
        niveau = 0;
        setButtonUse(new TextButton("Sword" , Skins.PLAIN_JAMES_SKIN));
    }

   public void upgrade(){
        niveau++;
   }

}

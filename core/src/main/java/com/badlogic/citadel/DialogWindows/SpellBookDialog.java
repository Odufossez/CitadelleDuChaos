package com.badlogic.citadel.DialogWindows;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.PlayerRelatedMethods.Player;
import com.badlogic.citadel.PlayerRelatedMethods.SpellBook;
import com.badlogic.citadel.PlayerRelatedMethods.SpellList;
import com.badlogic.citadel.Screens.Skins;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class SpellBookDialog extends Dialog {
    Citadel game;
    private Player ply;
    private SpellBook spellBook;

    private final float button_height = (float) (60);
    private final float button_width = (float) (150);
    private final float button_pad_h = (float) (10);

    public SpellBookDialog(Citadel game){
        super("Spellbook" , Skins.PLAIN_JAMES_SKIN);
        this.game = game;
        ply = game.getPlayer();
        create();
    }

    public void create(){
        if (ply.getGrimoire() == null){
            this.text("You don't have anymore spells");
        } else {
            for (SpellList.Sorts sort : ply.getGrimoire().getGrimoire()) {
                if (sort == null) continue;
                add(SpellList.getName(sort));
                row();
            }
        }
    }

    public void button(String text, InputListener listener){
        TextButton button = new TextButton(text, Skins.PLAIN_JAMES_SKIN);
        button.setSize(button_width, (44 * Citadel.density));
        button.addListener(listener);
        button.padLeft(button_pad_h);
        button.padRight(button_pad_h);

        getButtonTable().add(button).height(button_height);
        getButtonTable().row();
    }
}

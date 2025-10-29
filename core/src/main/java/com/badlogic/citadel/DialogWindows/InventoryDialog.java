package com.badlogic.citadel.DialogWindows;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.Item;
import com.badlogic.citadel.PlayerRelatedMethods.Player;
import com.badlogic.citadel.Screens.Skins;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import java.util.ArrayList;

public class InventoryDialog extends Dialog {
    Citadel game;
    private Player ply;
    private ArrayList<Item> inventory;

    private final float button_height = (float) (60);
    private final float button_width = (float) (150);
    private final float button_pad_h = (float) (10);

    public InventoryDialog(Citadel game) {
        super("Inventory" , Skins.PLAIN_JAMES_SKIN);
        this.game = game;
        ply = game.getPlayer();
        create();
    }

    private void create() {
        if (ply.getInventory() == null || ply.getInventory().getInventory().isEmpty()){
            this.text("Inventory is empty.");
        } else {
            for (Item.Items item : ply.getInventory().getInventory()) {
                add(item.toString().toLowerCase());
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
        getButtonTable().top().left();
    }



}

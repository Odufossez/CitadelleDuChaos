package com.badlogic.citadel.Methods;

import com.badlogic.citadel.Citadel;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.awt.*;

import static com.badlogic.citadel.Screens.Skins.PLAIN_JAMES_SKIN;

public class DialogAlert extends Dialog {

    //https://www.catalinmunteanu.com/design-custom-dialog-libgdx.html

    private float dialog_width = (float)(430* Citadel.density);
    private float dialog_height = (float)(200*Citadel.density);
    private float dialog_padding = (float)(5*Citadel.density);
    private float button_height = (float)(40*Citadel.density);
    private float button_width = (float)(100*Citadel.density);
    private float button_pad_h = (float)(10*Citadel.density);

    public DialogAlert(String title, Skin skin) {
        super(title, skin);
        setup();
    }

    //set certain sizes and options
    void setup() {
        padLeft(dialog_padding);
        padRight(dialog_padding);
        padBottom(dialog_padding);
        getButtonTable().defaults().height(button_height);
        getContentTable().defaults().width(dialog_width);

        setModal(true);
        setMovable(false);
        setResizable(false);
    }

    //set the properties of the description Label
    @Override
    public DialogAlert text(String text){
        Label label = new Label(text , PLAIN_JAMES_SKIN);
        label.setWrap(true);
        label.setWidth(dialog_width-dialog_padding*2);

        text(label);

        return this;
    }

    /**
     * The button to accept the intended action and proceed
     * the action might be either :
     * - usage of a spell
     * - usage of an item
     * Either during a dialog, an event or in combat
     * @param btnText the text displayed on the button
     * @param listener the listener of the button
     * @return a button all done for the dialogAlert box
     */
    public DialogAlert button(String btnText , Color color , InputListener listener){
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = Citadel.font;
        style.fontColor = color;

        TextButton button = new TextButton(btnText, style);
        button.setSize(button_width, (44*Citadel.density));
        button.addListener(listener);
        button.padLeft(button_pad_h);
        button.padRight(button_pad_h);

        button(button);

        return this;
    }


    @Override
    public float getPrefWidth() {
        return dialog_width;
    }
    @Override
    public float getPrefHeight() {
        return dialog_height;
    }
}

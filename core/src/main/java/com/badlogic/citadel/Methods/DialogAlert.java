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

    private float dialog_width = (float)(260* Citadel.density);
    private float dialog_height = (float)(180*Citadel.density);
    private float dialog_padding = (float)(20*Citadel.density);
    private float button_height = (float)(40*Citadel.density);
    private float button_width = (float)(200*Citadel.density);
    private float button_pad_h = (float)(15*Citadel.density);

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
     * The button to accept the intented action and proceed
     * the action might be either :
     * - usage of a spell
     * - usage of an item
     * Either during a dialog, an event or in combat
     * @param btnText
     * @param listener
     * @return
     */
    public DialogAlert buttonYes(String btnText , InputListener listener){
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = Citadel.font;
        style.fontColor = Color.RED;

        TextButton button = new TextButton(btnText, style);
        button.setSize(button_width, (float)(44*Citadel.density));
        button.addListener(listener);
        button.padLeft(button_pad_h);
        button.padRight(button_pad_h);


        button(button);

        return this;
    }

    public DialogAlert buttonNo(String btnTxt , InputListener listener){
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = Citadel.font;
        style.fontColor = Color.GREEN;

        TextButton button = new TextButton(btnTxt, style);
        button.setSize(button_width, (float)(44*Citadel.density));
        button.addListener(listener);
        button.padLeft(button_pad_h);
        button.padRight(button_pad_h);

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

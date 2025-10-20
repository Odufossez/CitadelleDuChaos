package com.badlogic.citadel.Methods;
import com.badlogic.citadel.Citadel;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import static com.badlogic.citadel.Screens.Skins.PLAIN_JAMES_SKIN;

public class DialogBox extends Dialog {
    private final float dialog_width = (float) 1000;
    private final float dialog_height = (float) 200;
    private final float dialog_padding = 0;
    private final float button_height = (float)(40);
    private final float button_width = (float)(100);
    private final float button_pad_h = (float)(10);


    public DialogBox(String title, Skin skin){
        super(title, skin);
        setup();
    }

    void setup(){
        padLeft(dialog_padding);
        padRight(dialog_padding);
        padBottom(dialog_padding);
        getButtonTable().defaults().height(button_height);
        getButtonTable().defaults().width(dialog_width);
        //super.setPosition(0,0);

        setModal(true);
        setMovable(false);
        setResizable(false);

    }

    @Override
    public DialogBox text(String text){
        Label label = new Label(text , PLAIN_JAMES_SKIN);
        label.setWrap(true);
        label.setWidth(dialog_width-dialog_padding*2);
        text(label);
        return this;
    }

    public void button(String text, InputListener listener){
        TextButton button = new TextButton(text, PLAIN_JAMES_SKIN);
        button.setSize(button_width, (44* Citadel.density));
        button.addListener(listener);
        button.padLeft(button_pad_h);
        button.padRight(button_pad_h);
        button.addListener(listener);
        button(button);
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

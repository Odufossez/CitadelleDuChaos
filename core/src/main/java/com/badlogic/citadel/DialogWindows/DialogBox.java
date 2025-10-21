package com.badlogic.citadel.DialogWindows;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;

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

    @Override
    public Dialog show(Stage stage){
        super.show(stage);
        //positionnement bas-centre
        setPosition(
            (Gdx.graphics.getWidth() - dialog_width) / 2 ,
            0
        );
        return this;
    }

    void setup(){
        padLeft(dialog_padding);
        padRight(dialog_padding);
        padBottom(dialog_padding);
        getButtonTable().defaults().minWidth(button_width);
        getButtonTable().defaults().minHeight(button_height);
        getButtonTable().defaults().pad(5);

        this.getTitleTable().padLeft(20);
        getContentTable().defaults().width(dialog_width - dialog_padding * 2);
        getContentTable().defaults().pad(10,30,10,10); //padding sur le contenu du dialog
        this.setWidth(this.getPrefWidth());

        setModal(true);
        setMovable(false);
        setResizable(false);
    }

    /**
     * Generate a box dialog located in 0,0 with a text
     * @param text the text to display
     * @return a dialog box with the text
     */
    @Override
    public DialogBox text(String text){
        Label label = new Label(text , PLAIN_JAMES_SKIN);
        label.setWrap(true);
        text(label);
        return this;
    }

    /**
     * Generate a button with a text and an action listener
     * @param text the text to display on the button
     * @param listener the actions the button will perform
     */
    public void button(String text, InputListener listener){
        TextButton button = new TextButton(text, PLAIN_JAMES_SKIN);
        button.padLeft(button_pad_h);
        button.padRight(button_pad_h);
        button.getLabel().setAlignment(Align.center);
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

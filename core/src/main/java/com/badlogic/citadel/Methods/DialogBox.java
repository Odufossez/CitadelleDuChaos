package com.badlogic.citadel.Methods;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;

import static com.badlogic.citadel.Screens.Skins.PLAIN_JAMES_SKIN;

public class DialogBox extends Dialog {
    private final float dialog_width = 1920;
    private final float dialog_height = 200;
    private final float dialog_padding = 0;


    public DialogBox(String title, Skin skin){
        super(title, skin);
        setup();
    }

    void setup(){
        padLeft(dialog_padding);
        padRight(dialog_padding);
        padBottom(dialog_padding);
        super.setPosition(0,1080);

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
}

package com.badlogic.citadel.Screens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.Methods.DialogBox;
import com.badlogic.citadel.Methods.RedirectionEvent;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.IOException;

import static com.badlogic.citadel.Screens.Skins.PLAIN_JAMES_SKIN;

public class IntroGameScreen extends ApplicationAdapter implements Screen {

    private final Citadel game;
    private final Stage stage;

    public IntroGameScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void create() {
        final DialogBox dialogIntro = new DialogBox("Test" , PLAIN_JAMES_SKIN);
        dialogIntro.getTitleTable().padLeft(20);
        dialogIntro.setWidth(dialogIntro.getPrefWidth());
        dialogIntro.text("Ceci est un test de dialog box");
        dialogIntro.button("Next (test)" , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                stage.clear();
                game.changeScreen(Citadel.EVENT1);
                return true;
            }
        });
        stage.addActor(dialogIntro);
    }

    private void input(){

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}

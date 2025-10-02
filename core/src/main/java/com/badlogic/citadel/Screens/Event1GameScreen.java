package com.badlogic.citadel.Screens;

import com.badlogic.citadel.Citadel;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import static com.badlogic.citadel.Screens.Skins.PLAIN_JAMES_SKIN;

public class Event1GameScreen extends ApplicationAdapter implements Screen {
    Citadel game;
    private Stage stage;
    private Dialog sceneDialog;
    private Skin skin;

    public Event1GameScreen(Citadel game){
        this.game = game;
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {
        /*
        * The screen must show first the back ground then the texts
        * and add lastly the HUD
        * */
        Gdx.input.setInputProcessor(stage);

        //Temporary
        TextButton nextEvent = new TextButton("Test retourne Main menu" , PLAIN_JAMES_SKIN); //todo texte ne s'affiche pas ?

        stage.addActor(nextEvent);
        nextEvent.align(Align.bottom);
        nextEvent.padLeft(1000);

        nextEvent.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.changeScreen(Citadel.MAINMENU);
            }
        });

        new HUD(game.getPlayer(), game.batch , game);

    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        game.batch.begin();
        game.titleFont.draw(game.batch, "Event 1" , Gdx.graphics.getWidth()*0.25f, Gdx.graphics.getHeight()*0.3f);
        game.batch.end();
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {
        stage.getViewport().update(i, i1, true);
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

    }
}

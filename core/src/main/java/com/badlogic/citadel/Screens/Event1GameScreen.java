package com.badlogic.citadel.Screens;

import com.badlogic.citadel.Citadel;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Event1GameScreen implements Screen {
    Citadel game;
    private Stage stage;

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

        //creation of the table
        Table table = new Table();
        table.setFillParent(true);

        new HUD(game.getPlayer(), new SpriteBatch());

    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
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

package com.badlogic.citadel.Screens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.Methods.Player;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SummaryScreen implements Screen {
    Citadel game;
    private Stage stage;
    private Player ply;

    public SummaryScreen(Citadel game){
        this.game = game;
        ply = game.getPlayer();
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {

    }

    @Override
    public void resize(int i, int i1) {

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

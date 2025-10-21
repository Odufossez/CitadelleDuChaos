package com.badlogic.citadel.Methods;

import com.badlogic.citadel.Citadel;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ScreenTransitionFade implements Screen {
    private final Citadel game;
    private final Screen fromScreen;
    private final Screen toScreen;

    private final ShapeRenderer shapeRenderer;

    private float alpha = 0f;
    private final float duration; //durée du fondu en secondes
    private boolean fadingOut = true;
    private boolean switched = false;

    public ScreenTransitionFade(Citadel game, Screen fromScreen, Screen toScreen, float duration) {
        this.game = game;
        this.fromScreen = fromScreen;
        this.toScreen = toScreen;
        this.duration = duration;
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render(float delta) {
        if (fadingOut) {
            alpha += delta / duration;
            if (alpha >= 1f) {
                alpha = 1f;
                fadingOut = false;
                //on change le screen
                switched = true;
                game.setScreen(toScreen);
            }
        } else {
            alpha -= delta/duration;
            if (alpha <- 0f){
                alpha = 0f;
                game.setScreen(fromScreen);
                dispose();
                return;
            }
        }

        //rendre le bon écran selon l'état
        if (fadingOut) {
            fromScreen.render(delta);
        } else {
            toScreen.render(delta);
        }

        // dessiner le fondu noir
        Gdx.gl.glEnable(GL20.GL_BLEND);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(0, 0, 0, alpha);
        shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shapeRenderer.end();
        Gdx.gl.glDisable(GL20.GL_BLEND);
    }

    @Override public void resize(int width, int height) {
        fromScreen.resize(width, height);
        toScreen.resize(width, height);
    }

    @Override public void show() {}
    @Override public void hide() {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void dispose() {
        shapeRenderer.dispose();
    }
}

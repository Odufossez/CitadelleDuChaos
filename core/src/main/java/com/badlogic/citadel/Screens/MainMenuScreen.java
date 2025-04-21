package com.badlogic.citadel.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.citadel.Citadel;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.citadel.Screens.Skins.PLAIN_JAMES_SKIN;


public class MainMenuScreen implements Screen {
    private Stage stage;
    final Citadel game;
    Texture background;



    public MainMenuScreen(final Citadel game){
        this.game = game;

        stage = new Stage(new ScreenViewport());


        //background = new Texture("menu.png"); //todo
    }

    public void create(){

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        //création de la table qui contient tous les objets de la scène
        Table table = new Table();
        table.setFillParent(true);

        stage.addActor(table);

        //Les boutons
        TextButton newGame = new TextButton("New Game", PLAIN_JAMES_SKIN);
        TextButton quit = new TextButton("Quit", PLAIN_JAMES_SKIN);
        TextButton loadSave = new TextButton("Load Save", PLAIN_JAMES_SKIN);
        TextButton parameters = new TextButton("Parameters", PLAIN_JAMES_SKIN);

        table.add(newGame).fillX().uniformX();
        table.row().pad(10,0,10,0);
        table.add(loadSave).fillX().uniformX();
        table.row();
        table.add(parameters).fillX().uniformX();
        table.row();
        table.add(quit).fillX().uniformX();

        //Les listeners des boutons
        quit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                Gdx.app.exit();
            }
        });

        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                game.changeScreen(Citadel.CHARACTERCREATOR);
            }
        });

        loadSave.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                game.changeScreen(Citadel.LOADMENU);
            }
        });

        parameters.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent , Actor actor) {
                game.changeScreen(Citadel.PARAMETERS);
            }
        });

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
        stage.getViewport().update(width, height, true);
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

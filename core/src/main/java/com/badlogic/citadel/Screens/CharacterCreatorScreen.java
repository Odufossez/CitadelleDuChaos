package com.badlogic.citadel.Screens;

import com.badlogic.citadel.Dice;
import com.badlogic.citadel.Methods.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.citadel.Citadel;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class CharacterCreatorScreen implements Screen {
    Citadel game;
    private Stage stage;

    TextButton backButton , rerollButton , goSpellButton;
    Label title , habLabel , endLabel , luckLabel , magicLabel;
    int habInt , endInt , luckInt , magicInt ;

    public CharacterCreatorScreen(final Citadel game){
        this.game = game;
        stage = new Stage(new ScreenViewport());
        habInt = Dice.soloDice() +6;
        endInt = Dice.doubleDice()+12;
        luckInt = Dice.soloDice()+6;
        magicInt = Dice.doubleDice()+6;
    }

    private void create(){
        Table table = new Table();
        table.setFillParent(true);
        table.setSkin(Skins.DEFAULT_SKIN);
        stage.addActor(table);

        createButtons();
        createLabels();


        table.add(title);
        table.row().pad(100,0,0,0);
        table.add(habLabel);
        table.add(Integer.toString(habInt));
        table.row();
        table.add(endLabel);
        table.add(Integer.toString(endInt));
        table.row();
        table.add(magicLabel);
        table.add(Integer.toString(magicInt));
        table.row();
        table.add(luckLabel);
        table.add(Integer.toString(luckInt));
        table.row();
        table.add(rerollButton);
        table.add(goSpellButton);
        table.row();
        table.add(backButton);
    }

    private void createButtons(){
        backButton = new TextButton("Back", Skins.PLAIN_JAMES_SKIN);
        rerollButton = new TextButton("Reroll", Skins.PLAIN_JAMES_SKIN);
        goSpellButton = new TextButton("Go next step", Skins.PLAIN_JAMES_SKIN);
    }

    private void createLabels(){
        title = new Label("Character generator", Skins.DEFAULT_SKIN);
        endLabel = new Label("Endurance - Life", Skins.DEFAULT_SKIN);
        habLabel = new Label("Hability - Strenght in combat", Skins.DEFAULT_SKIN);
        luckLabel = new Label("Luck" , Skins.DEFAULT_SKIN);
        magicLabel = new Label("Magic - Number of spells", Skins.DEFAULT_SKIN);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }


    private void input(){
        backButton.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent event, Actor actor){
                stage.clear();
                game.changeScreen(Citadel.MAINMENU);
            }
        });

        rerollButton.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent event, Actor actor){
                stage.clear();
                game.changeScreen(Citadel.CHARACTERCREATOR);
            }
        });

        goSpellButton.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent event, Actor actor){
                stage.clear();
                game.player = new Player(habInt,endInt,magicInt,0,luckInt);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });

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

    }
}

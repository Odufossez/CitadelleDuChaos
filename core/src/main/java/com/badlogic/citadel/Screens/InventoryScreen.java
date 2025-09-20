package com.badlogic.citadel.Screens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.Item;
import com.badlogic.citadel.Methods.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import javax.swing.plaf.basic.BasicButtonUI;
import java.util.ArrayList;

public class InventoryScreen implements Screen {
    Citadel game;
    private Player ply;
    private ArrayList<Item> inventory;
    private Stage stage;

    private Label title;
    private Table table;

    private TextButton backButton;

    public InventoryScreen(Citadel game) {
        this.game = game;
        ply = game.getPlayer();
        inventory = ply.getInventory().getInventory();
        stage = new Stage(new ScreenViewport());
    }

    private void create() {
        stage.setDebugAll(true);
        backButton = new TextButton("Back", Skins.PLAIN_JAMES_SKIN);

        title = new Label("Inventory" , Skins.DEFAULT_SKIN);
        stage.addActor(backButton);
        stage.addActor(title);
        table = new Table(Skins.DEFAULT_SKIN);
        table.row();

        for(Item i : inventory){
            if (i.inEvent(ply.getCurrentEvent())){
                table.add(i.getButton());
            } else {
                table.add(i.getName());
            }
            table.row();
        }
    }



    private void input(){
        backButton.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent event, Actor actor){
                stage.clear();
                //game.changeScreen(Citadel.); //TODO configure required
            }
        });
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

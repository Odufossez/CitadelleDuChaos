package com.badlogic.citadel.Screens;
import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.Methods.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.swing.*;

public class HUD implements Disposable , Screen {
    private final Citadel game;
    private Player ply;

    private int currentHealth;
    private int maxHealth;
    private int luck;
    private int maxLuck;
    private int mana , maxMana;

    private TextButton inventoryButton, menuButton;
    private Table table, tableButtons;

    private Label healthLabel, luckLabel, manaLabel;

    public Stage stage;

    public HUD(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        stage.setDebugAll(true);
        Skin skin = Skins.PLAIN_JAMES_SKIN;

        table = new Table();
        table.setFillParent(true);
        table.top().left();

        tableButtons = new Table();
        tableButtons.setFillParent(true);
        tableButtons.right().top();

        recupDataPlayer();
        System.out.println("Vie : " + currentHealth + "/" + maxHealth + " Mana : " + mana + "/" + maxMana +
            " LP : " + luck + "/" + maxLuck );

        Label.LabelStyle whiteStyle = new Label.LabelStyle(skin.get(Label.LabelStyle.class));
        whiteStyle.fontColor = Color.WHITE;

        healthLabel = new Label("Health : " + currentHealth + "/" + maxHealth , whiteStyle);
        luckLabel = new Label("Luck : " + luck + "/" + maxLuck , whiteStyle);
        manaLabel = new Label("Mana : " + mana + "/" + maxMana , whiteStyle);

        inventoryButton = new TextButton("Inventory" , skin);
        menuButton = new TextButton("Menu" , skin);

        table.add(healthLabel).padTop(10);
        table.row();
        table.add(luckLabel).padTop(10);
        table.row();
        table.add(manaLabel).padTop(10);

        tableButtons.add(inventoryButton).padTop(10);
        tableButtons.row();
        tableButtons.add(menuButton).padTop(10);

        stage.addActor(table);
        stage.addActor(tableButtons);
    }

    public void recupDataPlayer(){
        ply = game.getPlayer();

        //HP
        currentHealth = ply.getCurrentVitality();
        maxHealth = ply.getVitality();

        //MP
        mana = ply.getCurrentMagic();
        maxMana = ply.getMagic();

        //LP
        luck = ply.getCurrentLuck();
        maxLuck = ply.getLuck();
    }

    @Override
    public void show() {

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

    public void update(float dt){

    }
}

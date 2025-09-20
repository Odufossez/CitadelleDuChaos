package com.badlogic.citadel.Screens;
import com.badlogic.citadel.Methods.Player;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.swing.*;

public class HUD implements Disposable {
    private Player ply;
    private int currentHealth;
    private int maxHealth;
    private int luck;
    private int maxLuck;

    private TextButton inventoryButton;
    private TextButton menuButton;

    private Label healthLabel, luckLabel;

    public Stage stage;

    public HUD(Player player , SpriteBatch batch) {
        ply = player;
        currentHealth = ply.getCurrentVitality();
        maxHealth = ply.getVitality();
        luck = ply.getCurrentLuck();
        maxLuck = ply.getLuck();

        Viewport viewport = new FitViewport(400, 400, new OrthographicCamera());
        stage = new Stage(viewport, batch);

        inventoryButton = new TextButton("Inventory", Skins.PLAIN_JAMES_SKIN);
        menuButton = new TextButton("Menu", Skins.PLAIN_JAMES_SKIN);

        luckLabel = new Label("Luck: " + luck + "/" + maxLuck, Skins.PLAIN_JAMES_SKIN);
        healthLabel = new Label("Health: " + currentHealth + "/" + maxHealth, Skins.PLAIN_JAMES_SKIN);

        //a table to organize the hud's labels and button
        Table table = new Table();
        table.top();
        table.setFillParent(true);

        //add labels and button to the table, padding the top and giving them all equal width with expandX
        table.add(menuButton).expandX().padTop(10);
        table.add(inventoryButton).expandX().padTop(10);
        table.row();
        table.add(healthLabel).expandX().padTop(10);
        table.add(luckLabel).expandX().padTop(10);

        //add the table to the stage
        stage.addActor(table);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    public void update(float dt){

    }
}

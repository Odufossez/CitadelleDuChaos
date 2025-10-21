package com.badlogic.citadel.Screens;
import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.Methods.DialogAlert;
import com.badlogic.citadel.Methods.Player;
import com.badlogic.citadel.Methods.ScreenTransitionFade;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.*;
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

public class HUD implements Disposable {
    private final Citadel game;
    private Player ply;

    private int currentHealth;
    private int maxHealth;
    private int luck;
    private int maxLuck;
    private int mana , maxMana;

    private TextButton inventoryButton, menuButton;
    private Table table, tableButtons, hudLayer;

    private Label healthLabel, luckLabel, manaLabel;


    public HUD(Citadel game , Stage stage) {
        this.game = game;
        Skin skin = Skins.PLAIN_JAMES_SKIN;

        hudLayer = new Table();
        hudLayer.setFillParent(true);
        hudLayer.setTouchable(com.badlogic.gdx.scenes.scene2d.Touchable.childrenOnly);

        table = new Table();
        table.top().left();

        tableButtons = new Table();
        tableButtons.right().top();

        recupDataPlayer();

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

        //ajout des tables à la layer HUD
        hudLayer.add(table).expand().top().left();
        hudLayer.add().expand();
        hudLayer.add(tableButtons).expand().top().right();

        //ajout de la layer à la stage
        stage.addActor(hudLayer);

        input(stage);
    }

    public void bringToFront(){
        hudLayer.toFront();
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

    public void input(final Stage stage){
        inventoryButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                InventoryDialog inventoryDialog = new InventoryDialog(game);
                inventoryDialog.button("Back", new InputListener(){
                    @Override
                    public boolean touchDown(InputEvent event, float x , float y, int pointer, int button){
                        inventoryDialog.hide();
                        return true;
                    }
                });
                inventoryDialog.getButtonTable().row();
                inventoryDialog.show(stage);
                bringToFront();
            }
        });

        menuButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                DialogAlert menuAlert = new DialogAlert("Menu" , Skins.PLAIN_JAMES_SKIN);
                menuAlert.button("Main menu", Color.BLACK, new InputListener(){ //TODO AN "ARE YOU SURE"
                    @Override
                    public boolean touchDown(InputEvent event, float x , float y, int pointer, int button){
                        stage.clear();
                        Screen next = new MainMenuScreen(game);
                        game.setScreen(new ScreenTransitionFade(game,game.getScreen(), next , 1));
                        return true;
                    }
                });
                menuAlert.getButtonTable().row();

                menuAlert.button("Quit", Color.BLACK ,new InputListener(){ //TODO AN "ARE YOU SURE"
                    @Override
                    public boolean touchDown(InputEvent event, float x , float y, int pointer, int button){
                        Gdx.app.exit();
                        return true;
                    }
                });
                menuAlert.getButtonTable().row();

                menuAlert.button("Back", Color.BLACK ,new InputListener(){
                    @Override
                    public boolean touchDown(InputEvent event, float x , float y, int pointer, int button){
                        menuAlert.hide();
                        return true;
                    }
                });
                menuAlert.getButtonTable().row();

                stage.addActor(menuAlert);
                menuAlert.show(stage);
                bringToFront();
            }
        });
    }

    @Override
    public void dispose() {

    }

    public void update(float dt){
        // Mettre à jour les labels si nécessaire
        recupDataPlayer();
        healthLabel.setText("Health : " + currentHealth + "/" + maxHealth);
        luckLabel.setText("Luck : " + luck + "/" + maxLuck);
        manaLabel.setText("Mana : " + mana + "/" + maxMana);
    }
}

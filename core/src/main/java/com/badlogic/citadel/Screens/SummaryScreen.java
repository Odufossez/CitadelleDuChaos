package com.badlogic.citadel.Screens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.Methods.DialogAlert;
import com.badlogic.citadel.Methods.Player;
import com.badlogic.citadel.Methods.SpellList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.citadel.Screens.Skins.PLAIN_JAMES_SKIN;

public class SummaryScreen implements Screen {
    Citadel game;
    private Stage stage;
    private Player ply;
    private Stage dialogAlertStage;

    private TextButton rerollButton, startButton, newSpellBook;
    private Label title, playerLabel, spellBookLabel;
    private Table playerTable;
    private Table spellsTable;
    private Table titleTable;

    public SummaryScreen(Citadel game) {
        this.game = game;
        ply = game.getPlayer();
        stage = new Stage(new ScreenViewport());
        dialogAlertStage = new Stage(new ScreenViewport());
    }

    private void create() {
        stage.setDebugAll(true);

        createLabels();
        createButtons();

        titleTable = new Table();
        titleTable.setFillParent(true);
        titleTable.align(Align.topLeft);
        titleTable.add(title);
        stage.addActor(titleTable);

        playerTable = setUpPlayerTable();
        spellsTable = setUpSpellBookTable();

        playerTable.align(Align.left);
        spellsTable.align(Align.right);

        playerTable.padLeft(50);
        spellsTable.padRight(50);

        stage.addActor(playerTable);
        stage.addActor(spellsTable);
        stage.addActor(startButton);
    }

    private Table setUpPlayerTable() {
        playerTable = new Table();
        playerTable.setSkin(Skins.DEFAULT_SKIN);
        playerTable.setFillParent(true);
        playerTable.add(playerLabel);
        playerTable.row();
        playerTable.add("Ability - Strength in combat : " + ply.getAbility());
        playerTable.row();
        playerTable.add("Endurance - Damage you can take : " + ply.getVitality());
        playerTable.row();
        playerTable.add("Luck : " + ply.getLuck());
        playerTable.row();
        playerTable.add(rerollButton);
        return playerTable;
    }

    private Table setUpSpellBookTable() {
        spellsTable = new Table();
        spellsTable.setSkin(Skins.DEFAULT_SKIN);
        spellsTable.setFillParent(true);
        spellsTable.add(spellBookLabel);
        spellsTable.row();
        for (SpellList.Sorts sort : SpellList.Sorts.values()) {
            if (ply.getGrimoire().isInGrimoire(sort)) {
                spellsTable.add(SpellList.getName(sort) + " - " + ply.getGrimoire().getCountSpell(sort));
            }
            spellsTable.row();
        }
        spellsTable.add(newSpellBook);
        return spellsTable;
    }

    private void createLabels() {
        title = new Label("Summary", Skins.DEFAULT_SKIN);
        playerLabel = new Label("Player characteristics", Skins.DEFAULT_SKIN);
        spellBookLabel = new Label("Spell Book", Skins.DEFAULT_SKIN);
    }

    private void createButtons() {
        rerollButton = new TextButton("Reroll all characteristics", PLAIN_JAMES_SKIN);
        startButton = new TextButton("Start the adventure", PLAIN_JAMES_SKIN);
        newSpellBook = new TextButton("Redo the spell book", PLAIN_JAMES_SKIN);
    }

    private void input() {
        rerollButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                stage.clear();
                ply.getGrimoire().emptyGrimoire();
                game.changeScreen(Citadel.CHARACTERCREATOR);
            }
        });

        startButton.addListener(new ChangeListener() {
            DialogAlert dialogAlert = new DialogAlert("Start the adventure ?", PLAIN_JAMES_SKIN);
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                dialogAlert.text("Are you sure you want to go into the adventure ? You will not be able to change those " +
                    "values later on.");

                dialogAlert.button("No I am not ready yet ! ", Color.BLACK,  new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        dialogAlert.hide();
                        return true;
                    }
                });
                dialogAlert.button("Yes, hit me with the adventure ! ", Color.RED,new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        stage.clear();
                        game.changeScreen(Citadel.INTROSCREEN);
                        return true;
                    }
                });
                stage.addActor(dialogAlert);
                dialogAlert.show(stage);
            }
        });

        newSpellBook.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                stage.clear();
                game.changeScreen(Citadel.SPELLSMENU);
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

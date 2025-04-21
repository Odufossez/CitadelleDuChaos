package com.badlogic.citadel.Screens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.Methods.Player;
import com.badlogic.citadel.Methods.SpellList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import javax.security.auth.callback.CallbackHandler;

import static com.badlogic.citadel.Screens.Skins.DEFAULT_SKIN;
import static com.badlogic.citadel.Screens.Skins.PLAIN_JAMES_SKIN;

public class SpellScreen implements Screen {
    Citadel game;
    private Stage stage;
    private Player ply;

    private TextButton addCopy, addFeable, addFire, addStrenght, addIllusion , addLevitation , addGoldDumb , addProtection , addTelepathy , addEndu,addLuck,addHab;
    private TextButton backButton,nextButton;
    private TextButton rmCopy,rmFeable,rmFire,rmStrenght,rmIllusion,rmLevitation,rmGoldDumb,rmProtection,rmTelepathy,rmEndu,rmLuck,rmHab;
    private Label title , copyLabel , feableLabel,fireLabel,strenghtlabel,illusionLabel,levitationLabel,goldDumbLabel,protectionLabel,telepathyLabel,enduLabel,luckLabel,habLabel;

    public SpellScreen(Citadel game) {
        this.game = game;
        ply = game.getPlayer();
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();

    }

    private void create(){
        Table table = new Table();
        table.setFillParent(true);
        table.setSkin(DEFAULT_SKIN);
        stage.addActor(table);

        table.setDebug(true);
    }

    private void createButtons(){
        addCopy = new TextButton("Add" , PLAIN_JAMES_SKIN);
        addFeable = new TextButton("Add" , PLAIN_JAMES_SKIN);
        addFire = new TextButton("Add" , PLAIN_JAMES_SKIN);
        addStrenght = new TextButton("Add" , PLAIN_JAMES_SKIN);
        addIllusion = new TextButton("Add" , PLAIN_JAMES_SKIN);
        addLevitation = new TextButton("Add" , PLAIN_JAMES_SKIN);
        addGoldDumb = new TextButton("Add" , PLAIN_JAMES_SKIN);
        addProtection = new TextButton("Add" , PLAIN_JAMES_SKIN);
        addTelepathy = new TextButton("Add" , PLAIN_JAMES_SKIN);
        addEndu = new TextButton("Add" , PLAIN_JAMES_SKIN);
        addLuck = new TextButton("Add" , PLAIN_JAMES_SKIN);
        addHab = new TextButton("Add" , PLAIN_JAMES_SKIN);

        rmCopy = new TextButton("Remove" , PLAIN_JAMES_SKIN);
        rmFeable = new TextButton("Remove" , PLAIN_JAMES_SKIN);
        rmFire = new TextButton("Remove" , PLAIN_JAMES_SKIN);
        rmStrenght = new TextButton("Remove" , PLAIN_JAMES_SKIN);
        rmIllusion = new TextButton("Remove" , PLAIN_JAMES_SKIN);
        rmLevitation = new TextButton("Remove" , PLAIN_JAMES_SKIN);
        rmGoldDumb = new TextButton("Remove" , PLAIN_JAMES_SKIN);
        rmProtection = new TextButton("Remove" , PLAIN_JAMES_SKIN);
        rmTelepathy = new TextButton("Remove" , PLAIN_JAMES_SKIN);
        rmEndu = new TextButton("Remove" , PLAIN_JAMES_SKIN);
        rmLuck = new TextButton("Remove" , PLAIN_JAMES_SKIN);
        rmHab = new TextButton("Remove" , PLAIN_JAMES_SKIN);

        backButton = new TextButton("Back" , PLAIN_JAMES_SKIN);
    }
    private void createLabels(){
        title = new Label("Compose your spell's book" , DEFAULT_SKIN);
    }

    private void input(){
        backButton.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent event, Actor actor){
                stage.clear();
                game.changeScreen(Citadel.CHARACTERCREATOR);
            }
        });

        //todo
        /*nextButton.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent event, Actor actor){
                stage.clear();
                game.changeScreen(Citadel.CHARACTERCREATOR);
            }
        });*/

        addCopy.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent event, Actor actor){
                ply.getGrimoire().putIn(SpellList.Sorts.COPIE_CONFORME);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });
        rmCopy.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent event, Actor actor){
                ply.getGrimoire().removeFrom(SpellList.Sorts.COPIE_CONFORME);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });

        addFeable.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                ply.getGrimoire().putIn(SpellList.Sorts.FAIBLESSE);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });
        rmFeable.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                ply.getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });

        addFire.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent , Actor actor){
                ply.getGrimoire().putIn(SpellList.Sorts.FEU);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });
        rmFire.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                ply.getGrimoire().removeFrom(SpellList.Sorts.FEU);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });

        addStrenght.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().putIn(SpellList.Sorts.FORCE);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });
        rmStrenght.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                ply.getGrimoire().removeFrom(SpellList.Sorts.FORCE);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });

        addIllusion.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().putIn(SpellList.Sorts.ILLUSION);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });
        rmIllusion.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().putIn(SpellList.Sorts.ILLUSION);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });

        addLevitation.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().putIn(SpellList.Sorts.LEVITATION);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });
        rmLevitation.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().removeFrom(SpellList.Sorts.LEVITATION);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });

        addGoldDumb.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().putIn(SpellList.Sorts.OR_DU_SOT);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });
        rmGoldDumb.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().removeFrom(SpellList.Sorts.OR_DU_SOT);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });

        addProtection.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().putIn(SpellList.Sorts.PROTECTION);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });
        rmProtection.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().removeFrom(SpellList.Sorts.PROTECTION);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });

        addTelepathy.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().putIn(SpellList.Sorts.TELEPATHIE);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });
        rmTelepathy.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().removeFrom(SpellList.Sorts.TELEPATHIE);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });


    }

    @Override
    public void render(float v) {
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

    }
}

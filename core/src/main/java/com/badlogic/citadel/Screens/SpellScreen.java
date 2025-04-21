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

    private TextButton addCopy, addFeable, addFire, addStrenght, addIllusion , addLevitation , addGoldDumb ,
        addProtection , addTelepathy , addEndu,addLuck,addHab;
    private TextButton backButton,nextButton;
    private TextButton rmCopy,rmFeable,rmFire,rmStrenght,rmIllusion,rmLevitation,rmGoldDumb,rmProtection,rmTelepathy,
        rmEndu,rmLuck,rmHab;
    private Label title , copyLabel , feableLabel,fireLabel,strenghtlabel,illusionLabel,levitationLabel,goldDumbLabel,
        protectionLabel,telepathyLabel,enduLabel,luckLabel,habLabel;

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

        createButtons();
        createLabels();

        table.add(title);
        table.row().pad(100, 0, 0, 0);
        table.add(copyLabel); table.add(addCopy); table.add(rmCopy);
        table.add(Integer.toString(ply.getGrimoire().getCountSpell(SpellList.Sorts.COPIE_CONFORME)));
        table.row();
        table.add(feableLabel); table.add(addFeable); table.add(rmFeable);
        table.add(Integer.toString(ply.getGrimoire().getCountSpell(SpellList.Sorts.FAIBLESSE)));
        table.row();
        table.add(fireLabel); table.add(addFire); table.add(rmFire);
        table.add(Integer.toString(ply.getGrimoire().getCountSpell(SpellList.Sorts.FEU)));
        table.row();
        table.add(strenghtlabel); table.add(addStrenght); table.add(rmStrenght);
        table.add(Integer.toString(ply.getGrimoire().getCountSpell(SpellList.Sorts.FORCE)));
        table.row();
        table.add(illusionLabel); table.add(addIllusion); table.add(rmIllusion);
        table.add(Integer.toString(ply.getGrimoire().getCountSpell(SpellList.Sorts.ILLUSION)));
        table.row();
        table.add(levitationLabel); table.add(addLevitation); table.add(rmLevitation);
        table.add(Integer.toString(ply.getGrimoire().getCountSpell(SpellList.Sorts.LEVITATION)));
        table.row();
        table.add(goldDumbLabel); table.add(addGoldDumb); table.add(rmGoldDumb);
        table.add(Integer.toString(ply.getGrimoire().getCountSpell(SpellList.Sorts.OR_DU_SOT)));
        table.row();
        table.add(protectionLabel); table.add(addProtection); table.add(rmProtection);
        table.add(Integer.toString(ply.getGrimoire().getCountSpell(SpellList.Sorts.PROTECTION)));
        table.row();
        table.add(telepathyLabel); table.add(addTelepathy); table.add(rmTelepathy);
        table.add(Integer.toString(ply.getGrimoire().getCountSpell(SpellList.Sorts.TELEPATHIE)));
        table.row();
        table.add(enduLabel); table.add(addEndu); table.add(rmEndu);
        table.add(Integer.toString(ply.getGrimoire().getCountSpell(SpellList.Sorts.ENDURANCE)));
        table.row();
        table.add(luckLabel); table.add(addLuck); table.add(rmLuck);
        table.add(Integer.toString(ply.getGrimoire().getCountSpell(SpellList.Sorts.CHANCE)));
        table.row();
        table.add(habLabel); table.add(addHab); table.add(rmHab);
        table.add(Integer.toString(ply.getGrimoire().getCountSpell(SpellList.Sorts.HABILITE)));
        table.row().pad(50,0,10,50);
        table.add(backButton); table.add(nextButton);
        table.add(Integer.toString(ply.getGrimoire().countSpells())+'/'+ply.getMagic());
        table.row().pad(10,0,0,100);
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
        nextButton = new TextButton("Next step" , PLAIN_JAMES_SKIN);
    }
    private void createLabels(){
        title = new Label("Compose your spell's book" , DEFAULT_SKIN);
        copyLabel = new Label("Copie Conforme", DEFAULT_SKIN);
        feableLabel = new Label("Faiblesse",DEFAULT_SKIN);
        fireLabel = new Label("Fire", DEFAULT_SKIN);
        strenghtlabel = new Label("Force",DEFAULT_SKIN);
        illusionLabel = new Label("Illusion",DEFAULT_SKIN);
        levitationLabel = new Label("Levitation",DEFAULT_SKIN);
        goldDumbLabel = new Label("L'or du sot",DEFAULT_SKIN);
        protectionLabel = new Label("Protection",DEFAULT_SKIN);
        telepathyLabel = new Label("Telepathie",DEFAULT_SKIN);
        enduLabel = new Label("Endurance",DEFAULT_SKIN);
        luckLabel = new Label("Chance",DEFAULT_SKIN);
        habLabel = new Label("Habilite",DEFAULT_SKIN);
    }

    private void input(){
        backButton.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent event, Actor actor){
                stage.clear();
                ply.getGrimoire().emptyGrimoire();
                game.changeScreen(Citadel.CHARACTERCREATOR);
            }
        });

        nextButton.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent event, Actor actor){
                stage.clear();
                game.changeScreen(Citadel.SUMMARYSCREEN);
            }
        });

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
                ply.getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
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

        addEndu.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().putIn(SpellList.Sorts.ENDURANCE);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });
        rmEndu.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().removeFrom(SpellList.Sorts.ENDURANCE);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });

        addHab.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor) {
                ply.getGrimoire().putIn(SpellList.Sorts.HABILITE);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });
        rmHab.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().removeFrom(SpellList.Sorts.HABILITE);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });

        addLuck.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().putIn(SpellList.Sorts.CHANCE);
                game.changeScreen(Citadel.SPELLSMENU);
            }
        });
        rmLuck.addListener(new ChangeListener(){
            @Override
            public void changed(ChangeEvent changeEvent, Actor actor){
                ply.getGrimoire().removeFrom(SpellList.Sorts.CHANCE);
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

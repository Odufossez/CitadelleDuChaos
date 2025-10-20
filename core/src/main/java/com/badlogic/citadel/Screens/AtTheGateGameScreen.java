package com.badlogic.citadel.Screens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.Methods.DialogBox;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import static com.badlogic.citadel.Screens.Skins.PLAIN_JAMES_SKIN;

public class AtTheGateGameScreen extends ApplicationAdapter implements Screen {
    Citadel game;
    private Stage stage;
    private Dialog sceneDialog;
    private Skin skin;
    private HUD hud;

    /*----Dialogues for the current scene (event 1)----*/
    private final DialogBox dialogBox1 = new DialogBox("Narrator" , PLAIN_JAMES_SKIN);
    private final DialogBox dialogBox2 = new DialogBox("Narrator" , PLAIN_JAMES_SKIN);
    private final DialogBox dialogBox3 = new DialogBox("Narrator" , PLAIN_JAMES_SKIN);
    private final DialogBox dialogBox4 = new DialogBox("Monster Monkey-Head-Hound-Body" , PLAIN_JAMES_SKIN);

    /*----Dialogues for events----*/
    private final DialogBox dialogBox261 = new DialogBox("" , PLAIN_JAMES_SKIN); //évènement 261
    private final DialogBox dialogBox230 = new DialogBox("", PLAIN_JAMES_SKIN); //event 230
    private final DialogBox dialogBox20 = new DialogBox("", PLAIN_JAMES_SKIN); //event 20

    public AtTheGateGameScreen(Citadel game){
        this.game = game;
        stage = new Stage(new ScreenViewport());
        hud = new HUD(game,stage);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();
    }

    @Override
    public void create(){
        dialogBox1.text("The sun is setting. The climb to reach the top of the mountain is difficult but you manage " +
            "to make it. While you climb, you have to think about what you will say to the guards.");

        dialogBox2.text("Maybe a wanderer, looking for a safe place to sleep ? Or an herbalist, called to cure someone ? " +
            "Or maybe a seller or an artisan ?");

        dialogBox3.text("Either way, while thinking about that lie, you reach a trail going to the gates. Walking up it," +
            " you start to hear muffled voices and soon started to see the guards.");

        dialogBox4.text("Halt! Who's is coming !?");

        stage.addActor(dialogBox1);
        hud.bringToFront();
    }

    private void input() {
        dialogBox1.button("Think about a lie" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox1.hide();
                stage.addActor(dialogBox2);
                dialogBox2.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox2.button("Continue" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox2.hide();
                stage.addActor(dialogBox3);
                dialogBox3.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox3.button("Approach the gate" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox3.hide();
                stage.addActor(dialogBox4);
                dialogBox4.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox4.button("I am a herbalist ! " , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox4.hide();
                stage.addActor(dialogBox261);
                dialogBox261.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox4.button("I am a merchant !" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox4.hide();
                stage.addActor(dialogBox230);
                dialogBox230.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox4.button("I am a wanderer,\n looking for hospitality for the night !" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox4.hide();
                stage.addActor(dialogBox20);
                dialogBox20.show(stage);
                hud.bringToFront();
                return true;
            }
        });
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        hud.update(v);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        game.batch.begin();
        BitmapFont font = new BitmapFont();
        font.draw(game.batch, "Event 1" , Gdx.graphics.getWidth()*0.25f, Gdx.graphics.getHeight()*0.3f);
        game.batch.end();
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
        hud.dispose();
        stage.dispose();
    }
}

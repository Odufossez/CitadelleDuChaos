package com.badlogic.citadel.Screens.OnGameScreens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogBox;
import com.badlogic.citadel.Screens.HUD;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.citadel.DialogWindows.DialogBoxMethods.continueDialogBox;

//362
public class TempleOfTheCourtyardGameScreen extends ApplicationAdapter implements Screen {
    private Citadel game;
    private Stage stage;
    private HUD hud;

    DialogBox dialogBox362_1 = new DialogBox("Narrator");
    DialogBox dialogBox362_2 = new DialogBox("Narrator");
    DialogBox dialogBox58 = new DialogBox("Narrator");
    DialogBox dialogBox298 = new DialogBox("Narrator");
    DialogBox dialogBox267 = new DialogBox("Narrator");
    DialogBox dialogBox92 = new DialogBox("Narrator");
    DialogBox dialogBoxDream_1 = new DialogBox("Narrator");
    DialogBox dialogBoxDream_2 = new DialogBox("Narrator");

    public TempleOfTheCourtyardGameScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        hud = new HUD(game,stage);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();
        dialogBox362_1.show(stage);
    }

    public void create(){
        dialogBox362_1.text("The door opens and the small room inside is lit by candlelight. Cautiously, you look inside to " +
            "see a strange sight. On a stone altar in the the middle of a chamber are three silver chalices, each containing " +
            "a different-coloured liquid.");
        dialogBox362_2.text("One liquid is clear, one red and one milky. Fluttering around the altar are three small winged " +
            "gremlin like creatures. Every so often one lands on the altar and takes a sip of the milky one. The door creaks on its " +
            "hinges and startles them. They whirl round to see you and become very excited.");
        dialogBox58.text("As you enter, the Gremlins flutter and squeak excitedly, then fly past you, through the door and " +
            "out into the night. You are now alone with the chalices. Will you risk taking any drink ? ");
        dialogBox298.text("As your hands close around the chalice, it begins to fizz and foam, spitting at you as you raise " +
            "it to your lips. Are you sure you want to drink this ?");
        dialogBoxDream_1.text("The liquid tastes salty and you break into a cold sweat as it goes down. You begin to tremble and " +
            "try to steady yourself on the altar. However, you trip forward, knocking the other two chalices onto the floor, " +
            "spilling the liquids. You slump to the floor yourself, feeling extremely sick. As if in a dream, you see a vision " +
            "of a strange, muscular creature with two heads, a long tail, and scaly grey skin.");
        dialogBoxDream_2.text("In its hand it holds a large bunch of keys. A mouse runs across the table at wich it is sitting " +
            "and it shrieks loudly... The cry wakes you up with a start and you realize where you are. You pick yourself up " +
            "and grope the door handle. You need some fresh air.");
        dialogBox267.text("As you grasp the chalice, the liquid turns green, then a dirty brown in front of your eyes. It smells " +
            "putrid, but you take a sip. With a grimace you spit it out - you are drinking muddy waters ! You leave the chamber " +
            "and head for the Citadel.");
        dialogBox92.text("The milky liquid smells sweet. You take a sip and start to giggle! You take a gulp and burst out " +
            "laughing, for no reason at all ! No wonder the little Gremlins were enjoying it so much. Light-headed, and in fine" +
            " spirits, you leave the chamber to make your way towards the Citadel.");
    }

    public void input(){
        continueDialogBox(dialogBox362_1,dialogBox362_2,hud,stage);
        continueDialogBox(dialogBox362_2,dialogBox58,"Enter the temple",stage,hud);
        continueDialogBox(dialogBox362_2, "Go back to the courtyard\nand continue my way" , stage, new TentacleGameScreen(game), game);
        continueDialogBox(dialogBox58,dialogBox298,"The clear liquid" ,stage,hud);
        continueDialogBox(dialogBox58,dialogBox267,"The red liquid" ,stage,hud);
        continueDialogBox(dialogBox58,dialogBox92,"The milky liquid" ,stage,hud);
        continueDialogBox(dialogBox58,"No, go back", stage, new TentacleGameScreen(game), game);
        continueDialogBox(dialogBox298,dialogBox58,"No" ,stage,hud);
        continueDialogBox(dialogBox298,dialogBoxDream_1,"Yes" ,stage,hud);
        continueDialogBox(dialogBoxDream_1,dialogBoxDream_2,hud,stage);
        continueDialogBox(dialogBoxDream_2,"Go back to have some fresh air", stage , new TentacleGameScreen(game), game);

        dialogBox267.button("Cough, it is disgusting !" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox267.hide();
                game.getPlayer().decreaseLuck();
                stage.clear();
                game.setScreen(new TentacleGameScreen(game));
                return true;
            }
        });

        dialogBox92.button("Feel invigorated and go back" , new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox92.hide();
                game.getPlayer().setCurrentVitality(game.getPlayer().getCurrentVitality() + 2);
                stage.clear();
                game.setScreen(new TentacleGameScreen(game));
                return true;
            }
        });
    }

    /*------------ Screens methods -----------------------*/
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        hud.update(delta);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        game.batch.begin();
        BitmapFont font = new BitmapFont();
        font.draw(game.batch, "The temple of the courtyard" , Gdx.graphics.getWidth()*0.25f, Gdx.graphics.getHeight()*0.3f);
        game.batch.end();
        stage.draw();
    }

    @Override
    public void hide() {

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        hud.dispose();
        stage.dispose();
    }
}

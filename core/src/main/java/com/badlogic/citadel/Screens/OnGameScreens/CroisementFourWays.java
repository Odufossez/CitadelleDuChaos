package com.badlogic.citadel.Screens.OnGameScreens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogBox;
import com.badlogic.citadel.Screens.HUD;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.citadel.DialogWindows.DialogBoxMethods.continueDialogBox;

//367
public class CroisementFourWays extends ApplicationAdapter implements Screen {
    private final Citadel game;
    private final Stage stage;
    private final HUD hud;

    private final DialogBox dialogBox367 = new DialogBox("Narrator");
    private final DialogBox dialogBox121 = new DialogBox("Narrator");
    private final DialogBox dialogBox308 = new DialogBox("Narrator");

    public CroisementFourWays(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        hud = new HUD(game,stage);
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();
        dialogBox367.show(stage);
    }

    public void input(){
        continueDialogBox(dialogBox367,dialogBox308,"Open the door slowly",stage,hud);
        continueDialogBox(dialogBox367,dialogBox121,"Charge the door down",stage,hud);

        continueDialogBox(dialogBox121,stage,new GolemGameScreen(game),game,()->{
            game.getPlayer().modifyCurrentVitality(-1);
        });
        continueDialogBox(dialogBox308,stage,new GolemGameScreen(game),game,null);
    }

    public void create(){
        dialogBox367.text("Some way along the passage, you arrive at a four-way junction. You take a path to the north, which " +
            "eventually leads you to a large wooden door. You can hear nothing by listening at the keyhole.");

        dialogBox308.text("The handle turns and you step into a dark room.");

        dialogBox121.text("As you run at the door, it suddenly opens in front of you. Unable to stop, you rush headlong forwards " +
            "into the room, eventually tripping over and rolling to a stop.");
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        hud.update(v);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        game.batch.begin();
        BitmapFont font = new BitmapFont();
        font.draw(game.batch, "Golem Game Screen" , Gdx.graphics.getWidth()*0.25f, Gdx.graphics.getHeight()*0.3f);
        game.batch.end();
        stage.draw();
    }

    @Override
    public void hide() {

    }

    public void dispose(){
        stage.dispose();
        hud.dispose();
    }
}

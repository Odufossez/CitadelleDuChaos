package com.badlogic.citadel.Screens.OnGameScreens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogBox;
import com.badlogic.citadel.Methods.ScreenTransitionFade;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.citadel.Screens.Skins.PLAIN_JAMES_SKIN;

public class IntroGameScreen extends ApplicationAdapter implements Screen {

    private final Citadel game;
    private final Stage stage;
    private final DialogBox dialogIntro = new DialogBox("Narrator" , PLAIN_JAMES_SKIN);
    private final DialogBox dialogIntro2 = new DialogBox("Narrator" , PLAIN_JAMES_SKIN);

    private final Screen from = this;

    public IntroGameScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void create() {

        dialogIntro.text("You've been commissioned to go and defeat Baltus Dire who's been terrifying the valley for " +
            "8 years. He's planning to invade the Valley before the end of the week and must be stopped.");

        dialogIntro2.text("You have been walking for quite some time now and finally, the Citadel of Chaos" +
            " is in sight");

        stage.addActor(dialogIntro);
        dialogIntro.show(stage);

    }

    private void input(){
        dialogIntro.button("Next" , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogIntro.hide();
                stage.addActor(dialogIntro2);
                dialogIntro2.show(stage);
                return true;
            }
        });

        dialogIntro2.button("Start the adventure" , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                Screen next = new AtTheGateGameScreen(game);
                stage.clear();
                game.setScreen(new ScreenTransitionFade(game,from,next,1));
                return true;
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
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
}

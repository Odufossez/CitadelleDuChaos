package com.badlogic.citadel.Screens;

import com.badlogic.citadel.Citadel;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class ParameterScreen implements Screen {
    private Citadel game;
    private Stage stage;
    private Label titleLabel;
    private Label volMusicLabel;
    private Label volSoundLabel;
    private Label musicOnOffLabel;
    private Label soundOnOffLabel;


    public ParameterScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        TextButton backButton = new TextButton("Back", Skins.DEFAULT_SKIN);
        backButton.addListener(new ChangeListener(){
           @Override
           public void changed(ChangeEvent event, Actor actor){
               stage.clear();
               game.changeScreen(Citadel.MAINMENU);
           }
        });


        titleLabel = new Label("Parameters", Skins.DEFAULT_SKIN);
        volMusicLabel = new Label("Music", Skins.GLASSY_SKIN);
        volSoundLabel = new Label("Sound", Skins.GLASSY_SKIN);
        musicOnOffLabel = new Label(null, Skins.GLASSY_SKIN);
        soundOnOffLabel = new Label(null, Skins.GLASSY_SKIN);

        final Slider volMusicSlider = new Slider(0,1,0.1f,false,Skins.DEFAULT_SKIN);
        volMusicSlider.setValue(game.getAppPrefs().getMusicVolume());
        volMusicSlider.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                game.getAppPrefs().setMusicVolume( volMusicSlider.getValue());
                return false;
            }
        });

        final CheckBox musicCB = new CheckBox(null,Skins.DEFAULT_SKIN);
        musicCB.setChecked(game.getAppPrefs().getMusicEnable());
        musicCB.addListener(new EventListener() {
           @Override
           public boolean handle(Event event) {
               boolean enabled = musicCB.isChecked();
               game.getAppPrefs().setMusicEnable(enabled);
               return false;
           }
        });

        final Slider volSoundSlider = new Slider(0,1,0.1f,false,Skins.DEFAULT_SKIN);
        volSoundSlider.setValue(game.getAppPrefs().getSoundVolume());
        volSoundSlider.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                game.getAppPrefs().setSoundVolume( volSoundSlider.getValue());
                return false;
            }
        });

        final CheckBox soundCB = new CheckBox(null,Skins.DEFAULT_SKIN);
        soundCB.setChecked(game.getAppPrefs().getSoundEnable());
        soundCB.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                boolean enabled = soundCB.isChecked();
                game.getAppPrefs().setSoundEnable(enabled);
                return false;
            }
        });

        table.add(titleLabel);
        table.row().pad(10,0,0,10);
        table.add(volMusicLabel);
        table.add(volMusicSlider);
        table.row();
        table.add(musicOnOffLabel);
        table.add(musicCB);
        table.row();
        table.add(volSoundLabel);
        table.add(volSoundSlider);
        table.row();
        table.add(soundOnOffLabel);
        table.add(soundCB);
        table.row();
        table.add(backButton);
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

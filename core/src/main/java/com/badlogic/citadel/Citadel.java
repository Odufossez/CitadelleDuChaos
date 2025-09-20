package com.badlogic.citadel;

import com.badlogic.citadel.Methods.AppPreferences;
import com.badlogic.citadel.Methods.Player;
import com.badlogic.citadel.Screens.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Citadel extends Game {
    public final static int MAINMENU = 0;
    public final static int LOADMENU = 1;
    public final static int CHARACTERCREATOR = 2;
    public final static int SPELLSMENU = 3;
    public final static int INVENTORY = 4;
    public final static int GAMEOVER = 5;
    public final static int PARAMETERS = 6;
    public final static int SUMMARYSCREEN = 7;

    public final static int INTROSCREEN = 8;
    public final static int EVENT1 = 9;
    public final static int EVENT2 = 10;
    public final static int EVENT3 = 11;

    public BitmapFont font; //todo revoir les fonts
    public SpriteBatch batch;

    private MainMenuScreen menuScreen;
    private SpellScreen spellScreen;
    private GameOverScreen gameOverScreen;
    private CharacterCreatorScreen cCScreen;
    private InventoryScreen inventoryScreen;
    private LoadSaveScreen loadScreen;
    private ParameterScreen parameterScreen;
    private SummaryScreen summaryScreen;

    //Events screen
    private IntroGameScreen introScreen;
    private Event1GameScreen event1GameScreen;

    private AppPreferences appPrefs;
    public Player player;



    @Override
    public void create() {
        appPrefs = new AppPreferences();
        menuScreen = new MainMenuScreen(this);
        introScreen = new IntroGameScreen(this); //todo remove after testing
        batch = new SpriteBatch();
        font = new BitmapFont();
        setScreen(introScreen); //todo correct after testing
    }


    public AppPreferences getAppPrefs() {
        return appPrefs;
    }
    public Player getPlayer(){ return player ;}

    public void changeScreen(int screen){
        switch(screen){
            case MAINMENU:{
                if (menuScreen == null) menuScreen = new MainMenuScreen(this);
                this.setScreen(menuScreen);
                break;
            }
            case LOADMENU:{
                if (loadScreen == null) loadScreen = new LoadSaveScreen(this);
                this.setScreen(loadScreen);
                break;
            }
            case CHARACTERCREATOR:{
                cCScreen = new CharacterCreatorScreen(this);
                this.setScreen(cCScreen);
                break;
            }
            case SPELLSMENU:{
                spellScreen = new SpellScreen(this);
                this.setScreen(spellScreen);
                break;
            }
            case INVENTORY:{
                if (inventoryScreen == null) inventoryScreen = new InventoryScreen(this);
                this.setScreen(inventoryScreen);
                break;
            }
            case GAMEOVER:{
                if (gameOverScreen == null) gameOverScreen = new GameOverScreen(this);
                this.setScreen(gameOverScreen);
                break;
            }
            case PARAMETERS:{
                if (parameterScreen == null) parameterScreen = new ParameterScreen(this);
                this.setScreen(parameterScreen);
                break;
            }
            case SUMMARYSCREEN:{
                if (summaryScreen == null) summaryScreen = new SummaryScreen(this);
                this.setScreen(summaryScreen);
                break;
            }

            case INTROSCREEN:{
                if (introScreen == null) introScreen = new IntroGameScreen(this);
                this.setScreen(introScreen);
                break;
            }
            case EVENT1:{
                if (event1GameScreen==null) event1GameScreen = new Event1GameScreen(this);
                this.setScreen(event1GameScreen);
                break;
            }
            case EVENT2:{
            }
        }
    }

    public void render(){
        super.render();
    }

    public void dispose(){

    }
}

package com.badlogic.citadel;

import com.badlogic.citadel.Items.*;
import com.badlogic.citadel.Methods.AppPreferences;
import com.badlogic.citadel.Methods.Player;
import com.badlogic.citadel.Screens.*;
import com.badlogic.gdx.Game;

public class Citadel extends Game {
    public final static int MAINMENU = 0;
    public final static int LOADMENU = 1;
    public final static int CHARACTERCREATOR = 2;
    public final static int SPELLSMENU = 3;
    public final static int INVENTORY = 4;
    public final static int GAMESCREEN = 5;
    public final static int GAMEOVER = 6;
    public final static int PARAMETERS = 7;
    public final static int SUMMARYSCREEN = 8;

    private MainMenuScreen menuScreen;
    private SpellScreen spellScreen;
    private GameScreen gameScreen;
    private GameOverScreen gameOverScreen;
    private CharacterCreatorScreen cCScreen;
    private InventoryScreen inventoryScreen;
    private LoadSaveScreen loadScreen;
    private ParameterScreen parameterScreen;
    private SummaryScreen summaryScreen;

    private AppPreferences appPrefs;
    public Player player;



    @Override
    public void create() {
        appPrefs = new AppPreferences();
        menuScreen = new MainMenuScreen(this);
        setScreen(menuScreen);
        initializeItems();
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
            case GAMESCREEN:{
                if (gameScreen == null) gameScreen = new GameScreen(this);
                this.setScreen(gameScreen);
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
        }
    }

    public void render(){
        super.render();
    }

    public void dispose(){

    }
}

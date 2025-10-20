package com.badlogic.citadel;

import com.badlogic.citadel.Methods.AppPreferences;
import com.badlogic.citadel.Methods.Player;
import com.badlogic.citadel.Methods.SpellBook;
import com.badlogic.citadel.Methods.SpellList;
import com.badlogic.citadel.Screens.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Citadel extends Game {
    public final static int MAINMENU = 0;
    public final static int LOADMENU = 1;
    public final static int CHARACTERCREATOR = 2;
    public final static int SPELLSMENU = 3;
    public final static int INVENTORY = 4;
    public final static int GAMEOVER = 5;
    public final static int PARAMETERS = 6;
    public final static int SUMMARYSCREEN = 7;
    public final static int RULESSCREEN = 8; //TODO

    public final static int INTROSCREEN = 10;

    //public BitmapFont titleFont = new BitmapFont(); //todo revoir les fonts
    public static BitmapFont versionFont;

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
    private AtTheGateGameScreen atTheGateGameScreen;

    private AppPreferences appPrefs;
    public static float density;
    public Player player;



    @Override
    public void create() {
        appPrefs = new AppPreferences();
        menuScreen = new MainMenuScreen(this);
        batch = new SpriteBatch();
        //titleFont = new BitmapFont();
        density = Gdx.graphics.getDensity();

        //TODO à changer pour la version finale -- player et grimoire virtuel pour les tests
        /*player = new Player(1,1,1,1,1);
        player.setCurrentMagic(1);
        player.setCurrentLuck(1);
        player.setCurrentVitality(1);
        SpellBook grim = new SpellBook(1);
        grim.putIn(SpellList.Sorts.HABILITE);
        introScreen = new IntroGameScreen(this);
        setScreen(introScreen);*/
        /*------ fin du temporaire ---*/
        setScreen(menuScreen);

    }


    public AppPreferences getAppPrefs() {
        return appPrefs;
    }
    public Player getPlayer(){ return player ;}


    public void render(){
        super.render();
    }

    public void dispose(){

    }
}

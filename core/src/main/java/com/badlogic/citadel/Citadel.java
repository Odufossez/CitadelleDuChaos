package com.badlogic.citadel;

import com.badlogic.citadel.Methods.AppPreferences;
import com.badlogic.citadel.PlayerRelatedMethods.Player;
import com.badlogic.citadel.PlayerRelatedMethods.SpellBook;
import com.badlogic.citadel.PlayerRelatedMethods.SpellList;
import com.badlogic.citadel.Screens.OnGameScreens.*;
import com.badlogic.citadel.Screens.PregameScreens.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Citadel extends Game {

    public SpriteBatch batch;

    private MainMenuScreen menuScreen;


    private AppPreferences appPrefs;
    public static float density;
    public Player player;

    /*---------------------- Game variables like password and other key informations -----------------------------*/
    private boolean password; //Scimitar - TheCourtyardGameScreen
    private boolean combinationLock; //217 - LibraryGameScreen


    @Override
    public void create() {
        appPrefs = new AppPreferences();
        menuScreen = new MainMenuScreen(this);
        batch = new SpriteBatch();
        //titleFont = new BitmapFont();
        density = Gdx.graphics.getDensity();

        //TODO à changer pour la version finale -- player et grimoire virtuel pour les tests
        player = new Player(12,15,9,5,10);
        SpellBook grim = player.getGrimoire();
        grim.putIn(SpellList.Sorts.HABILITE);
        grim.putIn(SpellList.Sorts.COPIE_CONFORME);
        grim.putIn(SpellList.Sorts.ENDURANCE);
        grim.putIn(SpellList.Sorts.LEVITATION);
        grim.putIn(SpellList.Sorts.OR_DU_SOT);
        grim.putIn(SpellList.Sorts.PROTECTION);
        grim.putIn(SpellList.Sorts.TELEPATHIE);
        grim.putIn(SpellList.Sorts.FORCE);
        grim.putIn(SpellList.Sorts.FAIBLESSE);
        setScreen(new GameRoomScreenGame(this));
        /*------ fin du temporaire ---*/
        //setScreen(menuScreen);
        password = false;
        combinationLock = false;
    }


    public AppPreferences getAppPrefs() {
        return appPrefs;
    }
    public Player getPlayer(){ return player ;}

    public boolean getPassword(){return password;}
    public void setPassword(boolean b){password = b;}

    public boolean getCombinationLock(){return combinationLock;}
    public void setCombinationLock(boolean b){combinationLock = b;}


    public void render(){
        super.render();
    }

    public void dispose(){

    }
}

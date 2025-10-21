package com.badlogic.citadel;

import com.badlogic.citadel.Methods.AppPreferences;
import com.badlogic.citadel.PlayerRelatedMethods.Player;
import com.badlogic.citadel.PlayerRelatedMethods.SpellBook;
import com.badlogic.citadel.PlayerRelatedMethods.SpellList;
import com.badlogic.citadel.Screens.OnGameScreens.IntroGameScreen;
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



    @Override
    public void create() {
        appPrefs = new AppPreferences();
        menuScreen = new MainMenuScreen(this);
        batch = new SpriteBatch();
        //titleFont = new BitmapFont();
        density = Gdx.graphics.getDensity();

        //TODO à changer pour la version finale -- player et grimoire virtuel pour les tests
        player = new Player(10,15,9,0,10);
        player.setCurrentMagic(9);
        player.setCurrentLuck(10);
        player.setCurrentVitality(15);
        SpellBook grim = player.getGrimoire();
        grim.putIn(SpellList.Sorts.HABILITE);
        grim.putIn(SpellList.Sorts.CHANCE);
        grim.putIn(SpellList.Sorts.ENDURANCE);
        grim.putIn(SpellList.Sorts.LEVITATION);
        grim.putIn(SpellList.Sorts.OR_DU_SOT);
        grim.putIn(SpellList.Sorts.PROTECTION);
        grim.putIn(SpellList.Sorts.TELEPATHIE);
        grim.putIn(SpellList.Sorts.ILLUSION);
        grim.putIn(SpellList.Sorts.FORCE);
        IntroGameScreen introScreen = new IntroGameScreen(this);
        setScreen(introScreen);
        /*------ fin du temporaire ---*/
        //setScreen(menuScreen);

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

package com.badlogic.citadel.Screens.OnGameScreens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogBox;
import com.badlogic.citadel.Screens.HUD;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.*;

import static com.badlogic.citadel.DialogWindows.DialogBoxMethods.continueDialogBox;

//132
public class LibraryGameScreen extends ApplicationAdapter implements Screen {
    private Citadel game;
    private Stage stage;
    private HUD hud;

    private DialogBox dialogBox132 = new DialogBox("Narrator");
    private DialogBox dialogBox018 = new DialogBox("Book about Balthus Dire");
    private DialogBox dialogBox238 = new DialogBox("Book about the secrets of the Black Tower");
    private DialogBox dialogBox375 = new DialogBox("Book about the creatures of the Kingdom of Craggen Rock");
    private DialogBox dialogBox084 = new DialogBox("Narrator");
    private DialogBox dialogBox031 = new DialogBox("Narrator");
    private DialogBox dialogBox263 = new DialogBox("Narrator");
    private DialogBox dialogBox135 = new DialogBox("Narrator");
    private DialogBox dialogBox063 = new DialogBox("Narrator");
    private DialogBox dialogBox326 = new DialogBox("Narrator");

    public LibraryGameScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        hud = new HUD(game,stage);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();
        dialogBox132.show(stage);
    }

    public void create(){
        dialogBox132.text("You enter a room which is evidently a library of some sort. Books stretch from ceiling to floor " +
            "on each wall and several tables and chairs are lined down the centre of the room. At the far end sits a dark-" +
            "skinned man who looks up at you from a book over a narrow eyeglasses. Behind him is a door. He asks you for " +
            "what book you are looking for.");
        dialogBox018.text("Balthus is apparently third in a line of Sorcerer-Warlords, ruling over the Black Tower and the " +
            "Kingdom of Craggen Rock. He rose to power after the death of his father, several years ago. The Dires have been " +
            "masters of Black Sorcery for generations, but their strength and power last during the night-time only; sunlight " +
            "is like poison to them.\nYou notice the librarian holding his ear, like listening to something. He looks at you.");
        dialogBox238.text("");
    }

    public void input(){
        continueDialogBox(dialogBox132,dialogBox018,"Read about\nBalthus Dire",stage,hud);
        continueDialogBox(dialogBox132,dialogBox238,"Read about the\nsecrets of the Black Tower",stage,hud);
        continueDialogBox(dialogBox132,dialogBox375, "Read about the\ncreatures of the Kingdom of Craggen Rock",stage,hud);

        continueDialogBox(dialogBox018,dialogBox084,"Read another book",stage,hud);
        continueDialogBox(dialogBox084,stage,new PrisonGameScreen(game),game);
        continueDialogBox(dialogBox018,dialogBox031,"Leave the room",stage,hud);
        continueDialogBox(dialogBox031, stage, new DinnerRoomScreenGame(game),game);

        continueDialogBox(dialogBox238,dialogBox018,"Read about\nBalthus Dire",stage,hud);
        continueDialogBox(dialogBox238,dialogBox375,"Read about the\ncreatures of the Kingdom of Craggen Rock",stage,hud);
        continueDialogBox(dialogBox238,dialogBox031,"Leave the room",stage,hud);

        continueDialogBox(dialogBox375,dialogBox263,"The Calacorm",stage,hud);
        continueDialogBox(dialogBox375,dialogBox135,"The Miks",stage,hud);
        continueDialogBox(dialogBox375,dialogBox063,"The Ganjees",stage,hud);
        continueDialogBox(dialogBox063,dialogBox375, hud, stage);

        continueDialogBox(dialogBox135,dialogBox326,hud,stage);
        continueDialogBox(dialogBox263,dialogBox326,hud,stage);

        continueDialogBox(dialogBox326,dialogBox084,"Browse the library",stage,hud);
        continueDialogBox(dialogBox326,dialogBox031,"Leave the room",stage,hud);

    }

    public void resize(int width, int height){
        stage.getViewport().update(width, height, true);
    }

    public void dispose(){
        hud.dispose();
        stage.dispose();
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void hide() {

    }
}

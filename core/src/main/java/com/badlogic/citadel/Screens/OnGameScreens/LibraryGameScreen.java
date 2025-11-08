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
    private DialogBox dialogBox263 = new DialogBox("Book about the creatures of the Kingdom of Craggen Rock");
    private DialogBox dialogBox135 = new DialogBox("Book about the creatures of the Kingdom of Craggen Rock");
    private DialogBox dialogBox063 = new DialogBox("Book about the creatures of the Kingdom of Craggen Rock");
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
        dialogBox238.text("The Black Tower was built by Balthus Dire's grandfather. As it became a sanctuary for the forces " +
            "of evil, law and order gradually made way for chaos as the monstrous creatures battled their way up the power " +
            "hierarchy. Dire's grandfather eventually found it necessary to protect himself from his minions by setting up " +
            "various trap between him and the creatures. Most notable of these being the Doompit trap and a magical Combination " +
            "lock which code is 217.");
        dialogBox375.text("Which creatures do you want to know about?");
        dialogBox084.text("As you study the shelves, you hear a commotion behind you. You wheel around in time to see Orc-" +
            "like creatures, armed and on guard, materializing one after the other behind you. They advance and surround you." +
            " The tallest one moves his face close to yours and blows a puff of breath straight into eyes. The room spins " +
            "and you slump to the ground, unconscious.");
        dialogBox031.text("You leave the room through the door at the far end, which opens into a short passageway ending " +
            "at a large wooden door. The handle on this door turns, letting you into a large chamber.");
        dialogBox263.text("Calacorms are reliable and contented creatures. They are large reptilian beasts, with grey skin, " +
            "long tails and two heads, which chatter at each other incessantly. They want for little, having no great ambitions" +
            " in life beyond their jobs, their food (they live on dead snakes) and their home comforts. Rather out of character " +
            "with their placid nature is their grat delight in the screams and pain of torture. Strangely enough, they are " +
            "terrified by mice, in spite of their huge size.");
        dialogBox135.text("Miks are master of illusion, able to change themselves into any shape or form they wish. It is not " +
            "certain what their true nature is, as few have seen them in their natural form, but they have been described by fairly " +
            "reliable sources as a thin, elf-like race. They are an aggressive lot, but their favoured weapon is a Needleknife (" +
            "a thin stiletto-like dagger) with which they can only attack from close range. Although they can change themselves " +
            "into any form, they are unable to use metal in their disguises. They are also unable to cast their illusions over other " +
            "objects.");
        dialogBox063.text("You turn to the index and look up the reference. Turning to the correct page, you are dismayed to " +
            "find that the section has been ripped out of the book !");
        dialogBox326.text("You replace the book");

    }

    public void input(){
        continueDialogBox(dialogBox132,dialogBox018,"Read about\nBalthus Dire",stage,hud);
        continueDialogBox(dialogBox132,dialogBox238,"Read about the\nsecrets of the Black Tower",stage,hud,()->{
            game.setCombinationLock(true);
        });
        continueDialogBox(dialogBox132,dialogBox375, "Read about the\ncreatures of the Kingdom of Craggen Rock",stage,hud);

        continueDialogBox(dialogBox018,dialogBox084,"Read another book",stage,hud);
        continueDialogBox(dialogBox084,stage,new PrisonGameScreen(game),game,null );
        continueDialogBox(dialogBox018,dialogBox031,"Leave the room",stage,hud);
        continueDialogBox(dialogBox031, stage, new DinnerRoomScreenGame(game),game, null);

        continueDialogBox(dialogBox238,dialogBox018,"Read about\nBalthus Dire",stage,hud);
        continueDialogBox(dialogBox238,dialogBox375,"Read about the\ncreatures of the Kingdom of Craggen Rock",stage,hud);
        continueDialogBox(dialogBox238,dialogBox031,"Leave the room",stage,hud);

        continueDialogBox(dialogBox375,dialogBox263,"The Calacorm",stage,hud);
        continueDialogBox(dialogBox375,dialogBox135,"The Miks",stage,hud);
        continueDialogBox(dialogBox375,dialogBox063,"The Ganjees",stage,hud);
        continueDialogBox(dialogBox063,dialogBox375, hud, stage,null);

        continueDialogBox(dialogBox135,dialogBox326,hud,stage,null);
        continueDialogBox(dialogBox263,dialogBox326,hud,stage,null);

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
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        hud.update(v);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        game.batch.begin();
        BitmapFont font = new BitmapFont();
        font.draw(game.batch, "Rhino door" , Gdx.graphics.getWidth()*0.25f, Gdx.graphics.getHeight()*0.3f);
        game.batch.end();
        stage.draw();
    }

    @Override
    public void hide() {

    }
}

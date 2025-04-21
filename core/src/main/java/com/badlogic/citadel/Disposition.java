package com.badlogic.citadel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Disposition {
    /* MAIN MENU */
    public static final Rectangle NEW_GAME_RECT = new Rectangle(8, 7,2,1);
    public static final Rectangle LOAD_GAME_RECT = new Rectangle(8,6,2,1);
    public static final Rectangle CREDITS_RECT = new Rectangle(8,5,4,1);
    public static final Rectangle SUCCESS_RECT = new Rectangle(8,4,4,1);
    public static final Rectangle EXIT_RECT = new Rectangle(0.01f,0.5f,2,1);

    public static boolean newGameButton(){
        return ((Gdx.input.getX() >=  NEW_GAME_RECT.x && Gdx.input.getX() <= NEW_GAME_RECT.x + NEW_GAME_RECT.width)
            && Gdx.input.getY() >= NEW_GAME_RECT.y && Gdx.input.getY() <= NEW_GAME_RECT.y + NEW_GAME_RECT.height);
    }

    public static boolean loadGameButton(){
        return ((Gdx.input.getX() >= LOAD_GAME_RECT.x && Gdx.input.getX() <= LOAD_GAME_RECT.x + LOAD_GAME_RECT.width)
        && Gdx.input.getY() >= LOAD_GAME_RECT.y && Gdx.input.getY() <= LOAD_GAME_RECT.y + LOAD_GAME_RECT.height);
    }

    public boolean creditsButton(){
        return false; //todo
    }

    public boolean successButton(){
        return false; //todo
    }

    public static boolean exitButton(){
        return ((Gdx.input.getX() >= EXIT_RECT.x && Gdx.input.getX() <= EXIT_RECT.x + EXIT_RECT.width)
        && Gdx.input.getY() >= EXIT_RECT.y && Gdx.input.getY() <= EXIT_RECT.y);
    }
}

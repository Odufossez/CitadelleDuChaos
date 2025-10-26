package com.badlogic.citadel.DialogWindows;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.Item;
import com.badlogic.citadel.PlayerRelatedMethods.SpellList;
import com.badlogic.citadel.Screens.HUD;
import com.badlogic.citadel.Screens.OnGameScreens.RhinoDoorGameScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.awt.*;

public abstract class DialogBoxMethods {

    /**
     * Method to generate a dialogbox when the only possibility is to continue
     *
     * @param from the dialogBox in which the button is integrated
     * @param to   the dialogBox the button is linked to
     */
    public static void continueDialogBox(DialogBox from, DialogBox to, HUD hud, Stage stage) {
        from.button("Continue", new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                from.hide();
                stage.addActor(to);
                to.show(stage);
                hud.bringToFront();
                return true;
            }
        });
    }

    /**
     *
     * @param from
     * @param to
     * @param text
     * @param stage
     * @param hud
     */
    public static void continueDialogBox(DialogBox from, DialogBox to, String text, Stage stage, HUD hud){
        from.button(text, new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                from.hide();
                stage.addActor(to);
                to.show(stage);
                hud.bringToFront();
                return true;
            }
        });
    }

    /**
     * Method to generate a dialogbox (to) when the only possibility is to continue, and it has to remove an Item form
     * the inventory
     *
     * @param from     the dialogbox that displays the button
     * @param to       the dialogbox to display with that choice
     * @param hud      the HUD of the game
     * @param stage    the current stgae
     * @param game     the current game (e.g Citadel)
     * @param toRemove the Item.Items to remove from the inventory
     */
    public static void continueDialogBox(DialogBox from, DialogBox to, HUD hud, Stage stage, Citadel game, Item.Items toRemove) {
        from.button("Continue", new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                from.hide();
                game.getPlayer().getInventory().removeFrom(toRemove);
                stage.addActor(to);
                to.show(stage);
                hud.bringToFront();
                return true;
            }
        });
    }

    /**
     * A method to continue from a dialogbox with only one choice that sets a new screen
     *
     * @param from       the dialogbox that displays the button
     * @param stage      the current stage
     * @param nextScreen the new screen to display
     * @param game       the current game
     */
    public static void continueDialogBox(DialogBox from, Stage stage, Screen nextScreen, Citadel game) {
        from.button("Continue", new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                from.hide();
                stage.clear();
                game.setScreen(nextScreen);
                return true;
            }
        });
    }

    /**
     * A method to continue from a dialogbox with only one choice that sets a new screen with a button that says
     * something else than "Continue"
     *
     * @param from       the dialogbox that displays the button
     * @param text       the personnalised text for the button instead of "Continue"
     * @param stage      the current stage
     * @param nextScreen the new screen to display
     * @param game       the current game
     */
    public static void continueDialogBox(DialogBox from, String text, Stage stage, Screen nextScreen, Citadel game) {
        from.button(text, new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                from.hide();
                stage.clear();
                game.setScreen(nextScreen);
                return true;
            }
        });
    }


    /**
     * A method to display a Dialogalert like a pop up when a spell is about to be used
     *
     * @param from  the dialogbox that displays the choice
     * @param to    the dialogbox that has to be displayed after the choice is "yes"
     * @param sort  the spell about to be cast
     * @param hud   the HUD of the game
     * @param stage the current stage
     */
    public static void alertSpellDialog(DialogBox from, DialogBox to, SpellList.Sorts sort, HUD hud, Stage stage, Citadel game) {
        from.button("Cast " + SpellList.getName(sort), new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                DialogAlert alert = new DialogAlert("Do you want to cast " + SpellList.getName(sort) + "?");
                alert.text("An usage of " + SpellList.getName(sort) + " will be remove from your spellbook");
                alert.button("Yes", com.badlogic.gdx.graphics.Color.BLACK, new InputListener() {
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        game.getPlayer().getGrimoire().removeFrom(sort);
                        alert.hide();
                        from.hide();
                        stage.addActor(to);
                        to.show(stage);
                        hud.bringToFront();
                        return true;
                    }
                });
                alert.button("No", Color.BLACK, new InputListener() {
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        alert.hide();
                        hud.bringToFront();
                        return true;
                    }
                });
                alert.show(stage);
                hud.bringToFront();
                return true;
            }
        });
    }


}

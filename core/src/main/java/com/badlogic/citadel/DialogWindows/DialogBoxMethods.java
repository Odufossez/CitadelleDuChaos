package com.badlogic.citadel.DialogWindows;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.Item;
import com.badlogic.citadel.PlayerRelatedMethods.SpellList;
import com.badlogic.citadel.Screens.HUD;
import com.badlogic.citadel.Screens.OnGameScreens.GameOverScreen;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

import static com.badlogic.citadel.Dice.doubleDice;

public abstract class DialogBoxMethods {

    /**
     * Method to generate a dialogbox when the only possibility is to continue
     *
     * @param from the dialogBox in which the button is integrated
     * @param to   the dialogBox the button is linked to
     */
    public static void continueDialogBox(DialogBox from, DialogBox to, HUD hud, Stage stage,Runnable onOk) {
        from.button("Continue", new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                from.hide();
                stage.addActor(to);
                if (onOk!=null)onOk.run();
                to.show(stage);
                hud.bringToFront();
                return true;
            }
        });
    }

    /**
     * A method to generate a dialogBox with a personalized text button
     *
     * @param from  the dialogBox in which the button is integrated
     * @param to    in the dialogBox the button is linked to
     * @param text  the text of the button
     * @param stage the stage of the game
     * @param hud   the HUD of the game
     */
    public static void continueDialogBox(DialogBox from, DialogBox to, String text, Stage stage, HUD hud) {
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

    public static void continueDialogBox(DialogBox from, DialogBox to, String text, Stage stage, HUD hud, Runnable onOk) {
        from.button(text, new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                from.hide();
                onOk.run();
                stage.addActor(to);
                to.show(stage);
                hud.bringToFront();
                return true;
            }
        });
    }

    public static void continueDialogBox(DialogBox from, String text, HUD hud, Runnable onOk) {
        from.button(text, new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                from.hide();
                if (onOk!=null)onOk.run();
                hud.bringToFront();
                return true;
            }
        });
    }

    /**
     * Method to generate a dialogbox (to) when the only possibility is to continue, and it has to remove an Item form
     * the inventory
     *
     * @param from  the dialogbox that displays the button
     * @param to    the dialogbox to display with that choice
     * @param hud   the HUD of the game
     * @param stage the current stgae
     * @param game  the current game (e.g Citadel)
     * @param item  the item to move to/from the inventory
     * @param add   true if the item has to be added to the inventory, false if it has to be removed
     */
    public static void continueDialogBox(DialogBox from, DialogBox to, HUD hud, Stage stage, Citadel game,
                                         Item.Items item, boolean add) {
        if (add) { //ajouter
            from.button("Take " + Item.Items.getName(item), new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    from.hide();
                    game.getPlayer().getInventory().putIn(item);
                    stage.addActor(to);
                    to.show(stage);
                    hud.bringToFront();
                    return true;
                }
            });
        } else { //retirer
            from.button("Give up on " + Item.Items.getName(item), new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    from.hide();
                    game.getPlayer().getInventory().removeFrom(item);
                    stage.addActor(to);
                    to.show(stage);
                    hud.bringToFront();
                    return true;
                }
            });
        }
    }

    /**
     * Method to go to a new screen while adding or removing an item from the inventory
     *
     * @param from  the dialogbox that displays the button
     * @param to    the screen to display after
     * @param hud   the hud of the game
     * @param stage the current stage
     * @param game  the current game (e.g Citadel)
     * @param item  the item to move to/from the inventory
     * @param add   true if the item has to be added to the inventory, false if it has to be removed
     */
    public static void continueDialogBox(DialogBox from, Screen to, HUD hud, Stage stage, Citadel game,
                                         Item.Items item, boolean add) {
        if (add) { //ajouter
            from.button("Take " + Item.Items.getName(item), new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    from.hide();
                    game.getPlayer().getInventory().putIn(item);
                    stage.clear();
                    game.setScreen(to);
                    hud.bringToFront();
                    return true;
                }
            });
        } else { //retirer
            from.button("Give up on " + Item.Items.getName(item), new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    from.hide();
                    game.getPlayer().getInventory().removeFrom(item);
                    stage.clear();
                    game.setScreen(to);
                    hud.bringToFront();
                    return true;
                }
            });
        }
    }

    public static void continueDialogBox(DialogBox from, DialogBox to, HUD hud, Stage stage, Citadel game, int amount
        , boolean add) {
        if (add) {
            from.button("Take " + amount + " golds", new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    from.hide();
                    game.getPlayer().setGold(game.getPlayer().getGold() + amount);
                    stage.addActor(to);
                    to.show(stage);
                    hud.bringToFront();
                    return true;
                }
            });
        } else {
            from.button("Give up on " + amount + " golds", new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    from.hide();
                    game.getPlayer().setGold(game.getPlayer().getGold() - amount);
                    stage.addActor(to);
                    to.show(stage);
                    hud.bringToFront();
                    return true;
                }
            });
        }
    }

    /**
     * A method to continue from a dialogbox with only one choice that sets a new screen
     *
     * @param from       the dialogbox that displays the button
     * @param stage      the current stage
     * @param nextScreen the new screen to display
     * @param game       the current game
     * @param onOk       runnable to run an event after the choice
     */
    public static void continueDialogBox(DialogBox from, Stage stage, Screen nextScreen, Citadel game, Runnable onOk) {
        from.button("Continue", new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                from.hide();
                stage.clear();
                if (onOk!=null) onOk.run();
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
        from.button("Cast\n" + SpellList.getName(sort), new InputListener() {
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
                alertNoButton(alert, stage, hud);
                alert.show(stage);
                hud.bringToFront();
                return true;
            }
        });
    }

    public static void alertSpellDialog(DialogBox from, DialogBox to, SpellList.Sorts sort, HUD hud, Stage stage, Citadel game, Runnable onOk) {
        from.button("Cast\n" + SpellList.getName(sort), new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                DialogAlert alert = new DialogAlert("Do you want to cast " + SpellList.getName(sort) + "?");
                alert.text("An usage of " + SpellList.getName(sort) + " will be remove from your spellbook");
                alert.button("Yes", com.badlogic.gdx.graphics.Color.BLACK, new InputListener() {
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        game.getPlayer().getGrimoire().removeFrom(sort);
                        onOk.run();
                        alert.hide();
                        from.hide();
                        stage.addActor(to);
                        to.show(stage);
                        hud.bringToFront();
                        return true;
                    }
                });
                alertNoButton(alert, stage, hud);
                alert.show(stage);
                hud.bringToFront();
                return true;
            }
        });
    }

    public static void alertSpellDialog(DialogBox from, SpellList.Sorts sort, HUD hud, Stage stage, Citadel game, Runnable onOk) {
        from.button("Cast\n" + SpellList.getName(sort), new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                DialogAlert alert = new DialogAlert("Do you want to cast " + SpellList.getName(sort) + "?");
                alert.text("An usage of " + SpellList.getName(sort) + " will be remove from your spellbook");
                alert.button("Yes", com.badlogic.gdx.graphics.Color.BLACK, new InputListener() {
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        game.getPlayer().getGrimoire().removeFrom(sort);
                        onOk.run();
                        alert.hide();
                        from.hide();
                        hud.bringToFront();
                        return true;
                    }
                });
                alertNoButton(alert, stage, hud);
                alert.show(stage);
                hud.bringToFront();
                return true;
            }
        });
    }

    /**
     * A method to display a "No" button on a DialogAlert
     *
     * @param alert the dialogAlert to add the button to
     * @param stage the stage of the game
     * @param hud   the HUD of the game
     */
    public static void alertNoButton(DialogAlert alert, Stage stage, HUD hud) {
        alert.button("No", Color.BLACK, new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                alert.hide();
                hud.bringToFront();
                return true;
            }
        });
    }

    public static void alertPlayerPV(int amountPV, Stage stage, Citadel game, Runnable onOk) {
        DialogAlert alert = new DialogAlert("You have lost " + amountPV + "PV");
        alert.button("Ok", Color.BLACK, new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                alert.hide();
                game.getPlayer().setCurrentVitality(game.getPlayer().getCurrentVitality() - amountPV);
                if (game.getPlayer().isDead()) {
                    game.setScreen(new GameOverScreen(game));
                }
                if(onOk !=null)onOk.run();
                return true;
            }
        });
        alert.show(stage);
    }

    /**
     * A notification for the player, only one button ok to close the alert
     * @param title
     * @param message
     * @param stage
     * @param onOk
     */
    public static void alertNotification(String title, String message, Stage stage, Runnable onOk) {
        DialogAlert alert = new DialogAlert(title);
        alert.text(message);
        alert.button("Ok", Color.BLACK, new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                alert.hide();
                if (onOk != null) onOk.run();
                return true;
            }
        });
        alert.show(stage);
    }

    public static void dialogGetLucky(DialogBox from, DialogBox lucky, DialogBox unlucky, Stage stage, HUD hud, Citadel game) {
        from.button("Get Lucky !", new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                DialogBox result;
                if (game.getPlayer().getCurrentLuck() >= doubleDice()) {
                    result = lucky;
                } else {
                    result = unlucky;
                }
                game.getPlayer().decreaseLuck();
                from.hide();
                result.show(stage);
                hud.bringToFront();
                return true;
            }
        });
    }

    public static void alertYesNo(String title, String message, Stage stage, Runnable onYes, Runnable onNo){
        DialogAlert alert = new DialogAlert(title);
        alert.text(message);
        alert.button("Yes", Color.BLACK, new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                alert.hide();
                if (onYes!=null)onYes.run();
                return true;
            }
        });
        alert.button("No", Color.BLACK, new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                alert.hide();
                if (onNo!=null)onNo.run();
                return true;
            }
        });

        alert.show(stage);
    }

}

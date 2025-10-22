package com.badlogic.citadel.Screens.OnGameScreens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogAlert;
import com.badlogic.citadel.DialogWindows.DialogBox;
import com.badlogic.citadel.Dice;
import com.badlogic.citadel.PlayerRelatedMethods.SpellList;
import com.badlogic.citadel.Screens.HUD;
import com.badlogic.citadel.Screens.Skins;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.*;

//251
public class TheCourtyardGameScreen extends ApplicationAdapter implements Screen {
    Citadel game;
    private Stage stage;
    private HUD hud;

    DialogBox dialogBox1 = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);

    DialogBox dialogBox222 = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBox222_Help = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBox222_Help2 = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBox222_Help3 = new DialogBox("The old man" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBox222_Help4 = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBox222_Help5 = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBox222_Sword = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBox222_Illusion = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBox222_Protection = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBox222_Weakness = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBoxTumbling = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);

    DialogBox getLucky = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);

    DialogBox dialogBox179 = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBox378 = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBox125 = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBox341 = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBox209 = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBoxGreyTentacle = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBoxLevitation = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);
    DialogBox dialogBoxFire = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);

    DialogBox dialogBox321 = new DialogBox("Narrator" , Skins.PLAIN_JAMES_SKIN);

    public TheCourtyardGameScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        hud = new HUD(game,stage);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();
    }

    @Override
    public void create() {
        dialogBox1.text("You are standing in the shadow of the rampart surrounding the courtyard." +
            "How do you want to proceed? You could sneak your way to the next door or rush it.\n" +
            "Maybe go talk to the bystanders on your left ?");
    }

    public void input(){
        dialogBox1.button("Sneak" , new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox1.hide();

                //Les dialogues de cette branche
                dialogBox222.text("As you scoot your way to the door along the rampart, you see a man lying down.\n" +
                    "His voice low, but he is asking for help. He seems to be suffering. What to do ?");
                dialogBox222_Help.text("It is an old man. Seems a mass has hit him on the head. You don't have any healing" +
                    " potion or remedy but you could try an other way. Or move on.");
                dialogBox222_Help2.text("He seems to recover."); //383
                dialogBox222_Help3.text("Thank you. I taught I would die here ! Beware of the Ganjees ! They are really" +
                    " dangerous !");
                dialogBox222_Help4.text("Suddenly his eyes change and long piercing teeth bite down on your arm.");
                dialogBox222_Sword.text("You draw your sword but quickly realise the old man is not controlling his actions.\n" +
                    "With mercy, you hit his head with the pommel of you sword. He screams and release you.");
                dialogBox222_Illusion.text("You concentrate on your arm, he starts to harden and the color change to a \n" +
                    "silver-like tint. The old man seems surprised but no way to get away from him. You'll have to draw\n" +
                    "your sword and fight.");
                dialogBox222_Protection.text("The spell has no effect. You have to draw your sword and fight.");
                dialogBox222_Weakness.text("The spell works ! His grasp goes slack and he fall to the ground.\n" +
                    "You take some time to recover and patch up your arm before continuing.");
                dialogBoxTumbling.text("You can't see well in the shadow of the rampart. Suddenly, a tumbling stone makes\n" +
                    " you lose your balance and you are dangerously staggering close to a well.");
                /*--------------------------------------------------------*/

                stage.addActor(dialogBox222);
                dialogBox222.show(stage);
                inputManOnTheFloor();
                hud.bringToFront();
                return true;
            }
        });

        dialogBox1.button("Rush" , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox1.hide();

                //Les dialogues de cette branche
                dialogBox179.text("You rush through the courtyard when arrows start raining on your position ! You can't\n" +
                    " see from where they come from. ");
                /*------------------------------------------------------*/
                stage.addActor(dialogBox179);
                dialogBox179.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox1.button("Talk" , new InputListener());
    }

    //222
    public void inputManOnTheFloor(){
        dialogBox222.button("Help the person" , new InputListener(){
           public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
               dialogBox222.hide();
               stage.addActor(dialogBox222_Help);
               dialogBox222_Help.show(stage);
               hud.bringToFront();
               return true;
           }
        });
        dialogBox222.button("Ignore the person" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox222.hide();
                stage.addActor(dialogBoxTumbling);
                dialogBoxTumbling.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox222_Help.button("I can't help" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox222_Help.hide();
                stage.addActor(dialogBoxTumbling);
                dialogBoxTumbling.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.ENDURANCE)){
            dialogBox222_Help.button("Cast Endurance" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    DialogAlert alert = new DialogAlert("Do you want to cast Endurance ?" , Skins.PLAIN_JAMES_SKIN);
                    alert.text("    An usage of Endurance will be remove from your spellbook.");
                    alert.button("Yes" , Color.BLACK , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            game.getPlayer().getGrimoire().removeFrom(SpellList.Sorts.ENDURANCE);
                            alert.hide();
                            dialogBox222_Help.hide();
                            stage.addActor(dialogBox222_Help2);
                            dialogBox222_Help2.show(stage);
                            hud.bringToFront();
                            return true;
                        }
                    });
                    alert.button("No" , Color.BLACK , new InputListener() {
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

        dialogBox222_Help2.button("Continue" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox222_Help2.hide();
                stage.addActor(dialogBox222_Help3);
                dialogBox222_Help3.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        dialogBox222_Help3.button("Ask about the Citadel" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox222_Help3.hide();
                DialogAlert alert = new DialogAlert("You have lost 2 HP !" , Skins.PLAIN_JAMES_SKIN);
                alert.button("Ok" , new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        alert.hide();
                        if (game.getPlayer().isDead()) {
                            game.setScreen(new GameOverScreen(game));
                            hud.bringToFront();
                            return true;
                        }
                        game.getPlayer().isTouchedInCombat();
                        hud.bringToFront();
                        return true;
                    }
                });
                alert.show(stage);
                stage.addActor(dialogBox222_Help4);
                dialogBox222_Help4.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox222_Help4.button("Draw your sword" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox222_Help4.hide();
                game.getPlayer().isTouchedInCombat();
                DialogAlert alert = new DialogAlert("You have lost 2 HP !" , Skins.PLAIN_JAMES_SKIN);
                alert.button("Ok" , new InputListener() {
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        alert.hide();
                        if (game.getPlayer().isDead()) {
                            game.setScreen(new GameOverScreen(game));
                            hud.bringToFront();
                            return true;
                        }
                        return true;
                    }
                });
                alert.show(stage);
                stage.addActor(dialogBox222_Sword);
                dialogBox222_Sword.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.ILLUSION)){
            dialogBox222_Help4.button("Cast Illusion" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    DialogAlert alert = new DialogAlert("Do you want to cast Illusion ?" , Skins.PLAIN_JAMES_SKIN);
                    alert.text("    An usage of Illusion will be remove from your spellbook.");
                    alert.button("Yes" , Color.BLACK , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            game.getPlayer().getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                            game.getPlayer().isTouchedInCombat();
                            DialogAlert alertPV = new DialogAlert("You have lost 2 HP !" , Skins.PLAIN_JAMES_SKIN);
                            alertPV.button("Ok" , new InputListener() {
                                @Override
                                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                    alertPV.hide();
                                    if (game.getPlayer().isDead()) {
                                        game.setScreen(new GameOverScreen(game));
                                        hud.bringToFront();
                                    }
                                    return true;
                                }
                            });
                            stage.addActor(alertPV);
                            alertPV.show(stage);
                            alert.hide();
                            dialogBox222_Help4.hide();
                            stage.addActor(dialogBox222_Illusion);
                            dialogBox222_Illusion.show(stage);
                            return true;
                        }
                    });
                    alert.button("No" , Color.BLACK , new InputListener() {
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
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.PROTECTION)){
            dialogBox222_Help4.button("Cast Protection" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    DialogAlert alert = new DialogAlert("Do you want to cast Protection ?" , Skins.PLAIN_JAMES_SKIN);
                    alert.text("    An usage of Protection will be remove from your spellbook.");
                    alert.button("Yes" , Color.BLACK , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            game.getPlayer().getGrimoire().removeFrom(SpellList.Sorts.PROTECTION);
                            alert.hide();
                            dialogBox222_Help4.hide();
                            stage.addActor(dialogBox222_Protection);
                            dialogBox222_Protection.show(stage);
                            hud.bringToFront();
                            return true;
                        }
                    });
                    alert.button("No" , Color.BLACK , new InputListener() {
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
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FAIBLESSE)){
            dialogBox222_Help4.button("Cast Weakness" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    DialogAlert alert = new DialogAlert("Do you want to cast Weakness ?" , Skins.PLAIN_JAMES_SKIN);
                    alert.text("    An usage of Weakness will be remove from your spellbook.");
                    alert.button("Yes" , Color.BLACK , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            game.getPlayer().getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                            game.getPlayer().setCurrentVitality(game.getPlayer().getCurrentVitality() - 1);
                            DialogAlert alertPV = new DialogAlert("You have lost 1 HP !" , Skins.PLAIN_JAMES_SKIN);
                            alertPV.button("Ok" , new InputListener() {
                                @Override
                                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                    alertPV.hide();
                                    if (game.getPlayer().isDead()) {
                                        game.setScreen(new GameOverScreen(game));
                                        hud.bringToFront();
                                    }
                                    return true;
                                }
                            });
                            alertPV.show(stage);
                            alert.hide();
                            dialogBox222_Help4.hide();
                            stage.addActor(dialogBox222_Weakness);
                            dialogBox222_Weakness.show(stage);
                            hud.bringToFront();
                            return true;
                        }
                    });
                    alert.button("No" , Color.BLACK , new InputListener() {
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

        dialogBoxTumbling.button("Get lucky" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxTumbling.hide();
                if (game.getPlayer().getCurrentLuck() >= Dice.doubleDice()){
                    getLucky.text("You manage to steady your balance. You are now safe and can continue your journey.\n" +
                        "(You lost a point of luck.)");
                    getLucky.button("Continue" , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            getLucky.hide();
                            stage.clear();
                            game.setScreen(new TreeGameScreen(game));
                            hud.bringToFront();
                            return true;
                        }
                    });
                }else{
                    getLucky.text("You slip and fall on the well.");
                    getLucky.button("Continue" , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            getLucky.hide();
                            stage.clear();
                            game.setScreen(new WellGameScreen(game));
                            hud.bringToFront();
                            return true;
                        }
                    });
                }
                stage.addActor(getLucky);
                getLucky.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox222_Illusion.button("Continue" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox222_Illusion.hide();
                stage.addActor(dialogBox222_Sword);
                dialogBox222_Sword.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        dialogBox222_Protection.button("Continue" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox222_Protection.hide();
                stage.addActor(dialogBox222_Sword);
                dialogBox222_Sword.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        dialogBox222_Weakness.button("Continue" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox222_Weakness.hide();
                stage.addActor(dialogBoxTumbling);
                dialogBoxTumbling.show(stage);
                hud.bringToFront();
                return true;
            }
        });
    }

    //321
    public void inputCampFire(){

    }

    //179
    public void inputArrows(){

    }

    public void combat71(){

    }

    /*--------- METHODES DE SCREEN ----------*/

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        hud.update(delta);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        game.batch.begin();
        BitmapFont font = new BitmapFont();
        font.draw(game.batch, "In front of the gate" , Gdx.graphics.getWidth()*0.25f, Gdx.graphics.getHeight()*0.3f);
        game.batch.end();
        stage.draw();
    }

    @Override
    public void hide() {

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        hud.dispose();
        stage.dispose();
    }
}

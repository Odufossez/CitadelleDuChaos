package com.badlogic.citadel.Screens.OnGameScreens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogAlert;
import com.badlogic.citadel.DialogWindows.DialogBox;
import com.badlogic.citadel.Dice;
import com.badlogic.citadel.Methods.Monster;
import com.badlogic.citadel.PlayerRelatedMethods.SpellList;
import com.badlogic.citadel.Screens.HUD;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Event;
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

    DialogBox dialogBox1 = new DialogBox("Narrator");

    DialogBox dialogBox222 = new DialogBox("Narrator");
    DialogBox dialogBox222_Help = new DialogBox("Narrator");
    DialogBox dialogBox222_Help2 = new DialogBox("Narrator");
    DialogBox dialogBox222_Help3 = new DialogBox("The old man");
    DialogBox dialogBox222_Help4 = new DialogBox("Narrator");
    DialogBox dialogBox222_Help5 = new DialogBox("Narrator");
    DialogBox dialogBox222_Sword = new DialogBox("Narrator");
    DialogBox dialogBox222_Illusion = new DialogBox("Narrator");
    DialogBox dialogBox222_Protection = new DialogBox("Narrator");
    DialogBox dialogBox222_Weakness = new DialogBox("Narrator");
    DialogBox dialogBoxTumbling = new DialogBox("Narrator");

    DialogBox getLucky = new DialogBox("Narrator");

    DialogBox dialogBox179 = new DialogBox("Narrator");
    DialogBox dialogBox179_1 = new DialogBox("Narrator");
    DialogBox dialogBox179_2 = new DialogBox("Narrator");
    DialogBox dialogBox179_3 = new DialogBox("Narrator");
    DialogBox dialogBox378 = new DialogBox("Narrator");
    DialogBox dialogBox378_1 = new DialogBox("Narrator");
    DialogBox dialogBox378_2 = new DialogBox("Narrator");
    DialogBox dialogBoxGetLucky125 = new DialogBox("Narrator");
    DialogBox dialogBox341 = new DialogBox("Narrator");
    DialogBox dialogBox209 = new DialogBox("Narrator");
    DialogBox dialogBoxGreyTentacle = new DialogBox("Narrator");
    DialogBox dialogBoxGreyTentacle_1 = new DialogBox("Narrator");
    DialogBox dialogBoxLevitation = new DialogBox("Narrator");
    DialogBox dialogBoxLevitation_1 = new DialogBox("Narrator");
    DialogBox dialogBoxFire = new DialogBox("Narrator");

    DialogBox dialogBox321 = new DialogBox("Narrator");

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
        dialogBox1.show(stage);
        hud.bringToFront();
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
                dialogBox179.text("You step out of the shadow towards the center of the courtyard when you hear someone shout\n" +
                    "'Halt! Stop moving !'");
                dialogBox179_1.text("You try and fail to see who shout.");
                dialogBox179_2.text("Once again, you hear someone shouting but this time an arrow hiss through the air and\n" +
                    "sticks into the ground right next to your left feet.");
                dialogBox179_3.text("You still fail to see anything. Your enemy is invisible. You have to do something.");
                dialogBox378.text("You take a couple steps and an arrow stucks into the ground next to your foot.");
                dialogBox378_1.text("Another steps and an arrow rips your coat and catch your arm.");
                dialogBox378_2.text("Another steps and an arrow stucks right into your calf. You shout in pain.");
                dialogBoxGetLucky125.text("Fingers crossed, you rush at full speed towards the monument. Maybe they will\n" +
                    "not touch you if you run fast enough.");
                dialogBox341.text("You cast Protection on yourself and move forward. Four or five arrows hiss and crash\n" +
                    "on the shield and you manage to reach the monument unharmed.");
                dialogBox209.text("You take a look at the rather odd structure. It is not a fountain but a sort of temple.\n" +
                    "There is a door on the side. Might be worth a look, or maybe you prefer to continue on your way to the tower.");
                dialogBoxGreyTentacle.text("Walking the courtyard, you walk along a lump that seems to connect the temple\n" +
                    "to the tower; like a canalisation right under the dirt.");
                dialogBoxGreyTentacle_1.text("You examine it closer, maybe it is just a mole gallery ? But when you touch it\n" +
                    "it retracts and a grey tentacle appears from the ground and grab you by the leg.");
                dialogBoxLevitation.text("You cast Levitation and start to float. The tentacle goes up in the air with you\n" +
                    "and your leg starts to hurt tremendously.");
                dialogBoxLevitation_1.text("No other choices now but to fight or cast another spell.");
                dialogBoxFire.text("You cast Fire and the tentacle starts to tremble and release your leg before retreat\n" +
                    "below the dirt. You rub your numb leg and resume your way towards the tower.");
                /*------------------------------------------------------*/
                inputArrows();
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
                    DialogAlert alert = new DialogAlert("Do you want to cast Endurance ?");
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
                DialogAlert alert = new DialogAlert("You have lost 2 HP !");
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
                DialogAlert alert = new DialogAlert("You have lost 2 HP !");
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
                    DialogAlert alert = new DialogAlert("Do you want to cast Illusion ?");
                    alert.text("    An usage of Illusion will be remove from your spellbook.");
                    alert.button("Yes" , Color.BLACK , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            game.getPlayer().getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                            game.getPlayer().isTouchedInCombat();
                            DialogAlert alertPV = new DialogAlert("You have lost 2 HP !");
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
                    DialogAlert alert = new DialogAlert("Do you want to cast Protection ?");
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
                    DialogAlert alert = new DialogAlert("Do you want to cast Weakness ?");
                    alert.text("    An usage of Weakness will be remove from your spellbook.");
                    alert.button("Yes" , Color.BLACK , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            game.getPlayer().getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                            game.getPlayer().setCurrentVitality(game.getPlayer().getCurrentVitality() - 1);
                            DialogAlert alertPV = new DialogAlert("You have lost 1 HP !");
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
        dialogBox179.button("Turn around looking for the person" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               dialogBox179.hide();
               stage.addActor(dialogBox179_1);
               dialogBox179_1.show(stage);
               hud.bringToFront();
               return true;
            }
        });
        dialogBox179_1.button("Take another couple of steps" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               dialogBox179_1.hide();
               stage.addActor(dialogBox179_2);
               dialogBox179_2.show(stage);
               hud.bringToFront();
               return true;
            }
        });
        dialogBox179_2.button("Jump back and look for the person" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               dialogBox179_2.hide();
               stage.addActor(dialogBox179_3);
               dialogBox179_3.show(stage);
               hud.bringToFront();
               return true;
            }
        });
        dialogBox179_3.button("Continue to move on despite the enemy" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               dialogBox179_3.hide();
               stage.addActor(dialogBox378);
               dialogBox378.show(stage);
               hud.bringToFront();
               return true;
            }
        });
        dialogBox179_3.button("Rush towards the monument" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               dialogBox179_3.hide();
               stage.addActor(dialogBoxGetLucky125);
               dialogBoxGetLucky125.show(stage);
               hud.bringToFront();
               return true;
            }
        });
        dialogBox378.button("Take a couple of steps" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               dialogBox378.hide();
               stage.addActor(dialogBox378_1);
               dialogBox378_1.show(stage);
               hud.bringToFront();
               return true;
            }
        });
        dialogBox378_1.button("Another couple of steps" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               dialogBox378_1.hide();
               stage.addActor(dialogBox378_2);
               dialogBox378_2.show(stage);
               hud.bringToFront();
               return true;
            }
        });
        dialogBox378_2.button("Jump behind the monument to take cover" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               dialogBox378_2.hide();
               stage.addActor(dialogBox209);
               dialogBox209.show(stage);
               hud.bringToFront();
               return true;
            }
        });
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.PROTECTION)){
            dialogBox179_3.button("Cast Protection" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    DialogAlert alertProtection = new DialogAlert("Do you want to cast Protection");
                    alertProtection.text("    An usage of Protection will be remove from your spellbook.");
                    alertProtection.button("Yes" , Color.BLACK , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            game.getPlayer().getGrimoire().removeFrom(SpellList.Sorts.PROTECTION);
                            alertProtection.hide();
                            dialogBox179_3.hide();
                            stage.addActor(dialogBox341);
                            dialogBox341.show(stage);
                            hud.bringToFront();
                            return true;
                        }
                    });
                    alertProtection.button("No" , Color.BLACK , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            alertProtection.hide();
                            hud.bringToFront();
                            return true;
                        }
                    });
                    alertProtection.show(stage);
                    hud.bringToFront();
                    return true;
                }
            });
        }
        dialogBoxGetLucky125.button("Run full speed" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               DialogAlert alertGetLucky125 = new DialogAlert("Result get lucky");
               if (Dice.doubleDice() <= game.getPlayer().getCurrentLuck()){
                   alertGetLucky125.text("You ran fast enough to avoid the arrows\n" +
                       "(You lost a point of luck.)");
               } else {
                    alertGetLucky125.text("You did not manage to avoid the incoming arrows and lost 5 HP.\n" +
                        "(You lost a point of luck.)");
                    game.getPlayer().setCurrentVitality(game.getPlayer().getCurrentVitality() - 5);
               }
               alertGetLucky125.button("Continue" , new InputListener() {
                   public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                       alertGetLucky125.hide();
                       if (game.getPlayer().isDead()) {
                           stage.clear();
                           game.setScreen(new GameOverScreen(game));
                       }
                       dialogBoxGetLucky125.hide();
                       stage.addActor(dialogBox209);
                       dialogBox209.show(stage);
                       hud.bringToFront();
                       return true;
                   }
               });
               alertGetLucky125.show(stage);
               hud.bringToFront();
               return true;
            }
        });
        dialogBox341.button("Hide behind the monument" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               dialogBox341.hide();
               stage.addActor(dialogBox209);
               dialogBox209.show(stage);
               hud.bringToFront();
               return true;
            }
        });
        dialogBox209.button("Open the door" , new InputListener() {
            public boolean touchDown(Event event, float x, float y, int pointer, int button) {
               dialogBox209.hide();
               stage.clear();
               game.setScreen(new TempleOfTheCourtyardGameScreen(game));
               hud.bringToFront();
               return true;
            }
        });
        dialogBox209.button("Continue my way to the tower" , new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox209.hide();
                stage.addActor(dialogBoxGreyTentacle);
                dialogBoxGreyTentacle.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        dialogBoxGreyTentacle.button("Take a closer look" , new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxGreyTentacle.hide();
                stage.addActor(dialogBoxGreyTentacle_1);
                dialogBoxGreyTentacle_1.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        dialogBoxGreyTentacle_1.button("Draw out your sword" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxGreyTentacle_1.hide();
                combat71();
                hud.bringToFront();
                return true;
            }
        });
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.LEVITATION)){
            dialogBoxGreyTentacle_1.button("Cast Levitation" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    DialogAlert alert = new DialogAlert("Do you want to cast Levitation ?");
                    alert.text("    An usage of Levitation will be remove from your spellbook.");
                    alert.button("Yes" , Color.BLACK , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            game.getPlayer().getGrimoire().removeFrom(SpellList.Sorts.LEVITATION);
                            alert.hide();
                            dialogBoxGreyTentacle_1.hide();
                            stage.addActor(dialogBoxLevitation);
                            dialogBoxLevitation.show(stage);
                            return true;
                        }
                    });
                    alert.show(stage);
                    hud.bringToFront();
                    return true;
                }
            });
            dialogBoxLevitation.button("Get back down" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxLevitation.hide();
                stage.addActor(dialogBoxLevitation_1);
                dialogBoxLevitation_1.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        dialogBoxLevitation_1.button("Draw my sword" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxLevitation_1.hide();
                combat71();
                hud.bringToFront();
                return true;
            }
        });
        }

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FEU)){
            dialogBoxGreyTentacle_1.button("Cast Fire" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    dialogBoxGreyTentacle_1.hide();
                    stage.addActor(dialogBoxFire);
                    dialogBoxFire.show(stage);
                    hud.bringToFront();
                    return true;
                }
            });
            dialogBoxLevitation_1.button("Cast Fire" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    dialogBoxLevitation_1.hide();
                    stage.addActor(dialogBoxFire);
                    dialogBoxFire.show(stage);
                    hud.bringToFront();
                    return true;
                }
            });
        }

        dialogBoxFire.button("Go to the tower's door" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxFire.hide();
                stage.clear();
                game.setScreen(new RhinoDoorGameScreen(game));
                hud.bringToFront();
                return true;
            }
        });
    }

    private void combat71(){
        Monster greyTentacle = new Monster("Grey tentacle" , 15 , 2);
        int compteurTour = 1;
        showCombatDialogBox(greyTentacle, compteurTour);
    }

    private void showCombatDialogBox(Monster monster, int cptTour){
        //le monstre est mort
        if (monster.isDead() && cptTour != 4){
            DialogBox victory = new DialogBox("Narrator");
            victory.text("You have defeated the Grey Tentacle.\n" +
                "You continue your way to the Tower.");
            victory.button("Continue" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    victory.hide();
                    stage.clear();
                    game.setScreen(new RhinoDoorGameScreen(game));
                    hud.bringToFront();
                    return true;
                }
            });
            stage.addActor(victory);
            victory.show(stage);
            hud.bringToFront();
            return;
        }

        //si le compteur atteint 4
        if (cptTour == 4){
            DialogBox defeat = new DialogBox("Narrator !");
            defeat.text("You were dragged into the hole by the Grey Tentacle.");
            defeat.button("Continue" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    defeat.hide();
                    stage.clear();
                    game.setScreen(new GameOverScreen(game));
                    return true;
                }
            });
            stage.addActor(defeat);
            defeat.show(stage);
            hud.bringToFront();
            return;
        }

        //exécution du combat
        DialogBox fightBox = new DialogBox("Choose an action");
        DialogBox tentacleCrawl = setupTentacleCrawl(monster, cptTour);

        fightBox.button("Attack", new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                int scorePlayer = Dice.doubleDice()+game.getPlayer().getCurrentAbility();
                fightBox.hide();
                DialogAlert alert = new DialogAlert("Info !");

                if (scorePlayer<monster.getAbility()){
                    alert.text("You did not harm the tentacle.");
                    alert.button("Continue" , new InputListener() {
                       public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                           alert.hide();
                           tentacleCrawl.show(stage);
                           hud.bringToFront();
                           return true;
                       }
                    });
                } else {
                    monster.isTouchedInCombat();
                    alert.text("You harm the tentacle.");
                    alert.button("Continue" , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            alert.hide();
                            showCombatDialogBox(monster,cptTour);
                            return true;
                        }
                    });
                }
                alert.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        fightBox.button("Try to escape", new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                fightBox.hide();
                DialogBox escapeBox = new DialogBox("Narrator");
                escapeBox.text("You try to escape the Grey Tentacle.\n" +
                    "But it does not work.");
                escapeBox.button("Continue" , new InputListener() {
                    public boolean touchDown(Event event, float x, float y, int pointer, int button) {
                        escapeBox.hide();
                        tentacleCrawl.show(stage);
                        return true;
                    }
                });
                stage.addActor(escapeBox);
                escapeBox.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        stage.addActor(fightBox);
        fightBox.show(stage);
        hud.bringToFront();
    }

    public DialogBox setupTentacleCrawl(Monster monster, int cptTour){
        DialogBox tentacleCrawl = new DialogBox("Grey Tentacle");
        DialogAlert alert = new DialogAlert("Do you want to crawl ?");
        alert.text("You have " + (4-cptTour+1) + " round left to get away" );
        alert.button("Ok" , Color.BLACK , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                alert.hide();
                return true;
            }
        });
        tentacleCrawl.text("The tentacle grabs tighter and drags you to its hole !");
        tentacleCrawl.button("Continue" , new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                alert.show(stage);
                tentacleCrawl.hide();
                showCombatDialogBox(monster, cptTour + 1);
                hud.bringToFront();
                return true;
            }
        });
        return tentacleCrawl;
    }

    /*--------- MÉTHODES DE SCREEN ----------*/

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

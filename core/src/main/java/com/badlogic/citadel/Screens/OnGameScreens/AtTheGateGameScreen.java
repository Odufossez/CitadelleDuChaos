package com.badlogic.citadel.Screens.OnGameScreens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogAlert;
import com.badlogic.citadel.DialogWindows.DialogBox;
import com.badlogic.citadel.Dice;
import com.badlogic.citadel.Item;
import com.badlogic.citadel.Methods.Monster;
import com.badlogic.citadel.PlayerRelatedMethods.SpellList;
import com.badlogic.citadel.Screens.HUD;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import static com.badlogic.citadel.Screens.Skins.PLAIN_JAMES_SKIN;

public class AtTheGateGameScreen extends ApplicationAdapter implements Screen {
    Citadel game;
    private Stage stage;
    private Dialog sceneDialog;
    private Skin skin;
    private HUD hud;

    /*----Dialogues for the current scene (event 1)----*/
    private final DialogBox dialogBox1 = new DialogBox("Narrator" , PLAIN_JAMES_SKIN);
    private final DialogBox dialogBox2 = new DialogBox("Narrator" , PLAIN_JAMES_SKIN);
    private final DialogBox dialogBox3 = new DialogBox("Narrator" , PLAIN_JAMES_SKIN);
    private final DialogBox dialogBox4 = new DialogBox("Monster Monkey-Head-Hound-Body" , PLAIN_JAMES_SKIN);

    /*----Dialogues for events----*/
    private final DialogBox dialogBox261 = new DialogBox("Monster Monkey-Head-Hound-Body" , PLAIN_JAMES_SKIN); //évènement 261
    private final DialogBox dialogBox261_1 = new DialogBox("Narrator", PLAIN_JAMES_SKIN);
    private final DialogBox dialogBox261_2 = new DialogBox("Monster Monkey-Head-Hound-Body", PLAIN_JAMES_SKIN); //choix multiple de nom
    private final DialogBox dialogBox261_Wrong = new DialogBox("Monster Monkey-Head-Hound-Body", PLAIN_JAMES_SKIN);
    private final DialogBox dialogBox261_SecondChance = new DialogBox("Monster Monkey-Head-Hound-Body", PLAIN_JAMES_SKIN);
    private final DialogBox dialogBox261_Lucky = new DialogBox("Narrator", PLAIN_JAMES_SKIN);
    private final DialogBox dialogBox261_Unlucky = new DialogBox("Narrator", PLAIN_JAMES_SKIN);
    private final DialogBox dialogBox261_Kylltrog = new DialogBox("Monster Monkey-Head-Hound-Body", PLAIN_JAMES_SKIN);
    private final DialogBox dialogBox261_Blag = new DialogBox("Monster Monkey-Head-Hound-Body", PLAIN_JAMES_SKIN);
    private final DialogBox dialogBox261_Blag2 = new DialogBox("Monster Monkey-Head-Hound-Body", PLAIN_JAMES_SKIN);

    private final DialogBox dialogBoxEnter = new DialogBox("Narrator", PLAIN_JAMES_SKIN);

    private final DialogBox dialogBox230 = new DialogBox("Monster Monkey-Head-Hound-Body", PLAIN_JAMES_SKIN); //event 230
    private final DialogBox dialogBox230_1 = new DialogBox("Narrator", PLAIN_JAMES_SKIN);
    private final DialogBox dialogBoxOrDuSot = new DialogBox("Narrator", PLAIN_JAMES_SKIN);

    private final DialogBox dialogBox20 = new DialogBox("Monster Monkey-Head-Hound-Body", PLAIN_JAMES_SKIN); //event 20
    private final DialogBox dialogBox20_1 = new DialogBox("Narrator", PLAIN_JAMES_SKIN);

    public AtTheGateGameScreen(Citadel game){
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
    public void create(){
        dialogBox1.text("The sun is setting. The climb to reach the top of the mountain is difficult but you manage " +
            "to make it. While you climb, you have to think about what you will say to the guards.");

        dialogBox2.text("Maybe a wanderer, looking for a safe place to sleep ? Or an herbalist, called to cure someone ? " +
            "Or maybe a seller or an artisan ?");

        dialogBox3.text("Either way, while thinking about that lie, you reach a trail going to the gates. Walking up it," +
            " you start to hear muffled voices and soon started to see the guards.");

        dialogBox4.text("Halt! Who's is coming !?");

        stage.addActor(dialogBox1);
        dialogBox1.show(stage);
        hud.bringToFront();
    }

    private void inputPathHerbalist(){
        dialogBox261.button("Continue" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox261.hide();
                stage.addActor(dialogBox261_1);
                dialogBox261_1.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox261_1.button("Continue" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox261_1.hide();
                game.getPlayer().getInventory().removeFrom(Item.Items.GRASS);
                stage.addActor(dialogBox261_2);
                dialogBox261_2.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox261_2.button("Pincus" , new InputListener() { //175
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox261_2.hide();
                stage.addActor(dialogBox261_Wrong);
                dialogBox261_Wrong.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox261_Wrong.button("Fight for your life !" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox261_Wrong.hide();
                combat288();
                return true;
            }
        });

        dialogBox261_Wrong.button("Well no ! I meant someone else !" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox261_Wrong.hide();
                dialogBox261_SecondChance.text("Well WHO in that case ? ");
                stage.addActor(dialogBox261_SecondChance);
                dialogBox261_SecondChance.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox261_SecondChance.button("Get lucky" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                if (Dice.doubleDice() <= game.getPlayer().getCurrentLuck()){ //chanceux
                    game.getPlayer().setCurrentLuck(game.getPlayer().getCurrentLuck() - 1); //réduc du point de chance
                    stage.addActor(dialogBox261_Lucky);
                    dialogBox261_Lucky.show(stage);
                } else { //malchanceux
                    game.getPlayer().setCurrentLuck(game.getPlayer().getCurrentLuck() - 1); //réduc du point de chance
                    stage.addActor(dialogBox261_Unlucky);
                    dialogBox261_Unlucky.show(stage);
                }

                hud.bringToFront();
                return true;
            }
        });

        dialogBox261_Lucky.button("Continue" , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox261_Lucky.hide();
                stage.addActor(dialogBoxEnter);
                dialogBoxEnter.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox261_Unlucky.button("Continue" , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox261_Unlucky.hide();
                combat288();
                hud.bringToFront();
                return true;
            }
        });

        dialogBox261_2.button("Kylltrog" , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox261_2.hide();
                stage.addActor(dialogBox261_Kylltrog);
                dialogBox261_Kylltrog.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox261_Kylltrog.button("Laugh with them" , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox261_Kylltrog.hide();
                stage.addActor(dialogBoxEnter);
                dialogBoxEnter.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox261_2.button("Blag" , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox261_2.hide();
                stage.addActor(dialogBox261_Blag);
                dialogBox261_Blag.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox261_Blag.button("He's guard on the first floor !" , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox261_Blag.hide();
                stage.addActor(dialogBox261_Blag2);
                dialogBox261_Blag2.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox261_Blag2.button("Continue" , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox261_Blag2.hide();
                stage.addActor(dialogBoxEnter);
                dialogBoxEnter.show(stage);
                hud.bringToFront();
                return true;
            }
        });
    }

    private void inputPathMerchant(){
        dialogBox230.button("Continue" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox230.hide();
                stage.addActor(dialogBox230_1);
                dialogBox230_1.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        dialogBox230_1.button("Draw my sword" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    dialogBox230_1.hide();
                    combat288();
                    return true;
                }
            }
        );
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.OR_DU_SOT)){
            dialogBox230_1.button("Cast Dummy's Gold" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    DialogAlert alert = new DialogAlert("Do you want to cast Dummy's Gold ?" , PLAIN_JAMES_SKIN);
                    alert.text("    An usage of Dummy's Gold will be remove from your spellbook.");
                    alert.button("Yes" , Color.BLACK , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            game.getPlayer().getGrimoire().removeFrom(SpellList.Sorts.OR_DU_SOT);
                            alert.hide();
                            dialogBox230_1.hide();
                            stage.addActor(dialogBoxOrDuSot);
                            dialogBoxOrDuSot.show(stage);
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
    }

    private void inputPathWanderer(){
        dialogBox20.button("Think fast ! " , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox20.hide();
                stage.addActor(dialogBox20_1);
                dialogBox20_1.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox20_1.button("Draw my sword and fight" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox20_1.hide();
                combat288();
                return true;
            }
        });

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.OR_DU_SOT)){
            dialogBox20_1.button("Cast Dummy's Gold" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    DialogAlert alert = new DialogAlert("Do you want to cast Dummy's Gold ?" , PLAIN_JAMES_SKIN);
                    alert.text("    An usage of Dummy's Gold will be remove from your spellbook.");
                    alert.button("Yes" , Color.BLACK , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            game.getPlayer().getGrimoire().removeFrom(SpellList.Sorts.OR_DU_SOT);
                            alert.hide();
                            dialogBox20_1.hide();
                            stage.addActor(dialogBoxOrDuSot);
                            dialogBoxOrDuSot.show(stage);
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
    }

    private void input() {
        dialogBox1.button("Think about a lie" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox1.hide();
                stage.addActor(dialogBox2);
                dialogBox2.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox2.button("Continue" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox2.hide();
                stage.addActor(dialogBox3);
                dialogBox3.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox3.button("Approach the gate" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox3.hide();
                stage.addActor(dialogBox4);
                dialogBox4.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox4.button("I am a herbalist ! " , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox4.hide();

                //preparer les dialogues qui ne sont exécutés que dans cette branche
                dialogBox261.text("A herbalist uh ? What plants do you carry ?");
                dialogBox261_1.text("You hand to him the grass and flowers you had collected earlier. They are still\n"+
                    "suspicious about you...");
                dialogBox261_2.text("Who is that you are coming to heal ?");
                dialogBox261_Wrong.text("There is no Pincus here ! Prepare to die !");
                dialogBox261_Kylltrog.text(" HAHAHA! Kylltrog is worthless ! Would not be a big deal if he'd die !");
                dialogBox261_Blag.text("Blag ? Mmmmh... rings a bell but I am not too sure...");
                dialogBox261_Blag2.text("Yeah ? Sure whatever, go on.");
                dialogBoxEnter.text("The gate opens before you and you pass through, into the Citadel of Chaos.");
                dialogBox261_Lucky.text("Panicked, you scream a random name. Luckily for you, the guards know someone" +
                    " that name.");
                dialogBox261_Unlucky.text("You scream a random name. The guards do not know anyone with that name. You " +
                    "will have to fight for your life !");
                /*------------------------------------------------------------*/

                stage.addActor(dialogBox261);
                dialogBox261.show(stage);
                hud.bringToFront();
                inputPathHerbalist();
                return true;
            }
        });

        dialogBox4.button("I am a merchant !" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox4.hide();

                //les dialogues présents que dans cette branche
                dialogBox230.text("You came to earn money uh ? Maybe you can share a bit of your profit !");
                dialogBox230_1.text("You don't have any money to share... maybe you can trick them ? " +
                    "Or draw your sword and fight.");
                dialogBoxOrDuSot.text("You grab a small stone you collected earlier and cast the spell on it.\n" +
                    "It turns into a golden nugget you toss to the guards.");
                dialogBoxEnter.text("The guards yell to open the gate. As it opens, you step through and hear in the" +
                    " distance the two of them tick each other off about who's going to get the golden nugget.");
                /*-------------------------------------------------------*/

                stage.addActor(dialogBox230);
                dialogBox230.show(stage);
                hud.bringToFront();
                inputPathMerchant();
                return true;
            }
        });

        dialogBox4.button("I am a wanderer,\n looking for hospitality for the night !" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox4.hide();

                //Les dialogues de cette branche
                dialogBox20.text("Nobody enters the Black Tower after the night's fall. Go find somewhere else ! ");
                dialogBox20_1.text("You'll have to think about a new strategy right now. What do you think ?");
                dialogBoxOrDuSot.text("You grab a small stone you collected earlier and cast the spell on it.\n" +
                    "It turns into a golden nugget you toss to the guards.");
                dialogBoxEnter.text("The guards yell to open the gate. As it opens, you step through and hear in the" +
                    " distance the two of them tick each other off about who's going to get the golden nugget.");
                /*------------------------------------------------*/

                stage.addActor(dialogBox20);
                dialogBox20.show(stage);
                inputPathWanderer();
                hud.bringToFront();
                return true;
            }
        });

        dialogBoxEnter.button("Go through the gate" , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBoxEnter.hide();
                stage.clear();
                game.setScreen(new IntroGameScreen(game)); //todo change to the next screen
                return true;
            }
        });

        dialogBoxOrDuSot.button("Move on" , new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxOrDuSot.hide();
                stage.addActor(dialogBoxEnter);
                dialogBoxEnter.show(stage);
                hud.bringToFront();
                return true;
            }
        });
    }

    private void combat288(){
        Monster guard_Hound_Monkey = new Monster("Hound Monkey" , 6 , 6);
        Monster guard_Monkey_Hound = new Monster("Monkey Hound" , 7 , 4);

        showCombatDialog(guard_Hound_Monkey, guard_Monkey_Hound);
    }

    private void showCombatDialog(Monster guard_Hound_Monkey , Monster guard_Monkey_Hound){

        //si les DEUX monstres sont morts
        if (guard_Hound_Monkey.isDead() && guard_Monkey_Hound.isDead()){
            DialogBox victoryBox = new DialogBox("Narrator" , PLAIN_JAMES_SKIN);
            victoryBox.text("You defeated both monsters ! You lure the third guard by calling him from below and " +
                "manage your way in the citadel.");
            victoryBox.button("Continue" , new InputListener(){
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    victoryBox.hide();
                    stage.clear();
                    game.setScreen(new IntroGameScreen(game)); //todo change to the next screen
                    return true;
                }
            });
            stage.addActor(victoryBox);
            victoryBox.show(stage);
            hud.bringToFront();
            return;
        }

        //si le joueur est mort
        if (game.getPlayer().isDead()){
            stage.clear();
            game.setScreen(new GameOverScreen(game));
        }

        //Le combat se fait normalement
        DialogBox fightBox = new DialogBox("Choose an action" , PLAIN_JAMES_SKIN);

        //Chien-Singe
        if (!guard_Hound_Monkey.isDead()){
            fightBox.button("Attack"+guard_Hound_Monkey.getName() , new InputListener(){
                int scorePlayer;
                int scoreGuard_HM;
                int playerTouched = 0;
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    scorePlayer = Dice.doubleDice() + game.getPlayer().getCurrentAbility();
                    scoreGuard_HM = Dice.doubleDice() + guard_Hound_Monkey.getAbility();

                    fightBox.hide();

                    String msg = resolutionTour(scorePlayer , scoreGuard_HM , guard_Hound_Monkey);
                    playerTouched = isPlayerTouched(scorePlayer , scoreGuard_HM);
                    DialogAlert alert = new DialogAlert(msg , PLAIN_JAMES_SKIN);

                    alert.button("Ok" , Color.BLACK, new InputListener(){
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            alert.hide();
                            showCombatDialog(guard_Hound_Monkey, guard_Monkey_Hound);
                            return true;
                        }
                    });
                    if (playerTouched !=0){
                        displayAlertTouch(playerTouched,alert,guard_Hound_Monkey);
                        playerTouched = 0;
                    }
                    alert.show(stage);
                    hud.bringToFront();
                    return true;
                }
            });
        }
        //Singe-Chien
        if (!guard_Monkey_Hound.isDead()){
            fightBox.button("Attack" + guard_Monkey_Hound.getName() , new InputListener(){
                int scorePlayer;
                int scoreGuard_MH;
                int playerTouched = 0;
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    scorePlayer = Dice.doubleDice() + game.getPlayer().getCurrentAbility();
                    scoreGuard_MH = Dice.doubleDice() + guard_Monkey_Hound.getAbility();

                    fightBox.hide();

                    String msg = resolutionTour(scorePlayer , scoreGuard_MH, guard_Monkey_Hound);
                    playerTouched = isPlayerTouched(scorePlayer , scoreGuard_MH);
                    DialogAlert alert = new DialogAlert(msg , PLAIN_JAMES_SKIN);

                    alert.button("Ok" , Color.BLACK , new InputListener(){
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            alert.hide();
                            showCombatDialog(guard_Hound_Monkey, guard_Monkey_Hound);
                            return true;
                        }
                    });
                    if (playerTouched !=0){
                        displayAlertTouch(playerTouched,alert,guard_Monkey_Hound);
                        playerTouched = 0;
                    }
                    alert.show(stage);
                    hud.bringToFront();
                    return true;
                }
            });
        }

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FORCE)){
            fightBox.button("Cast Force" , new InputListener(){
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    DialogAlert alert = new DialogAlert("Do you want to cast Force ?" , PLAIN_JAMES_SKIN);
                    alert.text("    An usage of Force will be remove from your spellbook.");
                    alert.button("Yes" , Color.BLACK , new InputListener() {
                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            game.getPlayer().getGrimoire().removeFrom(SpellList.Sorts.FORCE);
                            alert.hide();
                            fightBox.hide();
                            DialogBox eventForce = new DialogBox("Narrator" , PLAIN_JAMES_SKIN);
                            eventForce.text("You cast Force on yourself and ready yourself for the next fight.\n" +
                                    "But you got so strong, you fail to control yourself and send your sword away. You'll" +
                                    " have to fight bare hands or flee.");
                            eventForce.button("Flee" , new InputListener() {
                                @Override
                                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                    eventForce.text("You flee and run away from the guards. You will try again " +
                                            "tomorrow night");
                                    eventForce.button("Let's do that" , new InputListener() {
                                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                            eventForce.hide();
                                            stage.clear();
                                            game.setScreen(new AtTheGateGameScreen(game));
                                            return true;
                                        }
                                    });
                                    hud.bringToFront();
                                    return true;
                                }
                            });
                            eventForce.button("Bare hands" , new InputListener() {
                               public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                   showCombatDialog(guard_Hound_Monkey, guard_Monkey_Hound);
                                   return true;
                               }
                            });
                            stage.addActor(eventForce);
                            eventForce.show(stage);
                            hud.bringToFront();
                            return true;
                        }
                    });
                    alert.button("No" , Color.BLACK , new InputListener() {
                        @Override
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

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.LEVITATION)){
            fightBox.button("Cast Levitation" , new InputListener(){
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    DialogAlert alert = new DialogAlert("Do you want to cast Levitation ?" , PLAIN_JAMES_SKIN);
                    alert.text("    An usage of Levitation will be remove from your spellbook.");
                    alert.button("Yes" , Color.BLACK , new InputListener() {
                        @Override
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            game.getPlayer().getGrimoire().removeFrom(SpellList.Sorts.LEVITATION);
                            fightBox.hide();
                            alert.hide();
                            DialogBox eventLevitation = new DialogBox("Narrator" , PLAIN_JAMES_SKIN);
                            eventLevitation.text("The monsters are stunned as you elevate yourself over the rampart.\n" +
                                "You just have to hope they will not alert anyone...");
                            eventLevitation.button("Fly away" , new InputListener() {
                                    @Override
                                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                        stage.clear();
                                        game.setScreen(new AtTheGateGameScreen(game)); //todo change to the next screen
                                        return true;
                                    }
                                }
                            );
                            stage.addActor(eventLevitation);
                            eventLevitation.show(stage);
                            hud.bringToFront();
                            return true;
                        }
                    });
                    alert.button("No" , Color.BLACK , new InputListener() {
                        @Override
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

        stage.addActor(fightBox);
        fightBox.show(stage);
        hud.bringToFront();
    }

    private int isPlayerTouched(int playerScore, int monsterScore){
        if (playerScore == monsterScore){
            return 0;
        }
        if (playerScore > monsterScore){
            return 2;
        }
        return 1;
    }

    private String resolutionTour(int playerScore , int monsterScore , Monster monster){
        String msg = "The " + monster.getName();
        if(playerScore == monsterScore){
            msg +=  " and you pared your hits !\nNobody was hurt.";
        } else if (playerScore > monsterScore) {
            msg += " took 2 damage from your hit !";
            monster.isTouchedInCombat();
        } else {
            msg += " hits you for 2 damage !";
            game.getPlayer().isTouchedInCombat();
        }
        return msg;
    }

    private void displayAlertTouch(int playerTouched, DialogAlert alert, Monster monster){
        String msg ="";
        String resultP1 = ""; //lucky or not
        String resultP2 = ""; //who is hit

        if (playerTouched==1){
            msg = "Will you taunt the devil to take less damage ? ";
            resultP2 = " were hit for 1 less damage.";

        } else {
            msg = "Will you taunt the devil to make more damage ? ";
            resultP2 = " hit the monster for 1 more damage";
        }

        boolean lucky = Dice.doubleDice() <= game.getPlayer().getCurrentLuck(); //true = lucky
        if (lucky){
            resultP1 = " You got lucky and ";
        } else {
            resultP1 = " You lost your bet and ";
        }

        String msgFinal = resultP1 + resultP2;

        DialogAlert getLucky = new DialogAlert(msg , PLAIN_JAMES_SKIN);
        getLucky.text("You will lose a point of luck by doing this action");
        getLucky.button("Yes" , Color.BLACK, new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                getLucky.hide();
                game.getPlayer().setCurrentLuck(game.getPlayer().getCurrentLuck() - 1); //enlever 1 PL
                DialogAlert getLuckyResult= new DialogAlert("Result" , PLAIN_JAMES_SKIN);
                getLuckyResult.text(msgFinal);
                getLuckyResult.button("Ok" , new InputListener(){
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        getLuckyResult.hide();
                        return true;
                    }
                });
                stage.addActor(getLuckyResult);
                getLuckyResult.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        getLucky.button("No" , Color.BLACK, new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                getLucky.hide();
                return true;
            }
        });

    }


    //Méthodes de screens
    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        hud.update(v);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        game.batch.begin();
        BitmapFont font = new BitmapFont();
        font.draw(game.batch, "In front of the gate" , Gdx.graphics.getWidth()*0.25f, Gdx.graphics.getHeight()*0.3f);
        game.batch.end();
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {
        stage.getViewport().update(i, i1, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        hud.dispose();
        stage.dispose();
    }
}

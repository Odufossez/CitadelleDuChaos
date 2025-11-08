package com.badlogic.citadel.Screens.OnGameScreens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogAlert;
import com.badlogic.citadel.DialogWindows.DialogBox;
import com.badlogic.citadel.Dice;
import com.badlogic.citadel.Methods.Combat;
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
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.citadel.DialogWindows.DialogBoxMethods.*;
import static com.badlogic.citadel.Dice.doubleDice;
import static com.badlogic.citadel.Dice.tripleDice;
import static com.badlogic.citadel.Methods.Combat.displayAlertTouch;

//218
public class RhinoDoorGameScreen extends ApplicationAdapter implements Screen {
    private Citadel game;
    private Stage stage;
    private HUD hud;

    private boolean faiblesse;
    private boolean force;
    private boolean knockDownDoor;

    private DialogBox dialogBox218 = new DialogBox("Narrator");
    private DialogBox dialogBox118 = new DialogBox("Narrator");
    private DialogBox dialogBox094 = new DialogBox("Narrator");
    private DialogBox dialogBox371 = new DialogBox("Narrator");
    private DialogBox dialogBox255 = new DialogBox("Narrator");
    private DialogBox dialogBox049 = new DialogBox("Narrator");
    private DialogBox dialogBoxLucky177 = new DialogBox("Narrator");
    private DialogBox dialogBoxUnlucky290 = new DialogBox("Narrator");
    private DialogBox dialogBoxLevitation70 = new DialogBox("Narrator");
    private DialogBox dialogBox264 = new DialogBox("Narrator");
    private DialogBox dialogBoxFaiblesse = new DialogBox("Narrator");

    public RhinoDoorGameScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        hud = new HUD(game,stage);
        faiblesse = false;
        force = false;
        knockDownDoor = false;
    }

    public void create(){
        dialogBox218.text("In front of you is a large wooden door, firmly locked. You may either knock three times for the " +
            " guard or use a Strength spell to try to open it.");
        dialogBox118.text("You knock three time and the door opens and a large, brutish creature steps out. It has a sharp horn in the middle of its " +
            "forehead and its skin appears to be armour-plated. It grunts to ask you what you want and demands the password " +
            "before letting you in.");
        dialogBox094.text("You feel your own growing power. Running at the door you hit it hard with your shoulder... but it " +
            "does not budge! You have to knock at the door.");
        dialogBox371.text("The creature grunts and opens the door to let you in.");
        dialogBox255.text("The creature looks at you. Its eyes narrow. In its hand is a long pike, witch it quickly points " +
            "towards you. It is not the right password.");
        dialogBox049.text("The creature gazes at you quizzically as it is uncertain about you.");
        dialogBoxLucky177.text("You are in a narrow hallway. This continues for several meters and ends in a doorway. " +
            "Halfway along the passage you can see an archway where some steps leads downwards.");
        dialogBoxUnlucky290.text("The creature steps forwards and jabs at you with its pike. You leap quickly out of the way. " +
            "You must decide whether to draw out your sword or cast a spell.");
        dialogBoxLevitation70.text("You fly up from his lunges but he stands his grounds and there is no way for you to fly " +
            "around him to the door. Eventually the spell wears off and you must face him once again");
        dialogBox264.text("Your great muscle flex and grip your sword hilt tightly. You stand and face the creature, ready " +
            "for battle.");
        dialogBoxFaiblesse.text("As you cast the spell, the creature lunges at you and clips your arm with its pike. When " +
            "the spell takes effect. The creature slows down and starts puffing and panting. You draw your sword and advance " +
            "to finish him off.");
    }

    public void input(){
        continueDialogBox(dialogBox218,dialogBox118,"Knock on the door",stage,hud);
        if (game.getPassword()){
            continueDialogBox(dialogBox118,dialogBox371,"Scimitar",stage,hud);
            continueDialogBox(dialogBox371,dialogBoxLucky177, hud, stage,null);
        }
        continueDialogBox(dialogBox118,dialogBox255,"Ganjees", stage,hud);
        continueDialogBox(dialogBox118,dialogBox049,"Kraken", stage,hud);
        continueDialogBox(dialogBox049,dialogBox255,hud,stage,null);
        if (!knockDownDoor && game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FORCE)){
            dialogBox218.button("Knock the door down" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    DialogAlert alert = new DialogAlert("Do you want to cast Strength ?");
                    alert.text("An usage of Strength will be remove from your spellbook.");
                    alert.button("Yes" , Color.BLACK , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            alertPlayerPV(1,stage,game, ()->{
                                knockDownDoor = true;
                                alert.hide();
                                dialogBox218.hide();
                                dialogBox094.show(stage);
                            });
                            return true;
                        }
                    });
                    alertNoButton(alert,stage,hud);
                    alert.show(stage);
                    return true;
                }
            });
        }
        continueDialogBox(dialogBox094,dialogBox118,hud,stage,null);

        dialogBox118.button("Make him believe\nyou are a herbalist",new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                DialogAlert alert = new DialogAlert("");
                if (game.getPlayer().getCurrentLuck() >= doubleDice()){
                    alert.text("You got lucky and managed to make him believe you are a herbalist.");
                    alert.button("Continue" , Color.BLACK, new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            alert.hide();
                            game.getPlayer().decreaseLuck();
                            dialogBox118.hide();
                            dialogBoxLucky177.show(stage);
                            return true;
                        }
                    });
                } else {
                    alert.text("You didn't manage to make him believe you are a herbalist. He is attacking you !");
                    alert.button("Continue" , Color.BLACK, new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            alert.hide();
                            dialogBox118.hide();
                            dialogBoxUnlucky290.show(stage);
                            return true;
                        }
                    });
                }
                alert.show(stage);
                return true;
            }
        });

        dialogBox255.button("Find an excuse for you presence",new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                DialogAlert alert = new DialogAlert("");
                if (game.getPlayer().getCurrentLuck() >= doubleDice()){
                    alert.text("You got lucky and managed to make him believe you are a herbalist.");
                    alert.button("Continue" , Color.BLACK, new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            alert.hide();
                            game.getPlayer().decreaseLuck();
                            dialogBox118.hide();
                            dialogBoxLucky177.show(stage);
                            return true;
                        }
                    });
                } else {
                    alert.text("You didn't manage to make him believe you are a herbalist. He is attacking you !");
                    alert.button("Continue" , Color.BLACK, new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            alert.hide();
                            dialogBox118.hide();
                            dialogBoxUnlucky290.show(stage);
                            return true;
                        }
                    });
                }
                alert.show(stage);
                return true;
            }
        });

        continueDialogBox(dialogBoxLucky177,"Stay on the path",stage,new MaitreHotelScreen(game),game);
        continueDialogBox(dialogBoxLucky177, "Go down the stairs",stage,new LutinScreen(game),game);

        dialogBoxUnlucky290.button("Draw out my sword" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxUnlucky290.hide();
                combatRhino();
                hud.bringToFront();
                return true;
            }
        });
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.LEVITATION)) {
            alertSpellDialog(dialogBoxUnlucky290, dialogBoxLevitation70, SpellList.Sorts.LEVITATION, hud, stage, game);
        }
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FAIBLESSE)) {
            alertSpellDialog(dialogBoxUnlucky290, dialogBoxFaiblesse, SpellList.Sorts.FAIBLESSE, hud, stage, game);
        }
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FORCE)) {
            alertSpellDialog(dialogBoxUnlucky290, dialogBox264, SpellList.Sorts.FORCE, hud, stage, game);
        }

        dialogBoxLevitation70.button("Draw out my sword" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxLevitation70.hide();
                combatRhino();
                hud.bringToFront();
                return true;
            }
        });

        dialogBox264.button("Draw out my sword" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox264.hide();
                force = true;
                combatRhino();
                hud.bringToFront();
                return true;
            }
        });

        dialogBoxFaiblesse.button("Draw out my sword" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxFaiblesse.hide();
                game.getPlayer().isTouchedInCombat();
                faiblesse = true;
                combatRhino();
                hud.bringToFront();
                return true;
            }
        });

    }

    private void combatRhino(){
        Monster rhino;
        if (faiblesse){
            rhino = new Monster("Rhino" , 4 , 7);
        } else {
            rhino = new Monster("Rhino" , 8 , 9);
        }

        hud.showEnenmyHealthBars(rhino);

        showDialogCombat(rhino);

    }

    private void showDialogCombat(Monster monster){
        //conditions de victoire
        if (monster.isDead()){
            hud.hideEnenmyBars();
            DialogBox victory = new DialogBox("Narrator");
            victory.text("You defeated the Rhino !");
            continueDialogBox(victory,dialogBoxLucky177,hud,stage,null);
            victory.show(stage);
            hud.bringToFront();
            return;
        }

        //joueur est mort
        if (game.getPlayer().isDead()){
            stage.clear();
            game.setScreen(new GameOverScreen(game));
        }

        DialogBox fightBox = new DialogBox("Choose an action");
        fightBox.button("Attack", new InputListener() {
            int playerTouched = 0;
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                int scorePlayer ;
                int scoreMonster = Dice.doubleDice()+monster.getAbility();

                if (force){
                    scorePlayer = tripleDice() + game.getPlayer().getCurrentAbility();
                } else {
                    scorePlayer = Dice.doubleDice() + game.getPlayer().getCurrentAbility();
                }

                String msg = Combat.resolutionTour(scorePlayer,scoreMonster,monster,game);
                playerTouched = Combat.isPlayerTouched(scorePlayer , scoreMonster);
                DialogAlert alert = new DialogAlert(msg);

                alert.button("Ok" , Color.BLACK, new InputListener(){
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        alert.hide();
                        if (playerTouched!=0){
                            displayAlertTouch(playerTouched, monster, stage, game, hud, () -> {
                                hud.showEnenmyHealthBars(monster);
                                showDialogCombat(monster);
                            });
                            playerTouched = 0;
                        } else {
                            showDialogCombat(monster);
                        }
                        return true;
                    }
                });
                alert.show(stage);
                return true;
            }
        });

        fightBox.show(stage);
        hud.bringToFront();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();
        dialogBox218.show(stage);
        hud.bringToFront();
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

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void hide() {

    }

    public void dispose(){
        hud.dispose();
        stage.dispose();
    }
}

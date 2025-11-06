package com.badlogic.citadel.Screens.OnGameScreens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogBox;
import com.badlogic.citadel.Dice;
import com.badlogic.citadel.Item;
import com.badlogic.citadel.Methods.Combat;
import com.badlogic.citadel.Methods.Monster;
import com.badlogic.citadel.PlayerRelatedMethods.SpellList;
import com.badlogic.citadel.Screens.HUD;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.citadel.DialogWindows.DialogBoxMethods.alertSpellDialog;
import static com.badlogic.citadel.DialogWindows.DialogBoxMethods.continueDialogBox;

//257
public class GolemGameScreen extends ApplicationAdapter implements Screen {
    private Citadel game;
    private Stage stage;
    private HUD hud;

    private boolean copy;

    private DialogBox dialogBox257 = new DialogBox("Narrator");
    private DialogBox dialogBox237 = new DialogBox("Narrator");
    private DialogBox dialogBox357 = new DialogBox("Narrator");
    private DialogBox dialogBox200 = new DialogBox("Narrator");
    private DialogBox dialogBox098 = new DialogBox("Narrator");
    private DialogBox dialogBox303 = new DialogBox("Narrator");
    private DialogBox dialogBox004 = new DialogBox("Narrator");
    private DialogBox dialogBox190 = new DialogBox("Narrator");
    private DialogBox dialogBox147 = new DialogBox("Narrator");
    private DialogBox dialogBox260 = new DialogBox("Narrator");
    private DialogBox dialogBox034 = new DialogBox("Narrator");
    private DialogBox dialogBox089 = new DialogBox("Narrator");
    private DialogBox dialogBox299 = new DialogBox("Narrator");
    private DialogBox dialogBox129 = new DialogBox("Narrator");
    private DialogBox dialogBox370 = new DialogBox("Narrator");

    public GolemGameScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        hud = new HUD(game,stage);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();
        dialogBox257.show(stage);
    }

    public void create(){
        dialogBox257.text("You look around the room. It is lit only by your torch. Although a fairly large room, it has little " +
            "furniture in it, although a large boulder, sliced flat, resembles a table and a smaller rock forms a sort of " +
            "stool behind it. In one corner, a pile of rock are held together with mud. You cannot imagine their purpose, " +
            "although they support three wooden chests. Then you jump with fright as torch lights up a large creature, seemingly " +
            "made of rock itself, standing by a door. It is roughly human-shaped, somewhat larger. Its eyes are staring " +
            "straight at you, but you cannot be sure it is actually seeing you.");
        dialogBox237.text("You open the door and step forwards into a passageway, which runs eastwards for several meters " +
            "and then ends at the foot of a staircase. you climb the stairs and eventually find yourself in a narrow " +
            "passageway. A short distance ahead, you can see an opening into a large, well-lit room. You press on forwards.");
        dialogBox357.text("The creature is apparently deaf-mute. You hail it in all the languages you know, but it conitnues " +
            "to stand silently. You make a move towards the center of the room.");
        dialogBox200.text("At your first movement, the creature seems to break from its trance and steps torwards you. Seeing " +
            "this you may either run for the door at the far end of the room or make for the boxes and risk taking on the " +
            "silent giant.");
        dialogBox098.text("The Golem advancing towards you is a slow-moving creature, and you reach the boxes easily. You " +
            "curse as you find they are all locked. As you struggle with the locks, the Golem closes on you.");
        dialogBox303.text("The Golem advances and you slash at it with you sword. It hits solid rock and clang noisily. It " +
            "will be hard to hurt it.");
        dialogBox004.text("You conjure up a fireball and send it flying at the creature's face. You watch in dismay as it " +
            "bounces off with no effect!");
        dialogBox190.text("A perfect copy of the Golem forms in front of you. You command it to attack the real Golem, which " +
            "is now almost upon you.");
        dialogBox147.text("The Golem crashes to the ground and breaks into pieces. With relief, you walk over to the boxes " +
            "to examine them. Which will you try to open ? ");
        dialogBox260.text("After some struggling, the box opens. Inside is a silver key.");
        dialogBox034.text("The key turns and, removing the lock, you open the box to find another key, this time cut into " +
            "a glowing green metal.");
        dialogBox089.text("The key turns, the lock clicks open and you look inside the box to see a glass jar. In it there is " +
            "a spider that has the face of an old man. He is talking to you, but you cannot make out what he is saying. A noise " +
            "startles you and you spin round to see that the door, the one you came through, is beginning to open. You put " +
            "the jar in your bag and make for the other door.");
        dialogBox299.text("The key will not turn, no matter how hard you try. In your frustration, you throw the box on the " +
            "ground and it vanishes ! You grope around for the invisible box but cannot feel it anywhere. In total despair, you " +
            "turn towards the door and set off once more towards your goal.");
        dialogBox129.text("You struggle with the box for some time, trying to open it. It will not open. You take out your " +
            "sword and strike the box, but you succeed only in blunting your sword.");
        dialogBox370.text("The box is solidly made and you cannot break the lock with your hands. You draw your sword to try " +
            "to hack it off and, as you do so, the box falls on your shin, causing a nasty cut. Your sword will not break the lock.");
    }

    public void input(){
        continueDialogBox(dialogBox257,dialogBox237,"Run to the door",stage,hud);
        continueDialogBox(dialogBox257,dialogBox357,"Talk to the golem",stage,hud);
        continueDialogBox(dialogBox257,dialogBox200,"Approach the boxes",stage,hud);

        //SORTIE DE LA PIECE
        continueDialogBox(dialogBox237,stage,new DinnerRoomScreenGame(game),game, null);

        continueDialogBox(dialogBox357,dialogBox200,hud,stage,null);

        continueDialogBox(dialogBox200,dialogBox237,"Run away",stage,hud);
        continueDialogBox(dialogBox200,dialogBox098,"Fight the creature",stage,hud);

        continueDialogBox(dialogBox098,dialogBox303,"Draw your sword",stage,hud,()->{
            game.getPlayer().modifyCurrentAbility(-1);
        });
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FEU)){
            alertSpellDialog(dialogBox098, dialogBox004, SpellList.Sorts.FEU, hud, stage, game);
        }
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.COPIE_CONFORME)){
            alertSpellDialog(dialogBox098, dialogBox190, SpellList.Sorts.COPIE_CONFORME, hud, stage, game,()->{
                copy = true;
            });
            continueDialogBox(dialogBox190,"Fight",hud, this::combatGolem);
        }
        continueDialogBox(dialogBox098,dialogBox237,"Run away",stage,hud);

        continueDialogBox(dialogBox303,"Get ready to fight",hud, this::combatGolem);

        continueDialogBox(dialogBox147,dialogBox260,"First box",stage,hud,()->{
            game.getPlayer().getInventory().putIn(Item.Items.KEY_SILVER);
        });
        continueDialogBox(dialogBox147,dialogBox129,"Second box",stage,hud,()->{
            game.getPlayer().modifyCurrentAbility(-1);
        });
        continueDialogBox(dialogBox147,dialogBox370,"Third box",stage,hud,()->{
            game.getPlayer().isTouchedInCombat();
        });

        //First box
        continueDialogBox(dialogBox260,dialogBox034,"Open the second box",stage,hud,()->{
            game.getPlayer().getInventory().putIn(Item.Items.KEY_GREEN);
        });
        continueDialogBox(dialogBox260,dialogBox299,"Open the third box",stage,hud);
        continueDialogBox(dialogBox260,dialogBox237,"Go out of the room",stage,hud);

        continueDialogBox(dialogBox034,dialogBox089,"Open the third box",stage,hud,()->{
            game.getPlayer().getInventory().removeFrom(Item.Items.KEY_SILVER);
        });
        continueDialogBox(dialogBox034,dialogBox237,"Go out of the room",stage,hud);

        continueDialogBox(dialogBox089,dialogBox237,hud,stage,()->{
            game.getPlayer().getInventory().removeFrom(Item.Items.KEY_GREEN);
            game.getPlayer().getInventory().putIn(Item.Items.SPIDER_MAN);
        });

        continueDialogBox(dialogBox299,dialogBox237,"Go out of the room",stage,hud);

        //Second box
        continueDialogBox(dialogBox129,dialogBox260,"Open the first box",stage,hud);
        continueDialogBox(dialogBox129,dialogBox370,"Open the third box",stage,hud);
        continueDialogBox(dialogBox129,dialogBox237,"Go out of the room",stage,hud);

        //Third box
        continueDialogBox(dialogBox370,dialogBox260,"Open the first box",stage,hud);
        continueDialogBox(dialogBox370,dialogBox129,"Open the second box",stage,hud);
    }

    private void combatGolem(){
        Monster monster = new Monster("Golem", 8, 10);
        Monster ally = null;
        if (copy){
            ally = new Monster("Golem Copied", 8, 10);
        }

        game.getPlayer().modifyCurrentAbility(-1);

        hud.showEnenmyHealthBars(monster);

        combatBox(monster,ally);

    }

    private void combatBox(Monster monster, Monster ally){
        //Conditions de victoire
        if (monster.isDead()){
            hud.hideEnenmyBars();
            game.getPlayer().modifyCurrentAbility(1);
            DialogBox victoryBox = new DialogBox("Narrator");
            victoryBox.text("You defeated the Golem ! You continue your way down the passageway.");
            continueDialogBox(victoryBox,dialogBox147,"Continue",stage,hud);
        }

        //Joueur mort
        if (game.getPlayer().isDead()){
            hud.hideEnenmyBars();
            game.setScreen(new GameOverScreen(game));
        }

        //Déroulement du combat
        DialogBox fightBox = new DialogBox("Choose an action");

        fightBox.button("Attack "+monster.getName() , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                int scorePlayer = Dice.doubleDice() + game.getPlayer().getCurrentAbility()+game.getPlayer().getWeaponBonus();
                int scoreMonster = Dice.doubleDice() + monster.getAbility();

                fightBox.hide();
                Combat.displayAlertResolutionTour(Combat.resolutionTour(scorePlayer,scoreMonster,monster,game),stage,()->{
                    Combat.displayAlertTouch(Combat.isPlayerTouched(scorePlayer,scoreMonster),monster,stage,game,hud,()->{
                        hud.showEnenmyHealthBars(monster);
                        combatBox(monster,ally);
                    });
                });
                return true;
            }
        });

        if (!ally.isDead() && ally!=null){
            fightBox.button("Attack with "+ally.getName() , new InputListener(){
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    int scoreAlly = Dice.doubleDice() + ally.getAbility();
                    int scoreMonster = Dice.doubleDice() + monster.getAbility();

                    fightBox.hide();
                    Combat.displayAlertResolutionTour(Combat.resolutionTour(scoreAlly,scoreMonster,ally,monster,game),stage,()->{
                        Combat.displayAlertTouch(Combat.isPlayerTouched(scoreAlly,scoreMonster),ally,stage,game,hud,()->{
                            hud.showEnenmyHealthBars(monster);
                            combatBox(monster,ally);
                        });
                    });
                    return true;
                }
            });
        }
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
        font.draw(game.batch, "Golem Game Screen" , Gdx.graphics.getWidth()*0.25f, Gdx.graphics.getHeight()*0.3f);
        game.batch.end();
        stage.draw();
    }

    @Override
    public void hide() {

    }
}

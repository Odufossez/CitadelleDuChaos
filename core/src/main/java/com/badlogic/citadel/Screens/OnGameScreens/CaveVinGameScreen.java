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

import javax.swing.plaf.IconUIResource;

import static com.badlogic.citadel.DialogWindows.DialogBoxMethods.alertSpellDialog;
import static com.badlogic.citadel.DialogWindows.DialogBoxMethods.continueDialogBox;
import static com.badlogic.citadel.Dice.doubleDice;

//144
public class CaveVinGameScreen extends ApplicationAdapter implements Screen {
    private final Citadel game;
    private final Stage stage;
    private final HUD hud;

    private boolean faiblesse;
    private boolean copy;
    private boolean illusion;

    private final DialogBox dialogBox144 = new DialogBox("Narrator");
    private final DialogBox dialogBox154 = new DialogBox("Narrator");
    private final DialogBox dialogBox056 = new DialogBox("Narrator");
    private final DialogBox dialogBox275 = new DialogBox("Narrator");
    private final DialogBox dialogBox120 = new DialogBox("Narrator");
    private final DialogBox dialogBox163 = new DialogBox("Narrator");
    private final DialogBox dialogBox334 = new DialogBox("Narrator");
    private final DialogBox dialogBox095 = new DialogBox("Narrator");
    private final DialogBox dialogBox272 = new DialogBox("Narrator");
    private final DialogBox dialogBox242 = new DialogBox("Narrator");
    private final DialogBox dialogBox105 = new DialogBox("Narrator");
    private final DialogBox dialogBox024 = new DialogBox("Narrator");
    private final DialogBox dialogBox372 = new DialogBox("Narrator");
    private final DialogBox dialogBox219 = new DialogBox("Narrator");


    public CaveVinGameScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        hud = new HUD(game,stage);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();

        dialogBox144.show(stage);
    }

    public void create(){
        dialogBox144.text("The door opens and you enter a narrow corridor. You follow it some time until you finally come to " +
            "another door : this time a wide, carved door with the inscription 'Wine Cellar' set into it. You try the handle " +
            "and it opens. Poking around you can see rows and rows of racks full of wine. The room is dimly lit by several " +
            "candles. The door opening caused a bell to ring, and a figure is limping towards you.");
        dialogBox154.text("As you draw your sword, the figure stops and takes something from the pouch at his waist. As " +
            "he limps closer, you can see that he is a Black Elf. In his hands he holds a small device. He sees you, manipulate " +
            "the device and it suddenly becomes a stiletto sword !");
        dialogBox056.text("The black elf approching you is skinny and ragged. He asks whether you are a guest or an adventurer." +
            "You tell him you are a guest, come down to sample the wine he keeps in his famous cellar. With pride, he shows " +
            "you the vintage bottles he keeps for his lord. Some of them, he claims, have magical powers.");
        dialogBox275.text("The device is a pocket Myriad, an enchanted gadget which can become any one of a number of weapons " +
            "or useful artefacts. You both close for battle.");
        dialogBox120.text("You teaste the wine and nod. The vintage is indeed excellent with a refreshing, fruity taste. " +
            "You try a little more and start to feel light-headed. You thank the Elf and press onwards.");
        dialogBox163.text("You take a sip and gag. It is AWFUL! The Elf is looking on expectantly and you must not insult " +
            "him, so you take another sip, grimacing as the liquid goes down. You thank him very much and explain quickly " +
            "that you must be getting back. You head for the far head of the room but your stomach will take the horrid taste " +
            "no longer. You are violently ill.");
        dialogBox334.text("You take a couple of sips. Not bad! You take a mouth full, wondering why the Elf is chuckling. " +
            "He asks whether you really are a guest or not. To your horror, you actually explain to him your whole project. " +
            "It was spiked with a Truth Serum ! The Elf now knows everything and must be put down.");
        dialogBox095.text("At the far end of the Wine Cellar is a wooden door, which you try. It opens out into a passageway " +
            "which leads onwards for several metres.");
        dialogBox272.text("You now may investigate the Wine cellar or press on through it to the door at the far end of the room.");
        dialogBox242.text("The bottle and caskets contain hundreds of differents types of wine. Some are exceedingly old and " +
            "valuable. In one corner of the room there is a table laid out for sampling with two bottles and glasses.");
        dialogBox105.text("The wine it rather bitter and, as you savour it in your mouth, you feel a burning sensation. You " +
            "spit the wine to the ground and, to your amazement, a jet of flame flies from your lips ! You take a sample to " +
            "use it to replace an use of the Fire spell.");
        dialogBox024.text("You taste the wine and, as you are considering its flavour, you hear a clinking noise. You turn " +
            "around to see that the bottles in the racks are moving on their own. One bottle flies from its place and hurtles " +
            "towards you, narrowly missing your head and smashing on the wall behind you. More and more are flying your direction.");
        dialogBox372.text("As you cast your shielding spell, a bottle hits you on the shoulder. You feel nothing. Something is " +
            "not quite righ, and you try to cancel your spell. Unfortunately, it has already been cast and you can see the " +
            "bottles smashing into the magic shield you have created. The bottle that hits you disappeared and you curse as " +
            "you realize the wine you tasted must have had some hallucinatory properties. At this moment, you blink and look " +
            "again. All the bottles are in place on their racks as normal.");
        dialogBox219.text("You duck and cover your head. A bottle hits you, then another and then more ! But you don't feel " +
            "a thing ! How ? Then you realize the wine must have contained some hallucinatory potion that is making you believe " +
            "the wines are attacking you. In an instant, the noise ceases, you look up to see the cellar as peaceful as ever.");
    }

    public void input(){
        continueDialogBox(dialogBox144,dialogBox154,"Draw out your sword",stage,hud);
        continueDialogBox(dialogBox144,dialogBox056,"Talk to the dark elf",stage,hud);

        continueDialogBox(dialogBox154,dialogBox275,"Fight the dark elf",stage,hud);
        continueDialogBox(dialogBox154,dialogBox056,"Talk to the dark elf",stage,hud);

        continueDialogBox(dialogBox056,dialogBox120,"Drink the red wine",stage,hud,()->{
            game.getPlayer().modifyCurrentVitality(2);
            game.getPlayer().modifyCurrentLuck(3);
        });
        continueDialogBox(dialogBox056,dialogBox163,"Drink the white wine",stage,hud,()-> {
            game.getPlayer().modifyCurrentAbility(-1);
            game.getPlayer().modifyCurrentVitality(-2);
        });
        continueDialogBox(dialogBox056,dialogBox334,"Drink the pink wine",stage,hud); //todo check vin
        continueDialogBox(dialogBox056,dialogBox095,"Leave the room",stage,hud);

        continueDialogBox(dialogBox120,dialogBox095,hud,stage,null);
        continueDialogBox(dialogBox163,dialogBox095,hud,stage,null);
        continueDialogBox(dialogBox334,dialogBox275,hud,stage,null);

        continueDialogBox(dialogBox275,"Fight the elf",hud, this::combatElfe);
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FAIBLESSE)){
            alertSpellDialog(dialogBox275, SpellList.Sorts.FAIBLESSE,hud,stage,game,()->{
                faiblesse = true;
                combatElfe();
            });
        }
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.COPIE_CONFORME)){
            alertSpellDialog(dialogBox275, SpellList.Sorts.COPIE_CONFORME,hud,stage,game,()->{
                copy = true;
                combatElfe();
            });
        }
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.ILLUSION)){
            alertSpellDialog(dialogBox275, SpellList.Sorts.ILLUSION, hud, stage, game,()->{
                illusion = true;
                combatElfe();
            });
        }

        continueDialogBox(dialogBox272,dialogBox095,"Leave the room",stage,hud);
        continueDialogBox(dialogBox272,dialogBox242,"Browse the cave",stage,hud); // todo check nom de la cave

        continueDialogBox(dialogBox242,dialogBox095,"Leave the room",stage,hud,()->{
            game.getPlayer().getInventory().putIn(Item.Items.RED_WINE);
        });
        continueDialogBox(dialogBox242,dialogBox105,"Taste the white wine",stage,hud);
        continueDialogBox(dialogBox242,dialogBox024,"Taste the red wine",stage,hud);

        continueDialogBox(dialogBox105,dialogBox095,"Leave the room",stage,hud,()->{
            game.getPlayer().getInventory().putIn(Item.Items.WINE_FIRE);
        });

        continueDialogBox(dialogBox024,dialogBox219,"Do nothing",stage,hud);
        continueDialogBox(dialogBox219,dialogBox095,"Leave the room",stage,hud);
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.PROTECTION)){
            alertSpellDialog(dialogBox024,dialogBox372, SpellList.Sorts.PROTECTION,hud,stage,game,null);
            continueDialogBox(dialogBox372,dialogBox095,"Leave the room",stage,hud);
        }

        continueDialogBox(dialogBox095,stage,new CroisementFourWays(game),game,null);
    }

    private void combatElfe(){
        Monster elf = new Monster("Elf", 8, 4);;
        Monster ally = null;

        if (copy){
            ally = new Monster("Elf copy", 8, 4);
        }
        if (faiblesse){
            elf = new Monster("Elf", 5, 4);
        } else if (illusion){
            elf = new Monster("Elf", 4, 4);
        }

        hud.showEnenmyHealthBars(elf);

        combatDialog(elf,ally);

    }

    private void combatDialog(Monster monster, Monster ally){
        //conditions de victoire
        if (monster.isDead()){
            hud.hideEnenmyBars();
            DialogBox victoryBox = new DialogBox("Narrator");
            victoryBox.text("You defeated the Elf ! You found 8 gold pieces and the broken Myriad");
            continueDialogBox(victoryBox,dialogBox272,"Continue",stage,hud,()->{
                game.getPlayer().getInventory().putIn(Item.Items.POCKET_MYRIADE);
                game.getPlayer().setGold(game.getPlayer().getGold()+8);
            });
        }

        //joueur mort
        if (game.getPlayer().isDead()){
            hud.hideEnenmyBars();
            game.setScreen(new GameOverScreen(game));
        }

        //déroulement
        DialogBox fightBox = new DialogBox("Choose an action");

        if (ally != null && !ally.isDead()){
            fightBox.button("Attack " + monster.getName() + " with " + ally.getName() , new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                    int scoreAlly = doubleDice() + ally.getAbility();
                    int scoreMonster = doubleDice() + monster.getAbility();

                    fightBox.hide();
                    Combat.displayAlertResolutionTour(Combat.resolutionTour(scoreAlly,scoreMonster,ally,monster,game),stage,()->{
                        Combat.displayAlertTouch(Combat.isPlayerTouched(scoreAlly,scoreMonster),ally,stage,game,hud,()->{
                            fightBox.hide();
                            combatDialog(monster,ally);
                        });
                    });
                    return true;
                }
            });
        }

        fightBox.button("Attack " + monster.getName() , new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                int scorePlayer = game.getPlayer().getAbility() + doubleDice() + game.getPlayer().getWeaponBonus();
                int scoreMonster = doubleDice() + monster.getAbility();

                fightBox.hide();
                Combat.displayAlertResolutionTour(Combat.resolutionTour(scorePlayer,scoreMonster,monster,game),stage,()->{
                    Combat.displayAlertTouch(Combat.isPlayerTouched(scorePlayer,scoreMonster),monster,stage,game,hud,()->{
                        fightBox.hide();
                        combatDialog(monster,ally);
                    });
                });
                return true;
            }
        });
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

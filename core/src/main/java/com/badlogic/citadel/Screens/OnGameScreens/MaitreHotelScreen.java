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
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.citadel.DialogWindows.DialogBoxMethods.*;
import static com.badlogic.citadel.Dice.doubleDice;
import static com.badlogic.citadel.Dice.soloDice;

//005
public class MaitreHotelScreen extends ApplicationAdapter implements Screen {
    private final Citadel game;
    private final Stage stage;
    private final HUD hud;

    private boolean db300 = false;
    private boolean initialStaminaLost = false;

    private final DialogBox dialogBox005 = new DialogBox("Narrator");
    private final DialogBox dialogBox040 = new DialogBox("Narrator");
    private final DialogBox dialogBox040_1 = new DialogBox("Narrator");
    private final DialogBox dialogBox040_2 = new DialogBox("Butler");
    private final DialogBox dialogBox040_3 = new DialogBox("Narrator");
    private final DialogBox dialogBox243 = new DialogBox("Narrator");
    private final DialogBox dialogBox002 = new DialogBox("Narrator");
    private final DialogBox dialogBox142 = new DialogBox("Narrator");
    private final DialogBox dialogBox361 = new DialogBox("Narrator");
    private final DialogBox dialogBox297 = new DialogBox("Narrator");
    private final DialogBox dialogBox126 = new DialogBox("Narrator");
    private final DialogBox dialogBox316 = new DialogBox("Narrator");
    private final DialogBox dialogBox075 = new DialogBox("Narrator");
    private final DialogBox dialogBox220 = new DialogBox("Narrator");
    private final DialogBox dialogBox139 = new DialogBox("Narrator");
    private final DialogBox dialogBox300 = new DialogBox("Narrator");
    private final DialogBox dialogBox244 = new DialogBox("Narrator");
    private final DialogBox dialogBox028 = new DialogBox("Narrator");
    private final DialogBox dialogBox346 = new DialogBox("Narrator");
    private final DialogBox dialogBox343 = new DialogBox("Narrator");
    private final DialogBox dialogBox055 = new DialogBox("Narrator");
    private final DialogBox dialogBox249 = new DialogBox("Narrator");
    private final DialogBox dialogBox010 = new DialogBox("Narrator");
    private final DialogBox dialogBox392 = new DialogBox("Narrator");
    private final DialogBox dialogBox231 = new DialogBox("Narrator (231)");


    public MaitreHotelScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        hud = new HUD(game,stage);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();
        dialogBox005.show(stage);
    }

    public void create(){
        dialogBox005.text("You try the handle of the door and it turns, opening into another hallway. Some distance along, the " +
            "passageway turns to the right and ends shortly in another door. On this door is a sign, which reads \'Please ring " +
            "for Butler\'. A rope, evidently the bell, hangs by the door. Will you ring as instructed ?");
        dialogBox040.text("After several moment the door opens slowly and a hunchbacked, mis-shapen creature with a rotten " +
            "teeth, ragged hair and tattered clothes stands in front of you.");
        dialogBox040_1.text("Yes sir (heh,heh) what can I do for you ?");
        dialogBox040_2.text("\'I am expected !\', you reply, and walk past him through the door with confidence. He is a little " +
            "bewildered by your manner and stammers, not knowing whether to challenge you or not.");
        dialogBox040_3.text("\"Which way to the reception room?\', you demand. He squints at you through one eye and motions " +
            "towards a left fork in the passageway a short distance ahead. Will you believe him ?");
        dialogBox243.text("The passage runs along for several metres and then ends at a door. You listen at it and can hear " +
            "a deep heavy breathing coming from inside, as if some large creature were asleep in there. Cautiously you try the " +
            "handle and the door opens. Just inside, although the room is dark, you can see that a very large Goblin-like " +
            "creature is asleep on the floor. You may either risk tiptoeing into the room or try the right-hand passageway.");
        dialogBox002.text("A little way up the passage there is a doorway on the right-hand side. This door has some strange " +
            "scrawlings on it, but they are in a language that you do not understand. Will you try opening the door or continue " +
            "up the passage ?");
        dialogBox142.text("You try the handle and it turns. You can hear nothing coming from inside the room, so you open the " +
            "door to look around. The room is small, with a golden candlestick on a table... but suddendly, you hear a creaking " +
            "sound coming from the floor ! Too late, you realize that the stones beneath your feet are shifting to reveal " +
            "a trap! You fall feet first into a pit. As you hit the bottom you roll sideways, down another passage, and continue " +
            "rolling downwards. As you hit the bottom, you hear excited chatterings, then you pass out.");
        dialogBox361.text("Again the door opens but as you do it, you hear the deafening clanging of an alarm bell!");
        dialogBox297.text("You slam the door shut behind you and, above the clanging bell, you can hear the sound of footsteps," +
            " running quickly and getting closer. The corridor ahead forks two ways. Will you spring ahead and take the right " +
            "fork or the left fork ? Or will you go back and call the butler ?");
        dialogBox126.text("You pause to consider, in a state of panic. Ahead, the passageway forks to the left and to the right. " +
            "As you are trying to decide which direction to take, three creatures emerge from the left-hand passage. Calling " +
            "the noises you heard \'footstep\' was not entirely accurate...");
        dialogBox316.text("The footsteps you heard belong to three Wheelies which now roll down the passageway towards you, " +
            "forcing you back to the door. These creatures are peculiar beasts having, instead of legs, an extra set of hands. They " +
            "move by cartwheeling along at quite a rapid pace. Grasping knives are speeding their way towards you.");
        dialogBox075.text("You step through the doorway, close the door behind you and wait for some time. You hear the footsteps " +
            "run closer closer and reach the door. Incomprehensible chatterings on the other side of the door eventually " +
            "die down and again you hear footsteps, this time moving away from you.");
        dialogBox220.text("The knives hit your magic shield and drop to the ground. The Wheelies likewise bump into the shield " +
            "and bounce off, holding you at bay while your spell wears off. They seem to reach some sort of agreement and one " +
            "rolls off back up the corridor, presumably to fetch help. The other two reach for their belts and pull out small " +
            "blowpipes. Putting some kind of pellets in their mouths first, they prepare to aim.");
        dialogBox139.text("All three knives miss and stick deep into the door behind you. The Wheelies are almost on you and you " +
            "must decide quickly whether to fight them or cast a spell.");
        dialogBox300.text("You must prepare to counter-attack.");
        dialogBox346.text("As the Wheelies see you draw out your sword, they stop and chatter excitedly. One of them, evidently " +
            "the leader, sends the smallest one back up the passage. The other two draw knives and roll down slowly towards " +
            "you.");
        dialogBox343.text("A little further along the passage, you arrive at another fork where you may go either left or right.");
        dialogBox244.text("As you concentrate on your spell, the Wheelies stop. Evidently they are a little apprehensive about " +
            "what you are planning. Suddenly, in front of their hairy eyes, your disappear ! Again they chatter excitedly. " +
            "Where have you gone to ? Under your invisibility illusion, you may continue choosing either the right-hand passageway " +
            "or the left-hand passageway leaving the Wheelies behind.");
        dialogBox028.text("You cast the spell and conjure up a ball of fire in your hands. They stop in their tracks and watch " +
            "you carefully. You toss the ball towards them and they shriek in fright, rolling away in terror from your obvious " +
            "powers. While you still have control over the spell, you create three smaller fireballs and pitch one at each " +
            "of them. They howl and scatter, rolling up the corridor away from you. You may now proceed up the right or left-hand " +
            "passageway.");
        dialogBox055.text("You follow the passageway for some time. It turns to the right and eventually reaches a dead end. " +
            "You may either return to the fork or look for secret passages.");
        dialogBox249.text("The passageway ends ahead of you at a wooden door. A sign reading 'Pantry' is fixed to it. You " +
            "listen but hear nothing. The door is locked. If you have a copper key you may try to use it. Otherwise, you " +
            "may either try to charge the door down or return to the fork and take the other passage.");
        dialogBox010.text("You feel around in the rock and eventually find a small lever. As you pull this lever, the rock " +
            "face crumbles slightly and a narrow opening appears. You climb through this opening and find yourself in a " +
            "passageway. Down the passageway to the left you can see a door and decide to investigate.");
        dialogBox392.text("The key turns and the door opens.");
        dialogBox231.text("You barge the door with your shoulder.");
    }

    public void input(){
        continueDialogBox(dialogBox005,dialogBox040,"Ring the bell" , stage,hud);
        continueDialogBox(dialogBox040,dialogBox040_1,hud,stage,null);
        continueDialogBox(dialogBox040_1,dialogBox040_2,hud,stage,null);
        continueDialogBox(dialogBox040_2,dialogBox040_3,hud,stage,null);
        continueDialogBox(dialogBox040_3,dialogBox243,"Left",stage,hud);
        continueDialogBox(dialogBox040_3,dialogBox002,"Right",stage,hud);
        continueDialogBox(dialogBox243, "Go in tiptoeing",stage,new SleepingGarkGameScreen(game),game);
        continueDialogBox(dialogBox243,dialogBox002,"Try the right\nhand passage",stage,hud);
        continueDialogBox(dialogBox002,dialogBox142,"Try opening the door",stage,hud);
        continueDialogBox(dialogBox142,stage, new PrisonGameScreen(game),game, null);
        continueDialogBox(dialogBox002,dialogBox343,"Continue up the passage",stage,hud);
        continueDialogBox(dialogBox343,dialogBox055,"Left",stage,hud);
        continueDialogBox(dialogBox343,dialogBox249,"Right",stage,hud);
        continueDialogBox(dialogBox055,dialogBox010,"Look for a secret passage",stage,hud);
        continueDialogBox(dialogBox010,dialogBox249,hud, stage,null);

        if (game.getPlayer().getInventory().getInventory().contains(Item.Items.KEY_COPPER)){
            continueDialogBox(dialogBox249,dialogBox392, hud,stage,game, Item.Items.KEY_COPPER,false);
        }
        continueDialogBox(dialogBox249,dialogBox231,"Take down the door",stage,hud);
        continueDialogBox(dialogBox249,dialogBox243,"Take the first fork",stage,hud);

        //todo lucky unlucky 231
        dialogBox231.addListener(new InputListener() {
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if (!initialStaminaLost && dialogBox231.isVisible()) {
                    alertPlayerPV(1,stage,game,()->{
                        initialStaminaLost = true;
                        if (game.getPlayer().getCurrentLuck()>=doubleDice()){ //lucky
                            continueDialogBox(dialogBox231,stage, new FoodSafeScreenGame(game),game, null);
                        } else {//unlucky
                            dialogBox231.getButtonTable().clear();

                            dialogBox231.button("Take the first fork", new InputListener() {
                                @Override
                                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                    dialogBox231.hide();
                                    initialStaminaLost = false;
                                    dialogBox243.show(stage);
                                    return true;
                                }
                            });

                            dialogBox231.button("Try again", new InputListener() {
                                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                                    dialogBox231.hide();
                                    initialStaminaLost = false;
                                    dialogBox231.show(stage);
                                    return true;
                                }
                            });
                        }
                        game.getPlayer().decreaseLuck();
                        hud.bringToFront();
                    });
                }
            }
        });



        continueDialogBox(dialogBox392,stage, new FoodSafeScreenGame(game),game, null);

        continueDialogBox(dialogBox005,dialogBox361,"Open the door",stage,hud);
        dialogGetLucky(dialogBox361,dialogBox297,dialogBox126,stage,hud,game);
        continueDialogBox(dialogBox126,dialogBox316,hud,stage,null);

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.PROTECTION)){
            alertSpellDialog(dialogBox316, dialogBox220, SpellList.Sorts.PROTECTION, hud, stage, game);
        }
        dialogGetLucky(dialogBox316,dialogBox139,dialogBox300,stage,hud,game);


        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.ILLUSION)){
            alertSpellDialog(dialogBox139, dialogBox244, SpellList.Sorts.ILLUSION, hud, stage, game);
            alertSpellDialog(dialogBox300, dialogBox244, SpellList.Sorts.ILLUSION, hud, stage, game);
            continueDialogBox(dialogBox244,dialogBox002,"Right-hand passageway",stage,hud);
            continueDialogBox(dialogBox244,dialogBox243,"Left-hand passageway",stage,hud);
        }

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FEU)){
            alertSpellDialog(dialogBox300, dialogBox028, SpellList.Sorts.FEU, hud, stage, game);
            alertSpellDialog(dialogBox139, dialogBox028, SpellList.Sorts.FEU, hud, stage, game);
            continueDialogBox(dialogBox028,dialogBox002,"Right-hand passageway",stage,hud);
            continueDialogBox(dialogBox028,dialogBox243,"Left-hand passageway",stage,hud);
        }

        continueDialogBox(dialogBox139,dialogBox346,"Draw out your sword",stage,hud);
        continueDialogBox(dialogBox300,dialogBox346,"Draw out your sword",stage,hud);

        continueDialogBox(dialogBox297,dialogBox002,"Take the right path",stage,hud);
        continueDialogBox(dialogBox297,dialogBox075,"Go back and\ncall the butler",stage,hud);
        continueDialogBox(dialogBox297,dialogBox316,"Take the left path",stage,hud);

        continueDialogBox(dialogBox075,dialogBox040,"Call the butler",stage,hud);

        dialogBox220.button("Get ready to fight (220)", new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox220.hide();
                combatRoulards();
                hud.bringToFront();
                return true;
            }
        });

        dialogBox346.button("Fight !" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox346.hide();
                combatRoulards();
                hud.bringToFront();
                return true;
            }
        });

        dialogBox300.addListener(new InputListener() {
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                if (!db300 && dialogBox300.isVisible()) {
                    db300 = true;
                    int die = soloDice();
                    if (die>=1 && die<=3){
                        alertPlayerPV(die*2,stage,game,hud::bringToFront);
                    }
                }
            }
        });
    }

    private void combatRoulards(){
        Monster roulard1 = new Monster("Wheelie 1" , 7,6);
        Monster roulard2 = new Monster("Wheelie 2" , 6, 5);

        hud.showEnenmyHealthBars(roulard1, roulard2);

        showCombatDialog(roulard1, roulard2);
    }

    private void showCombatDialog(Monster... monsters){
        boolean victory = true;
        DialogBox fightBox = new DialogBox("Choose your action");

        //condition de victoire
        for (Monster monster : monsters){
            if (!monster.isDead()){
                victory = false;
                break;
            }
        }
        if (victory){
            hud.hideEnenmyBars();
            DialogBox victoryBox = new DialogBox("Narrator");
            victoryBox.text("You defeated the Wheelies ! You continue your way down the passageway.");
            continueDialogBox(victoryBox,dialogBox243,hud,stage,null);
            victoryBox.show(stage);
            hud.bringToFront();
            return;
        }

        //joueur mort
        if (game.getPlayer().isDead()){
            stage.clear();
            game.setScreen(new GameOverScreen(game));
            return;
        }

        //déroulement
        for (Monster monster : monsters){
            if (!monster.isDead()){
                fightBox.button("Attack the "+monster.getName(), new InputListener() {
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        int scorePlayer = doubleDice() + game.getPlayer().getCurrentAbility();
                        int scoreMonster = Dice.doubleDice()+monster.getAbility();

                        fightBox.hide();
                        Combat.displayAlertResolutionTour(Combat.resolutionTour(scorePlayer,scoreMonster,monster,game),stage,()->{
                            Combat.displayAlertTouch(Combat.isPlayerTouched(scorePlayer,scoreMonster),monster,stage,game,hud,()->{
                                hud.showEnenmyHealthBars(monsters);
                                showCombatDialog(monsters);
                            });
                        });
                        return true;
                    }
                });
            }
        }

        fightBox.show(stage);
        hud.bringToFront();
    }

    /*------------------------------------ MÉTHODES DE SCREEN -------------------------------------*/

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        hud.update(v);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        game.batch.begin();
        BitmapFont font = new BitmapFont();
        font.draw(game.batch, "Maitre hotel screen" , Gdx.graphics.getWidth()*0.5f, Gdx.graphics.getHeight()*0.3f);
        game.batch.end();
        stage.draw();
    }

    @Override
    public void hide() {

    }

    public void dispose(){
        hud.dispose();
        stage.dispose();
    }
}

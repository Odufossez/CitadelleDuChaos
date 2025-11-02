package com.badlogic.citadel.Screens.OnGameScreens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogBox;
import com.badlogic.citadel.DialogWindows.DialogBoxMethods;
import com.badlogic.citadel.Dice;
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

//234
public class PrisonGameScreen extends ApplicationAdapter implements Screen {
    private Citadel game;
    private Stage stage;
    private HUD hud;

    private boolean faiblesse;

    private DialogBox dialogBox234 = new DialogBox("Narrator");
    private DialogBox dialogBox234_1 = new DialogBox("Narrator");
    private DialogBox dialogBox397 = new DialogBox("Narrator");
    private DialogBox dialogBox069 = new DialogBox("Narrator");
    private DialogBox dialogBox211 = new DialogBox("Narrator");
    private DialogBox dialogBox211_Calacorm = new DialogBox("Calacorm");
    private DialogBox dialogBox123 = new DialogBox("Narrator");
    private DialogBox dialogBox035 = new DialogBox("Narrator");
    private DialogBox dialogBox283 = new DialogBox("Narrator");
    private DialogBox dialogBox364 = new DialogBox("Narrator");
    private DialogBox dialogBox364_1 = new DialogBox("Narrator");
    private DialogBox dialogBox364_2 = new DialogBox("Narrator");
    private DialogBox dialogBox174 = new DialogBox("Narrator");
    private DialogBox dialogBox268 = new DialogBox("Narrator");
    private DialogBox dialogBox116 = new DialogBox("Narrator");
    private DialogBox dialogBox246 = new DialogBox("Narrator");

    public PrisonGameScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        hud = new HUD(game,stage);
    }

    public void create(){
        dialogBox234.text("You wake up in a dirty room with rough walls cut into the rock. Iron bars in the window and the door, " +
            "confirm your suspicion that you are in a prison cell of some sort. There is not much you can do but sit on the straw " +
            "mattress in one corner until someone appears. An hour or so later, you hear a shuffling noise outside. Looking through " +
            "the bars in the door you can see a lizard-like creature shuffling down the corridor, carrying a mug and a bowl.");
        dialogBox234_1.text("The beast has two heads which talk to each other as he walks. His skin is grey and scaly and a long " +
            "tail follows him up the passage. He stops at your door and pushes the bowl and mug through a small opening into your " +
            "cell, then shambles off to sit at a table across the hall.");
        dialogBox397.text("This is not much of a meal, but you were hungry and thirsty and this offering restores two PV. Now, " +
            "you may either call out the Calacorm or choose a spell to try to get out of this cell.");
        dialogBox069.text("The creature is not very talkative, but you do discover that you are in the dungeons beneath the " +
            "Black Tower and you will probably never be released, unless you are given to the Ganjees for sport. When you " +
            "question him about Balthus Dire, he goes silent.");
        dialogBox211.text("You offer him a pebbles you have turned into gold.");
        dialogBox211_Calacorm.text("Everything I want is down here. I am fed, I have a job to do and, if I get bored, I am " +
            "allowed to torture the prisoners for amusement. What do I want with gold ?");
        dialogBox123.text("You concentrate and images from the Calacorm flash through your mind. You see a plate full of dead snakes, " +
            "then a similar-looking creature with greyish skin - possibly the female of his species - then you feel a great sense of " +
            "pleasure as you see an unfortunate creature bound to the wall having its toes tickled with a burning torch. Nothing " +
            "that can help you escape whatsoever.");
        dialogBox035.text("You concentrate on your illusion. You can either convince him that he is being attacked by an enemy, or" +
            " make yourself disappear in the hope that he will come looking for you.");
        dialogBox283.text("Without magic, your fate is sealed. You are doomed to spend the rest of your days as a prisoner " +
            "in the Citadel of Chaos.");
        dialogBox364.text("As your spell takes effect, you see a small mouse runs towards the table. You curse as you realize " +
            "that the spell cannot have worked properly. But hope returns as one of the Calacorm's heads sees the mouse and looks " +
            "horrified! The other head suddenly notices it and both throats shriek together!");
        dialogBox364_1.text("The mouse jumps up on to the table, and the Calacorm screams in terror as the harmless little mouse " +
            "approaches, sniffing fastidiously at the ground on the way. You let the Calacorm suffer for some moments and then " +
            "call out that you will get rid of the mouse fo him, if he releases you.");
        dialogBox364_2.text("He agrees quickly and throws you the keys. You let yourself out, grab your sword which was leaning " +
            "against the wall and set off down the passageway. A safe distance away, you break your spell and the mouse disappears.");
        dialogBox174.text("The passageway twists and turns, eventually ending in a flight of stairs going upwards. You climb " +
            "the stairs and find yourself in a short passage ending at a dead end. As you examine the wall, you discover a short " +
            "lever, which you pull. The rock face ahead opens slightly and closes behind you as you walk through. You are " +
            "now standing in front of a door, which is locked.");
        dialogBox268.text("As you hit the door, the wood cracks a little but does not give. You try it again and this time " +
            "the wood splits down the middle. You break your way through into the room behind it.");
        dialogBox116.text("Your super-powered hands grip the handle and tug. It comes off in your grip. You bunch up a fist and slam " +
            "it into the centre of the door. The wood cracks and breaks, allowing you to break through into the room beyond.");
        dialogBox246.text("You disappear. You can, however, still watch the Calacorm from your cell. To your consternation, " +
            "the beasts has not noticed that you have gone! You wait patiently, but to no avail, and now you start to worry " +
            "the spell might be wearing off. You kick the dust and the creature looks up and rushes to your cell door, but " +
            "as he opens it, the spell wears off. You will have to fight the Calacorm.");
    }

    public void input(){
        continueDialogBox(dialogBox234,dialogBox234_1,hud,stage);
        continueDialogBox(dialogBox234_1,dialogBox397,"Eat the meal\nhe provided",stage,hud , ()->{
            game.getPlayer().setCurrentVitality(game.getPlayer().getCurrentVitality()+2);
        });
        continueDialogBox(dialogBox234_1,dialogBox069, "Talk to the guard" , stage, hud);

        continueDialogBox(dialogBox397,dialogBox283,"Do not use\na spell",stage, hud);
        continueDialogBox(dialogBox069,dialogBox283,"Do not use\na spell",stage, hud);
        continueDialogBox(dialogBox123,dialogBox283,"Do not use\na spell",stage, hud);
        continueDialogBox(dialogBox283,stage,new GameOverScreen(game),game);

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.OR_DU_SOT)){
            alertSpellDialog(dialogBox397,dialogBox211,SpellList.Sorts.OR_DU_SOT,hud,stage,game);
            alertSpellDialog(dialogBox069,dialogBox211,SpellList.Sorts.OR_DU_SOT,hud,stage,game);
            alertSpellDialog(dialogBox123,dialogBox211,SpellList.Sorts.OR_DU_SOT,hud,stage,game);
        }
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.TELEPATHIE)){
            alertSpellDialog(dialogBox397,dialogBox123,SpellList.Sorts.TELEPATHIE,hud,stage,game);
            alertSpellDialog(dialogBox069,dialogBox123,SpellList.Sorts.TELEPATHIE,hud,stage,game);
            alertSpellDialog(dialogBox211_Calacorm,dialogBox035,SpellList.Sorts.TELEPATHIE,hud,stage,game);
        }
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.ILLUSION)){
            alertSpellDialog(dialogBox397,dialogBox035,SpellList.Sorts.ILLUSION,hud,stage,game);
            alertSpellDialog(dialogBox069,dialogBox035,SpellList.Sorts.ILLUSION,hud,stage,game);
            alertSpellDialog(dialogBox211_Calacorm,dialogBox035,SpellList.Sorts.ILLUSION,hud,stage,game);
            alertSpellDialog(dialogBox123,dialogBox035,SpellList.Sorts.ILLUSION,hud,stage,game);
        }

        continueDialogBox(dialogBox211,dialogBox211_Calacorm,hud,stage);
        continueDialogBox(dialogBox035,dialogBox364,"Attack the guard",stage,hud);
        continueDialogBox(dialogBox035,dialogBox246,"Turn invisible",stage,hud);
        continueDialogBox(dialogBox364,dialogBox364_1,hud,stage);
        continueDialogBox(dialogBox364_1,dialogBox364_2,hud,stage);
        continueDialogBox(dialogBox364_2,dialogBox174,hud,stage);
        continueDialogBox(dialogBox174,dialogBox268,"Take down\nthe door",stage,hud);

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FORCE)){
            alertSpellDialog(dialogBox364_2,dialogBox116,SpellList.Sorts.FORCE,hud,stage,game);
        }
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FAIBLESSE)){
            alertSpellDialog(dialogBox364_2,dialogBox116,SpellList.Sorts.FAIBLESSE,hud,stage,game, ()->{
                faiblesse = true;
            });
            alertSpellDialog(dialogBox246,dialogBox116,SpellList.Sorts.FAIBLESSE,hud,stage,game, ()->{
                faiblesse = true;
            });
        }
        continueDialogBox(dialogBox246,"Get ready to fight",hud,this::combatCalacorm);
        continueDialogBox(dialogBox268,stage,new LutinScreen(game),game);
        continueDialogBox(dialogBox116,stage,new LutinScreen(game),game);

    }

    private void combatCalacorm(){
        Monster guard_Calacorm ;
        if (faiblesse){
            guard_Calacorm = new Monster("Calacorm" , 5 , 8);
        } else {
            guard_Calacorm = new Monster("Calacorm" , 9 , 8);
        }

        hud.showEnenmyHealthBars(guard_Calacorm);
    }

    private void showCombatDialog(Monster monster){
        //condition de victoire
        if (monster.isDead()){
            hud.hideEnenmyBars();
            DialogBox victory = new DialogBox("Narrator");
            victory.text("You defeated the Calacorm !");
            continueDialogBox(victory,dialogBox174,hud,stage);
            victory.show(stage);
            hud.bringToFront();
            return;
        }

        //joueur mort
        if (game.getPlayer().isDead()){
            stage.clear();
            game.setScreen(new GameOverScreen(game));
        }

        DialogBox fightBox = new DialogBox("Choose an action");
        //déroulement
        fightBox.button("Attack " + monster.getName(), new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                int scorePlayer = Dice.doubleDice() + game.getPlayer().getCurrentAbility();
                int scoreMonster = Dice.doubleDice() + monster.getAbility();

                Combat.displayAlertResolutionTour(Combat.resolutionTour(scorePlayer,scoreMonster,monster,game),stage,()->{
                    hud.showEnenmyHealthBars(monster);
                    showCombatDialog(monster);
                });

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
        dialogBox234.show(stage);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        hud.update(v);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        game.batch.begin();
        BitmapFont font = new BitmapFont();
        font.draw(game.batch, "Prison game screen" , Gdx.graphics.getWidth()*0.25f, Gdx.graphics.getHeight()*0.3f);
        game.batch.end();
        stage.draw();
    }

    @Override
    public void hide() {

    }

    @Override
    public void resize(int i, int i1) {
        stage.getViewport().update(i, i1, true);
    }

    @Override
    public void dispose() {
        hud.dispose();
        stage.dispose();
    }
}

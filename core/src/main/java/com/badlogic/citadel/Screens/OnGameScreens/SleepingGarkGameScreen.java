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
import static com.badlogic.citadel.Dice.doubleDice;

//352
public class SleepingGarkGameScreen extends ApplicationAdapter implements Screen {
    private Citadel game;
    private Stage stage;
    private HUD hud;

    private boolean faiblesse;
    private boolean copy;

    private final DialogBox dialogBox352 = new DialogBox("Narrator");
    private final DialogBox dialogBox352_1 = new DialogBox("Narrator");
    private final DialogBox dialogBox352_2 = new DialogBox("Narrator");
    private final DialogBox dialogBox203 = new DialogBox("Narrator");
    private final DialogBox dialogBox016 = new DialogBox("Narrator");
    private final DialogBox dialogBox216 = new DialogBox("Narrator");
    private final DialogBox dialogBox036 = new DialogBox("Narrator");
    private final DialogBox dialogBox262 = new DialogBox("Narrator");
    private final DialogBox dialogBox128 = new DialogBox("Narrator");
    private final DialogBox dialogBox152 = new DialogBox("Narrator");
    private final DialogBox dialogBox294 = new DialogBox("Narrator");
    private final DialogBox dialogBox038 = new DialogBox("Narrator");
    private final DialogBox dialogBox306 = new DialogBox("Narrator");
    private final DialogBox dialogBox099 = new DialogBox("Narrator");
    private final DialogBox dialogBox180 = new DialogBox("Narrator");
    private final DialogBox dialogBox391 = new DialogBox("Narrator");

    public SleepingGarkGameScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        hud = new HUD(game,stage);

        copy = false;
        faiblesse = false;
    }

    public void create(){
        dialogBox352.text("You tiptoe into the room. It is gloomy and the air is damp. A crude wooden post is nailed to one wall " +
            "with several hooks on it. There are two doors in the far wall leading onwards. On the post, hanging on the wall, " +
            "is a makeshift mirror but as your torch lights up the mirror, its reflection is thrown across the eyes of the sleeping giant");
        dialogBox352_1.text("He grunts and stirs. One eye opens, then another and seeing you, it springs to its feet! He " +
            "grabs an axe, which it was using as a pillow, and quickly undoes the leather sheath to reveal a sharp bronze " +
            "head.");
        dialogBox352_2.text("The giant creature is a Gark ! Large and brutish, Garks are half-goblin half-giant, bred by master " +
            "sorcerers for their aggressive character. Although somewhat stupid, they rather tough beasts with a war-like nature.");
        dialogBox203.text("As you race for the doors, you stumble, allowing the creature to gain ground. It grabs your arm " +
            "with one hand and throws you across the wall under the mirror. You will now either have to draw your sword or " +
            "use a spell");
        dialogBox016.text("You may escape in some turns through one of the doors, or you may fight the Gark");
        dialogBox216.text("What will your approach be? You may either tell the creature that you are a guest, or you may " +
            "try to bribe by offering him 3 *real* gold pieces, or by using Fool's gold to create some gold to offer it.");
        dialogBox036.text("It dawns on the creature that if you are offering a bribe, you must be an intruder, which, for a Gark, " +
            "is quite a stunning piece of logical thinking ! He slaps you hard with his great hand, knocking you unconscious. " +
            "The last words you hear before you pass out are the proud Gark's : 'Into the jail for this one'.");
        dialogBox262.text("As you cast the spell, an identical Gark, similarly armed, appears before you. At your command, the " +
            "battle starts ! " );
        dialogBox128.text("As the spell takes its effect, you begin to get various thoughts as they flash through the creature's " +
            "mind. Apart from a feeling of fear that its captain might find out it was asleep at its post and let an intruder " +
            "in, it holds some strange reverence for a carved Hairbrush which is apparently in the room somewhere.");
        dialogBox152.text("You cast your spell and the creature stops in its tracks, not quite sure what has happened to it. " +
            "With some effort, he picks up his axe and comes towards you, but is evidently not such a strong adversary as before.");
        dialogBox294.text("The Gark straightens up, lowers his axe and begins apologizing to your for being asleep at his post " +
            "At his insistence you agree not to tell anyone. The creature offers you to take your tunic but you decline and press onwards");
        dialogBox038.text("The door opens into a short passageway which is paved with small sones. A short distance further " +
            "on, an ornately caved door marks the end of the passageway. But just before the door, a side passage leads off " +
            "to the left. You approach the door, it is fancy. Listening for any signs of life inside. As your hand touches " +
            "the handle, a voice invites you to enter from inside.");
        dialogBox306.text("A short distance further on, a door blocks the passageway. In fact, this only a half-door and is " +
            "about waist-high to you. A sign by the door points onwards and says 'Players Only'.");
        dialogBox099.text("Will you take the left-hand door or the right-hand door?");
        dialogBox180.text("You loot the body of the Gark and gain 6 gold pieces. You also get an Enchanted Brush.");
        dialogBox391.text("The Gark takes your 3 gold pieces, puts them into a pouch around his waist and shows you onwards " +
            "to the doors. He asks you whether you would like to go to the Library (Right) or the Games Room (Left).");
    }

    public void input(){
        continueDialogBox(dialogBox352,dialogBox352_1,hud,stage);
        continueDialogBox(dialogBox352_1,dialogBox352_2,hud,stage);

        continueDialogBox(dialogBox352_2,dialogBox203,"Rush to\nthe door",stage,hud);
        continueDialogBox(dialogBox352_2,dialogBox016,"Draw out\nmy sword",stage,hud);
        continueDialogBox(dialogBox352_2,dialogBox216,"Excuse you",stage,hud);

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.OR_DU_SOT)){
            alertSpellDialog(dialogBox352_2,dialogBox036, SpellList.Sorts.OR_DU_SOT, hud,stage,game);
            alertSpellDialog(dialogBox216,dialogBox036, SpellList.Sorts.OR_DU_SOT, hud,stage,game);
            alertSpellDialog(dialogBox203,dialogBox036, SpellList.Sorts.OR_DU_SOT, hud,stage,game);
            alertSpellDialog(dialogBox128,dialogBox036, SpellList.Sorts.OR_DU_SOT, hud,stage,game);
        }

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.COPIE_CONFORME)){
            alertSpellDialog(dialogBox352_2,dialogBox262, SpellList.Sorts.COPIE_CONFORME, hud,stage,game, ()->{
                copy = true;
            });
            alertSpellDialog(dialogBox203,dialogBox262, SpellList.Sorts.COPIE_CONFORME,hud,stage,game, ()->{
                copy = true;
            });
            alertSpellDialog(dialogBox128,dialogBox262, SpellList.Sorts.COPIE_CONFORME,hud,stage,game, ()->{
                copy = true;
            });
        }

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.TELEPATHIE)){
            alertSpellDialog(dialogBox352_2,dialogBox128, SpellList.Sorts.TELEPATHIE, hud,stage,game);
            alertSpellDialog(dialogBox203,dialogBox128, SpellList.Sorts.TELEPATHIE,hud,stage,game);
        }

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FAIBLESSE)){
            alertSpellDialog(dialogBox352_2,dialogBox152, SpellList.Sorts.FAIBLESSE, hud,stage,game, ()->{
                faiblesse = true;
            });
            alertSpellDialog(dialogBox203,dialogBox152, SpellList.Sorts.FAIBLESSE,hud,stage,game,()->{
                faiblesse = true;
            });
            alertSpellDialog(dialogBox128,dialogBox152, SpellList.Sorts.FAIBLESSE,hud,stage,game,()->{
                faiblesse = true;
            });
        }

        continueDialogBox(dialogBox262,"Fight",hud, this::combat16);
        continueDialogBox(dialogBox152,"Fight",hud, this::combat16);

        continueDialogBox(dialogBox203,dialogBox016,"Draw out my sword",stage,hud);
        continueDialogBox(dialogBox128,dialogBox016,"Draw out my sword",stage,hud);

        continueDialogBox(dialogBox016, "Get ready to fight",hud, this::combat16);
        continueDialogBox(dialogBox016,dialogBox294,"I am a guest !",stage,hud);
        if (game.getPlayer().getGold()>=3){
            continueDialogBox(dialogBox016,dialogBox391,hud,stage,game,3,false);
        }
        continueDialogBox(dialogBox294,dialogBox099,hud,stage);
        continueDialogBox(dialogBox391,dialogBox099,hud,stage);

        continueDialogBox(dialogBox099,"Left",stage,new GameRoomScreenGame(game),game);
        continueDialogBox(dialogBox099,dialogBox038,"Right",stage,hud);

        continueDialogBox(dialogBox038,"Enter the room\nas instructed",stage,new LibraryGameScreen(game),game);
        continueDialogBox(dialogBox038,dialogBox306,"Take the passage leading\noff to the left",stage,hud);

        continueDialogBox(dialogBox306,"Push open this door",stage,new GameRoomScreenGame(game),game);
        continueDialogBox(dialogBox306,"Enter the room\nwith the fancy door",stage,new LibraryGameScreen(game),game);

        continueDialogBox(dialogBox180, dialogBox099, "Loot the body", stage, hud, ()->{
            game.getPlayer().setGold(game.getPlayer().getGold()+6);
            game.getPlayer().getInventory().getInventory().add(Item.Items.ENCHANTED_BRUSH);
        });
    }

    private void combat16(){
        int cptTour = 0;
        Monster gark;
        Monster garkDouble;
        if (faiblesse){
            gark = new Monster("Gark" , 5 , 5);
            garkDouble = null;
        } else {
            gark = new Monster("Gark" , 7 , 11);
            garkDouble = null;
        }
        if (copy){
            gark = new Monster("Gark" , 7 , 11);
            garkDouble = new Monster("Gark" , 7 , 11);
        }

        hud.showEnenmyHealthBars(gark);

        showCombatDialog(gark,garkDouble,cptTour);
    }

    private void showCombatDialog(Monster monster, Monster ally, int cptTour){
        //Conditions de victoire
        if (monster.isDead()){
            hud.hideEnenmyBars();
            DialogBox victory = new DialogBox("Narrator");
            victory.text("You defeated the " + monster.getName() + " !");
            continueDialogBox(victory,dialogBox180,hud,stage);
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
        fightBox.button("Attack the "+monster.getName(), new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                int scorePlayer = doubleDice()+game.getPlayer().getCurrentAbility()+game.getPlayer().getWeaponBonus();
                int scoreMonster = Dice.doubleDice()+monster.getAbility();

                fightBox.hide();
                Combat.displayAlertResolutionTour(Combat.resolutionTour(scorePlayer,scoreMonster,monster,game),stage,()->{
                    hud.showEnenmyHealthBars(monster);
                    showCombatDialog(monster,ally,cptTour+1);
                });
                return true;
            }
        });

        if (ally!=null && !ally.isDead()){
            fightBox.button("The copy attacks\nthe "+monster.getName(), new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    int scoreDouble = ally.getAbility() + doubleDice();
                    int scoreMonstre = monster.getAbility() + doubleDice();

                    Combat.displayAlertResolutionTour(Combat.resolutionTour(scoreDouble,scoreMonstre,ally,monster,game),stage,()->{
                        hud.showEnenmyHealthBars(monster);
                        showCombatDialog(monster,ally,cptTour+1);
                    });

                    return true;
                }
            });
        }

        if (cptTour>=3){
            fightBox.button("Run away", new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    fightBox.hide();
                    dialogBox099.show(stage);
                    hud.bringToFront();
                    return true;
                }
            });
        }

        fightBox.show(stage);
        hud.bringToFront();

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();
        dialogBox352.show(stage);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        hud.update(v);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        game.batch.begin();
        BitmapFont font = new BitmapFont();
        font.draw(game.batch, "Lutin screen" , Gdx.graphics.getWidth()*0.25f, Gdx.graphics.getHeight()*0.3f);
        game.batch.end();
        stage.draw();
    }

    @Override
    public void hide() {

    }

    public void dispose(){
        stage.dispose();
        hud.dispose();
    }
}

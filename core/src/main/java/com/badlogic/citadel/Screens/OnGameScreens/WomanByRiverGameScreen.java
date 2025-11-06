package com.badlogic.citadel.Screens.OnGameScreens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogBox;
import com.badlogic.citadel.Item;
import com.badlogic.citadel.PlayerRelatedMethods.SpellList;
import com.badlogic.citadel.Screens.HUD;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.citadel.DialogWindows.DialogBoxMethods.alertSpellDialog;
import static com.badlogic.citadel.DialogWindows.DialogBoxMethods.continueDialogBox;

//90
public class WomanByRiverGameScreen extends ApplicationAdapter implements Screen {
    private final Citadel game;
    private final Stage stage;
    private final HUD hud;

    private final DialogBox dialogBox090 = new DialogBox("Narrator");
    private final DialogBox dialogBox176 = new DialogBox("Narrator");
    private final DialogBox dialogBox329 = new DialogBox("Narrator");
    private final DialogBox dialogBox021 = new DialogBox("Narrator");
    private final DialogBox dialogBox221 = new DialogBox("Narrator");
    private final DialogBox dialogBox127 = new DialogBox("Narrator");
    private final DialogBox dialogBox053 = new DialogBox("Narrator");
    private final DialogBox dialogBox387 = new DialogBox("Narrator");
    private final DialogBox dialogBox240 = new DialogBox("Narrator");
    private final DialogBox dialogBox194 = new DialogBox("Narrator");
    private final DialogBox dialogBox006 = new DialogBox("Narrator");
    private final DialogBox dialogBox367 = new DialogBox("Narrator");
    private final DialogBox dialogBox308 = new DialogBox("Narrator");
    private final DialogBox dialogBox121 = new DialogBox("Narrator");

    public WomanByRiverGameScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        hud = new HUD(game, stage);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();

        dialogBox090.show(stage);
    }

    public void create() {
        dialogBox090.text("The passageway widens and you are now walking alongside a flowing river. Just ahead, a woman seems " +
            "to be washing clothes. She has a basket of these beside her, and several sets of long johns are hanging on  line " +
            "behind her.");
        dialogBox176.text("As you get closer, she turns to look at you. Not in the least perturbed by your weapon, she says " +
            "to put down your weapon, she's just an old woman.");
        dialogBox329.text("You concentrate on her mind and you are shocked to find that she is not alive, as she seems, but " +
            "has been dead for many years. Ever since a raging fire - a curse put on her by Balthus Dire for failing to " +
            "launder his robes in time - burned her and her children to death. Her ghostly body has been doomed to wash clothes " +
            "for eternity. She is indeed a miserable wretch. You notice that she is growing angry and suspicious with your presence." +
            " She is chanting something under a breath.");
        dialogBox021.text("You tell her your story, carefully avoiding your real mission. She advises that if you know any magic, " +
            "you should flee from this place. The creature you have met so far do not compare with those you will come across within" +
            " the Citadel Tower itself. She tells you you will never meet the master without finding the Fleece first, bids " +
            "you luck on your mission.");
        dialogBox221.text("As you move forwards, she makes a peculiar gesture with her hands and lowers her head, mumbling " +
            "quietly.");
        dialogBox127.text("She lifts her head and calls into the air. You stop in your tracks as you see the washing on the " +
            "line rustle and kick about in the air. Freeing themselves from the line, as they get close, you can make out ghostly " +
            "bodies with long-dead faces inside of them. She cries for her sons and daughters to protect her and the clothes " +
            "surround you. One pair of arms wraps itself around your neck, making it difficult to breathe. Your sword seems " +
            "to swing in the air, not doing much to the ghosts.");
        dialogBox053.text("She laughs at your berries. She has lost her appetite at the same time as her body. She is nothing " +
            "but a ghost. She floats across in the air towards you.");
        dialogBox387.text("At the mention of a Silver Mirror, she rises, holds up her hands, and commands her Ghosts to stop. " +
            "You give her the mirror and she bids you on your way. You are lucky to be alive.");
        dialogBox240.text("You hold up a flaming hand, running it down the back of the gown with its arms around your neck. " +
            "It bursts into flames and a silent scream comes from the dead mouth within it. The other ghosts back off and " +
            "you set fire to a couple more as they retreat but they are too close and you burn yourself a bit. Walking " +
            "carefully forward you hold the rest of the Ghosts at bay until you are safely past the woman.");
        dialogBox194.text("The strangehold around your neck tightens and your last living memory is one of fear - of these non-" +
            "human creatures with their long dead-faces, gloating over your death.");
        dialogBox006.text("The path runs alongside the river for several metres and then cuts back into the rock. You follow " +
            "the path for some time.");
        dialogBox367.text("Some way along the passage, you arrive at a four-way junction. You take a path to the north, which " +
            "eventually leads you to a large wooden door. You can hear nothing by listening at the keyhole.");
        dialogBox308.text("The handle turns and you step into a dark room.");
        dialogBox121.text("As you run at the door, it suddenly opens in front of you. Unable to stop, you rush headlong forwards " +
            "into the room, eventually tripping over and rolling to a stop.");
    }

    public void input() {
        continueDialogBox(dialogBox090, dialogBox176, "Draw my sword", stage, hud);
        continueDialogBox(dialogBox090, dialogBox021, "Talk to\nthe woman", stage, hud);
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.TELEPATHIE)) {
            alertSpellDialog(dialogBox090, dialogBox329, SpellList.Sorts.TELEPATHIE, hud, stage, game);
            alertSpellDialog(dialogBox176, dialogBox329, SpellList.Sorts.TELEPATHIE, hud, stage, game);
            continueDialogBox(dialogBox329, dialogBox021, "Talk to\nthe woman", stage, hud);
            continueDialogBox(dialogBox329, dialogBox221, "Move quickly past her\nalong the path", stage, hud);
            continueDialogBox(dialogBox221, dialogBox127, hud, stage, null);
        }

        continueDialogBox(dialogBox021, dialogBox006, hud, stage, () -> {
            game.getPlayer().modifyCurrentLuck(+2);
        });

        continueDialogBox(dialogBox176, dialogBox021, "Talk to the woman", stage, hud);
        continueDialogBox(dialogBox176, dialogBox127, "Draw my sword", stage, hud);

        if (game.getPlayer().getInventory().hasItem(Item.Items.BERRIES)) {
            continueDialogBox(dialogBox127, dialogBox053, "Give her berries", stage, hud);
        }
        if (game.getPlayer().getInventory().hasItem(Item.Items.SILVER_MIRROR)) {
            continueDialogBox(dialogBox127, dialogBox387, "Give her the silver mirror", stage, hud);
        }
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FEU)) {
            alertSpellDialog(dialogBox127, dialogBox240, SpellList.Sorts.FEU, hud, stage, game,()->{
                game.getPlayer().isTouchedInCombat();
            });
        }
        continueDialogBox(dialogBox127,dialogBox194,"Do nothing",stage,hud);
        continueDialogBox(dialogBox194,stage,new GameOverScreen(game),game,null);

        continueDialogBox(dialogBox387,dialogBox006,hud,stage,()->{
            game.getPlayer().getInventory().removeFrom(Item.Items.SILVER_MIRROR);
        });
        continueDialogBox(dialogBox240,dialogBox006,hud,stage,null);
        continueDialogBox(dialogBox006,dialogBox367,hud,stage,null);

        continueDialogBox(dialogBox367,dialogBox308,"Open the door slowly",stage,hud);
        continueDialogBox(dialogBox367,dialogBox121,"Charge the door down",stage,hud);

        continueDialogBox(dialogBox121,stage,new GolemGameScreen(game),game,()->{
            game.getPlayer().modifyCurrentVitality(-1);
        });
        continueDialogBox(dialogBox308,stage,new GolemGameScreen(game),game,null);
    }

    public void dispose() {
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
        font.draw(game.batch, "Women by river screen", Gdx.graphics.getWidth() * 0.25f, Gdx.graphics.getHeight() * 0.3f);
        game.batch.end();
        stage.draw();
    }

    @Override
    public void hide() {

    }
}

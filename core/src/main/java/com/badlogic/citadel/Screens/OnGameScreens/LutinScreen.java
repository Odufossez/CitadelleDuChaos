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
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.citadel.DialogWindows.DialogBoxMethods.*;

//210
public class LutinScreen extends ApplicationAdapter implements Screen {
    private Citadel game;
    private Stage stage;
    private HUD hud;

    private DialogBox dialogBox210 = new DialogBox("Narrator");
    private DialogBox dialogBox192 = new DialogBox("Narrator");
    private DialogBox dialogBox359 = new DialogBox("Narrator");
    private DialogBox dialogBox029 = new DialogBox("Narrator");
    private DialogBox dialogBox029_1 = new DialogBox("O'Seamus The Leprechaun");
    private DialogBox dialogBox029_2 = new DialogBox("Narrator");
    private DialogBox dialogBox271 = new DialogBox("Narrator");
    private DialogBox dialogBox131 = new DialogBox("Narrator");
    private DialogBox dialogBox271_1 = new DialogBox("Narrator");
    private DialogBox dialogBox271_2 = new DialogBox("O'Seamus The Leprechaun");
    private DialogBox dialogBox348 = new DialogBox("Narrator");
    private DialogBox dialogBox348_1 = new DialogBox("O'Seamus The Leprechaun");
    private DialogBox dialogBox207 = new DialogBox("Narrator");
    private DialogBox dialogBox022 = new DialogBox("Narrator");
    private DialogBox dialogBox354 = new DialogBox("Narrator");
    private DialogBox dialogBox068 = new DialogBox("O'Seamus The Leprechaun");
    private DialogBox dialogBox188 = new DialogBox("Narrator");
    private DialogBox dialogBox301 = new DialogBox("Narrator");
    private DialogBox dialogBox159 = new DialogBox("Narrator");
    private DialogBox dialogBox051 = new DialogBox("Narrator");
    private DialogBox dialogBox280 = new DialogBox("Narrator");
    private DialogBox dialogBox323 = new DialogBox("Narrator");
    private DialogBox dialogBox323_1 = new DialogBox("Narrator");
    private DialogBox dialogBox323_2 = new DialogBox("Narrator");
    private DialogBox dialogBox323_3 = new DialogBox("O'Seamus The Leprechaun");
    private DialogBox dialogBox386 = new DialogBox("Narrator");
    private DialogBox dialogBox204 = new DialogBox("Narrator");
    private DialogBox dialogBox108 = new DialogBox("Narrator");
    private DialogBox dialogBox338 = new DialogBox("Narrator");

    public LutinScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        hud = new HUD(game,stage);
        dialogBox210.show(stage);
    }

    public void create(){
        dialogBox210.text("You now stand in a large, round room. It is lit by a single torch, fixed into one wall. There is " +
            "just a rough wooden table and chair in the center. Hovering above the table - fast asleep - is a very small man " +
            "in a green shirt and pantaloons. You cannot believe that he is still asleep after your noisy entrance ! You " +
            "hear a creak and turn to your right in time to see a small catapult fire a missile of some sort straight at you.");
        dialogBox192.text("You cast the spell just in time. The missile hits your magical shield and splatters against it, " +
            "dribbling on the floor. You test the resulting mush to see what it was. You were nearly hit by a tomato! " +
            "In the center of the room, the sleeping figure is stirring.");
        dialogBox359.text("You try to duck, but cannot avoid the full impact of the missile, which hits you on the forehead " +
            "and splatters all over your face. You brace yourself waiting perhaps for an acidic reaction to take place, but " +
            "the mushy liquid merely drips off your face on to the ground. Cautiously you test it, first with your tongue. " +
            "You have just been hit by a ripe tomato! You turn to face the sleeping figure once more.");
        dialogBox029.text("Cautiously, you approach the little man. As you get close, a single eye opens and looks you straight " +
            "in the face. A wide grin spreads between the creature's ears and he disappears!");
        dialogBox029_1.text("Good mornin' to yer ! I'm O'Seamus, the Leprechaun!");
        dialogBox029_2.text("He chuckles, and holds his hand out to you. He seems friendly enough. Will you shake his hand ?");
        dialogBox271.text("You grasp his hand and introduce yourself - and cry out as the nerves down your arm go numb! " +
            "O'Seamus bursts out laughing. You are becoming angry, but the little man continues to shake your hand and laugh. ");
        dialogBox271_1.text("A laugh comes from behind you and you look round to see him floating in the air, grinning. But " +
            "you are still shaking his hand in front of you... or are you ? In fact, you now realize you are frantically " +
            "shaking hands with a stuffed dummy which is flopping around on the end of your arm as you shake it. You throw it " +
            "to the ground - but it is stuck to your hand ! The situation is ludicrous, and you are becoming very angry.");
        dialogBox271_2.text("Just a little joke ! Now, what can I do for you ?");
        dialogBox348.text("He turns to three doors, each one with a different handle.");
        dialogBox348_1.text("Oh, I shouldn't go this way. These are not pleasant parts. These three doors are the only ways " +
            "onward. Two of them are very dangerous and the other is very smelly.");
        dialogBox207.text("You open the door and peer through into the darkness beyond. You walk a couple of paces forward, " +
            "allowing your eyes to accustom themselves to the blackness. You close the door behind you, bidding the Leprechaun " +
            "farewell");
        dialogBox022.text("You open the door and step out in a long, dark corridor.");
        dialogBox354.text("You open the door and step into another room, glad to have left the annoying little creature " +
            "behind.");
        dialogBox068.text("Which would I take eh ? Let's see... I would not take the door doors to the left of the copper" +
            "-handled one, nor the door to the right of the bronze-handled one.");
        dialogBox188.text("A sudden intense flash of light burst out in front of you. You shield your eyes and then rub them" +
            "-but you cannot see! Panic hits you as you hear a low growling noise. Padded footsteps come closer and you cry" +
            " out in pain as this unseen creature roars and embeds its sharp teeth in your leg. What to do ?");
        dialogBox301.text("You feel strength surging through your body. You try to wrestle with the head of this creature " +
            "but its own strength seems also to have increased to match yours. Your leg is now useless and covered in blood. " +
            "Your strength begins to fade, and as it does so, the creature jaw close on your throat. Consciousness fades.");
        dialogBox159.text("You cast Weakness. Hopefully, you wait for the creature's strength to fade. But as its teeth still " +
            "maul you, you are dismayed to find that its attack is becoming more ferocious. You cannot feel your leg now. " +
            "The pain is intense. You feel faint and lose consciousness as the jaws close on your throat.");
        dialogBox051.text("You slash about madly with your sword but cannot hit the creature. Either it is extremely quick " +
            "or it has no solid body for you to it! Its teeth are now tearing at your flesh and you can feel blood on your leg." +
            " You will have to protect yourself with your magic, or face certain death from this unseen creature.");
        dialogBox280.text("The creature is savaging you mercilessly and you are powerless to prevent it. Your leg is covered " +
            "in blood and the pain is sickening. To no avail you struggle with the unseen head. You are in agony. The creature " +
            "lunges at your neck, and your last memory, before losing consciousness, is of its jaws closing around your throat.");
        dialogBox323.text("You awake and look around. As your memory returns, you are amazed that you can see ! Your leg " +
            "feels tender, but it uninjured ! You hear a small chuckle coming from above you and suddenly the whole thing " +
            "makes sense...");
        dialogBox323_1.text("Floating above you is O'Seamus, now laughing loudly. The whole thing has been one big practical " +
            "joke You are enraged and leap to your feet, but as you glare at the funny little man rolling about in the air in " +
            "hysterics, you can't help but see the funny side too. You chuckle, then giggle, then laugh loudly. For some time" +
            " the two of you roar with laughter until tears stream down your faces.");
        dialogBox323_2.text("When you are both able to control yourselves, you eventually settle down to chat. He is a " +
            "pleasant little man");
        dialogBox323_3.text("Indeed you are a good sport. Your way ahead is fraught with danger, though. But perhaps these " +
            "will help you.");
        dialogBox386.text("Outside the door, the passage slopes downwards and you follow it for several minutes. You notice an " +
            "unpleasant smell which gets stronger and stronger as you go. Eventually you come to an opening. Looking " +
            "through it, holding your nose, you can see a large open sewer flowing across the passageway. A rope hangs down " +
            "from the ceiling.");
        dialogBox204.text("You hold your nose and step forward into the slimy water. A couple of steps in, you feel pulling on " +
            "your leg. Lifting it out the water you find that some sort of vine has coiled itself around your leg. You leap " +
            "back to the bank and the vine rises, moves around in the air as if looking at you, and then falls back with a " +
            "splash. You realize that this is not a vine but a sewer snake, which is now pulling itself towards you.");
        dialogBox108.text("You grasp the rope firmly, step back, and take a run at putrid river. Suddenly, the rope snatches and " +
            "whips with a mind of its own! You quickly let go and drop down to the ground. The rope drops on top of you. " +
            "You realize that it is not a rope but, in fact, a long sewer snake, which wraps itself around your body and neck");
        dialogBox338.text("The door opens into a passageway. You follow the passageway onwards for some time and it twists " +
            "and turns through the rock. You pass another passageway joining from the right and carry straight on. Eventually " +
            "the path widens out.");
        dialogBox131.text("You quickly unsheathe the sword, pointing it towards the Leprechaun. He throws a glance at the blade " +
            "and to your horror it droops limply from the hilt, hanging downwards like a leather belt. It seems that you won't " +
            "get far acting aggressively. Perhaps you had better ask him the way onwards.");
    }

    public void input(){
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.PROTECTION)){
            alertSpellDialog(dialogBox210, dialogBox192, SpellList.Sorts.PROTECTION, hud, stage, game);
        }
        continueDialogBox(dialogBox210,dialogBox359,"Protect yourself as you can",stage,hud);
        continueDialogBox(dialogBox192,dialogBox029, hud, stage);
        continueDialogBox(dialogBox359,dialogBox029, hud, stage);
        continueDialogBox(dialogBox029,dialogBox029_1, hud, stage);
        continueDialogBox(dialogBox029_1,dialogBox029_2, hud, stage);

        dialogBox029_2.button("Handshake O'Seamus The Leprechaun" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                dialogBox029_2.hide();
                game.getPlayer().modifyCurrentAbility(-1);
                dialogBox271.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        continueDialogBox(dialogBox029_2,dialogBox131, "Draw out your sword", stage, hud);
        continueDialogBox(dialogBox271,dialogBox271_1, hud,stage);
        continueDialogBox(dialogBox271_1,dialogBox271_2, hud,stage);
        continueDialogBox(dialogBox271_2,dialogBox131, "Draw out my sword", stage, hud);
        continueDialogBox(dialogBox271_2,dialogBox348, "Ask for directions", stage, hud);
        continueDialogBox(dialogBox131,dialogBox348, "Ask for directions", stage, hud);

        continueDialogBox(dialogBox348,dialogBox348_1, hud,stage);
        continueDialogBox(dialogBox348_1,dialogBox207, "The brass-\nhandled door" , stage, hud);
        continueDialogBox(dialogBox348_1,dialogBox022, "The copper-\nhandlded door" , stage, hud);
        continueDialogBox(dialogBox348_1,dialogBox354, "The bronze-\nhandled door" , stage, hud);
        continueDialogBox(dialogBox348_1,dialogBox068, "Ask for\nhis opinion", stage, hud);

        continueDialogBox(dialogBox068,dialogBox207, "The brass-\nhandled door" , stage, hud);
        continueDialogBox(dialogBox068,dialogBox022, "The copper-\nhandlded door" , stage, hud);
        continueDialogBox(dialogBox068,dialogBox354, "The bronze-\nhandled door" , stage, hud);

        continueDialogBox(dialogBox207,dialogBox188, hud, stage);
        continueDialogBox(dialogBox022,dialogBox188, hud, stage);
        continueDialogBox(dialogBox354,dialogBox188, hud, stage);

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FORCE)){
            alertSpellDialog(dialogBox188, dialogBox301, SpellList.Sorts.FORCE, hud, stage, game);
            alertSpellDialog(dialogBox051, dialogBox301, SpellList.Sorts.FORCE, hud, stage, game);
        }
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FAIBLESSE)){
            alertSpellDialog(dialogBox188, dialogBox159, SpellList.Sorts.FAIBLESSE, hud, stage, game);
            alertSpellDialog(dialogBox051, dialogBox159, SpellList.Sorts.FAIBLESSE, hud, stage, game);
        }
        continueDialogBox(dialogBox188,dialogBox051, "Draw out your sword", stage, hud);
        continueDialogBox(dialogBox051,dialogBox280, hud, stage);
        continueDialogBox(dialogBox280,dialogBox323, hud, stage);
        continueDialogBox(dialogBox301,dialogBox323, hud, stage);
        continueDialogBox(dialogBox159,dialogBox323, hud, stage);
        continueDialogBox(dialogBox323,dialogBox323_1, hud, stage);
        continueDialogBox(dialogBox323_1,dialogBox323_2, hud, stage);
        dialogBox323_2.button("Continue", new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                game.getPlayer().getInventory().putIn(Item.Items.SILVER_MIRROR);
                game.getPlayer().setWeaponBonus(1);
                alertNotification("You obtain two items" , "You obtain a silver mirror and a sword+1",stage,hud, ()->{
                    dialogBox323_2.hide();
                    dialogBox323_3.show(stage);
                    hud.bringToFront();
                });
                return true;
            }
        });
        continueDialogBox(dialogBox323_3,dialogBox386, "The brass-handled door", stage, hud);
        continueDialogBox(dialogBox323_3, "The copper-handled door", stage, new CaveVinGameScreen(game),game);
        continueDialogBox(dialogBox323_3, dialogBox338,"The bronze-handled door", stage,hud);

        continueDialogBox(dialogBox386,dialogBox204, "Wade accross the sewer" , stage, hud);
        continueDialogBox(dialogBox386,dialogBox108, "Use the rope\nand swing across" , stage, hud);

        continueDialogBox(dialogBox204,stage,new PassageRiverGameScreen(game),game);
        continueDialogBox(dialogBox108,stage,new PassageRiverGameScreen(game),game);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();
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
        hud.dispose();
        stage.dispose();
    }

    public void resize(int width, int height){
        stage.getViewport().update(width, height, true);
    }
}

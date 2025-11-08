package com.badlogic.citadel.Screens.OnGameScreens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogAlert;
import com.badlogic.citadel.DialogWindows.DialogBox;
import com.badlogic.citadel.DialogWindows.DialogBoxMethods;
import com.badlogic.citadel.Dice;
import com.badlogic.citadel.Item;
import com.badlogic.citadel.Methods.Combat;
import com.badlogic.citadel.Methods.Monster;
import com.badlogic.citadel.PlayerRelatedMethods.SpellList;
import com.badlogic.citadel.Screens.HUD;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.citadel.DialogWindows.DialogBoxMethods.*;

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
    DialogBox dialogBox222_Sword = new DialogBox("Narrator");
    DialogBox dialogBox222_Illusion = new DialogBox("Narrator");
    DialogBox dialogBox222_Protection = new DialogBox("Narrator");
    DialogBox dialogBox222_Weakness = new DialogBox("Narrator");
    DialogBox dialogBoxTumbling = new DialogBox("Narrator");

    DialogBox dialogBoxWell = new DialogBox("Narrator");
    DialogBox dialogBoxWell_Levitation = new DialogBox("Narrator");
    DialogBox dialogBoxWell_Force = new DialogBox("Narrator");
    DialogBox dialogBoxWell_Recast = new DialogBox("Narrator");
    DialogBox dialogBoxWell_CallHelp = new DialogBox("Narrator");
    DialogBox dialogBoxTree = new DialogBox("Narrator");
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


    DialogBox dialogBox321 = new DialogBox("Narrator");
    DialogBox dialogBoxDuo = new DialogBox("Narrator");
    DialogBox dialogBoxDuo_1 = new DialogBox("Tall man");
    DialogBox dialogBoxDuo_2 = new DialogBox("Small man");
    DialogBox dialogBoxDuo_3 = new DialogBox("Narrator");
    DialogBox dialogBoxDuo_4 = new DialogBox("Tall man");
    DialogBox dialogBox186 = new DialogBox("Narrator");
    DialogBox dialogBoxDagger = new DialogBox("Narrator");
    DialogBox dialogBoxAlive = new DialogBox("Small man");
    DialogBox dialogBoxDead = new DialogBox("Narrator");
    DialogBox dialogBox161 = new DialogBox("Narrrator");
    DialogBox dialogBox161_1 = new DialogBox("Narrator");
    DialogBox dialogBoxWindWomen = new DialogBox("Narrator");
    DialogBox dialogBoxWindWomen_1 = new DialogBox("Narrator");
    DialogBox dialogBoxTricked = new DialogBox("Narrator");
    DialogBox dialogBoxNotTricked = new DialogBox("Narrator");
    DialogBox dialogBoxChatting = new DialogBox("Narrator");
    DialogBox dialogBoxWind = new DialogBox("Narrator");
    DialogBox dialogBoxWind_1 = new DialogBox("Wind Women");
    DialogBox dialogBoxWind_2 = new DialogBox("Narrator");
    DialogBox dialogBoxDouble = new DialogBox("Narrator");
    DialogBox dialogBoxGaz = new DialogBox("Narrator");
    DialogBox dialogBoxFly = new DialogBox("Narrator");
    DialogBox dialogBoxLucky390 = new DialogBox("Narrator");
    DialogBox dialogBoxFireCamp = new DialogBox("Narrator");
    DialogBox dialogBoxFireCamp_1 = new DialogBox("Narrator");
    DialogBox dialogBoxFireCamp_2 = new DialogBox("Narrator");
    DialogBox dialogBoxSitDown = new DialogBox("Narrator");
    DialogBox dialogBoxSitDown_1 = new DialogBox("Orc");
    DialogBox dialogBoxSitDown_2 = new DialogBox("Narrator");
    DialogBox dialogBoxSitDown_3 = new DialogBox("Narrator");
    DialogBox dialogBoxLevitFireCamp =  new DialogBox("Narrator");
    DialogBox dialogBoxScorpion = new DialogBox("Narrator");
    DialogBox dialogBoxNotInterested = new DialogBox("Narrator"); //149
    DialogBox dialogBoxNotInterested_1 = new DialogBox("Narrator"); //380
    DialogBox dialogBoxFireCampFight = new DialogBox("Narrator");
    DialogBox dialogBoxFightGolds = new DialogBox("Narrator");
    DialogBox dialogBoxFightKey = new DialogBox("Narrator");
    DialogBox dialogBoxFightOintment = new DialogBox("Narrator");
    DialogBox dialogBoxEndChoice = new DialogBox("Narrator");

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
        dialogBox1.text("You are standing in the shadow of the rampart surrounding the courtyard. " +
            "How do you want to proceed? You could sneak your way to the next door or cross the courtyard. " +
            "Maybe go talk to the bystanders on your left ?");
        dialogBox209.text("You take a look at the rather odd structure. It is not a fountain but a sort of temple. " +
            "There is a door on the side. Might be worth a look, or maybe you prefer to continue on your way to the tower.");
        dialogBoxTree.text("In the far corner of the courtyard, you come across a peculiar bush with branches twisting out" +
            " from the central stalk, as if in agony. The leaves are diamond shaped, with small berries underneath, flat and " +
            "tablet-like. You may keep some and creep further long the wall to the main entrance.");
        dialogBoxWell.text("You fall to the bottom of a deep pit. Possibly a filled-in well. You appear to be intact, but " +
            "how are you going to get out? To dig footholes would take far too long. You could cast a spell to assist or " +
            "call for help.");
        dialogBoxWell_Force.text("You feel the strength surging through your body. You draw out your sword and dig into the " +
            "earthy walls. By making a foothole, then stepping on to it as you dig the next, you make up your way up the shaft " +
            "quite quickly. Halfway up, however, your strength begins to ebb and you realize you are returning back to normal. " +
            "You may either recast Strength or fall back again and call out for help.");
        dialogBoxWell_Recast.text("As you recast the spell, your strength returns to enable you to finish off the steps. " +
            "As you reach the top, the effects wear off once more.");
        dialogBoxWell_CallHelp.text("After several minutes of shouting, you hear voices in a strange tongue corning tongue " +
            "coming closer. To your relief you see four heads peering into the pit. You yell at them to get some rope. They " +
            "chatter and disappear. Eventually you hear them coming back. They stand once more at the top of the pit and " +
            "throw down to you, not a rescue rope, but the contents of a cauldron of boiling oil !");
        dialogBoxWell_Levitation.text("You cast Levitation and get out of the pit easily.");
        dialogBox1.show(stage);
        hud.bringToFront();
    }

    public void input(){
        dialogBox1.button("Sneak" , new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox1.hide();

                //Les dialogues de cette branche
                dialogBox222.text("As you scoot your way to the door along the rampart, you see a man lying down. " +
                    "His voice low, but he is asking for help. He seems to be suffering. What to do ?");
                dialogBox222_Help.text("It is an old man. Seems a mass has hit him on the head. You don't have any healing" +
                    " potion\nor remedy but you could try an other way. Or move on.");
                dialogBox222_Help2.text("He seems to recover."); //383
                dialogBox222_Help3.text("Thank you. I taught I would die here ! Beware of the Ganjees ! They are really" +
                    " dangerous !");
                dialogBox222_Help4.text("Suddenly his eyes change and long piercing teeth bite down on your arm.");
                dialogBox222_Sword.text("You draw out your sword but quickly realise the old man is not controlling his actions." +
                    " With mercy, you hit his head with the pommel of you sword. He screams and release you.");
                dialogBox222_Illusion.text("You concentrate on your arm, he starts to harden and the color change to a " +
                    "silver-like tint. The old man seems surprised but no way to get away from him. You'll have to draw " +
                    "out your sword and fight.");
                dialogBox222_Protection.text("The spell has no effect. You have to draw out your sword and fight.");
                dialogBox222_Weakness.text("The spell works ! His grasp goes slack and he fall to the ground." +
                    "You take some time to recover and patch up your arm before continuing.");
                dialogBoxTumbling.text("You can't see well in the shadow of the rampart. Suddenly, a tumbling stone makes" +
                    " you lose your balance and you are dangerously staggering close to a well.");
                /*--------------------------------------------------------*/

                stage.addActor(dialogBox222);
                dialogBox222.show(stage);
                inputManOnTheFloor();
                hud.bringToFront();
                return true;
            }
        });

        dialogBox1.button("Cross the courtyard\ntowards the monument" , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox1.hide();

                //Les dialogues de cette branche
                dialogBox179.text("You step out of the shadow towards the center of the courtyard when you hear someone shout " +
                    "'Halt! Stop moving !'");
                dialogBox179_1.text("You try and fail to see who shout.");
                dialogBox179_2.text("Once again, you hear someone shouting but this time an arrow hiss through the air and " +
                    "sticks into the ground right next to your left feet.");
                dialogBox179_3.text("You still fail to see anything. Your enemy is invisible. You have to do something.");
                dialogBox378.text("You take a couple steps and an arrow stucks into the ground next to your foot.");
                dialogBox378_1.text("Another steps and an arrow rips your coat and catch your arm.");
                dialogBox378_2.text("Another steps and an arrow stucks right into your calf. You shout in pain.");
                dialogBoxGetLucky125.text("Fingers crossed, you rush at full speed towards the monument. Maybe they will " +
                    "not touch you if you run fast enough.");
                dialogBox341.text("You cast Protection on yourself and move forward. Four or five arrows hiss and crash " +
                    "on the shield and you manage to reach the monument unharmed.");

                /*------------------------------------------------------*/
                inputArrows();
                stage.addActor(dialogBox179);
                dialogBox179.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        dialogBox1.button("Approach the group\naround the fire camp" , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox1.hide();

                //Dialogues de cette branche
                dialogBox321.text("You sneak along the rampart, cautiously to avoid being seen. There is two groups of creatures. " +
                    "On the right two humans chatting below a torch fixed on the wall. On the left, four creatures of different " +
                    "species are eating around a wood fire camp. Which one would you like to talk to ?");
                dialogBoxDuo.text("You come near two individuals that seem to be arguing about the price of a dagger.");
                dialogBoxDuo_1.text("You can't be serious, it's worth way more. It is magical !");
                dialogBoxDuo_2.text("Craps ! I am not paying more for that !");
                dialogBoxDuo_3.text("The tall man grabs your arm, calling you as a witness.");
                dialogBoxDuo_4.text("You ! Tell us how much that dagger costs !");
                dialogBoxAlive.text("Well, that old thief is dead now at least. Wanna toss a coin to see who keeps the " +
                    "dagger ?");
                dialogBoxDead.text("Both of the men are dead. You loot them the dagger and 28 gold pieces");
                dialogBoxDagger.text("The dagger is a proper work of art. The blade is shining and the handle is in green leather. " +
                    "You put it in your belt and continue your way towards the tower.");
                dialogBoxChatting.text("The man is a merchant, you talk with him about prices and trade. He informs you " +
                    "he has never been on the stories of the Black Tower ever because they despise merchants.");
                dialogBox186.text("The tall man agrees, the small one tries to bargain 6 then 7 golds." +
                    "You can offer him 8 golds for it yourself before the small man takes it for himself. In that case, " +
                    "you can have a chat with the tall man or just continue on your way.");
                dialogBox161.text("She's upset by your indifference. She makes you fall and even you try to crawl, she's" +
                    " always standing in front of you.");
                dialogBoxWind.text("As you walk, the night's air is fresh. But a little wind rise up and quickly becomes a gust " +
                    "so violent you can't manage to walk forward. You close your eyes waiting for the wind to cease and when " +
                    "you open them back, a women draped in wind is standing in front of you. When she talks, you hear her words " +
                    "a few moments after.");
                dialogBoxWind_1.text("Are you not a bit aggressive ?");
                dialogBoxWind_2.text("The women defies you, throwing insults at you. She laughs at you when you draw out " +
                    "your sword.");
                dialogBoxGaz.text("You concentrate and a green fuming gas jets out of your finger towards the creature. She " +
                    "realizes that a own spinning will suck the gas inside her whirlwind and backs off. When she's far enough" +
                    " you dash to the Black Tower.");
                dialogBoxDouble.text("She watches in astonishment as an exact duplicate of herself appears between the two" +
                    " of you. She backs off a bit when you instruct your creation to attack. But as they get close to one" +
                    " another, they seem unable to get close to one another. At least, she backed off enough that it allows " +
                    "you to continue your way towards the tower.");
                dialogBoxFly.text("Dismayed, she watches you as you float into the air above her. She spins frantically, " +
                    "trying to suck you down, but you are out of reach. You taunt her with a smile and a wave and float over " +
                    "towards the Black Tower.");
                dialogBoxFireCamp.text("A few creatures sit there around a fire camp. An Orc with green skin hands out " +
                    "paltry portions of meat to everyone. A grumpy Dwarf says he has been left out while a couple of " +
                    "Gobelins hold each other lovingly");
                dialogBoxFireCamp_1.text("When you approach, they look at you with hostility. As clean as you are, you " +
                    "stand out. The female Goblin murmurs something to her companion and they laugh.");
                dialogBoxFireCamp_2.text("In front of the dwarf, there is an open small coffer. Inside of it, there is a " +
                    "flask of an unknown liquid. What will you do, sit with them or maybe ask for permission ?");
                dialogBoxSitDown.text("They are disconcerted by your boldness. Maybe do not wait for them to react."); //todo 134
                dialogBoxSitDown_1.text("By ... the door ? But you'll need the password. Scimitar.");
                dialogBoxSitDown_2.text("They begin to be agitaded with that question.");
                dialogBoxSitDown_3.text("The more you ask, the more they start to be wary. The dwarf is jumping with his " +
                    "club as the Gobelin and the Orc are grabbing their swords. The female gobelin takes a few steps back " +
                    "as the three of them are coming upon you.");
                dialogBoxNotInterested.text("Your company does not interest them. They ask you to go away.\n" +
                    "You can continue towards the tower or maybe inspect the monument on the center of the courtyard." +
                    "You can still sit down among them anyway.");
                dialogBoxNotInterested_1.text("They get really angry. The dwarf grab his club, the gobelin and the orc " +
                    "their sword.");
                dialogBoxLevitFireCamp.text("The Orc and the Gobelin grabs your leg as you elevate yourself in the air." +
                    " The Dwarf hits the ground with his club as he approaches you.");
                dialogBoxScorpion.text("You transform yourself into a giant scorpio. But as it is only an illusion, your " +
                    "hits do not affect the orc and the other two resume their approach");
                dialogBoxEndChoice.text("After you grabbing your loot, you can continue your way towards the tower or go" +
                    " see the two men arguing under the torch.");
                dialogBoxFightOintment.text("You take the ointment, it is an alchemist balm. You are granted two use of " +
                    "youre magical powers for free !");
                dialogBoxFightGolds.text("You put the golds on your pocket.");
                dialogBoxFightKey.text("You grab the copper key. What could it open ?");
                /*-----------------------------------------------------*/
                inputCampFire();
                stage.addActor(dialogBox321);
                dialogBox321.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        DialogBoxMethods.continueDialogBox(dialogBox209,"Open the door", stage, new TempleOfTheCourtyardGameScreen(game), game);
        DialogBoxMethods.continueDialogBox(dialogBox209,"Continue my way to the tower", stage, new TentacleGameScreen(game), game);
    }

    //222
    public void inputManOnTheFloor(){
        DialogBoxMethods.continueDialogBox(dialogBox222,dialogBox222_Help,"Help the person",stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBox222,dialogBoxTumbling,"Ignore the person",stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBox222_Help,dialogBoxTumbling,"I can't help",stage,hud);

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.ENDURANCE)){
            DialogBoxMethods.alertSpellDialog(dialogBox222_Help,dialogBox222_Help2, SpellList.Sorts.ENDURANCE,hud,stage,game);
        }
        DialogBoxMethods.continueDialogBox(dialogBox222_Help2,dialogBox222_Help3,hud,stage,null);

        dialogBox222_Help3.button("Ask about the Citadel" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox222_Help3.hide();
                alertPlayerPV(2,stage,game, ()->{
                    stage.addActor(dialogBox222_Help4);
                    dialogBox222_Help4.show(stage);
                    hud.bringToFront();
                });
                return true;
            }
        });

        dialogBox222_Help4.button("Draw out your sword" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox222_Help4.hide();
                alertPlayerPV(2,stage,game, ()->{
                    stage.addActor(dialogBox222_Sword);
                    dialogBox222_Sword.show(stage);
                    hud.bringToFront();
                });
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
                            alertPlayerPV(2,stage,game, ()->{
                                alert.hide();
                                dialogBox222_Help4.hide();
                                stage.addActor(dialogBox222_Illusion);
                                dialogBox222_Illusion.show(stage);
                            });
                            return true;
                        }
                    });
                    alertNoButton(alert,stage,hud);
                    alert.show(stage);
                    hud.bringToFront();
                    return true;
                }
            });
        }
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.PROTECTION)){
            alertSpellDialog(dialogBox222_Help4,dialogBox222_Protection, SpellList.Sorts.PROTECTION,hud,stage,game);
        }
        // ne pas changer, usage particulier
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FAIBLESSE)){
            dialogBox222_Help4.button("Cast Weakness" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    DialogAlert alert = new DialogAlert("Do you want to cast Weakness ?");
                    alert.text("    An usage of Weakness will be remove from your spellbook.");
                    alert.button("Yes" , Color.BLACK , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            game.getPlayer().getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                            game.getPlayer().setCurrentVitality(game.getPlayer().getCurrentVitality() - 1);
                            alertPlayerPV(1,stage,game, ()->{
                                dialogBox222_Help4.hide();
                                stage.addActor(dialogBox222_Weakness);
                                dialogBox222_Weakness.show(stage);
                                hud.bringToFront();
                            });
                            return true;
                        }
                    });
                    alertNoButton(alert,stage,hud);
                    alert.show(stage);
                    hud.bringToFront();
                    return true;
                }
            });
        }
        // ne pas changer, usage particulier
        dialogBoxTumbling.button("Get lucky" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxTumbling.hide();
                if (game.getPlayer().getCurrentLuck() >= Dice.doubleDice()){ //79
                    getLucky.text("You manage to steady your balance. You are now safe and can continue your journey.\n" +
                        "(You lost a point of luck.)");
                    DialogBoxMethods.continueDialogBox(getLucky,dialogBoxTree,hud,stage,null);
                }else{ //100
                    getLucky.text("You slip and fall on the well.");
                    DialogBoxMethods.continueDialogBox(getLucky,dialogBoxWell,hud,stage,null);
                }
                game.getPlayer().decreaseLuck();
                stage.addActor(getLucky);
                getLucky.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.LEVITATION)){
            alertSpellDialog(dialogBoxWell,dialogBoxWell_Levitation, SpellList.Sorts.LEVITATION,hud,stage,game);
            alertSpellDialog(dialogBoxWell_Force,dialogBoxWell_Levitation, SpellList.Sorts.LEVITATION,hud,stage,game);
            DialogBoxMethods.continueDialogBox(dialogBoxWell_Levitation,dialogBoxTree,hud,stage,null);
        }

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FORCE)){
            alertSpellDialog(dialogBoxWell,dialogBoxWell_Force, SpellList.Sorts.FORCE,hud,stage,game);
            alertSpellDialog(dialogBoxWell_Force,dialogBoxWell_Recast, SpellList.Sorts.FORCE,hud,stage,game);
            continueDialogBox(dialogBoxWell_Force,dialogBoxWell_CallHelp, "Call out for help" , stage,hud);
            DialogBoxMethods.continueDialogBox(dialogBoxWell_Recast,dialogBoxTree,hud,stage,null);
        }

        DialogBoxMethods.continueDialogBox(dialogBoxWell,dialogBoxWell_CallHelp, "Call out for help" , stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBoxWell_CallHelp,stage, new GameOverScreen(game),game, null);

        DialogBoxMethods.continueDialogBox(dialogBox222_Illusion,dialogBox222_Sword,hud,stage,null);
        DialogBoxMethods.continueDialogBox(dialogBox222_Weakness,dialogBoxTumbling,hud,stage,null);

        continueDialogBox(dialogBoxTree,new RhinoDoorGameScreen(game),hud,stage,game, Item.Items.BERRIES,true);
    }

    //321
    public void inputCampFire(){
        DialogBoxMethods.continueDialogBox(dialogBox321,dialogBoxFireCamp,"Talk to the group on the left",stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBox321,dialogBoxDuo,"Talk to the men on the right",stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBoxDuo,dialogBoxDuo_1,"Listen to them",stage,hud);

        DialogBoxMethods.continueDialogBox(dialogBoxDuo_1, dialogBoxDuo_2,hud,stage,null);
        DialogBoxMethods.continueDialogBox(dialogBoxDuo_2, dialogBoxDuo_3,hud,stage,null);
        DialogBoxMethods.continueDialogBox(dialogBoxDuo_3, dialogBoxDuo_4,hud,stage,null);

        dialogBoxDuo_4.button("5 golden coins" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxDuo_4.hide();
                DialogBox dialogBox = new DialogBox("Tall man");
                dialogBox.text("What !? It is way too low !");
                dialogBox.button("Draw out your sword" , new InputListener() {
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        dialogBox.hide();
                        combat205();
                        hud.bringToFront();
                        return true;
                    }
                });
                dialogBox.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        DialogBoxMethods.continueDialogBox(dialogBoxDuo_4,dialogBox186, "8 golden coins",  stage,hud);
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.OR_DU_SOT)){
            DialogBoxMethods.alertSpellDialog(dialogBox186,dialogBoxDagger, SpellList.Sorts.OR_DU_SOT, hud,stage,game);
        }

        dialogBoxDuo_4.button("10 golden coins" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxDuo_4.hide();
                DialogBox dialogBox = new DialogBox("Small man");
                DialogBox dialogBox2 = new DialogBox("Tall man");
                dialogBox.text("TEN ? That's way too much. I pass.");
                dialogBox2.text("Well. That's unfortunate. I can make it 9 pieces for you.");
                DialogBoxMethods.continueDialogBox(dialogBox, dialogBox2,hud,stage,null);
                if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.OR_DU_SOT)) {
                    DialogBoxMethods.alertSpellDialog(dialogBox2,dialogBoxDagger, SpellList.Sorts.OR_DU_SOT,hud,stage,game);
                }
                DialogBoxMethods.continueDialogBox(dialogBox2,dialogBoxDuo_4,"Continue your way",stage,hud);

                dialogBox.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        DialogBoxMethods.continueDialogBox(dialogBox186,dialogBoxChatting,"Have a chat with the tall man",stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBoxChatting,dialogBoxWind,hud,stage,null);
        DialogBoxMethods.continueDialogBox(dialogBox186,dialogBoxWind,"Continue your way\nto the tower",stage,hud);

        DialogBoxMethods.continueDialogBox(dialogBoxWind,dialogBoxWind_1,hud,stage,null);
        DialogBoxMethods.continueDialogBox(dialogBoxWind_1,dialogBoxWind_2,hud,stage,null);
        DialogBoxMethods.continueDialogBox(dialogBoxWind_2,dialogBox161,"Ignore her" ,stage,hud);

        dialogBoxWind_2.button("Talk to her" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogLucky();
                return true;
            }
        });
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.COPIE_CONFORME)){
            DialogBoxMethods.alertSpellDialog(dialogBoxWind_2,dialogBoxDouble, SpellList.Sorts.COPIE_CONFORME,hud,stage,game);
            DialogBoxMethods.continueDialogBox(dialogBoxDouble,stage,new RhinoDoorGameScreen(game) , game, null);
        }
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.ILLUSION)){
            DialogBoxMethods.alertSpellDialog(dialogBoxWind_2,dialogBoxGaz, SpellList.Sorts.ILLUSION,hud,stage,game);
            DialogBoxMethods.continueDialogBox(dialogBoxGaz,stage,new RhinoDoorGameScreen(game) , game,null);
        }
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.LEVITATION)){
            DialogBoxMethods.alertSpellDialog(dialogBoxWind_2,dialogBoxFly, SpellList.Sorts.LEVITATION,hud,stage,game);
            DialogBoxMethods.continueDialogBox(dialogBoxFly,stage,new RhinoDoorGameScreen(game) , game,null );
        }

        dialogBox161.button("Show her your anger" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                DialogBox dialogBox = new DialogBox("Wind women");
                dialogBox161.hide();
                dialogBox.text("Oh I like that way more ! Let's walk together !");
                DialogBoxMethods.continueDialogBox(dialogBox, dialogBox161_1,hud,stage,null);
                hud.bringToFront();
                return true;
            }
        });
        dialogBox161.button("Try to coax her" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox161.hide();
                dialogLucky();
                return true;
            }
        });

        DialogBoxMethods.continueDialogBox(dialogBox161_1,stage,new RhinoDoorGameScreen(game) , game, null);

        dialogBoxAlive.button("Flip a coin" , new InputListener() {
            DialogAlert alert = new DialogAlert("Result");
            boolean win ;
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (Dice.pileFaceDice() == "face"){
                    alert.text("You flipped a coin and it's heads. You win");
                    win = true;
                    game.getPlayer().getInventory().putIn(Item.Items.ENCHANTED_THROWING_DAGGER);
                } else {
                    alert.text("You flipped a coin and it's tails. You lose");
                    win = false;
                }

                alert.button("Ok" , Color.BLACK , new InputListener() {
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        alert.hide();
                        if (win) dialogBoxDagger.show(stage);
                        else dialogBoxWind.show(stage);
                        return true;
                    }
                });

                alert.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        DialogBoxMethods.continueDialogBox(dialogBoxAlive,dialogBoxWind,"No, leave the dagger to the man",stage,hud);

        DialogBoxMethods.continueDialogBox(dialogBoxDagger,dialogBoxWind,hud,stage, game, Item.Items.ENCHANTED_THROWING_DAGGER,true);
        DialogBoxMethods.continueDialogBox(dialogBoxFireCamp,dialogBoxFireCamp_1,"Approach",stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBoxFireCamp_1,dialogBoxFireCamp_2,"Look at them", stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBoxFireCamp_2,dialogBoxSitDown,"Sit down",stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBoxFireCamp_2,dialogBoxNotInterested,
            "Ask for permission to sit down", stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBoxNotInterested,dialogBoxWind,"Go towards the tower", stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBoxNotInterested,dialogBox209,"Inspect the monument",stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBoxNotInterested,dialogBoxNotInterested_1,"Sit anyway",stage,hud);

        dialogBoxNotInterested_1.button("Defend yourself" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxNotInterested_1.hide();
                combat213();
                hud.bringToFront();
                return true;
            }
        });

        dialogBoxSitDown.button("Do not wait their reactions. Ask how to enter the Black Tower." , new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxSitDown.hide();
                game.setPassword(true);
                dialogBoxSitDown_1.show(stage);
                hud.bringToFront();
                return true;
            }
        });

        DialogBoxMethods.continueDialogBox(dialogBoxSitDown_1,dialogBoxSitDown_2,"Ask what is in the flask"
            ,stage,hud);

        DialogBoxMethods.continueDialogBox(dialogBoxSitDown_2,dialogBoxSitDown_3,"Insist",stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBoxSitDown_2,dialogBoxDuo,"Give up and\ngo see the men",stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBoxSitDown_2,dialogBoxWind,"Hasten to the tower",stage,hud);

        dialogBoxSitDown_3.button("Draw out my sword" , new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxSitDown_3.hide();
                combat213();
                return true;
            }
        });
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.LEVITATION)){
            DialogBoxMethods.alertSpellDialog(dialogBoxSitDown_3,dialogBoxLevitFireCamp, SpellList.Sorts.LEVITATION,hud
                ,stage,game);
            dialogBoxLevitFireCamp.button("Draw out my sword", new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    dialogBoxLevitFireCamp.hide();
                    combat213();
                    return true;
                }
            });
        }
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.ILLUSION)){
            DialogBoxMethods.alertSpellDialog(dialogBoxSitDown_3,dialogBoxScorpion, SpellList.Sorts.ILLUSION,hud,stage
                ,game);
            dialogBoxScorpion.button("Draw out my sword", new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    dialogBoxScorpion.hide();
                    combat213();
                    return true;
                }
            });
        }

        DialogBoxMethods.continueDialogBox(dialogBoxFireCampFight,dialogBoxFightGolds,hud, stage, game, 8 , true ); //8 golds
        DialogBoxMethods.continueDialogBox(dialogBoxFireCampFight,dialogBoxFightOintment,hud,stage,game,Item.Items.ALCHEMIST_HEALING_BALM,true); //ointment
        DialogBoxMethods.continueDialogBox(dialogBoxFireCampFight,dialogBoxFightKey,hud,stage,game, Item.Items.KEY_COPPER, true); //key

        DialogBoxMethods.continueDialogBox(dialogBoxFightGolds, dialogBoxEndChoice, hud, stage, game, Item.Items.ALCHEMIST_HEALING_BALM, true ); //gold + ointment
        DialogBoxMethods.continueDialogBox(dialogBoxFightGolds, dialogBoxEndChoice, hud, stage, game, Item.Items.KEY_COPPER, true ); // gold + key

        DialogBoxMethods.continueDialogBox(dialogBoxFightOintment, dialogBoxEndChoice, hud, stage, game, Item.Items.KEY_COPPER, true ); //ointment + key
        DialogBoxMethods.continueDialogBox(dialogBoxFightOintment, dialogBoxEndChoice, hud, stage, game, 8, true ); //ointment + golds

        DialogBoxMethods.continueDialogBox(dialogBoxFightKey, dialogBoxEndChoice, hud, stage, game, Item.Items.ALCHEMIST_HEALING_BALM, true ); //key + ointment
        DialogBoxMethods.continueDialogBox(dialogBoxFightKey, dialogBoxEndChoice, hud, stage, game, 8, true ); //key + golds

        DialogBoxMethods.continueDialogBox(dialogBoxEndChoice, dialogBoxDuo, "Go see the two man" , stage, hud );
        DialogBoxMethods.continueDialogBox(dialogBoxEndChoice, dialogBoxWind, "Go to the tower", stage, hud );

    }

    private void dialogLucky(){
        DialogBox dialogBox = new DialogBox("Narrator");
        dialogBox.text("She's playing with you. Every time you get up, she makes you fall.");
        dialogBox.button("Make her believe you see someone far away on the courtyard that looks like her" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBox.hide();
                if (game.getPlayer().getCurrentLuck() <= Dice.doubleDice()){ //350
                    dialogBoxLucky390.text("She says you must be mistaking. But you're insisting and you ended up convincing her and she" +
                        " decides to go see that by herself");
                    DialogBoxMethods.continueDialogBox(dialogBoxLucky390,"Take this opportunity to go the tower's door"
                        , stage, new RhinoDoorGameScreen(game),game);
                } else {
                    dialogBoxLucky390.text("The trick does not work. She laughs it of. You have no choice but to use" +
                        " a spell. Or back away and hide behind the monument.");
                    if(game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.COPIE_CONFORME)){
                        DialogBoxMethods.alertSpellDialog(dialogBoxLucky390,dialogBoxDouble,
                            SpellList.Sorts.COPIE_CONFORME,hud,stage,game);
                    }
                    if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.ILLUSION)){
                        DialogBoxMethods.alertSpellDialog(dialogBoxLucky390,dialogBoxGaz, SpellList.Sorts.ILLUSION,hud,stage,game);
                    }
                    if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.LEVITATION)){
                        DialogBoxMethods.alertSpellDialog(dialogBoxLucky390,dialogBoxFly, SpellList.Sorts.LEVITATION,hud,stage,game);
                    }
                    DialogBoxMethods.continueDialogBox(dialogBoxLucky390,dialogBox209,"Go hide\nbehind the monument", stage,hud);
                }
                game.getPlayer().decreaseLuck();
                dialogBoxLucky390.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        dialogBox.show(stage);
        hud.bringToFront();
    }

    //179
    public void inputArrows(){
        DialogBoxMethods.continueDialogBox(dialogBox179,dialogBox179_1,"Turn around looking for the person",stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBox179_1,dialogBox179_2,"Take another couple of steps", stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBox179_2,dialogBox179_3,"Jump back and look for the shooter", stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBox179_3,dialogBox378,"Continue to move on despite the enemy", stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBox179_3,dialogBoxGetLucky125,"Rush towards the monument", stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBox378,dialogBox378_1,"Take a couple of steps",  stage,hud);
        DialogBoxMethods.continueDialogBox(dialogBox378_1, dialogBox378_2,"Another couple of steps", stage,hud);

        dialogBox378_2.button("Jump behind the monument to take cover" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                DialogAlert alert = new DialogAlert("You have lost 4 HP !");
                alert.button("Ok" , Color.BLACK ,new InputListener() {
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        alert.hide();
                        dialogBox378_2.hide();
                        System.out.println("Touch dialogBox378_2");
                        game.getPlayer().setCurrentVitality(game.getPlayer().getCurrentVitality() - 4);
                        if (game.getPlayer().isDead()) {
                            stage.clear();
                            game.setScreen(new GameOverScreen(game));
                        }
                        stage.addActor(dialogBox209);
                        dialogBox209.show(stage);
                        hud.bringToFront();
                        return true;
                    }
                });
                alert.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.PROTECTION)){
            DialogBoxMethods.alertSpellDialog(dialogBox179_3,dialogBox341, SpellList.Sorts.PROTECTION,hud,stage,game);
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
                game.getPlayer().decreaseLuck();
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
        DialogBoxMethods.continueDialogBox(dialogBox341,dialogBox209,"Hide behind the monument" , stage, hud);
    }

    //combat tall man
    private void combat205(){
        Monster tallMan = new Monster("Tall man", 8,8);
        Monster ally = new Monster("Small man", 7,6);

        hud.showEnenmyHealthBars(tallMan , ally);
        showDialogBox205(tallMan,ally);
    }

    private void showDialogBox205(Monster monster, Monster ally){
        //Check la victoire
        if (monster.isDead()){
            DialogBox victory = new DialogBox("Narrator");
            victory.text("You have defeated the Tall Man!");
            victory.button("Continue" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    victory.hide();
                    if (!ally.isDead()){
                        dialogBoxAlive.show(stage);
                    } else {
                        dialogBoxDead.show(stage);
                    }
                    hud.bringToFront();
                    return true;
                }
            });
            stage.addActor(victory);
            victory.show(stage);
            hud.bringToFront();
            return;
        }

        //check si le joueur est mort
        if (game.getPlayer().isDead()){
            stage.clear();
            game.setScreen(new GameOverScreen(game));
            return;
        }

        //déroulement du combat
        DialogBox fightBox = new DialogBox("Choose an action");
        DialogBox fightBox2 = new DialogBox("Narrator");
        boolean attackSmallMan = false;

        if (!ally.isDead()){
            attackSmallMan = Dice.pileFaceDice() == "face";
        }

        if (attackSmallMan) {
            int scoreAlly = Dice.doubleDice() + ally.getAbility();
            int scoreMonster = Dice.doubleDice() + monster.getAbility();

            DialogAlert alert = new DialogAlert("   Info !");
            alert.text("    The men fight each other !");
            alert.button("Ok" , Color.BLACK , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    alert.hide();
                    fightBox2.text(Combat.resolutionTour(scoreAlly,scoreMonster,ally,monster,game));
                    fightBox2.button("Continue" , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            fightBox2.hide();
                            hud.showEnenmyHealthBars(monster , ally);
                            showDialogBox205(monster,ally);
                            return true;
                        }
                    });
                    fightBox2.show(stage);
                    return true;
                }
            });
            alert.show(stage);
        } else {
            DialogAlert alert = new DialogAlert("   Info !");
            alert.text("    The tall man attacks you !");
            alert.button("Ok",Color.BLACK, new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                    alert.hide();
                    fightBox.button("Attack" , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            int scorePlayer = Dice.doubleDice()+game.getPlayer().getCurrentAbility();
                            int scoreMonster = Dice.doubleDice()+monster.getAbility();

                            DialogAlert alert = new DialogAlert("   Info !");
                            alert.text(Combat.resolutionTour(scorePlayer,scoreMonster,monster,game));
                            alert.button("Ok" , Color.BLACK , new InputListener() {
                                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                                    fightBox.hide();
                                    alert.hide();
                                    int playerTouched = Combat.isPlayerTouched(scorePlayer,scoreMonster);
                                    if (playerTouched != 0){
                                        Combat.displayAlertTouch(playerTouched,monster,stage,game,hud, ()->{
                                            hud.showEnenmyHealthBars(monster , ally);
                                            showDialogBox205(monster,ally);
                                        });
                                        playerTouched = 0;
                                    } else {
                                        //si pas touché, pas besoin de mettre à jour
                                        showDialogBox205(monster,ally);
                                    }
                                    return true;
                                }
                            });
                            alert.show(stage);
                            return true;
                        }
                    });
                    fightBox.show(stage);
                    return true;
                }
            });
            alert.show(stage);
        }
    }

    //combat feu de camp
    private void combat213(){
        Monster dwarf = new Monster("Dwarf", 5,6);
        Monster orc = new Monster("Orc", 5,7);
        Monster goblin = new Monster("Goblin", 6,4);

        hud.showEnenmyHealthBars(dwarf , orc , goblin);
        showCombat213(dwarf,orc,goblin);
    }

    private void showCombat213(Monster dwarf, Monster orc, Monster goblin){
        //Conditions de victoire
        if (dwarf.isDead() && orc.isDead() && goblin.isDead()){
            hud.hideEnenmyBars();
            DialogBox victory = new DialogBox("Narrator");
            victory.text("You have defeated the Dwarfs, Orcs and Goblins!");
            dialogBoxFireCampFight.text("You feared for a moment that the sounds of the fights could have alert anyone else" +
                " but as nothing came, you decide to loot your enemies and found 8 gold pieces, a copper key and a jar of " +
                "a dark, creamy ointment. You can take any two of these.");
            DialogBoxMethods.continueDialogBox(victory, dialogBoxFireCampFight, hud, stage,null);
            victory.show(stage);
            return;
        }

        //Joueur
        if (game.getPlayer().isDead()){
            stage.clear();
            game.setScreen(new GameOverScreen(game));
            return;
        }

        //Combat
        DialogBox fightBox = new DialogBox("Choose an action");

        if (!dwarf.isDead()){
            fightBox.button("Attack " + dwarf.getName(), new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    fightBox.hide();
                    int scoreDwarf = Dice.doubleDice() + dwarf.getAbility();
                    int scorePlayer = Dice.doubleDice() + game.getPlayer().getCurrentAbility();

                    Combat.displayAlertResolutionTour(Combat.resolutionTour(scorePlayer,scoreDwarf,dwarf,game), stage, ()->{
                        Combat.displayAlertTouch(Combat.isPlayerTouched(scoreDwarf,scorePlayer), dwarf, stage, game, hud, ()->{
                            hud.showEnenmyHealthBars(dwarf , orc , goblin);
                            showCombat213(dwarf,orc,goblin);
                        });
                    });
                    return true;
                }
            });
        }

        if (!orc.isDead()){
            fightBox.button("Attack " + orc.getName(), new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    fightBox.hide();
                    int scoreOrc = Dice.doubleDice() + orc.getAbility();
                    int scorePlayer = Dice.doubleDice() + game.getPlayer().getCurrentAbility();
                    Combat.displayAlertResolutionTour(Combat.resolutionTour(scorePlayer,scoreOrc,orc,game), stage, ()->{
                        Combat.displayAlertTouch(Combat.isPlayerTouched(scoreOrc,scorePlayer), orc, stage, game, hud, ()->{
                            hud.showEnenmyHealthBars(dwarf , orc , goblin);
                            showCombat213(dwarf,orc,goblin);
                        });
                    });
                    return true;
                }
            });
        }

        if (!goblin.isDead()){
            fightBox.button("Attack " + goblin.getName(), new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    fightBox.hide();
                    int scoreGoblin = Dice.doubleDice() + goblin.getAbility();
                    int scorePlayer = Dice.doubleDice() + game.getPlayer().getCurrentAbility();
                    Combat.displayAlertResolutionTour(Combat.resolutionTour(scorePlayer,scoreGoblin,goblin,game), stage, ()->{
                        Combat.displayAlertTouch(Combat.isPlayerTouched(scoreGoblin,scorePlayer), goblin, stage, game, hud, ()->{
                            hud.showEnenmyHealthBars(dwarf , orc , goblin);
                            showCombat213(dwarf,orc,goblin);
                        });
                    });
                    return true;
                }
            });
        }

        fightBox.button("Flee to the monument", new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
                fightBox.hide();
                hud.hideEnenmyBars();
                DialogBox dialogBox = new DialogBox("Narrator");
                dialogBox.text("You flee to the monument.");
                DialogBoxMethods.continueDialogBox(dialogBox,dialogBox209,hud,stage,null);
                dialogBox.show(stage);
                return true;
            }
        });

        fightBox.show(stage);
        hud.bringToFront();
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
        font.draw(game.batch, "In the courtyard" , Gdx.graphics.getWidth()*0.5f, Gdx.graphics.getHeight()*0.3f);
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

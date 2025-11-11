package com.badlogic.citadel.Screens.OnGameScreens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogBox;
import com.badlogic.citadel.Item;
import com.badlogic.citadel.Methods.RocBombe;
import com.badlogic.citadel.PlayerRelatedMethods.SpellList;
import com.badlogic.citadel.Screens.HUD;
import com.badlogic.citadel.Screens.Skins;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.citadel.DialogWindows.DialogBoxMethods.*;
import static com.badlogic.citadel.Dice.doubleDice;
import static com.badlogic.citadel.Dice.soloDice;

//52
public class GameRoomScreenGame extends ApplicationAdapter implements Screen {
    private final Citadel game;
    private final Stage stage;
    private final HUD hud;

    private final DialogBox dialogBox052 = new DialogBox("Narrator");
    private final DialogBox dialogBox052_1 = new DialogBox("Narrator");
    private final DialogBox dialogBox227 = new DialogBox("Narrator");
    private final DialogBox dialogBoxPrizes = new DialogBox("Prizes");
    private final DialogBox dialogGameChose = new DialogBox("Choose a game to play :");
    private final DialogBox dialogExit = new DialogBox("Exit");

    //prize
    private boolean prize;
    private boolean leave;

    //Dague-Dingue
    private final DialogBox dialogBoxDagueDingue = new DialogBox("Choose a dagger");
    private final DialogBox dialogRulesDagueDingue = new DialogBox("Rules");
    private final DialogBox dialogBoxRulesPiqueSix = new DialogBox("Rules");
    private final DialogBox dialogBoxRulesRocBombe = new DialogBox("Rules");
    private final DialogBox dialogIllusion = new DialogBox("Narrator");
    private final DialogBox victoryMiniGame = new DialogBox("Victory Mini Game");
    private final DialogBox defeatMiniGame = new DialogBox("Defeat Mini Game");

    //Visuels pique 6
    private Table tablePiqueSix;
    private final int[] tableMises = {0, 0, 0, 0, 0, 0};
    private Label[] tableLabel;
    private Label goldTotal;
    private TextButton buttonLancerDice;

    //visuels choix des sorts
    private Table tableSorts;
    private TextButton[] textButtonsSorts;
    private final Label[] nomSorts = new Label[SpellList.Sorts.values().length];
    private TextButton valider;

    public GameRoomScreenGame(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        hud = new HUD(game, stage);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        create();
        input();

        //possible de choisir un prix
        prize = true;
        leave = false;

        dialogBox052.show(stage);

    }

    public void create() {
        dialogBox052.text("The door opens and you stride onwards, slamming it shut behind you. A short distance ahead, you reach a " +
            "three way junction where you take the northwards passage. This continue for several metres leading to another door. " +
            "You can hear laughter and merriment on the other side. Cautiously you open the door into a large room where a party of a " +
            "dozen or so creatures, of all shapes, sizes and colours, are playing games.");
        dialogGameChose.text("Welcome to the Game Room ! Choose a game");
        dialogBox052_1.text("As you step into the room, a voice shouts in your direction. Evidently they are expecting someone " +
            "and have mistaken you for their missing guest.");
        dialogBoxPrizes.text("You have won a prize ! Choose one but choose wisely, you'll only getting one !");
        victoryMiniGame.text("You won the mini game !");

        buttonLancerDice = new TextButton("Roll the dice", Skins.DEFAULT_SKIN);
    }

    public void input() {
        continueDialogBox(dialogGameChose,dialogRulesDagueDingue,"Dague dingue",stage,hud);
        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.ILLUSION)){
            alertSpellDialog(dialogRulesDagueDingue,dialogIllusion, SpellList.Sorts.ILLUSION,hud,stage,game);
        }
        continueDialogBox(dialogRulesDagueDingue, "Play", hud, ()->{
            leave = true;
            dagueDingue();
        }); //todo temporaire nom

        continueDialogBox(dialogGameChose,dialogBoxRulesRocBombe,"Roc bombe",stage,hud);
        continueDialogBox(dialogBoxRulesRocBombe, "Play", hud, ()->{
            leave = true;
            initRocBombe();
        }); //todo temporaire nom

        continueDialogBox(dialogGameChose,dialogBoxRulesPiqueSix,"Pique six",stage,hud);
        continueDialogBox(dialogBoxRulesPiqueSix, "Play", hud, ()->{
            leave = true;
            piqueSix();
        }); //todo temporaire nom

        continueDialogBox(victoryMiniGame, dialogGameChose, "Play another game", stage,hud);

        continueDialogBox(dialogBoxPrizes,"Two spells",hud,()->{
            alertYesNo("Do you want to add two more spells?" ,
                "You will be able to choose two spells from the initial list",
                stage,
                ()->{
                    dialogBoxPrizes.hide();
                    visualSpellChoosing();
                },null);
        });
        continueDialogBox(dialogBoxPrizes,"50 golds",hud,()->{
            alertYesNo("Do you want 50 gold pieces ?" , "", stage,
                ()->{
                game.getPlayer().modifyGold(50);
                dialogBoxPrizes.hide();
                dialogGameChose.show(stage);
                }
                , null);
        });
        continueDialogBox(dialogBoxPrizes, "Enchanted armor", hud, () -> {
            alertYesNo("Do you want to get the enchanted armor ? ", "This enchanted armor remove two points of attack to your adversary.", stage ,
                ()->{
                    game.getPlayer().getInventory().putIn(Item.Items.ENCHANTED_ARMOR);
                    dialogBoxPrizes.hide();
                    dialogGameChose.show(stage);
                } , null);
        });
        if (leave) {
            continueDialogBox(dialogGameChose, dialogExit, "Leave the room", stage, hud);
        }
        continueDialogBox(dialogExit, "Leave", stage,new DinnerRoomScreenGame(game),game);

        continueDialogBox(dialogBox052,dialogBox052_1,hud,stage,null);
        continueDialogBox(dialogBox052_1,dialogBox227,"Reach the door",stage,hud);
        continueDialogBox(dialogBox227,stage,new PrisonGameScreen(game),game,null);
        continueDialogBox(dialogBox052_1,dialogGameChose,"Play a game",stage,hud,()->{
            game.getPlayer().modifyCurrentVitality(2);
        });

        buttonLancerDice.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //faire la résolution du tour avec les mises
                int resultatTour = soloDice();
                int pertes = 0;
                int gain = 0;
                for (int i = 1; i <= 6; i++) {
                    if (i == resultatTour) {
                        game.getPlayer().modifyGold(tableMises[i - 1] * 5);
                        gain = tableMises[i - 1] * 5;
                    } else {
                        game.getPlayer().modifyGold(-tableMises[i - 1]);
                        pertes += tableMises[i - 1];
                    }
                }
                alertYesNo("Result of this round", "You rolled a " + resultatTour
                        + ". You won " + gain + " and lose " + pertes + ". Do you want to retry", stage,
                    () -> {
                        if (game.getPlayer().getGold() == 0) {
                            alertNotification("You have no gold anymore", "You cannot play this game anymore", stage,
                                () -> {
                                    tablePiqueSix.clear();
                                    buttonLancerDice.remove();
                                    dialogGameChose.show(stage);
                                });
                        }

                        for (int i = 0; i < 6; i++) {
                            tableMises[i] = 0;
                        }
                        piqueSix();
                    },
                    () -> {
                        goldTotal.remove();
                        tablePiqueSix.clear();
                        buttonLancerDice.remove();
                        dialogGameChose.show(stage);
                    });
                return true;
            }
        });
    }

    //Dague-Dingue
    private void dagueDingue() {
        int numeroDague = soloDice();

        if (ordiTour(numeroDague)) {
            alertNotification("Your adversary died ! You won !", "", stage, () -> {
                if (prize) {
                    prize = false;
                   dialogBoxPrizes.show(stage);
                } else {
                    victoryMiniGame.show(stage);
                }
            });
        } else {
            alertNotification("Your adversary survived his turn", "", stage, () -> {
                joueurTour(numeroDague, this::dagueDingue);
            });


        }
    }

    private void joueurTour(int numeroDague, Runnable onChose) {
        dialogBoxDagueDingue.getButtonTable().clear();

        for (int i = 1; i <= 6; i++) {
            if (i == numeroDague) {
                dialogBoxDagueDingue.button("Dague " + i, new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        alertNotification("You are dead", "You chose the real dagger and died", stage, () -> {
                            game.setScreen(new GameOverScreen(game));
                        });
                        return true;
                    }
                });
            } else {
                dialogBoxDagueDingue.button("Dague " + i, new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        onChose.run();
                        alertNotification("You survived ! ", "You chose a fake dagger", stage,null);
                        return true;
                    }
                });
            }
        }
        dialogBoxDagueDingue.show(stage);
    }

    private boolean ordiTour(int numeroDague) {
        return numeroDague == soloDice();
    }

    //Pique Six
    private void piqueSix() {
        if (tablePiqueSix != null) tablePiqueSix.clear();
        if (buttonLancerDice != null) buttonLancerDice.remove();
        if (goldTotal != null) goldTotal.remove();

        tablePiqueSix = new Table();
        tablePiqueSix.setFillParent(true);

        tableLabel = initLabel();
        TextButton[] tableButtonsAdd = initTextButtonAdd();
        TextButton[] tableButtonsLess = initTextButtonLess();

        goldTotal = new Label("Or total : " + game.getPlayer().getGold(), Skins.DEFAULT_SKIN);
        goldTotal.setFontScale(1.5f);
        goldTotal.setPosition(Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.75f);
        stage.addActor(goldTotal);

        for (int i = 1; i <= 6; i++) {
            Label num = new Label(Integer.toString(i), Skins.DEFAULT_SKIN);
            tablePiqueSix.add(num);
            tablePiqueSix.add(tableButtonsAdd[i - 1]);
            tablePiqueSix.add(tableButtonsLess[i - 1]);
            tablePiqueSix.add(tableLabel[i - 1]);
            tablePiqueSix.row();
        }

        stage.addActor(tablePiqueSix);
        buttonLancerDice.setPosition(Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.9f, Align.center);
        stage.addActor(buttonLancerDice);
    }

    private TextButton[] initTextButtonAdd() {
        TextButton[] renvoi = new TextButton[6];
        for (int i = 0; i < 6; i++) {
            renvoi[i] = new TextButton("More", Skins.DEFAULT_SKIN);
            int finalI = i;
            renvoi[i].addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    if (sommeTableMise() + 1 > game.getPlayer().getGold()) {
                        return true;
                    } else {
                        tableMises[finalI] += 1;
                    }
                    updateCounter();
                    return true;
                }
            });
        }
        return renvoi;
    }

    private Label[] initLabel() {
        Label[] renvoi = new Label[6];
        for (int i = 0; i < 6; i++) {
            renvoi[i] = new Label(Integer.toString(tableMises[i]), Skins.DEFAULT_SKIN);
        }
        return renvoi;
    }

    private TextButton[] initTextButtonLess() {
        TextButton[] renvoi = new TextButton[6];
        for (int i = 0; i < 6; i++) {
            int finalI = i;
            renvoi[i] = new TextButton("Less", Skins.DEFAULT_SKIN);
            renvoi[i].addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    tableMises[finalI] -= 1;
                    if (tableMises[finalI] < 0) tableMises[finalI] = 0;
                    updateCounter();
                    return true;
                }
            });
        }
        return renvoi;
    }

    private void updateCounter() {
        int i = 0;
        for (Label lab : tableLabel) {
            lab.setText(Integer.toString(tableMises[i]));
            i++;
        }
    }

    private int sommeTableMise() {
        int total = 0;
        for (int i = 0; i < 6; i++) {
            total += tableMises[i];
        }
        return total;
    }

    //Roc bombe
    private void initRocBombe() {
        RocBombe rocBombe = new RocBombe(1 + soloDice());

        alertNotification("New game of Bomb rock has begun", "You are " + rocBombe.getNbJoueur() + " players. You are player number 0", stage, () -> {
            int premierJoueur = rocBombe.premierJoueur();
            alertNotification("First player", "The first player is player number " + premierJoueur, stage, () -> {
                partieRocBombe(rocBombe, premierJoueur, 12);
            });
        });
    }

    private void partieRocBombe(RocBombe rocBombe, int player, int scoreMax) {
        int resultatTour = doubleDice();

        if (resultatTour > scoreMax) { //the rock exploded
            if (player == 0) {
                game.getPlayer().modifyCurrentVitality(-4);
                game.getPlayer().modifyCurrentAbility(-2);
                alertYesNo("The rock exploded on your hands ! "
                    , "You have been hurt by the explosion. Would you like to continue this game anyway ? "
                    , stage, () -> { //yes
                        partieRocBombe(rocBombe, rocBombe.getNextJoueur(player), 12);
                    },
                    () -> { //no
                        defeatMiniGame.show(stage);
                    });
            } else {
                rocBombe.eliminateJoueur(player);
                alertNotification("A player has been eliminated", rocBombe.getJoueur(player) + " has been eliminated",
                    stage, () -> {
                        if (rocBombe.joueurEnJeu() > 1) {
                            int nextPlayer = rocBombe.getNextJoueur(player);
                            alertNotification("Next player", "The next player is  " + rocBombe.getJoueur(nextPlayer) +
                                ". There is still " + rocBombe.joueurEnJeu() + " players.", stage, () -> {
                                partieRocBombe(rocBombe, rocBombe.getNextJoueur(player), 12);
                            });
                        } else {
                            game.getPlayer().setGold(game.getPlayer().getGold() + rocBombe.getPactole());
                            alertNotification("Game over", "You won " + rocBombe.getPactole() + " golds", stage, () -> {
                                if (prize) {
                                    prize = false;
                                    dialogBoxPrizes.show(stage);
                                } else {
                                    victoryMiniGame.show(stage);
                                }
                            });
                        }
                    });
            }
        } else if (resultatTour == scoreMax) { //the rock exploded in the air
            alertNotification("The rock exploded in the air",
                "The game is on with the same number of players", stage, () -> {
                    partieRocBombe(rocBombe, rocBombe.getNextJoueur(player), 12);
                });
        } else { //the rock did not explode
            alertNotification(rocBombe.getJoueur(player) + ", the rock did not explode.",
                "The game continues.", stage, () -> {
                    partieRocBombe(rocBombe, rocBombe.getNextJoueur(player), scoreMax - 1);
                });
        }
    }

    private void visualSpellChoosing(){
        tableSorts = new Table();
        final int limiteSorts = 2;
        int cpt = 0;

        initLabelSorts();
        for (Label nomSort : nomSorts) {
            tableSorts.add(nomSort);
            tableSorts.row();
        }
    }

    private void initLabelSorts(){
        for (int i = 0; i < SpellList.Sorts.values().length; i++) {
            nomSorts[i] = new Label(SpellList.getName(SpellList.Sorts.values()[i]), Skins.DEFAULT_SKIN);
            nomSorts[i].setFontScale(1.5f);
            nomSorts[i].setPosition(Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.75f + i * 50);
        }
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        hud.update(v);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        game.batch.begin();
        BitmapFont font = new BitmapFont();
        font.draw(game.batch, "Game room screen", Gdx.graphics.getWidth() * 0.25f, Gdx.graphics.getHeight() * 0.3f);
        game.batch.end();
        stage.draw();
    }

    @Override
    public void hide() {

    }

    public void dispose() {
        hud.dispose();
        stage.dispose();
    }
}

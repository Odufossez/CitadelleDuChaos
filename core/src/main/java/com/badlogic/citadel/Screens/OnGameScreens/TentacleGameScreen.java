package com.badlogic.citadel.Screens.OnGameScreens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogAlert;
import com.badlogic.citadel.DialogWindows.DialogBox;
import com.badlogic.citadel.DialogWindows.DialogBoxMethods;
import com.badlogic.citadel.Dice;
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

public class TentacleGameScreen extends ApplicationAdapter implements Screen {
    private Citadel game;
    private Stage stage;
    private HUD hud;

    DialogBox dialogBoxGreyTentacle = new DialogBox("Narrator");
    DialogBox dialogBoxGreyTentacle_1 = new DialogBox("Narrator");
    DialogBox dialogBoxLevitation = new DialogBox("Narrator");
    DialogBox dialogBoxLevitation_1 = new DialogBox("Narrator");
    DialogBox dialogBoxFire = new DialogBox("Narrator");

    public TentacleGameScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        hud = new HUD(game,stage);
    }

    public void show(){
        Gdx.input.setInputProcessor(stage);
        create();
        input();
    }

    public void create(){
        dialogBoxGreyTentacle.text("Walking the courtyard, you walk along a lump that seems to connect the temple " +
            "to the tower; like a canalisation right under the dirt.");
        dialogBoxGreyTentacle_1.text("You examine it closer, maybe it is just a mole gallery ? But when you touch it, " +
            "it retracts and a grey tentacle appears from the ground and grab you by the leg.");
        dialogBoxLevitation.text("You cast Levitation and start to float. The tentacle goes up in the air with you " +
            "and your leg starts to hurt tremendously.");
        dialogBoxLevitation_1.text("No other choices now but to fight or cast another spell.");
        dialogBoxFire.text("You cast Fire and the tentacle starts to tremble and release your leg before retreat " +
            "below the dirt. You rub your numb leg and resume your way towards the tower.");

        dialogBoxGreyTentacle.show(stage);
        hud.bringToFront();
    }

    public void input(){
        DialogBoxMethods.continueDialogBox(dialogBoxGreyTentacle,dialogBoxGreyTentacle_1,"Take a closer look", stage,hud);
        dialogBoxGreyTentacle_1.button("Draw out your sword" , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                dialogBoxGreyTentacle_1.hide();
                combat71();
                hud.bringToFront();
                return true;
            }
        });

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.LEVITATION)){
            DialogBoxMethods.alertSpellDialog(dialogBoxGreyTentacle_1,dialogBoxLevitation, SpellList.Sorts.LEVITATION,hud,stage,game);
            DialogBoxMethods.continueDialogBox(dialogBoxLevitation,dialogBoxLevitation_1,"Get back down", stage,hud);

            dialogBoxLevitation_1.button("Draw out my sword" , new InputListener() {
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    dialogBoxLevitation_1.hide();
                    combat71();
                    hud.bringToFront();
                    return true;
                }
            });
        }

        if (game.getPlayer().getGrimoire().isInGrimoire(SpellList.Sorts.FEU)){
            DialogBoxMethods.alertSpellDialog(dialogBoxGreyTentacle_1,dialogBoxFire, SpellList.Sorts.FEU,hud,stage,game);
            DialogBoxMethods.alertSpellDialog(dialogBoxLevitation_1,dialogBoxFire, SpellList.Sorts.FEU,hud,stage,game);
            DialogBoxMethods.continueDialogBox(dialogBoxFire,"Go to the tower's door",stage,new RhinoDoorGameScreen(game),game);
        }
    }

    //combat grey tentacle
    private void combat71(){
        Monster greyTentacle = new Monster("Grey tentacle" , 15 , 2);
        int compteurTour = 1;
        hud.showEnenmyHealthBars(greyTentacle);
        showCombatDialogBox71(greyTentacle, compteurTour);
    }

    private void showCombatDialogBox71(Monster monster, int cptTour){
        //le monstre est mort
        if (monster.isDead() && cptTour != 4){
            hud.hideEnenmyBars();
            DialogBox victory = new DialogBox("Narrator");
            victory.text("You have defeated the Grey Tentacle.\n" +
                "You continue your way to the Tower.");
            DialogBoxMethods.continueDialogBox(victory,stage,new RhinoDoorGameScreen(game),game);
            return;
        }

        //si le compteur atteint 4
        if (cptTour == 4){
            DialogBox defeat = new DialogBox("Narrator !");
            defeat.text("You were dragged into the hole by the Grey Tentacle.");
            DialogBoxMethods.continueDialogBox(defeat,stage,new GameOverScreen(game),game);
            return;
        }

        //exécution du combat
        DialogBox fightBox = new DialogBox("Choose an action");
        DialogBox tentacleCrawl = setupTentacleCrawl(monster,cptTour);

        fightBox.button("Attack", new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                int scorePlayer = Dice.doubleDice()+game.getPlayer().getCurrentAbility();
                fightBox.hide();
                DialogAlert alert = new DialogAlert("Info !");

                if (scorePlayer<monster.getAbility()){
                    alert.text("You did not harm the tentacle.");
                    alert.button("Continue" , Color.BLACK, new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            alert.hide();
                            tentacleCrawl.show(stage);
                            return true;
                        }
                    });
                } else {
                    monster.isTouchedInCombat();
                    alert.text("You harmed the tentacle.");
                    alert.button("Continue", Color.BLACK , new InputListener() {
                        public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                            alert.hide();
                            showCombatDialogBox71(monster,cptTour);
                            return true;
                        }
                    });
                }
                alert.show(stage);
                return true;
            }
        });
        fightBox.button("Try to escape", new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                fightBox.hide();
                DialogBox escapeBox = new DialogBox("Narrator");
                escapeBox.text("You try to escape the Grey Tentacle.\n" +
                    "But it does not work.");
                DialogBoxMethods.continueDialogBox(escapeBox,tentacleCrawl,hud,stage);
                stage.addActor(escapeBox);
                escapeBox.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        stage.addActor(fightBox);
        fightBox.show(stage);
        hud.bringToFront();
    }

    private DialogBox setupTentacleCrawl(Monster monster, int cptTour){
        DialogBox tentacleCrawl = new DialogBox("Grey Tentacle");
        DialogAlert alert = new DialogAlert("Do you want to crawl ?");

        alert.text("You have " + (4-cptTour+1) + " round left to get away" );
        alert.button("Ok" , Color.BLACK , new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                alert.hide();
                showCombatDialogBox71(monster, cptTour + 1);
                return true;
            }
        });
        tentacleCrawl.text("The tentacle grabs tighter and drags you to its hole !");
        tentacleCrawl.button("Continue" , new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                alert.show(stage);
                tentacleCrawl.hide();
                hud.bringToFront();
                return true;
            }
        });
        return tentacleCrawl;
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        hud.update(delta);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        game.batch.begin();
        BitmapFont font = new BitmapFont();
        font.draw(game.batch, "Tentacle screen" , Gdx.graphics.getWidth()*0.5f, Gdx.graphics.getHeight()*0.3f);
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

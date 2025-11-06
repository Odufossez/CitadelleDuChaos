package com.badlogic.citadel.Screens.OnGameScreens;

import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogBox;
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

import static com.badlogic.citadel.DialogWindows.DialogBoxMethods.*;

//73
public class PassageRiverGameScreen extends ApplicationAdapter implements Screen {
    private Citadel game;
    private Stage stage;
    private HUD hud;

    private boolean force;

    private DialogBox dialogBox073 = new DialogBox("Narrator");
    private DialogBox dialogBox112 = new DialogBox("Narrator");
    private DialogBox dialogBox282 = new DialogBox("Narrator");
    private DialogBox dialogBox367 = new DialogBox("Narrator");
    private DialogBox dialogBox212 = new DialogBox("Narrator");
    private DialogBox dialogBox121 = new DialogBox("Narrator");
    private DialogBox dialogBox308 = new DialogBox("Narrator");

    public PassageRiverGameScreen(Citadel game) {
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

    public void create(){
        dialogBox073.text("");
    }

    public void input(){
        continueDialogBox(dialogBox073,"Draw my sword",hud, this::combat73);

        if (game.getPlayer().getGrimoire().isInGrimoire( SpellList.Sorts.FORCE)){
            alertSpellDialog(dialogBox073, SpellList.Sorts.FORCE,hud,stage,game,()->{
                force = true;
                combat73();
            });
        }

        if (game.getPlayer().getGrimoire().isInGrimoire( SpellList.Sorts.FEU)){
            alertSpellDialog(dialogBox073,dialogBox282, SpellList.Sorts.FEU,hud,stage,game,()->{
                alertPlayerPV(2,stage,game,null);
            });
        }

        continueDialogBox(dialogBox112,"Go forwards",stage,new CroisementFourWays(game),game);
        continueDialogBox(dialogBox112,dialogBox212,"Go left",stage,hud);
    }

    private void combat73(){
        Monster snake = new Monster("Snake" , 6 , 7);

        hud.showEnenmyHealthBars(snake);
        showDialogCombat(snake);
    }

    private void showDialogCombat(Monster monster){
        //conditions victoire
        if (monster.isDead()){
            hud.hideEnenmyBars();
            DialogBox victory = new DialogBox("Narrator");
            victory.text("You have defeated the Snake.");
            continueDialogBox(victory,dialogBox112,hud,stage,null);
            return;
        }

        //joueur est mort
        if (game.getPlayer().isDead()){
            stage.clear();
            game.setScreen(new GameOverScreen(game));
        }

        //déroulement
        DialogBox fightbox = new DialogBox("Choose an action");
        fightbox.button("Attack", new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                int scorePlayer = Dice.doubleDice() + game.getPlayer().getCurrentAbility();
                if (force){
                    scorePlayer += 3;
                }
                int scoreMonster = Dice.doubleDice() + monster.getAbility();

                Combat.displayAlertResolutionTour(Combat.resolutionTour(scorePlayer,scoreMonster,monster,game),stage,()->{
                    hud.showEnenmyHealthBars(monster);
                    showDialogCombat(monster);
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
        font.draw(game.batch, "Rhino door" , Gdx.graphics.getWidth()*0.25f, Gdx.graphics.getHeight()*0.3f);
        game.batch.end();
        stage.draw();
    }

    public void dispose(){
        stage.dispose();
        hud.dispose();
    }

    @Override
    public void hide() {

    }
}

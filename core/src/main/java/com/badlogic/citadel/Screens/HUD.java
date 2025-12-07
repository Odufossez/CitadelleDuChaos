package com.badlogic.citadel.Screens;
import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogAlert;
import com.badlogic.citadel.DialogWindows.InventoryDialog;
import com.badlogic.citadel.DialogWindows.SpellBookDialog;
import com.badlogic.citadel.Methods.Monster;
import com.badlogic.citadel.PlayerRelatedMethods.Player;
import com.badlogic.citadel.Methods.ScreenTransitionFade;
import com.badlogic.citadel.Screens.PregameScreens.MainMenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;
import java.util.List;

public class HUD implements Disposable {
    private final Citadel game;
    private Player ply;

    private int currentHealth;
    private int maxHealth;
    private int luck;
    private int maxLuck;
    private int mana , maxMana;
    private int ability, maxAbility;
    private int gold;

    private InventoryDialog inventoryDialog;
    private SpellBookDialog spellBookDialog;
    private DialogAlert menuAlert;

    private TextButton inventoryButton, menuButton, spellbookButton;
    private Table table, tableButtons, hudLayer;
    private Table enemyHealthTable;

    private Label healthLabel, luckLabel, manaLabel, abilityLabel, goldLabel;
    private List<Label> enemyHealthLabels;


    public HUD(Citadel game , Stage stage) {
        this.game = game;
        Skin skin = Skins.PLAIN_JAMES_SKIN;

        hudLayer = new Table();
        hudLayer.setFillParent(true);
        hudLayer.setTouchable(com.badlogic.gdx.scenes.scene2d.Touchable.childrenOnly);

        table = new Table();
        table.top().left();

        tableButtons = new Table();
        tableButtons.right().top();

        enemyHealthTable = new Table();
        enemyHealthTable.top();
        enemyHealthLabels = new ArrayList<>();

        recupDataPlayer();

        Label.LabelStyle whiteStyle = new Label.LabelStyle(skin.get(Label.LabelStyle.class));
        whiteStyle.fontColor = Color.WHITE;

        healthLabel = new Label("Health : " + currentHealth + "/" + maxHealth , whiteStyle);
        luckLabel = new Label("Luck : " + luck + "/" + maxLuck , whiteStyle);
        manaLabel = new Label("Mana : " + mana + "/" + maxMana , whiteStyle);
        abilityLabel = new Label("Ability : " + ability + "/"+ maxAbility , whiteStyle);
        goldLabel = new Label("Gold : " + gold , whiteStyle);

        inventoryButton = new TextButton("Inventory" , skin);
        menuButton = new TextButton("Menu" , skin);
        spellbookButton = new TextButton("Spellbook" , skin);

        table.add(healthLabel).padTop(10);
        table.row();
        table.add(luckLabel).padTop(10);
        table.row();
        table.add(manaLabel).padTop(10);
        table.row();
        table.add(abilityLabel).padTop(10);
        table.row();
        table.add(goldLabel).padTop(10);

        tableButtons.add(inventoryButton).padTop(10);
        tableButtons.row();
        tableButtons.add(spellbookButton).padTop(10);
        tableButtons.row();
        tableButtons.add(menuButton).padTop(10);

        //on ajoute les tables au HUD
        hudLayer.add(table).expand().top().left().padLeft(10).padTop(10);
        hudLayer.add(enemyHealthTable).expandX().top().center();
        hudLayer.add(tableButtons).expand().top().right().padRight(10).padTop(10);

        //ajout de la layer à la stage
        stage.addActor(hudLayer);

        input(stage);
    }

    public void bringToFront(){
        hudLayer.toFront();
    }

    public void recupDataPlayer(){
        ply = game.getPlayer();

        //HP
        currentHealth = ply.getCurrentVitality();
        maxHealth = ply.getVitality();

        //MP
        mana = ply.getCurrentMagic();
        maxMana = ply.getMagic();

        //LP
        luck = ply.getCurrentLuck();
        maxLuck = ply.getLuck();

        //AP
        ability = ply.getCurrentAbility();
        maxAbility = ply.getAbility();

        //gold
        gold = ply.getGold();
    }

    private void backButton(Dialog dialog , Runnable onBack){
        dialog.button("Back",new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x , float y, int pointer, int button){
                dialog.hide();
                onBack.run();
                return true;
            }
        });
    }

    public void input(final Stage stage){
        inventoryButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (inventoryDialog != null) {
                    inventoryDialog.hide();
                    inventoryDialog = null;
                }
                else{
                    inventoryDialog = new InventoryDialog(game);
                    backButton(inventoryDialog , () ->{
                        inventoryDialog = null;
                    });
                    inventoryDialog.getButtonTable().row();
                    inventoryDialog.show(stage);
                    bringToFront();
                }

            }
        });

        spellbookButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (spellBookDialog != null) {
                    spellBookDialog.hide();
                    spellBookDialog = null;
                } else {
                    spellBookDialog = new SpellBookDialog(game);
                    backButton(spellBookDialog , () ->{
                        spellBookDialog = null;
                    });
                    spellBookDialog.getButtonTable().row();
                    spellBookDialog.show(stage);
                    bringToFront();
                }

            }
        });

        menuButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (menuAlert != null){
                    menuAlert.hide();
                    menuAlert = null;
                } else {
                    menuAlert = new DialogAlert("Menu");
                    menuAlert.button("Main menu", Color.BLACK, new InputListener(){ //TODO AN "ARE YOU SURE"
                        @Override
                        public boolean touchDown(InputEvent event, float x , float y, int pointer, int button){
                            stage.clear();
                            Screen next = new MainMenuScreen(game);
                            game.setScreen(new ScreenTransitionFade(game,game.getScreen(), next , 1));
                            return true;
                        }
                    });

                    menuAlert.getButtonTable().row();

                    menuAlert.button("Quit", Color.BLACK ,new InputListener(){ //TODO AN "ARE YOU SURE"
                        @Override
                        public boolean touchDown(InputEvent event, float x , float y, int pointer, int button){
                            Gdx.app.exit();
                            return true;
                        }
                    });
                    menuAlert.getButtonTable().row();

                    menuAlert.button("Back", Color.BLACK ,new InputListener(){
                        @Override
                        public boolean touchDown(InputEvent event, float x , float y, int pointer, int button){
                            menuAlert.hide();
                            return true;
                        }
                    });
                    menuAlert.getButtonTable().row();

                    stage.addActor(menuAlert);
                    menuAlert.show(stage);
                    bringToFront();
                }


            }
        });
    }

    public void showEnenmyHealthBars(Monster... monsters){
        if (enemyHealthTable != null) enemyHealthTable.clear();
        if (enemyHealthLabels!=null) enemyHealthLabels.clear();

        Skin skin = Skins.PLAIN_JAMES_SKIN;
        Label.LabelStyle redStyle = new Label.LabelStyle(skin.get(Label.LabelStyle.class));
        redStyle.fontColor = Color.RED;

        for (Monster monster : monsters) {
            if (monster != null && !monster.isDead()) {
                String healthBarText = createHealthBar(monster);
                Label enemyLabel = new Label(healthBarText, redStyle);
                enemyHealthLabels.add(enemyLabel);
                enemyHealthTable.add(enemyLabel).padTop(10);
                enemyHealthTable.row();
            }
        }
    }

    private static String createHealthBar(Monster monster){
        int maxEndurance = monster.getVitality();
        int currEndurance = monster.getDamage();
        int barLength = 20;

        int filledBars = (int) ((float) currEndurance/maxEndurance*barLength);

        StringBuilder healthbar = new StringBuilder();
        healthbar.append(monster.getName()).append("\n");
        healthbar.append("[");

        for(int i = 0; i < barLength; i++){
            if(i < filledBars){
                healthbar.append("=");
            } else {
                healthbar.append(" ");
            }
        }

        healthbar.append("]");
        healthbar.append(currEndurance).append("/").append(maxEndurance);

        return healthbar.toString();
    }

    public void hideEnenmyBars(){
        enemyHealthLabels.clear();
        enemyHealthTable.clear();
    }


    @Override
    public void dispose() {

    }

    public void update(float dt){
        // Mettre à jour les labels si nécessaire
        recupDataPlayer();
        healthLabel.setText("Health : " + currentHealth + "/" + maxHealth);
        luckLabel.setText("Luck : " + luck + "/" + maxLuck);
        manaLabel.setText("Mana : " + mana + "/" + maxMana);
        abilityLabel.setText("Ability : " + ability + "/"+ maxAbility);
        goldLabel.setText("Gold : " + gold);
    }
}

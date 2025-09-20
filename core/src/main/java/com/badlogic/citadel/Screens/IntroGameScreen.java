package com.badlogic.citadel.Screens;

import com.badlogic.citadel.Citadel;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import javax.swing.event.ChangeEvent;

import static com.badlogic.citadel.Screens.Skins.PLAIN_JAMES_SKIN;

public class IntroGameScreen implements Screen {

    private final Citadel game;
    private final Stage stage;

    public IntroGameScreen(Citadel game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        TextButton toEvent1 = new TextButton("Next" , PLAIN_JAMES_SKIN);
        Table choices = new Table();

        choices.add(toEvent1);
        choices.align(Align.bottom);
        choices.padLeft(1900);
        stage.addActor(choices);

        toEvent1.addListener(new ChangeListener() {
           @Override
            public void changed(ChangeEvent event, Actor actor) {
               game.changeScreen(Citadel.EVENT1);
           }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        game.batch.begin();
        game.font.draw(game.batch , " Le bon peuple de la Vallée des Saules vit depuis environ huit ans dans " +
                "la crainte, voire la terreur. Cette crainte, c'est un certain Balthus le\n" +
                "Terrible qui l'inspire, Balthus le Sorcier dont les pouvoirs magiques " +
                "sont impressionnants. Et lorsque le bruit a couru que Balthus le Terrible\n" +
                "avait décidé de conquérir le monde en commençant par la Vallée des " +
                "Saules, la crainte s'est changée soudain en terreur.\n" +
                "Un elfe envoyé en mission d'espionnage à la Tour Noire est revenu " +
                "trois jours plus tôt, porteur d'une tragique nouvelle : Balthus le Terrible\n" +
                "a en effet recruté dans les grottes du Pic de la Roche toute une armée de " +
                "monstres, les redoutables Chaotiques, qui se préparent à envahir la\n" +
                "Vallée des Saules sous son commandement, et cela, avant la fin de la " +
                "semaine.\n" +
                "Le bon Roi Salamon qui règne sur la Vallée est un homme d'action. " +
                "Aussitôt prévenu, il envoie des messagers dans tout le royaume pour\n" +
                "mobiliser ses sujets et organiser la résistance. Des cavaliers ont " +
                "également été dépêchés dans la Grande Forêt de Yore pour avertir les\n" +
                "elfes qui l'habitent et leur proposer une alliance. Le Roi Salamon est " +
                "aussi un homme sage et il sait que la nouvelle viendra inévitablement\n" +
                "aux oreilles du Grand Enchanteur de Yore, un vieux mage dont les " +
                "pouvoirs sont grands et qui vit au coeur de la forêt.\n" +
                "Le Grand Enchanteur de Yore est cependant trop âgé pour participer " +
                "lui-même à une telle bataille. Mais il se peut que, parmi ses jeunes\n" +
                "disciples, il s'en trouve un qui ait suffisamment de courage et " +
                "d'ambition pour décider de venir en aide au Roi et à ses sujets.\n" +
                "Or, le meilleur élève du Grand Enchanteur de Yore, c'est vous. Sous la " +
                "conduite de ce maître exigeant, vous avez toujours donné le meilleur de " +
                "vous-même\n, et sitôt connue la menace qui plane sur la Vallée des\n" +
                "Saules, vous partez immédiatement pour la cour du Roi Salamon. Là " +
                "vous êtes accueilli comme un héros par le Monarque qui vous expose\n" +
                "aussitôt son plan : il s'agirait d'éviter que la bataille ait lieu en faisant " +
                "disparaître Balthus avant que son armée soit prête.Cette mission est extrêmement périlleuse, car Balthus le Terrible est\n" +
                "protégé, dans sa Citadelle, par une foule de créatures diaboliques. Et " +
                "bien que vos pouvoirs magiques soient votre meilleure arme, il faudra\n" +
                "parfois vous battre à l'épée pour défendre votre vie. " +
                "Le Roi Salamon vous a expliqué votre mission et vous a averti des\n" +
                "dangers qui vous attendent. Un seul chemin vous mènera vers Balthus " +
                "le Terrible avec un minimum de risques. Si vous le découvrez, vous " +
                "gagnerez facilement, mais il vous faudra peut-être faire plusieurs\n" +
                "voyages avant de trouver le meilleur moyen d'atteindre le Sorcier. " +
                "Il ne vous reste plus à présent qu'à vous mettre en route en direction de\n" +
                "la Tour Noire. Parvenu au pied du Pic de la Roche, vous apercevez la " +
                "Citadelle du Chaos dont les contours se dessinent au loin sous le ciel " +
                "sombre... " ,
            (float) Gdx.graphics.getWidth()*0.004f , (float) Gdx.graphics.getHeight()*0.99f ); //todo rework for text showing
        game.batch.end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}

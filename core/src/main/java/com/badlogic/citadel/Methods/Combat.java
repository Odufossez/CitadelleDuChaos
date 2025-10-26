package com.badlogic.citadel.Methods;


import com.badlogic.citadel.Citadel;
import com.badlogic.citadel.DialogWindows.DialogAlert;
import com.badlogic.citadel.Dice;
import com.badlogic.citadel.Screens.HUD;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class  Combat {
    public static void displayAlertTouch(int playerTouched, Monster monster , Stage stage , Citadel game , HUD hud, Runnable onComplete){
        String msg ="";
        String resultP1 = ""; //lucky or not
        String resultP2 = ""; //who is hit

        if (playerTouched==1){
            msg = "Will you taunt the devil to take less damage ? ";
            resultP2 = " were hit for 1 less damage.";
        } else if (playerTouched==2){
            msg = "Will you taunt the devil to make more damage ? ";
            resultP2 = " hit the monster for 1 more damage";
        } else {
            return;
        }

        boolean lucky = Dice.doubleDice() <= game.getPlayer().getCurrentLuck(); //true = lucky
        if (lucky){
            resultP1 = " You got lucky and ";
            if (playerTouched==2) monster.setVitality( monster.getVitality() - 1);
            else game.getPlayer().setCurrentVitality( game.getPlayer().getCurrentVitality() + 1);
        } else {
            resultP1 = " You lost your bet and ";
            if (playerTouched==2) monster.setVitality( monster.getVitality() + 1);
            else game.getPlayer().setCurrentVitality( game.getPlayer().getCurrentVitality() - 1 );
        }

        String msgFinal = resultP1 + resultP2;

        DialogAlert getLucky = new DialogAlert(msg);
        getLucky.text("You will lose a point of luck by doing this action");
        getLucky.button("Yes" , Color.BLACK, new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                getLucky.hide();
                game.getPlayer().decreaseLuck(); //enlever 1 PL
                DialogAlert getLuckyResult= new DialogAlert("Result");
                getLuckyResult.text(msgFinal);
                getLuckyResult.button("Ok" ,Color.BLACK, new InputListener(){
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        getLuckyResult.hide();
                        if(onComplete!=null) onComplete.run();
                        return true;
                    }
                });
                stage.addActor(getLuckyResult);
                getLuckyResult.show(stage);
                hud.bringToFront();
                return true;
            }
        });
        getLucky.button("No" , Color.BLACK, new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                getLucky.hide();
                if (onComplete!=null) onComplete.run();
                return true;
            }
        });

        stage.addActor(getLucky);
        getLucky.show(stage);
        hud.bringToFront();
    }

    public static String resolutionTour(int playerScore, int monsterScore, Monster monster, Citadel game){
        String msg = "The " + monster.getName();
        if(playerScore == monsterScore){
            msg +=  " and you pared your hits !\nNobody was hurt.";
        } else if (playerScore > monsterScore) {
            msg += " took 2 damage from your hit !";
            monster.isTouchedInCombat();
        } else {
            msg += " hits you for 2 damage !";
            game.getPlayer().isTouchedInCombat();
        }
        return msg;
    }

    public static String resolutionTour(int scoreAlly, int monsterScore, Monster ally, Monster monster, Citadel game){
        String msg = "The " + monster.getName();
        if (scoreAlly==monsterScore){
            msg += " and " + ally.getName() + " pared their hits !\nNobody was hurt.";
        } else if (scoreAlly > monsterScore) {
            msg += " took 2 damage from " + ally.getName() + "'s hit !";
            monster.isTouchedInCombat();
        } else {
            msg += " hits " + ally.getName() + " for 2 damage !";
            game.getPlayer().isTouchedInCombat();
        }
        return msg;
    }

    public static int isPlayerTouched(int playerScore, int monsterScore){
        if (playerScore == monsterScore){
            return 0;
        }
        if (playerScore > monsterScore){
            return 2;
        }
        return 1;
    }

}

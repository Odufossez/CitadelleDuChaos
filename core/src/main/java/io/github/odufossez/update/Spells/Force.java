package Spells;

import Methods.Combat;
import Methods.Monster;
import Methods.Player;
import Tools.Dice;

public class Force {
    public static void renforcer(Player p){
        Combat cmb = p.getCombat();
        Monster m = cmb.getMonster();
        Monster cm = m;

        while(!p.isDead() || !m.isDead()){
            cmb.fight(Dice.doubleDice() , Dice.doubleDice()+3);
        }
    }
}

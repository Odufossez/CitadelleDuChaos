package Spells;

import Methods.Combat;
import Methods.Monster;
import Methods.Player;
import Tools.Dice;

public class CopyConf {
    public static int copiage(Player p) {
        Combat cmb = p.getCombat();
        Monster m = cmb.getMonster();
        Monster cm = m;

        while(!m.isDead() || !cm.isDead()) {
            cmb.fightMvM(Dice.doubleDice(),Dice.doubleDice());
        }
        return m.getVitality();
    }
}

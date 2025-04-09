package Methods;

import Spells.CopyConf;
import Spells.Force;
import Tools.Dice;

import java.io.IOException;

import static EventsCdC.Events.*;
import static EventsCdC.RedirectionEvent.returnToEvent;
import static Tools.ReadingInChar.*;
import static Tools.StdDraw.clear;
import static Tools.Stuff.getStuffInEvent;

public class InventoryMethods {
    private Player ply;
    private boolean flagNotZero;

    public InventoryMethods(Player ply , int flag) throws IOException {
        char inChar;

        if (flag==0){
            flagNotZero=false; //flag est égal à 0, il n'y a pas de première liste
        } else {
            flagNotZero=true; //flag différent de 0
        }

        this.ply=ply;

        do {
            inChar = readChar();
            if (getCharIndex(inChar) > flag && getUsableSpell()){ //partie sorts
                spellIsSelected(getCharIndex(inChar));
            } else if (getCharIndex(inChar) <= flag && getUsableObject()) { //partie objet
                objectIsSelected(getCharIndex(inChar));
            } else if (!getUsableObject() && !getUsableSpell()) {
                System.out.println("Rien d'utilisable");
            } else {
                if (inChar == ESCAPE){
                    returnToEvent(ply.getCurrentEvent());
                }
            }
        }while (true);
    }

    public void objectIsSelected(int indInInventory) throws IOException {
        int object = ply.getWhatIsInventory(indInInventory);
        int event = ply.getCurrentEvent();

        switch (object){
            case 0 :{ //dague enchantée
                if (ply.getIsInCombat()){
                    Combat cmb = ply.getCombat();
                    cmb.getMonster().isTouchedInCombat();
                }
            }
            case 1:{ //Onguent noir
                if (getStuffInEvent(event,1)){
                    switch (event){
                        case 54: event287();
                        case 289: event305();
                        case 322: event291();
                    }
                }
            }
            case 2:{ //brosse à cheveux
                if (getStuffInEvent(event,2)){
                    switch (event){
                        case 42: event91();
                    }
                }
            }
            case 3: { //Essence de berce
                if (getStuffInEvent(event,3)){
                    switch (event){
                        case 289: event214();
                    }
                }
            }
            case 7: { //bocal
                if (getStuffInEvent(event,4)){
                    switch (event){
                        case 3: event59();
                        case 42: event223();
                        case 277: event330();
                        case 322: event39();
                    }
                }
            }
            case 8: { // myriade
                if (getStuffInEvent(event,8)){
                    switch (event){
                        case 3: event327();
                        case 54: event160();
                        case 226: event384();
                        case 277: event315();
                        case 287: event160();
                    }
                }
            }
            case 9: { //poignée de baies
                if (getStuffInEvent(event,9)){
                    switch (event){
                        case 3: event236();
                        case 127: event53();
                        case 277: event76();
                    }
                }
            }
            case 10: { //Miroir d'argent
                if (getStuffInEvent(event,10)){
                    switch (event){
                        case 42: event91();
                        case 111: event347();
                        case 127: event387();
                        case 226: event312();
                        case 289: event340();
                    }
                }
            }
            case 11: { //clé de cuivre
                if (getStuffInEvent(event,11)){
                    switch (event){
                        case 228: event296();
                        case 249: event392();
                    }
                }
            }
            case 12: { //toison d'or
                if (getStuffInEvent(event,12)){
                    if (event==226){
                        event37();
                    }
                }
            }
            case 13: { //amulette ensorcelée
                if (getStuffInEvent(event,13)){
                    switch (event){
                        case 322: event168();
                    }
                }
            }
        }
    }

    public void spellIsSelected(int indInInventory) throws IOException {
        int sort = ply.getWhatIsInventory(indInInventory);
        int event = ply.getCurrentEvent();

        switch (sort){
            case 0:{ //chance
                int oldLuck = ply.getCurrentLuck();

                if (oldLuck<ply.getLuck()){
                    if(oldLuck+(ply.getLuck()/2) > ply.getLuck()){
                        ply.setCurrentLuck(ply.getLuck());
                    } else {
                        ply.setCurrentLuck(oldLuck+(ply.getLuck()/2));
                    }
                } else {
                    //todo message pour dire que la chance est au max
                }


            }
            case 1:{ //copie
                if (ply.getIsInCombat()){
                    if(CopyConf.copiage(ply)>0){
                        Combat cmb = ply.getCombat();
                        Monster mst = cmb.getMonster();
                        while(!mst.isDead()||!ply.isDead()){
                            cmb.fight(Dice.doubleDice() , Dice.doubleDice());
                        }
                        if (ply.getCurrentVitality()==0){
                            //todo game over
                        }
                    }
                } else {
                    //todo message "il ny a rien à copier"
                }
            }
            case 2:{ //endurance

                if(ply.getCurrentVitality()<ply.getVitality()){
                    int oldEndu = ply.getCurrentVitality();
                    if (oldEndu+(ply.getVitality()/2) > ply.getVitality()){
                        ply.setCurrentVitality(ply.getVitality());
                    } else {
                        ply.setCurrentVitality(oldEndu+(ply.getVitality()/2));
                    }
                } else {
                    //todo message pour dire que la santé est au max
                }
            }
            case 3:{ // faiblesse

            }
            case 4:{ //feu
                switch (event){
                    case 73: event282();
                    case 77: event46();
                    case 98: event4();
                    case 128: event240();
                    case 139: event28();
                    case 156,284: event114();
                    case 182,395: event85();
                    default : //todo renvoyer message de rien ne se passe
                }
            }
            case 5:{ //force
                switch(event){
                    case 7,174: event116();
                    case 25: event133();
                    case 51,188: event301();
                    case 70: event264();
                    case 73: {
                        Force.renforcer(ply);
                        if (ply.getCurrentVitality()==0){
                            //todo game over screen
                        }
                    }
                    case 88: event170();
                    case 165: event398();
                    case 218: event94();
                    case 228: event170();
                    case 229: event164();
                    case 241:{
                        Combat cmb = ply.getCombat();
                        Monster m = cmb.getMonster();
                        while(!m.isDead() || !ply.isDead()){
                            cmb.fight(Dice.doubleDice() , Dice.doubleDice());
                        }
                        if (ply.getCurrentVitality()==0){
                            //todo gameover
                        }
                    }

                    case 276: event165();
                    case 288: event162();
                    case 290: event264();
                    default: //todo message "inutile pour le moment"
                }
            }
            case 6:{ //habilité
                if(ply.getCurrentHab()<ply.getHability()){
                    if (ply.getCurrentHab()+(ply.getHability()/2) > ply.getHability()){
                        ply.setCurrentHab(ply.getHability());
                    } else {
                        ply.setCurrentHab(ply.getCurrentHab()+(ply.getHability()/2));
                    }
                } else {
                    //todo message pour dire que la santé est au max
                }
            }
            case 7:{ //illusion

            }
            case 8:{ //lévitation

            }
            case 9:{//or du sot

            }
            case 10:{ //protection

            }
            case 11:{//télépathie

            }
        }
        ply.removeFromInvent(indInInventory);
    }

}

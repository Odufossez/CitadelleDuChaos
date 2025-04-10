package Methods;

import Spells.CopyConf;
import Spells.Force;
import Tools.Dice;

import java.io.IOException;

import static EventsCdC.Events.*;
import static EventsCdC.RedirectionEvent.returnToEvent;
import static Tools.ReadingInChar.*;
import static Tools.StdDraw.clear;
import static Items.Stuff.getStuffInEvent;

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
                if (inChar == RETURN){
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
                switch (event){
                    case 11: {
                        ply.removeFromInvent(indInInventory);
                        event152();
                    }
                    case 26:{
                        ply.removeFromInvent(indInInventory);
                        event345();
                    }
                    case 51: {
                        ply.removeFromInvent(indInInventory);
                        event159();
                    }
                    case 70: {
                        ply.removeFromInvent(indInInventory);
                        event307();
                    }
                    case 128: {
                        ply.removeFromInvent(indInInventory);
                        event152();
                    }
                    case 188: {
                        ply.removeFromInvent(indInInventory);
                        event159();
                    }
                    case 189: {
                        ply.removeFromInvent(indInInventory);
                        event43();
                    }
                    case 246: {
                        ply.getCombat().getMonster().setHability(5);
                        ply.removeFromInvent(indInInventory);
                    }
                    case 275: {
                        ply.getCombat().getMonster().setHability(5);
                        ply.removeFromInvent(indInInventory);
                    }
                    case 307: {
                        ply.removeFromInvent(indInInventory);
                        ply.getCombat().getMonster().setHability(4);
                    }
                    case 320: {
                        ply.removeFromInvent(indInInventory);
                        event113();
                    }
                    case 374: {
                        ply.removeFromInvent(indInInventory);
                        event158();
                    }
                    default: //todo rien à faire
                }
            }
            case 4:{ //feu
                switch (event){
                    case 73: {
                        ply.removeFromInvent(indInInventory);
                        event282();
                    }
                    case 77: {
                        ply.removeFromInvent(indInInventory);
                        event46();
                    }
                    case 98: {
                        ply.removeFromInvent(indInInventory);
                        event4();
                    }
                    case 128: {
                        ply.removeFromInvent(indInInventory);
                        event240();
                    }
                    case 139: {
                        ply.removeFromInvent(indInInventory);
                        event28();
                    }
                    case 156,284:{
                        ply.removeFromInvent(indInInventory);
                        event114();
                    }
                    case 182,395: {
                        ply.removeFromInvent(indInInventory);
                        event85();
                    }
                    default : //todo renvoyer message de rien ne se passe
                }
            }
            case 5:{ //force
                switch(event){
                    case 7,174: {
                        ply.removeFromInvent(indInInventory);
                        event116();
                    }
                    case 25:{
                        ply.removeFromInvent(indInInventory);
                        event133();
                    }
                    case 51,188: {
                        ply.removeFromInvent(indInInventory);
                        event301();
                    }
                    case 70: {
                        ply.removeFromInvent(indInInventory);
                        event264();
                    }
                    case 73: {
                        Force.renforcer(ply);
                        ply.removeFromInvent(indInInventory);
                        if (ply.getCurrentVitality()==0){
                            //todo game over screen
                        }
                    }
                    case 88: {
                        ply.removeFromInvent(indInInventory);
                        event170();
                    }
                    case 165: {
                        ply.removeFromInvent(indInInventory);
                        event398();
                    }
                    case 218: {
                        ply.removeFromInvent(indInInventory);
                        event94();
                    }
                    case 228: {
                        ply.removeFromInvent(indInInventory);
                        event170();
                    }
                    case 229: {
                        ply.removeFromInvent(indInInventory);
                        event164();
                    }
                    case 241:{
                        Combat cmb = ply.getCombat();
                        Monster m = cmb.getMonster();
                        while(!m.isDead() || !ply.isDead()){
                            cmb.fight(Dice.doubleDice() , Dice.doubleDice());
                        }
                        if (ply.getCurrentVitality()==0){
                            //todo gameover
                        }
                        ply.removeFromInvent(indInInventory);
                    }

                    case 276: {
                        ply.removeFromInvent(indInInventory);
                        event165();
                    }
                    case 288: {
                        ply.removeFromInvent(indInInventory);
                        event162();
                    }
                    case 290: {
                        ply.removeFromInvent(indInInventory);
                        event264();
                    }
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
                    ply.removeFromInvent(indInInventory);
                } else {
                    //todo message pour dire que la santé est au max
                }
            }
            case 7:{ //illusion
                switch (event){
                    case 47: {
                        ply.removeFromInvent(indInInventory);
                        event173();
                    }
                    case 60: {
                        ply.removeFromInvent(indInInventory);
                        event295();
                    }
                    case 85: {
                        ply.removeFromInvent(indInInventory);
                        event395();
                    }
                    case 123: {
                        ply.removeFromInvent(indInInventory);
                        event35();
                    }
                    case 139,300: {
                        ply.removeFromInvent(indInInventory);
                        event244();
                    }
                    case 182: {
                        ply.removeFromInvent(indInInventory);
                        event395();
                    }
                    case 187: {
                        ply.removeFromInvent(indInInventory);
                        event314();
                    }
                    case 189: {
                        ply.removeFromInvent(indInInventory);
                        event319();
                    }
                    case 193,211: {
                        ply.removeFromInvent(indInInventory);
                        event35();
                    }
                    case 258: {
                        ply.removeFromInvent(indInInventory);
                        event140();
                    }
                    case 275: {
                        ply.removeFromInvent(indInInventory);
                        event399();
                    }
                    case 309: {
                        ply.removeFromInvent(indInInventory);
                        event250();
                    }
                    case 320,377: {
                        ply.removeFromInvent(indInInventory);
                        event332();
                    }
                    case 365: {
                        ply.removeFromInvent(indInInventory);
                        event9();
                    }
                    default : //todo msg "pas utile rn"
                }
            }
            case 8:{ //lévitation
                switch(event){
                    case 19: {
                        ply.removeFromInvent(indInInventory);
                        event363();
                    }
                    case 47: {
                        ply.removeFromInvent(indInInventory);
                        event259();
                    }
                    case 60: {
                        ply.removeFromInvent(indInInventory);
                        event33();
                    }
                    case 100:{
                        ply.removeFromInvent(indInInventory);
                        event79();
                    }
                    case 156: {
                        ply.removeFromInvent(indInInventory);
                        event284();
                    }
                    case 164: {
                        ply.removeFromInvent(indInInventory);
                        //todo recommencer l'aventure
                    }
                    case 187: {
                        ply.removeFromInvent(indInInventory);
                        event279();
                    }
                    case 239: {
                        ply.removeFromInvent(indInInventory);
                        event379();
                    }
                    case 248: {
                        ply.removeFromInvent(indInInventory);
                        event103();
                    }
                    case 288:{
                        ply.removeFromInvent(indInInventory);
                        event86();
                    }
                    case 290: {
                        ply.removeFromInvent(indInInventory);
                        event70();
                    }
                    case 400: {
                        //todo fin avec lévitation
                        ply.removeFromInvent(indInInventory);
                    }
                    default : //todo message inutile
                }
            }
            case 9:{//or du sot
                switch(event){
                    case 11,128,216: {
                        ply.removeFromInvent(indInInventory);
                        event36();
                    }
                    case 20,230: {
                        ply.removeFromInvent(indInInventory);
                        event96();
                    }
                    case 123: {
                        ply.removeFromInvent(indInInventory);
                        event211();
                    }
                    case 171:{
                        ply.setGold(ply.getGold()+10);
                        ply.removeFromInvent(indInInventory);
                    }
                    case 186: {
                        ply.removeFromInvent(indInInventory);
                        event15();
                    }
                    case 193: {
                        ply.removeFromInvent(indInInventory);
                        event211();
                    }
                    case 225:{
                        ply.removeFromInvent(indInInventory);
                        event15();
                    }
                    default: //todo inutile rn
                }
            }
            case 10:{ //protection
                switch (event){
                    case 24: {
                        ply.removeFromInvent(indInInventory);
                        event372();
                    }
                    case 138:{
                        ply.removeFromInvent(indInInventory);
                        event376();
                    }
                    case 179: {
                        ply.removeFromInvent(indInInventory);
                        event341();
                    }
                    case 189: {
                        ply.removeFromInvent(indInInventory);
                        event130();
                    }
                    case 210: {
                        ply.removeFromInvent(indInInventory);
                        event192();
                    }
                    case 217: {
                        ply.removeFromInvent(indInInventory);
                        event293();
                    }
                    case 292: {
                        ply.removeFromInvent(indInInventory);
                        event376();
                    }
                    case 316:{
                        ply.removeFromInvent(indInInventory);
                        event220();
                    }
                    case 374: {
                        ply.removeFromInvent(indInInventory);
                        event109();
                    }
                }
            }
            case 11:{//télépathie
                switch (event){
                    case 11: {
                        ply.removeFromInvent(indInInventory);
                        event128();
                    }
                    case 77: {
                        ply.removeFromInvent(indInInventory);
                        event187();
                    }
                    case 90,176: {
                        ply.removeFromInvent(indInInventory);
                        event329();
                    }
                    case 193,211: {
                        ply.removeFromInvent(indInInventory);
                        event123();
                    }
                    case 310: {
                        ply.removeFromInvent(indInInventory);
                        event393();
                    }
                    case 377: {
                        ply.removeFromInvent(indInInventory);
                        event320();
                    }
                    default: //todo il n'y a rien à écouter
                }
            }
        }
    }

}

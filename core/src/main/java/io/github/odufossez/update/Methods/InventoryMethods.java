package Methods;

import Items.DagueEnchantee;
import Items.Item;
import Spells.CopyConf;
import Spells.Force;
import Spells.SpellList;
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
            if (getCharIndex(inChar) > flag){ //partie sorts
                spellIsSelected(getCharIndex(inChar));
            } else if (getCharIndex(inChar) <= flag ) { //partie objet
                objectIsSelected(getCharIndex(inChar));
            } else {
                if (inChar == RETURN){
                    returnToEvent(ply.getCurrentEvent());
                }
            }
        }while (true);
    }

    public void objectIsSelected(int indInInventory) throws IOException {
        Item object = ply.getInventory().getItem(indInInventory);
        int event = ply.getCurrentEvent();
        int[] tabEvent = new int[]{};

        switch (object.getLabel()){
            case DAGUE_ENCHANTEE :{
                if(ply.getIsInCombat()){
                    //todo display messages
                    ply.getCombat().getMonster().setVitality(ply.getCombat().getMonster().getVitality()-2);
                    ply.getInventory().removeFrom(object);
                }else{
                    //todo display message "ne sert à rien rn"
                }
                break;
            }
            case ONGUENT_NOIR:{
                switch(event){


                    default:{
                        //todo display ne peut rien en faire
                    }
                }
                break;
            }
            case BROSSE_A_CHEVEUX:{

            }
            case ESSENCE_BERCE:{

            }
            case BOCAL_HOMME_ARAIGNEE:{

            }
            case MYRIADE:{

            }
            case POIGNEE_BAIES:{

            }
            case MIROIR_ARGENT:{

            }
            case CLE_CUIVRE:{

            }
            case TOISON_OR:{

            }
            case AMULETTE_ENSORCELEE:{

            }
        }
    }

    public void spellIsSelected(int indInSpellBook) throws IOException {
        SpellList.Sorts sort = ply.getGrimoire().getSpell(indInSpellBook);
        int event = ply.getCurrentEvent();

        switch (sort){
            case CHANCE:{ //chance
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
                break;
            }
            case COPIE_CONFORME:{ //copie
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
                break;
            }
            case ENDURANCE:{ //endurance

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
                break;
            }
            case FAIBLESSE:{ // faiblesse
                switch (event){
                    case 11: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                        event152();
                    }
                    case 26:{
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                        event345();
                    }
                    case 51: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                        event159();
                    }
                    case 70: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                        event307();
                    }
                    case 128: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                        event152();
                    }
                    case 188: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                        event159();
                    }
                    case 189: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                        event43();
                    }
                    case 246: {
                        ply.getCombat().getMonster().setHability(5);
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                    }
                    case 275: {
                        ply.getCombat().getMonster().setHability(5);
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                    }
                    case 307: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                        ply.getCombat().getMonster().setHability(4);
                    }
                    case 320: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                        event113();
                    }
                    case 374: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FAIBLESSE);
                        event158();
                    }
                    default: //todo rien à faire
                }
            }
            case FEU:{ //feu
                switch (event){
                    case 73: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FEU);
                        event282();
                    }
                    case 77: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FEU);
                        event46();
                    }
                    case 98: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FEU);
                        event4();
                    }
                    case 128: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FEU);
                        event240();
                    }
                    case 139: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FEU);
                        event28();
                    }
                    case 156,284:{
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FEU);
                        event114();
                    }
                    case 182,395: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FEU);
                        event85();
                    }
                    default : //todo renvoyer message de rien ne se passe
                }
                break;
            }
            case FORCE:{ //force
                switch(event){
                    case 7,174: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FORCE);
                        event116();
                    }
                    case 25:{
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FORCE);
                        event133();
                    }
                    case 51,188: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FORCE);
                        event301();
                    }
                    case 70: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FORCE);
                        event264();
                    }
                    case 73: {
                        Force.renforcer(ply);
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FORCE);
                        if (ply.getCurrentVitality()==0){
                            //todo game over screen
                        }
                        event112();
                    }
                    case 88: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FORCE);
                        event170();
                    }
                    case 165: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FORCE);
                        event398();
                    }
                    case 218: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FORCE);
                        event94();
                    }
                    case 228: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FORCE);
                        event170();
                    }
                    case 229: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FORCE);
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
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FORCE);
                        event77();
                    }

                    case 276: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FORCE);
                        event165();
                    }
                    case 288: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FORCE);
                        event162();
                    }
                    case 290: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.FORCE);
                        event264();
                    }
                    default: //todo message "inutile pour le moment"
                }
                break;
            }
            case HABILITE:{ //habilité
                if(ply.getCurrentHab()<ply.getHability()){
                    if (ply.getCurrentHab()+(ply.getHability()/2) > ply.getHability()){
                        ply.setCurrentHab(ply.getHability());
                    } else {
                        ply.setCurrentHab(ply.getCurrentHab()+(ply.getHability()/2));
                    }
                    ply.getGrimoire().removeFrom(SpellList.Sorts.HABILITE);
                } else {
                    //todo message pour dire que la santé est au max
                }
                break;
            }
            case ILLUSION:{ //illusion
                switch (event){
                    case 47: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                        event173();
                    }
                    case 60: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                        event295();
                    }
                    case 85: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                        event395();
                    }
                    case 123: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                        event35();
                    }
                    case 139,300: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                        event244();
                    }
                    case 182: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                        event395();
                    }
                    case 187: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                        event314();
                    }
                    case 189: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                        event319();
                    }
                    case 193,211: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                        event35();
                    }
                    case 258: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                        event140();
                    }
                    case 275: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                        event399();
                    }
                    case 309: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                        event250();
                    }
                    case 320,377: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                        event332();
                    }
                    case 365: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.ILLUSION);
                        event9();
                    }
                    default : //todo msg "pas utile rn"
                }
                break;
            }
            case LEVITATION:{ //lévitation
                switch(event){
                    case 19: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.LEVITATION);
                        event363();
                    }
                    case 47: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.LEVITATION);
                        event259();
                    }
                    case 60: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.LEVITATION);
                        event33();
                    }
                    case 100:{
                        ply.getGrimoire().removeFrom(SpellList.Sorts.LEVITATION);
                        event79();
                    }
                    case 156: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.LEVITATION);
                        event284();
                    }
                    case 164: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.LEVITATION);
                        //todo recommencer l'aventure
                    }
                    case 187: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.LEVITATION);
                        event279();
                    }
                    case 239: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.LEVITATION);
                        event379();
                    }
                    case 248: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.LEVITATION);
                        event103();
                    }
                    case 288:{
                        ply.getGrimoire().removeFrom(SpellList.Sorts.LEVITATION);
                        event86();
                    }
                    case 290: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.LEVITATION);
                        event70();
                    }
                    case 400: {
                        //todo fin avec lévitation
                        ply.getGrimoire().removeFrom(SpellList.Sorts.LEVITATION);
                    }
                    default : //todo message inutile
                }
                break;
            }
            case OR_DU_SOT:{//or du sot
                switch(event){
                    case 11,128,216: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.OR_DU_SOT);
                        event36();
                    }
                    case 20,230: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.OR_DU_SOT);
                        event96();
                    }
                    case 123: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.OR_DU_SOT);
                        event211();
                    }
                    case 171:{
                        ply.setGold(ply.getGold()+10);
                        ply.getGrimoire().removeFrom(SpellList.Sorts.OR_DU_SOT);
                    }
                    case 186: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.OR_DU_SOT);
                        event15();
                    }
                    case 193: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.OR_DU_SOT);
                        event211();
                    }
                    case 225:{
                        ply.getGrimoire().removeFrom(SpellList.Sorts.OR_DU_SOT);
                        event15();
                    }
                    default: //todo inutile rn
                }
            }
            case PROTECTION:{ //protection
                switch (event){
                    case 24: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.PROTECTION);
                        event372();
                    }
                    case 138:{
                        ply.getGrimoire().removeFrom(SpellList.Sorts.PROTECTION);
                        event376();
                    }
                    case 179: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.PROTECTION);
                        event341();
                    }
                    case 189: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.PROTECTION);
                        event130();
                    }
                    case 210: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.PROTECTION);
                        event192();
                    }
                    case 217: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.PROTECTION);
                        event293();
                    }
                    case 292: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.PROTECTION);
                        event376();
                    }
                    case 316:{
                        ply.getGrimoire().removeFrom(SpellList.Sorts.PROTECTION);
                        event220();
                    }
                    case 374: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.PROTECTION);
                        event109();
                    }
                    default://todo inutile
                }
                break;
            }
            case TELEPATHIE:{//télépathie
                switch (event){
                    case 11: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.TELEPATHIE);
                        event128();
                    }
                    case 77: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.TELEPATHIE);
                        event187();
                    }
                    case 90,176: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.TELEPATHIE);
                        event329();
                    }
                    case 193,211: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.TELEPATHIE);
                        event123();
                    }
                    case 310: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.TELEPATHIE);
                        event393();
                    }
                    case 377: {
                        ply.getGrimoire().removeFrom(SpellList.Sorts.TELEPATHIE);
                        event320();
                    }
                    default: //todo il n'y a rien à écouter
                }
            }
        }
    }

}

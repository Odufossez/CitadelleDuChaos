package io.github.odufossez.update.EventsCdC;
import Methods.Combat;
import Methods.InventoryMethods;
import Methods.Monster;
import Methods.Player;
import Tools.Dice;
import Visual.*;

import static Tools.ReadingInChar.RETURN;
import static Tools.ReadingInChar.readChar;
import static Tools.OutilsSorts.eventHasSpell;
import static Tools.StdDraw.clear;
import static Items.Stuff.eventHasStuff;
import static Visual.DisplayChoice.choice;
import static Visual.Inventory.displayInventory;
import static Visual.DisplayEvents.*;

import static Tools.PathsTo.*;
import java.io.IOException;

public class Events {
    static private int choice;
    static private Player player;
    static private char inChar;
    static private boolean usableObject;
    static private boolean usableSpell;

    public static boolean getUsableObject(){
        return usableObject;
    }
    public static boolean getUsableSpell() {return usableSpell;}


    public static void setUpPlayer(Player player) throws IOException {
        Events.player = player;
        RedirectionEvent.returnToEvent(player.getCurrentEvent());
    }

    private static void initStuffSpell(int indice){
        usableObject = eventHasStuff(indice);
        usableSpell = eventHasSpell(indice);
    }


    public static void intro(int nbSave) throws IOException {
        DisplayEvents.displayIntro();
        usableObject = false;
        usableSpell = false;
        do {
            inChar = readChar();
            switch (inChar){
                case 'x' : {
                    clear();
                    CharacterCreator.creationPerso(nbSave);
                }
                case RETURN: {
                    clear();
                    MainMenu.afficherTextes();
                }
                default : {continue;}
            }
        }while (true);


    }
    public static void event1() throws IOException {
        DisplayEvents.displayEvent1();
        player.setCurrentEvent(1);
        new HUD(player);
        initStuffSpell(1);
        do {
            inChar = readChar();
            switch (inChar){
                case 'i' : {
                    clear();
                    new InventoryMethods(player,displayInventory(player));
                }
                case '&','1': {
                    clear();
                    event261();
                    break;
                }
                case 'é','2': {
                    clear();
                    event230();
                    break;
                }
                case '"','3': {
                    clear();
                    event20();
                    break;
                }
                default: continue;
            }
        }while (true);
    }
    public static void event2() throws IOException {
        player.setCurrentEvent(2);
        displayEvent2();
        new HUD(player);
        initStuffSpell(2);
        choice(pathToChoices+"choice142.txt" , pathToChoices+"choice343.txt");
        do{
            inChar = readChar();
            switch (inChar){
                case 'i' : {
                    clear();
                    new InventoryMethods(player,displayInventory(player));
                }
                case '&','1': {
                    clear();
                    event142();
                    break;
                }
                case 'é','2': {
                    clear();
                    event343();
                    break;
                }
                default: continue;
        }
        }while (true);


    }
    public static void event3() throws IOException {
        player.setCurrentEvent(3);
        displayEvent3();
        initStuffSpell(3);
        new HUD(player);
        do {
            inChar = readChar();
            switch (inChar){
                case 'i':{
                    clear();
                    new InventoryMethods(player,displayInventory(player));
                }
                case'1','&' : {
                    clear();
                    event366();
                }
                case '2','é':{
                    clear();
                    event286();
                }

                default : {continue;}
            }
        }while (true);
    }
    public static void event4() throws IOException {
        player.setCurrentEvent(4);
        displayEvent4();
        initStuffSpell(4);
        new HUD(player);
        do {
            inChar = readChar();
            switch (inChar){
                case 'i':{
                    clear();
                    new InventoryMethods(player,displayInventory(player));
                }
                case '1','&' : {
                    clear();
                    event303();
                }
                case '2' , 'é':{
                    clear();
                    event190();
                }
                default : {continue;}
            }
        }while(true);

    }

    public static void event5() throws IOException {
        player.setCurrentEvent(5);
        displayEvent5();
        initStuffSpell(5);
        new HUD(player);
        do{
            inChar = readChar();
            switch (inChar){
                case 'i' : {
                    clear();
                    new InventoryMethods(player,displayInventory(player));
                }
                case '1','&': {
                    clear();
                    event40();
                }
                case '2','é': {
                    event361();
                    clear();
                }
                default: System.exit(1);
            }
        }while(true);


    }
    public static void event6() throws IOException {
        player.setCurrentEvent(6);
        displayEvent6();
        initStuffSpell(6);
        new HUD(player);
        do{
            inChar = readChar();
            switch (inChar){
                case 'i':{
                    clear();
                    new InventoryMethods(player,displayInventory(player));
                }
                case 'x':{
                    clear();
                    event367();
                }
            }
        }while(true);

    }
    public static void event7() throws IOException {
        player.setCurrentEvent(7);
        displayEvent7();
        initStuffSpell(7);
        new HUD(player);
        do{
            inChar = readChar();
            switch (inChar){
                case 'i' : {
                    clear();
                    new InventoryMethods(player,displayInventory(player));
                }
                case '1' ,'&': {
                    clear();
                    event268();
                }
                case '2' ,'é':{
                    clear();
                    event116();
                }
                default: continue;
            }
        }while(true);

    }
    public static void event8() throws IOException {
        player.setCurrentEvent(8);
        displayEvent8();
        initStuffSpell(8);
        new HUD(player);
        do{
            inChar = readChar();
            switch (inChar){
                case 'i' : {
                    clear();
                    new InventoryMethods(player,displayInventory(player));
                }
                case 'x' : {
                    clear();
                    event218();
                }
            }
        }while (true);

    }
    public static void event9() throws IOException {
        player.setCurrentEvent(9);
        displayEvent9();
        initStuffSpell(9);
        new HUD(player);
        do {
            inChar = readChar();
            switch (inChar){
                case 'i' : {
                    clear();
                    new InventoryMethods(player,displayInventory(player));
                }
                case 'x' : {
                    clear();
                    event31();
                }
                default:continue;
            }
        }while(true);

    }
    public static void event10() throws IOException {
        player.setCurrentEvent(10);
        initStuffSpell(10);
        new HUD(player);
        do {
            inChar = readChar();
            switch (inChar){
                case 'i' : {
                    clear();
                    new InventoryMethods(player,displayInventory(player));
                }
                case 'x' : {
                    clear();
                    event249();
                }
                default: continue;
            }

        }while(true);

    }

    public static void event11() throws IOException {
        player.setCurrentEvent(11);
        initStuffSpell(11);
        displayEvent10();
        do {
            inChar = readChar();
            switch (inChar){
                case 'i' : {
                    clear();
                    new InventoryMethods(player,displayInventory(player));
                }

                case 'x' : {
                    clear();
                    event16(); break;
                }

                default: continue;
            }
        }while (true);
    }
    public static void event12() throws IOException {
        switch (choice){
            case 1: event274();  break;
            case 2: event335(); break;
            case 3: event78(); break;
            default: System.exit(1);
        }
    }
    public static void event13() throws IOException {
        switch (choice){
            case 1: event302(); break;
            case 2: event215(); break;
            default: System.exit(1);
        }
    }
    public static void event14() throws IOException {
        switch(choice) {
            case 1: event79(); break;
            case 2: event100(); break;
            default: System.exit(1);
        }
    }
    public static void event15() throws IOException {
        event245();
    }
    public static void event16() throws IOException {
        //todo ici combat GARK 7/11

        switch(choice) {
            case 1: event99(); break;
            case 2: event180(); break;
            default: System.exit(1);
        }
    }
    public static void event17() throws IOException {
        event93();
    }
    public static void event18() throws IOException {
        switch (choice){
            case 1: event31(); break;
            case 2: event84(); break;
            default: System.exit(1);
        }
    }
    public static void event19() throws IOException {
        switch(choice){
            case 1: event363(); break;
            case 2: event254(); break;
            default: System.exit(1);
        }
    }
    public static void event20() throws IOException {
        switch(choice) {
            case 1: event96(); break;
            case 2: event288(); break;
            default: System.exit(1);
        }
    }

    public static void event21() throws IOException {
        event6();
    }
    public static void event22() throws IOException {
        event188();
    }
    public static void event23() throws IOException {
        event169();
    }
    public static void event24() throws IOException {
        switch (choice){
            case 1: event372(); break;
            case 2: event219(); break;
            default: System.exit(1);
        }
    }
    public static void event25() throws IOException {
        switch (choice){
            case 1: event239(); break;
            case 2: event206(); break;
            case 3: event133(); break;
            default: System.exit(1);
        }
    }
    public static void event26() throws IOException {
        switch (choice){
            case 1: event87(); break;
            case 2: event345(); break;
            case 3: event304(); break;
            case 4: event101(); break;
            default: System.exit(1);
        }
    }
    public static void event27() throws IOException {
        event206();
    }
    public static void event28() throws IOException {
        switch (choice){
            case 1: event2(); break;
            case 2: event243(); break;
            default: System.exit(1);
        }
    }
    public static void event29() throws IOException {
        switch (choice){
            case 1: event271(); break;
            case 2: event131(); break;
            default: System.exit(1);
        }
    }
    public static void event30() throws IOException {
        event241();
    }

    public static void event31() throws IOException {
        event169();
    }
    public static void event32() throws IOException {
        event251();
    }
    public static void event33() throws IOException {
        event213();
    }
    public static void event34() throws IOException {
        switch (choice){
            case 1: event237(); break;
            case 2: event89(); break;
            default: System.exit(1);
        }
    }
    public static void event35() throws IOException {
        switch (choice){
            case 1: event364(); break;
            case 2: event246(); break;
            default: System.exit(1);
        }
    }
    public static void event36() throws IOException {
        event99();
    }
    public static void event37() throws IOException {
        event229();
    }
    public static void event38() throws IOException {
        switch (choice){
            case 1: event306(); break;
            case 2: event132(); break;
            default: System.exit(1);
        }
    }
    public static void event39() throws IOException {
        /*todo combat contre Homme-Araignée 7/5
        si victoire sans touché 248 sinon 208
         */
    }
    public static void event40() throws IOException {
        switch(choice) {
            case 1: event243(); break;
            case 2: event2(); break;
            default: System.exit(1);
        }
    }

    public static void event41() throws IOException {
        event257();
    }
    public static void event42() throws IOException {
        switch (choice){
            case 1: event138(); break;
            case 2: event91(); break;
            case 3: event223(); break;
            default: System.exit(1);
        }
    }
    public static void event43() throws IOException {
        event14();
    }
    public static void event44() throws IOException {
        switch (choice){
            case 1: event353(); break;
            case 2: event277(); break;
            default: System.exit(1);
        }
    }
    public static void event45() throws IOException {
        switch (choice){
            case 1: event166(); break;
            case 2: event313(); break;
            case 3: event253(); break;
            case 4: event97(); break;
            default: System.exit(1);
        }
    }
    public static void event46() throws IOException {
        switch (choice){
            case 1: event195(); break;
            case 2: event74(); break;
            default: System.exit(1);
        }
    }
    public static void event47() throws IOException {
        switch (choice){
            case 1: event8(); break;
            case 2: event173(); break;
            case 3: event259(); break;
            case 4: event209(); break;
            default: System.exit(1);
        }
    }
    public static void event48() throws IOException {
        switch (choice){
            case 1: event199(); break;
            case 2: event232(); break;
            default: System.exit(1);
        }
    }
    public static void event49() throws IOException {
        event255();
    }
    public static void event50() throws IOException {
        event164();
    }

    public static void event51() throws IOException {
        switch (choice){
            case 1: event159(); break;
            case 2: event301(); break;
            case 3: event280(); break;
            default: System.exit(1);
        }
    }
    public static void event52() throws IOException {
        switch (choice){
            case 1: event385(); break;
            case 2: event227(); break;
            default: System.exit(1);
        }
    }
    public static void event53() throws IOException {
        event194();
    }
    public static void event54() throws IOException {

        switch (choice){
            case 1: event287(); break;
            case 2: event160(); break;
            case 3: event27(); break;
            default: System.exit(1);
        }
    }
    public static void event55() throws IOException {
        switch (choice){
            case 1: event10(); break;
            case 2: event249(); break;
            default: System.exit(1);
        }
    }
    public static void event56() throws IOException {
        switch (choice){
            case 1: event120(); break;
            case 2: event163(); break;
            case 3: event334(); break;
            default: System.exit(1);
        }
    }
    public static void event57() throws IOException {
        switch (choice){
            case 1: event150(); break;
            case 2: event233(); break;
            default: System.exit(1);
        }
    }
    public static void event58() throws IOException {
        switch (choice){
            case 1: event92(); break;
            case 2: event298(); break;
            case 3: event267(); break;
            case 4: event156(); break;
            default: System.exit(1);
        }
    }
    public static void event59() throws IOException {
        event140();
    }
    public static void event60() throws IOException {
        switch (choice){
            case 1: event213(); break;
            case 2: event33(); break;
            case 3: event295(); break;
            default: System.exit(1);
        }
    }

    public static void event61() throws IOException {
        //game over
    }
    public static void event62() throws IOException {
        event140();
    }
    public static void event63() throws IOException {
        switch (choice){
            case 1: event263(); break;
            case 2: event135(); break;
            default: System.exit(1);
        }
    }
    public static void event64() throws IOException {
        switch (choice){
            case 1: event3(); break;
            case 2: event286(); break;
            case 3: event366(); break;
            default: System.exit(1);
        }
    }
    public static void event65() throws IOException {
        //game over
    }

    public static void event66() throws IOException {
        event270();
    }
    public static void event67() throws IOException {
        switch (choice){
            case 1: event143(); break;
            case 2: event226(); break;
            default: System.exit(1);
        }
    }
    public static void event68() throws IOException {
        switch (choice){
            case 1: event207(); break;
            case 2: event22(); break;
            case 3: event354(); break;
            default: System.exit(1);
        }
    }
    public static void event69() throws IOException {
        event193();
    }
    public static void event70() throws IOException {
        switch (choice){
            case 1: event307(); break;
            case 2: event264(); break;
            case 3: event325(); break;
            default: System.exit(1);
        }
    }

    public static void event71() throws IOException {
        event218();
    }
    public static void event72() throws IOException {
        //game over
    }
    public static void event73() throws IOException {
        /*
        todo combat boa 6/7
        victoire 112 - formule de force +3 att
         */


        switch(choice){
            case 1: event112(); break;
            default: System.exit(1);
        }
    }
    public static void event74() throws IOException {
        event377();
    }
    public static void event75() throws IOException {
        event40();
    }
    public static void event76() throws IOException {
        event191();
    }
    public static void event77() throws IOException {
        switch (choice){
            case 1: event349(); break;
            case 2: event46(); break;
            case 3: event187(); break;
            default: System.exit(1);
        }
    }
    public static void event78() throws IOException {
        switch (choice){
            case 1: event277(); break;
            case 2: event124(); break;
            case 3: event324(); break;
            default: System.exit(1);
        }
    }
    public static void event79() throws IOException {
        event218();
    }
    public static void event80() throws IOException {
        event199();
    }

    public static void event81() throws IOException {
        event251();
    }
    public static void event82() throws IOException {
        //game over
    }
    public static void event83() throws IOException {
        event245();
    }
    public static void event84() throws IOException {
        event234();
    }
    public static void event85() throws IOException {
        switch (choice){
            case 1: event395(); break;
            case 2: event248(); break;
            case 3: event322(); break;
            default: System.exit(1);
        }
    }
    public static void event86() throws IOException {
        event251();
    }
    public static void event87() throws IOException {
        event64();
    }
    public static void event88() throws IOException {
        switch (choice){
            case 1: event292(); break;
            case 2: event170(); break;
            case 3: event64(); break;
            case 4: event304(); break;
            default: System.exit(1);
        }
    }
    public static void event89() throws IOException {
        event237();
    }
    public static void event90() throws IOException {
        switch (choice){
            case 1: event176(); break;
            case 2: event21(); break;
            case 3: event329(); break;
            default: System.exit(1);
        }
    }

    public static void event91() throws IOException {
        event140();
    }
    public static void event92() throws IOException {
        event156();
    }
    public static void event93() throws IOException {
        event169();
    }
    public static void event94() throws IOException {
        event118();
    }
    public static void event95() throws IOException {
        event367();
    }
    public static void event96() throws IOException {
        event251();
    }
    public static void event97() throws IOException {
        switch (choice){
            case 1: event13(); break;
            case 2: event281(); break;
            default: System.exit(1);
        }
    }
    public static void event98() throws IOException {
        switch (choice){
            case 1: event303(); break;
            case 2: event4(); break;
            case 3: event190(); break;
            default: System.exit(1);
        }
    }
    public static void event99() throws IOException {
        switch (choice){
            case 1: event52(); break;
            case 2: event38(); break;
            default: System.exit(1);
        }
    }
    public static void event100() throws IOException {
        switch (choice){
            case 1: event79(); break;
            case 2: event276(); break;
            default: System.exit(1);
        }
    }

    public static void event101() throws IOException {
        switch (choice){
            case 1: event64(); break;
            case 2: event62(); break;
            default: System.exit(1);
        }
    }

    public static void event102() throws IOException {
        switch (choice){
            case 1: event183(); break;
            case 2: event396(); break;
            case 3: event270(); break;
            default: System.exit(1);
        }
    }

    public static void event103() throws IOException {
        //game over
    }
    public static void event104() throws IOException {
        switch (choice){
            case 1: event25(); break;
            case 2: event266(); break;
            case 3: event310(); break;
            case 4: event54(); break;
            default: System.exit(1);
        }
    }
    public static void event105() throws IOException {
        event95();
    }
    public static void event106() throws IOException {
        event218();
    }
    public static void event107() throws IOException {
        event184();
    }
    public static void event108() throws IOException {
        event73();
    }
    public static void event109() throws IOException {
        event30();
    }
    public static void event110() throws IOException {
        switch (choice){
            case 1: event288(); break;
            case 2: event251(); break;
            default: System.exit(1);
        }
    }

    public static void event111() throws IOException {
        switch (choice){
            case 1: event347(); break;
            case 2: event153(); break;
            default: System.exit(1);
        }
    }
    public static void event112() throws IOException {
        event212();
    }
    public static void event113() throws IOException {
        switch (choice){
            case 1: event388(); break;
            case 2: event145(); break;
            default: System.exit(1);
        }
    }
    public static void event114() throws IOException {
        event218();
    }
    public static void event115() throws IOException {
        event373();
    }
    public static void event116() throws IOException {
        event210();
    }
    public static void event117() throws IOException {
        event337();
    }
    public static void event118() throws IOException {
        switch (choice){
            case 1: event273(); break;
            case 2: event198(); break;
            default: System.exit(1);
        }
    }
    public static void event119() {
        //game over
    }
    public static void event120() throws IOException {
        event95();
    }

    public static void event121() throws IOException {
        event257();
    }
    public static void event122() throws IOException {
        event47();
    }
    public static void event123() throws IOException {
        switch (choice){
            case 1: event211(); break;
            case 2: event35(); break;
            case 3: event283(); break;
            default: System.exit(1);
        }
    }
    public static void event124() throws IOException {
        event400();
    }
    public static void event125() throws IOException {
        //chance ou -5pv
        event209();
    }
    public static void event126() throws IOException {
        event316();
    }
    public static void event127() throws IOException {
        switch (choice){
            case 1: event53(); break;
            case 2: event387(); break;
            case 3: event240(); break;
            case 4: event194(); break;
            default: System.exit(1);
        }
    }
    public static void event128() throws IOException {
        switch (choice){
            case 1: event262(); break;
            case 2: event36(); break;
            case 3: event152(); break;
            case 4: event336(); break;
            default: System.exit(1);
        }
    }
    public static void event129() throws IOException {
        switch (choice){
            case 1: event260(); break;
            case 2: event370(); break;
            default: System.exit(1);
        }
    }
    public static void event130() throws IOException {
        event333();
    }

    public static void event131() throws IOException {
        event348();
    }
    public static void event132() throws IOException {
        switch (choice){
            case 1: event18(); break;
            case 2: event238(); break;
            case 3: event375(); break;
            default: System.exit(1);
        }
    }
    public static void event133() throws IOException {
        switch (choice){
            case 1: event82(); break;
            case 2: event206(); break;
            default: System.exit(1);
        }
    }
    public static void event134() throws IOException {
        switch (choice){
            case 1: event169(); break;
            case 2: event60(); break;
            case 3: event245(); break;
            default: System.exit(1);
        }
    }
    public static void event135() throws IOException {
        event326();
    }
    public static void event136() throws IOException {
        switch (choice){
            case 1: event17(); break;
            case 2: event167(); break;
            case 3: event389(); break;
            default: System.exit(1);
        }
    }
    public static void event137() throws IOException {
        switch (choice){
            case 1: event14(); break;
            case 2: event383(); break;
            default: System.exit(1);
        }
    }
    public static void event138() throws IOException {
        switch (choice){
            case 1: event64(); break;
            case 2: event376(); break;
            default: System.exit(1);
        }
    }
    public static void event139() throws IOException {
        switch (choice){
            case 1: event244(); break;
            case 2: event346(); break;
            case 3: event28(); break;
            default: System.exit(1);
        }
    }
    public static void event140() throws IOException {
        switch (choice){
            case 1: event25(); break;
            case 2: event104(); break;
            default: System.exit(1);
        }
    }

    public static void event141() throws IOException {
        event156();
    }
    public static void event142() throws IOException {
        event234();
    }
    public static void event143() throws IOException {
        switch (choice){
            case 1: event360(); break;
            case 2: event184(); break;
            case 3: event226(); break;
            default: System.exit(1);
        }
    }
    public static void event144() throws IOException {
        switch (choice){
            case 1: event154(); break;
            case 2: event56(); break;
            default: System.exit(1);
        }
    }
    public static void event145() throws IOException {
        switch (choice){
            case 1: event157(); break;
            case 2: event80(); break;
            default: System.exit(1);
        }
    }
    public static void event146() throws IOException {
        switch (choice){
            case 1: event247(); break;
            case 2: event201(); break;
            case 3: event102(); break;
            case 4: event66(); break;
            default: System.exit(1);
        }
    }
    public static void event147() throws IOException {
        switch (choice){
            case 1: event260(); break;
            case 2: event129(); break;
            case 3: event370(); break;
            default: System.exit(1);
        }
    }
    public static void event148() throws IOException {
        //game over
    }
    public static void event149() throws IOException {
        switch (choice){
            case 1: event245(); break;
            case 2: event380(); break;
            case 3: event209(); break;
            default: System.exit(1);
        }
    }
    public static void event150() throws IOException {
        event374();
    }

    public static void event151() throws IOException{
        switch (choice){
            case 1: event197(); break;
            case 2: event19(); break;
            default: System.exit(1);
        }
    }
    public static void event152() throws IOException {
        event180();
    }
    public static void event153() throws IOException {
        //game over
    }
    public static void event154() throws IOException {
        switch (choice){
            case 1: event56(); break;
            case 2: event275(); break;
            default: System.exit(1);
        }
    }
    public static void event155() throws IOException {
        event65();
    }
    public static void event156() throws IOException {
        switch (choice){
            case 1: event71(); break;
            case 2: event284(); break;
            case 3: event114(); break;
            default: System.exit(1);
        }
    }
    public static void event157() throws IOException {
        switch (choice){
            case 1: event199(); break;
            case 2: event232(); break;
            default: System.exit(1);
        }
    }
    public static void event158() throws IOException {
        event77();
    }
    public static void event159() throws IOException {
        event323();
    }
    public static void event160() throws IOException {
        event206();
    }

    public static void event161() throws IOException {
        switch (choice){
            case 1: event390(); break;
            case 2: event106(); break;
            default: System.exit(1);
        }
    }
    public static void event162() throws IOException {
        event32();
    }
    public static void event163() throws IOException {
        event95();
    }
    public static void event164() throws IOException {
        //game over
    }
    public static void event165() throws IOException {
        switch (choice){
            case 1: event202(); break;
            case 2: event398(); break;
            default: System.exit(1);
        }
    }
    public static void event166() throws IOException {
        switch (choice){
            case 1: event13(); break;
            case 2: event281(); break;
            default: System.exit(1);
        }

    }
    public static void event167() throws IOException {
        switch (choice){
            case 1: event331(); break;
            case 2: event224(); break;
            default: System.exit(1);
        }
    }
    public static void event168() throws IOException {
        event328();
    }
    public static void event169() throws IOException {
        switch (choice){
            case 1: event19(); break;
            case 2: event197(); break;
            case 3: event317(); break;
            case 4: event151(); break;
            default: System.exit(1);
        }
    }
    public static void event170() throws IOException {
        switch (choice){
            case 1: event292(); break;
            case 2: event64(); break;
            case 3: event304(); break;
            default: System.exit(1);
        }
    }

    public static void event171() throws IOException {
        switch (choice){
            case 1: event278(); break;
            case 2: event31(); break;
            case 3: event365(); break;
            default: System.exit(1);
        }
    }
    public static void event172() throws IOException {
        switch (choice){
            case 1: event26(); break;
            case 2: event289(); break;
            default: System.exit(1);
        }
    }
    public static void event173() throws IOException {
        event218();
    }
    public static void event174() throws IOException {
        switch (choice){
            case 1: event116(); break;
            case 2: event268(); break;
            default: System.exit(1);
        }
    }
    public static void event175() throws IOException {
        event110();
    }
    public static void event176() throws IOException {
        switch (choice){
            case 1: event127(); break;
            case 2: event21();  break;
            case 3: event329(); break;
            default: System.exit(1);
        }
    }
    public static void event177() throws IOException {
        switch (choice){
            case 1: event5(); break;
            case 2: event344(); break;
            default: System.exit(1);
        }
    }
    public static void event178() throws IOException {
        switch (choice){
            case 1: event17();  break;
            case 2: event265();  break;
            default: System.exit(1);
        }
    }
    public static void event179() throws IOException {
        switch (choice){
            case 1: event378(); break;
            case 2: event125(); break;
            case 3: event341(); break;
            default: System.exit(1);
        }
    }
    public static void event180() throws IOException {
        event99();
    }

    public static void event181() throws IOException {
        switch (choice) {
            case 1: event54(); break;
            case 2: event25(); break;
            default: System.exit(1);
        }
    }
    public static void event182() throws IOException {
        switch (choice){
            case 1: event85(); break;
            case 2: event395(); break;
            case 3: event322(); break;
            case 4: event248(); break;
            default: System.exit(1);
        }
    }

    public static void event183() throws IOException {
        event270();
    }
    public static void event184() throws IOException {
        //game over
    }
    public static void event185() throws IOException {
        event13();
    }
    public static void event186() throws IOException {
        switch (choice){
            case 1: event155(); break;
            case 2: event83(); break;
            case 3: event245(); break;
            default: System.exit(1);
        }
    }
    public static void event187() throws IOException {
        switch (choice){
            case 1: event279(); break;
            case 2: event314(); break;
            case 3: event115(); break;
            default: System.exit(1);
        }
    }
    public static void event188() throws IOException {
        switch (choice) {
            case 1: event301(); break;
            case 2: event159(); break;
            case 3: event51(); break;
            default: System.exit(1);
        }
    }
    public static void event189() throws IOException {
        switch (choice){
            case 1: event319(); break;
            case 2: event130(); break;
            case 3: event43(); break;
            default: System.exit(1);
        }
    }
    public static void event190() throws IOException {
        event147();
    }

    public static void event191() {
        event119();
    }
    public static void event192() throws IOException {
        event29();
    }
    public static void event193() throws IOException {
        switch (choice){
            case 1: event211(); break;
            case 2: event123(); break;
            case 3: event35(); break;
            case 4: event283(); break;
            default: System.exit(1);
        }
    }
    public static void event194() {
        //game over
    }
    public static void event195() throws IOException {
        event377();
    }
    public static void event196() throws IOException {
        switch (choice){
            case 1: event45(); break;
            case 2: event13(); break;
            case 3: event281(); break;
            default: System.exit(1);
        }
    }
    public static void event197() throws IOException {
        event363();
    }
    public static void event198() throws IOException {
        switch (choice){
            case 1: event177(); break;
            case 2: event290(); break;
            default: System.exit(1);
        }
    }
    public static void event199() {
        //game over
    }
    public static void event200() throws IOException {
        switch (choice){
            case 1: event237(); break;
            case 2: event98(); break;
            default: System.exit(1);
        }
    }

    public static void event201() throws IOException {
        event270();
    }
    public static void event202() throws IOException {
        //Game Over
    }
    public static void event203() throws IOException {
        switch (choice){
            case 1: event203(); break;
            case 2: event11(); break;
            default: System.exit(1);
        }
    }
    public static void event204() throws IOException {
        event73();
    }
    public static void event205() throws IOException {
        switch (choice){
            case 1: event368(); break;
            case 2: event309(); break;
            default: System.exit(1);
        }
    }
    public static void event206() throws IOException {
        event182();
    }
    public static void event207() throws IOException {
        event188();
    }
    public static void event208() {
        //game over
    }
    public static void event209() throws IOException {
        switch (choice){
            case 1: event362(); break;
            case 2: event156(); break;
            default: System.exit(1);
        }
    }
    public static void event210() throws IOException {
        switch (choice){
            case 1: event192(); break;
            case 2: event359(); break;
            default: System.exit(1);
        }
    }

    public static void event211() throws IOException {
        switch (choice){
            case 1: event123(); break;
            case 2: event35(); break;
            case 3: event283(); break;
            default: System.exit(1);
        }
    }
    public static void event212() throws IOException {
        event90();
    }
    public static void event213() throws IOException {
        switch (choice){
            case 1: event235(); break;
            case 2: event209(); break;
            default: System.exit(1);
        }
    }
    public static void event214() throws IOException {
        event62();
    }
    public static void event215() throws IOException {
        switch (choice){
            case 1: event136(); break;
            case 2: event41(); break;
            default: System.exit(1);
        }
    }
    public static void event216() throws IOException {
        switch (choice){
            case 1: event294(); break;
            case 2: event391(); break;
            case 3: event36(); break;
            default: System.exit(1);
        }
    }
    public static void event217() throws IOException {
        switch (choice){
            case 1: event293(); break;
            case 2: event57(); break;
            default: System.exit(1);
        }
    }
    public static void event218() throws IOException {
        switch (choice){
            case 1: event118(); break;
            case 2: event94(); break;
            default: System.exit(1);
        }
    }
    public static void event219() throws IOException {
        event95();
    }
    public static void event220() throws IOException {
        switch (choice){
            case 1: event243(); break;
            case 2: event2(); break;
            default: System.exit(1);
        }
    }

    public static void event221() throws IOException {
        event127();
    }
    public static void event222() throws IOException {
        switch (choice){
            case 1: event137(); break;
            case 2: event14(); break;
            default: System.exit(1);
        }
    }
    public static void event223() throws IOException {
        event138();
    }
    public static void event224() throws IOException {
        event265();
    }
    public static void event225() throws IOException {
        switch (choice){
            case 1: event15(); break;
            case 2: event245(); break;
            default: System.exit(1);
        }
    }
    public static void event226() throws IOException {
        switch (choice){
            case 1: event184(); break;
            case 2: event312(); break;
            case 3: event37(); break;
            case 4: event384(); break;
            default: System.exit(1);
        }
    }
    public static void event227() throws IOException {
        event234();
    }
    public static void event228() throws IOException {
        switch (choice){
            case 1: event88(); break;
            case 2: event170(); break;
            case 3: event296(); break;
            default: System.exit(1);
        }
    }
    public static void event229() throws IOException {
        switch (choice){
            case 1: event217(); break;
            case 2: event164(); break;
            case 3: event50(); break;
            default: System.exit(1);
        }
    }
    public static void event230() throws IOException {
        switch (choice){
            case 1: event288(); break;
            case 2: event96(); break;
            default: System.exit(1);
        }
    }

    public static void event231() throws IOException {
        switch (choice){
            case 1: event196(); break;
            case 2: event243(); break;
            default: System.exit(1);
        }
    }
    public static void event232() throws IOException {
        switch (choice){
            case 1: event111(); break;
            case 2: event72(); break;
            default: System.exit(1);
        }
    }
    public static void event233() throws IOException {
        event374();
    }
    public static void event234() throws IOException {
        switch (choice){
            case 1: event397(); break;
            case 2: event69(); break;
            default: System.exit(1);
        }
    }
    public static void event235() throws IOException {
        switch (choice){
            case 1: event245(); break;
            case 2: event269(); break;
            default: System.exit(1);
        }
    }
    public static void event236() throws IOException {
        event140();
    }
    public static void event237() throws IOException {
        event169();
    }
    public static void event238() throws IOException {
        switch (choice){
            case 1: event31(); break;
            case 2: event18(); break;
            case 3: event375(); break;
            default: System.exit(1);
        }
    }
    public static void event239() throws IOException {
        switch (choice){
            case 1: event379(); break;
            case 2: event82(); break;
            default: System.exit(1);
        }
    }

    public static void event240() throws IOException {
        event6();
    }

    public static void event241() throws IOException {
        event77();
    }
    public static void event242() throws IOException {
        switch (choice){
            case 1: event24(); break;
            case 2: event105(); break;
            default: System.exit(1);
        }
    }
    public static void event243() throws IOException {
        switch (choice){
            case 1: event2(); break;
            case 2: event352(); break;
            default: System.exit(1);
        }
    }
    public static void event244() throws IOException {
        switch (choice){
            case 1: event243(); break;
            case 2: event2(); break;
            default: System.exit(1);
        }
    }
    public static void event245() throws IOException {
        switch (choice){
            case 1: event161(); break;
            case 2: event390(); break;
            case 3: event47(); break;
            default: System.exit(1);
        }
    }
    public static void event246() throws IOException {
        event174();
    }
    public static void event247() throws IOException {
        event234();
    }
    public static void event248() throws IOException {
        switch (choice){
            case 1: event103(); break;
            case 2: break; //game over
            default: System.exit(1);
        }
    }
    public static void event249() throws IOException {
        switch (choice){
            case 1: event392(); break;
            case 2: event231(); break;
            default: System.exit(1);
        }
    }

    public static void event250() throws IOException {
        //game over
    }
    public static void event251() throws IOException {
        switch (choice){
            case 1: event222(); break;
            case 2: event179(); break;
            case 3: event321(); break;
            default: System.exit(1);
        }
    }
    public static void event252() throws IOException {
        event229();
    }
    public static void event253() throws IOException {
        switch (choice){
            case 1: event13(); break;
            case 2: event281(); break;
            default: System.exit(1);
        }
    }
    public static void event254() throws IOException {
        event197();
    }
    public static void event255() throws IOException {
        switch (choice){
            case 1: event198(); break;
            case 2: event290(); break;
            default: System.exit(1);
        }
    }
    public static void event256() throws IOException {
        switch (choice){
            case 1: event155(); break;
            case 2: event65(); break;
            default: System.exit(1);
        }
    }
    public static void event257() throws IOException {
        switch (choice){
            case 1: event237(); break;
            case 2: event357(); break;
            case 3: event200(); break;
            default: System.exit(1);
        }
    }
    public void event258() throws IOException {
        switch (choice){
            case 1: event140(); break;
            case 2: event366(); break;
            default: System.exit(1);
        }
    }
    public static void event259() throws IOException {
        event218();
    }
    public static void event260() throws IOException {
        switch (choice){
            case 1: event34(); break;
            case 2: event299(); break;
            default: System.exit(1);
        }
    }

    public static void event261() throws IOException {
        System.out.println("Event 261");
        switch (choice){
            case 1: event81(); break;
            case 2: event394(); break;
            case 3: event175(); break;
            default: System.exit(1);
        }
    }
    public static void event262() throws IOException {
        event180();
    }
    public static void event263() throws IOException {
        event326();
    }
    public static void event264() throws IOException {
        Combat cmb = player.getCombat();
        Monster m = cmb.getMonster();
        while(!m.isDead() || !player.isDead()){
            cmb.fight(Dice.doubleDice(),Dice.tripleDice());
        }
        if (player.getCurrentVitality()==0){
            //todo gameover
        }
        event177();
    }
    public static void event265() throws IOException {
        event169();
    }
    public static void event266() throws IOException {
        switch (choice){
            case 1: event54(); break;
            case 2: event310(); break;
            default: System.exit(1);
        }
    }
    public static void event267() throws IOException {
        event156();
    }
    public static void event268() throws IOException {
        event210();
    }
    public static void event269() throws IOException {
        switch (choice){
            case 1: event205(); break;
            case 2: event186(); break;
            case 3: event225(); break;
            default: System.exit(1);
        }
    }
    public static void event270() throws IOException {
        switch (choice){
            case 1: event185(); break;
            case 2: event23(); break;
            default: System.exit(1);
        }
    }

    public static void event271() throws IOException {
        switch (choice){
            case 1: event348(); break;
            case 2: event131(); break;
            default: System.exit(1);
        }
    }
    public static void event272() throws IOException {
        switch (choice) {
            case 1: event95(); break;
            case 2: event242(); break;
            default: System.exit(1);
        }
    }
    public static void event273() throws IOException {
        switch (choice){
            case 1: event49(); break;
            case 2: event255(); break;
            case 3: event371(); break;
            default: System.exit(1);
        }
    }
    public static void event274() throws IOException {
        switch (choice){
            case 1: event353(); break;
            case 2: event277(); break;
            default: System.exit(1);
        }
    }
    public static void event275() throws IOException {
        switch (choice){
            case 1: event272(); break;
            case 2: event399(); break;
            default: System.exit(1);
        }
    }
    public static void event276() throws IOException {
        switch (choice){
            case 1: event165(); break;
            case 2: event202(); break;
            default: System.exit(1);
        }
    }
    public static void event277() throws IOException {
        switch (choice){
            case 1: event330(); break;
            case 2: event315(); break;
            case 3: event76(); break;
            case 4: event119(); break;
            default: System.exit(1);
        }
    }
    public static void event278() throws IOException {
        switch (choice){
            case 1: event365(); break;
            case 2: event171(); break;
            case 3: event31(); break;
            default: System.exit(1);
        }
    }
    public static void event279() throws IOException {
        switch (choice){
            case 1: event44(); break;
            case 2: event318(); break;
            case 3: event78(); break;
            case 4: event335(); break;
            default: System.exit(1);
        }
    }
    public static void event280() throws IOException {
        event323();
    }

    public static void event281() throws IOException {
        switch (choice){
            case 1: event382(); break;
            case 2: event285(); break;
            case 3: event256(); break;
            default: System.exit(1);
        }
    }
    public static void event282() throws IOException {
        event212();
    }
    public static void event283() throws IOException {
        //game over
    }
    public static void event284() throws IOException {
        switch (choice){
            case 1: event71(); break;
            case 2: event114(); break;
            default: System.exit(1);
        }
    }
    public static void event285() throws IOException {
        switch (choice){
            case 1: event23(); break;
            case 2: event185(); break;
            default: System.exit(1);
        }
    }
    public static void event286() throws IOException {
        event140();
    }
    public static void event287() throws IOException {
        switch (choice){
            case 1: event25(); break;
            case 2: event27(); break;
            case 3: event160(); break;
            default: System.exit(1);
        }
    }
    public static void event288() throws IOException {
        switch (choice){
            case 1: event86(); break;
            case 2: event162(); break;
            case 3: event32(); break;
            default: System.exit(1);
        }
    }
    public static void event289() throws IOException {
        switch (choice){
            case 1: event340(); break;
            case 2: event214(); break;
            case 3: event305(); break;
            case 4: event304(); break;
            default: System.exit(1);
        }

    }
    public static void event290() throws IOException {
        switch (choice){
            case 1: event325(); break;
            case 2: event307(); break;
            case 3: event70(); break;
            case 4: event264(); break;
            default: System.exit(1);
        }
    }

    public static void event291() throws IOException {
        event328();
    }
    public static void event292() throws IOException {
        switch (choice){
            case 1: event376(); break;
            case 2: event42(); break;
            case 3: event64(); break;
            default: System.exit(1);
        }
    }
    public static void event293() throws IOException {
        event374();
    }
    public static void event294() throws IOException {
        event99();
    }
    public static void event295() throws IOException {
        event213();
    }
    public static void event296() throws IOException {
        event292();
    }
    public static void event297() throws IOException {
        switch (choice){
            case 1: event2(); break;
            case 2: event316(); break;
            case 3: event75(); break;
            default: System.exit(1);
        }
    }
    public static void event298() throws IOException {
        switch (choice){
            case 1: event58(); break;
            case 2: event141(); break;
            default: System.exit(1);
        }
    }
    public static void event299() throws IOException {
        event237();
    }
    public static void event300() throws IOException {
        switch (choice){
            case 1: event244(); break;
            case 2: event346(); break;
            default: System.exit(1);
        }
    }
    public static void event301() throws IOException {
        event323();
    }
    public static void event302() throws IOException {
        event169();
    }
    public static void event303() throws IOException {
        event169();
    }
    public static void event304() throws IOException {
        switch (choice){
            case 1: event172(); break;
            case 2: event26(); break;
            case 3: event289(); break;
            default: System.exit(1);
        }
    }
    public static void event305() throws IOException {
        event64();
    }
    public static void event306() throws IOException {
        switch (choice){
            case 1: event132(); break;
            case 2: event52(); break;
            default: System.exit(1);
        }
    }
    public static void event307() throws IOException {
        event177();
    }
    public static void event308() throws IOException {
        event257();
    }
    public static void event309() throws IOException {
        switch (choice){
            case 1: event15(); break;
            case 2: event245(); break;
            default: System.exit(1);
        }
    }
    public static void event310() throws IOException {
        switch (choice){
            case 1: event181(); break;
            case 2: event250(); break;
            case 3: event393(); break;
            default: System.exit(1);
        }
    }

    public static void event311() throws IOException {
        switch (choice){
            case 1: event61(); break;
            case 2: event178(); break;
            default: System.exit(1);
        }
    }
    public static void event312() throws IOException {
        event184();
    }
    public static void event313() throws IOException {
        switch (choice){
            case 1: event13(); break;
            case 2: event281(); break;
            default: System.exit(1);
        }
    }
    public static void event314() throws IOException {
        event191();
    }
    public static void event315() throws IOException {
        event191();
    }
    public static void event316() throws IOException {
        switch (choice){
            case 1: event220(); break;
            case 2: event139(); break;
            case 3: event300(); break;
            default: System.exit(1);
        }
    }
    public static void event317() throws IOException {
        switch (choice){
            case 1: event197(); break;
            case 2: event19(); break;
            default: System.exit(1);
        }
    }
    public static void event318() throws IOException {
        switch (choice){
            case 1: event381(); break;
            case 2: event117(); break;
            case 3: event277(); break;
            default: System.exit(1);
        }
    }
    public static void event319() throws IOException {
        event333();
    }
    public static void event320() throws IOException {
        switch (choice){
            case 1: event113(); break;
            case 2: event332(); break;
            case 3: event351(); break;
            default: System.exit(1);
        }
    }

    public static void event321() throws IOException {
        switch (choice){
            case 1: event269(); break;
            case 2: event339(); break;
            default: System.exit(1);
        }
    }
    public static void event322() throws IOException {
        switch (choice){
            case 1: event39(); break;
            case 2: event168(); break;
            case 3: event291(); break;
            default: System.exit(1);
        }
    }
    public static void event323() throws IOException {
        switch (choice){
            case 1: event386(); break;
            case 2: event144(); break;
            case 3: event338(); break;
            default: System.exit(1);
        }
    }
    public static void event324() {
        event369();
    }
    public static void event325() throws IOException {
        event177();
    }
    public static void event326() throws IOException {
        switch (choice) {
            case 1: event84(); break;
            case 2: event31(); break;
            default: System.exit(1);
        }
    }
    public static void event327() throws IOException {
        event366();
    }
    public static void event328() throws IOException {
        switch (choice){
            case 1: event67(); break;
            case 2: event143(); break;
            case 3: event226(); break;
            default: System.exit(1);
        }
    }
    public static void event329() throws IOException {
        event221();
    }
    public static void event330() {
        switch (choice){
            case 1: event208(); break;
            case 2: event119(); break;
            default: System.exit(1);
        }
    }

    public static void event331() throws IOException {
        event265();
    }
    public static void event332() throws IOException {
        switch (choice){
            case 1: event80(); break;
            case 2: event48(); break;
            default: System.exit(1);
        }
    }
    public static void event333() throws IOException {
        // -2pv
        event14();
    }
    public static void event334() throws IOException {
        event275();
    }
    public static void event335() {
        event342();
    }
    public static void event336() throws IOException {
        switch (choice){
            case 1: event180(); break;
            case 2: event99(); break;
            default: System.exit(1);
        }
    }
    public static void event337() {
        event400();
    }
    public static void event338() throws IOException {
        event90();
    }
    public static void event339() throws IOException {
        switch (choice){
            case 1: event134(); break;
            case 2: event149(); break;
            default: System.exit(1);
        }
    }

    public static void event340() throws IOException {
        switch (choice){
            case 1: event64(); break;
            case 2: event62(); break;
            default: System.exit(1);
        }
    }
    public static void event341() throws IOException {
        //formule magique
        event209();
    }
    public static void event342() {
        //game over
    }
    public static void event343() throws IOException {
        switch (choice){
            case 1: event55(); break;
            case 2: event249(); break;
            default: System.exit(1);
        }
    }
    public static void event344() throws IOException {
        switch (choice){
            case 1: event5(); break;
            case 2: event7(); break;
            default: System.exit(1);
        }
    }
    public static void event345() throws IOException {
        event140();
    }
    public static void event346() throws IOException {
        switch (choice){
            case 1: event2(); break;
            case 2: event243(); break;
            default: System.exit(1);
        }
    }
    public static void event347() throws IOException {
        event12();
    }
    public static void event348() throws IOException {
        switch (choice){
            case 1: event68(); break;
            case 2: event207(); break;
            case 3: event22(); break;
            case 4: event354(); break;
            default: System.exit(1);
        }
    }
    public static void event349() throws IOException {
        event157();
    }
    public static void event350() throws IOException {
        event218();
    }

    public static void event351() {
        event400();
    }
    public static void event352() throws IOException {
        switch (choice){
            case 1: event203(); break;
            case 2: event16(); break;
            case 3: event216(); break;
            case 4: event11(); break;
            default: System.exit(1);
        }
    }
    public static void event353() {
        event400();
    }
    public static void event354() throws IOException {
        event188();
    }
    public static void event355() {
        event351();
    }
    public static void event356() throws IOException {
        switch (choice){
            case 1: event146(); break;
            case 2: event185(); break;
            case 3: event23(); break;
            default: System.exit(1);
        }
    }
    public static void event357() throws IOException {
        event200();
    }

    public static void event358() throws IOException {
        switch (choice) {
            case 1: event148(); break;
            case 2: event256(); break;
            default: System.exit(1);
        }
    }
    public static void event359() throws IOException {
        event29();
    }
    public static void event360() throws IOException {
        switch (choice){
            case 1: event229(); break;
            case 2: event184(); break;
            default: System.exit(1);
        }
    }

    public static void event361() throws IOException {
        switch (choice){
            case 1: event297(); break;
            case 2: event126(); break;
            default: System.exit(1);
        }
    }
    public static void event362() throws IOException {
        switch (choice){
            case 1: event58(); break;
            case 2: event156(); break;
            default: System.exit(1);
        }
    }
    public static void event363() throws IOException {
        switch (choice){
            case 1: event228(); break;
            case 2: event64(); break;
            case 3: event304(); break;
            default: System.exit(1);
        }
    }
    public static void event364() throws IOException {
        event174();
    }
    public static void event365() throws IOException {
        switch (choice){
            case 1: event171(); break;
            case 2: event278(); break;
            case 3: event9(); break;
            case 4: event31(); break;
            default: System.exit(1);
        }
    }
    public static void event366() throws IOException {
        event140();
    }
    public static void event367() throws IOException {
        switch (choice){
            case 1: event308(); break;
            case 2: event121(); break;
            default: System.exit(1);
        }
    }
    public static void event368() throws IOException {
        event15();
    }
    public static void event369() {
        //game over
    }
    public static void event370() throws IOException {
        switch (choice){
            case 1: event129(); break;
            case 2: event260(); break;
            default: System.exit(1);
        }
    }

    public static void event371() throws IOException {
        event177();
    }
    public static void event372() throws IOException {
        event95();
    }
    public static void event373() throws IOException {
        switch (choice){
            case 1: event148(); break;
            case 2: event256(); break;
            case 3: event358(); break;
            default: System.exit(1);
        }
    }
    public static void event374() throws IOException {
        switch (choice){
            case 1: event30(); break;
            case 2: event109(); break;
            case 3: event158(); break;
            default: System.exit(1);
        }
    }
    public static void event375() throws IOException {
        switch (choice){
            case 1: event263(); break;
            case 2: event135(); break;
            case 3: event63(); break;
            default: System.exit(1);
        }
    }
    public static void event376() throws IOException {
        //game over
    }
    public static void event377() throws IOException {
        switch (choice){
            case 1: event332(); break;
            case 2: event113(); break;
            case 3: event320(); break;
            case 4: event355(); break;
            default: System.exit(1);
        }
    }
    public static void event378() throws IOException {
        //-4 pv
        event209();
    }
    public static void event379() throws IOException {
        event206();
    }
    public static void event380() throws IOException {
        event213();
    }

    public static void event381() {
        event400();
    }
    public static void event382() throws IOException {
        switch (choice){
            case 1: event285(); break;
            case 2: event356(); break;
            default: System.exit(1);
        }
    }
    public static void event383() throws IOException {
        switch (choice){
            case 1: event333(); break;
            case 2: event189(); break;
            default: System.exit(1);
        }
    }
    public static void event384() throws IOException {
        switch (choice){
            case 1: event252(); break;
            case 2: event107(); break;
            default: System.exit(1);
        }
    }
    public static void event385() throws IOException {
        switch (choice){
            case 1: event365(); break;
            case 2: event278(); break;
            case 3: event171(); break;
            default: System.exit(1);
        }
    }
    public static void event386() throws IOException {
        switch (choice){
            case 1: event204(); break;
            case 2: event108(); break;
            default: System.exit(1);
        }
    }
    public static void event387() throws IOException {
        event6();
    }
    public static void event388() throws IOException {
        event157();
    }
    public static void event389() throws IOException {
        switch (choice){
            case 1: event61(); break;
            case 2: event178(); break;
            case 3: event311(); break;
            default: System.exit(1);
        }
    }
    public static void event390() throws IOException {
        switch (choice){
            case 1: event122(); break;
            case 2: event350(); break;
            default: System.exit(1);
        }
    }

    public static void event391() throws IOException {
        event99();
    }
    public static void event392() throws IOException {
        event196();
    }
    public static void event393() throws IOException {
        switch (choice){
            case 1: event27(); break;
            case 2: event25(); break;
            default: System.exit(1);
        }
    }
    public static void event394() throws IOException {
        event251();
    }
    public static void event395() throws IOException {
        switch (choice) {
            case 1:
                event85();
                break;
            case 2:
                event322();
                break;
            case 3:
                event248();
                break;
            default:
                System.exit(1);
        }
    }
    public static void event396() throws IOException {
        event183();
    }
    public static void event397() {

    }
    public static void event398 () throws IOException {
        event79();
    }
    public static void event399() throws IOException {
        event272();
    }
    public static void event400 () {
        //good ending
    }
}


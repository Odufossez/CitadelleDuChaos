import java.io.IOException;
import java.util.Scanner;

/**
 * ERROR STATUS :
 * 1 : WRONG INPUT CHOICE
 */

public class Events {
    static Scanner input = new Scanner(System.in);
    static int choice;

    public static void intro() throws IOException {
        Affichage.affichage("CitadelleDuChaos/ressources/Event_Intro_text.txt");
        event1();
    }
    public static void event1(){
        System.out.println("""
                Le soleil se couche ; et tandis que l'obscurité s'installe, vous entreprenez l'escalade de la montagne
                en direction de la silhouette menaçante qui se dresse dans la nuit. La Citadelle du Chaos se trouve à moins
                d'une heure de marche. À quelque distance des remparts, vous vous arrêtez pour vous reposer et la Citadelle
                vous semble alors un immense et redoutable fantôme auquel il serait impossible d'échapper. Vous contemplez
                cette masse imposante et un frisson de peur vous parcourt l'échiné. Vous avez honte cependant d'éprouver
                cette crainte et, avec une froide détermination, vous continuez à grimper jusqu'au portail d'entrée
                dont vous savez qu'il est surveillé par des gardes. En même temps, vous réfléchissez à ce que vous allez
                dire. Vous avez pensé à vous faire passer pour un herboriste venu soigner l'un des gardes atteint de fièvre.
                Vous pourriez également vous présenter comme un marchand ou un artisan - un charpentier par exemple.
                Vous pourriez même vous prétendre un vagabond en quête d'un abri pour la nuit. Tout en réfléchissant à
                ces trois mensonges, vous atteignez le sentier qui mène au portail. Deux flambeaux brûlent de chaque côté de la herse.
                À mesure que vous avancez, vous percevez des grognements étouffés et vous distinguez bientôt deux créatures hybrides.
                À gauche, il s'agit d'un animal repoussant à la tête de chien posée sur un corps de grand singe. Du côté
                opposé se tient son contraire : un monstre à tête de singe et au corps de molosse. Ce dernier s'avance
                vers vous, s'arrête à quelques mètres, puis, se dressant sur ses pattes de derrière, vous demande qui vous êtes.
                Quelle réponse allez-vous faire ?
                """);

        System.out.println("\n\n1. Prétendre être un herboriste  2. Se faire passer pour un marchand  3.Demander l'hospitalité pour la nuit");
        choice = input.nextInt();
        switch (choice){
            case 1: event261(); break;
            case 2: event230(); break;
            case 3: event20(); break;
            default: System.exit(1);
        }
    }
    public static void event2() {
        switch (choice){
            case 1: event142(); break;
            case 2: event343(); break;
            default: System.exit(1);
        }
    }
    public static void event3() {

        switch (choice){
            case 1: event327(); break;
            case 2: event59();  break;
            case 3: event236(); break;
            case 4: event286(); break;
            case 5: event366(); break;
            default: System.exit(1);
        }
    }
    public static void event4() {
        switch (choice){
            case 1: event303(); break;
            case 2: event190(); break;
            default: System.exit(1);
        }
    }
    public static void event5() {
        switch (choice){
            case 1: event40(); break;
            case 2: event361(); break;
            default: System.exit(1);
        }
    }
    public static void event6() {
        event367();
    }
    public static void event7() {
        switch (choice){
            case 1: event268(); break;
            case 2: event116(); break;
            default: System.exit(1);
        }
    }
    public static void event8() {
        event218();
    }
    public static void event9() {
        event31();
    }
    public static void event10() {
        event249();
    }

    public static void event11() {
        switch (choice){
            case 1: event36(); break;
            case 2: event262(); break;
            case 3: event128(); break;
            case 4: event152(); break;
            case 5: event16(); break;
            default: System.exit(1);
        }
    }
    public static void event12() {
        switch (choice){
            case 1: event274();  break;
            case 2: event335(); break;
            case 3: event78(); break;
            default: System.exit(1);
        }
    }
    public static void event13() {
        switch (choice){
            case 1: event302(); break;
            case 2: event215(); break;
            default: System.exit(1);
        }
    }
    public static void event14() {
        switch(choice) {
            case 1: event79(); break;
            case 2: event100(); break;
            default: System.exit(1);
        }
    }
    public static void event15() {
        event245();
    }
    public static void event16() {
        switch(choice) {
            case 1: event99(); break;
            case 2: event180(); break;
            default: System.exit(1);
        }
    }
    public static void event17() {
        event93();
    }
    public static void event18() {
        switch (choice){
            case 1: event31(); break;
            case 2: event84(); break;
            default: System.exit(1);
        }
    }
    public static void event19() {
        switch(choice){
            case 1: event363(); break;
            case 2: event254(); break;
            default: System.exit(1);
        }
    }
    public static void event20() {
        switch(choice) {
            case 1: event96(); break;
            case 2: event288(); break;
            default: System.exit(1);
        }
    }

    public static void event21() {
        event6();
    }
    public static void event22() {
        event188();
    }
    public static void event23() {
        event169();
    }
    public static void event24() {
        switch (choice){
            case 1: event372(); break;
            case 2: event219(); break;
            default: System.exit(1);
        }
    }
    public static void event25() {
        switch (choice){
            case 1: event239(); break;
            case 2: event206(); break;
            case 3: event133(); break;
            default: System.exit(1);
        }
    }
    public static void event26() {
        switch (choice){
            case 1: event87(); break;
            case 2: event345(); break;
            case 3: event304(); break;
            case 4: event101(); break;
            default: System.exit(1);
        }
    }
    public static void event27() {
        event206();
    }
    public static void event28() {
        switch (choice){
            case 1: event2(); break;
            case 2: event243(); break;
            default: System.exit(1);
        }
    }
    public static void event29() {
        switch (choice){
            case 1: event271(); break;
            case 2: event131(); break;
            default: System.exit(1);
        }
    }
    public static void event30() {
        event241();
    }

    public static void event31() {
        event169();
    }
    public static void event32() {
        event251();
    }
    public static void event33() {
        event213();
    }
    public static void event34() {
        switch (choice){
            case 1: event237(); break;
            case 2: event89(); break;
            default: System.exit(1);
        }
    }
    public static void event35() {
        switch (choice){
            case 1: event364(); break;
            case 2: event246(); break;
            default: System.exit(1);
        }
    }
    public static void event36() {
        event99();
    }
    public static void event37() {
        event229();
    }
    public static void event38() {
        switch (choice){
            case 1: event306(); break;
            case 2: event132(); break;
            default: System.exit(1);
        }
    }
    public static void event39() {
        event248();
    }
    public static void event40() {
        switch(choice) {
            case 1: event243(); break;
            case 2: event2(); break;
            default: System.exit(1);
        }
    }

    public static void event41() {
        event257();
    }
    public static void event42() {
        switch (choice){
            case 1: event138(); break;
            case 2: event91(); break;
            case 3: event223(); break;
            default: System.exit(1);
        }
    }
    public static void event43() {
        event14();
    }
    public static void event44() {
        switch (choice){
            case 1: event353(); break;
            case 2: event277(); break;
            default: System.exit(1);
        }
    }
    public static void event45() {
        switch (choice){
            case 1: event166(); break;
            case 2: event313(); break;
            case 3: event253(); break;
            case 4: event97(); break;
            default: System.exit(1);
        }
    }
    public static void event46() {
        switch (choice){
            case 1: event195(); break;
            case 2: event74(); break;
            default: System.exit(1);
        }
    }
    public static void event47() {
        switch (choice){
            case 1: event8(); break;
            case 2: event173(); break;
            case 3: event259(); break;
            case 4: event209(); break;
            default: System.exit(1);
        }
    }
    public static void event48() {
        switch (choice){
            case 1: event199(); break;
            case 2: event232(); break;
            default: System.exit(1);
        }
    }
    public static void event49() {
        event255();
    }
    public static void event50() {
        event164();
    }

    public static void event51() {
        switch (choice){
            case 1: event159(); break;
            case 2: event301(); break;
            case 3: event280(); break;
            default: System.exit(1);
        }
    }
    public static void event52() {
        switch (choice){
            case 1: event385(); break;
            case 2: event227(); break;
            default: System.exit(1);
        }
    }
    public static void event53() {
        event194();
    }
    public static void event54() {

        switch (choice){
            case 1: event287(); break;
            case 2: event160(); break;
            case 3: event27(); break;
            default: System.exit(1);
        }
    }
    public static void event55() {
        switch (choice){
            case 1: event10(); break;
            case 2: event249(); break;
            default: System.exit(1);
        }
    }
    public static void event56() {
        switch (choice){
            case 1: event120(); break;
            case 2: event163(); break;
            case 3: event334(); break;
            default: System.exit(1);
        }
    }
    public static void event57() {
        switch (choice){
            case 1: event150(); break;
            case 2: event233(); break;
            default: System.exit(1);
        }
    }
    public static void event58() {
        switch (choice){
            case 1: event92(); break;
            case 2: event298(); break;
            case 3: event267(); break;
            case 4: event156(); break;
            default: System.exit(1);
        }
    }
    public static void event59() {
        event140();
    }
    public static void event60() {
        switch (choice){
            case 1: event213(); break;
            case 2: event33(); break;
            case 3: event295(); break;
            default: System.exit(1);
        }
    }

    public static void event61() {
        //game over
    }
    public static void event62() {
        event140();
    }
    public static void event63() {
        switch (choice){
            case 1: event263(); break;
            case 2: event135(); break;
            default: System.exit(1);
        }
    }
    public static void event64() {
        switch (choice){
            case 1: event3(); break;
            case 2: event286(); break;
            case 3: event366(); break;
            default: System.exit(1);
        }
    }
    public static void event65() {
        //game over
    }

    public static void event66() {
        event270();
    }
    public static void event67() {
        switch (choice){
            case 1: event143(); break;
            case 2: event226(); break;
            default: System.exit(1);
        }
    }
    public static void event68() {
        switch (choice){
            case 1: event207(); break;
            case 2: event22(); break;
            case 3: event354(); break;
            default: System.exit(1);
        }
    }
    public static void event69() {
        event193();
    }
    public static void event70() {
        switch (choice){
            case 1: event307(); break;
            case 2: event264(); break;
            case 3: event325(); break;
            default: System.exit(1);
        }
    }

    public static void event71() {
        event218();
    }
    public static void event72() {
        //game over
    }
    public static void event73() {
        switch(choice){
            case 1: event112(); break;
            case 2: event282(); break;
            default: System.exit(1);
        }
    }
    public static void event74() {
        event377();
    }
    public static void event75() {
        event40();
    }
    public static void event76() {
        event191();
    }
    public static void event77() {
        switch (choice){
            case 1: event349(); break;
            case 2: event46(); break;
            case 3: event187(); break;
            default: System.exit(1);
        }
    }
    public static void event78() {
        switch (choice){
            case 1: event277(); break;
            case 2: event124(); break;
            case 3: event324(); break;
            default: System.exit(1);
        }
    }
    public static void event79() {
        event218();
    }
    public static void event80() {
        event199();
    }

    public static void event81() {
        event251();
    }
    public static void event82() {
        //game over
    }
    public static void event83() {
        event245();
    }
    public static void event84() {
        event234();
    }
    public static void event85() {
        switch (choice){
            case 1: event395(); break;
            case 2: event248(); break;
            case 3: event322(); break;
            default: System.exit(1);
        }
    }
    public static void event86() {
        event251();
    }
    public static void event87() {
        event64();
    }
    public static void event88() {
        switch (choice){
            case 1: event292(); break;
            case 2: event170(); break;
            case 3: event64(); break;
            case 4: event304(); break;
            default: System.exit(1);
        }
    }
    public static void event89() {
        event237();
    }
    public static void event90() {
        switch (choice){
            case 1: event176(); break;
            case 2: event21(); break;
            case 3: event329(); break;
            default: System.exit(1);
        }
    }

    public static void event91() {
        event140();
    }
    public static void event92() {
        event156();
    }
    public static void event93() {
        event169();
    }
    public static void event94() {
        event118();
    }
    public static void event95() {
        event367();
    }
    public static void event96() {
        event251();
    }
    public static void event97() {
        switch (choice){
            case 1: event13(); break;
            case 2: event281(); break;
            default: System.exit(1);
        }
    }
    public static void event98() {
        switch (choice){
            case 1: event303(); break;
            case 2: event4(); break;
            case 3: event190(); break;
            default: System.exit(1);
        }
    }
    public static void event99() {
        switch (choice){
            case 1: event52(); break;
            case 2: event38(); break;
            default: System.exit(1);
        }
    }
    public static void event100() {
        switch (choice){
            case 1: event79(); break;
            case 2: event276(); break;
            default: System.exit(1);
        }
    }

    public static void event101() {
        switch (choice){
            case 1: event64(); break;
            case 2: event62(); break;
            default: System.exit(1);
        }
    }

    public static void event102() {
        switch (choice){
            case 1: event183(); break;
            case 2: event396(); break;
            case 3: event270(); break;
            default: System.exit(1);
        }
    }

    public static void event103() {
        //game over
    }
    public static void event104() {
        switch (choice){
            case 1: event25(); break;
            case 2: event266(); break;
            case 3: event310(); break;
            case 4: event54(); break;
            default: System.exit(1);
        }
    }
    public static void event105() {
        event95();
    }
    public static void event106() {
        event218();
    }
    public static void event107() {
        event184();
    }
    public static void event108() {
        event73();
    }
    public static void event109() {
        event30();
    }
    public static void event110() {
        switch (choice){
            case 1: event288(); break;
            case 2: event251(); break;
            default: System.exit(1);
        }
    }

    public static void event111() {
        switch (choice){
            case 1: event347(); break;
            case 2: event153(); break;
            default: System.exit(1);
        }
    }
    public static void event112() {
        event212();
    }
    public static void event113() {
        switch (choice){
            case 1: event388(); break;
            case 2: event145(); break;
            default: System.exit(1);
        }
    }
    public static void event114() {
        event218();
    }
    public static void event115() {
        event373();
    }
    public static void event116() {
        event210();
    }
    public static void event117() {
        event337();
    }
    public static void event118() {
        switch (choice){
            case 1: event273(); break;
            case 2: event198(); break;
            default: System.exit(1);
        }
    }
    public static void event119() {
        //game over
    }
    public static void event120() {
        event95();
    }

    public static void event121() {
        event257();
    }
    public static void event122() {
        event47();
    }
    public static void event123() {
        switch (choice){
            case 1: event211(); break;
            case 2: event35(); break;
            case 3: event283(); break;
            default: System.exit(1);
        }
    }
    public static void event124() {
        event400();
    }
    public static void event125() {
        //chance ou -5pv
        event209();
    }
    public static void event126() {
        event316();
    }
    public static void event127() {
        switch (choice){
            case 1: event53(); break;
            case 2: event387(); break;
            case 3: event240(); break;
            case 4: event194(); break;
            default: System.exit(1);
        }
    }
    public static void event128() {
        switch (choice){
            case 1: event262(); break;
            case 2: event36(); break;
            case 3: event152(); break;
            case 4: event336(); break;
            default: System.exit(1);
        }
    }
    public static void event129() {
        switch (choice){
            case 1: event260(); break;
            case 2: event370(); break;
            default: System.exit(1);
        }
    }
    public static void event130() {
        event333();
    }

    public static void event131() {
        event348();
    }
    public static void event132() {
        switch (choice){
            case 1: event18(); break;
            case 2: event238(); break;
            case 3: event375(); break;
            default: System.exit(1);
        }
    }
    public static void event133() {
        switch (choice){
            case 1: event82(); break;
            case 2: event206(); break;
            default: System.exit(1);
        }
    }
    public static void event134() {
        switch (choice){
            case 1: event169(); break;
            case 2: event60(); break;
            case 3: event245(); break;
            default: System.exit(1);
        }
    }
    public static void event135() {
        event326();
    }
    public static void event136() {
        switch (choice){
            case 1: event17(); break;
            case 2: event167(); break;
            case 3: event389(); break;
            default: System.exit(1);
        }
    }
    public static void event137() {
        switch (choice){
            case 1: event14(); break;
            case 2: event383(); break;
            default: System.exit(1);
        }
    }
    public static void event138() {
        switch (choice){
            case 1: event64(); break;
            case 2: event376(); break;
            default: System.exit(1);
        }
    }
    public static void event139() {
        switch (choice){
            case 1: event244(); break;
            case 2: event346(); break;
            case 3: event28(); break;
            default: System.exit(1);
        }
    }
    public static void event140() {
        switch (choice){
            case 1: event25(); break;
            case 2: event104(); break;
            default: System.exit(1);
        }
    }

    public static void event141() {
        event156();
    }
    public static void event142() {
        event234();
    }
    public static void event143() {
        switch (choice){
            case 1: event360(); break;
            case 2: event184(); break;
            case 3: event226(); break;
            default: System.exit(1);
        }
    }
    public static void event144() {
        switch (choice){
            case 1: event154(); break;
            case 2: event56(); break;
            default: System.exit(1);
        }
    }
    public static void event145() {
        switch (choice){
            case 1: event157(); break;
            case 2: event80(); break;
            default: System.exit(1);
        }
    }
    public static void event146() {
        switch (choice){
            case 1: event247(); break;
            case 2: event201(); break;
            case 3: event102(); break;
            case 4: event66(); break;
            default: System.exit(1);
        }
    }
    public static void event147() {
        switch (choice){
            case 1: event260(); break;
            case 2: event129(); break;
            case 3: event370(); break;
            default: System.exit(1);
        }
    }
    public static void event148() {
        //game over
    }
    public static void event149() {
        switch (choice){
            case 1: event245(); break;
            case 2: event380(); break;
            case 3: event209(); break;
            default: System.exit(1);
        }
    }
    public static void event150() {
        event374();
    }

    public static void event151() {
        switch (choice){
            case 1: event197(); break;
            case 2: event19(); break;
            default: System.exit(1);
        }
    }
    public static void event152() {
        event180();
    }
    public static void event153() {
        //game over
    }
    public static void event154() {
        switch (choice){
            case 1: event56(); break;
            case 2: event275(); break;
            default: System.exit(1);
        }
    }
    public static void event155() {
        event65();
    }
    public static void event156() {
        switch (choice){
            case 1: event71(); break;
            case 2: event284(); break;
            case 3: event114(); break;
            default: System.exit(1);
        }
    }
    public static void event157() {
        switch (choice){
            case 1: event199(); break;
            case 2: event232(); break;
            default: System.exit(1);
        }
    }
    public static void event158() {
        event77();
    }
    public static void event159() {
        event323();
    }
    public static void event160() {
        event206();
    }

    public static void event161() {
        switch (choice){
            case 1: event390(); break;
            case 2: event106(); break;
            default: System.exit(1);
        }
    }
    public static void event162() {
        event32();
    }
    public static void event163() {
        event95();
    }
    public static void event164() {
        //game over
    }
    public static void event165() {
        switch (choice){
            case 1: event202(); break;
            case 2: event398(); break;
            default: System.exit(1);
        }
    }
    public static void event166() {
        switch (choice){
            case 1: event13(); break;
            case 2: event281(); break;
            default: System.exit(1);
        }

    }
    public static void event167() {
        switch (choice){
            case 1: event331(); break;
            case 2: event224(); break;
            default: System.exit(1);
        }
    }
    public static void event168() {
        event328();
    }
    public static void event169() {
        switch (choice){
            case 1: event19(); break;
            case 2: event197(); break;
            case 3: event317(); break;
            case 4: event151(); break;
            default: System.exit(1);
        }
    }
    public static void event170() {
        switch (choice){
            case 1: event292(); break;
            case 2: event64(); break;
            case 3: event304(); break;
            default: System.exit(1);
        }
    }

    public static void event171() {
        switch (choice){
            case 1: event278(); break;
            case 2: event31(); break;
            case 3: event365(); break;
            default: System.exit(1);
        }
    }
    public static void event172() {
        switch (choice){
            case 1: event26(); break;
            case 2: event289(); break;
            default: System.exit(1);
        }
    }
    public static void event173() {
        event218();
    }
    public static void event174() {
        switch (choice){
            case 1: event116(); break;
            case 2: event268(); break;
            default: System.exit(1);
        }
    }
    public static void event175() {
        event110();
    }
    public static void event176() {
        switch (choice){
            case 1: event127(); break;
            case 2: event21();  break;
            case 3: event329(); break;
            default: System.exit(1);
        }
    }
    public static void event177() {
        switch (choice){
            case 1: event5(); break;
            case 2: event344(); break;
            default: System.exit(1);
        }
    }
    public static void event178() {
        switch (choice){
            case 1: event17();  break;
            case 2: event265();  break;
            default: System.exit(1);
        }
    }
    public static void event179() {
        switch (choice){
            case 1: event378(); break;
            case 2: event125(); break;
            case 3: event341(); break;
            default: System.exit(1);
        }
    }
    public static void event180() {
        event99();
    }

    public static void event181() {
        switch (choice) {
            case 1: event54(); break;
            case 2: event25(); break;
            default: System.exit(1);
        }
    }
    public static void event182() {
        switch (choice){
            case 1: event85(); break;
            case 2: event395(); break;
            case 3: event322(); break;
            case 4: event248(); break;
            default: System.exit(1);
        }
    }

    public static void event183() {
        event270();
    }
    public static void event184() {
        //game over
    }
    public static void event185() {
        event13();
    }
    public static void event186() {
        switch (choice){
            case 1: event155(); break;
            case 2: event83(); break;
            case 3: event245(); break;
            default: System.exit(1);
        }
    }
    public static void event187() {
        switch (choice){
            case 1: event279(); break;
            case 2: event314(); break;
            case 3: event115(); break;
            default: System.exit(1);
        }
    }
    public static void event188() {
        switch (choice) {
            case 1: event301(); break;
            case 2: event159(); break;
            case 3: event51(); break;
            default: System.exit(1);
        }
    }
    public static void event189() {
        switch (choice){
            case 1: event319(); break;
            case 2: event130(); break;
            case 3: event43(); break;
            default: System.exit(1);
        }
    }
    public static void event190() {
        event147();
    }

    public static void event191() {
        event119();
    }
    public static void event192() {
        event29();
    }
    public static void event193() {
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
    public static void event195() {
        event377();
    }
    public static void event196() {
        switch (choice){
            case 1: event45(); break;
            case 2: event13(); break;
            case 3: event281(); break;
            default: System.exit(1);
        }
    }
    public static void event197() {
        event363();
    }
    public static void event198() {
        switch (choice){
            case 1: event177(); break;
            case 2: event290(); break;
            default: System.exit(1);
        }
    }
    public static void event199() {
        //game over
    }
    public static void event200() {
        switch (choice){
            case 1: event237(); break;
            case 2: event98(); break;
            default: System.exit(1);
        }
    }

    public static void event201() {
        event270();
    }
    public static void event202() {
        //Game Over
    }
    public static void event203() {
        switch (choice){
            case 1: event203(); break;
            case 2: event11(); break;
            default: System.exit(1);
        }
    }
    public static void event204() {
        event73();
    }
    public static void event205() {
        switch (choice){
            case 1: event368(); break;
            case 2: event309(); break;
            default: System.exit(1);
        }
    }
    public static void event206() {
        event182();
    }
    public static void event207() {
        event188();
    }
    public static void event208() {
        //game over
    }
    public static void event209() {
        switch (choice){
            case 1: event362(); break;
            case 2: event156(); break;
            default: System.exit(1);
        }
    }
    public static void event210() {
        switch (choice){
            case 1: event192(); break;
            case 2: event359(); break;
            default: System.exit(1);
        }
    }

    public static void event211() {
        switch (choice){
            case 1: event123(); break;
            case 2: event35(); break;
            case 3: event283(); break;
            default: System.exit(1);
        }
    }
    public static void event212() {
        event90();
    }
    public static void event213() {
        switch (choice){
            case 1: event235(); break;
            case 2: event209(); break;
            default: System.exit(1);
        }
    }
    public static void event214() {
        event62();
    }
    public static void event215() {
        switch (choice){
            case 1: event136(); break;
            case 2: event41(); break;
            default: System.exit(1);
        }
    }
    public static void event216() {
        switch (choice){
            case 1: event294(); break;
            case 2: event391(); break;
            case 3: event36(); break;
            default: System.exit(1);
        }
    }
    public static void event217() {
        switch (choice){
            case 1: event293(); break;
            case 2: event57(); break;
            default: System.exit(1);
        }
    }
    public static void event218() {
        switch (choice){
            case 1: event118(); break;
            case 2: event94(); break;
            default: System.exit(1);
        }
    }
    public static void event219() {
        event95();
    }
    public static void event220() {
        switch (choice){
            case 1: event243(); break;
            case 2: event2(); break;
            default: System.exit(1);
        }
    }

    public static void event221() {
        event127();
    }
    public static void event222() {
        switch (choice){
            case 1: event137(); break;
            case 2: event14(); break;
            default: System.exit(1);
        }
    }
    public static void event223() {
        event138();
    }
    public static void event224() {
        event265();
    }
    public static void event225() {
        switch (choice){
            case 1: event15(); break;
            case 2: event245(); break;
            default: System.exit(1);
        }
    }
    public static void event226() {
        switch (choice){
            case 1: event184(); break;
            case 2: event312(); break;
            case 3: event37(); break;
            case 4: event384(); break;
            default: System.exit(1);
        }
    }
    public static void event227() {
        event234();
    }
    public static void event228() {
        switch (choice){
            case 1: event88(); break;
            case 2: event170(); break;
            case 3: event296(); break;
            default: System.exit(1);
        }
    }
    public static void event229() {
        switch (choice){
            case 1: event217(); break;
            case 2: event164(); break;
            case 3: event50(); break;
            default: System.exit(1);
        }
    }
    public static void event230() {
        switch (choice){
            case 1: event288(); break;
            case 2: event96(); break;
            default: System.exit(1);
        }
    }

    public static void event231() {
        switch (choice){
            case 1: event196(); break;
            case 2: event243(); break;
            default: System.exit(1);
        }
    }
    public static void event232() {
        switch (choice){
            case 1: event111(); break;
            case 2: event72(); break;
            default: System.exit(1);
        }
    }
    public static void event233() {
        event374();
    }
    public static void event234() {
        switch (choice){
            case 1: event397(); break;
            case 2: event69(); break;
            default: System.exit(1);
        }
    }
    public static void event235() {
        switch (choice){
            case 1: event245(); break;
            case 2: event269(); break;
            default: System.exit(1);
        }
    }
    public static void event236() {
        event140();
    }
    public static void event237() {
        event169();
    }
    public static void event238() {
        switch (choice){
            case 1: event31(); break;
            case 2: event18(); break;
            case 3: event375(); break;
            default: System.exit(1);
        }
    }
    public static void event239() {
        switch (choice){
            case 1: event379(); break;
            case 2: event82(); break;
            default: System.exit(1);
        }
    }

    public static void event240() {
        event6();
    }

    public static void event241(){
        event77();
    }
    public static void event242() {
        switch (choice){
            case 1: event24(); break;
            case 2: event105(); break;
            default: System.exit(1);
        }
    }
    public static void event243() {
        switch (choice){
            case 1: event2(); break;
            case 2: event352(); break;
            default: System.exit(1);
        }
    }
    public static void event244() {
        switch (choice){
            case 1: event243(); break;
            case 2: event2(); break;
            default: System.exit(1);
        }
    }
    public static void event245() {
        switch (choice){
            case 1: event161(); break;
            case 2: event390(); break;
            case 3: event47(); break;
            default: System.exit(1);
        }
    }
    public static void event246() {
        event174();
    }
    public static void event247() {
        event234();
    }
    public static void event248() {
        switch (choice){
            case 1: event103(); break;
            case 2: break; //game over
            default: System.exit(1);
        }
    }
    public static void event249() {
        switch (choice){
            case 1: event392(); break;
            case 2: event231(); break;
            default: System.exit(1);
        }
    }

    public static void event250() {
        //game over
    }
    public static void event251() {
        switch (choice){
            case 1: event222(); break;
            case 2: event179(); break;
            case 3: event321(); break;
            default: System.exit(1);
        }
    }
    public static void event252() {
        event229();
    }
    public static void event253() {
        switch (choice){
            case 1: event13(); break;
            case 2: event281(); break;
            default: System.exit(1);
        }
    }
    public static void event254() {
        event197();
    }
    public static void event255() {
        switch (choice){
            case 1: event198(); break;
            case 2: event290(); break;
            default: System.exit(1);
        }
    }
    public static void event256() {
        switch (choice){
            case 1: event155(); break;
            case 2: event65(); break;
            default: System.exit(1);
        }
    }
    public static void event257() {
        switch (choice){
            case 1: event237(); break;
            case 2: event357(); break;
            case 3: event200(); break;
            default: System.exit(1);
        }
    }
    public void event258() {
        switch (choice){
            case 1: event140(); break;
            case 2: event366(); break;
            default: System.exit(1);
        }
    }
    public static void event259() {
        event218();
    }
    public static void event260() {
        switch (choice){
            case 1: event34(); break;
            case 2: event299(); break;
            default: System.exit(1);
        }
    }

    public static void event261() {
        System.out.println("Event 261");
        switch (choice){
            case 1: event81(); break;
            case 2: event394(); break;
            case 3: event175(); break;
            default: System.exit(1);
        }
    }
    public static void event262() {
        event180();
    }
    public static void event263() {
        event326();
    }
    public static void event264() {
        event177();
    }
    public static void event265() {
        event169();
    }
    public static void event266() {
        switch (choice){
            case 1: event54(); break;
            case 2: event310(); break;
            default: System.exit(1);
        }
    }
    public static void event267() {
        event156();
    }
    public static void event268() {
        event210();
    }
    public static void event269() {
        switch (choice){
            case 1: event205(); break;
            case 2: event186(); break;
            case 3: event225(); break;
            default: System.exit(1);
        }
    }
    public static void event270() {
        switch (choice){
            case 1: event185(); break;
            case 2: event23(); break;
            default: System.exit(1);
        }
    }

    public static void event271() {
        switch (choice){
            case 1: event348(); break;
            case 2: event131(); break;
            default: System.exit(1);
        }
    }
    public static void event272() {
        switch (choice) {
            case 1: event95(); break;
            case 2: event242(); break;
            default: System.exit(1);
        }
    }
    public static void event273() {
        switch (choice){
            case 1: event49(); break;
            case 2: event255(); break;
            case 3: event371(); break;
            default: System.exit(1);
        }
    }
    public static void event274() {
        switch (choice){
            case 1: event353(); break;
            case 2: event277(); break;
            default: System.exit(1);
        }
    }
    public static void event275() {
        switch (choice){
            case 1: event272(); break;
            case 2: event399(); break;
            default: System.exit(1);
        }
    }
    public static void event276() {
        switch (choice){
            case 1: event165(); break;
            case 2: event202(); break;
            default: System.exit(1);
        }
    }
    public static void event277() {
        switch (choice){
            case 1: event330(); break;
            case 2: event315(); break;
            case 3: event76(); break;
            case 4: event119(); break;
            default: System.exit(1);
        }
    }
    public static void event278() {
        switch (choice){
            case 1: event365(); break;
            case 2: event171(); break;
            case 3: event31(); break;
            default: System.exit(1);
        }
    }
    public static void event279() {
        switch (choice){
            case 1: event44(); break;
            case 2: event318(); break;
            case 3: event78(); break;
            case 4: event335(); break;
            default: System.exit(1);
        }
    }
    public static void event280() {
        event323();
    }

    public static void event281() {
        switch (choice){
            case 1: event382(); break;
            case 2: event285(); break;
            case 3: event256(); break;
            default: System.exit(1);
        }
    }
    public static void event282() {
        event212();
    }
    public static void event283() {
        //game over
    }
    public static void event284() {
        switch (choice){
            case 1: event71(); break;
            case 2: event114(); break;
            default: System.exit(1);
        }
    }
    public static void event285() {
        switch (choice){
            case 1: event23(); break;
            case 2: event185(); break;
            default: System.exit(1);
        }
    }
    public static void event286() {
        event140();
    }
    public static void event287() {
        switch (choice){
            case 1: event25(); break;
            case 2: event27(); break;
            case 3: event160(); break;
            default: System.exit(1);
        }
    }
    public static void event288() {
        switch (choice){
            case 1: event86(); break;
            case 2: event162(); break;
            case 3: event32(); break;
            default: System.exit(1);
        }
    }
    public static void event289() {
        switch (choice){
            case 1: event340(); break;
            case 2: event214(); break;
            case 3: event305(); break;
            case 4: event304(); break;
            default: System.exit(1);
        }

    }
    public static void event290() {
        switch (choice){
            case 1: event325(); break;
            case 2: event307(); break;
            case 3: event70(); break;
            case 4: event264(); break;
            default: System.exit(1);
        }
    }

    public static void event291() {
        event328();
    }
    public static void event292() {
        switch (choice){
            case 1: event376(); break;
            case 2: event42(); break;
            case 3: event64(); break;
            default: System.exit(1);
        }
    }
    public static void event293() {
        event374();
    }
    public static void event294() {
        event99();
    }
    public static void event295() {
        event213();
    }
    public static void event296() {
        event292();
    }
    public static void event297() {
        switch (choice){
            case 1: event2(); break;
            case 2: event316(); break;
            case 3: event75(); break;
            default: System.exit(1);
        }
    }
    public static void event298() {
        switch (choice){
            case 1: event58(); break;
            case 2: event141(); break;
            default: System.exit(1);
        }
    }
    public static void event299() {
        event237();
    }
    public static void event300() {
        switch (choice){
            case 1: event244(); break;
            case 2: event346(); break;
            default: System.exit(1);
        }
    }
    public static void event301() {
        event323();
    }
    public static void event302() {
        event169();
    }
    public static void event303() {
        event169();
    }
    public static void event304() {
        switch (choice){
            case 1: event172(); break;
            case 2: event26(); break;
            case 3: event289(); break;
            default: System.exit(1);
        }
    }
    public static void event305() {
        event64();
    }
    public static void event306() {
        switch (choice){
            case 1: event132(); break;
            case 2: event52(); break;
            default: System.exit(1);
        }
    }
    public static void event307() {
        event177();
    }
    public static void event308() {
        event257();
    }
    public static void event309() {
        switch (choice){
            case 1: event15(); break;
            case 2: event245(); break;
            default: System.exit(1);
        }
    }
    public static void event310() {
        switch (choice){
            case 1: event181(); break;
            case 2: event250(); break;
            case 3: event393(); break;
            default: System.exit(1);
        }
    }

    public static void event311(){
        switch (choice){
            case 1: event61(); break;
            case 2: event178(); break;
            default: System.exit(1);
        }
    }
    public static void event312() {
        event184();
    }
    public static void event313() {
        switch (choice){
            case 1: event13(); break;
            case 2: event281(); break;
            default: System.exit(1);
        }
    }
    public static void event314() {
        event191();
    }
    public static void event315() {
        event191();
    }
    public static void event316() {
        switch (choice){
            case 1: event220(); break;
            case 2: event139(); break;
            case 3: event300(); break;
            default: System.exit(1);
        }
    }
    public static void event317() {
        switch (choice){
            case 1: event197(); break;
            case 2: event19(); break;
            default: System.exit(1);
        }
    }
    public static void event318() {
        switch (choice){
            case 1: event381(); break;
            case 2: event117(); break;
            case 3: event277(); break;
            default: System.exit(1);
        }
    }
    public static void event319() {
        event333();
    }
    public static void event320() {
        switch (choice){
            case 1: event113(); break;
            case 2: event332(); break;
            case 3: event351(); break;
            default: System.exit(1);
        }
    }

    public static void event321() {
        switch (choice){
            case 1: event269(); break;
            case 2: event339(); break;
            default: System.exit(1);
        }
    }
    public static void event322() {
        switch (choice){
            case 1: event39(); break;
            case 2: event168(); break;
            case 3: event291(); break;
            default: System.exit(1);
        }
    }
    public static void event323() {
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
    public static void event325() {
        event177();
    }
    public static void event326() {
        switch (choice) {
            case 1: event84(); break;
            case 2: event31(); break;
            default: System.exit(1);
        }
    }
    public static void event327() {
        event366();
    }
    public static void event328() {
        switch (choice){
            case 1: event67(); break;
            case 2: event143(); break;
            case 3: event226(); break;
            default: System.exit(1);
        }
    }
    public static void event329() {
        event221();
    }
    public static void event330() {
        switch (choice){
            case 1: event208(); break;
            case 2: event119(); break;
            default: System.exit(1);
        }
    }

    public static void event331() {
        event265();
    }
    public static void event332() {
        switch (choice){
            case 1: event80(); break;
            case 2: event48(); break;
            default: System.exit(1);
        }
    }
    public static void event333() {
        // -2pv
        event14();
    }
    public static void event334() {
        event275();
    }
    public static void event335() {
        event342();
    }
    public static void event336() {
        switch (choice){
            case 1: event180(); break;
            case 2: event99(); break;
            default: System.exit(1);
        }
    }
    public static void event337() {
        event400();
    }
    public static void event338() {
        event90();
    }
    public static void event339() {
        switch (choice){
            case 1: event134(); break;
            case 2: event149(); break;
            default: System.exit(1);
        }
    }

    public static void event340() {
        switch (choice){
            case 1: event64(); break;
            case 2: event62(); break;
            default: System.exit(1);
        }
    }
    public static void event341() {
        //formule magique
        event209();
    }
    public static void event342() {
        //game over
    }
    public static void event343() {
        switch (choice){
            case 1: event55(); break;
            case 2: event249(); break;
            default: System.exit(1);
        }
    }
    public static void event344() {
        switch (choice){
            case 1: event5(); break;
            case 2: event7(); break;
            default: System.exit(1);
        }
    }
    public static void event345() {
        event140();
    }
    public static void event346() {
        switch (choice){
            case 1: event2(); break;
            case 2: event243(); break;
            default: System.exit(1);
        }
    }
    public static void event347() {
        event12();
    }
    public static void event348() {
        switch (choice){
            case 1: event68(); break;
            case 2: event207(); break;
            case 3: event22(); break;
            case 4: event354(); break;
            default: System.exit(1);
        }
    }
    public static void event349() {
        event157();
    }
    public static void event350() {
        event218();
    }

    public static void event351() {
        event400();
    }
    public static void event352() {
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
    public static void event354() {
        event188();
    }
    public static void event355() {
        event351();
    }
    public static void event356() {
        switch (choice){
            case 1: event146(); break;
            case 2: event185(); break;
            case 3: event23(); break;
            default: System.exit(1);
        }
    }
    public static void event357() {
        event200();
    }

    public static void event358() {
        switch (choice) {
            case 1: event148(); break;
            case 2: event256(); break;
            default: System.exit(1);
        }
    }
    public static void event359() {
        event29();
    }
    public static void event360() {
        switch (choice){
            case 1: event229(); break;
            case 2: event184(); break;
            default: System.exit(1);
        }
    }

    public static void event361() {
        switch (choice){
            case 1: event297(); break;
            case 2: event126(); break;
            default: System.exit(1);
        }
    }
    public static void event362() {
        switch (choice){
            case 1: event58(); break;
            case 2: event156(); break;
            default: System.exit(1);
        }
    }
    public static void event363() {
        switch (choice){
            case 1: event228(); break;
            case 2: event64(); break;
            case 3: event304(); break;
            default: System.exit(1);
        }
    }
    public static void event364() {
        event174();
    }
    public static void event365() {
        switch (choice){
            case 1: event171(); break;
            case 2: event278(); break;
            case 3: event9(); break;
            case 4: event31(); break;
            default: System.exit(1);
        }
    }
    public static void event366() {
        event140();
    }
    public static void event367() {
        switch (choice){
            case 1: event308(); break;
            case 2: event121(); break;
            default: System.exit(1);
        }
    }
    public static void event368() {
        event15();
    }
    public static void event369() {
        //game over
    }
    public static void event370() {
        switch (choice){
            case 1: event129(); break;
            case 2: event260(); break;
            default: System.exit(1);
        }
    }

    public static void event371() {
        event177();
    }
    public static void event372() {
        event95();
    }
    public static void event373() {
        switch (choice){
            case 1: event148(); break;
            case 2: event256(); break;
            case 3: event358(); break;
            default: System.exit(1);
        }
    }
    public static void event374() {
        switch (choice){
            case 1: event30(); break;
            case 2: event109(); break;
            case 3: event158(); break;
            default: System.exit(1);
        }
    }
    public static void event375() {
        switch (choice){
            case 1: event263(); break;
            case 2: event135(); break;
            case 3: event63(); break;
            default: System.exit(1);
        }
    }
    public static void event376() {
        //game over
    }
    public static void event377() {
        switch (choice){
            case 1: event332(); break;
            case 2: event113(); break;
            case 3: event320(); break;
            case 4: event355(); break;
            default: System.exit(1);
        }
    }
    public static void event378() {
        //-4 pv
        event209();
    }
    public static void event379() {
        event206();
    }
    public static void event380() {
        event213();
    }

    public static void event381() {
        event400();
    }
    public static void event382() {
        switch (choice){
            case 1: event285(); break;
            case 2: event356(); break;
            default: System.exit(1);
        }
    }
    public static void event383() {
        switch (choice){
            case 1: event333(); break;
            case 2: event189(); break;
            default: System.exit(1);
        }
    }
    public static void event384() {
        switch (choice){
            case 1: event252(); break;
            case 2: event107(); break;
            default: System.exit(1);
        }
    }
    public static void event385() {
        switch (choice){
            case 1: event365(); break;
            case 2: event278(); break;
            case 3: event171(); break;
            default: System.exit(1);
        }
    }
    public static void event386() {
        switch (choice){
            case 1: event204(); break;
            case 2: event108(); break;
            default: System.exit(1);
        }
    }
    public static void event387() {
        event6();
    }
    public static void event388() {
        event157();
    }
    public static void event389() {
        switch (choice){
            case 1: event61(); break;
            case 2: event178(); break;
            case 3: event311(); break;
            default: System.exit(1);
        }
    }
    public static void event390() {
        switch (choice){
            case 1: event122(); break;
            case 2: event350(); break;
            default: System.exit(1);
        }
    }

    public static void event391() {
        event99();
    }
    public static void event392() {
        event196();
    }
    public static void event393() {
        switch (choice){
            case 1: event27(); break;
            case 2: event25(); break;
            default: System.exit(1);
        }
    }
    public static void event394() {
        event251();
    }
    public static void event395() {
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
    public static void event396() {
        event183();
    }
    public static void event397() {

    }
    public static void event398 () {
        event79();
    }
    public static void event399() {
        event272();
    }
    public static void event400 () {
        //good ending
    }
}


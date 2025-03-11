import java.util.Random;
import java.util.Scanner;

/**
 * ERROR STATUS :
 * 1 : WRONG INPUT CHOICE
 */

public class Events {
    Scanner input = new Scanner(System.in);
    int choice;

    public void intro(){
        System.out.println("Le bon peuple de la Vallée des Saules vit depuis environ huit ans dans\n" +
                "la crainte, voire la terreur. Cette crainte, c'est un certain Balthus le\n" +
                "Terrible qui l'inspire, Balthus le Sorcier dont les pouvoirs magiques\n" +
                "sont impressionnants. Et lorsque le bruit a couru que Balthus le Terrible\n" +
                "avait décidé de conquérir le monde en commençant par la Vallée des\n" +
                "Saules, la crainte s'est changée soudain en terreur.\n" +
                "Un elfe envoyé en mission d'espionnage à la Tour Noire est revenu\n" +
                "trois jours plus tôt, porteur d'une tragique nouvelle : Balthus le Terrible\n" +
                "a en effet recruté dans les grottes du Pic de la Roche toute une armée de\n" +
                "monstres, les redoutables Chaotiques, qui se préparent à envahir la\n" +
                "Vallée des Saules sous son commandement, et cela, avant la fin de la\n" +
                "semaine.\n" +
                "Le bon Roi Salamon qui règne sur la Vallée est un homme d'action.\n" +
                "Aussitôt prévenu, il envoie des messagers dans tout le royaume pour\n" +
                "mobiliser ses sujets et organiser la résistance. Des cavaliers ont\n" +
                "également été dépêchés dans la Grande Forêt de Yore pour avertir les\n" +
                "elfes qui l'habitent et leur proposer une alliance. Le Roi Salamon est\n" +
                "aussi un homme sage et il sait que la nouvelle viendra inévitablement\n" +
                "aux oreilles du Grand Enchanteur de Yore, un vieux mage dont les\n" +
                "pouvoirs sont grands et qui vit au cœur de la forêt.\n" +
                "Le Grand Enchanteur de Yore est cependant trop âgé pour participer\n" +
                "lui-même à une telle bataille. Mais il se peut que, parmi ses jeunes\n" +
                "disciples, il s'en trouve un qui ait suffisamment de courage et\n" +
                "d'ambition pour décider de venir en aide au Roi et à ses sujets.\n" +
                "Or, le meilleur élève du Grand Enchanteur de Yore, c'est vous. Sous la\n" +
                "conduite de ce maître exigeant, vous avez toujours donné le meilleur de\n" +
                "vous-même, et sitôt connue la menace qui plane sur la Vallée des\n" +
                "Saules, vous partez immédiatement pour la cour du Roi Salamon. Là\n" +
                "vous êtes accueilli comme un héros par le Monarque qui vous expose\n" +
                "aussitôt son plan : il s'agirait d'éviter que la bataille ait lieu en faisant\n" +
                "disparaître Balthus avant que son armée soit prête.\n" +
                "Cette mission est extrêmement périlleuse, car Balthus le Terrible est\n" +
                "protégé, dans sa Citadelle, par une foule de créatures diaboliques. Et\n" +
                "bien que vos pouvoirs magiques soient votre meilleure arme, il faudra\n" +
                "parfois vous battre à l'épée pour défendre votre vie.\n" +
                "Le Roi Salamon vous a expliqué votre mission et vous a averti des\n" +
                "dangers qui vous attendent. Un seul chemin vous mènera vers Balthus\n" +
                "le Terrible avec un minimum de risques. Si vous le découvrez, vous\n" +
                "gagnerez facilement, mais il vous faudra peut-être faire plusieurs\n" +
                "voyages avant de trouver le meilleur moyen d'atteindre le Sorcier.\n" +
                "Il ne vous reste plus à présent qu'à vous mettre en route en direction de\n" +
                "la Tour Noire. Parvenu au pied du Pic de la Roche, vous apercevez la\n" +
                "Citadelle du Chaos dont les contours se dessinent au loin sous le ciel\n" +
                "sombre...");
        event1();
    }
    public void event1(){
        System.out.println("Le soleil se couche ; et tandis que l'obscurité s'installe, vous\n" +
                "entreprenez l'escalade de la montagne en direction de la silhouette\n" +
                "menaçante qui se dresse dans la nuit. La Citadelle du Chaos se trouve à\n" +
                "moins d'une heure de marche. À quelque distance des remparts, vous\n" +
                "vous arrêtez pour vous reposer et la Citadelle vous semble alors un\n" +
                "immense et redoutable fantôme auquel il serait impossible d'échapper.\n" +
                "Vous contemplez cette masse imposante et un frisson de peur vous\n" +
                "parcourt l'échiné. Vous avez honte cependant d'éprouver cette crainte\n" +
                "et, avec une froide détermination, vous continuez à grimper jusqu'au\n" +
                "portail d'entrée dont vous savez qu'il est surveillé par des gardes. En\n" +
                "même temps, vous réfléchissez à ce que vous allez dire. Vous avez\n" +
                "pensé à vous faire passer pour un herboriste venu soigner l'un des\n" +
                "gardes atteint de fièvre. Vous pourriez également vous présenter\n" +
                "comme un marchand ou un artisan - un charpentier par exemple.\n" +
                "Vous pourriez même vous prétendre un vagabond en quête d'un abri\n" +
                "pour la nuit. Tout en réfléchissant à ces trois mensonges, vous atteignez\n" +
                "le sentier qui mène au portail. Deux flambeaux brûlent de chaque côté\n" +
                "de la herse. À mesure que vous avancez, vous percevez des\n" +
                "grognements étouffés et vous distinguez bientôt deux créatures\n" +
                "hybrides. À gauche, il s'agit d'un animal repoussant à la tête de chien\n" +
                "posée sur un corps de grand singe. Du côté opposé se tient son contraire\n" +
                ": un monstre à tête de singe et au corps de molosse. Ce dernier s'avance\n" +
                "vers vous, s'arrête à quelques mètres, puis, se dressant sur ses pattes de\n" +
                "derrière, vous demande qui vous êtes.\n");

        System.out.println("1. Prétendre être un herboriste  2. Se faire passer pour un marchand  3.Demander l'hospitalité pour la nuit");
        choice = input.nextInt();
        switch (choice){
            case 1: event261(); break;
            case 2: event230(); break;
            case 3: event20(); break;
            default: System.exit(1);
        }
    }
    public void event2() {
        switch (choice){
            case 1: event142(); break;
            case 2: event343(); break;
            default: System.exit(1);
        }
    }
    public void event3() {
        switch (choice){
            case 1: event327();  break;
            case 2: event59(); break;
            case 3: event236(); break;
            default: System.exit(1);
        }
    }
    public void event4() {
        switch (choice){
            case 1: event303(); break;
            case 2: event190(); break;
            default: System.exit(1);
        }
    }
    public void event5() {
        switch (choice){
            case 1: event40(); break;
            case 2: event361(); break;
            default: System.exit(1);
        }
    }
    public void event6() {
        event367();
    }
    public void event7() {
        switch (choice){
            case 1: event268(); break;
            case 2: event116(); break;
            default: System.exit(1);
        }
    }
    public void event8() {
        event218();
    }
    public void event9() {
        event31();
    }
    public void event10() {
        event249();
    }

    public void event11() {
        switch (choice){
            case 1: event36(); break;
            case 2: event262(); break;
            case 3: event128(); break;
            case 4: event152(); break;
            default: System.exit(1);
        }
    }
    public void event12() {
        switch (choice){
            case 1: event274();  break;
            case 2: event335(); break;
            case 3: event78(); break;
            default: System.exit(1);
        }
    }
    public void event13() {
        switch (choice){
            case 1: event302(); break;
            case 2: event215(); break;
            default: System.exit(1);
        }
    }
    public void event14() {
        switch(choice) {
            case 1: event79(); break;
            case 2: event100(); break;
            default: System.exit(1);
        }
    }
    public void event15() {
        event245();
    }
    public void event16() {
        switch(choice) {
            case 1: event99(); break;
            case 2: event180(); break;
            default: System.exit(1);
        }
    }
    public void event17() {
        event93();
    }
    public void event18() {
        switch (choice){
            case 1: event31(); break;
            case 2: event84(); break;
            default: System.exit(1);
        }
    }
    public void event19() {
        switch(choice){
            case 1: event363(); break;
            case 2: event254(); break;
            default: System.exit(1);
        }
    }
    public void event20() {
        switch(choice) {
            case 1: event96(); break;
            case 2: event288(); break;
            default: System.exit(1);
        }
    }

    public void event21() {
        event6();
    }
    public void event22() {
        event188();
    }
    public void event23() {
        event169();
    }
    public void event24() {
        switch (choice){
            case 1: event372(); break;
            case 2: event219(); break;
            default: System.exit(1);
        }
    }
    public void event25() {
        switch (choice){
            case 1: event239(); break;
            case 2: event206(); break;
            case 3: event133(); break;
            default: System.exit(1);
        }
    }
    public void event26() {
        switch (choice){
            case 1: event87(); break;
            case 2: event345(); break;
            case 3: event304(); break;
            case 4: event101(); break;
            default: System.exit(1);
        }
    }
    public void event27() {
        event206();
    }
    public void event28() {
        switch (choice){
            case 1: event2(); break;
            case 2: event243(); break;
            default: System.exit(1);
        }
    }
    public void event29() {
        switch (choice){
            case 1: event271(); break;
            case 2: event131(); break;
            default: System.exit(1);
        }
    }
    public void event30() {
        event241();
    }

    public void event31() {}
    public void event32() {
        event251();
    }
    public void event33() {
        event213();
    }
    public void event34() {
        switch (choice){
            case 1: event237(); break;
            case 2: event89(); break;
            default: System.exit(1);
        }
    }
    public void event35() {
        switch (choice){
            case 1: event364(); break;
            case 2: event246(); break;
            default: System.exit(1);
        }
    }
    public void event36() {
        event99();
    }
    public void event37() {
        event229();
    }
    public void event38() {
        switch (choice){
            case 1: event306(); break;
            case 2: event132(); break;
            default: System.exit(1);
        }
    }
    public void event39() {
        event248();
    }
    public void event40() {
        switch(choice) {
            case 1: event243(); break;
            case 2: event2(); break;
            default: System.exit(1);
        }
    }

    public void event41() {
        event257();
    }
    public void event42() {
        switch (choice){
            case 1: event138(); break;
            case 2: event91(); break;
            case 3: event223(); break;
            default: System.exit(1);
        }
    }
    public void event43() {
        event14();
    }
    public void event44() {
        switch (choice){
            case 1: event353(); break;
            case 2: event277(); break;
            default: System.exit(1);
        }
    }
    public void event45() {
        switch (choice){
            case 1: event166(); break;
            case 2: event313(); break;
            case 3: event253(); break;
            case 4: event97(); break;
            default: System.exit(1);
        }
    }
    public void event46() {
        switch (choice){
            case 1: event195(); break;
            case 2: event74(); break;
            default: System.exit(1);
        }
    }
    public void event47() {
        switch (choice){
            case 1: event8(); break;
            case 2: event173(); break;
            case 3: event259(); break;
            case 4: event209(); break;
            default: System.exit(1);
        }
    }
    public void event48() {
        switch (choice){
            case 1: event199(); break;
            case 2: event232(); break;
            default: System.exit(1);
        }
    }
    public void event49() {
        event255();
    }
    public void event50() {
        event164();
    }

    public void event51() {
        switch (choice){
            case 1: event159(); break;
            case 2: event301(); break;
            case 3: event280(); break;
            default: System.exit(1);
        }
    }
    public void event52() {
        switch (choice){
            case 1: event385(); break;
            case 2: event227(); break;
            default: System.exit(1);
        }
    }
    public void event53() {}
    public void event54() {
        switch (choice){
            case 1: event287(); break;
            case 2: event160(); break;
            case 3: event27(); break;
            default: System.exit(1);
        }
    }
    public void event55() {
        switch (choice){
            case 1: event10(); break;
            case 2: event249(); break;
            default: System.exit(1);
        }
    }
    public void event56() {
        switch (choice){
            case 1: event120(); break;
            case 2: event163(); break;
            case 3: event334(); break;
            default: System.exit(1);
        }
    }
    public void event57() {
        switch (choice){
            case 1: event150(); break;
            case 2: event233(); break;
            default: System.exit(1);
        }
    }
    public void event58() {
        switch (choice){
            case 1: event92(); break;
            case 2: event298(); break;
            case 3: event267(); break;
            case 4: event156(); break;
            default: System.exit(1);
        }
    }
    public void event59() {
        event140();
    }
    public void event60() {
        switch (choice){
            case 1: event213(); break;
            case 2: event33(); break;
            case 3: event295(); break;
            default: System.exit(1);
        }
    }

    public void event61() {
        //game over
    }
    public void event62() {
        event140();
    }
    public void event63() {
        switch (choice){
            case 1: event263(); break;
            case 2: event135(); break;
            default: System.exit(1);
        }
    }
    public void event64() {
        switch (choice){
            case 1: event3(); break;
            case 2: event286(); break;
            case 3: event366(); break;
            default: System.exit(1);
        }
    }
    public void event65() {
        //game over
    }
    public void event66() {}
    public void event67() {
        switch (choice){
            case 1: event143(); break;
            case 2: event226(); break;
            default: System.exit(1);
        }
    }
    public void event68() {}
    public void event69() {
        event193();
    }
    public void event70() {
        switch (choice){
            case 1: event307(); break;
            case 2: event264(); break;
            case 3: event325(); break;
            default: System.exit(1);
        }
    }

    public void event71() {
        event218();
    }
    public void event72() {
        //game over
    }
    public void event73() {
        switch(choice){
            case 1: event112(); break;
            case 2: event282(); break;
            default: System.exit(1);
        }
    }
    public void event74() {
        event377();
    }
    public void event75() {
        event40();
    }
    public void event76() {
        event191();
    }
    public void event77() {
        switch (choice){
            case 1: event349(); break;
            case 2: event46(); break;
            case 3: event187(); break;
            default: System.exit(1);
        }
    }
    public void event78() {
        switch (choice){
            case 1: event277(); break;
            case 2: event124(); break;
            case 3: event324(); break;
            default: System.exit(1);
        }
    }
    public void event79() {
        event218();
    }
    public void event80() {
        event199();
    }

    public void event81() {
        event251();
    }
    public void event82() {
        //game over
    }
    public void event83() {
        event245();
    }
    public void event84() {
        event234();
    }
    public void event85() {
        switch (choice){
            case 1: event395(); break;
            case 2: event248(); break;
            case 3: event322(); break;
            default: System.exit(1);
        }
    }
    public void event86() {
        event251();
    }
    public void event87() {
        event64();
    }
    public void event88() {
        switch (choice){
            case 1: event292(); break;
            case 2: event170(); break;
            case 3: event64(); break;
            case 4: event304(); break;
            default: System.exit(1);
        }
    }
    public void event89() {
        event237();
    }
    public void event90() {
        switch (choice){
            case 1: event176(); break;
            case 2: event21(); break;
            case 3: event329(); break;
            default: System.exit(1);
        }
    }

    public void event91() {
        event140();
    }
    public void event92() {
        event156();
    }
    public void event93() {
        event169();
    }
    public void event94() {
        event118();
    }
    public void event95() {
        event367();
    }
    public void event96() {
        event251();
    }
    public void event97() {
        switch (choice){
            case 1: event13(); break;
            case 2: event281(); break;
            default: System.exit(1);
        }
    }
    public void event98() {
        switch (choice){
            case 1: event303(); break;
            case 2: event4(); break;
            case 3: event190(); break;
            default: System.exit(1);
        }
    }
    public void event99() {
        switch (choice){
            case 1: event52(); break;
            case 2: event38(); break;
            default: System.exit(1);
        }
    }
    public void event100() {
        switch (choice){
            case 1: event79(); break;
            case 2: event276(); break;
            default: System.exit(1);
        }
    }

    public void event101() {
        switch (choice){
            case 1: event64(); break;
            case 2: event62(); break;
            default: System.exit(1);
        }
    }
    public void event102() {}
    public void event103() {
        //game over
    }
    public void event104() {
        switch (choice){
            case 1: event25(); break;
            case 2: event266(); break;
            case 3: event310(); break;
            case 4: event54(); break;
            default: System.exit(1);
        }
    }
    public void event105() {
        event95();
    }
    public void event106() {
        event218();
    }
    public void event107() {
        event184();
    }
    public void event108() {
        event73();
    }
    public void event109() {
        event30();
    }
    public void event110() {
        switch (choice){
            case 1: event288(); break;
            case 2: event251(); break;
            default: System.exit(1);
        }
    }

    public void event111() {
        switch (choice){
            case 1: event347(); break;
            case 2: event153(); break;
            default: System.exit(1);
        }
    }
    public void event112() {
        event212();
    }
    public void event113() {
        switch (choice){
            case 1: event388(); break;
            case 2: event145(); break;
            default: System.exit(1);
        }
    }
    public void event114() {}
    public void event115() {
        event373();
    }
    public void event116() {
        event210();
    }
    public void event117() {
        event337();
    }
    public void event118() {
        switch (choice){
            case 1: event273(); break;
            case 2: event198(); break;
            default: System.exit(1);
        }
    }
    public void event119() {
        //game over
    }
    public void event120() {
        event95();
    }

    public void event121() {
        event257();
    }
    public void event122() {
        event47();
    }
    public void event123() {
        switch (choice){
            case 1: event211(); break;
            case 2: event35(); break;
            case 3: event283(); break;
            default: System.exit(1);
        }
    }
    public void event124() {
        event400();
    }
    public void event125() {
        //chance ou -5pv
        event209();
    }
    public void event126() {
        event316();
    }
    public void event127() {}
    public void event128() {
        switch (choice){
            case 1: event262(); break;
            case 2: event36(); break;
            case 3: event152(); break;
            case 4: event336(); break;
        }
    }
    public void event129() {
        switch (choice){
            case 1: event260(); break;
            case 2: event370(); break;
            default: System.exit(1);
        }
    }
    public void event130() {
        event333();
    }

    public void event131() {}
    public void event132() {
        switch (choice){
            case 1: event18(); break;
            case 2: event238(); break;
            case 3: event375(); break;
            default: System.exit(1);
        }
    }
    public void event133() {
        switch (choice){
            case 1: event82(); break;
            case 2: event206(); break;
            default: System.exit(1);
        }
    }
    public void event134() {
        switch (choice){
            case 1: event169(); break;
            case 2: event60(); break;
            case 3: event245(); break;
            default: System.exit(1);
        }
    }
    public void event135() {
        event326();
    }
    public void event136() {
        switch (choice){
            case 1: event17(); break;
            case 2: event167(); break;
            case 3: event389(); break;
            default: System.exit(1);
        }
    }
    public void event137() {
        switch (choice){
            case 1: event14(); break;
            case 2: event383(); break;
        }
    }
    public void event138() {
        switch (choice){
            case 1: event64(); break;
            case 2: event376(); break;
            default: System.exit(1);
        }
    }
    public void event139() {
        switch (choice){
            case 1: event244(); break;
            case 2: event346(); break;
            case 3: event28(); break;
            default: System.exit(1);
        }
    }
    public void event140() {
        switch (choice){
            case 1: event25(); break;
            case 2: event104(); break;
            default: System.exit(1);
        }
    }

    public void event141() {
        event156();
    }
    public void event142() {
        event234();
    }
    public void event143() {
        switch (choice){
            case 1: event360(); break;
            case 2: event184(); break;
            case 3: event226(); break;
            default: System.exit(1);
        }
    }
    public void event144() {
        switch (choice){
            case 1: event154(); break;
            case 2: event56(); break;
            default: System.exit(1);
        }
    }
    public void event145() {
        switch (choice){
            case 1: event157(); break;
            case 2: event80(); break;
            default: System.exit(1);
        }
    }
    public void event146() {
        switch (choice){
            case 1: event247(); break;
            case 2: event201(); break;
            case 3: event102(); break;
            case 4: event66(); break;
            default: System.exit(1);
        }
    }
    public void event147() {
        switch (choice){
            case 1: event260(); break;
            case 2: event129(); break;
            case 3: event370(); break;
            default: System.exit(1);
        }
    }
    public void event148() {
        //game over
    }
    public void event149() {
        switch (choice){
            case 1: event245(); break;
            case 2: event380(); break;
            case 3: event209(); break;
            default: System.exit(1);
        }
    }
    public void event150() {
        event374();
    }

    public void event151() {
        switch (choice){
            case 1: event197(); break;
            case 2: event19(); break;
            default: System.exit(1);
        }
    }
    public void event152() {
        event180();
    }
    public void event153() {
        //game over
    }
    public void event154() {
        switch (choice){
            case 1: event56(); break;
            case 2: event275(); break;
            default: System.exit(1);
        }
    }
    public void event155() {
        event65();
    }
    public void event156() {
        switch (choice){
            case 1: event71(); break;
            case 2: event284(); break;
            case 3: event114(); break;
            default: System.exit(1);
        }
    }
    public void event157() {
        switch (choice){
            case 1: event199(); break;
            case 2: event232(); break;
            default: System.exit(1);
        }
    }
    public void event158() {
        event77();
    }
    public void event159() {
        event323();
    }
    public void event160() {
        event206();
    }

    public void event161() {
        switch (choice){
            case 1: event390(); break;
            case 2: event106(); break;
            default: System.exit(1);
        }
    }
    public void event162() {
        event32();
    }
    public void event163() {
        event95();
    }
    public void event164() {
        //game over
    }
    public void event165() {
        switch (choice){
            case 1: event202(); break;
            case 2: event398(); break;
            default: System.exit(1);
        }
    }
    public void event166() {
        switch (choice){
            case 1: event13(); break;
            case 2: event281(); break;
            default: System.exit(1);
        }

    }
    public void event167() {
        switch (choice){
            case 1: event331(); break;
            case 2: event224(); break;
            default: System.exit(1);
        }
    }
    public void event168() {
        event328();
    }
    public void event169() {
        switch (choice){
            case 1: event19(); break;
            case 2: event197(); break;
            case 3: event317(); break;
            case 4: event151(); break;
            default: System.exit(1);
        }
    }
    public void event170() {
        switch (choice){
            case 1: event292(); break;
            case 2: event64(); break;
            case 3: event304(); break;
            default: System.exit(1);
        }
    }

    public void event171() {
        switch (choice){
            case 1: event278(); break;
            case 2: event31(); break;
            case 3: event365(); break;
            default: System.exit(1);
        }
    }
    public void event172() {
        switch (choice){
            case 1: event26(); break;
            case 2: event289(); break;
            default: System.exit(1);
        }
    }
    public void event173() {
        event218();
    }
    public void event174() {
        switch (choice){
            case 1: event116(); break;
            case 2: event268(); break;
            default: System.exit(1);
        }
    }
    public void event175() {
        event110();
    }
    public void event176() {
        switch (choice){
            case 1: event127(); break;
            case 2: event21();  break;
            case 3: event329(); break;
            default: System.exit(1);
        }
    }
    public void event177() {
        switch (choice){
            case 1: event5(); break;
            case 2: event344(); break;
            default: System.exit(1);
        }
    }
    public void event178() {
        switch (choice){
            case 1: event17();  break;
            case 2: event265();  break;
            default: System.exit(1);
        }
    }
    public void event179() {
        switch (choice){
            case 1: event378(); break;
            case 2: event125(); break;
            case 3: event341(); break;
            default: System.exit(1);
        }
    }
    public void event180() {
        event99();
    }

    public void event181() {
        switch (choice) {
            case 1: event54(); break;
            case 2: event25(); break;
            default: System.exit(1);
        }
    }
    public void event182() {
        switch (choice){
            case 1: event85(); break;
            case 2: event395(); break;
            case 3: event322(); break;
            case 4: event248(); break;
            default: System.exit(1);
        }
    }
    public void event183() {}
    public void event184() {
        //game over
    }
    public void event185() {
        event13();
    }
    public void event186() {
        switch (choice){
            case 1: event155(); break;
            case 2: event83(); break;
            case 3: event245(); break;
            default: System.exit(1);
        }
    }
    public void event187() {
        switch (choice){
            case 1: event279(); break;
            case 2: event314(); break;
            case 3: event115(); break;
            default: System.exit(1);
        }
    }
    public void event188() {
        switch (choice) {
            case 1: event301(); break;
            case 2: event159(); break;
            case 3: event51(); break;
            default: System.exit(1);
        }
    }
    public void event189() {
        switch (choice){
            case 1: event319(); break;
            case 2: event130(); break;
            case 3: event43(); break;
            default: System.exit(1);
        }
    }
    public void event190() {
        event147();
    }

    public void event191() {
        event119();
    }
    public void event192() {
        event29();
    }
    public void event193() {
        switch (choice){
            case 1: event211(); break;
            case 2: event123(); break;
            case 3: event35(); break;
            case 4: event283(); break;
            default: System.exit(1);
        }
    }
    public void event195() {
        event377();
    }
    public void event196() {
        switch (choice){
            case 1: event45(); break;
            case 2: event13(); break;
            case 3: event281(); break;
            default: System.exit(1);
        }
    }
    public void event197() {
        event363();
    }
    public void event198() {
        switch (choice){
            case 1: event177(); break;
            case 2: event290(); break;
            default: System.exit(1);
        }
    }
    public void event199() {
        //game over
    }
    public void event200() {
        switch (choice){
            case 1: event237(); break;
            case 2: event98(); break;
        }
    }

    public void event201() {}
    public void event202() {
        //Game Over
    }
    public void event203() {
        switch (choice){
            case 1: event203(); break;
            case 2: event11(); break;
            default: System.exit(1);
        }
    }
    public void event204() {
        event73();
    }
    public void event205() {
        switch (choice){
            case 1: event368(); break;
            case 2: event309(); break;
            default: System.exit(1);
        }
    }
    public void event206() {
        event182();
    }
    public void event207() {
        event188();
    }
    public void event208() {
        //game over
    }
    public void event209() {
        switch (choice){
            case 1: event362(); break;
            case 2: event156(); break;
            default: System.exit(1);
        }
    }
    public void event210() {
        switch (choice){
            case 1: event192(); break;
            case 2: event359(); break;
            default: System.exit(1);
        }
    }

    public void event211() {
        switch (choice){
            case 1: event123(); break;
            case 2: event35(); break;
            case 3: event283(); break;
            default: System.exit(1);
        }
    }
    public void event212() {
        event90();
    }
    public void event213() {
        switch (choice){
            case 1: event235(); break;
            case 2: event209(); break;
            default: System.exit(1);
        }
    }
    public void event214() {
        event62();
    }
    public void event215() {
        switch (choice){
            case 1: event136(); break;
            case 2: event41(); break;
            default: System.exit(1);
        }
    }
    public void event216() {
        switch (choice){
            case 1: event294(); break;
            case 2: event391(); break;
            case 3: event36(); break;
            default: System.exit(1);
        }
    }
    public void event217() {
        switch (choice){
            case 1: event293(); break;
            case 2: event57(); break;
            default: System.exit(1);
        }
    }
    public void event218() {
        switch (choice){
            case 1: event118(); break;
            case 2: event94(); break;
            default: System.exit(1);
        }
    }
    public void event219() {
        event95();
    }
    public void event220() {}

    public void event222() {
        switch (choice){
            case 1: event137(); break;
            case 2: event14(); break;
            default: System.exit(1);
        }
    }
    public void event223() {
        event138();
    }
    public void event224() {
        event265();
    }
    public void event225() {
        switch (choice){
            case 1: event15(); break;
            case 2: event245(); break;
            default: System.exit(1);
        }
    }
    public void event226() {
        switch (choice){
            case 1: event184(); break;
            case 2: event312(); break;
            case 3: event37(); break;
            case 4: event384(); break;
            default: System.exit(1);
        }
    }
    public void event227() {
        event234();
    }
    public void event228() {
        switch (choice){
            case 1: event88(); break;
            case 2: event170(); break;
            case 3: event296(); break;
            default: System.exit(1);
        }
    }
    public void event229() {
        switch (choice){
            case 1: event217(); break;
            case 2: event164(); break;
            case 3: event50(); break;
            default: System.exit(1);
        }
    }
    public void event230() {
        switch (choice){
            case 1: event288(); break;
            case 2: event96(); break;
            default: System.exit(1);
        }
    }

    public void event231() {
        switch (choice){
            case 1: event196(); break;
            case 2: event243(); break;
            default: System.exit(1);
        }
    }
    public void event232() {
        switch (choice){
            case 1: event111(); break;
            case 2: event72(); break;
            default: System.exit(1);
        }
    }
    public void event233() {
        event374();
    }
    public void event234() {
        switch (choice){
            case 1: event397(); break;
            case 2: event69(); break;
            default: System.exit(1);
        }
    }
    public void event235() {
        switch (choice){
            case 1: event245(); break;
            case 2: event269(); break;
            default: System.exit(1);
        }
    }
    public void event236() {
        event140();
    }
    public void event237() {
        event169();
    }
    public void event238() {
        switch (choice){
            case 1: event31(); break;
            case 2: event18(); break;
            case 3: event375(); break;
            default: System.exit(1);
        }
    }
    public void event239() {
        switch (choice){
            case 1: event379(); break;
            case 2: event82(); break;
            default: System.exit(1);
        }
    }

    public void event241(){
        event77();
    }
    public void event242() {
        switch (choice){
            case 1: event24(); break;
            case 2: event105(); break;
            default: System.exit(1);
        }
    }
    public void event243() {
        switch (choice){
            case 1: event2(); break;
            case 2: event352(); break;
            default: System.exit(1);
        }
    }
    public void event244() {
        switch (choice){
            case 1: event243(); break;
            case 2: event2(); break;
            default: System.exit(1);
        }
    }
    public void event245() {
        switch (choice){
            case 1: event161(); break;
            case 2: event390(); break;
            case 3: event47(); break;
            default: System.exit(1);
        }
    }
    public void event246() {
        event174();
    }
    public void event247() {}
    public void event248() {
        switch (choice){
            case 1: event103(); break;
            case 2: break; //game over
            default: System.exit(1);
        }
    }
    public void event249() {
        switch (choice){
            case 1: event392(); break;
            case 2: event231(); break;
            default: System.exit(1);
        }
    }

    public void event250() {
        //game over
    }
    public void event251() {
        switch (choice){
            case 1: event222(); break;
            case 2: event179(); break;
            case 3: event321(); break;
            default: System.exit(1);
        }
    }
    public void event252() {
        event229();
    }
    public void event253() {
        switch (choice){
            case 1: event13(); break;
            case 2: event281(); break;
            default: System.exit(1);
        }
    }
    public void event254() {
        event197();
    }
    public void event255() {
        switch (choice){
            case 1: event198(); break;
            case 2: event290(); break;
            default: System.exit(1);
        }
    }
    public void event256() {
        switch (choice){
            case 1: event155(); break;
            case 2: event65(); break;
            default: System.exit(1);
        }
    }
    public void event257() {
        switch (choice){
            case 1: event237(); break;
            case 2: event357(); break;
            case 3: event200(); break;
        }
    }
    public void event259() {
        event218();
    }
    public void event260() {
        switch (choice){
            case 1: event34(); break;
            case 2: event299(); break;
            default: System.exit(1);
        }
    }

    public void event261() {
        switch (choice){
            case 1: event81(); break;
            case 2: event394(); break;
            case 3: event175(); break;
            default: System.exit(1);
        }
    }
    public void event262() {
        event180();
    }
    public void event263() {
        event326();
    }
    public void event264() {
        event177();
    }
    public void event265() {
        event169();
    }
    public void event266() {
        switch (choice){
            case 1: event54(); break;
            case 2: event310(); break;
            default: System.exit(1);
        }
    }
    public void event267() {
        event156();
    }
    public void event268() {
        event210();
    }
    public void event269() {
        switch (choice){
            case 1: event205(); break;
            case 2: event186(); break;
            case 3: event225(); break;
            default: System.exit(1);
        }
    }

    public void event271() {
        switch (choice){
            case 1: event348(); break;
            case 2: event131(); break;
            default: System.exit(1);
        }
    }
    public void event272() {
        switch (choice) {
            case 1: event95(); break;
            case 2: event242(); break;
            default: System.exit(1);
        }
    }
    public void event273() {
        switch (choice){
            case 1: event49(); break;
            case 2: event255(); break;
            case 3: event371(); break;
            default: System.exit(1);
        }
    }
    public void event274() {
        switch (choice){
            case 1: event353(); break;
            case 2: event277(); break;
            default: System.exit(1);
        }
    }
    public void event275() {
        event272();
    }
    public void event276() {
        switch (choice){
            case 1: event165(); break;
            case 2: event202(); break;
            default: System.exit(1);
        }
    }
    public void event277() {
        switch (choice){
            case 1: event330(); break;
            case 2: event315(); break;
            case 3: event76(); break;
            case 4: event119(); break;
            default: System.exit(1);
        }
    }
    public void event278() {
        switch (choice){
            case 1: event365(); break;
            case 2: event171(); break;
            case 3: event31(); break;
            default: System.exit(1);
        }
    }
    public void event279() {
        switch (choice){
            case 1: event44(); break;
            case 2: event318(); break;
            case 3: event78(); break;
            case 4: event335(); break;
            default: System.exit(1);
        }
    }
    public void event280() {
        event323();
    }

    public void event281() {
        switch (choice){
            case 1: event382(); break;
            case 2: event285(); break;
            case 3: event256(); break;
            default: System.exit(1);
        }
    }
    public void event282() {
        event212();
    }
    public void event283() {
        //game over
    }
    public void event284() {
        switch (choice){
            case 1: event71(); break;
            case 2: event114(); break;
            default: System.exit(1);
        }
    }
    public void event285() {
        switch (choice){
            case 1: event23(); break;
            case 2: event185(); break;
            default: System.exit(1);
        }
    }
    public void event286() {
        event140();
    }
    public void event287() {
        switch (choice){
            case 1: event25(); break;
            case 2: event27(); break;
            case 3: event160(); break;
            default: System.exit(1);
        }
    }
    public void event288() {
        switch (choice){
            case 1: event86(); break;
            case 2: event162(); break;
            case 3: event32(); break;
            default: System.exit(1);
        }
    }
    public void event289() {
        switch (choice){
            case 1: event340(); break;
            case 2: event214(); break;
            case 3: event305(); break;
            case 4: event304(); break;
            default: System.exit(1);
        }

    }
    public void event290() {
        switch (choice){
            case 1: event325(); break;
            case 2: event307(); break;
            case 3: event70(); break;
            case 4: event264(); break;
            default: System.exit(1);
        }
    }

    public void event291() {
        event328();
    }
    public void event292() {
        switch (choice){
            case 1: event376(); break;
            case 2: event42(); break;
            case 3: event64(); break;
            default: System.exit(1);
        }
    }
    public void event293() {
        event374();
    }
    public void event294() {
        event99();
    }
    public void event295() {
        event213();
    }
    public void event296() {
        event292();
    }
    public void event297() {
        switch (choice){
            case 1: event2(); break;
            case 2: event316(); break;
            case 3: event75(); break;
            default: System.exit(1);
        }
    }
    public void event298() {
        switch (choice){
            case 1: event58(); break;
            case 2: event141(); break;
            default: System.exit(1);
        }
    }
    public void event299() {
        event237();
    }

    public void event300() {
        switch (choice){
            case 1: event244(); break;
            case 2: event346(); break;
            default: System.exit(1);
        }
    }
    public void event301() {
        event323();
    }
    public void event302() {
        event169();
    }
    public void event303() {
        event169();
    }
    public void event304() {
        switch (choice){
            case 1: event172(); break;
            case 2: event26(); break;
            case 3: event289(); break;
            default: System.exit(1);
        }
    }
    public void event305() {
        event64();
    }
    public void event306() {
        switch (choice){
            case 1: event132(); break;
            case 2: event52(); break;
            default: System.exit(1);
        }
    }
    public void event307() {
        event177();
    }
    public void event308() {
        event257();
    }
    public void event309() {
        switch (choice){
            case 1: event15(); break;
            case 2: event245(); break;
            default: System.exit(1);
        }
    }
    public void event310() {
        switch (choice){
            case 1: event181(); break;
            case 2: event250(); break;
            case 3: event393(); break;
            default: System.exit(1);
        }
    }

    public void event311(){
        switch (choice){
            case 1: event61(); break;
            case 2: event178(); break;
            default: System.exit(1);
        }
    }
    public void event312() {
        event184();
    }
    public void event313() {
        switch (choice){
            case 1: event13(); break;
            case 2: event281(); break;
            default: System.exit(1);
        }
    }
    public void event314() {
        event191();
    }
    public void event315() {
        event191();
    }
    public void event316() {
        switch (choice){
            case 1: event220(); break;
            case 2: event139(); break;
            case 3: event300(); break;
            default: System.exit(1);
        }
    }
    public void event317() {
        switch (choice){
            case 1: event197(); break;
            case 2: event19(); break;
            default: System.exit(1);
        }
    }
    public void event318() {
        event277();
    }
    public void event319() {
        event333();
    }
    public void event320() {
        switch (choice){
            case 1: event113(); break;
            case 2: event332(); break;
            case 3: event351(); break;
            default: System.exit(1);
        }
    }

    public void event321() {
        switch (choice){
            case 1: event269(); break;
            case 2: event339(); break;
            default: System.exit(1);
        }
    }
    public void event322() {
        switch (choice){
            case 1: event39(); break;
            case 2: event168(); break;
            case 3: event291(); break;
            default: System.exit(1);
        }
    }
    public void event323() {
        switch (choice){
            case 1: event386(); break;
            case 2: event144(); break;
            case 3: event338(); break;
            default: System.exit(1);
        }
    }
    public void event324() {
        event369();
    }
    public void event325() {
        event177();
    }
    public void event326() {}
    public void event327() {
        event366();
    }
    public void event328() {
        switch (choice){
            case 1: event67(); break;
            case 2: event143(); break;
            case 3: event226(); break;
            default: System.exit(1);
        }
    }
    public void event329() {}
    public void event330() {
        switch (choice){
            case 1: event208(); break;
            case 2: event119(); break;
            default: System.exit(1);
        }
    }

    public void event331() {
        event265();
    }
    public void event332() {
        switch (choice){
            case 1: event80(); break;
            case 2: event48(); break;
            default: System.exit(1);
        }
    }
    public void event333() {
        // -2pv
        event14();
    }
    public void event334() {
        event275();
    }
    public void event335() {
        event342();
    }
    public void event336() {
        switch (choice){
            case 1: event180(); break;
            case 2: event99(); break;
            default: System.exit(1);
        }
    }
    public void event337() {}
    public void event338() {
        event90();
    }
    public void event339() {
        switch (choice){
            case 1: event134(); break;
            case 2: event149(); break;
            default: System.exit(1);
        }
    }

    public void event340 () {
        switch (choice){
            case 1: event64(); break;
            case 2: event62(); break;
            default: System.exit(1);
        }
    }
    public void event341() {
        //formule magique
        event209();
    }
    public void event342() {
        //game over
    }
    public void event343() {
        switch (choice){
            case 1: event55(); break;
            case 2: event249(); break;
            default: System.exit(1);
        }
    }
    public void event344() {
        switch (choice){
            case 1: event5(); break;
            case 2: event7(); break;
            default: System.exit(1);
        }
    }
    public void event345() {}
    public void event346() {
        switch (choice){
            case 1: event2(); break;
            case 2: event243(); break;
            default: System.exit(1);
        }
    }
    public void event347() {
        event12();
    }
    public void event348() {
        switch (choice){
            case 1: event68(); break;
            case 2: event207(); break;
            case 3: event22(); break;
            case 4: event354(); break;
        }
    }
    public void event349() {
        event157();
    }
    public void event350() {
        event218();
    }

    public void event351() {
        event400();
    }
    public void event352() {
        switch (choice){
            case 1: event203(); break;
            case 2: event16(); break;
            case 3: event216(); break;
            case 4: event11(); break;
            default: System.exit(1);
        }
    }
    public void event353() {
        event400();
    }
    public void event354() {
        event188();
    }
    public void event355() {
        event351();
    }
    public void event356() {
        switch (choice){
            case 1: event146(); break;
            case 2: event185(); break;
            case 3: event23(); break;
            default: System.exit(1);
        }
    }
    public void event357() {
        event200();
    }
    public void event359() {
        event29();
    }
    public void event358() {
        switch (choice) {
            case 1: event148(); break;
            case 2: event256(); break;
            default: System.exit(1);
        }
    }
    public void event360() {
        switch (choice){
            case 1: event229(); break;
            case 2: event184(); break;
            default: System.exit(1);
        }
    }

    public void event361() {
        switch (choice){
            case 1: event297(); break;
            case 2: event126(); break;
            default: System.exit(1);
        }
    }
    public void event362() {
        switch (choice){
            case 1: event58(); break;
            case 2: event156(); break;
            default: System.exit(1);
        }
    }
    public void event363() {
        switch (choice){
            case 1: event228(); break;
            case 2: event64(); break;
            case 3: event304(); break;
            default: System.exit(1);
        }
    }
    public void event364() {
        event174();
    }
    public void event365() {
        switch (choice){
            case 1: event171(); break;
            case 2: event278(); break;
            case 3: event9(); break;
            case 4: event31(); break;
            default: System.exit(1);
        }
    }
    public void event366() {
        event140();
    }
    public void event367() {
        switch (choice){
            case 1: event308(); break;
            case 2: event121(); break;
            default: System.exit(1);
        }
    }
    public void event368() {
        event15();
    }
    public void event369() {
        //game over
    }
    public void event370() {
        switch (choice){
            case 1: event129(); break;
            case 2: event260(); break;
            default: System.exit(1);
        }
    }

    public void event371() {
        event177();
    }
    public void event372() {
        event95();
    }
    public void event373() {
        switch (choice){
            case 1: event148(); break;
            case 2: event256(); break;
            case 3: event358(); break;
            default: System.exit(1);
        }
    }
    public void event374() {
        switch (choice){
            case 1: event30(); break;
            case 2: event109(); break;
            case 3: event158(); break;
            default: System.exit(1);
        }
    }
    public void event375() {
        switch (choice){
            case 1: event263(); break;
            case 2: event135(); break;
            case 3: event63(); break;
            default: System.exit(1);
        }
    }
    public void event376() {
        //game over
    }
    public void event377() {
        switch (choice){
            case 1: event332(); break;
            case 2: event113(); break;
            case 3: event320(); break;
            case 4: event355(); break;
            default: System.exit(1);
        }
    }
    public void event378() {
        //-4 pv
        event209();
    }
    public void event379() {
        event206();
    }
    public void event380() {
        event213();
    }

    public void event381() {
        event400();
    }
    public void event382() {
        switch (choice){
            case 1: event285(); break;
            case 2: event356(); break;
            default: System.exit(1);
        }
    }
    public void event383() {
        switch (choice){
            case 1: event333(); break;
            case 2: event189(); break;
            default: System.exit(1);
        }
    }
    public void event384() {
        switch (choice){
            case 1: event252(); break;
            case 2: event107(); break;
            default: System.exit(1);
        }
    }
    public void event385() {
        switch (choice){
            case 1: event365(); break;
            case 2: event278(); break;
            case 3: event171(); break;
            default: System.exit(1);
        }
    }
    public void event386() {
        switch (choice){
            case 1: event204(); break;
            case 2: event108(); break;
            default: System.exit(1);
        }
    }
    public void event387() {

    }
    public void event388() {
        event157();
    }
    public void event389() {
        switch (choice){
            case 1: event61(); break;
            case 2: event178(); break;
            case 3: event311(); break;
            default: System.exit(1);
        }
    }
    public void event390() {
        switch (choice){
            case 1: event122(); break;
            case 2: event350(); break;
            default: System.exit(1);
        }
    }

    public void event391() {
        event99();
    }
    public void event392() {
        event196();
    }
    public void event393() {
        switch (choice){
            case 1: event27(); break;
            case 2: event25(); break;
            default: System.exit(1);
        }
    }
    public void event394() {
        event251();
    }
    public void event395() {
        switch (choice){
            case 1: event85(); break;
            case 2: event322(); break;
            case 3: event248(); break;
            default: System.exit(1);
        }
    }
    public void event396() {}
    public void event397() {
        event69();
    }
    public void event398() {
        event79();
    }
    public void event399() {}
    public void event400() {}
}

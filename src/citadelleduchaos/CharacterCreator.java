package citadelleduchaos;

import jdk.jfr.Event;

import java.io.IOException;

public class CharacterCreator {
    private static Player player;
    private static int indiceSave;

    /**
     * Gestion de l'affichage du menu de création de perso
     * @throws IOException
     */ //TODO potentiellement revoir l'affichage (v1.01)
    public static void creationPerso(int nbSave) throws IOException {
        char inChar;
        indiceSave = nbSave;

        StdDraw.setFont(Affichage.bold25);
        StdDraw.text(100,1000 , "Création du personnage");


        StdDraw.setFont(Affichage.plain15);

        int x=-1000 , y=500;
        int playerHab = Dice.soloDice()+6;
        int playerEnd = Dice.doubleDice() +12;
        int playerLuck = Dice.soloDice() + 6;
        int playerMagic = Dice.doubleDice() + 6;

        StdDraw.text(x,y , "Force du personnage (habilité au combat) : ");
        StdDraw.text(x+450, y , Integer.toString(playerHab));
        y-=40;
        StdDraw.text(x,y , "Endurance du personnage (nombre de points de vie) : ");
        StdDraw.text(x+450,y, Integer.toString(playerEnd));
        y-=40; //ligne du dessous
        StdDraw.text(x,y , "Chance: ");
        StdDraw.text(x+450,y, Integer.toString(playerLuck));
        y-=40;
        StdDraw.text(x,y,"Formules magiques possibles : ");
        StdDraw.text(x+450,y,Integer.toString(playerMagic));
        y-=100;


        StdDraw.setFont(Affichage.bold20);
        StdDraw.text(x,y,"Voulez vous relancer les dés ? (Les valeurs changeront)");
        y-=140;


        StdDraw.text(x,y,"a. Oui, relancer");
        StdDraw.text(x+500,y,"e. Non, continuer");

        StdDraw.show();


        do {
            while(!StdDraw.hasNextKeyTyped()){continue;}
            inChar = StdDraw.nextKeyTyped();
            switch (inChar){
                case 'a': StdDraw.clear(); creationPerso(nbSave); break; //oui - reroll
                case 'e': { //non - continuer
                    StdDraw.clear();
                    player = new Player(playerHab, playerEnd, playerMagic, 0, playerLuck);
                    afficheMakeGrimoire();
                    break;
                }
                default: continue;
            }
        }while(inChar != 'a' && inChar != 'e');


    }


    /**
     * Affichage de la fenêtre pour ajouter les sorts au grimoire
     */
    public static void afficheMakeGrimoire() throws IOException {
        char tabAlphabet[] = { 'a' , 'b' , 'c' , 'd' , 'e' , 'f' , 'g' ,'h','i','j','k','l','m','n','o'};
        new Spells();
        int counterSpells = 0;

        do {
            Affichage.arrowPrev();
            StdDraw.setFont(Affichage.bold25);
            StdDraw.text(0,1000 , "Grimoire");
            StdDraw.setFont(Affichage.bold15);
            StdDraw.text(-1500,-900 , "Sorts disponibles : " + player.getMagic());
            StdDraw.text(-1500 , -860 , "Sorts sélectionnés : " + counterSpells);

            //liste des sorts avec les descriptions
            int x = -1200 , y = 800;
            for (int i=0 ; i<12 ; i++){
                StdDraw.setFont(Affichage.bold18);
                StdDraw.textLeft(x,y , tabAlphabet[i] + " " + Spells.getSpellName(i));
                x=1800;
                StdDraw.setFont(Affichage.plain18);
                StdDraw.textRight(x,y, Spells.getSpellDescription(i));
                y-=100;
                x = -1200;
            }

            //Construction du tableau de quantité de sorts actuels
            x = -1800;
            y = -500;
            for (int i=0 ; i<12 ; i++){
                StdDraw.setFont(Affichage.bold15);
                StdDraw.textLeft(x,y , Spells.getSpellName(i));
                StdDraw.setFont(Affichage.plain15);
                y-=40;
                StdDraw.textRight(x,y, Integer.toString(player.getCountSpell(i)));
                y+=40;
                x+=300;
            }

            StdDraw.show();

            while(!StdDraw.hasNextKeyTyped()){continue;} //attendre une touche
            StdDraw.clear();
            switch (StdDraw.nextKeyTyped()){
                case 'a' : player.setSpelltInGrimoire(0,counterSpells); counterSpells++; break;
                case 'b' : player.setSpelltInGrimoire(1,counterSpells); counterSpells++; break;
                case 'c' : player.setSpelltInGrimoire(2,counterSpells); counterSpells++; break;
                case 'd' : player.setSpelltInGrimoire(3,counterSpells); counterSpells++; break;
                case 'e' : player.setSpelltInGrimoire(4,counterSpells); counterSpells++; break;
                case 'f' : player.setSpelltInGrimoire(5,counterSpells); counterSpells++; break;
                case 'g' : player.setSpelltInGrimoire(6,counterSpells); counterSpells++; break;
                case 'h' : player.setSpelltInGrimoire(7,counterSpells); counterSpells++; break;
                case 'i' : player.setSpelltInGrimoire(8,counterSpells); counterSpells++; break;
                case 'j' : player.setSpelltInGrimoire(9,counterSpells); counterSpells++; break;
                case 'k' : player.setSpelltInGrimoire(10,counterSpells); counterSpells++; break;
                case 'l' : player.setSpelltInGrimoire(11,counterSpells); counterSpells++; break;
                case 'w' : {
                    if (counterSpells>0){
                        counterSpells--;
                        player.setSpelltInGrimoire(13,counterSpells);
                    } else {
                        creationPerso(indiceSave);
                    }
                    break;
                }
                default: continue;
            }
        }while(!player.grimoireIsFull());
        StdDraw.clear();
        confirmScreen();
    }

    /**
     * Affiche un écran qui résume les choix précédents et permet de changer seulement les sorts ou tous les rolls
     */
    public static void confirmScreen() throws IOException {
        char inChar;
        Sauvegarde save = new Sauvegarde();

        Affichage.arrowNext();
        Affichage.arrowPrev();

        StdDraw.setFont(Affichage.bold25);
        StdDraw.text(0,1000 , "Résumé");
        StdDraw.setFont(Affichage.plain18);
        StdDraw.textLeft(-1200,800 , "êtes vous satisfait de cette construction ?");

        //Affichage du résumé des sorts
        StdDraw.setFont(Affichage.bold18);
        StdDraw.textLeft(-1200 , 600 , "Sorts");
        StdDraw.setFont(Affichage.plain15);
        int x = -1200 , y = 400;
        for (int i=0 ; i<12 ; i++){
            if(player.getCountSpell(i)>0){
                StdDraw.textLeft(x,y , Spells.getSpellName(i) + " " + player.getCountSpell(i));
                y-=40;
            }
        }

        //Affichage des caractéristiques du personnage
        StdDraw.setFont(Affichage.bold18);
        StdDraw.textRight(1200 , 600 , "Caractéristiques");
        StdDraw.setFont(Affichage.plain15);
        x = 1200 ; y = 400;
        StdDraw.textRight(x,y , "Habilité : " + player.getHability());
        y-=40;
        StdDraw.textRight(x,y, "Endurance : " + player.getVitality());
        y-=40;
        StdDraw.textRight(x,y, "Chance : " + player.getLuck());

        StdDraw.show();

        do {
            while (!StdDraw.hasNextKeyTyped()){continue;}
            inChar = StdDraw.nextKeyTyped();
            switch (inChar){
                case 'x' : {
                    StdDraw.clear();
                    save.createSave(indiceSave);
                    save.newSave(indiceSave,player);
                    new Events(player);
                    Events.intro();
                    break;
                }
                case 'w' : {
                    StdDraw.clear();
                    player.setSpellBook();
                    afficheMakeGrimoire();
                    break;
                }
                default: break;
            }
        } while (inChar != 'x' && inChar!='w');

    }

}

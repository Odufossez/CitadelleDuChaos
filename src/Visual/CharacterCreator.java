package Visual;

import EventsCdC.Events;
import Methods.CharacterCreatorMethods;
import Methods.Player;
import Methods.Sauvegarde;
import Tools.Dice;
import Tools.ReadingInChar;
import Tools.Spells;
import Tools.StdDraw;


import java.io.IOException;

import static Methods.CharacterCreatorMethods.makeGrimoire;
import static Tools.Fonts.*;

public class CharacterCreator {
    public static Player player;
    private static int indiceSave;

    /**
     * Gestion de l'affichage du menu de création de perso
     * @throws IOException
     */
    //TODO potentiellement revoir l'affichage (v1.01)
    public static void creationPerso(int nbSave) throws IOException {
        char inChar;
        indiceSave = nbSave;

        StdDraw.setFont(bold25);
        StdDraw.text(100,1000 , "Création du personnage");


        StdDraw.setFont(plain15);

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


        StdDraw.setFont(bold20);
        StdDraw.text(x,y,"Voulez vous relancer les dés ? (Les valeurs changeront)");
        y-=140;


        StdDraw.text(x,y,"a. Oui, relancer");
        StdDraw.text(x+500,y,"e. Non, continuer");

        StdDraw.show();
        CharacterCreatorMethods.confirmStats(nbSave,playerHab,playerEnd,playerLuck,playerMagic);

    }

    /**
     * Affichage de la fenêtre pour ajouter les sorts au grimoire
     */
    public static void afficheMakeGrimoire(Player player) throws IOException {
        new Affichage();
        new Spells();
        int counterSpells = 0;

        do {
            Affichage.arrowPrev();
            StdDraw.setFont(bold25);
            StdDraw.text(0,1000 , "Grimoire");
            StdDraw.setFont(bold15);
            StdDraw.text(-1500,-800 , "Sorts disponibles : " + player.getMagic());
            StdDraw.text(-1500 , -860 , "Sorts sélectionnés : " + counterSpells);

            //liste des sorts avec les descriptions
            int x = -1200 , y = 800;
            for (int i=0 ; i<12 ; i++){
                StdDraw.setFont(bold18);
                StdDraw.textLeft(x,y , ReadingInChar.tabAlphabet[i] + " " + Spells.getSpellName(i));
                x=1800;
                StdDraw.setFont(plain18);
                StdDraw.textRight(x,y, Spells.getSpellDescription(i));
                y-=100;
                x = -1200;
            }

            //Construction du tableau de quantité de sorts actuels
            x = -1800;
            y = -500;
            for (int i=0 ; i<12 ; i++){
                StdDraw.setFont(bold15);
                StdDraw.textLeft(x,y , Spells.getSpellName(i));
                StdDraw.setFont(plain15);
                y-=40;
                StdDraw.textRight(x,y, Integer.toString(player.getCountSpell(i)));
                y+=40;
                x+=300;
            }

            StdDraw.show();
            makeGrimoire(player);

        }while(!player.grimoireIsFull());
        StdDraw.clear();
        confirmScreen();
    }

    /**
     * Affiche un écran qui résume les choix précédents et permet de changer seulement les sorts ou tous les rolls
     */
    public static void confirmScreen() throws IOException {
        char inChar;

        Affichage.arrowNext();
        Affichage.arrowPrev();

        StdDraw.setFont(bold25);
        StdDraw.text(0,1000 , "Résumé");
        StdDraw.setFont(plain18);
        StdDraw.textLeft(-1200,800 , "Êtes vous satisfait de cette construction ?");

        //Affichage du résumé des sorts
        StdDraw.setFont(bold18);
        StdDraw.textLeft(-1200 , 600 , "Sorts");
        StdDraw.setFont(plain15);
        int x = -1200 , y = 400;
        for (int i=0 ; i<12 ; i++){
            if(player.getCountSpell(i)>0){
                StdDraw.textLeft(x,y , Spells.getSpellName(i) + " " + player.getCountSpell(i));
                y-=40;
            }
        }

        //Affichage des caractéristiques du personnage
        StdDraw.setFont(bold18);
        StdDraw.textRight(1200 , 600 , "Caractéristiques");
        StdDraw.setFont(plain15);
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
                    Sauvegarde.createSave(indiceSave);
                    Sauvegarde.newSave(indiceSave,player);
                    break;
                }
                case 'w' : {
                    StdDraw.clear();
                    player.setSpellBook();
                    afficheMakeGrimoire(player);
                    break;
                }
                default: break;
            }
        } while (true);

    }

}

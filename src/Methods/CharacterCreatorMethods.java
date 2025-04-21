package com.badlogic.citadel.Methods;

import Tools.StdDraw;

import java.io.IOException;

import static Tools.ReadingInChar.RETURN;
import static Tools.ReadingInChar.readChar;
import static Visual.CharacterCreator.*;

public class CharacterCreatorMethods {
    private static char inChar;
    private static int indiceSave;
    private static int counterSpells;

    /**
     * Confirme les statistiques tirées précédemment
     * @param nbSave numéro de sauvegarde
     * @param playerHab habilité du joueur
     * @param playerEnd endurance du joueur
     * @param playerLuck chance du joueur
     * @param playerMagic magie du joueur (nombre de sorts possible)
     * @throws IOException
     */
    public static void confirmStats(int nbSave,int playerHab,int playerEnd,
                                    int playerLuck,int playerMagic) throws IOException {
        indiceSave = nbSave;
        do {
            inChar = readChar();
            switch (inChar){
                case 'a': {
                    StdDraw.clear();
                    creationPerso(nbSave);
                    break; //oui - reroll
                }
                case 'e': { //non - continuer
                    StdDraw.clear();
                    Player player = new Player(playerHab, playerEnd, playerMagic, 0, playerLuck);
                    afficheMakeGrimoire(player);
                    break;
                }
                default: continue;
            }
        }while(true);
    }

    public static void makeGrimoire(Player player) throws IOException {
        inChar = readChar();
        StdDraw.clear();
        switch (inChar){
            case 'a' : {

            }
            case RETURN: {
                if (counterSpells>0){
                    counterSpells--;

                } else {
                    creationPerso(indiceSave);
                }
                break;
            }
            default: break;
        }
    }
}

package Methods;

import Tools.StdDraw;

import java.io.IOException;

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
    public static void confirmStats(int nbSave,int playerHab,int playerEnd,int playerLuck,int playerMagic) throws IOException {
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
            default: break;
        }
    }
}

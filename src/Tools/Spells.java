package Tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static Tools.PathsTo.pathToTableurs;

public class Spells {
    private static String[][] spells;
    private static boolean[][] spellsEvent = new boolean[400][12];

    public Spells() throws FileNotFoundException {
        spells = new String[12][2];

        spells[0][0] = "Chance";
        spells[0][1] = "Augmente les points de chance de la moitié des points de départ sans le dépasser.";

        spells[1][0] = "Copie Conforme";
        spells[1][1] = "Crée un double du monstre que vous affrontez. Ce double aura les mêmes statistiques que " +
                "l'original";

        spells[2][0] = "Endurance";
        spells[2][1] = "Augmente les points de vie de la moitié des points de départ sans le dépasser";

        spells[3][0] = "Faiblesse";
        spells[3][1] = "Réduit les statistiques du monstre adverse";

        spells[4][0] = "Feu";
        spells[4][1] = "Fait apparaître du feu";

        spells[5][0] = "Force";
        spells[5][1] = "Accroit temporairement votre force mais attention au risque de blessures !";

        spells[6][0] = "Habilité";
        spells[6][1] = "Augmente l'habilité de la moitié des points de départ sans la dépasser.";

        spells[7][0] = "Illusion";
        spells[7][1] = "Crée une illusion fort convainquante, il se peut qu'une action rompt le charme";

        spells[8][0] = "Lévitation";
        spells[8][1] = "Elimine toute pesanteur";

        spells[9][0] = "L'or du sot";
        spells[9][1] = "Permet de transformer des cailloux en apparentes pépites d'or";

        spells[10][0] = "Protection";
        spells[10][1] = "Crée une barrière magique qui vous met hors d'atteinte de toute attaque physique";

        spells[11][0] = "Télépathie";
        spells[11][1] = "Permet de lire dans les ondes psychiques d'une créature mais peut être source de confusion " +
                "s'il y a plusieurs sources psychiques à proximité";

        File tabSpell = new File(pathToTableurs + "sorts.csv");
        Scanner scanLine = new Scanner(tabSpell);
        Scanner scanChar;

        while (scanLine.hasNextLine()){
            for (int i = 0; i < 12 ; i++) { //lines
                scanChar = new Scanner(scanLine.nextLine());
                for (int j = 0 ; j <399 ; j++){
                    if (scanChar.hasNextInt()){
                        if(scanChar.nextInt() == 1){
                            spellsEvent[j][i] = true;
                        } else {
                            spellsEvent[j][i] = false;
                        }
                    } else {
                        scanChar.next();
                    }
                }
            }
        }
    }

    public static String getSpellName(int spell){
        return spells[spell][0];
    }

    public static String getSpellDescription(int spell){
        return spells[spell][1];
    }

    public static void tabAffiche(){
        for (int i = 0; i < spellsEvent.length; i++) {
            for (int j = 0; j < spellsEvent[i].length; j++) {
                System.out.print(spellsEvent[i][j]);
            }
            System.out.println();
        }
    }


    public static boolean getSpellInEvent(int event, int spell){
        return spellsEvent[event-1][spell];
    }

    public static boolean eventHasSpell(int event){
        for (int i = 0; i < 12; i++) {
            if (spellsEvent[event-1][i]){
                return true;
            }
        }
        return false;
    }
}

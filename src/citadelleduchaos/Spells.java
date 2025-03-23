package citadelleduchaos;

public class Spells {
    private static String[][] spells;

    public Spells(){
        spells = new String[12][3];

        spells[0][0] = "1";
        spells[0][1] = "Chance";
        spells[0][2] = "Augmente les points de chance de la moitié des points de départ sans le dépasser.";

        spells[1][0] = "2";
        spells[1][1] = "Copie Conforme";
        spells[1][2] = "Crée un double du monstre que vous affrontez. Ce double aura les mêmes statistiques que " +
                "l'original";

        spells[2][0] = "3";
        spells[2][1] = "Endurance";
        spells[2][2] = "Augmente les points de vie de la moitié des points de départ sans le dépasser";

        spells[3][0] = "4";
        spells[3][1] = "Faiblesse";
        spells[3][2] = "Réduit les statistiques du monstre adverse";

        spells[4][0] = "5";
        spells[4][1] = "Feu";
        spells[4][2] = "Fait apparaître du feu";

        spells[5][0] = "6";
        spells[5][1] = "Force";
        spells[5][2] = "Accroit temporairement votre force mais attention au risque de blessures !";

        spells[6][0] = "7";
        spells[6][1] = "Habilité";
        spells[6][2] = "Augmente l'habilité de la moitié des points de départ sans la dépasser.";

        spells[7][0] = "8";
        spells[7][1] = "Illusion";
        spells[7][2] = "Crée une illusion fort convainquante, il se peut qu'une action rompt le charme";

        spells[8][0] = "9";
        spells[8][1] = "Lévitation";
        spells[8][2] = "Elimine toute pesanteur";

        spells[9][0] = "10";
        spells[9][1] = "L'or du sot";
        spells[9][2] = "Permet de transformer des cailloux en apparentes pépites d'or";

        spells[10][0] = "11";
        spells[10][1] = "Protection";
        spells[10][2] = "Crée une barrière magique qui vous met hors d'atteinte de toute attaque physique";

        spells[11][0] = "12";
        spells[11][1] = "Télépathie";
        spells[11][2] = "Permet de lire dans les ondes psychiques d'une créature mais peut être source de confusion " +
                "s'il y a plusieurs sources psychiques à proximité";
    }

    public static String getSpellName(int spell){
        return spells[spell][1];
    }

    public static String getSpellDescription(int spell){
        return spells[spell][2];
    }
}

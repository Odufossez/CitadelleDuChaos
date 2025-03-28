package Tools;

public class Stuff {
    private static String stuff[][] = new String[15][2];

    public Stuff(){
        stuff[0][0] = "Dague enchantée";        stuff[0][1] = "Inflige 2 dégâts automatique, est détruit après utilisation";
        stuff[1][0] = "Onguent noir";           stuff[1][1] = "Deux utilisations de magie gratuites";
        stuff[2][0] = "Brosse à cheveux";       stuff[2][1] = "Une brosse à cheveux rafinée";
        stuff[3][0] = "Essence de berce";       stuff[3][1] = "Repousse les créatures de pierre";
        stuff[4][0] = "Epée +1";                stuff[4][1] = "+1 en force d'attaque";
        stuff[5][0] = "Epée +2";                stuff[5][1] = "+2 en force d'attaque";
        stuff[6][0] = "Epée basique";           stuff[6][1] = "+0 en force d'attaque";
        stuff[7][0] = "Bocal Homme-Araignée";   stuff[7][1] = "Un bocal avec une araignée au visage humain";
        stuff[8][0] = "Liquide vert";           stuff[8][1] = "";
    }

    public static String getStuffName(int indObj){
        return stuff[indObj][0];
    }

    public static String getStuffDescription(int indObj){
        return stuff[indObj][1];
    }
}

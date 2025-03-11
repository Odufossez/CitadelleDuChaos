public class Player {
    public String pseudo;
    public int hability;
    public int  vitality;
    public int magic;
    public int gold;
    public int luck;

    public String[] inventory;

    public void setNewPlayer(String n_pseudo , int  p_hability, int p_vitality, int p_magic, int p_gold , int p_luck){
        pseudo = n_pseudo;
        hability = p_hability;
        vitality = p_vitality;
        magic = p_magic;
        gold = 0;
        luck = p_luck;
    }

    public int[] setSpells(int magic){
        int[] spells = new int[magic];

        //remplir le grimoire avec la colonne [n][0]

        return spells;
    }

    public String toString(){
        return "Nom: " + pseudo + " -hability : " + hability + " -vitality: " + vitality + " -luck: " + luck + " -magic: " + magic;
    }



}

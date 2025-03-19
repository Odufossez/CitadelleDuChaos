public class Player {
    private String pseudo;
    private int hability;
    private int currentHab;
    private int  vitality;
    private int  currentVit;
    private int magic;
    private int gold;
    private int luck;
    private int[] spells;

    private String[] inventory;

    public void setNewPlayer(String n_pseudo , int  p_hability, int p_vitality, int p_magic, int p_gold , int p_luck){
        pseudo = n_pseudo;
        hability = p_hability;
        vitality = p_vitality;
        magic = p_magic;
        gold = 0;
        luck = p_luck;
        spells = new int[magic];
    }

    public int getCurrentVitality(){
        return currentVit;
    }
    public int getVitality(){
        return vitality;
    }
    public void setCurrentVitality(int vit){
        currentVit = vit;
    }
    public void setVitality(int vitality) {this.vitality = vitality;}

    public int getMagic(){
        return magic;
    }
    public void setMagic(int magic) {this.magic = magic;}

    public  int getGold(){return  gold;}

    public int  getCurrentHab(){
        return currentHab;
    }
    public int getHability(){return  hability;}
    public void setHability(int hability) {this.hability = hability;}

    public int[] setSpells(){
        //remplir le grimoire avec la colonne [n][0]

        return spells;
    }
    public int[] getSpells(){return spells;}

    public String getPseudo(){
        return pseudo;
    }

    public String[] getInventory(){
        return inventory;
    }

    public String toString(){
        return "Nom: " + pseudo + " -hability : " + hability + " -vitality: " + vitality + " -luck: " + luck + " -magic: " + magic;
    }



}

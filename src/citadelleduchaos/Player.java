package citadelleduchaos;

import java.util.ArrayList;

public class Player {
    private static String pseudo; //TODO V1.1
    private static int hability;
    private static int currentHab;
    private static int vitality;
    private static int currentVit;
    private static int magic;
    private static int gold;
    private static int luck;
    private static int[] spellBook;
    static private int currentEvent;

    private static ArrayList<Integer> inventory = new ArrayList<Integer>() ;

    /**
     * Method that returns a Player with the caracteristics that were passed on parameters
     * @param p_hability
     * @param p_vitality
     * @param p_magic : settles the lenght of the magic book
     * @param p_gold
     * @param p_luck
     * @return a Player
     */
    public Player setNewPlayer(int p_hability, int p_vitality, int p_magic, int p_gold, int p_luck){

        this.hability = p_hability;
        this.vitality = p_vitality;
        this.magic = p_magic;
        this.gold = 0;
        this.luck = p_luck;

        return this;
    }

    public void setCurrentEvent(int p_event){this.currentEvent = p_event;}
    public int getCurrentEvent(){return this.currentEvent;}

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

    public int getLuck(){ return luck; }
    public void setLuck(int luck) {this.luck = luck;}
    public void decreaseLuck(){this.luck--;}

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

    public String getPseudo(){
        return pseudo;
    }

    //todo à réformat pour mettre des int -> copier le modèle sur les sorts

    /**
     * Renvoie les indices des objets mis en inventaire. Il faut la combiner avec la méthode Stuff.getStuffName(indice)
     * @return une liste de int représentant les indices des objets dans l'inventaire
     */
    public ArrayList<Integer> getInventory(){
        return inventory;
    }
    public void setInventory(int indiceObjet) { inventory.add(indiceObjet);}
    /**
     * Savoir si l'objet recherché est dans l'inventaire
     * @param indiceObjet que l'on cherche
     * @return vrai si trouvé sinon faux
     */
    public boolean isInventory(int indiceObjet){
        return inventory.contains(indiceObjet);
    }

    /**
     * Renvoie les indices des sorts qui ont été choisi. Il faut la combiner avec la méthode Spells.getSpellName(indice)
     * @return un grimoire d'indice
     */
    public void setSpellBook(){
        this.spellBook = new int[magic];
        for (int i=0;i<magic;i++){
            spellBook[i] = 13;
        }
    }
    public int[] getSpells(){
        return this.spellBook;
    }
    public boolean grimoireIsFull(){
        for (int i = 0 ; i<this.getMagic() ; i++){
            if (spellBook[i]==13) return false;
        }
        return true;
    }

    /**
     * Savoir si un sort est dans le grimoire
     * @param sort : indice du sort que l'on cherche
     * @return true si le sort est trouvé, false sinon
     */
    public boolean isInSpellBook(int sort){
        for (int i = 0 ; i<this.getMagic() ; i++){
            if (spellBook[i]==sort) return true;
        }
        return false;
    }

    /**
     * Compte le nombre de fois qu'un sort donné est présent dans le grimoire
     * @param index l'indice du sort à compter
     * @return le compte du sort index
     */
    public int getCountSpell(int index){
        int count = 0;
        for(int i=0 ; i<this.getMagic() ; i++){
            if(spellBook[i]==index) count++;
        }
        return count;
    }

    /**
     * Put the spell's index into the grimoire's index placed into parameters
     * @param sort
     * @param index
     */
    public void setSpelltInGrimoire(int sort , int index){
        this.spellBook[index]=sort;
    }





    public String toString(){
        return "Nom: " + pseudo + " -hability : " + hability + " -vitality: " + vitality + " -luck: " + luck + " -magic: " + magic;
    }



}

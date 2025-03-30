package Methods;
import java.util.ArrayList;

public class Player {
    private  String pseudo; //TODO V1.1
    private  int hability;
    private  int currentHab;
    private  int vitality;
    private  int currentVit;
    private  int magic;
    private  int gold;
    private  int luck;
    private  int[] spellBook;
    private  int currentEvent;
    private  int indiceSave;

    private ArrayList<Integer> inventory = new ArrayList<Integer>() ;

    /**
     * Constructor
     */
    public Player(){}

    /**
     * Method that returns a Player with the caracteristics that were passed on parameters
     * @param p_hability
     * @param p_vitality
     * @param p_magic : settles the lenght of the magic book
     * @param p_gold
     * @param p_luck
     * @return a Player
     */
    public Player(int p_hability, int p_vitality, int p_magic, int p_gold, int p_luck){

        setHability(p_hability);
        setVitality(p_vitality);
        magic = p_magic;
        setSpellBook();
        gold = p_gold;
        luck = p_luck;
    }

    /**
     * Méthode qui permet d'attribuer l'indice de save au joueur
     * @param indiceSave un entier représentant l'indice la sauvegarde du joueur
     */
    public void setIndiceSave(int indiceSave){
        this.indiceSave = indiceSave;}

    /**
     * Renvoie l'indice de la sauvegarde associée au joueur
     * @return un entier
     */
    public int getIndiceSave(){
        return indiceSave;
    }

    /**
     * Attribue le numéro d'event en cours au joueur
     * @param p_event un entier représentant l'event en cours
     */
    public void setCurrentEvent(int p_event){this.currentEvent = p_event;}

    /**
     * Renvoie le numéro de l'event associé au joueur
     * @return
     */
    public int getCurrentEvent(){return this.currentEvent;}

    /**
     * renvoie la valeur de la vitalité actuelle
     * @return un entier compris entre 0 et vitality (max)
     */
    public int getCurrentVitality(){
        return currentVit;
    }

    /**
     * Renvoie la valeur de la vitalité max
     * @return un entier
     */
    public int getVitality(){
        return vitality;
    }

    /**
     * Mets la valeur de vitalité à jour
     * @param vit la nouvelle valeur de la vitalité
     */
    public void setCurrentVitality(int vit){
        currentVit = vit;
    }

    /**
     * Mets la valeur de vitalité max à jour
     * @param vitality
     */
    public void setVitality(int vitality) {
        this.vitality = vitality;
        currentVit = vitality;
    }

    /**
     * Renvoie si le joueur est mort ou non
     * @return true si le joueur est mort
     */
    public boolean isDead(){
        return this.getCurrentVitality() <= 0;
    }

    public int getLuck(){ return luck; }
    public void setLuck(int luck) {this.luck = luck;}
    public void decreaseLuck(){this.luck--;}

    public int getMagic(){
        return magic;
    }
    public void setMagic(int magic) {this.magic = magic;}

    public void setGold(int gold) {this.gold = gold;}
    public  int getGold(){return  gold;}

    /**
     * Les méthodes liées à l'habilité
     * @return l'habilité actuelle
     */
    public int  getCurrentHab(){
        return currentHab;
    }
    public void setCurrentHab(int currentHab){
        this.currentHab = currentHab;
    }
    public int getHability(){return  hability;}
    public void setHability(int hability) {
        this.hability = hability;
        currentHab = hability;
    }

    public String getPseudo(){
        return pseudo;
    }

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
    public boolean isInInventory(int indiceObjet){
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

    /**
     * Renvoie la totalité du grimoire du joueur
     * @return un tableau de int représentant les indices de spells mis en grimoire
     */
    public int[] getSpells(){
        return this.spellBook;
    }

    /**
     * renvoie si le grimoire est complet ou non
     * @return true si le grimoire est complet sinon false
     */
    public boolean grimoireIsFull(){
        for (int i = 0 ; i<this.getMagic() ; i++){
            if (spellBook[i]==13) return false;
        }
        return true;
    }

    /**
     * Savoir si un sort est dans le grimoire
     * @param sort  indice du sort que l'on cherche
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
     * @param sort index du sort
     * @param index index à lequel le mettre
     */
    public void setSpelltInGrimoire(int sort , int index){
        spellBook[index]=sort;
    }

    /**
     * Fonction qui permet de diminuer les PV du joueur en combat
     *  !! Ne vérifie pas si le joueur est mort après le coup !!
     */
    public void isTouchedInCombat(){
        int curVit = this.getCurrentVitality();
        this.setCurrentVitality(curVit-2);
    }

    /**
     * Transforme les caractéristiques du joueur en String lisible
     * @return la liste des informations joueur
     */
    public String toString(){
        return "Nom: " + pseudo + " -hability : " + hability + " -vitality: " + vitality + " -luck: " + luck +
                " -magic: " + magic;
    }
}

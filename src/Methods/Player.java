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
    private  int currentLuck;
    private  SpellBook grimoire;
    private  int currentEvent;
    private  int indiceSave;
    private boolean isInCombat;
    private Combat combat;
    private Inventory inventaire;

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
     */
    public Player(int p_hability, int p_vitality, int p_magic, int p_gold, int p_luck){

        setHability(p_hability);
        setVitality(p_vitality);
        magic = p_magic;
        grimoire = new SpellBook(magic);
        gold = p_gold;
        setLuck(p_luck);
        setIsInCombat(false);
    }

    public SpellBook getGrimoire() {
        return grimoire;
    }

    public Inventory getInventory() {
        return inventaire;
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
    public void setLuck(int luck) {
        this.luck = luck;
        currentLuck = luck;
    }
    public void decreaseLuck(){this.currentLuck--;}
    public void setCurrentLuck(int luck){
        currentLuck=luck;
    }
    public int getCurrentLuck(){
        return currentLuck;
    }

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
     * Fonction qui permet de diminuer les PV du joueur en combat
     *  !! Ne vérifie pas si le joueur est mort après le coup !!
     */
    public void isTouchedInCombat(){
        int curVit = this.getCurrentVitality();
        this.setCurrentVitality(curVit-2);
    }

    public boolean getIsInCombat(){
        return isInCombat;
    }
    public void setIsInCombat(boolean state, Combat cmb){
        this.isInCombat = state;
        this.combat = cmb;
    }
    public void setIsInCombat(boolean state){
        this.isInCombat = state;
    }
    public Combat getCombat(){
        return combat;
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

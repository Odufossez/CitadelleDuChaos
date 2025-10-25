package com.badlogic.citadel.PlayerRelatedMethods;

import com.badlogic.citadel.Item;

public class Player {
    private  String pseudo; //TODO V1.1
    private  int ability;
    private  int currentAbility;
    private  int vitality;
    private  int currentVit;
    private  int magic;
    private int currentMagic;
    private  int gold;
    private  int luck;
    private  int currentLuck;
    private  SpellBook grimoire;
    private  int currentEvent;
    private  int indiceSave;
    private boolean isInCombat;
    private Inventory inventaire;

    /**
     * Constructor
     */
    public Player(){}

    /**
     * Method that constructs a Player with the characteristics that were passed on parameters
     * @param p_hability  the ability of the player
     * @param p_vitality the vitality of the player
     * @param p_magic  settles the length of the magic book
     * @param p_gold  the gold of the player
     * @param p_luck  the luck of the player
     */
    public Player(int p_hability, int p_vitality, int p_magic, int p_gold, int p_luck){
        //Init caractéristiques
        magic = p_magic;
        currentMagic = magic;
        ability = p_hability;
        currentAbility = ability;
        vitality = p_vitality;
        currentVit = vitality;
        luck = p_luck;
        currentLuck = luck;

        //Init grimoire et inventaire
        grimoire = new SpellBook(magic);
        gold = p_gold;
        inventaire = new Inventory();
        inventaire.putIn(Item.Items.GRASS); //item par défaut dans l'inventaire

        //In combat
        setIsInCombat(false);

    }

    /**
     * Init the player with the current stats passed on parameters
     * @param currentVit
     * @param currentHab
     * @param currentMagic
     * @param currentLuck
     * @param gold
     */
    public void initCurrent(int currentVit, int currentHab , int currentMagic, int currentLuck ,int gold){
        this.currentMagic = currentMagic;
        this.gold = gold;
        this.currentLuck = currentLuck;
        this.currentAbility = currentHab;
        this.currentVit = currentVit;
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
    public int getCurrentMagic(){
        return currentMagic;
    }
    public void setCurrentMagic(int magic){
        currentMagic = magic;
    }

    public void setGold(int gold) {this.gold = gold;}
    public  int getGold(){return  gold;}

    /**
     * Les méthodes liées à l'habilité
     * @return l'habilité actuelle
     */
    public int getCurrentAbility(){
        return currentAbility;
    }
    public void setCurrentAbility(int currentAbility){
        this.currentAbility = currentAbility;
    }
    public int getAbility(){return ability;}
    public void setAbility(int ability) {
        this.ability = ability;
        currentAbility = ability;
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

    public void setIsInCombat(boolean state){
        this.isInCombat = state;
    }




    /**
     * Transforme les caractéristiques du joueur en String lisible
     * @return la liste des informations joueur
     */
    public String toString(){
        return "Nom: " + pseudo + " -hability : " + ability + " -vitality: " + vitality + " -luck: " + luck +
                " -magic: " + magic;
    }


}

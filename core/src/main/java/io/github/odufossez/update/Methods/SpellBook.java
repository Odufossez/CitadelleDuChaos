package Methods;

import Spells.SpellList;

import static Tools.OutilsSorts.spellsEvent;

public class SpellBook {
    public int length;
    private SpellList.Sorts[] grimoire;

    public SpellBook(int magic){
        grimoire = new SpellList.Sorts[magic];
        length = grimoire.length;
    }

    /**
     * Rajoute le sort au premier emplacement disponible
     * @param s le sort à ajouter
     */
    public void putIn(SpellList.Sorts s){
        for (int i = 0; i < grimoire.length; i++) {
            if (grimoire[i] == null) {
                grimoire[i] = s;
            }
        }
    }

    /**
     * Renvoie le grimoire
     * @return un tableau de sort
     */
    public SpellList.Sorts[] getGrimoire(){
        return grimoire;
    }

    /**
     * Retire du grimoire le sort passer en paramètre
     * @param s
     */
    public void removeFrom(SpellList.Sorts s){
        for (int i = 0; i < grimoire.length; i++) {
            if (grimoire[i] == s) {
                grimoire[i] = null;
                return;
            }
        }
    }

    /**
     * renvoie si le grimoire est complet ou non
     * @return true si le grimoire est complet sinon false
     */
    public boolean grimoireIsFull(){
        for (int i = 0 ; i< grimoire.length; i++){
            if (grimoire[i]==null) return false;
        }
        return true;
    }

    /**
     * Savoir si un sort est dans le grimoire
     * @param s  sort que l'on cherche
     * @return true si le sort est trouvé, false sinon
     */
    public boolean isInGrimoire(SpellList.Sorts s){
        for (int i = 0 ; i< grimoire.length ; i++){
            if (grimoire[i]==s) return true;
        }
        return false;
    }

    /**
     * Compte le nombre de fois qu'un sort donné est présent dans le grimoire
     * @param s sort à compter
     * @return le compte du sort
     */
    public int getCountSpell(SpellList.Sorts s){
        int count = 0;
        for(int i=0 ; i< grimoire.length ; i++){
            if(grimoire[i]==s) count++;
        }
        return count;
    }

    public SpellList.Sorts getSpell(int i){
        return grimoire[i];
    }



}

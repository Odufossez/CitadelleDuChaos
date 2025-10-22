package com.badlogic.citadel.Methods;

public class Monster {
    private String name;
    private int ability;
    private int vitality;

    public Monster(String name, int a, int v) {
        this.name = name;
        this.ability = a;
        this.vitality = v;
    }

    public void setName(String n_name) {
        name = n_name;
    }
    public String getName() {
        return name;
    }

    public void setHability(int n_a) {
        ability = n_a;
    }
    public void setVitality(int n_v) {
        vitality = n_v;
    }

    public int getAbility() {
        return ability;
    }
    public int getVitality() {
        return vitality;
    }


    public void isTouchedInCombat() {
        int curVit = this.getVitality();
        setVitality(curVit - 2);
    }

    /**
     *
     * @return true si le monstre est mort
     */
    public boolean isDead(){
        return getVitality() <= 0;
    }

    public String toString(){
        return "Monster : " + name + " hab= " + ability + " vital=" + vitality;
    }

}

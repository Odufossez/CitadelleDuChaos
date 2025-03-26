package citadelleduchaos;

public class Monster {
    private String name;
    private int habiliy;
    private int vitality;

    public Monster() {}

    public void setName(String n_name) {
        name = n_name;
    }

    public void setHability(int n_h) {
        habiliy = n_h;
    }

    public void setVitality(int n_v) {
        vitality = n_v;
    }

    public int getHability() {
        return habiliy;
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
        return "Monster : " + name + " hab= " + habiliy + " vital=" + vitality;
    }

}

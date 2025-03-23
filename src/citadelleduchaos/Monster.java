package citadelleduchaos;

public class Monster {
    private String name;
    private int habiliy;
    private int vitality;

    public Monster(int habiliy, int vitality) {
        this.habiliy = habiliy;
        this.vitality = vitality;
    }

    public void setName(String n_name) {
        name = n_name;
    }

    public void setHabiliy(int n_h) {
        habiliy = n_h;
    }

    public void setVitality(int n_v) {
        vitality = n_v;
    }

    public int getHabiliy() {
        return habiliy;
    }

    public int getVitality() {
        return vitality;
    }

    public boolean checkVitality(){
        return getVitality() > 0;
    }

    public String toString(){
        return "Monster : " + name + " hab= " + habiliy + " vital=" + vitality;
    }

}

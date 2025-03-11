public class Monster {
    public String name;
    public int habiliy;
    public int vitality;

    public void setName(String n_name) {
        name = n_name;
    }

    public void setHabiliy(int n_h) {
        habiliy = n_h;
    }

    public void setVitality(int n_v) {
        vitality = n_v;
    }

    public String toString(){
        return "Monster : " + name + " hab= " + habiliy + " vital=" + vitality;
    }

}

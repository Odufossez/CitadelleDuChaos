package Items;

public class AmuletteEnsorcelee extends Item{

    AmuletteEnsorcelee(String name, String description, int numero, LabelItem label) {
        super(name, description, numero , label);
        tabEvent = new int[]{322};
        super.setEtat(true);
    }
}

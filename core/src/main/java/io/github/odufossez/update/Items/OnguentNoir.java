package Items;

public class OnguentNoir extends Item {

    private final int[] utilisations = {1,2,3,4}; //todo exemple à changer

    OnguentNoir(String name, String description, int numero) {
        super(name, description, numero);
    }

    public int[] getUtilisations() {
        return utilisations;
    }
}

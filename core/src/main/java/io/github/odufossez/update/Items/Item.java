package Items;

public class Item {
    protected String name;
    protected String description;
    protected int numero;
    protected boolean isDansInventaire;
    protected LabelItem label;
    protected static int[] tabEvent;

    public enum LabelItem {
        DAGUE_ENCHANTEE,
        ONGUENT_NOIR,
        BROSSE_A_CHEVEUX,
        ESSENCE_BERCE,
        EPEE,
        BOCAL_HOMME_ARAIGNEE,
        MYRIADE,
        POIGNEE_BAIES,
        MIROIR_ARGENT,
        CLE_CUIVRE,
        TOISON_OR,
        AMULETTE_ENSORCELEE
    }
    
    Item(String name, String description, int numero , LabelItem label) {
        this.name = name;
        this.description = description;
        this.numero = numero;
        this.isDansInventaire = false;
        this.label = label;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getNumero() {
        return numero;
    }

    public void setEtat(boolean etat) {
        isDansInventaire = etat;
    }

    public boolean isDansInventaire() {
        return isDansInventaire;
    }

    public String toString() {
        return name;
    }

    public static int[] getTabEvent(){
        return tabEvent;
    }

    public LabelItem getLabel(){
        return label;
    }
}

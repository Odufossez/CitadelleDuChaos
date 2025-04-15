package Items;

public class DagueEnchantee extends Item{

    DagueEnchantee(String name, String description,int numero) {
        super(name, description,numero , LabelItem.DAGUE_ENCHANTEE);
        tabEvent = new int[]{};
    }
}

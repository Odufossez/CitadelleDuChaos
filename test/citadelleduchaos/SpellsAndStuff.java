import Tools.Spells;
import Tools.Stuff;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SpellsAndStuff {

    @Test
    public void testGetSpellName(){
        new Spells();
        Assertions.assertEquals("Chance" , Spells.getSpellName(0));
    }

     @Test
    public void testGetSpellDescription(){
        new Spells();
        Assertions.assertEquals("Augmente les points de chance de la moitié des points de départ sans le dépasser.", Spells.getSpellDescription(0));
    }

    @Test
    public void testGetStuffName(){
        new Stuff();
        Assertions.assertEquals("Dague enchantée" , Stuff.getStuffName(0));
    }

    @Test
    public void testGetStuffDescription(){
        new Stuff();
        Assertions.assertEquals("Inflige 2 dégâts automatique, est détruit après utilisation" , Stuff.getStuffDescription(0));
    }
}

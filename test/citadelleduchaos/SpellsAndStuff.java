import Tools.OutilsSorts;
import Items.Stuff;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;

import static Tools.OutilsSorts.eventHasSpell;

public class SpellsAndStuff {

    @Test
    public void testGetSpellName() throws FileNotFoundException {
        new OutilsSorts();
        Assertions.assertEquals("Chance" , OutilsSorts.getSpellName(0));
    }

     @Test
    public void testGetSpellDescription() throws FileNotFoundException {
        new OutilsSorts();
        Assertions.assertEquals("Augmente les points de chance de la moitié des points de départ sans le dépasser.", OutilsSorts.getSpellDescription(0));
    }

    @Test
    public void testGetStuffName() throws FileNotFoundException {
        new Stuff();
        Assertions.assertEquals("Dague enchantée" , Stuff.getStuffName(0));
    }

    @Test
    public void testGetStuffDescription() throws FileNotFoundException {
        new Stuff();
        Assertions.assertEquals("Inflige 2 dégâts automatique, est détruit après utilisation" , Stuff.getStuffDescription(0));
    }

    @Test
    public void getSpellInEvent() throws FileNotFoundException {
        new OutilsSorts();
        Assertions.assertTrue(eventHasSpell(11));
        Assertions.assertFalse(eventHasSpell(12));

        Assertions.assertTrue(OutilsSorts.getSpellInEvent(11,9));
        Assertions.assertFalse(OutilsSorts.getSpellInEvent(11,4));
    }
}

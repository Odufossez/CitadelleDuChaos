import Methods.Player;
import Tools.Spells;
import Tools.Stuff;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PlayerUnitTest {
    Player ply = new Player();

    @Test
    public void testGrimoireIsFull(){
        ply.setMagic(2);
        ply.setSpellBook();
        ply.setSpelltInGrimoire(0,0);
        ply.setSpelltInGrimoire(13,1);
        Assertions.assertFalse(ply.grimoireIsFull());
        ply.setSpelltInGrimoire(2,1);
        Assertions.assertTrue(ply.grimoireIsFull());
    }

    @Test
    public void testIsInInventory(){
        new Stuff();
        ply.setInventory(0);
        ply.setInventory(1);
        Assertions.assertFalse(ply.isInInventory(2));
        Assertions.assertTrue(ply.isInInventory(1));
    }

    @Test
    public void testIsInSpellBook(){
        new Spells();
        ply.setMagic(2);
        ply.setSpellBook();
        ply.setSpelltInGrimoire(0,0);
        ply.setSpelltInGrimoire(1,1);
        Assertions.assertFalse(ply.isInSpellBook(2));
        Assertions.assertTrue(ply.isInSpellBook(1));
    }

    @Test
    public void testGetCountSpell(){
        new Spells();
        ply.setMagic(3);
        ply.setSpellBook();
        ply.setSpelltInGrimoire(0,0);
        ply.setSpelltInGrimoire(1,1);
        ply.setSpelltInGrimoire(1,2);
        Assertions.assertEquals(2,ply.getCountSpell(1));
    }

    @Test
    public void testDecreaseLuck(){
        ply.setLuck(2);
        Assertions.assertEquals(2,ply.getLuck());
        ply.decreaseLuck();
        Assertions.assertEquals(1,ply.getLuck());
    }

    @Test
    public void testIsTouchedInCombat(){
        ply.setVitality(4);
        Assertions.assertEquals(4,ply.getCurrentVitality());
        ply.isTouchedInCombat();
        Assertions.assertEquals(2,ply.getCurrentVitality());
    }

    @Test
    public void testSetVitality(){
        ply.setVitality(2);
        Assertions.assertEquals(2,ply.getVitality());
        Assertions.assertEquals(2,ply.getCurrentVitality());
    }

    @Test
    public void testIsDead(){
        ply.setCurrentVitality(1);
        Assertions.assertFalse(ply.isDead());
        ply.setCurrentVitality(0);
        Assertions.assertTrue(ply.isDead());
    }
}
